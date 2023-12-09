// Package contenant la classe Nymph
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Nymph qui étend Creature et implémente plusieurs interfaces
public class Nymph extends Creature implements Fly, Viviparous, FlyingCreature {

    // Constructeur de la classe Nymph
    public Nymph(String name, String gender, int weight, height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce de la Nymph
        this.setSpecies("Nymph");
    }

    // Implémentation de la méthode fly() de l'interface Fly
    @Override
    public String fly() {
        // Affichage d'un message indiquant que la Nymph s'élève dans les airs
        System.out.println("La Nymph s'élève dans les airs.");
        // Retour d'une chaîne de caractères décrivant l'action
        return "La Nymph s'élève dans les airs.";
    }
}
