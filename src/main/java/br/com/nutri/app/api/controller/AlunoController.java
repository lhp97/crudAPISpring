package br.com.nutri.app.api.controller;

import br.com.nutri.app.api.model.Aluno;
import br.com.nutri.app.api.service.AlunoService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public Aluno pegaAluno(@RequestParam(value="id") Integer idAluno) {
        val id = idAluno;
        val aluno = alunoService.pegaAluno(id);
        return aluno;

    }

}
