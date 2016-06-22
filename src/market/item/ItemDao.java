package market.item;

import java.util.ArrayList;

public interface ItemDao {
	ArrayList<Item>getAllItems();
	void updateItem(Item item);
	void deleteItem(Item item);
	void addItem(Item item);
}
