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
		HealthCalcImpl hclc= new HealthCalcImpl();
		assertThrows(RuntimeException.class, () -> hclc.idealWeight(-165, 'm'));
	}

	//2. Altura distinta de 0
	@Test
	public void altura0() {
		HealthCalcImpl hclc= new HealthCalcImpl();
		assertThrows(RuntimeException.class, () -> hclc.idealWeight(0, 'm'));
	}

	//3. Genero distinto de 'm' y de 'w'
	@Test
	public void generoDistinto() {
		HealthCalcImpl hclc= new HealthCalcImpl();
		assertThrows(RuntimeException.class, () -> hclc.idealWeight(167, 'u'));
	}

	//4. Valor correcto, 'w'
	@Test
	public void ValorCorrectoWIW(){
		HealthCalc hclc = new HealthCalcImpl();
        
		try {

			float resultado = hclc.idealWeight(164, 'w');
			assertEquals(58.4, resultado, 0.0001);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}

	//5. Valor correcto, 'm'

	@Test
	public void ValorCorrectoMIW(){
		HealthCalc hclc = new HealthCalcImpl();
        
		try {
            float resultado = hclc.idealWeight(175, 'm');
            assertEquals(68.75, resultado, 0.0001);

		} catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

	}
}


	