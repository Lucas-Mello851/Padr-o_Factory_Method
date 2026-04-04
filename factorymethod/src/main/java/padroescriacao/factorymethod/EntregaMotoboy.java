package padroescriacao.factorymethod;

public class EntregaMotoboy implements Entrega {

    private static final double CUSTO_BASE = 8.00;
    private static final double CUSTO_POR_KG = 2.50;
    private static final int PRAZO_DIAS = 1;

    @Override
    public String realizarEntrega(String endereco) {
        return "Entrega via Motoboy em andamento para: " + endereco +
               ". Prazo: mesmo dia ou até " + PRAZO_DIAS + " dia útil.";
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
        return "Motoboy";
    }
}
