package padroescriacao.factorymethod;

public class MotoboyFactory extends EntregaFactory {

    @Override
    public Entrega criarEntrega() {
        return new EntregaMotoboy();
    }
}
