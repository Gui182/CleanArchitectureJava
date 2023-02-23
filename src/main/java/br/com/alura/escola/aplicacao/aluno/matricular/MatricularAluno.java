package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.PublicadoDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {
    
    private final RepositorioDeAlunos repositorios;
    private final PublicadoDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorios, PublicadoDeEventos publicador) {
        this.repositorios = repositorios;
        this.publicador = publicador;
    }

    public void matricular(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        repositorios.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicador.publicar(evento);
    }
}
