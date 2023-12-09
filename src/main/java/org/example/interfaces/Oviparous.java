// Package contenant l'interface Oviparous
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Oviparous
public interface Oviparous {

    // Méthode par défaut permettant de décrire l'action liée à la reproduction ovipare pour une créature donnée
    default String oviparous(Creature creature) {
        // Vérification de la vitalité de la créature
        if (!creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est morte
            return creature.getName() + " est mort(e)";
        } else if ("femme".equalsIgnoreCase(creature.getGender())) {
            // Retour d'une chaîne de caractères indiquant que la créature pond des œufs
            return creature.getName() + " pond des œufs";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est un mâle et ne peut pas pondre
            return creature.getName() + " est un mâle, il ne peut pas pondre";
        }
    }
}
