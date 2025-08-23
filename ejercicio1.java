/*Escribir un método en Java que permita comprobar si la diagonal principal de una matriz 
cuadrada de enteros tiene en cada posición un valor igual a la suma de todos los valores
 de las posiciones anteriores de dicha diagonal. */
package ejercicios_practica;

public class ejercicio1 {
    public static void main(String[] args) {
        int mat[][] = {
            {1, 2, 5},
            {3, 1, 7},
            {4, 2, 2}
        };

        if(calcularDiagonal(mat))
        {
            System.out.println("La diagonal cumple");
        }
        else
        {
            System.out.println("La diagonal no cumple");
        }
    }

    public static boolean calcularDiagonal(int mat[][]) {

        int f = mat.length;

        int suma = mat[0][0];

        for(int i=1; i< f; i++)
        {
            if(mat[i][i] == suma)
            {
                suma += mat[i][i];
            }
            else
                return false;
        }

        return true;

    }

}

