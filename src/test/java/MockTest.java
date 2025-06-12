import com.example.Lion;
import com.example.Predator;
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
    private Predator predatorMock;

    @Test
    public void testEatMeatDelegatesToPredator() throws Exception {
        Lion lion = new Lion("Самец", predatorMock);
        List<String> expectedFood = List.of("Антилопа", "Зебра");

        when(predatorMock.eatMeat()).thenReturn(expectedFood);

        assertEquals(expectedFood, lion.eatMeat());
        verify(predatorMock, times(1)).eatMeat(); // Проверка вызова
    }

    @Test(expected = Exception.class)
    public void testPredatorExceptionPropagates() throws Exception {
        when(predatorMock.eatMeat()).thenThrow(new Exception("Ошибка в Predator"));

        Lion lion = new Lion("Самка", predatorMock);
        lion.eatMeat();
    }
}

