import java.util.Scanner;  // Importation de la classe Scanner

public class Calculatrice {
    public static void main(String[] args) {
        // Créer un objet Scanner pour lire les entrées de l'utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur de saisir le premier nombre
        System.out.print("Entrez le premier nombre : ");
        double num1 = scanner.nextDouble();

        // Demander à l'utilisateur de saisir le deuxième nombre
        System.out.print("Entrez le deuxième nombre : ");
        double num2 = scanner.nextDouble();

        // Demander à l'utilisateur de saisir l'opérateur
        System.out.print("Entrez l'opérateur (+, -, *, /) : ");
        char operation = scanner.next().charAt(0);  // On récupère le premier caractère

        // Afficher la confirmation de la saisie
        System.out.println("Vous avez entré : " + num1 + " " + operation + " " + num2);

        // Fermer le scanner
        scanner.close();
    }
}
