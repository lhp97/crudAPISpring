package br.com.nutri.app.api.repository;

import br.com.nutri.app.api.model.Aluno;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlunoMapper {

    void insereAluno(Aluno param);

    List<Aluno> listaAlunos();

    Aluno pegaAluno(Integer param);

}
