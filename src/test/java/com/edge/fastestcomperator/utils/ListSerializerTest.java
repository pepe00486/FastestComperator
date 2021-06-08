package com.edge.fastestcomperator.utils;

import org.junit.Test;

import java.io.File;

import static com.edge.fastestcomperator.utils.ListSerializer.serializeFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListSerializerTest {
    @Test
    public void ListSerializer_serializeFile_valid_file_return_list_of_9() {
        File file = new File("src/test/resources/validResource.json");
        assertEquals(serializeFile(file).size(), 9);
    }

    @Test
    public void ListSerializer_serializeFile_empty_file_return_empty_list() {
        File file = new File("src/test/resources/empty.json");
        assertTrue(serializeFile(file).isEmpty());
    }

    @Test
    public void ListSerializer_serializeFile_missformatted_file_return_empty_list() {
        File file = new File("src/test/resources/missformatted.json");
        assertTrue(serializeFile(file).isEmpty());
    }

    @Test
    public void ListSerializer_serializeFile_invalid_file_return_empty_list() {
        File file = new File("src/test/resources/invalid.json");
        assertTrue(serializeFile(file).isEmpty());
    }

    @Test
    public void ListSerializer_serializeFile_partly_invalid_file_return_empty_list2() {
        File file = new File("src/test/resources/partlyInvalid.json");
        assertTrue(serializeFile(file).isEmpty());
    }
}
