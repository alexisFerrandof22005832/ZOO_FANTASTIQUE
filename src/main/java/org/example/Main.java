// Importations des classes nécessaires
import org.example.manager.CreatureManager;
import org.example.manager.ZooManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe principale de l'application
public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Thread> creatureThreads = new ArrayList<>();  // Liste de threads pour les créatures
    static Enclosure sansEnclos = new Enclosure("Sans Enclos", 150, 4, Cleanliness.BON);  // Enclos par défaut
    static List<Enclosure> enclosureList = new ArrayList<>();  // Liste des enclos dans le zoo
    static CreatureManager creatureManager = new CreatureManager(sansEnclos);  // Gestionnaire de créatures
    public static ZooManager zooManager = new ZooManager();  // Gestionnaire de zoo
    static Zoo zoo = null;  // Instance du zoo

    // Méthode principale
    public static void main(String[] args) throws InterruptedException {
        int mainChoice;

        // Initialisation du zoo en utilisant le gestionnaire de zoo
        zoo = zooManager.displayZooCreationMenu();
        System.out.println("Maintenant, créez un nouvel enclos dans votre zoo");
        zooManager.addEnclosure();

        // Boucle principale du programme
        do {
            if (zoo != null) { // Vérifiez si le zoo n'est pas nul

                // Affiche le menu principal et attend l'entrée de l'utilisateur
                zooManager.displayMainMenu(zoo);
                mainChoice = scanner.nextInt();

                // Traitement en fonction du choix de l'utilisateur
                switch (mainChoice) {
                    case 1:
                        zooManager.runCreatureMenu();
                        break;
                    case 2:
                        zooManager.runEnclosureMenu();
                        break;
                    case 3:
                        // Ajouter la logique pour simuler le passage du temps
                        System.out.println("Simulation du passage du temps...");
                        startCreatureThreads(); // Démarrer les threads des créatures
                        break;
                    case 4:
                        stopCreatureThreads(); // Arrêter les threads des créatures avant de quitter
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir à nouveau.");
                }
            } else {
                // Gère le cas où le zoo est nul
                System.out.println("Zoo non créé. Veuillez créer un zoo avant de choisir d'autres options.");
                mainChoice = 1; // Définit une valeur par défaut pour continuer la boucle
            }
        } while (mainChoice != 4);

        creatureManager.closeScanner();  // Ferme le scanner utilisé pour les entrées utilisateur
        System.exit(0); // 0 indique une sortie normale
    }

    // Méthode pour démarrer les threads des créatures
    private static void startCreatureThreads() {
        for (Creature creature : creatureManager.getCreatures()) {
            Thread creatureThread = new Thread(creature);
            creatureThreads.add(creatureThread);
            creatureThread.start();
        }
    }

    // Méthode pour arrêter les threads des créatures
    private static void stopCreatureThreads() {
        for (Thread thread : creatureThreads) {
            thread.interrupt();
        }
    }
}
