package hello.itemservice.web;


import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Slf4j
@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {

        List<Item> items = itemRepository.findByAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @PostConstruct
    public void init() {
        itemRepository.save(new Item("exampleA", 1000, 1));
        itemRepository.save(new Item("exampleB", 2000, 2));

    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addItemV4(@ModelAttribute Item item, RedirectAttributes redirectAttributes) {
        itemRepository.save(item);
        redirectAttributes.addAttribute("itemId", item.getId());
        redirectAttributes.addAttribute("itemName", item.getItemName());
        redirectAttributes.addAttribute("price", item.getPrice());
        redirectAttributes.addAttribute("quantity", item.getQuantity());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/items/{itemId}";
    }

    // 변수명과 @Pathvariable을 맞춰야한다.
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findByID(itemId);
        model.addAttribute("item", item);

        return "/basic/item";
    }

    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findByID(itemId);
        model.addAttribute("item", item);

        return "basic/editForm";
    }

    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute Item updateItem,Model model) {

        Item item = itemRepository.update(itemId, updateItem);
        model.addAttribute("item", item);

        return "redirect:/basic/items/{itemId}";
    }
}

