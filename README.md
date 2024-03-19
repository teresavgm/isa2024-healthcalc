# isa2024-healtcalc
Health calculator

# PRACTICA 2
-------

## Casos de Uso
___

![](https://github.com/teresavgm/isa2024-healthcalc/blob/practica2/doc/CasosDeUso.JPG?raw=true)


## Especificacion de un caso de uso:   

**Nombre:** Calcular Ideal Weight

**Actor principal:** Usuario

**Ambito:** Aplicacion

**Nivel:** user goal

**Stakeholders and Interests:**


- El usuario: quiere saber su peso ideal.
- Sistema sanitario: quiere saber ese dato del paciente

**Precondition:** 

El usuario esta dentro de la aplicacion

**Garantias minimas:** toda la informacion introducida por el paciente es completamente cofidencial y no podra ser utilizada para ningun otro fin que el especificado.

**Garantias de exito:** Se habra podido calcular de manera correcta el peso ideal del paciente y dicha informacion llegara a los dos stakeholders.

**Escenario:**

1. El usuario elige calcular su peso ideal en la aplicacion.
2. El sistema le pide que introduzca su altura y su genero. 
3. El sistema aplica la formula segun el genero introducido.
4. El sistema devuelve el resultado.

**Escenarios Alternativos:**

2a. El usuario introduce unos datos no validos.

2a1. El usuario introduce mal sus datos.

**Extensiones:**

1a. El usuario quiere repetir el proceso.

1a1. El usuario sale de la pagina.










# PRACTICA 1
---


## Casos de Prueba
___

### Tests para el Metodo idealWeight

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'w' o 'f'. En caso contrario se lanzara una excepcion.

4. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

5. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.





### Tests para el Metodo basalMetabolicRate

1. **Altura Positiva**: Comprobamos que el valor de la altura sea positivo. En caso contrario se lanzara una excepcion.

2. **Altura distinta de cero**: Comprobamos que el valor de la altura sea distinto de 0. En caso contrario se lanzara una excepcion.

3. **Genero distinto de 'm' y de 'w'**: Comprobamos que el genero introducido sea 'w' o 'f'. En caso contrario se lanzara una excepcion.

4. **Peso igual que 0**: Comprobamos que el valor del peso sea distinto de 0. En caso contrario se lanzara una excepcion.

5. **Peso menor que 0**:Comprobamos que el valor del peso sea mayor que 0. En caso contrario se lanzara una excepcion.

6. **Valor correcto 'w'**: comprobamos que se hayan realizado los calculos correctamente para las mujeres.

7. **Valor correcto 'm'**: comprobamos que se hayan realizado los calculos correctamente para los hombres.rrectamente.




