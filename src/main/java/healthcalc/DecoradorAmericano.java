package healthcalc;

public class DecoradorAmericano extends DecoratorHealthHospital {

    public DecoradorAmericano(HealthHospital h) {
        super(h);
        //TODO Auto-generated constructor stub
    }

    @Override               
    public int pesoIdeal(Gender genero,float alturaFt) throws Exception {
        //pasamos la altura introducida en pies a metros
        float alturaMetros = alturaFt * 0.3048f;
        float pi = super.pesoIdeal(genero, alturaMetros);

        return (int) pi ;
    }

    @Override
    public double bmr(Gender genero, int edad, float alturaFt, int pesoLb) throws Exception {
        float alturaMetros = alturaFt * 0.3048f;
        int pesoGr = (int) (pesoLb * 453.592);

        float BMR = (float) super.bmr(genero, edad,alturaMetros, pesoGr );

        //Imprimimos los resultados por pantalla en inglés y en español
        System.out.println("The person whose height is " + alturaFt + " ft" + " and whose weight is " + pesoLb + " Lb has a BMR of " + BMR + " calories");
        System.out.println("La persona con altura " + alturaMetros + " metros " + " y peso de " + pesoGr + " Gr tiene un BMR de " + BMR + " calorias");

        return BMR;
    }


}
