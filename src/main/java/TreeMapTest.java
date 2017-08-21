import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String args[]) {
//		TreeMap<Key, Integer> tmap = new TreeMap<>();
//		tmap.put(new Key(), 1);
//		tmap.put(new Key(), 2);
//		tmap.put(new Key(), 2);
//		System.out.println(tmap.values());
		
		TreeMap<Key2, Integer> tmap2 = new TreeMap<>();
		tmap2.put(new Key2(), 1);
		tmap2.put(new Key2(), 2);
		tmap2.put(new Key2(), 2);
		System.out.println(tmap2.values());
	}
	static class Key{
	}

	static class Key2 implements Comparable<Key2> {

		@Override
		public int compareTo(Key2 o) {
			return 1;
		}
	}
}