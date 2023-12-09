// Package contenant l'interface Viviparous
package org.example.interfaces;

// Importation de la classe Creature
import org.example.Creature;

// Déclaration de l'interface Viviparous
public interface Viviparous {

    // Méthode par défaut permettant de décrire l'action de donner naissance pour une créature donnée
    default String giveBirth(Creature creature) {
        // Vérification de la vitalité de la créature
        if (!creature.isAlive()) {
            // Retour d'une chaîne de caractères indiquant que la créature est morte
            return creature.getName() + " est morte";
        } else if ("femme".equalsIgnoreCase(creature.getGender())) {
            // Retour d'une chaîne de caractères indiquant que la créature est en train d'accoucher
            return creature.getName() + " est en train d'accoucher";
        } else {
            // Retour d'une chaîne de caractères indiquant que la créature est un mâle et ne peut pas accoucher
            return creature.getName() + " est un mâle, il ne peut pas accoucher";
        }
    }
}
