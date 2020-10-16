
public class Ejercicio2 {

	public static void main (String[] args){
		
		double array_doubles [] = new double [500];
		for (int i = 0; i < 500; i++){
		 array_doubles [i] = 7 * i;
		}
		
		/*
		 * En el main declara un arreglo de variables double
		 * y la llena con multiplos de 7 * el indice
		 * 
		 */
		for (int i = 0; i < 600; i = i + 25){
		/*
		 * en el for se recorre hasta el 600  pasos de 25 unidades
		 * se hace de 600 intencionalmente fuera del limite del indice
		 * del arreglo para ejemplificar las excepciones
		 */
			try {
		 System.out.println ("El elemento en " + i + " es "
		 + acceso_por_indice (array_doubles, i));
		/*
		 * en el bloque try intenta traer el valor del arreglo mediante el
		 * metodo acceso por indice, si el metodo puede hacerlo se imprimran
		 * en pantalla la leyenda y los datos
		 */
			}
		catch (Exception e){
		 System.out.println (e.toString());
		/*
		 * en el bloque catch , es decir en caso de que se lance una excepcion, se imprimira el metodo tostring
		 * de la excepcion, en este caso se hizo override del metodo que aparece mas adelante
		 */
		}
		}
	}
	
	public static double acceso_por_indice(double[] v, int indice)
			throws IndiceFueraDeRangoExcepcion {
		/*se declara un metodo que recibe el arreglo de double asi como el numero del indice
		 * y se especifica que puede lanzar una excepcion de una clase que se declara
		 * mas adelante y que hereda de la clase excepction.
		 */
			try {
			 if ((0 <= indice) && (indice < v.length)) {
			 return v[indice];
			 /*
			  * en el bloque try revisa que el indice este entre 0 y la longitud del arregelo si es asi regresa el 
			  * valor del arreglo correspondiente al indice
			  */
			 } else {
				 
			 throw new IndiceFueraDeRangoExcepcion("El indice " + indice +"no es una posicion valida");
			 /*
			  * si no esta dentro de los indices posibles, lanza una instancia de la clase
			  * IndiceFueraDeRango con un argumento tipo String
			  */
			 }
			 } catch (IndiceFueraDeRangoExcepcion mi_excepcion) {
			
			 System.out.println(mi_excepcion.toString());
			 System.out.println(mi_excepcion.getMessage());
			 throw mi_excepcion;
			 /*
			  * en el bloque catch atrapa la excepcion y utiliza
			  * los metodos de la clase que heredo de exception , ToString y GetMessage}
			  */
			 } 
	}
}


class IndiceFueraDeRangoExcepcion extends Exception{
/*
 * declara una clase que hereda de la clase exception
 */
public IndiceFueraDeRangoExcepcion (){
super();
}
/*
 * incluye un constructor sin argumentos
 */

public IndiceFueraDeRangoExcepcion (String s){
super(s);
}
/*
 * asi como un constructor con un argumento tipo String
 */
public String toString (){
return ("Se ha producido la excepcion " + this.getClass().getName() +
"\n" +
"Con el siguiente mensaje: " + this.getMessage() + "\n");
	}
/*
 * y redefine el metodo toString utilizando parametros de la clase padre excelption
 */
}


