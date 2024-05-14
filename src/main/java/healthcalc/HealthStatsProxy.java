package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthStatsProxy implements  HealthHospital, HealthStats {

    private List<Float> pesosList= new ArrayList<Float>();
    private List<Float> alturasList= new ArrayList<Float>();
    private List<Integer> edadesList= new ArrayList<Integer>();
    private List<Float> bmrsList= new ArrayList<Float>();
    private int numW;
    private int numM;
    private Adapter calculadora;
    

    public HealthStatsProxy(HealthHospital healthCalc){
        calculadora =(Adapter) healthCalc;
            numW = 0;
            numM = 0;
    }


    // Calculamos la altura media de todos los pacientes que han usado la calculadora
    @Override
    public float alturaMedia(){
        float suma = 0;
        for(float i:alturasList){
            suma+= i;
        }

        return suma/alturasList.size();
    }
    // Calculamos el peso medio de todos los pacientes que han usado la calculadora
    @Override
    public float pesoMedio(){
        float suma = 0;
        for(float i:pesosList){
            suma+= i;
        }
        return suma/numTotalPacientes();
    }
    // Calculamos la edad media de todos los pacientes que han usado la calculadora
    @Override
    public float edadMedia(){
        float suma = 0;
        for(int i:edadesList){
            suma+= i;
        }

        return suma/numTotalPacientes();
    }
    // Calculamos el bmr medio de todos los pacientes que han usado la calculadora
    @Override
    public float bmrMedio(){
        float suma = 0;
        for(float i:bmrsList){
            suma+= i;
        }
        return suma/numTotalPacientes();
    }
    // Calculamos el número de hombres y de mujeres que han usado la calculadora
    @Override
    public int numSexoH(){
        return numM;
    }
    @Override
    public int  numSexoM(){
        return numW;
    }
    // Calculamos el numero de personas que han usado la calculadora
    @Override
    public int numTotalPacientes(){
            return alturasList.size();
    }
    
    @Override
    public double bmr(Paciente p) throws Exception {
        alturasList.add((float)p.height());
        switch (p.gender()) {
            case FEMALE:
                numW++;
                break;
            case MALE:
                numM++;
                break;
        }        
        pesosList.add((float)p.weight());
        edadesList.add(p.age());
        double bmr = calculadora.bmr(p);
        bmrsList.add((float)bmr);
        return  (float) bmr;
    
    }

    @Override
    public int pesoIdeal(Paciente p) throws Exception {
        alturasList.add((float)p.height());
        switch (p.gender()) {
            case FEMALE:
                numW++;
                break;
            case MALE:
                numM++;
                break;
        }         
        float iw = calculadora.pesoIdeal(p);
       
        return (int) iw;      }
}
