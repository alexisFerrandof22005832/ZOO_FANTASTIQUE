package org.example.manager;

import org.example.Cleanliness;
import org.example.Creature;
import org.example.Enclosure;
import org.example.Zoo;
import org.example.ZooKeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Cette classe gère la création d'un zoo fantastique.
 */
public class ZooManager {

    private static ZooKeeper zooKeeper;
    private static Zoo zoo;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Enclosure> enclosureList = new ArrayList<>();

    static Enclosure sansEnclos = new Enclosure("Sans Enclos", 150, 4, Cleanliness.BON);
    static CreatureManager creatureManager = new CreatureManager(sansEnclos);

    /**
     * Demande et renvoie le nom du zoo saisi par l'utilisateur.
     *
     * @return Le nom du zoo.
     */
    public static String setName() {
        System.out.print("Nom du zoo : ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty() || name.isBlank()) {
            System.out.println("Il faut donner un nom au zoo !");
            System.out.print("Nom du zoo : ");
            name = scanner.nextLine().trim();
        }
        System.out.println("Nom du zoo : " + name);
        return name;
    }

    /**
     * Demande et renvoie le nombre maximum d'enclos saisi par l'utilisateur.
     *
     * @return Le nombre maximum d'enclos.
     */
    private static int setMaxEnclosures() {
        System.out.print("Nombre maximum d'enclos (defaut = 10) : ");
        String maxEnclosuresInput = scanner.nextLine().trim();
        if (!maxEnclosuresInput.isEmpty()) {
            while (!isNumeric(maxEnclosuresInput)) {
                System.out.println("Veuillez entrer un nombre entier.");
                System.out.print("Nombre maximum d'enclos (defaut = 10) : ");
                maxEnclosuresInput = scanner.nextLine().trim();
            }
            System.out.println("Nombre maximum d'enclos : " + maxEnclosuresInput);
            return Integer.parseInt(maxEnclosuresInput);
        }
        System.out.println("Nombre maximum d'enclos par défaut : 10");
        return 10;
    }

