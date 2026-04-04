package padroescriacao.factorymethod;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("   SISTEMA DE ENTREGAS — Factory Method (GoF)   ");
        System.out.println("\n");

        EntregaFactory[] factories = {
            new MotoboyFactory(),
            new TransportadoraFactory(),
            new DroneFactory()
        };

        String[] enderecos = {
            "Rua das Flores, 100 — São Paulo/SP",
            "Rodovia BR-116, Km 410 — Curitiba/PR",
            "Av. Paulista, 1000 — São Paulo/SP"
        };

        double[] pesos = { 1.5, 20.0, 3.0 };

        for (int i = 0; i < factories.length; i++) {
            EntregaFactory factory = factories[i];
            Entrega entrega = factory.criarEntrega();

            System.out.println("Tipo de Entrega: " + entrega.getTipoEntrega());
            System.out.println("Endereço : " + enderecos[i]);
            System.out.printf ("Peso     : %.1f kg%n", pesos[i]);
            System.out.printf ("Custo    : R$ %.2f%n", entrega.calcularCusto(pesos[i]));
            System.out.println("Prazo    : " + entrega.prazoEntregaDias() + " dia(s) útil(eis)");
            System.out.println("Status   : " + entrega.realizarEntrega(enderecos[i]));
            System.out.println(" ");
            System.out.println("Resumo via processarEntrega():");
            System.out.println("   " + factory.processarEntrega(enderecos[i], pesos[i]));
            System.out.println();
        }

        System.out.println(" ");
        System.out.println("   TESTE DE RESTRIÇÃO — Drone com peso > 5kg    ");
        System.out.println(" ");
        try {
            EntregaFactory droneFactory = new DroneFactory();
            droneFactory.processarEntrega("Av. Brasil, 500", 8.0);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exceção capturada corretamente: " + e.getMessage());
        }
    }
}
