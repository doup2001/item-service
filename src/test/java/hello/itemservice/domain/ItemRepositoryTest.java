package hello.itemservice.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemRepositoryTest {

    private final ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void after() {
        itemRepository.deleteAll();
    }

    @Test
    void save() {
        //given

        Item item = new Item("hello", 1000, 1);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        assertThat(item).isEqualTo(saveItem);
    }

    @Test
    void findByID() {
        //given
        Item item = new Item("hello", 1000, 1);
        Item savedItem = itemRepository.save(item);

        //when
        Item byID = itemRepository.findByID(savedItem.getItemID());

        //then
        assertThat(item).isEqualTo(byID);

    }

    @Test
    void findByAll() {
        //given
        Item item = new Item("hello", 1000, 1);
        Item item2 = new Item("health", 1000, 1);


        itemRepository.save(item);
        itemRepository.save(item2);

        //when
        List<Item> items = itemRepository.findByAll();

        //then
        assertThat(items.size()).isEqualTo(2);
        assertThat(items).contains(item, item2);

    }

    @Test
    void update() {

        //given
        Item item = new Item("hello", 1000, 1);
        itemRepository.save(item);

        String update_name = "update";
        Integer update_price =  1000;
        Integer update_quantity = 2;

        //when
        Item updateItem = new Item(update_name, update_price, update_quantity);
        Item updatedItem = itemRepository.update(item.getItemID(), updateItem);

        //then
        assertThat(updatedItem.getItemID()).isEqualTo(item.getItemID());
        assertThat(updatedItem.getItemName()).isEqualTo(update_name);

    }


}