package healthcalc;


public class HealthCalcImpl implements HealthCalc {

private static HealthCalcImpl instance;
private static CardiovascularMetrics CardiovascularMetrics;
private MetabolicMetrics MetabolicMetrics;

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
        return (float) CardiovascularMetrics.getIdealBodyWeight(p);

	}
    @Override
    public float basalMetabolicRate(Paciente p) throws Exception {
        // Calculamos la Tasa Metabólica Basal (TMB) de una persona con la siguiente fórmula:
        // Para hombres: BMR = 10 * weight + 6.25 * height - 5 * age + 5
        // Para mujeres: BMR = 10 * weight + 6.25 * height - 5 * age - 161
        return (float) MetabolicMetrics.basalMetabolicRate(p);
    }
}