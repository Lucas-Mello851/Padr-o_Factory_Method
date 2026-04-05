package padroescriacao.factorymethod;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes - Factories Concretas")
class EntregaFactoryTest {

    @Test
    @DisplayName("MotoboyFactory deve criar instância de EntregaMotoboy")
    void motoboyFactoryDeveCriarInstanciaCorreta() {
        EntregaFactory factory = new MotoboyFactory();
        Entrega entrega = factory.criarEntrega();
        assertInstanceOf(EntregaMotoboy.class, entrega);
    }

    @Test
    @DisplayName("MotoboyFactory deve processar entrega com resumo correto")
    void motoboyFactoryDeveProcessarEntrega() {
        EntregaFactory factory = new MotoboyFactory();
        String resultado = factory.processarEntrega("Rua A, 10", 1.0);
        assertTrue(resultado.contains("Motoboy"));
        assertTrue(resultado.contains("R$"));
        assertTrue(resultado.contains("dia"));
    }

    @Test
    @DisplayName("MotoboyFactory deve calcular custo no processamento")
    void motoboyFactoryDeveCalcularCustoNoProcessamento() {
        EntregaFactory factory = new MotoboyFactory();
        String resultado = factory.processarEntrega("Rua B, 20", 2.0);
        assertTrue(resultado.contains("13,00") || resultado.contains("13.00"));
    }

    @Test
    @DisplayName("TransportadoraFactory deve criar instância de EntregaTransportadora")
    void transportadoraFactoryDeveCriarInstanciaCorreta() {
        EntregaFactory factory = new TransportadoraFactory();
        Entrega entrega = factory.criarEntrega();
        assertInstanceOf(EntregaTransportadora.class, entrega);
    }

    @Test
    @DisplayName("TransportadoraFactory deve processar entrega com resumo correto")
    void transportadoraFactoryDeveProcessarEntrega() {
        EntregaFactory factory = new TransportadoraFactory();
        String resultado = factory.processarEntrega("Rodovia SP-330, Km 100", 15.0);
        assertTrue(resultado.contains("Transportadora"));
        assertTrue(resultado.contains("R$"));
    }

    @Test
    @DisplayName("TransportadoraFactory deve calcular custo no processamento")
    void transportadoraFactoryDeveCalcularCustoNoProcessamento() {
        EntregaFactory factory = new TransportadoraFactory();
        String resultado = factory.processarEntrega("Rua C, 30", 10.0);
        assertTrue(resultado.contains("70,00") || resultado.contains("70.00"));
    }

    @Test
    @DisplayName("DroneFactory deve criar instância de EntregaDrone")
    void droneFactoryDeveCriarInstanciaCorreta() {
        EntregaFactory factory = new DroneFactory();
        Entrega entrega = factory.criarEntrega();
        assertInstanceOf(EntregaDrone.class, entrega);
    }

    @Test
    @DisplayName("DroneFactory deve processar entrega com resumo correto")
    void droneFactoryDeveProcessarEntrega() {
        EntregaFactory factory = new DroneFactory();
        String resultado = factory.processarEntrega("Av. Ipiranga, 50", 1.5);
        assertTrue(resultado.contains("Drone"));
        assertTrue(resultado.contains("R$"));
    }

    @Test
    @DisplayName("DroneFactory deve lançar exceção ao processar pacote acima do limite")
    void droneFactoryDeveLancarExcecaoParaPesoExcessivo() {
        EntregaFactory factory = new DroneFactory();
        assertThrows(IllegalArgumentException.class,
            () -> factory.processarEntrega("Av. D, 40", 10.0));
    }

    @Test
    @DisplayName("Factories devem criar produtos com tipos distintos")
    void factoriesDevemCriarProdutosDistintos() {
        Entrega motoboy = new MotoboyFactory().criarEntrega();
        Entrega transportadora = new TransportadoraFactory().criarEntrega();
        Entrega drone = new DroneFactory().criarEntrega();

        assertNotEquals(motoboy.getTipoEntrega(), transportadora.getTipoEntrega());
        assertNotEquals(motoboy.getTipoEntrega(), drone.getTipoEntrega());
        assertNotEquals(transportadora.getTipoEntrega(), drone.getTipoEntrega());
    }

    @Test
    @DisplayName("Todos os produtos devem implementar a interface Entrega")
    void todosProdutosDevemImplementarInterfaceEntrega() {
        Entrega motoboy = new MotoboyFactory().criarEntrega();
        Entrega transportadora = new TransportadoraFactory().criarEntrega();
        Entrega drone = new DroneFactory().criarEntrega();

        assertInstanceOf(Entrega.class, motoboy);
        assertInstanceOf(Entrega.class, transportadora);
        assertInstanceOf(Entrega.class, drone);
    }
}
