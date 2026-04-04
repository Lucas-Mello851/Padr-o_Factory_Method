package padroescriacao.factorymethod;

public class EntregaTransportadora implements Entrega {

    private static final double CUSTO_BASE = 20.00;
    private static final double CUSTO_POR_KG = 5.00;
    private static final int PRAZO_DIAS = 5;

    @Override
    public String realizarEntrega(String endereco) {
        return "Entrega via Transportadora agendada para: " + endereco +
               ". Prazo estimado: até " + PRAZO_DIAS + " dias úteis.";
    }

    @Override
    public double calcularCusto(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        return CUSTO_BASE + (pesoKg * CUSTO_POR_KG);
    }

    @Override
    public int prazoEntregaDias() {
        return PRAZO_DIAS;
    }

    @Override
    public String getTipoEntrega() {
        return "Transportadora";
    }
}
