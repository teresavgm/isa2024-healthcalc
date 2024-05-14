package healthcalc;

public class Paciente implements Person{

    private float peso;
    private float altura;
    private int edad;
    private Gender genero;

    public Paciente(Gender genero, int edad, float altura, float peso){
        this.peso = peso;
        this.altura = altura;
        this.edad = edad;
        this.genero = genero;

    }

    //Devuelve el peso
    @Override
    public float weight() {
        // TODO Auto-generated method stub
        return peso;
    }

    //Devuelve la altura
    @Override
    public float height() {
        // TODO Auto-generated method stub
        return altura;
    }

    //Devuelve la edad
    @Override
    public int age() {
        // TODO Auto-generated method stub
        return edad;        
    }
    
    //Devuelve el genero
    @Override
    public Gender gender() {
        // TODO Auto-generated method stub
        return genero;
    }

}
