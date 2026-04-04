package padroescriacao.factorymethod;

public class DroneFactory extends EntregaFactory {

    @Override
    public Entrega criarEntrega() {
        return new EntregaDrone();
    }
}
