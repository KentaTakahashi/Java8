package chapter_6.ex_06_07;

import static org.junit.Assert.*;

import java.time.ZoneId;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class LongestValueTest {

	ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<String, Long>();
	Long maxValue = Long.MIN_VALUE; //calc expected value
	{
		Random rnd = new Random();
		String[] zoneIds = ZoneId.getAvailableZoneIds().toArray(new String[0]);
		for(int i = 0; i < 100; i++) {
			int keyIndex = rnd.nextInt(zoneIds.length);
			String key = zoneIds[keyIndex];
			long value = rnd.nextLong();
			map.put(key, value);

			if(maxValue < value) //update
				maxValue = value;
		}
		map.forEach((key, value) -> {
			System.out.println(key + "\t: " + value);
		});
	}
	@Test
	public void test() {
		String key = LongestValue.search(map);
		assertEquals(maxValue, map.get(key));

		System.out.println("\nsearched entry is");
		System.out.println(key + "\t: " + map.get(key));
	}

}
