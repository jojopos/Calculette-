import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demande les nombres
        System.out.print("Entrez le premier nombre : ");
        double nombre1 = scanner.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double nombre2 = scanner.nextDouble();

        // Demande l'opérateur avec validation
        char operateur;
        while (true) { // Boucle infinie jusqu'à ce qu'on ait un opérateur valide
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
            operateur = scanner.next().charAt(0);

            // Vérifie si l'opérateur est valide
            if (operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/') {
                break; // Sort de la boucle si l'opérateur est valide
            } else {
                System.out.println("Erreur : opérateur invalide ! Veuillez entrer +, -, * ou /.");
            }
        }

        // Affichage de la confirmation
        System.out.println("Vous avez entré : " + nombre1 + " " + operateur + " " + nombre2);

        scanner.close();
    }
}