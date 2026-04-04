package padroescriacao.factorymethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - EntregaMotoboy")
class EntregaMotoboyTest {

    private Entrega entrega;

    @BeforeEach
    void setUp() {
        entrega = new EntregaMotoboy();
    }

    @Test
    @DisplayName("Deve retornar tipo de entrega correto")
    void deveRetornarTipoEntregaCorreto() {
        assertEquals("Motoboy", entrega.getTipoEntrega());
    }

    @Test
    @DisplayName("Deve retornar prazo de 1 dia útil")
    void deveRetornarPrazoUmDia() {
        assertEquals(1, entrega.prazoEntregaDias());
    }

    @Test
    @DisplayName("Deve calcular custo corretamente para 2kg")
    void deveCalcularCustoCorreto() {
        assertEquals(13.00, entrega.calcularCusto(2.0), 0.001);
    }

    @Test
    @DisplayName("Deve calcular custo mínimo para peso muito baixo")
    void deveCalcularCustoParaPesoBaixo() {
        assertEquals(8.25, entrega.calcularCusto(0.1), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção para peso zero")
    void deveLancarExcecaoParaPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(0));
    }

    @Test
    @DisplayName("Deve lançar exceção para peso negativo")
    void deveLancarExcecaoParaPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(-1.0));
    }

    @Test
    @DisplayName("Deve conter endereço na mensagem de entrega")
    void deveConterEnderecoNaMensagem() {
        String endereco = "Rua das Flores, 100 - São Paulo";
        String resultado = entrega.realizarEntrega(endereco);
        assertTrue(resultado.contains(endereco));
    }

    @Test
    @DisplayName("Deve mencionar Motoboy na mensagem de entrega")
    void deveMencionarMotoboyNaMensagem() {
        String resultado = entrega.realizarEntrega("Av. Paulista, 1000");
        assertTrue(resultado.toLowerCase().contains("motoboy"));
    }
}
