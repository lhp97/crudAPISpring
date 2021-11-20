package br.com.nutri.app.api.controller;

import br.com.nutri.app.api.model.Aluno;
import br.com.nutri.app.api.service.AlunoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/all")
    public List<Aluno> listaAlunos() {
        val alunos = alunoService.listaAlunosService();
        return alunos;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> pegaAluno(@PathVariable Integer id) {
        val aluno = alunoService.pegaAluno(id);
        return ResponseEntity.ok().body(aluno);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insereAluno(@RequestBody Aluno aluno) {
        alunoService.insereAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}").buildAndExpand(aluno.getIdAluno()).toUri();

        return ResponseEntity.created(uri).build();
    }

}
