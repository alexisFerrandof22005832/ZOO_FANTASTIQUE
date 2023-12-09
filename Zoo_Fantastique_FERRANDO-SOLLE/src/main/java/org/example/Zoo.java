// Déclaration du package et des importations nécessaires
package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Définition de la classe Zoo
public class Zoo {

    // Attributs de la classe Zoo
    public String name;                  // Nom du zoo
    private ZooKeeper zooKeeper;         // Gardien du zoo
    private int maxEnclosures;           // Nombre maximal d'enclos dans le zoo
    private List<Enclosure> enclosureList;  // Liste des enclos dans le zoo
    private static Scanner scanner = new Scanner(System.in);

    // Constructeur de la classe Zoo
    public Zoo(String name, int maxEnclosures, ZooKeeper zooKeeper) {
        this.name = name;
        this.zooKeeper = zooKeeper;
        this.maxEnclosures = maxEnclosures;
        this.enclosureList = new ArrayList<>();
    }

    // Méthode pour ajouter un enclos au zoo
    public void addEnclosure(Enclosure enclosure) {
        if (enclosureList.size() < maxEnclosures) {
            enclosureList.add(enclosure);
        } else {
            System.out.println("Le nombre maximal d'enclos a été atteint. Impossible d'ajouter un nouvel enclos.");
        }
    }

    // Méthode pour afficher le nombre total de créatures dans le zoo
    public void displayTotalNumberOfCreatures() {
        int total = 0;
        for (Enclosure enclosure : enclosureList) {
            total += enclosure.getNumberOfCreatures();
        }
        System.out.println("Nombre total de créatures dans le zoo : " + total);
    }

    // Méthode pour afficher les informations sur toutes les créatures dans tous les enclos
    public void displayCreaturesInAllEnclosures() {
        for (Enclosure enclosure : enclosureList) {
            System.out.println("Enclos : " + enclosure.getName());
            enclosure.displayInfo();
        }
    }

    // Méthode pour appliquer des événements aléatoires aux créatures dans les enclos
    public void applyRandomEvents() {
        Random random = new Random();
        for (Enclosure enclosure : enclosureList) {
            for (Creature creature : enclosure.getCreatures()) {
                if (random.nextBoolean()) {
                    creature.sleep();
                } else {
                    creature.wake();
                }

                if (random.nextBoolean()) {
                    creature.heal();
                }

                if (random.nextBoolean()) {
                    creature.eat();
                }

                if (random.nextBoolean()) {
                    creature.old();
                }
            }

            if (random.nextBoolean()) {
                enclosure.setCleanliness(Cleanliness.values()[random.nextInt(Cleanliness.values().length)]);
            }
        }
    }

    // Méthode pour obtenir le nom du zoo
    public String getName() {
        return name;
    }
}
