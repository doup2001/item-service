package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository{

    private static final Map<Long, Item> store = new HashMap<>();
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findByID(Long id) {
        return store.get(id);
    }

    public List<Item> findByAll() {
        return new ArrayList<>(store.values());
    }

    public Item update(Long itemId,Item updateItem) {

        Item findByID = findByID(itemId);
        findByID.setItemName(updateItem.getItemName());
        findByID.setPrice(updateItem.getPrice());
        findByID.setQuantity(updateItem.getQuantity());

        return findByID;
    }

    public void deleteAll() {
        store.clear();
    }

}

