package padroescriacao.factorymethod;

public abstract class EntregaFactory {

    public abstract Entrega criarEntrega();

    public String processarEntrega(String endereco, double pesoKg) {
        Entrega entrega = criarEntrega();

        String confirmacao = entrega.realizarEntrega(endereco);
        double custo = entrega.calcularCusto(pesoKg);
        int prazo = entrega.prazoEntregaDias();

        return String.format(
            "[%s] %s | Custo: R$ %.2f | Prazo: %d dia(s) útil(eis).",
            entrega.getTipoEntrega(), confirmacao, custo, prazo
        );
    }
}
