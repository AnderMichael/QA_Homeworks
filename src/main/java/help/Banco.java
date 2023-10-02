package help;

public class Banco {

    private ASFIService asfiService;

    public String getMaximoPrestamo(String ci) {
        String categoria = ASFIService.getCategoria(ci);
        switch (categoria) {
            case "A":
                return String.format("Maximo a prestar %d", 200000);
            case "B":
                return String.format("Maximo a prestar %d", 100000);
            case "C":
                return "No se puede prestar ningún monto ALERTA!";
            default:
                return "ERROR - Categoría inexistente!";
        }
    }
}
