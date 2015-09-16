package chapter_6.ex_06_07;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LongestValue {

	public static String search(ConcurrentHashMap<String, Long> map) {
		Entry<String, Long> entry = map.reduceEntries(2L, (entry1, entry2) -> {
			if(entry1.getValue() < entry2.getValue())
				return entry2;
			else
				return entry1;
		});

		return entry.getKey();
	}
}
