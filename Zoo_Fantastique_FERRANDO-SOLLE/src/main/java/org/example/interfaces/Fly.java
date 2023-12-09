// Package contenant l'interface Fly
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Fly
public interface Fly {

    // Méthode par défaut permettant de décrire l'action de voler pour une créature donnée
    default String fly(Creature creature) {
        // Vérification de la vitalité de la créature
        if (creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est en train de voler
            return creature.getName() + " est en train de voler";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est morte
            return creature.getName() + " est mort";
        }
    }
}
