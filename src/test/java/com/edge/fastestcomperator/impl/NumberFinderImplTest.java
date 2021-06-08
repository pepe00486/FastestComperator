package com.edge.fastestcomperator.impl;

import com.edge.fastestcomperator.api.NumberFinder;
import com.edge.fastestcomperator.pojo.CustomNumberEntity;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class NumberFinderImplTest {
    final NumberFinder numberFinder = new NumberFinderImpl();

    @Test
    public void NumberFinderImpl_readFromFile_valid_file_returns_9_items_list() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validResource.json");
        assertEquals(9, valid.size());
    }

    @Test
    public void NumberFinderImpl_readFromFile_invalid_file_returns_empty_list() {
        List<CustomNumberEntity> nonExisting = numberFinder.readFromFile("src/test/resources/testResNonExisting.json");
        assertTrue(nonExisting.isEmpty());
    }

    @Test
    public void NumberFinderImpl_contains_should_return_true_for_input_100() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validResource.json");
        assertTrue(numberFinder.contains(100, valid));
    }

    @Test
    public void NumberFinderImpl_contains_should_return_false_for_input_4() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validResource.json");
        assertFalse(numberFinder.contains(4, valid));
    }

    @Test
    public void NumberFinderImpl_contains_should_return_true_for_input_MAX_INT() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validResource.json");
        assertTrue(numberFinder.contains(Integer.MAX_VALUE, valid));
    }

    @Test
    public void NumberFinderImpl_contains_should_return_false_for_input_MAX_INT_plus_1() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validResource.json");
        assertFalse(numberFinder.contains(Integer.MAX_VALUE + 1, valid));
    }

    @Test
    public void NumberFinderImpl_contains_should_return_true_for_input_999_in_large_file() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validLarge.json");
        assertTrue(numberFinder.contains(999, valid));
    }

    @Test
    public void NumberFinderImpl_contains_should_return_false_for_input_999_in_large_number_file() {
        List<CustomNumberEntity> valid = numberFinder.readFromFile("src/test/resources/validLargeNumber.json");
        assertFalse(numberFinder.contains(999, valid));
    }
}
