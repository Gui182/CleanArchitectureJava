package br.com.alura.escola.dominio.aluno;

public interface CifradoDeSenha {
    
    String cifrarSenha(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
