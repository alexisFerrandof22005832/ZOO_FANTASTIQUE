// Déclaration du package et des importations nécessaires
package org.example;
import java.util.ArrayList;
import java.util.List;

// Définition de la classe Creature implémentant l'interface Runnable
public class Creature implements Runnable {

    // Déclaration des attributs de la classe Creature
    private String name;           // Nom de la créature
    private String species;        // Espèce de la créature
    private String gender;         // Genre de la créature
    private int weight;            // Poids de la créature
    private int height;            // Taille de la créature
    protected int age;             // Âge de la créature (accessible par les classes dérivées)
    private double hunger;         // Niveau de faim de la créature
    private boolean sleeping;      // Indique si la créature est en train de dormir
    private int health;            // Niveau de santé de la créature

    private String cries;          // Cri de la créature
    private boolean isAlive;       // Indique si la créature est en vie

    // Constructeur de la classe Creature
    public Creature(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Initialisation des attributs avec les valeurs passées en paramètres
        this.name = name;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.health = health;
        this.cries = cries;
        this.hunger = 100;          // Initialisation du niveau de faim à 100
        this.sleeping = false;      // Initialisation du statut de sommeil à faux
        this.isAlive = true;        // Initialisation du statut de vie à vrai
    }

    // Implémentation de la méthode run de l'interface Runnable
    @Override
    public void run() {
        hunger();   // Appelle la méthode hunger lorsqu'un thread est lancé
    }

    // Méthode qui simule la faim de la créature et gère les cas de famine
    public void hunger() {
        while (this.hunger > 0 && !Thread.interrupted()) {
            try {
                this.hunger = this.hunger - 1;     // Décrémente le niveau de faim
                Thread.sleep(10000);               // Pause de 10 secondes

                // Vérifie si le niveau de faim est critique et affiche un message
                if (this.hunger <= 15 && this.hunger % 5 == 0) {
                    System.out.println("Il est temps de manger pour " + this.name + " (" + this.hunger + " )");

                    Thread.sleep(10000);   // Pause de 10 secondes

                    // Vérifie si la créature meurt de faim
                    if (this.hunger == 0) {
                        System.out.println(this.name + " est mort de famine.");
                        this.isAlive = false;   // Déclare la créature comme morte
                        break;                 // Sort de la boucle
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();   // Gère l'interruption du thread
            }
        }
    }

    // ... (Méthodes d'accès aux attributs, méthodes d'action sur la créature, etc.)

    // Méthode qui retourne une représentation textuelle de la créature
    @Override
    public String toString() {
        return "Créature{" +
                "nom='" + name + '\'' +
                ", espèce='" + species + '\'' +
                ", âge=" + age +
                '}';
    }

    // Méthode protégée pour afficher des informations supplémentaires (à implémenter dans les sous-classes)
    protected void displayInfo() {
        // Les informations supplémentaires peuvent être affichées ici dans les sous-classes
    }
}
