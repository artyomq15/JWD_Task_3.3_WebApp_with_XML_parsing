package by.tr.parser.controller.util;

import java.io.Serializable;

public class Pagination implements Serializable {
    private static final long serialVersionUID = -2311039667918672652L;

    private int first;
    private int previous;
    private int current;
    private int next;
    private int last;

    public Pagination() {
        first = 1;
        current = 1;
        previous = 1;
        next = 1;
        last = 1;
    }

    public int getFirst() {
        return first;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Pagination)) return false;

        Pagination that = (Pagination) object;

        if (first != that.first) return false;
        if (previous != that.previous) return false;
        if (current != that.current) return false;
        if (next != that.next) return false;
        return last == that.last;

    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + previous;
        result = 31 * result + current;
        result = 31 * result + next;
        result = 31 * result + last;
        return result;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "first=" + first +
                ", previous=" + previous +
                ", current=" + current +
                ", next=" + next +
                ", last=" + last +
                '}';
    }
}
