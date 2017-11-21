package by.tr.parser.controller.util;

public class PaginationHelper {
    public static final int ELEMENTS_ON_PAGE = 4;

    public static int getLastPageNumber(int size){
        int lastPageNumber = size/ELEMENTS_ON_PAGE;
        if (size%ELEMENTS_ON_PAGE>0){
            lastPageNumber++;
        }
        return lastPageNumber;
    }

    public static int getFirstElementIndex(int current){
        return (current-1)*ELEMENTS_ON_PAGE;
    }

    public static int getLastElementIndex(int firstElementIndex, int size){
        int lastElementIndex = firstElementIndex + ELEMENTS_ON_PAGE;
        if (lastElementIndex>size){
            lastElementIndex = firstElementIndex + size%ELEMENTS_ON_PAGE;
        }
        return lastElementIndex;
    }
}
