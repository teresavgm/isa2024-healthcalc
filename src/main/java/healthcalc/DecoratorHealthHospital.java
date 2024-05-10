package healthcalc;

public class DecoratorHealthHospital implements HealthHospital {
    
    protected HealthHospital wrappeeHealthHospital;
   
    public DecoratorHealthHospital(HealthHospital h) {
        this.wrappeeHealthHospital = h;
    }

    @Override
    public double bmr(char genero, int edad, float altura, int peso) throws Exception {
        // TODO Auto-generated method stub
        return wrappeeHealthHospital.bmr(genero,edad, altura, peso);
    }

    @Override
    public int pesoIdeal(char genero, float altura) throws Exception {
        // TODO Auto-generated method stub
        return wrappeeHealthHospital.pesoIdeal(genero, altura);
    }


}
