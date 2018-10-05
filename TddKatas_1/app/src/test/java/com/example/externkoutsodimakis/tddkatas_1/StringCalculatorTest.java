package com.example.externkoutsodimakis.tddkatas_1;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class StringCalculatorTest {

    StringCalculator SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new StringCalculator();

    }

    @Test
    public void whenNumbersAreTwo_workingGood() {
        SUT.add("1,2");
        assertTrue(true);
    }

    @Test(expected = RuntimeException.class)
    public final void whenNonNumberIsUsedThenExceptionIsThrown() {
        SUT.add("1,X");
    }

    @Test
    public void whenEmptyStringReturnValue0() throws Exception {
        assertEquals(0, SUT.add(""));
    }

    @Test
    public void whenOneNumberIsAdded_returnItsValue() throws Exception {
        assertEquals(3, SUT.add("3"));
    }

    @Test
    public void whenTwoNumbersAdded_returnTheSum() throws Exception {
        assertEquals(3 + 6, SUT.add("3,6"));
    }

    @Test
    public void whenMoreThanTwoNumbersAdded_returnTheSum() {
        assertEquals(3 + 6 + 6 + 3 + 5, SUT.add("3,6,6,3,5"));
    }

    @Test
    public void whenNewLineIsUsedBetweenNumbers_returnSum() {
        assertEquals(3 + 6 + 5, SUT.add("3,6n5"));
    }

    /* @Test(expected = RuntimeException.class)
     public void negativeNumbersWillThrowRunTimeException(){
         SUT.add("3,-6,5");
     }
     */
    @Test
    public final void negativeNumbersWillThrowRunTimeException() throws RuntimeException {
        RuntimeException exception = null;
        try {
            SUT.add("3,-6,15");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Exception!!!", exception.getMessage());
    }

    @Test
    public final void numbersGreaterThan1000WillBeIgnored() throws RuntimeException {
        RuntimeException exception = null;
        try {
            SUT.add("3,-1001,15");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("Exception!!!", exception.getMessage());


    }

}