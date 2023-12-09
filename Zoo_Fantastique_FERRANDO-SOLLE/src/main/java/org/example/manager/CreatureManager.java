package org.example.manager;

import org.example.Creature;
import org.example.Enclosure;
import org.example.Zoo;
import org.example.ZooKeeper;
import org.example.creatures.Dragon;
import org.example.creatures.Kraken;
import org.example.creatures.Megalodons;
import org.example.creatures.Mermaids;
import org.example.creatures.Phenix;
import org.example.creatures.Unicorne;
import org.example.creatures.Nymph;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Cette classe gère les créatures et les opérations associées dans le zoo
 * fantastique.
 */
public class CreatureManager {
    private static List<Creature> creatures = new ArrayList<>();
    private static List<Thread> creatureThreads = new ArrayList<>();
    private static Enclosure enclosParDefaut;
    static Zoo zoo;
    public static ZooManager zooManager = new ZooManager();

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Constructeur de la classe CreatureManager.
     *
     * @param enclosParDefaut L'enclos par défaut dans le zoo fantastique.
     */
    public CreatureManager(Enclosure enclosParDefaut) {
        CreatureManager.enclosParDefaut = enclosParDefaut;
        CreatureManager.creatures = new ArrayList<>();
        CreatureManager.creatureThreads = new ArrayList<>();
    }

    /**
     * Ajoute une créature à la liste et démarre un thread pour la créature.
     *
     * @param creature La créature à ajouter.
     */
    public static void addCreature(Creature creature) {
        creatures.add(creature);

        Thread creatureThread = new Thread(creature);
        creatureThreads.add(creatureThread);
        creatureThread.start();
    }

    /**
     * Renvoie la liste des créatures.
     *
     * @return La liste des créatures.
     */
    public List<Creature> getCreatures() {
        return creatures;
    }

    /**
     * Affiche la liste des créatures avec leur nom et leur niveau de faim.
     */
    public void displayCreatures() {
        System.out.println("===== Liste des Créatures =====");

        if (creatures != null) {
            for (Creature creature : creatures) {
                System.out.println("Name : " + creature.getName() + " | " + "Hunger : " + creature.getHunger());
            }
        } else {
            System.out.println("La liste de créatures est nulle.");
        }
    }

    /**
     * Supprime une créature de la liste.
     *
     * @param creature La créature à supprimer.
     */
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    public void removeCreatureFromEnclosure(Enclosure enclosure) {
        if (!enclosure.getCreatures().isEmpty()) {
            System.out.print("Choisissez le numéro de la créature à retirer : ");
            int creatureIndex = scanner.nextInt();

            if (creatureIndex >= 1 && creatureIndex <= enclosure.getNumberOfCreatures()) {
                Creature creatureToRemove = enclosure.getCreatures().get(creatureIndex - 1);
                enclosure.removeCreature(creatureToRemove); // Utilise la fonction d'Enclosure pour retirer la créature
                System.out.println(creatureToRemove.getName() + " a été retiré de l'enclos.");
            } else {
                System.out.println("Numéro de créature invalide.");
            }
        } else {
            System.out.println("Aucune créature présente dans l'enclos.");
        }
    }

    /**
     * Demande et renvoie le nom de la créature saisi par l'utilisateur.
     *
     * @return Le nom de la créature.
     */
    public static String setName() {
        System.out.print("Nom de la créature : ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty() || name.isBlank()) {
            System.out.println("Il faut donner un nom à la créature !");
            System.out.print("Nom de la créature : ");
            name = scanner.nextLine().trim();
        }
        System.out.println("Nom : " + name);
        return name;
    }

    /**
     * Demande et renvoie le type de la créature saisi par l'utilisateur.
     *
     * @return Le type de la créature.
     */
    public static String setType() {
        System.out.print("Male(M) ou Femelle(F) (defaut F): ");
        String stype = scanner.nextLine().trim();
        if ("M".equals(stype)) {
            System.out.println("Type : Male");
            return "Male";
        } else if ("F".equals(stype)) {
            System.out.println("Type : Femelle");
            return "Femelle";
        }
        System.out.println("Type par défaut : Femelle");
        return "Femelle";
    }

    /**
     * Demande et renvoie le poids de la créature saisi par l'utilisateur.
     *
     * @return Le poids de la créature.
     */
    public static int setWeight() {
        System.out.print("Poids de la créature (defaut = 80) : ");
        String weightInput = scanner.nextLine().trim();
        if (!weightInput.isEmpty()) {
            while (!isNumeric(weightInput)) {
                System.out.println("Veuillez entrer un nombre entier.");
                System.out.print("Poids de la créature (defaut = 80) : ");
                weightInput = scanner.nextLine().trim();
            }
            System.out.println("Poids : " + weightInput);
            return Integer.parseInt(weightInput);
        }
        System.out.println("Poids par défaut : 80");
        return 80;
    }

    /**
     * Demande et renvoie la taille de la créature saisi par l'utilisateur.
     *
     * @return La taille de la créature.
     */
    public static int setHeight() {
        System.out.print("Taille de la créature (defaut = 110) : ");
        String heightInput = scanner.nextLine().trim();
        if (!heightInput.isEmpty()) {
            while (!isNumeric(heightInput)) {
                System.out.println("Veuillez entrer un nombre entier.");
                System.out.print("Taille de la créature (defaut = 110) : ");
                heightInput = scanner.nextLine().trim();
            }
            System.out.println("Taille : " + heightInput);
            return Integer.parseInt(heightInput);
        }
        System.out.println("Taille par défaut : 110");
        return 110;
    }

