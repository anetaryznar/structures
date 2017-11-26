import java.util.Arrays;

public class ArrayList implements List<Double> {
    private double[] elements;
    private int length;

    public ArrayList() {
        elements = new double[10];
        length = 0;
    }

    @Override
    public void add(Double a) {
        if(elements.length == length) {
            double[] temp = new double[length + 10];
            System.arraycopy(elements, 0, temp, 0, length);

            elements = temp;
        }

        elements[length] = a;
        ++length;
    }

    @Override
    public Double get(int i) {
        if(i >= length || i < 0) {
            throw new IndexOutOfBoundsException("can't find index " + i + ", length = " + length);
        }
        return elements[i];
    }

    @Override
    public void remove(int pos) {
        if(pos >= length || pos < 0) {
            throw new IndexOutOfBoundsException("can't find index " + pos + ", length = " + length);
        }

        for(int i = pos; i < length - 1;++i) {
            elements[i] = elements[i + 1];
        }
        --length;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
