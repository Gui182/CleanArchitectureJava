package escola;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class EmailTeste {

    @Test
    void naoDeveCriarEmailsComEndereçoInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));

        assertThrows(IllegalArgumentException.class, () -> new Email("null"));

        assertThrows(IllegalArgumentException.class, () -> new Email("emailinválido"));
    }

    @Test
    void naoDeveriaCriarTelefoneComDDDsInvalidos() {
        assertThrows(IllegalArgumentException.class,
                () -> new Telefone(null, "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("", "123456789"));

        assertThrows(IllegalArgumentException.class,
                () -> new Telefone("1", "123456789"));
    }
}
