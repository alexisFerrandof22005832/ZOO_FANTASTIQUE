package org.example.creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MermaidsTest {


    @Test
    void displayCharacteristics() {
        Mermaids mermaids = new Mermaids("Mermaids", "Femelle", 50, 100, 50, 100, "Aaaaaaa");
        assertEquals("Mermaids", mermaids.getName());
        assertEquals("Femelle", mermaids.getGender());
        assertEquals(100, mermaids.getWeight());
        assertEquals(100, mermaids.getHeight());
        assertEquals(100, mermaids.getAge());
        assertEquals(100, mermaids.getHealth());
        assertEquals("Grrrrr", mermaids.getCries());
        assertEquals("Mermaids", mermaids.getSpecies());
    }
    @Test
    void swim() {
        Mermaids mermaids = new Mermaids("Mermaids", "Male", 100, 50, 100, 50, "Aaaaaaa");
        assertEquals("La sirène nage dans l'eau.", mermaids.swim());
    }


}