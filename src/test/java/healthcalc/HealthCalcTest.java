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
				assertThrows(RuntimeException.class, () -> hclc.idealWeight(-165, 'm'));
	}

	//2. Altura distinta de 0
	@Test
	public void altura0() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.idealWeight(0, 'm'));
	}

	//3. Genero distinto de 'm' y de 'w'
	@Test
	public void generoDistinto() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.idealWeight(167, 'u'));
	}

	//4. Valor correcto, 'w'
	@Test
	public void ValorCorrectoWIW(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
        
		try {
			assertEquals(58.4, hclc.idealWeight(164, 'w'), 1);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

	//5. Valor correcto, 'm'

	@Test
	public void ValorCorrectoMIW(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
        
		try {
            assertEquals(69, hclc.idealWeight(175, 'm'), 0.0001);
		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}



	//1. Altura no negativa basalMetabolicRate
	@Test
	public void alturaNegBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(52, -160, 'm', 17));	
	}

	//2. Altura distinta de 0 basalMetabolicRate
	@Test
	public void altura0BMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(74, 0, 'm', 86));	
	}

	//3. Genero distinto de 'w' y de 'm'
	@Test
	public void generoDistintoBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(52, 160, 'f', 17));	
	}


	//4. Peso igual que 0
	@Test
	public void peso0BMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(0, 192, 'm', 34));	
	}


	//5. Peso menor que 0 basalMetabolicRate
	@Test
	public void pesoNegBMR() {
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
		assertThrows(RuntimeException.class, () -> hclc.basalMetabolicRate(-52, 180, 'm', 17));	
	}


	//6. Valor correcto, 'w'
	@Test
	public void ValorCorrectoWIWbmr(){
		HealthCalcImpl hclc =  HealthCalcImpl.getInstance();
        
		try {

			float resultado = hclc.basalMetabolicRate(45, 165, 'w', 42);
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
			float resultado = hclc.basalMetabolicRate(24, 110, 'm', 6);
            assertEquals(902.5, resultado, 0.0001);

		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

}


	