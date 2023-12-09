// Déclaration du package et des importations nécessaires
package org.example;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Définition de la classe Enclosure
public class Enclosure {

    // Déclaration des attributs de la classe Enclosure
    private String name;                  // Nom de l'enclos
    private double area;                  // Superficie de l'enclos en mètres carrés
    private int maxCapacity;              // Capacité maximale d'occupants de l'enclos
    private List<Creature> creatures;     // Liste des créatures présentes dans l'enclos
    private static List<Enclosure> enclosureList = new ArrayList<>();  // Liste statique d'enclos
    private Cleanliness cleanliness;      // Niveau de propreté de l'enclos

    // Constructeur de la classe Enclosure
    public Enclosure(String name, double area, int maxCapacity, Cleanliness cleanliness) {
        this.name = name;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.creatures = new ArrayList<>();
        this.cleanliness = cleanliness;
        enclosureList.add(this);   // Ajout de l'enclos à la liste statique d'enclos
    }

    // Méthode pour ajouter une créature à l'enclos
    public void addCreature(Creature creature) {
        if (creatures.size() < maxCapacity) {
            creatures.add(creature);
        } else {
            System.out.println("L'enclos est plein !");
        }
    }

    // Méthode pour retirer les créatures mortes de l'enclos
    public void removeDeadCreatures() {
        Iterator<Creature> iterator = creatures.iterator();
        boolean creatureRemoved = false;

        while (iterator.hasNext()) {
            Creature creature = iterator.next();
            if (!creature.isAlive()) {
                iterator.remove();
                creatureRemoved = true;
                System.out.println(creature.getName() + " a été retiré de l'enclos car il est mort.");
            }
        }

        if (creatureRemoved) {
            updateCleanliness();
        }
    }

    // Méthode privée pour mettre à jour la propreté en cas de créatures mortes
    private void updateCleanliness() {
        if (hasDeadCreatures()) {
            setCleanliness(Cleanliness.CORRECT);
            System.out.println("Le niveau de propreté de l'enclos est maintenant MOYEN en raison de créatures mortes.");
        }
    }

    // Méthode privée pour vérifier s'il y a des créatures mortes dans l'enclos
    private boolean hasDeadCreatures() {
        for (Creature creature : creatures) {
            if (!creature.isAlive()) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour retirer une créature de l'enclos
    public void removeCreature(Creature creature) {
        creatures.remove(creature);
    }

    // Méthode pour afficher les informations de l'enclos
    public void displayInfo() {
        System.out.println("Nom de l'enclos: " + name);
        System.out.println("Superficie: " + area + " mètres carrés");
        System.out.println("Capacité maximale: " + maxCapacity);
        System.out.println("Propreté: " + cleanliness);
        System.out.println("Nombre de créatures: " + getNumberOfCreatures());

        if (!creatures.isEmpty()) {
            System.out.println("Créatures présentes:");
            for (Creature creature : creatures) {
                System.out.println(creature);
            }
        } else {
            System.out.println("Aucune créature présente.");
        }
    }

    // Méthode pour effectuer l'entretien de l'enclos
    public void maintainEnclosure() {
        if (creatures.isEmpty() && cleanliness != Cleanliness.BON) {
            cleanliness = Cleanliness.BON;
            System.out.println("L'enclos a été nettoyé et est maintenant en bon état.");
        } else {
            System.out.println("L'entretien de l'enclos n'est pas possible actuellement.");
        }
    }

    // Méthode pour nourrir les créatures présentes dans l'enclos
    public void feedCreatures() {
        if (!creatures.isEmpty()) {
            for (Creature creature : creatures) {
                creature.eat();
            }
        } else {
            System.out.println("Il n'y a pas de créatures à nourrir dans l'enclos " + name);
        }
    }

    // Méthode pour obtenir le nombre de créatures dans l'enclos
    public int getNumberOfCreatures() {
        return creatures.size();
    }

    // Méthodes d'accès aux attributs
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Creature> getCreatures() {
        return new ArrayList<>(creatures);
    }

    public Cleanliness getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Cleanliness cleanliness) {
        this.cleanliness = cleanliness;
    }

    // Méthode pour afficher la liste des créatures dans l'enclos
    public void displayCreaturesList() {
        System.out.println("Liste des créatures dans l'enclos " + name + ":");
        if (!creatures.isEmpty()) {
            for (int i = 0; i < creatures.size(); i++) {
                Creature creature = creatures.get(i);
                System.out.println((i + 1) + ". " + creature.getName());
            }
        } else {
            System.out.println("Aucune créature présente dans l'enclos.");
        }
    }
}
