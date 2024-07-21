public class main{
    public static void main(String[] args) {
        MatrizQuadradaOtimizada matA = new MatrizQuadradaOtimizada(3);
        long startTime = System.nanoTime();
        matA.inicializaRandomico();
        //matA.inicializaManual();
		matA.imprime();
		System.out.println("O determinante eh " + matA.detLaPlace());
        long stopTime = System.nanoTime();
        long executionTime = stopTime - startTime;
        System.out.println(executionTime);
    }
}