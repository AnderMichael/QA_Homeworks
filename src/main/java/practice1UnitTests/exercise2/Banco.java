package practice1UnitTests.exercise2;

public class Banco {

    private ASFIService asfiService;

    public ASFIService getAsfiService() {
        return asfiService;
    }

    public void setAsfiService(ASFIService asfiService) {
        this.asfiService = asfiService;
    }

    public String getMaximoPrestamo(String ci) {
        String categoria = asfiService.getCategoria(ci);
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
