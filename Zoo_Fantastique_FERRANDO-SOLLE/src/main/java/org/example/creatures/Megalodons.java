// Package contenant la classe Megalodons
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Megalodons qui étend Creature et implémente plusieurs interfaces
public class Megalodons extends Creature implements Swim, Oviparous, AquaticCreature {

    // Constructeur de la classe Megalodons
    public Megalodons(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce du Megalodon
        this.setSpecies("Megalodons");
    }

    // Implémentation de la méthode swim() de l'interface Swim
    @Override
    public String swim() {
        // Affichage d'un message indiquant que le Megalodon se déplace puissamment dans l'eau
        System.out.println("Le Megalodon se déplace puissamment dans l'eau.");
        // Retour d'une chaîne de caractères décrivant l'action
        return "Le Megalodon se déplace puissamment dans l'eau.";
    }
}
