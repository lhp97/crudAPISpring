package br.com.nutri.app.api.response;

import br.com.nutri.app.api.model.Aluno;
import lombok.Data;

import java.util.List;

@Data
public class AlunosResponse {

    private Integer qtdAlunos;
    private List<Aluno> alunos;

}
