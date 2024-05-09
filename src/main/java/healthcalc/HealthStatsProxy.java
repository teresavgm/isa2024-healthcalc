package healthcalc;

import java.util.ArrayList;
import java.util.List;

public class HealthStatsProxy implements  HealthHospital, HealthStats {


    public int pacientesTotales = 0;
    public List<Float> pesosList= new ArrayList<Float>();
    public List<Float> alturasList= new ArrayList<Float>();
    public List<Integer> edadesList= new ArrayList<Integer>();
    public List<Float> bmrsList= new ArrayList<Float>();
    public int numW;
    public int numM;
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

        return suma/pacientesTotales;
    }
    // Calculamos el peso medio de todos los pacientes que han usado la calculadora
    @Override
    public float pesoMedio(){
        float suma = 0;
        for(float i:pesosList){
            suma+= i;
        }
        return suma/pacientesTotales;
    }
    // Calculamos la edad media de todos los pacientes que han usado la calculadora
    @Override
    public float edadMedia(){
        float suma = 0;
        for(int i:edadesList){
            suma+= i;
        }

        return suma/pacientesTotales;
    }
    // Calculamos el bmr medio de todos los pacientes que han usado la calculadora
    @Override
    public float bmrMedio(){
        float suma = 0;
        for(float i:bmrsList){
            suma+= i;
        }
        return suma/pacientesTotales;
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
            return pacientesTotales;
    }
    




    @Override
    public double bmr(char genero, int edad, float altura, int peso) {
        pacientesTotales++;
        alturasList.add((float)altura);
        if(genero == 'w'){
            numW++;
        }else if(genero == 'm'){
            numM++;
        }        
        pesosList.add((float)peso);
        edadesList.add(edad);

        double bmr = calculadora.bmr(genero, edad, (float) altura, (int) peso);
        bmrsList.add((float)bmr);
        return  (float) bmr;
    
    }


    @Override
    public int pesoIdeal(char genero, float altura) {
        pacientesTotales++;
        alturasList.add((float)altura);
        if(genero == 'w'){
            numW++;
        }else if(genero == 'm'){
            numM++;
        }        
        float iw = calculadora.pesoIdeal(genero,(float) altura);
       
        return (int) iw;      }
    
}