    /**
     * Demande et renvoie l'âge de la créature saisi par l'utilisateur.
     *
     * @return L'âge de la créature.
     */
    public static int setAge() {
        System.out.print("Age de la créature (defaut = 10) : ");
        String ageInput = scanner.nextLine().trim();
        if (!ageInput.isEmpty()) {
            while (!isNumeric(ageInput)) {
                System.out.println("Veuillez entrer un nombre entier.");
                System.out.print("Age de la créature (defaut = 10) : ");
                ageInput = scanner.nextLine().trim();
            }
            System.out.println("Age : " + ageInput);
            return Integer.parseInt(ageInput);
        }
        System.out.println("Age par défaut : 10");
        return 10;
    }

    /**
     * Demande et renvoie la santé de la créature saisi par l'utilisateur.
     *
     * @return La santé de la créature.
     */
    public static int setHealth() {
        System.out.print("Santé de la créature (defaut = 100) : ");
        String healthInput = scanner.nextLine().trim();
        if (!healthInput.isEmpty()) {
            while (!isNumeric(healthInput)) {
                System.out.println("Veuillez entrer un nombre entier.");
                System.out.print("Santé de la créature (defaut = 100) : ");
                healthInput = scanner.nextLine().trim();
            }
            System.out.println("Santé : " + healthInput);
            return Integer.parseInt(healthInput);
        }
        System.out.println("Santé par défaut : 100");
        return 100;
    }

    /**
     * Ajoute une créature en fonction de l'entrée utilisateur.
     */
    public void addCreatureFromUserInput() {
        int creatureChoice;

        do {
            System.out.println("Quelle créature souhaitez-vous créer? ");
            zooManager.afficherMenuCreationCreature();

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre entier.");
                scanner.next(); // Consommer l'entrée incorrecte
            }

            creatureChoice = scanner.nextInt();
            scanner.nextLine(); // Lire la ligne vide après la saisie du nombre

            switch (creatureChoice) {
                case 1:
                    // Création d'un dragon...
                    int health = 100;
                    int age = 1;
                    int height = 110;
                    int weight = 80;
                    String name = "name";
                    String type = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Dragon newDragon = new Dragon(name, type, weight, height, age, health, "Grr Grr");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newDragon);

                    addCreature(newDragon);

                    System.out.println("Dragon ajouté avec succès !");
                    break;

                case 2:
                    // Création d'un kraken...
                    int health2 = 100;
                    int age2 = 1;
                    int height2 = 110;
                    int weight2 = 80;
                    String name2 = "name";
                    String type2 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Kraken newKraken = new Kraken(name, type, weight, height, age, health, "Brr Brr");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newKraken);

                    addCreature(newKraken);

                    System.out.println("Kraken ajouté avec succès !");
                    break;

                case 3:
                    // Création d'un Mégalodon...
                    int health3 = 100;
                    int age3 = 1;
                    int height3 = 110;
                    int weight3 = 80;
                    String name3 = "name";
                    String type3 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Megalodons newMegalodons = new Megalodons(name, type, weight, height, age, health, "Piouf");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newMegalodons);

                    addCreature(newMegalodons);

                    System.out.println("Mégalodon ajouté avec succès !");
                    break;
                case 4:
                    // Création d'une mermaid...
                    int health4 = 100;
                    int age4 = 1;
                    int height4 = 110;
                    int weight4 = 80;
                    String name4 = "name";
                    String type4 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Mermaids newMermaids = new Mermaids(name, type, weight, height, age, health, "Skuu");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newMermaids);

                    addCreature(newMermaids);

                    System.out.println("Mermaids ajouté avec succès !");
                    break;
                case 5:
                    // Création d'une nymph...
                    int health5 = 100;
                    int age5 = 1;
                    int height5 = 110;
                    int weight5 = 80;
                    String name5 = "name";
                    String type5 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Nymph newNymph = new Nymph(name, type, weight, height, age, health, "Suuuiiii");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newNymph);

                    addCreature(newNymph);

                    System.out.println("Nymph ajouté avec succès !");
                    break;
                case 6:
                    // Création d'un Phenix...
                    int health6 = 100;
                    int age6 = 1;
                    int height6 = 110;
                    int weight6 = 80;
                    String name6 = "name";
                    String type6 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Phenix newPhenix = new Phenix(name, type, weight, height, age, health, "Sheeesh");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newPhenix);

                    addCreature(newPhenix);

                    System.out.println("Phenix ajouté avec succès !");
                    break;
                case 7:
                    // Création d'un Unicorne...
                    int health7 = 100;
                    int age7 = 1;
                    int height7 = 110;
                    int weight7 = 80;
                    String name7 = "name";
                    String type7 = "Femelle";

                    name = setName();
                    type = setType();
                    weight = setWeight();
                    height = setHeight();
                    age = setAge();
                    health = setHealth();

                    Unicorne newUnicorne = new Unicorne(name, type, weight, height, age, health, "Huuuu");

                    // Ajout de la créature à un enclos
                    zooManager.addCreatureToEnclosure(newUnicorne);

                    addCreature(newUnicorne);

                    System.out.println("Unicorne ajouté avec succès !");
                    break;

                case 8:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez choisir à nouveau.");
            }

            if (creatureChoice == 8) {
                break;
            }
        } while (creatureChoice != 8);
    }

    /**
     * Ajoute un thread pour la créature.
     *
     * @param creatureThread Le thread de la créature.
     */
    public void addCreatureThread(Thread creatureThread) {
        creatureThreads.add(creatureThread);
    }

    /**
     * Renvoie la liste des threads des créatures.
     *
     * @return La liste des threads des créatures.
     */
    public List<Thread> getCreatureThreads() {
        return creatureThreads;
    }

    /**
     * Ferme le scanner.
     */
    public void closeScanner() {
        // scanner.close();
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
}
