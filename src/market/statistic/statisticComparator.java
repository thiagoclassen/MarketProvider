package market.statistic;

import java.util.Comparator;

public class statisticComparator implements Comparator<ItemData>{

	@Override
	public int compare(ItemData o, ItemData o2) {
		return -1*Double.compare(o.getPrecoMedio(), o2.getPrecoMedio()); 
	}
	
}
