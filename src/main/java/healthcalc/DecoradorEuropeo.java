package healthcalc;

public class DecoradorEuropeo extends DecoratorHealthHospital {


    public DecoradorEuropeo(HealthHospital h) {
        super(h);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int pesoIdeal(Gender genero,float altura) throws Exception {
        return super.pesoIdeal(genero, altura);
    }

    @Override
    public double bmr(Gender genero, int edad, float alturaMetros, int pesoGr) throws Exception {
        float BMR = (float) super.bmr(genero, edad,alturaMetros, pesoGr );
        double alturaFt = alturaMetros*3.28084;
        int pesoLb = (int) (pesoGr * 0.00220462);

        //Imprimimos los resultados por pantalla en inglés y en español
        System.out.println("La persona con altura " + alturaMetros + " metros " + " y peso de " + pesoGr + " gr tiene un BMR de " + BMR + " calorias");
        System.out.println("The person whose height is " + alturaFt + " ft " + " and whose weight is " + pesoLb + " Lb has a BMR of " + BMR + " calories");
        return BMR;
    }


}
