// Package contenant la classe Mermaids
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Mermaids qui étend Creature et implémente plusieurs interfaces
public class Mermaids extends Creature implements Swim, Viviparous, AquaticCreature {

    // Constructeur de la classe Mermaids
    public Mermaids(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce des sirènes
        this.setSpecies("Mermaids");
    }

    // Implémentation de la méthode swim() de l'interface Swim
    @Override
    public String swim() {
        // Affichage d'un message indiquant que la sirène nage dans l'eau
        System.out.println("La sirène nage dans l'eau.");
        // Retour d'une chaîne de caractères décrivant l'action
        return "La sirène nage dans l'eau.";
    }
}
