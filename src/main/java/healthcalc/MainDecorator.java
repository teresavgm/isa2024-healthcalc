package healthcalc;

public class MainDecorator {



    public static void main(String[] args) throws Exception {

        HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital healthHospital = new Adapter(healthCalc);
        
        HealthStatsProxy healthStatsProxy = new HealthStatsProxy(healthHospital);
        HealthHospital healthHospitalEuropea = new DecoradorEuropeo(healthStatsProxy);
        HealthHospital healthHospitalAmericana = new DecoradorAmericano(healthStatsProxy);

        // Comprobamos el peso ideal
        Paciente paciente1 = new Paciente(Gender.FEMALE, 25, (float)1.4, 45000);
        Paciente paciente2 = new Paciente(Gender.MALE, 50, (float)1.8, 70000);
        Paciente paciente3 = new Paciente(Gender.FEMALE, 23, 1.65f, 50000);
        Paciente paciente4 = new Paciente(Gender.MALE, 54, 1.82f, 70000);
        
        Paciente paciente5 = new Paciente(Gender.FEMALE, 42, 6.5f, 190);
        Paciente paciente6 = new Paciente(Gender.MALE, 70, 5.3f, 150);
        Paciente paciente7 = new Paciente(Gender.FEMALE, 20, 1.70f, 56000);
        Paciente paciente8 = new Paciente(Gender.FEMALE, 20, 5.57743f, 123);

        int pesoIdealEU= healthHospitalEuropea.pesoIdeal(paciente1);
        int pesoIdealAM = healthHospitalAmericana.pesoIdeal(paciente2);

        System.out.println(" ");  
         System.out.println(" ");
        

        System.out.println("Peso ideal paciente europeo 1: " + pesoIdealEU);
        System.out.println("Peso ideal paciente americano 1: " + pesoIdealAM);
        System.out.println(" ");
        
        //Pacientes europeos
        healthHospitalEuropea.bmr(paciente3);
        healthHospitalEuropea.bmr(paciente4);
        //Pacientes americanos
        healthHospitalAmericana.bmr(paciente5);
        healthHospitalAmericana.bmr(paciente6);
        System.out.println(" ");

        //Comprobacion de q se cambian las unidades correctamente
        System.out.println("Los siguiente pacientes deben tener el mismo BMR:");

        healthHospitalEuropea.bmr(paciente7);
        healthHospitalAmericana.bmr(paciente8);
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
