package healthcalc;


public class HealthCalcImpl implements HealthCalc {

private static HealthCalcImpl instance;

private HealthCalcImpl(){
}

public static HealthCalcImpl getInstance(){
    if(instance== null){
        instance = new HealthCalcImpl();
    }
    return instance;
}

    
    @Override
    public float idealWeight(Paciente p) throws Exception {
        // calculamos su peso ideal siguiendo la formula de Lorentz:
        //For men: IW = height - 100 - (height - 150) / 4)
	    //For women: IW = height - 100 - (height - 150) / 2.5)
        float idealW = 0;

        if(p.height()<=0){
            throw new RuntimeException("Altura introducida no valida: es menor o igual que 0");
        }else{
            switch (p.gender()) {
                case FEMALE:
                    idealW = p.height() - 100 - (p.height() - 150) / 2.5f;
                    break;
                case MALE:
                    idealW = p.height() - 100 - (p.height() - 150) / 4;
                    break;
                default:
                    throw new RuntimeException("Género introducido no válido");
        }
        }
        return idealW;

	}
    @Override
    public float basalMetabolicRate(Paciente p) throws Exception {
        // Calculamos la Tasa Metabólica Basal (TMB) de una persona con la siguiente fórmula:
        // Para hombres: BMR = 10 * weight + 6.25 * height - 5 * age + 5
        // Para mujeres: BMR = 10 * weight + 6.25 * height - 5 * age - 161
    
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