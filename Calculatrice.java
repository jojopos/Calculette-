import java.util.Scanner;

public class Calculatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double nombre1, nombre2, resultat = 0;
        char operateur;
        boolean operateurValide;

        // Saisie des nombres
        System.out.print("Entrez le premier nombre : ");
        while (!scanner.hasNextDouble()) { 
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.next(); // Efface l'entrée incorrecte
            System.out.print("Entrez le premier nombre : ");
        }
        nombre1 = scanner.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        while (!scanner.hasNextDouble()) { 
            System.out.println("Erreur : Veuillez entrer un nombre valide !");
            scanner.next(); 
            System.out.print("Entrez le deuxième nombre : ");
        }
        nombre2 = scanner.nextDouble();

        // Saisie et validation de l'opérateur
        do {
            System.out.print("Entrez un opérateur (+, -, *, /) : ");
            operateur = scanner.next().charAt(0);

            operateurValide = (operateur == '+' || operateur == '-' || operateur == '*' || operateur == '/');
            
            if (!operateurValide) {
                System.out.println("Opérateur invalide, veuillez réessayer.");
            }
        } while (!operateurValide);

        // Effectuer le calcul
        switch (operateur) {
            case '+':
                resultat = nombre1 + nombre2;
                break;
            case '-':
                resultat = nombre1 - nombre2;
                break;
            case '*':
                resultat = nombre1 * nombre2;
                break;
            case '/':
                if (nombre2 == 0) {
                    System.out.println("Erreur : Division par zéro impossible !");
                    scanner.close();
                    return;
                }
                resultat = nombre1 / nombre2;
                break;
        }

        // Affichage du résultat
        System.out.println("Résultat : " + nombre1 + " " + operateur + " " + nombre2 + " = " + resultat);

        scanner.close();
    }
}
