// Package contenant l'interface Swim
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Swim
public interface Swim {

    // Méthode par défaut permettant de décrire l'action de nager pour une créature donnée
    default String swim(Creature creature) {
        // Vérification de la vitalité de la créature
        if (creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est en train de nager
            return creature.getName() + " est en train de nager";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est morte
            return creature.getName() + " est morte";
        }
    }
}
