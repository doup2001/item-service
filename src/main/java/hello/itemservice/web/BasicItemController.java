package hello.itemservice.web;


import hello.itemservice.domain.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Slf4j
@Controller
public class BasicItemController {

    @GetMapping("/basic/items")
    public String items() {
        return "basic/items";
    }

    @GetMapping("/basic/items/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/basic/items/add")
    public String addItem(@ModelAttribute Item item) {

        log.info("test_item_Name = {}", item.getItemName());

        return "ok";
    }
}
