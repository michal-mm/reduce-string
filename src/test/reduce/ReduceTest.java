package test.reduce;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import reduce.*;
import static reduce.Char2EnumFactory.*;
import static org.junit.Assert.*;

/**
 * Created by michal on 03.08.15.
 */
public class ReduceTest {

    private Reduction r;

    @Before
    public void setUp() {
        r = new Reduction ();
    }

    @After
    public void tearDown () {
        r = null;
    }

    @Test
    public void noReductionTest() {

        String toBeReduced = "AC";
        String expected = "AC";

        assertEquals(expected, r.solution(toBeReduced));
    }

    @Test
    public void simpleReductionTest() {

        String toBeReduced = "AAC";
        String expected = "AC";

        assertEquals(expected, r.solution(toBeReduced));
    }

    @Test
    public void simpleStateTest_A1() {
        CharState cs = new CharStateA(new StringBuffer());
        CharState expected = new CharStateA(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('A')));
    }

    @Test
    public void simpleStateTest_A2() {
        CharState cs = new CharStateA(new StringBuffer());
        CharState expected = new CharStateA(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('B')));
    }

    @Test
    public void simpleStateTest_A3() {
        CharState cs = new CharStateA(new StringBuffer());
        CharState expected = new CharStateC(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('C')));
    }

    @Test
    public void simpleStateTest_C1() {
        CharState cs = new CharStateC(new StringBuffer());

        assertEquals(cs, cs.next(getCharEnum('C')));
    }

    @Test
    public void simpleStateTest_C2() {
        CharState cs = new CharStateC(new StringBuffer());
        CharState expected = new CharStateA(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('A')));
    }

    @Test
    public void simpleStateTest_C3() {
        CharState cs = new CharStateC(new StringBuffer());
        CharState expected = new CharStateC(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('B')));
    }

    @Test
    public void simpleStateTest_B1() {
        CharState cs = new CharStateB(new StringBuffer());
        CharState expected = new CharStateA(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('A')));
    }

    @Test
    public void simpleStateTest_B2() {
        CharState cs = new CharStateB(new StringBuffer());
        CharState expected = new CharStateC(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('C')));
    }

    @Test
    public void simpleStateTest_B3() {
        CharState cs = new CharStateB(new StringBuffer());
        CharState expected = new CharStateB(new StringBuffer());

        assertEquals(expected, cs.next(getCharEnum('B')));
    }

    @Test
    public void simpleBufferTest_1(){
        StringBuffer begin = new StringBuffer("A");
        String expected = "AC";

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('C'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_2(){
        StringBuffer begin = new StringBuffer("A");
        String expected = "A";

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('A'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_3(){
        StringBuffer begin = new StringBuffer("A");
        String expected = "A";

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('B'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_4(){
        StringBuffer begin = new StringBuffer("C");
        String expected = "CA";

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('A'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_5(){
        StringBuffer begin = new StringBuffer("C");
        String expected = "C";

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('C'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_6(){
        StringBuffer begin = new StringBuffer("C");
        String expected = "C";

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('B'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_7(){
        StringBuffer begin = new StringBuffer("");
        String expected = "A";

        CharState cs = new CharStateB(begin);
        CharState nextState = cs.next(getCharEnum('A'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_8(){
        StringBuffer begin = new StringBuffer("");
        String expected = "C";

        CharState cs = new CharStateB(begin);
        CharState nextState = cs.next(getCharEnum('C'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void simpleBufferTest_9(){
        StringBuffer begin = new StringBuffer("");
        String expected = "BB";

        CharState cs = new CharStateB(begin);
        CharState nextState = cs.next(getCharEnum('B'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_1AC() {
        StringBuffer begin = new StringBuffer("");
        String expected = "AC";

        begin.append("A");

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('C'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_2CA() {
        StringBuffer begin = new StringBuffer("");
        String expected = "CA";

        begin.append("C");

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('A'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_3AA() {
        StringBuffer begin = new StringBuffer("");
        String expected = "A";

        begin.append("A");

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('A'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_4CC() {
        StringBuffer begin = new StringBuffer("");
        String expected = "C";

        begin.append("C");

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('C'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_5AB() {
        StringBuffer begin = new StringBuffer("");
        String expected = "A";

        begin.append("A");

        CharState cs = new CharStateA(begin);
        CharState nextState = cs.next(getCharEnum('B'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void twoCharBuffer_6CB() {
        StringBuffer begin = new StringBuffer("");
        String expected = "C";

        begin.append("C");

        CharState cs = new CharStateC(begin);
        CharState nextState = cs.next(getCharEnum('B'));

        assertEquals(expected, nextState.getBufferAsString());
    }

    @Test
    public void testSolution_ABC() {
        String toBeReduced = "ABC";
        String expected = "AC";

        assertEquals(expected, r.solution(toBeReduced));
    }
    
    @Test
    public void testSolution_CBA() {
        String toBeReduced = "CBA";
        String expected = "CA";

        assertEquals(expected, r.solution(toBeReduced));
    }

    @Test
    public void testSolution_AABCC() {
        String toBeReduced = "AABCC";
        String expected = "AC";

        assertEquals(expected, r.solution(toBeReduced));
    }

    @Test
    public void testSolution_BBBBC() {
        String toBeReduced = "BBBBC";
        String expected = "C";

        assertEquals(expected, r.solution(toBeReduced));
    }

    @Test
    public void testSolution_BBBB() {
        String toBeReduced = "BBBB";
        String expected = "BBBB";

        assertEquals(expected, r.solution(toBeReduced));
    }
    
    @Test
    public void testEqualsA(){
    	CharState csA = new CharStateA(new StringBuffer());
    	CharState csB = new CharStateB(new StringBuffer());
    	
    	assertEquals (false, csA.equals(csB));
    }
    
    @Test
    public void testEqualsB(){
    	CharState csA = new CharStateA(new StringBuffer());
    	CharState csB = new CharStateB(new StringBuffer());
    	
    	assertEquals (false, csB.equals(csA));
    }
    
    @Test
    public void testEqualsC(){
    	CharState csC = new CharStateC(new StringBuffer());
    	CharState csB = new CharStateB(new StringBuffer());
    	
    	assertEquals (false, csC.equals(csB));
    }
    
    @Test
    public void testChar2EnumFactory() {
    	CharEnum ce = Char2EnumFactory.getCharEnum('A');
    	char expected = 'A';
    	assertEquals(expected, ce.getCharacter());
    }
}
