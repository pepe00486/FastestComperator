package com.edge.fastestcomperator.utils;

import org.junit.Test;

import static com.edge.fastestcomperator.utils.StringHelper.isInteger;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringHelperTest {
    @Test
    public void StringHelper_isInteger_should_return_false_for_null() {
        assertFalse(isInteger(null));
    }

    @Test
    public void StringHelper_isInteger_should_return_false_for_empty() {
        assertFalse(isInteger(""));
    }

    @Test
    public void StringHelper_isInteger_should_return_false_for_non_numeric_value() {
        assertFalse(isInteger("av"));
        assertFalse(isInteger("a1v"));
        assertFalse(isInteger("_v"));
        assertFalse(isInteger("_"));
        assertFalse(isInteger("_"));
        assertFalse(isInteger("null"));
        assertFalse(isInteger("ABC"));
        assertFalse(isInteger("#13"));
        assertFalse(isInteger("9_9_9"));
        assertFalse(isInteger("9.9"));
        assertFalse(isInteger("-1.2"));
        assertFalse(isInteger("--12"));
        assertFalse(isInteger("12333333333333333333333333333333333333333333333333333333333333333333333333333333333"));
        assertFalse(isInteger("-12333333333333333333333333333333333333333333333333333333333333333333333333333333333"));
    }

    @Test
    public void StringHelper_isInteger_should_return_true_for_numeric_value() {
        assertTrue(isInteger("123"));
        assertTrue(isInteger("-12"));
        assertTrue(isInteger("-0"));
        assertTrue(isInteger(Integer.MAX_VALUE + ""));
        assertTrue(isInteger(Integer.MIN_VALUE + ""));
    }
}
