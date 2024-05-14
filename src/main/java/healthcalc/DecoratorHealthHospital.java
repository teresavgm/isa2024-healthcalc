package healthcalc;

public class DecoratorHealthHospital implements HealthHospital {
    
    protected HealthHospital wrappeeHealthHospital;
   
    public DecoratorHealthHospital(HealthHospital h) {
        this.wrappeeHealthHospital = h;
    }

    @Override
    public double bmr(Paciente p) throws Exception {
        // TODO Auto-generated method stub
        return wrappeeHealthHospital.bmr(p);
    }

    @Override
    public int pesoIdeal(Paciente p) throws Exception {
        // TODO Auto-generated method stub
        return wrappeeHealthHospital.pesoIdeal(p);
    }


}
