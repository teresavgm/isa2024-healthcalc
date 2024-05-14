package healthcalc;

public class DecoradorEuropeo extends DecoratorHealthHospital {


    public DecoradorEuropeo(HealthHospital h) {
        super(h);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int pesoIdeal(Paciente pa) throws Exception {
        return super.pesoIdeal(pa);
    }

    @Override
    public double bmr(Paciente pa) throws Exception {
        float BMR = (float) super.bmr(pa );
        double alturaFt = pa.height()*3.28084;
        int pesoLb = (int) (pa.weight() * 0.00220462);

        //Imprimimos los resultados por pantalla en inglés y en español
        System.out.println("La persona con altura " + pa.height() + " metros " + " y peso de " + pa.weight() + " gr tiene un BMR de " + BMR + " calorias");
        System.out.println("The person whose height is " + alturaFt + " ft " + " and whose weight is " + pesoLb + " Lb has a BMR of " + BMR + " calories");
        return BMR;
    }


}
