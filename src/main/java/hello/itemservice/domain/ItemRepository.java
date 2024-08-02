package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository{

    private static final Map<String, Object> store = new HashMap<>();
    private static final long sequence = 0L;

    public Item save(Item item) {

    }

    public Item findByID() {

    }

    public List<Member> findByAll() {

    }

    public void deleteAll() {

    }



}
