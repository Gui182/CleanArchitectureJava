package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositórioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadoDeEventos;

public class MatricularAlunoViaDeComando {
    public static void main(String[] args) {

        String nome = "Guilherme Augusto";
        String cpf = "123.456.729-00";
        String email = "guilherm@yahoo.com";

        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);

        PublicadoDeEventos publicador = new PublicadoDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GeraSeloAlunoNovato(new RepositórioDeSelosEmMemoria()));

        //COMMAND
        MatricularAluno executa = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        executa.matricular(dto);
    }
}