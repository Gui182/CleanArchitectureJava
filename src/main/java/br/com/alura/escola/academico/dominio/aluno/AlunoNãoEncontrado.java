package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.CPF;

public class AlunoNãoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNãoEncontrado(CPF cpf) {
        super("Aluno não encontrado com CPF " + cpf.getNumero());
    }

}
