import java.util.OptionalDouble;
import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double nombre1 = demanderNombre(scanner, "Entrez le premier nombre : ");
        char operateur = demanderOperateur(scanner);
        double nombre2 = demanderNombre(scanner, "Entrez le deuxième nombre : ");

        OptionalDouble resultat = calculer(nombre1, nombre2, operateur);

        if (resultat.isPresent()) {
            System.out.println("Résultat : " + nombre1 + " " + operateur + " " + nombre2 + " = " + resultat.getAsDouble());
        } else {
            System.out.println("Erreur : Impossible d'effectuer l'opération.");
        }

        scanner.close();
    }

    private static double demanderNombre(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.next();
            System.out.print(message);
        }
        return scanner.nextDouble();
    }

    private static char demanderOperateur(Scanner scanner) {
        System.out.print("Entrez un opérateur (+, -, *, /) : ");
        while (!scanner.hasNext("[-+*/]")) {
            System.out.println("Erreur : Opérateur invalide !");
            scanner.next();
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
        }
        return scanner.next().charAt(0);
    }

    private static OptionalDouble calculer(double nombre1, double nombre2, char operateur) {
        return switch (operateur) {
            case '+' -> OptionalDouble.of(nombre1 + nombre2);
            case '-' -> OptionalDouble.of(nombre1 - nombre2);
            case '*' -> OptionalDouble.of(nombre1 * nombre2);
            case '/' -> (nombre2 != 0) ? OptionalDouble.of(nombre1 / nombre2) : OptionalDouble.empty();
            default -> OptionalDouble.empty();
        };
    }
}

