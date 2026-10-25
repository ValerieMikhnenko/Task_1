package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BunTest {

    @Test
    void bunConstructorSetsNameAndPrice() {
        Bun bun = new Bun("Sesame bun", 100.0f);

        assertEquals("Sesame bun", bun.getName());
        assertEquals(100.0f, bun.getPrice(), 0.001f);
    }

    @Test
    void getNameReturnsCorrectName() {
        Bun bun = new Bun("Rye bun", 80.0f);

        assertEquals("Rye bun", bun.getName());
    }

    @Test
    void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun("Wheat bun", 90.0f);

        assertEquals(90.0f, bun.getPrice(), 0.001f);
    }
}