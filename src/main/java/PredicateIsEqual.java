import java.util.function.Predicate;

class PredicateIsEqual {
	public static void main(String args[]) {
		String in = new String("1");
		Predicate<String> ins = Predicate.isEqual(in);
		System.out.println(ins.test("2"));
	}
}