package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.Objects;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        int count = 0;
        String[] toRemove = Arrays.copyOf(super.array, super.array.length);
        for(int i = 0; i < toRemove.length; i++ ) {
            count = getNumberOfOccurrences(toRemove, toRemove[i]);
            if (count >= maxNumberOfDuplications) {
                toRemove = removeValue(toRemove, toRemove[i]);
                i--;
            }
        }

        String[] removed = Arrays.copyOf(toRemove, toRemove.length);
        return removed;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int count = 0;
        String[] toRemove = Arrays.copyOf(super.array, super.array.length);
        for(int i = 0; i < toRemove.length; i++ ) {
            count = getNumberOfOccurrences(toRemove, toRemove[i]);
            if (count == exactNumberOfDuplications) {
                toRemove = removeValue(toRemove, toRemove[i]);
                i--;
            }
        }

        String[] removed = Arrays.copyOf(toRemove, toRemove.length);
        return removed;
    }

    public Integer getNumberOfOccurrences(String[] intArray, String intToCount) {
        Integer count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i].equals(intToCount)) {
                count++;
            }
        }
        return count;
    }


    public String[] removeValue(String[] intArray, String intToRemove) {
        String[] resultArray = new String[intArray.length
                - getNumberOfOccurrences(intArray, intToRemove)];
        int count = 0;
        for (String s : intArray) {
            if (!Objects.equals(intToRemove, s)) {
                resultArray[count] = s;
                count++;
            }
        }
        return Arrays.copyOf(resultArray, resultArray.length, String[].class);
    }
}
