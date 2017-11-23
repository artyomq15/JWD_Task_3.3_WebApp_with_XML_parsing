package by.tr.parser.controller.util;

public class PaginationHelper {
    private static final int ELEMENTS_ON_PAGE = 5;
    private static final String INTEGER_PATTERN = "[0-9]+";


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

    public static Pagination getPagination(String current, int size){
        Pagination pagination = new Pagination();
        int currentPage;

        if (current != null && current.matches(INTEGER_PATTERN)) {
            currentPage = Integer.parseInt(current);
            if (currentPage<=0 || currentPage>=size){
                return null;
            }
        } else {
            return null;
        }
        pagination.setCurrent(currentPage);
        pagination.setLast(PaginationHelper.getLastPageNumber(size));
        if (currentPage != pagination.getFirst()) {
            pagination.setPrevious(currentPage - 1);
        }
        if (currentPage < pagination.getLast()) {
            pagination.setNext(currentPage + 1);
        } else{
            pagination.setNext(currentPage);
        }
        return pagination;
    }
}
