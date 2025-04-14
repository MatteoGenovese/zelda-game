package org.example.items;

import java.util.ArrayList;
import java.util.List;

public class Bag <T extends Item>{

    List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems(){
        return items;
    }

    public void removeItem(T itemToRemove){
        int index = 0;
        for (T item : items){
            if (item.getName().equals(itemToRemove.getName())){
                items.remove(index);
            }
            index++;
        }
    }

    @Override
    public String toString() {
        return "Bag{" +
                "items=" + items +
                '}';
    }
}
