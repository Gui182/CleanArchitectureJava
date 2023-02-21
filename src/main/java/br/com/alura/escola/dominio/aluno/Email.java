package br.com.alura.escola.dominio.aluno;

public class Email {
    
    private String endereco;

    public Email(String endereco) {
        if(endereco == null || !endereco.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Email inválido");

        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }    
}
