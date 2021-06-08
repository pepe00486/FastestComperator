package com.edge.fastestcomperator.utils;

import com.edge.fastestcomperator.pojo.CustomNumberEntity;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class ListSerializer {
    private static final Logger logger = LoggerFactory.getLogger(ListSerializer.class);

    private ListSerializer() {
    }

    public static List<CustomNumberEntity> serializeFile(final File file) {
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            final JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, CustomNumberEntity.class);
            return objectMapper.readValue(file, type);
        } catch (final IOException ioException) {
            logger.error("IOException was thrown while trying to serialize file {}, {} ", file.getPath(), ioException.getMessage());
            return Collections.emptyList();
        }
    }
}
