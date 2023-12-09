// Package contenant la classe Phenix
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Phenix qui étend Creature et implémente plusieurs interfaces
public class Phenix extends Creature implements Fly, Oviparous, FlyingCreature {

    // Constructeur de la classe Phenix
    public Phenix(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce du Phenix
        this.setSpecies("Phenix");
    }

    // Implémentation de la méthode fly() de l'interface Fly
    @Override
    public String fly() {
        // Affichage d'un message indiquant que le Phenix s'élève dans les airs
        System.out.println("Le Phenix s'élève dans les airs.");
        // Retour d'une chaîne de caractères décrivant l'action
        return "Le Phenix s'élève dans les airs.";
    }
}
