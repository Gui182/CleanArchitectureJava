package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.PublicadoDeEventos;

public class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        PublicadoDeEventos publicador = new PublicadoDeEventos();
        
        
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.456-78", "fula@email.com");
        useCase.matricular(dados);

        publicador.adicionar(new LogDeAlunoMatriculado());

        Aluno encontrado = repositorio.buscaPorCPF(new CPF("123.456.456-78"));
        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.456-78", encontrado.getCpf().toString());
        assertEquals("fula@email.com", encontrado.getEmail());
    }
    

}
