package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    
    private final RepositorioDeAlunos repositorios;

    public MatricularAluno(RepositorioDeAlunos repositorios) {
        this.repositorios = repositorios;
    }

    public void matricular(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorios.matricular(novo);
    }
}
