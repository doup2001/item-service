package hello.itemservice.domain;

import lombok.Data;

@Data
public class Item {

    private Long ItemID;
    private String ItemName;
    private Integer price;
    private Integer quantity;

    public Item(String itemName, Integer price, Integer quantity) {
        ItemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

}