    /**
     * Vérifie si la chaîne donnée est numérique.
     *
     * @param str La chaîne à vérifier.
     * @return true si la chaîne est numérique, sinon false.
     */
    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }

    /**
     * Affiche le menu principal du zoo fantastique.
     */
    public void displayMainMenu(Zoo zoo) {
        System.out.println("===== Bienvenue chez le Zoo " + zoo.getName() + " =====");
        System.out.println("1. Gérer les créatures");
        System.out.println("2. Gérer les enclos");
        System.out.println("3. Simuler le passage du temps");
        System.out.println("4. Quitter");
        System.out.print("Choisissez une option : ");
    }

    public static void displayCreatureMenu() {
        System.out.println("===== Gérer les Créatures =====s");
        System.out.println("1. Afficher les créatures");
        System.out.println("2. Ajouter une créature");
        System.out.println("4. Retour au menu principal");
    }

    /**
     * Affiche le menu de gestion des enclos.
     */
    public static void displayEnclosureMenu() {
        System.out.println("===== Gérer les Enclos =====");
        System.out.println("1. Afficher les enclos");
        System.out.println("2. Ajouter un enclos");
        System.out.println("3. Rentrer dans un enclos");
        System.out.println("4. Retour au menu principal");
    }

    /**
     * Affiche le menu de création des créatures.
     */
    public void afficherMenuCreationCreature() {
        System.out.println("1. Dragon");
        System.out.println("2. Kraken");
        System.out.println("3. Megalodons");
        System.out.println("4. Mermaids");
        System.out.println("5. Nymph");
        System.out.println("6. Phenix");
        System.out.println("7. Unicorne");
        System.out.println("8. Retour au menu Gestion Creature");
    }

    public void addEnclosure() {
        if (zoo != null) { // Vérifiez si zoo n'est pas null avant d'ajouter un enclos
            System.out.print("Nom de l'enclos : ");
            String enclosureName = scanner.next();

            System.out.print("Superficie de l'enclos (mètres carrés) : ");
            double enclosureArea = scanner.nextDouble();

            System.out.print("Capacité maximale de l'enclos : ");
            int maxCapacity = scanner.nextInt();

            Enclosure newEnclosure = new Enclosure(enclosureName, enclosureArea, maxCapacity, Cleanliness.BON);
            enclosureList.add(newEnclosure);
            zoo.addEnclosure(newEnclosure);

            System.out.println("Enclos ajouté avec succès !");
        }
    }

    public void displayEnclosureNames(List<Enclosure> enclosureList) {
        System.out.println("Liste des enclos :");
        System.out.println(enclosureList.size());

        for (int i = 0; i < enclosureList.size(); i++) {
            Enclosure enclosure = enclosureList.get(i);
            System.out.println((i + 1) + ". " + enclosure.getName());
        }
    }

    public void displayEnclosureDetails(int enclosureIndex) {
        if (enclosureIndex >= 0 && enclosureIndex < enclosureList.size()) {
            Enclosure enclosure = enclosureList.get(enclosureIndex);
            System.out.println("Détails de l'enclos " + enclosure.getName() + " :");
            enclosure.displayInfo();
        } else {
            System.out.println("Index d'enclos invalide.");
        }
    }

    /**
     * Exécute le menu de gestion des créatures.
     */
    public void runCreatureMenu() {
        int creatureChoice;

        do {
            displayCreatureMenu();
            System.out.print("Choisissez une option : ");
            creatureChoice = scanner.nextInt();

            switch (creatureChoice) {
                case 1:
                    System.out.println("Affichage des créatures...");
                    creatureManager.displayCreatures();
                    break;
                case 2:
                    System.out.println("Ajout d'une créature...");
                    creatureManager.addCreatureFromUserInput();
                    break;
                case 3:
                    System.out.println("Soigner une créature...");
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        } while (creatureChoice != 4);
    }

    /**
     * Exécute le menu de gestion des enclos.
     */
    public void runEnclosureMenu() {
        int enclosureChoice;

        do {
            displayEnclosureMenu();
            System.out.print("Choisissez une option : ");
            enclosureChoice = scanner.nextInt();

            switch (enclosureChoice) {
                case 1:
                    // Afficher les noms des enclos
                    displayEnclosureNames(enclosureList);

                    // Laisser l'utilisateur choisir un enclos pour afficher les détails
                    System.out.print("Choisissez un enclos pour afficher les détails (0 pour revenir) : ");
                    int selectedEnclosureIndex = scanner.nextInt() - 1;

                    if (selectedEnclosureIndex >= 0 && selectedEnclosureIndex < enclosureList.size()) {
                        displayEnclosureDetails(selectedEnclosureIndex);
                    } else if (selectedEnclosureIndex != -1) {
                        System.out.println("Index d'enclos invalide.");
                    }
                    break;
                case 2:
                    // Ajouter la logique pour ajouter un enclos
                    System.out.println("Ajout d'un enclos...");
                    addEnclosure();
                    break;
                case 3:
                    // entrer dans un enclos
                    displayEnclosureNames(enclosureList);
                    System.out.print("Choisissez un enclos pour entrer (0 pour revenir) : ");
                    int selectedEnclosureIndex2 = scanner.nextInt() - 1;

                    if (selectedEnclosureIndex2 >= 0 && selectedEnclosureIndex2 < enclosureList.size()) {
                        runInsideEnclosureMenu(selectedEnclosureIndex2);
                    } else if (selectedEnclosureIndex2 != -1) {
                        System.out.println("Index d'enclos invalide.");
                    }
                    break;
                case 4:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }
        } while (enclosureChoice != 4);
    }

    private void runInsideEnclosureMenu(int enclosureIndex) {
        int choice;

        do {
            if (enclosureIndex >= 0 && enclosureIndex < enclosureList.size()) {
                displayInsideEnclosureMenu();
                Enclosure enclosure = enclosureList.get(enclosureIndex);
                System.out.print("Choisissez une option : ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Quelle créature souhaitez-vous retirer :");
                        enclosure.displayCreaturesList();
                        creatureManager.removeCreatureFromEnclosure(enclosure);
                        break;
                    // Ajoutez d'autres cas selon les besoins
                    case 2:
                        System.out.println("Quelle créature souhaitez-vous Nourir :");
                        enclosure.displayCreaturesList();
                        feedCreature(enclosure);
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir à nouveau.");
                        break;
                }
            } else {
                System.out.println("Index d'enclos invalide.");
                choice = -1; // Pour continuer la boucle
            }
        } while (choice != 3);
    }

    private void displayInsideEnclosureMenu() {
        System.out.println("===== Gérer l' Enclos =====");
        System.out.println("1. Retirer une Creature");
        System.out.println("2. Nourir les creatures");
        System.out.println("3. Quitter");
    }

    /**
     * Affiche le menu de création du zoo fantastique.
     * 
     * @return
     *
     * @throws InterruptedException
     */

    public Zoo displayZooCreationMenu() throws InterruptedException {
        int creatureChoice;

        do {
            System.out.println("===== Zoo Fantastique =====");
            System.out.println("Bienvenue dans le Zoo Fantastique !");
            System.out.println("Dans un premier temps, vous allez créer un zoo");
            System.out.println("1. Créer un zoo");
            System.out.println("2. Quitter");
            System.out.print("Choisissez une option : ");

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre entier.");
                scanner.next(); // Consommer l'entrée incorrecte
            }

            creatureChoice = scanner.nextInt();
            scanner.nextLine(); // Lire la ligne vide après la saisie du nombre

            switch (creatureChoice) {
                case 1:
                    System.out.println("Ajout d'un zoo...");

                    String name = setName();
                    int maxEnclosures = setMaxEnclosures();

                    zoo = new Zoo(name, maxEnclosures, zooKeeper); // Attribuez le nouveau zoo à la variable zoo

                    System.out.println("Zoo ajouté avec succès !");
                    return zoo;
                case 2:
                    System.out.println("Aurevoir !");
                    System.exit(0); // 0 indique une sortie normale
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }

        } while (creatureChoice != 2);

        // Si l'utilisateur choisit l'option 2, retourne null
        return null;
    }

    void addCreatureToEnclosure(Creature creature) {
        // Afficher la liste des enclos
        displayEnclosureNames(enclosureList);

        // Demander à l'utilisateur de choisir un enclos
        System.out.print("Choisissez un enclos pour ajouter la créature (0 pour annuler) : ");
        int selectedEnclosureIndex = scanner.nextInt() - 1;

        if (selectedEnclosureIndex >= 0 && selectedEnclosureIndex < enclosureList.size()) {
            Enclosure selectedEnclosure = enclosureList.get(selectedEnclosureIndex);
            selectedEnclosure.addCreature(creature);
            System.out.println("Créature ajoutée à l'enclos : " + selectedEnclosure.getName());
        } else if (selectedEnclosureIndex != -1) {
            System.out.println("Index d'enclos invalide. La créature ne sera pas ajoutée à un enclos.");
        }
    }

    private void feedCreature(Enclosure enclosure) {
        List<Creature> creatures = enclosure.getCreatures();

        if (!creatures.isEmpty()) {
            System.out.println("Choisissez la créature à nourrir :");

            for (int i = 0; i < creatures.size(); i++) {
                System.out.println((i + 1) + ". " + creatures.get(i).getName());
            }

            int creatureIndex = scanner.nextInt();

            if (creatureIndex >= 1 && creatureIndex <= creatures.size()) {
                Creature selectedCreature = creatures.get(creatureIndex - 1);
                selectedCreature.eat(); // Appelle la méthode eat() de la créature
            } else {
                System.out.println("Numéro de créature invalide.");
            }
        } else {
            System.out.println("Aucune créature présente dans l'enclos.");
        }
    }
}
