# isa2024-healtcalc
Health calculator

# PRACTICA 3


## User Story: BMR

**As a** user

**I want** to calculate my basal metabolic rate (BMR)

**So that** from it I can take steps to be healthier
______

**Acceptance Criteria**
_____
_____


**Scenario 1:** I give the program the correct parameters


**Given** my gender, weight, height and age

**When** I calculate my BMR

**Then** the system return my BMR

_______________________

**Scenario 2:** I give the program incorrect parameters


**Given** at least my gender, weight, height or age incorrectly

**When** I calculate my BMR

**Then** the system raises an exception




## User Story: ideal Weight

**As a** user

**I want** to calculate my ideal weight

**So that** I could control my weight and take steps to be healthier
_____________

**Acceptance Criteria**
_____
_____


**Scenario 1:** I give the program the correct parameters


**Given** my gender and height

**When** I calculate my ideal weight

**Then** the system return my ideal Weight

_________________

**Scenario 2:** I give the program the incorrect parameters


**Given** my height in negative or an unrecognizable gender

**When** I calculate my ideal Weight

**Then** the system raises an exception








# Casos de Prueba
___

## Tests para el Metodo idealWeight

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'w' o 'w'. En caso contrario se lanzara una excepcion.

4. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

5. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.





## Tests para el Metodo basalMetabolicRate

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'w' o 'w'. En caso contrario se lanzara una excepcion.

4. **Peso igual que 0**: Comprobamos que el valor del peso sea distinto de 0. En caso contrario se lanzara una excepcion.

5. **Peso menor que 0**:Comprobamos que el valor del peso sea mayor que 0. En caso contrario se lanzara una excepcion.

6. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

7. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.rrectamente.


