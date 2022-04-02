package com.company;

import com.company.exceptions.CheckIndexException;
import com.company.exceptions.ElementIsNullException;
import com.company.exceptions.ElementNotFoundException;

public class StringListImpl implements StringList {

    private String[] myList = new String[10];
    private int size = 0;

    @Override
    public String add(String item) {
        myList[size] = item;
        size++;
        increaseMyList();
        return item;
    }

    @Override
    public String add(int index, String item) {
        checkIndex(index);
        increaseMyList();
        for (int i = size - 1; i >= index; i--) {
            myList[i + 1] = myList[i];
        }
        myList[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        myList[index] = item;
        return item;
    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String result = myList[index];
        for (int i = index; i < size; i++) {
            myList[i] = myList[i + 1];
        }
        size--;
        return result;
    }

    @Override
    public String remove(String item) {
        int a = -1;
        for (int i = 0; i < size; i++) {
            if (item.equals(myList[i])) {
                a = i;
                break;
            }
        }
        if (a != -1) {
            remove(a);
        } else {
            throw new ElementNotFoundException("Элемент в списке не найден");
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (myList[i].equals(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public int indexOf(String item) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (myList[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(String item) {
        int result = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (myList[i].equals(item)) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return myList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new ElementIsNullException("В качестве параметра передан пустой элемент");
        }
        boolean result = true;
        if (this.size != otherList.size()) {
            result = false;
       } else {
            for (int i = 0; i < this.size; i++) {
                if (!this.get(i).equals(otherList.get(i))) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean result = true;
        for (String s : myList) {
            if (s != null) {
                result = false;
                break;
            }
        }
        return result;
    }

    @Override
    public void clear() {
        myList = new String[10];
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] newListFromOldList = new String[this.size];
        for (int i = 0; i < newListFromOldList.length; i++) {
            newListFromOldList[i] = this.get(i);
        }
        return newListFromOldList;
    }


    private void checkIndex(int index) {
        if (index < 0 || index > myList.length - 1) {
            throw new CheckIndexException("Индекс выходит за пределы листа!");
        }
        if (index > size - 1) {
            throw new CheckIndexException("Элемент по указанному индексу отсутствует");
        }
    }

    private void increaseMyList() {
        if (size == myList.length) {
            String[] newList = new String[myList.length * 2];
            for (int i = 0; i < myList.length; i++) {
                newList[i] = myList[i];
            }
            myList = newList;
        }
    }
}
