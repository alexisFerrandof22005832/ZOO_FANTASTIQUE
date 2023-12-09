// Définition de la classe ZooKeeper
public class ZooKeeper {

    // Attributs de la classe ZooKeeper
    private String name;   // Nom du gardien de zoo
    private String gender; // Genre du gardien de zoo
    private int age;       // Âge du gardien de zoo

    // Constructeur de la classe ZooKeeper
    public ZooKeeper(String name, String gender, int age) {
        this.name = name;
        this.gender = String.valueOf(gender);  // Conversion du genre en chaîne de caractères
        this.age = age;
    }

    // Méthode pour examiner un enclos
    public void examineEnclosure(Enclosure enclosure) {
        System.out.println("Examen de l'enclos : " + enclosure.getName());
        enclosure.displayInfo();
    }

    // Méthode pour nettoyer un enclos
    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.setCleanliness(Cleanliness.BON);
        System.out.println("L'enclos " + enclosure.getName() + " a été nettoyé.");
    }

    // Méthode pour nourrir les créatures dans un enclos
    public void feedCreaturesInEnclosure(Enclosure enclosure) {
        enclosure.feedCreatures();
        System.out.println("Les créatures de l'enclos " + enclosure.getName() + " ont été nourries.");
    }

    // Méthode pour transférer une créature d'un enclos à un autre
    public void transferCreature(Creature creature, Enclosure fromEnclosure, Enclosure toEnclosure) {
        // Vérifie si la créature est dans l'enclos source et si l'enclos de destination a de la capacité
        if (fromEnclosure.getCreatures().contains(creature) && toEnclosure.getNumberOfCreatures() < toEnclosure.getMaxCapacity()) {
            fromEnclosure.removeCreature(creature);
            toEnclosure.addCreature(creature);
            System.out.println("La créature a été transférée de " + fromEnclosure.getName() + " à " + toEnclosure.getName() + ".");
        } else {
            System.out.println("Le transfert de la créature n'est pas possible.");
        }
    }
}
