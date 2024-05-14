package healthcalc;

public class DecoradorAmericano extends DecoratorHealthHospital {

    public DecoradorAmericano(HealthHospital h) {
        super(h);
        //TODO Auto-generated constructor stub
    }

    @Override               
    public int pesoIdeal(Paciente p) throws Exception {
        //pasamos la altura introducida en pies a metros
        float alturaMetros = p.height() * 0.3048f;
        float pi = super.pesoIdeal(p);

        return (int) pi ;
    }

    @Override
    public double bmr(Paciente p) throws Exception {
        float alturaMetros = p.height() * 0.3048f;
        int pesoGr = (int) (p.weight() * 453.592);

        float BMR = (float) super.bmr(p );

        //Imprimimos los resultados por pantalla en inglés y en español
        System.out.println("The person whose height is " + p.height() + " ft" + " and whose weight is " + p.weight() + " Lb has a BMR of " + BMR + " calories");
        System.out.println("La persona con altura " + alturaMetros + " metros " + " y peso de " + pesoGr + " Gr tiene un BMR de " + BMR + " calorias");

        return BMR;
    }


}
