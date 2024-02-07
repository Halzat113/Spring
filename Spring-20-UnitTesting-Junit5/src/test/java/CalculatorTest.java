import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
     static void beforeAll(){
        System.out.println("==========BEFORE ALL STARTED=============");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("===========AFTER ALL=============");
    }

    @BeforeEach
     void beforeEach(){
        System.out.println("===========Before Each Started============");
    }

    @AfterEach
     void afterEach(){
        System.out.println("===========After Each============");
    }

    @Test
    void testCase1(){
        //fail("Not implemented yet");

    }
    @Test
    void testCase2(){
        assertTrue(Calculator.operator.equals("add"));
    }
    @Test
    void testCase3(){
        assertArrayEquals(new int[]{1,2,3},new int[]{1,2,3});
    }
    @Test
    void testCase4(){
        String nullString = null;
        String notNullString = "str";
        assertNotNull(notNullString);
        assertNull(nullString);
    }
    @Test
    void testCase5(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();
        assertSame(c1,c2);
        assertNotSame(c1,c3);
    }
    @Test
    void add() {
        int actual = Calculator.add(2,3);
        assertEquals(5,actual,"It is not matching with expected value");
    }  @Test
    void add2() {
        assertThrows(IllegalArgumentException.class,()->Calculator.add2(5,2));
    }

}