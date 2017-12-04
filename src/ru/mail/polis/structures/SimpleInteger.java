package ru.mail.polis.structures;

/**
 * Created by Nechaev Mikhail
 * Since 12/11/2017.
 */
public class SimpleInteger implements Numerical, Comparable<SimpleInteger> {

    private static final int DIGIT_COUNT = 10;

    private Integer data = null;

    public SimpleInteger(Integer data) throws IllegalArgumentException {
        if (data == null) {
            throw new IllegalArgumentException("Source must be not null");
        }
        this.data = new Integer(data);
    }

    @Override
    public int getDigit(int index) throws IndexOutOfBoundsException {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index " + index);
        } else if (index >= getDigitCount()) {
            return 0;
        } else {
            return String.valueOf(data).charAt(index) - '0';

        }
    }

    @Override
    public int getDigitMaxValue() {
        return DIGIT_COUNT;
    }

    @Override
    public int getDigitCount() {
        return String.valueOf(data).length();
    }

    @Override
    public int compareTo(SimpleInteger anotherSimpleInteger) {
        return 0;
    }

    public Integer getInteger() {
        return data;
    }
}
