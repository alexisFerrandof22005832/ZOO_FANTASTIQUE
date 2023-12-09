// Package contenant la classe Dragon
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Dragon qui étend Creature et implémente plusieurs interfaces
public class Dragon extends Creature implements Run, Swim, Fly, Oviparous, FlyingCreature, AquaticCreature {

    // Constructeur de la classe Dragon
    public Dragon(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce du Dragon
        this.setSpecies("Dragon");
    }

    // Implémentation de la méthode fly() de l'interface Fly
    @Override
    public String fly() {
        // Affichage d'un message indiquant que le Dragon s'envole dans les airs
        System.out.println("Le Dragon s'envole dans les airs.");
        // Retour d'une chaîne de caractères décrivant l'action
        return "Le Dragon s'envole dans les airs.";
    }

    // Implémentation de la méthode swim() de l'interface Swim
    @Override
    public String swim() {
        // Affichage d'un message indiquant que le Dragon se déplace dans l'eau
        System.out.println("Le Dragon se déplace dans l'eau.");
        // La méthode ne retourne rien (null)
        return null;
    }
}
