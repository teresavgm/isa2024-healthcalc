package healthcalc;

public class MainProxy {

    public static void main(String[] args) throws Exception {
 
    HealthCalc healthCalc = HealthCalcImpl.getInstance();
    Adapter calc = new Adapter(healthCalc);
    HealthStatsProxy nuevaCalc = new HealthStatsProxy(calc);

    //Utilizamos la calculadora para introducir datos
    double bmr1 = nuevaCalc.bmr('w', 25, (float)1.4, 45000);
    double bmr2 = nuevaCalc.bmr('m', 50, (float)1.8, 70000);

    
    System.out.println("BMR Paciente 1: " + bmr1 );
    System.out.println("BMR Paciente 2: " + bmr2 );
    System.out.println("    ");

    System.out.println("ALTURA MEDIA EN METROS: " + nuevaCalc.alturaMedia());
    System.out.println("EDAD MEDIA: " +nuevaCalc.edadMedia());
    System.out.println("PESO MEDIO EN GRAMOS: " +nuevaCalc.pesoMedio());
    System.out.println("NÚMERO DE PACIENTES MUJER: " +nuevaCalc.numSexoM());
    System.out.println("NÚMERO DE PACIENTES HOMBRE: " +nuevaCalc.numSexoH());
    System.out.println("BMR MEDIO: " + nuevaCalc.bmrMedio());


    }
}
