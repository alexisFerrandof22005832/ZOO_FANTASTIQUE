// Package contenant l'interface Run
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Run
public interface Run {

    // Méthode par défaut permettant de décrire l'action de courir pour une créature donnée
    default String run(Creature creature) {
        // Vérification de la vitalité de la créature
        if (creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est en train de courir
            return creature.getName() + " est en train de courir";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est morte
            return creature.getName() + " est morte";
        }
    }
}
