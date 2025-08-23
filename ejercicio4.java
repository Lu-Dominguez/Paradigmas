package ejercicios_practica;

public class ejercicio4 {

    public static void main(String[] args) {
        int[][] mat3 = {
            {1, 1, 3, 3},
            {4, 6, 9, 1},
            {2, 6, 6, 9}
        };

        // Llamo al método y le paso la matriz
        modasPorFila(mat3);
    }

    public static void modasPorFila(int[][] mat) {

    int f = mat.length;
    int c = mat[0].length;

    int moda, maxFrecuencia, actual, frecuencia;

    int[] vec = new int[f];

    for(int i = 0; i < f; i++) 
    {
            moda = mat[i][0]; //tomo al primer elemento como moda inicial
            maxFrecuencia = 0;

            for(int j = 0; j < c; j++) 
            {
                actual = mat[i][j];
                frecuencia = 0;

                for(int k = 0; k < c; k++) 
                {
                    if(mat[i][k] == actual) 
                    {
                        frecuencia++;
                    }
                }

                if(frecuencia > maxFrecuencia || (frecuencia == maxFrecuencia && actual > moda)) 
                {
                    maxFrecuencia = frecuencia;
                    moda = actual;
                }
            }

            vec[i] = moda;
        }

        System.out.println("Vector de modas:");
        for(int i = 0; i < f; i++) 
        {
            System.out.print(vec[i] + " ");
        }
    }
}