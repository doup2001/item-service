package hello.itemservice.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    private ItemRepository itemRepository = new ItemRepository();

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


}