package br.com.nutri.app.api.service;

import br.com.nutri.app.api.model.Aluno;
import br.com.nutri.app.api.repository.AlunoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoMapper alunoMapper;

    public void insereAluno(Aluno aluno) {
        alunoMapper.insereAluno(aluno);
    }

    public List<Aluno> listaAlunosService() {
        return alunoMapper.listaAlunos();
    }

    public Aluno pegaAluno(Integer idAluno) {
        return alunoMapper.pegaAluno(idAluno);
    }

}
