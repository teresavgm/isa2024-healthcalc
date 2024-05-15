package healthcalc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests para la calculadora de salud.")

public class HealthCalcTest {

	@Test
	@DisplayName("Esto es un test de ejemplo.")
	public void bmi() {
		assertEquals(true, true);
	}

	//Metodo idealWeight


	//1. Altura negativa
	@Test
	public void alturaNegIW() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 23, -165, 23 );
				assertThrows(RuntimeException.class, () -> hclc.idealWeight(p));
	}

	//2. Altura distinta de 0
	@Test
	public void altura0() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 0, 0, 23 );

		assertThrows(RuntimeException.class, () -> hclc.idealWeight(p));
	}

	//3. Genero distinto de 'm' y de 'w'
	@Test
	public void generoDistinto() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(null, 127, 165, 23 );

		assertThrows(RuntimeException.class, () -> hclc.idealWeight(p));
	}

	//4. Valor correcto, 'w'
	@Test
	public void ValorCorrectoWIW(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.FEMALE, 23, 164, 23 );

		try {
			assertEquals(58.4, hclc.idealWeight(p), 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

	//5. Valor correcto, 'm'

	@Test
	public void ValorCorrectoMIW(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 75, 175, 23 );

		try {
            assertEquals(69, hclc.idealWeight(p), 0.0001);
		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}



	//1. Altura no negativa basalMetabolicRate
	@Test
	public void alturaNegBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 17, -160, 52 );
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(p));	
	}

	//2. Altura distinta de 0 basalMetabolicRate
	@Test
	public void altura0BMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 86, 0, 74 );
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(p));	
	}

	//3. Genero distinto de 'w' y de 'm'
	@Test
	public void generoDistintoBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(null, 17, 160, 52 );

		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(p));	
	}


	//4. Peso igual que 0
	@Test
	public void peso0BMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 34, 192, 0 );

		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(p));	
	}


	//5. Peso menor que 0 basalMetabolicRate
	@Test
	public void pesoNegBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		Paciente p = new Paciente(Gender.MALE, 17, 180, -52 );
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(p));	
	}


	//6. Valor correcto, 'w'
	@Test
	public void ValorCorrectoWIWbmr(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
        
		try {
			Paciente p = new Paciente(Gender.FEMALE, 42, 165, 45 );
			float resultado = hclc.basalMetabolicRate(p);
			assertEquals(1110.25, resultado, 0.0001);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}
	

	//7. Valor correcto, 'm'
	@Test
	public void ValorCorrectoMIWbmr(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
        
		try {
			Paciente p = new Paciente(Gender.MALE, 6, 110, 24 );
			float resultado = hclc.basalMetabolicRate(p);
            assertEquals(902.5, resultado, 0.0001);

		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}


	