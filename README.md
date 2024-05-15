# isa2024-healtcalc
# Health calculator


## Práctica 7: Refactorings

### 1. Definimos el char género mediante un Enum

Bad Smell -->  TYPE TESTS
		Para seleccionar el genero utilizamos los caracteres 'w' y 'm', teniendo que comprobar	en todo momento si estos parámetros han sido corrrectamente introducidos. 
		No podemos invocar su comportamiento sin realizar antes algunas comprobaciones, perdiendo de esta manera polimorfismo.


Refactoring --> Replace type code with Enum. Creamos un Enum que incluya las 2 opciones posibles, FEMALE y MALE.


Categoría -->  Attribute refactoring


Cambios realizados --> Se han tenido que cambiar las declaraciones de este parámetro en los 2 métodos que implementa la calculadora,
			idealWeight y basalMetabolicRate, y todas sus variantes en las diferentes interfaces y clases usadas: Adapter, DecoradorAmericano,DecoradorEuropeo,
			DecoradorHealthHospital,HealthCalc, HealthCalcImpl,HealthHospital,HealthStatsProxy. También se han cambiado los tests realizados y el controlador, 
			para a partir de la entrada de la calculadora declarar genero como Gender.FEMALE o Gender.MALE. Ahora en todos estos casos, cuando se recibe un
			parámetro que representa el género en vez de ser un parámetro de tipo char, ahora representa uno de los elementos del tipo enum creado Gender.


Número de cambios manueales--> 11 clases



### 2. Creamos la interface Person

Bad Smell--> LONG PARAMETER LIST/DATA CLUMPS
		En varios métodos, con el objetico final de calcular el BMR de un paciente, se pasa como parámetros la altura, el peso, el género y la edad. 
		De esta manera, se podría considerar que estos métodos reciben demasiados parámetros. Por otra parte, para calcular el peso ideal en diferentes métodos
		se pasan en múltiples veces como parámetros 'altura' y 'genero'. Lo mismo pasa con los 4 parámetros necesarios para calcular la tasa metabólica basal, que se 
		utilizan juntos en muchas ocasiones.


Refactoring --> Introduce Parameter Object. Para resolver este problema introduciremos la clase Paciente que implementa la nueva interfaz introducida Person,
		la cual recogerá los metodos para solicitar estos atributos. De esta manera, cuando se quiera calcular el peso ideal o el BMR se le pasará 
		como parámetro un objetoc de tipo Paciente. A partir de este se pordrán obtener los parametros necesarios.


Categoría --> Class refactoring


Cambios realizados --> se han cambiado los parámetros de todos los métodos cuyo objetivo era calcular el peso ideal o la tasa
			metabolica basal y se han sustituido por  un objeto de tipo Paciente en varias clases.


Número de cambios --> 8



### 3.Creamos las clases CardiovascularMetrics y MetabolicMetrics

Bad Smell--> LARGE/GOD CLASS
	     La clase HealCalcImpl tiene demasiadas responsabilidades al ser enteramente la que lleva a cabo todos los calculos que puede llevar a cabo la calculadora, cayendo
	     en esta toda la responsabilidad.


Refactoring --> Extract(sub)Class


Categoría --> Class refactoring 


Cambios realizados --> Van a ser creadas 2 clases, CardiovascularMetrics y MetabolicMetrics. Cada una tendrá un método para
			calcular el peso ideal y la tasa metabólica basal respectivamente.La clase HealthCalcImpl tendrá como atributo
			un objeto de cada clase para poder dirigir el uso de estas funciones.


Número de cambios --> Se han creado 2 clases, y se ha modificado la clase HealthCalcImpl,3.



## Práctica 6: Patrones de diseño
___
### Implementación del patrón Singleton
Diagrama de clases incluyendo el patrón Singleton, requerido en el ejercicio 2.
![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica6/design_patterns/DiagramaSingleton.PNG?raw=true)


### Implementación del patrón Adapter
En el apartado a del ejercicio 3 he considerado el patrón adapter el más apropiado para la tarea requerida. En el siguiente diagrama de clases ha sido inlcuido dicho patrón:
![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica6/design_patterns/DiagramaAdapter.PNG?raw=true)

### Implementación del patrón Proxy
Seguidamente, en el apartado b del ejercicio 3 he considerado el patrón Proxy el más apropiado para la tarea requerida. En el siguiente diagrama de clases el patrón indicado:
![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica6/design_patterns/DiagramaProxy.PNG?raw=true)

### Implementación del patrón Decorator
Por último, en el apartado c del ejercicio 3 he considerado el patrón Decorator el más apropiado para la tarea requerida. En el siguiente diagrama de clases ha sido inlcuido dicho patrón (además de lo ya implementado anteriormente):
![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica6/design_patterns/DiagramaDecorator.PNG?raw=true)


# Practica 4 
___

## Imagen del boceto inicial de la interfaz


![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica4/Imagenes/BocetoInterfazGrafica.PNG?raw=true)


## Imagen de la interfaz gráfica final

![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica4/Imagenes/InterfazFinal.PNG?raw=true)



# Practica 1


# Casos de Prueba
___

## Tests para el Metodo idealWeight

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'm' o 'w'. En caso contrario se lanzara una excepcion.

4. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

5. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.





## Tests para el Metodo basalMetabolicRate

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'm' o 'w'. En caso contrario se lanzara una excepcion.

4. **Peso igual que 0**: Comprobamos que el valor del peso sea distinto de 0. En caso contrario se lanzara una excepcion.

5. **Peso menor que 0**:Comprobamos que el valor del peso sea mayor que 0. En caso contrario se lanzara una excepcion.

6. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

7. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.rrectamente.




