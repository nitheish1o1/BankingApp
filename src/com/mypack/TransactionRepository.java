package com.mypack;

import java.util.ArrayList;

public class TransactionRepository implements Container {
    public static ArrayList<Integer> transaction_array = new ArrayList<>();
    @Override
    public Iterator getIterator() {
        return new Transaction_arrayIterator();
    }

    private static class Transaction_arrayIterator implements Iterator{
        int index = 0;
        @Override
        public boolean hasnext() {
            if(index < transaction_array.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasnext()){
                return transaction_array.get(index++);
            }
            return null;
        }
    }
}
