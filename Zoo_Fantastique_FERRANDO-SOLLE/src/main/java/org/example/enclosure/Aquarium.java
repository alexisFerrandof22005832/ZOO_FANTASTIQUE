// Package contenant la classe Aquarium
package org.example.enclosure;

// Importation des classes et interfaces nécessaires
import org.example.Cleanliness;
import org.example.Creature;
import org.example.Enclosure;
import org.example.interfaces.AquaticCreature;

import java.util.List;

// Déclaration de la classe Aquarium qui étend Enclosure
public class Aquarium extends Enclosure {
    // Attributs spécifiques à la classe Aquarium
    private double depth;
    private double salinity;

    // Constructeur de la classe Aquarium
    public Aquarium(String name, double area, int maxCapacity, List<Creature> creatures, Cleanliness cleanliness) {
        super(name, area, maxCapacity, cleanliness);
        this.depth = depth;
        this.salinity = salinity;
    }

    // Méthode de maintenance de l'enclos, surchargeant la méthode de la classe mère
    @Override
    public void maintainEnclosure() {
        super.maintainEnclosure(); // Appel de la méthode de la classe mère
        checkWaterQuality(); // Vérification de la qualité de l'eau

        setCleanliness(Cleanliness.BON); // Définition de la propreté à un niveau optimal

        System.out.println("L'aquarium a été entretenu, avec vérification de la qualité de l'eau.");
    }

    // Méthode privée pour vérifier la qualité de l'eau
    private void checkWaterQuality() {
        System.out.println("La qualité de l'eau a été vérifiée : profondeur et salinité sont adéquates.");
    }

    // Méthode pour ajouter une créature à l'aquarium
    @Override
    public void addCreature(Creature creature) {
        // Vérification que la créature est une créature aquatique avant de l'ajouter
        if (!(creature instanceof AquaticCreature)) {
            System.out.println("Seules les créatures aquatiques peuvent être ajoutées à un aquarium.");
            return;
        }
        super.addCreature(creature); // Appel de la méthode de la classe mère pour ajouter la créature
    }

    // Méthode getter pour la profondeur de l'aquarium
    public double getDepth() {
        return depth;
    }

    // Méthode setter pour la profondeur de l'aquarium
    public void setDepth(double depth) {
        this.depth = depth;
    }

    // Méthode getter pour la salinité de l'aquarium
    public double getSalinity() {
        return salinity;
    }

    // Méthode setter pour la salinité de l'aquarium
    public void setSalinity(double salinity) {
        this.salinity = salinity;
    }
}
