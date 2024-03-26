package uma.healthcalc.BDD;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import healthcalc.HealthCalcImpl;

public class CucumberStep {

    private float weight;
    private int height;
    private char gender;
    private int age;
    private boolean raiseException;
    private float resultado1;
    private float resultado2;

    private HealthCalcImpl calcImpl= new HealthCalcImpl();

    
    //BMR
    @Given("my gender {string}, weight {int}, height {int} and age {int} correctly")
    public void my_gender_weight_height_and_age_correctly(String s, Integer int1, Integer int2, Integer int3) {
        weight= int1;
        height= int2;
        gender=s.charAt(0);
        age= int3;

    }
    @When("I calcule my BMR")
    public void i_calcule_my_BMR() {
        try{ 
            resultado1=calcImpl.basalMetabolicRate(weight,height,gender,age);
        }catch(Exception e){
            raiseException = true;
        }
    }

    @Then("the system return my BMR {float}")
    public void the_system_return_my_BMR(float int1){

        assertEquals(int1,resultado1);
    }
    @Given("at least my gender {string}, weight {int}, height {int} or age {int} incorrectly")
    public void at_least_my_gender_heigth_weight_or_age_incorrectly(String g, Integer h, Integer w, Integer a) {
        weight= w;
        height= h;
        gender=g.charAt(0);
        age= a;
    } 
    @Then("the system raises an exception")
    public void the_system_raises_an_exception() {
        assertEquals(true, raiseException);
    }
    
   
    //idealWeight

    @Given("my gender {string} and height {int} correctly")
    public void my_gender_and_height_correctly(String s, Integer int1) {
        height=int1;
        gender=s.charAt(0);
    }
    @When("I calcule my ideal weight")
    public void i_calcule_my_ideal_weight() {
        try{
            resultado2=calcImpl.idealWeight(height,gender);
        }catch(Exception e){
            raiseException=true;
        }
    }
    @Then("the system return my ideal weight {float}")
    public void the_system_return_my_ideal_weight(float idealw) {
        assertEquals(idealw,resultado2);
        
    }
    @Given("my height {int} in negative or an unrecognizable gender {string}")
    public void my_height_in_negative_or_an_unrecognizable_gender(Integer h, String s) {
        height=h;
        gender=s.charAt(0);
    }
    
    
    
}
    
    