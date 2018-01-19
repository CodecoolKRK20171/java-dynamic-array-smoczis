package com.codecool.dynamicArrayDojo;

// put your code here!
class DynamicIntArray {

    private int[] data;
    private int size;

    DynamicIntArray() {
        this.size = 0;
        this.data = new int[this.size];
    }

    DynamicIntArray(int initialSize) {
        this.size = initialSize;
        this.data = new int[size];
    }

    void add(int value) {
        extendArray();
        this.data[size-1] = value;
    }

    void remove(int value) {
        int idx = -1;
        for(int i=0; i<this.size; i++) {
            if(this.data[i] == value) { idx = this.data[i]; }
        }

        if(idx >= 0) { shrinkArray(idx); }
        else { throw new ArrayIndexOutOfBoundsException("Info"); }
    }

    void insert(int index, int value) {

        if(index > this.size) { index = size; }
        extendArray();
        moveElementsRightFrom(index);
        data[index] = value;

    }

    private void moveElementsRightFrom(int index) {
        for(int end = size-1; end>=index; end--) {
            data[end] = data[end-1];
        }
    }

    private void extendArray() {
        int[] extendedArray = new int[++this.size];
        for(int i=0; i<this.size-1; i++) {
            extendedArray[i] = data[i];
        }
        this.data = extendedArray;
    }

    private void shrinkArray(int index) {
        int[] shrinkedArray = new int[--this.size];

        for(int i=0; i<index; i++) {
            shrinkedArray[i] = data[i];
        }

        for(int i=index; i<this.size; i++) {
            shrinkedArray[i] = data[i+1];
        }

        data = shrinkedArray;
    }

    public String toString() {
        StringBuilder result = new StringBuilder("");
        for(int i : this.data) {
            result.append(" ").append(i);
        }
        return result.toString();
    }




}
