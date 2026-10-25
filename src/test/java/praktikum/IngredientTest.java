package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    @Test
    void ingredientConstructorSetsFields() {
        Ingredient ingredient = new Ingredient(
                IngredientType.SAUCE,
                "Hot sauce",
                50.0f
        );

        assertEquals(IngredientType.SAUCE, ingredient.getType());
        assertEquals("Hot sauce", ingredient.getName());
        assertEquals(50.0f, ingredient.getPrice(), 0.001f);
    }

    @ParameterizedTest
    @CsvSource({
            "SAUCE, 'Hot sauce', 50.0",
            "FILLING, 'Chicken', 120.0",
            "FILLING, 'Cheese', 70.0"
    })
    void gettersReturnCorrectValues(
            IngredientType type,
            String name,
            float price
    ) {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }
}