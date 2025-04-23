import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    public void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    public void testAdd() {
        assertEquals(5, mathUtils.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(2, mathUtils.subtract(5, 3));
    }

    @Test
    public void testMultiply() {
        assertEquals(10, mathUtils.multiply(2, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, mathUtils.divide(6, 3));
        assertEquals(-1.0, mathUtils.divide(6, 0));
    }

    @AfterEach
    public void tearDown() {
        mathUtils = null;
    }
}
