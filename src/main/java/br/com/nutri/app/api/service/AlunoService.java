package br.com.nutri.app.api.service;

import br.com.nutri.app.api.model.Aluno;
import br.com.nutri.app.api.repository.AlunoMapper;
import lombok.val;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoMapper alunoMapper;

    public void insereAluno(Aluno aluno) {
        Assert.assertNotNull(aluno);
        aluno.setIdAluno(null);

        alunoMapper.insereAluno(aluno);
    }

    public void atualizaAluno(Aluno aluno) {
        Assert.assertNotNull(aluno);
        Assert.assertNotNull(aluno.getIdAluno());

        val alunoTmp = alunoMapper.pegaAluno(aluno.getIdAluno());
        Assert.assertNotNull(alunoTmp);

        alunoTmp.setNomeAluno(aluno.getNomeAluno());
        alunoTmp.setIdadeAluno(aluno.getIdadeAluno());
        alunoTmp.setSexoAluno(aluno.getSexoAluno());
        alunoTmp.setCpfAluno(aluno.getCpfAluno());
        alunoTmp.setRgAluno(aluno.getRgAluno());

        alunoMapper.atualizaAluno(alunoTmp);

    }

    public List<Aluno> listaAlunosService() {
        return alunoMapper.listaAlunos();
    }

    public Aluno pegaAluno(Integer idAluno) {
        return alunoMapper.pegaAluno(idAluno);
    }

}
