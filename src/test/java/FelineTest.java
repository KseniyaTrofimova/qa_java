import com.example.Feline;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
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

    @RunWith(Parameterized.class)
    public static class GetKittensParameterizedTest {
        private final int input;
        private final int expected;

        public GetKittensParameterizedTest(int input, int expected) {
            this.input = input;
            this.expected = expected;
        }

        @Parameterized.Parameters
        public static Iterable<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {1, 1},
                    {3, 3},
                    {0, 0}
            });
        }

        @Test
        public void testGetKittensWithParameter() {
            Feline feline = new Feline();
            assertEquals(expected, feline.getKittens(input));
        }
    }

    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }
}