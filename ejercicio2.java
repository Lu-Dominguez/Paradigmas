/*Escribir un método en Java que permita comprobar si la multiplicación de todos los valores de una matriz 
numérica, dará 0 o no. */
package ejercicios_practica;

public class ejercicio2 {
    public static void main(String argv[])
    {
        int mat[][] = {
                {1, 2, 3},
                {4, 2, 1},
                {2, 9, 3}
                };


         System.out.println(tieneCero(mat));

    }

    public static boolean tieneCero(int mat[][])
    {
        int f = mat.length;
        int c = mat[0].length;

        for(int i = 0; i<f; i++)
        {
            for(int j=0; j<c; j++)
            {
                if(mat[i][j]==0)
                     return true;
            }
        }

        return false;

    }
}
