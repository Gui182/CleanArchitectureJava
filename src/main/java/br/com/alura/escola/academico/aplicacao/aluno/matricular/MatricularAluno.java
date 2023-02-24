package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.evento.PublicadoDeEventos;

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
