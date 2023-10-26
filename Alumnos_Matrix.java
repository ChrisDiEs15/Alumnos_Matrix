package alumnos_matrix;
import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author cdiaz
 */
public class Alumnos_Matrix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /**/
        Scanner fila = new Scanner(System.in);
        Scanner columna = new Scanner(System.in);
        Scanner cantidadAlumnos = new Scanner(System.in);
        System.out.println("Programa para crear alumnos y `guardarlos en una matriz");
        System.out.println("Por favor inserte el numero de filas que va a contener la matriz");
        int filaMatriz = fila.nextInt();
        System.out.println("Por favor inserte el numero de columnas que va a contener la matriz");
        int columnaMatriz = columna.nextInt();
        System.out.println("Por favor inserte el numero de alumnos a guardar ");
        int numeroAlumnos = cantidadAlumnos.nextInt();

        /*
        until finish the capture use alumnos Saved for read and write anywhere in the matrix*/
        AlumnosConstructor[] alumnosSaved = CrearNuevoAlumno(numeroAlumnos);
        /*await until CrearAlumno finish to run manual matrix*/
        ManualMatrix(alumnosSaved, filaMatriz, columnaMatriz);

    }

    public static AlumnosConstructor[] CrearNuevoAlumno(int numeroAlumnos) {
        /*create an temp array for save the alumnos return this array for use in manual sort*/
        AlumnosConstructor[] nuevoAlumno;
        nuevoAlumno = new AlumnosConstructor[numeroAlumnos];
        /*Array for store the cal*/
        float[] nuevo = new float[6];
        /*Temp variables*/
        String nombreTemporal = "";
        int numeroDeListaTemporal = 0;
        String cuentaTemporal = "";
        /*Scanner for datos and scanner for array cal */
        Scanner arrayDatos = new Scanner(System.in);
        Scanner datos = new Scanner(System.in);

        /*creates the number of alumnos and store the AlumnosConstructor in array temp*/
        for (int w = 0; w < numeroAlumnos; w++) {
            /*init array for store nuevo alumno*/
            System.out.println("\n Por favor escriba el nombre:");
            nombreTemporal = datos.next();
            System.out.println("\n Por favor escriba el numero de lista:");
            numeroDeListaTemporal = datos.nextInt();
            System.out.println("\n Por favor escriba el numero de cuenta:");
            cuentaTemporal = datos.next();
            System.out.println("\n A continuacion escriba las 6 calificaciones");
            for (int i = 0; i < 6; i++) {
                nuevo[i] = arrayDatos.nextFloat();
            }
            nuevoAlumno[w] = new AlumnosConstructor(nombreTemporal, numeroDeListaTemporal, cuentaTemporal, nuevo);
        }

        System.out.println("" + numeroAlumnos + " alumnos han sido guardados exitosamente");
        /*returns the array created*/
        return nuevoAlumno;

    }

    public static void ManualMatrix(AlumnosConstructor[] alumnos, int filas, int columnas) {
        /*Creates a Scanner for introduce manual sapce of array selection*/
        Scanner seleccion = new Scanner(System.in);
        /*calculate the spaces in a matrix*/
        int cantidadDeEspacio = (filas * columnas);
        /*creates an bi-dimensional array for store mi AlumnosConstructor Object*/
        Object[][] alumnosMatrix;
        alumnosMatrix = new Object[filas][columnas];
        /*fill the matrix with zeros to initialize*/
        for (int i = 0; i < filas; i++) {
            /*method.fill is a java method for fill the array with any type of dato*/
            Arrays.fill(alumnosMatrix[i], 0);
        }

        /*sout after creates the matrix and fill each row in zeros*/
        System.out.println("Se ha creado una matriz de " + filas + " filas y " + columnas + " columnas");
        /*Print the init array in 0  */
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(alumnosMatrix[i][j] + " ");
            }
            System.out.println(); 
        }
        /**/
        System.out.println("Existen" + cantidadDeEspacio + "lugares para guardar datos");
        System.out.println("Existen" + alumnos.length + "datos para guardar");
        /*iterates over the alumnos length*/
        for (int k =0; k < alumnos.length; k++){
        System.out.println("Indique la fila en la que le gustaria guardar el "+k+" dato");
        int filaSelected = seleccion.nextInt();
        System.out.println("indique la columna en la que le gustaria guardar el "+k+" dato ");
        int columnaSelected = seleccion.nextInt();
        /*Store in selected space*/
        alumnosMatrix[filaSelected][columnaSelected]=alumnos[k];
        /*Print the init array filled*/
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(alumnosMatrix[i][j].getClass() + " ");
            }
            System.out.println(); 
        }
        
        }
        

    }

}
