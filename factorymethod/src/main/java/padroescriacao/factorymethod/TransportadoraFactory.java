package padroescriacao.factorymethod;

public class TransportadoraFactory extends EntregaFactory {

    @Override
    public Entrega criarEntrega() {
        return new EntregaTransportadora();
    }
}
