package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository{

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setItemID(++sequence);
        store.put(item.getItemID(), item);
        return item;
    }

    public Item findByID(Long id) {
        return store.get(id);
    }

    public List<Item> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId,Item updateItem) {

        Item findByID = findByID(itemId);
        findByID.setItemName(updateItem.getItemName());
        findByID.setPrice(updateItem.getPrice());
        findByID.setQuantity(updateItem.getQuantity());

    }

    public void deleteAll() {
        store.clear();
    }



}

