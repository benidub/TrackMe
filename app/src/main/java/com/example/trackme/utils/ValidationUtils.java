package com.example.trackme.utils;

import java.util.Collection;

/**
 * Will contain useful validation utils
 */
public class ValidationUtils {

    /**
     * Will check if the collection is null or empty
     * @param collection collection to check
     * @return {@code true} if the collection is null or empty and {@code false} if not
     */
    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * Will check if an array of elements is null or empty
     * @param objects array of elements to check
     * @return {@code true} if the array is null or empty and {@code false} if not
     */
    public static boolean isEmpty(Object[] objects) {
        return (objects == null || objects.length == 0);
    }

}
