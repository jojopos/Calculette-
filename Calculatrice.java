import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demande les deux nombres à l'utilisateur
        double nombre1 = demanderNombre(scanner, "Entrez le premier nombre : ");
        double nombre2 = demanderNombre(scanner, "Entrez le deuxième nombre : ");

        // Demande un opérateur valide
        char operateur = getValidOperator(scanner);

        // Effectue le calcul
        double resultat = calculer(nombre1, nombre2, operateur);

        // Affiche le résultat
        System.out.println("Résultat : " + nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);

        scanner.close();
    }

    // Méthode pour demander un nombre valide
    private static double demanderNombre(Scanner scanner, String message) {
        System.out.print(message);
        while (!scanner.hasNextDouble()) {
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.next(); // Efface l'entrée incorrecte
            System.out.print(message);
        }
        return scanner.nextDouble();
    }

    // Méthode pour demander un opérateur valide
    private static char getValidOperator(Scanner scanner) {
        System.out.print("Entrez un opérateur (+, -, *, /) : ");
        while (!scanner.hasNext("[-+*/]")) {
            System.out.println("Erreur : opérateur invalide ! Veuillez entrer +, -, * ou /.");
            scanner.next(); // Efface l'entrée incorrecte
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
        }
        return scanner.next().charAt(0);
    }

    // Méthode pour effectuer le calcul
    private static double calculer(double nombre1, double nombre2, char operateur) {
        switch (operateur) {
            case '+': return nombre1 + nombre2;
            case '-': return nombre1 - nombre2;
            case '*': return nombre1 * nombre2;
            case '/': 
                if (nombre2 == 0) {
                    System.out.println("Erreur : Division par zéro impossible !");
                    return Double.NaN; // Retourne une valeur spéciale pour indiquer une erreur
                }
                return nombre1 / nombre2;
            default:
                System.out.println("Erreur inattendue !");
                return Double.NaN;
        }
    }
}
