package praktikum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTypeTest {

    @ParameterizedTest
    @EnumSource(IngredientType.class)
    void ingredientTypeHasCorrectName(IngredientType type) {
        assertEquals(type.name(), type.toString());
    }
}
