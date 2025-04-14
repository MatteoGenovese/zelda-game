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
        T itemToRemove3 = null;
        for (T item : items){
            if (item.getName().equals(itemToRemove.getName())){
                itemToRemove3 = item;

            }
        }
        items.remove(itemToRemove3);
    }

    @Override
    public String toString() {
        return "Bag{" +
                "items=" + items +
                '}';
    }
}
