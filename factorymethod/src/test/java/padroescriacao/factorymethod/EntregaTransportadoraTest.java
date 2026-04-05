package padroescriacao.factorymethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - EntregaTransportadora")
class EntregaTransportadoraTest {

    private Entrega entrega;

    @BeforeEach
    void setUp() {
        entrega = new EntregaTransportadora();
    }

    @Test
    @DisplayName("Deve retornar tipo de entrega correto")
    void deveRetornarTipoEntregaCorreto() {
        assertEquals("Transportadora", entrega.getTipoEntrega());
    }

    @Test
    @DisplayName("Deve retornar prazo de 5 dias úteis")
    void deveRetornarPrazoCincoDias() {
        assertEquals(5, entrega.prazoEntregaDias());
    }

    @Test
    @DisplayName("Deve calcular custo corretamente para 10kg")
    void deveCalcularCustoCorreto() {
        assertEquals(70.00, entrega.calcularCusto(10.0), 0.001);
    }

    @Test
    @DisplayName("Deve calcular custo para peso muito alto")
    void deveCalcularCustoParaPesoAlto() {
        assertEquals(270.00, entrega.calcularCusto(50.0), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção para peso zero")
    void deveLancarExcecaoParaPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(0));
    }

    @Test
    @DisplayName("Deve lançar exceção para peso negativo")
    void deveLancarExcecaoParaPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(-5.0));
    }

    @Test
    @DisplayName("Deve conter endereço na mensagem de entrega")
    void deveConterEnderecoNaMensagem() {
        String endereco = "Rodovia BR-101, Km 50 - Curitiba";
        String resultado = entrega.realizarEntrega(endereco);
        assertTrue(resultado.contains(endereco));
    }

    @Test
    @DisplayName("Deve mencionar Transportadora na mensagem de entrega")
    void deveMencionarTransportadoraNaMensagem() {
        String resultado = entrega.realizarEntrega("Rua Central, 500");
        assertTrue(resultado.toLowerCase().contains("transportadora"));
    }
}
