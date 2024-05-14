package healthcalc;

public interface HealthHospital {


    /**
     * Se calcula la tasa metabólica basal (bmr) 
     *   
     */

    public double bmr(Paciente p) throws Exception;


    
    /**
     * Se calcula el peso ideal (bmr) 
     *   
     */

    public int pesoIdeal(Paciente p) throws Exception;

}
