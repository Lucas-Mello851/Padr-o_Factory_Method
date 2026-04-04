package padroescriacao.factorymethod;

public class EntregaDrone implements Entrega {

    private static final double CUSTO_BASE = 15.00;
    private static final double CUSTO_POR_KG = 4.00;
    private static final double PESO_MAXIMO_KG = 5.0;
    private static final int PRAZO_DIAS = 1;

    @Override
    public String realizarEntrega(String endereco) {
        return "Entrega via Drone iniciada para: " + endereco +
               ". Tempo estimado: 30 minutos. Prazo máximo: " + PRAZO_DIAS + " dia útil.";
    }

    @Override
    public double calcularCusto(double pesoKg) {
        if (pesoKg <= 0) {
            throw new IllegalArgumentException("Peso deve ser maior que zero.");
        }
        if (pesoKg > PESO_MAXIMO_KG) {
            throw new IllegalArgumentException(
                "Drone não suporta pacotes acima de " + PESO_MAXIMO_KG + " kg.");
        }
        return CUSTO_BASE + (pesoKg * CUSTO_POR_KG);
    }

    @Override
    public int prazoEntregaDias() {
        return PRAZO_DIAS;
    }

    @Override
    public String getTipoEntrega() {
        return "Drone";
    }

    public double getPesoMaximoKg() {
        return PESO_MAXIMO_KG;
    }
}
