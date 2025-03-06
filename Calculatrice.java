import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double nombre1 = demanderNombre(scanner, "Entrez le premier nombre : ", false);
        char operateur = getValidOperator(scanner);
        double nombre2 = demanderNombre(scanner, "Entrez le deuxième nombre : ", operateur == '/');

        double resultat = calculer(nombre1, nombre2, operateur);
        System.out.println("Résultat : " + nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);

        scanner.close();
    }

    // Méthode unique pour demander un nombre (évite la duplication du code)
    private static double demanderNombre(Scanner scanner, String message, boolean verifierDivisionParZero) {
        double nombre;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                nombre = scanner.nextDouble();
                if (!verifierDivisionParZero || nombre != 0) {
                    return nombre;
                }
                System.out.println("Erreur : Division par zéro impossible !");
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                scanner.next(); // Efface l’entrée incorrecte
            }
        }
    }

    // Optimisation avec une seule vérification regex pour l'opérateur
    private static char getValidOperator(Scanner scanner) {
        System.out.print("Entrez un opérateur (+, -, *, /) : ");
        while (!scanner.hasNext("[-+*/]")) {
            System.out.println("Erreur : Opérateur invalide !");
            scanner.next();
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
        }
        return scanner.next().charAt(0);
    }

    // Calcul simplifié
    private static double calculer(double nombre1, double nombre2, char operateur) {
        return switch (operateur) {
            case '+' -> nombre1 + nombre2;
            case '-' -> nombre1 - nombre2;
            case '*' -> nombre1 * nombre2;
            case '/' -> nombre1 / nombre2;
            default -> Double.NaN; // Ne devrait jamais arriver
        };
    }
}
