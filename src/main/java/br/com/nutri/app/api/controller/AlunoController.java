package br.com.nutri.app.api.controller;

import br.com.nutri.app.api.model.Aluno;
import br.com.nutri.app.api.response.AlunosResponse;
import br.com.nutri.app.api.service.AlunoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/all")
    public AlunosResponse listaAlunos() {
        val alunos = alunoService.listaAlunosService();
        val alunosResponse = new AlunosResponse();
        alunosResponse.setAlunos(alunos);
        alunosResponse.setQtdAlunos(alunos.size());
        return alunosResponse;
    }

    @RequestMapping(value = "/{idAluno}", method = RequestMethod.GET)
    public ResponseEntity<?> pegaAluno(@PathVariable Integer idAluno) {
        val aluno = alunoService.pegaAluno(idAluno);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insereAluno(@RequestBody Aluno aluno) {
        alunoService.insereAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/idAluno}").buildAndExpand(aluno.getIdAluno()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{idAluno}", method = RequestMethod.PUT)
    public ResponseEntity<Void> atualizaAluno(@RequestBody Aluno aluno, @PathVariable Integer idAluno) {
        aluno.setIdAluno(idAluno);
        alunoService.atualizaAluno(aluno);

        return ResponseEntity.noContent().build();
    }

}
