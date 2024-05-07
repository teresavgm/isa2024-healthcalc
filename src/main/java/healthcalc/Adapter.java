package healthcalc;

public class Adapter implements HealthHospital {

    private HealthCalc healthCalc;

    public Adapter(HealthCalc healthCalc) {
        this.healthCalc = healthCalc;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        try {
            return healthCalc.basalMetabolicRate(peso, (int) altura, genero, edad);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo apropiado de la excepción, dependiendo de los requisitos.
            return 0; // Puedes devolver un valor predeterminado o manejar la excepción según sea necesario.
        }
    }

    @Override
    public int pesoIdeal(char genero, float altura) {
        try {
            return (int) healthCalc.idealWeight((int) altura, genero);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo apropiado de la excepción, dependiendo de los requisitos.
            return 0; // Puedes devolver un valor predeterminado o manejar la excepción según sea necesario.
        }
    }
}




