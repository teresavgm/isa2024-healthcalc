package healthcalc;

public interface HealthHospital {


    /**
     * Se calcula la tasa metabólica basal (bmr) 
     *   
     */

    public double bmr(Gender genero, int edad, float altura, int peso) throws Exception;


    
    /**
     * Se calcula el peso ideal (bmr) 
     *   
     */

    public int pesoIdeal(Gender genero, float altura) throws Exception;

}
