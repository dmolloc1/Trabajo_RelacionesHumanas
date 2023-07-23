import java.util.Scanner;

public class CalculadoraNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de notas que va a ingresar: ");
        int numNotas = scanner.nextInt();
        scanner.nextLine();
        double sumaPesos = 0.0;
        double sumaNotasPesadas = 0.0;
        
        for (int i = 1; i <= numNotas; i++) {
            System.out.print("Ingrese la nota " + i + ": ");
            double nota = scanner.nextDouble();
            System.out.print("Ingrese el peso de la nota " + i + " (en %): ");
            double peso = scanner.nextDouble();
            sumaPesos += peso;
            sumaNotasPesadas += nota * (peso / 100.0);
            scanner.nextLine();
        }
        if (sumaPesos > 100.0) {
            System.out.println("¡Error! La suma de los pesos de las notas supera el 100%.");
        } else {
            double notaFinal = sumaNotasPesadas / (sumaPesos / 100.0);
            System.out.println("La nota final con los datos brindados es: " + notaFinal);
        }
        scanner.close();
    }
}
