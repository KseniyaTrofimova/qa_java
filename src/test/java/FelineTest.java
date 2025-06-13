import com.example.Feline;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class FelineTest {

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test(expected = Exception.class)
    public void testGetFoodWithUnknownTypeThrowsException() throws Exception {
        Feline feline = new Feline();
        feline.getFood("Неизвестный тип");
    }

    @Test
    public void testGetKittensWithZero() {
        Feline feline = new Feline();
        assertEquals(0, feline.getKittens(0));
    }

    @Test
    public void testGetKittensWithNegativeNumber() {
        Feline feline = new Feline();
        assertEquals(-5, feline.getKittens(-5));
    }
}