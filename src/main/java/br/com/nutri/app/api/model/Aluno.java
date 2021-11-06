package br.com.nutri.app.api.model;

import lombok.Data;

@Data
public class Aluno {

    private Integer idAluno;
    private String nomeAluno;
    private Integer idadeAluno;
    private String sexoAluno;
    private String rgAluno;
    private String cpfAluno;
}
