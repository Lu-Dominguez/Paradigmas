/*Escribir un método en Java que de una matriz numérica dada, devuelva una matriz con la misma cantidad 
de elementos, pero donde cada valor es la suma de sus adyacentes originales (arriba, abajo, izquierda,
 y derecha; si existen) 
 00 01 02
 10 11 12
 20 21 22*/

package ejercicios_practica;

public class ejercicio3 {
    public static void main(String argv[])
    {
        int mat[][] = {
                {1, 2, 3},
                {4, 2, 1},
                {2, 9, 3}
                };

         int[][] resultado = sumaDeAdy(mat);

        for(int i = 0; i < resultado.length; i++) 
        {
            for(int j = 0; j < resultado[0].length; j++) 
            {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] sumaDeAdy(int mat[][])
    {
        int f = mat.length;
        int c = mat[0].length;
        int suma;
        int matTemp[][] = new int[f][c];

        for(int i = 0; i<f; i++)
        {
            for(int j =0; j<c; j++)
            {
                suma = 0;
                if(i>0)
                {
                    suma += mat[i-1][j];
                }
                if(j>0)
                {
                    suma+= mat[i][j-1];
                }
                if(j < c-1)
                {
                    suma += mat[i][j+1];
                }
                if(i < f-1)
                {
                    suma += mat[i+1][j];
                }

                matTemp[i][j] = suma;
            }
        }
        return matTemp;
    }
}
