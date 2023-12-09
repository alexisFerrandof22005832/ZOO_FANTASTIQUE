package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NymphTest {


    @Test
    void displayCharacteristics() {
        Nymph nymph = new Nymph("Nymph", "Femelle", 100, 50, 100, 50, "SHIIIII");
        assertEquals("Nymph", nymph.getName());
        assertEquals("Femelle", nymph.getGender());
        assertEquals(100, nymph.getWeight());
        assertEquals(100, nymph.getHeight());
        assertEquals(100, nymph.getAge());
        assertEquals(100, nymph.getHealth());
        assertEquals("Grrrrr", nymph.getCries());
        assertEquals("Nymph", nymph.getSpecies());
    }
    @Test
    void fly() {
        Nymph nymph = new Nymph("Nymph", "Male", 50, 100, 50, 100, "SHIIIII");
        assertEquals("Le Nymph s'élève dans les airs.", nymph.fly());
    }
}