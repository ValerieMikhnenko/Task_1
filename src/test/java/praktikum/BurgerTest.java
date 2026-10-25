package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class BurgerTest {

    private Burger burger;
    private Ingredient sauce;
    private Ingredient chicken;
    private Ingredient cheese;

    @BeforeEach
    void setUp() {
        burger = new Burger();

        sauce = new Ingredient(IngredientType.SAUCE, "Hot sauce", 50.0f);
        chicken = new Ingredient(IngredientType.FILLING, "Chicken", 120.0f);
        cheese = new Ingredient(IngredientType.FILLING, "Cheese", 70.0f);
    }

    @Test
    void addIngredientAddsIngredientToBurger() {
        burger.addIngredient(sauce);

        assertEquals(1, burger.ingredients.size());
        assertSame(sauce, burger.ingredients.get(0));
    }

    @Test
    void removeIngredientRemovesIngredientFromBurger() {
        burger.addIngredient(sauce);
        burger.addIngredient(chicken);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
        assertSame(chicken, burger.ingredients.get(0));
    }

    @Test
    void moveIngredientChangesIngredientOrder() {
        burger.addIngredient(sauce);
        burger.addIngredient(chicken);
        burger.addIngredient(cheese);

        burger.moveIngredient(0, 2);

        assertEquals(3, burger.ingredients.size());
        assertSame(chicken, burger.ingredients.get(0));
        assertSame(cheese, burger.ingredients.get(1));
        assertSame(sauce, burger.ingredients.get(2));
    }

    @Test
    void getPriceCalculatesTotalPrice() {
        Bun bun = Mockito.mock(Bun.class);
        when(bun.getPrice()).thenReturn(100.0f);

        Ingredient sauceMock = Mockito.mock(Ingredient.class);
        when(sauceMock.getPrice()).thenReturn(50.0f);

        Ingredient fillingMock = Mockito.mock(Ingredient.class);
        when(fillingMock.getPrice()).thenReturn(30.0f);

        burger.setBuns(bun);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);

        assertEquals(280.0f, burger.getPrice(), 0.001f);
    }



    @Test
    void getReceiptReturnsCorrectReceipt() {
        Bun bun = Mockito.mock(Bun.class);
        when(bun.getName()).thenReturn("Sesame");
        when(bun.getPrice()).thenReturn(100.0f);

        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Hot sauce", 50.0f);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Chicken", 30.0f);

        burger.setBuns(bun);
        burger.addIngredient(sauce);
        burger.addIngredient(filling);

        String receipt = burger.getReceipt();

        assertEquals(
                "(==== Sesame ====)" + System.lineSeparator()
                        + "= sauce Hot sauce =" + System.lineSeparator()
                        + "= filling Chicken =" + System.lineSeparator()
                        + "(==== Sesame ====)" + System.lineSeparator()
                        + System.lineSeparator()
                        + "Price: 280,000000" + System.lineSeparator(),
                receipt
        );
    }


}