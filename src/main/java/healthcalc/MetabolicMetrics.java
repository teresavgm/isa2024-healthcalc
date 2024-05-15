package healthcalc;

public class MetabolicMetrics {


    public double basalMetabolicRate(Paciente p){

        float BMR = 0;
    
        if (p.height() <= 0) {
            throw new RuntimeException("Altura introducida no válida: es menor o igual que 0");
        } else if (p.gender() == null) {
            throw new RuntimeException("Género introducido no válido");
        } else if (p.weight() <= 0) {
            throw new RuntimeException("Peso introducido no válido: es menor o igual que 0");
        } else if (p.age() <= 0) {
            throw new RuntimeException("Edad introducida no válida: es menor o igual que 0");
        } else {
            switch (p.gender()) {
                case FEMALE:
                    BMR = 10f * p.weight() + 6.25f * p.height() - 5f * p.age() - 161f;
                    break;
                case MALE:
                    BMR = 10f * p.weight() + 6.25f * p.height() - 5f * p.age() + 5f;
                    break;
                default:
                    throw new RuntimeException("Género introducido no válido");
            }
        }
        return BMR;
    }
}
