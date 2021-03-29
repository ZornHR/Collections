package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCollection<E> implements Collection<E> {

    private int size;

    private Object[] elementData = new Object[10];

    @Override
    public String toString() {
        return "MyCollection{" +
                "size=" + size +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }

    private class MyIterator<T> implements Iterator<T> {

        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return (T) elementData[cursor++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            elementData = Arrays.copyOf(elementData, (int) (size * 1.5f));
        }
        elementData[size++] = e;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>();
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o != null) {
                if (o.equals(elementData[i])) {
                    return true;
                }
            } else {
                if (null == (elementData[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o != null) {
                if (o.equals(elementData[i])) {
                    Object[] arrRem = new Object[elementData.length];
                    // https://javarush.ru/help/9543
                    System.arraycopy(elementData, 0, arrRem, 0, i);
                    System.arraycopy(elementData, i + 1, arrRem, i, elementData.length - 1 - i);
                    elementData = arrRem;
                    size--;
                    return true;
                }
            } else {
                if (null == (elementData[i])) {
                    Object[] arrRem = new Object[elementData.length];
                    // https://javarush.ru/help/9543
                    System.arraycopy(elementData, 0, arrRem, 0, i);
                    System.arraycopy(elementData, i + 1, arrRem, i, elementData.length - 1 - i);
                    elementData = arrRem;
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E x : c) {
            add(x);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        elementData = new Object[10];
    }
}
