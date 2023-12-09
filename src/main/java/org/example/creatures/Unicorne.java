// Package contenant la classe Unicorne
package org.example.creatures;

// Importation des classes et interfaces nécessaires
import org.example.Creature;
import org.example.interfaces.*;

// Déclaration de la classe Unicorne qui étend Creature et implémente plusieurs interfaces
public class Unicorne extends Creature implements Run, Viviparous {

    // Constructeur de la classe Unicorne
    public Unicorne(String name, String gender, int weight, int height, int age, int health, String cries) {
        // Appel du constructeur de la classe mère (Creature)
        super(name, gender, weight, height, age, health, cries);
        // Initialisation de l'espèce de l'Unicorne
        this.setSpecies("Unicorne");
    }

    // Les méthodes spécifiques à l'Unicorne peuvent être ajoutées ici si nécessaire
}
