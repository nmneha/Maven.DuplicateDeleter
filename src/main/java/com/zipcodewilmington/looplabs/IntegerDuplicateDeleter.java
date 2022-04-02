package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        int count = 0;
        Integer[] toRemove = Arrays.copyOf(super.array, super.array.length);
        for(int i = 0; i < toRemove.length; i++ ) {
            count = getNumberOfOccurrences(toRemove, toRemove[i]);
            if (count >= maxNumberOfDuplications) {
                  toRemove = removeValue(toRemove, toRemove[i]);
                  i--;
            }
        }

        Integer[] removed = Arrays.copyOf(toRemove, toRemove.length);
        return removed;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        return new Integer[0];
    }

    public static Integer getNumberOfOccurrences(Integer[] intArray, int intToCount) {
        Integer count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if(intArray[i].equals(intToCount)) {
                count++;
            }
        }
        return count;
    }


    public Integer[] removeValue(Integer[] intArray, int intToRemove) {
        Integer[] resultArray = new Integer[intArray.length
                - getNumberOfOccurrences(intArray, intToRemove)];
        int count = 0;
        for (int i = 0; i < intArray.length; i++) {
            if (intToRemove != intArray[i]) {
                resultArray[count] = intArray[i];
                count++;
            }
        }
        Integer[] integerArray = Arrays.copyOf(resultArray, resultArray.length, Integer[].class);
        return integerArray;
    }



}
