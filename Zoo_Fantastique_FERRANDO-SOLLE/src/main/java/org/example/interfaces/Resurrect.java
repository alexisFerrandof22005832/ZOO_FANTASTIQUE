// Package contenant l'interface Resurrect
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Resurrect
public interface Resurrect {

    // Méthode par défaut permettant de décrire l'action de résurrection pour une créature donnée
    default String resurrect(Creature creature) {
        // Vérification de la vitalité de la créature
        if (!creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est en train de ressusciter
            return creature.getName() + " est en train de ressusciter";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est vivante
            return creature.getName() + " est vivant";
        }
    }
}
