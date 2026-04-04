package padroescriacao.factorymethod;

public interface Entrega {

    String realizarEntrega(String endereco);

    double calcularCusto(double pesoKg);

    int prazoEntregaDias();

    String getTipoEntrega();
}
