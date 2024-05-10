package healthcalc;

public class MainDecorator {



    public static void main(String[] args) throws Exception {

        HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital healthHospital = new Adapter(healthCalc);
        
        HealthStatsProxy healthStatsProxy = new HealthStatsProxy(healthHospital);
        HealthHospital healthHospitalEuropea = new DecoradorEuropeo(healthStatsProxy);
        HealthHospital healthHospitalAmericana = new DecoradorAmericano(healthStatsProxy);

        // Comprobamos el peso ideal
        int pesoIdealEU= healthHospitalEuropea.pesoIdeal('w', 1.65f);
        int pesoIdealAM = healthHospitalAmericana.pesoIdeal('m',  5.5f);

        System.out.println(" ");  
         System.out.println(" ");
        

        System.out.println("Peso ideal paciente europeo 1: " + pesoIdealEU);
        System.out.println("Peso ideal paciente americano 1: " + pesoIdealAM);
        System.out.println(" ");

        
        //Pacientes europeos
        healthHospitalEuropea.bmr('w', 23, 1.65f, 50000);
        healthHospitalEuropea.bmr('m', 54, 1.82f, 70000);

        //Pacientes americanos
        healthHospitalAmericana.bmr('w', 42, 6.5f, 190);
        healthHospitalAmericana.bmr('m', 70, 5.3f, 150);
        System.out.println(" ");

        //Comprobacion de q se cambian las unidades correctamente
        System.out.println("Los siguiente pacientes deben tener el mismo BMR:");

        healthHospitalEuropea.bmr('w', 20, 1.70f, 56000);
        healthHospitalAmericana.bmr('w', 20, 5.57743f, 123);
        System.out.println(" ");


        //Probamos a la vez el patrón proxy para confirmar una correcta implementacion
        System.out.println("        Altura media de los pacientes: " + healthStatsProxy.alturaMedia() + " metros");
        System.out.println("        Edad media de los pacientes: " + healthStatsProxy.edadMedia());
        System.out.println("        Peso medio de los pacientes: " + healthStatsProxy.pesoMedio() + " gramos");
        System.out.println("        BMR medio de los pacientes: " + healthStatsProxy.bmrMedio());
        System.out.println("        Pacientes hombres: " + healthStatsProxy.numSexoH());
        System.out.println("        Pacientes mujeres: " + healthStatsProxy.numSexoM());
        System.out.println("        En total hay " + healthStatsProxy.numTotalPacientes()+ " pacientes");

    }
}
