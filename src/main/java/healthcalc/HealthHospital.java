package healthcalc;

public interface HealthHospital {


    /**
     * Se calcula la tasa metabólica basal (bmr) 
     *   
     */

    public double bmr(char genero, int edad, float altura, int peso);


    
    /**
     * Se calcula el peso ideal (bmr) 
     *   
     */

    public int pesoIdeal(char genero, float altura);

}
