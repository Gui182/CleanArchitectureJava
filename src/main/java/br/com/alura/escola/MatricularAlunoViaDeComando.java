package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoViaDeComando {
    public static void main(String[] args) {

        String nome = "Guilherme Augusto";
        String cpf = "123.456.729-00";
        String email = "guilherm@yahoo.com";

        //COMMAND
        MatricularAluno executa = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        executa.matricular(new MatricularAlunoDto(nome, cpf, email));
    }
}