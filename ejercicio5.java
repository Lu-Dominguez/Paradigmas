/*Escribir un método en Java que de una matriz cuadrada dada de dimensión nxn, 
devuelva una matriz con 2n-1 filas, donde cada una tendrá los datos de una de las diagonales
 (de abajo a la izquierda hacia arriba a la derecha) 
 00 01 02
 10 11 12
 20 21 22*/
package ejercicios_practica;

public class ejercicio5 {

    public static void main(String argv[])
    {
        int mat[][]  = {
            {1, 1, 3},
            {4, 6, 9},
            {2, 6, 6}
        };

        int matResu[][] = ejer5(mat);
        int f = matResu.length;
        int c = matResu[0].length;

        for(int i = 0; i < f; i++)
        {
            for(int j = 0; j < matResu[i].length; j++)
            {
                System.out.print(matResu[i][j] + " ");
            }
            System.out.println();
        }


    }

    public static int[][] ejer5(int mat[][])
    {
        int n = mat.length;
        int f = (2 * n)-1;
        int c = mat[0].length;

        int resu[][] = new int[f][c];

        for(int k = 0; k< f; k++)
        {
            int tamFil = (k<n)? (k+1) : (2 * n -1-k);
            resu[k] = new int[tamFil];

            int i = (k<n) ? (n-1-k) : 0;
            int j = (k<n) ? 0 : (k-n+1);

            int pos = 0;

            while(i<n && j<n)
            {
                resu[k][pos++] = mat[i][j];
                i++;
                j++;
            }
        }
        return resu;

    }
    
}
