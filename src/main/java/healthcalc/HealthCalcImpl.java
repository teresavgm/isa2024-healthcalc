package healthcalc;


public class HealthCalcImpl implements HealthCalc {

private static HealthCalcImpl instance;

private HealthCalcImpl(){
}

public static HealthCalcImpl getInstance(){
    if(instance== null){
        instance = new HealthCalcImpl();
    }
    return instance;
}

    
    @Override
    public float idealWeight(int height, char gender) throws Exception {
        // calculamos su peso ideal siguiendo la formula de Lorentz:
        //For men: IW = height - 100 - (height - 150) / 4)
	    //For women: IW = height - 100 - (height - 150) / 2.5)
        float idealW = 0;

        if(height<=0){
            throw new RuntimeException("Altura introducida no valida: es menor o igual que 0");
        } else if(gender != 'w' && gender != 'm'){
            throw new RuntimeException("Genero introducido no valido");
        }else{
            if(gender == 'w'){
                idealW = height - 100 - (height - 150) / 2.5f;
            }else{
                idealW = height - 100 - (height - 150) / 4;
            }
        }
    
        return idealW;

	}
	
    public float basalMetabolicRate(float weight, int height, char gender, int age) throws Exception{
        // Calculate the Basal Metabolic Rate (BMR) of a person with the following formula:
	    //For men: BMR = 10 * weight + 6.25 * height - 5 * age + 5
	    // For women: BMR = 10 * weight + 6.25 * height - 5 * age - 161
	  
        
        float BMR = 0;
        
        if(height<=0){
            throw new RuntimeException("Altura introducida no valida: es menor o igual que 0");
        } else if(gender != 'w' && gender != 'm'){
            throw new RuntimeException("Genero introducido no valido");
        }else if( weight <= 0){
            throw new RuntimeException("Peso introducido no valido: es menor o igual que 0");

        }else if(age<=0){
            throw new RuntimeException("Edad introducida no valida: es menor o igual que 0");
        }else{
            if (gender == 'w'){
                BMR = (10f * weight + 6.25f * height - 5f * age - 161f);
            }
            else if (gender == 'm'){
                BMR = (10f * weight + 6.25f * height - 5f * age + 5f);
        }

    }
        
    return BMR;
    }
}
