package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.456-78", "fula@email.com");
        useCase.matricular(dados);

        Aluno encontado = repositorio.buscaPorCPF(new CPF("123.456.456-78"));
        assertEquals("Fulano", encontado.getNome());
        assertEquals("123.456.456-78", encontado.getCpf());
        assertEquals("fula@email.com", encontado.getEmail());
    }
    

}
