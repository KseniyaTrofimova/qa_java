import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        when(feline.getKittens()).thenReturn(5);

        Lion lion = new Lion("Самец", feline);
        assertEquals(5, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Lion lion = new Lion("Самка", feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test(expected = Exception.class)
    public void testInvalidSex() throws Exception {
        new Lion("Неизвестный пол", feline);
    }
}


