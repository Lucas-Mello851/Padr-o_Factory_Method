package padroescriacao.factorymethod;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - EntregaDrone")
class EntregaDroneTest {

    private EntregaDrone entrega;

    @BeforeEach
    void setUp() {
        entrega = new EntregaDrone();
    }

    @Test
    @DisplayName("Deve retornar tipo de entrega correto")
    void deveRetornarTipoEntregaCorreto() {
        assertEquals("Drone", entrega.getTipoEntrega());
    }

    @Test
    @DisplayName("Deve retornar prazo de 1 dia útil")
    void deveRetornarPrazoUmDia() {
        assertEquals(1, entrega.prazoEntregaDias());
    }

    @Test
    @DisplayName("Deve calcular custo corretamente para 2kg")
    void deveCalcularCustoCorreto() {
        assertEquals(23.00, entrega.calcularCusto(2.0), 0.001);
    }

    @Test
    @DisplayName("Deve calcular custo no limite máximo de peso (5kg)")
    void deveCalcularCustoNoLimiteMaximo() {
        assertEquals(35.00, entrega.calcularCusto(5.0), 0.001);
    }

    @Test
    @DisplayName("Deve lançar exceção para peso acima do limite do drone")
    void deveLancarExcecaoParaPesoAcimaDoLimite() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(6.0));
    }

    @Test
    @DisplayName("Deve lançar exceção para peso zero")
    void deveLancarExcecaoParaPesoZero() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(0));
    }

    @Test
    @DisplayName("Deve lançar exceção para peso negativo")
    void deveLancarExcecaoParaPesoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> entrega.calcularCusto(-2.0));
    }

    @Test
    @DisplayName("Deve retornar peso máximo de 5kg")
    void deveRetornarPesoMaximo() {
        assertEquals(5.0, entrega.getPesoMaximoKg(), 0.001);
    }

    @Test
    @DisplayName("Deve conter endereço na mensagem de entrega")
    void deveConterEnderecoNaMensagem() {
        String endereco = "Alameda Santos, 200 - São Paulo";
        String resultado = entrega.realizarEntrega(endereco);
        assertTrue(resultado.contains(endereco));
    }

    @Test
    @DisplayName("Deve mencionar Drone na mensagem de entrega")
    void deveMencionarDroneNaMensagem() {
        String resultado = entrega.realizarEntrega("Av. Brasil, 300");
        assertTrue(resultado.toLowerCase().contains("drone"));
    }
}
