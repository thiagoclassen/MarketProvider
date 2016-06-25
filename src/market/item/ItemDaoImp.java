package market.item;

import java.util.ArrayList;

import market.data.FileManager;

public class ItemDaoImp implements ItemDao{

	private static ArrayList<Item> items;
	
	private static ItemDaoImp instance;
	
	public static ItemDaoImp getInstance() {

		if (instance == null) {
			instance = new ItemDaoImp();
			items = FileManager.loadItems();
		}
		return instance;
	}
	
	private ItemDaoImp() {
		items = new ArrayList<Item>();
	}
	
	@Override
	public ArrayList<Item> getAllItems() {
		return items;
	}

	@Override
	public void updateItem(Item item) {
		//TODO - throw error if the item doesn't exists
		int pos = items.indexOf(item);
		if(pos != -1){
			items.set(pos, item);
			writeItems();
		}
	}

	@Override
	public void deleteItem(Item item) {
		//TODO - throw error if the item doesn't exists
		int pos = items.indexOf(item);
		if(pos != -1){
			items.remove(pos);
			writeItems();
		}
	}

	@Override
	public void addItem(Item item) {
		items.add(item);
		writeItems();
	}
	
	private void writeItems(){
		FileManager.writeItems(items);
	}

}
