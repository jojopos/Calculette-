import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double nombre1 = demanderNombre(scanner, "Entrez le premier nombre : ");
        double nombre2 = demanderNombre(scanner, "Entrez le deuxième nombre : ");
        char operateur = getValidOperator(scanner);
        
        double resultat = calculerResultat(nombre1, nombre2, operateur);
        
        System.out.println("Résultat : " + nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);
        
        scanner.close();
    }
    
    private static double demanderNombre(Scanner scanner, String message) {
        double nombre;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                nombre = scanner.nextDouble();
                scanner.nextLine(); // Pour consommer la fin de ligne
                return nombre;
            } else {
                System.out.println("Erreur : Veuillez entrer un nombre valide !");
                scanner.next(); // Efface l'entrée incorrecte et permet de recommencer
            }
        }
    }
    
    private static char getValidOperator(Scanner scanner) {
        char operateur;
        while (true) {
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
            String input = scanner.next();
            
            if (input.length() == 1) {
                operateur = input.charAt(0);
                if (operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/') {
                    return operateur;
                }
            }
            System.out.println("Erreur : Opérateur invalide ! Veuillez entrer +, -, * ou /.");
        }
    }
    
    private static double calculerResultat(double nombre1, double nombre2, char operateur) {
        switch (operateur) {
            case '+':
                return nombre1 + nombre2;
            case '-':
                return nombre1 - nombre2;
            case '*':
                return nombre1 * nombre2;
            case '/':
                if (nombre2 == 0) {
                    System.out.println("Erreur : Division par zéro impossible !");
                    return Double.NaN;
                }
                return nombre1 / nombre2;
            default:
                return 0;
        }
    }
}
