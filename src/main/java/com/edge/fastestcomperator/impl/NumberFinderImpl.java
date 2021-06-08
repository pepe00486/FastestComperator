package com.edge.fastestcomperator.impl;

import com.edge.fastestcomperator.api.NumberFinder;
import com.edge.fastestcomperator.comperators.FastestComparator;
import com.edge.fastestcomperator.pojo.CustomNumberEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import static com.edge.fastestcomperator.utils.ListSerializer.serializeFile;
import static com.edge.fastestcomperator.utils.StringHelper.isInteger;

public class NumberFinderImpl implements NumberFinder {
    private final Logger logger = LoggerFactory.getLogger(NumberFinderImpl.class);

    public boolean contains(final int valueToFind, final List<CustomNumberEntity> list) {
        final FastestComparator comparator = new FastestComparator();
        final Predicate<CustomNumberEntity> containsValueToFind = customNumberEntity ->
                compare(comparator, customNumberEntity, valueToFind);
        return list.stream()
                .filter(customNumberEntity -> isInteger(customNumberEntity.getNumber()))
                .distinct()
                .parallel()
                .anyMatch(containsValueToFind);
    }

    public List<CustomNumberEntity> readFromFile(final String filePath) {
        final File file = new File(filePath);
        if (file.exists()) {
            return serializeFile(file);
        } else {
            logger.error("File with given path {} was not found", filePath);
            return Collections.emptyList();
        }
    }

    private boolean compare(final FastestComparator comparator, final CustomNumberEntity entity, final int valueToFind) {
        try {
            return comparator.compare(valueToFind, entity) == 0;
        } catch (NumberFormatException efException) {
            return false;
        }
    }
}
