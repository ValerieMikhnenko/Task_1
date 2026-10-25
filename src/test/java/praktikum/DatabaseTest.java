
package praktikum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void availableBunsReturnsThreeBuns() {
        Database database = new Database();

        assertEquals(3, database.availableBuns().size());
        assertEquals("black bun", database.availableBuns().get(0).getName());
        assertEquals(100, database.availableBuns().get(0).getPrice());
    }

    @Test
    void availableIngredientsReturnsSixIngredients() {
        Database database = new Database();

        assertEquals(6, database.availableIngredients().size());
        assertEquals("hot sauce", database.availableIngredients().get(0).getName());
        assertEquals(IngredientType.SAUCE,
                database.availableIngredients().get(0).getType());
        assertEquals("sausage", database.availableIngredients().get(5).getName());
    }
}

