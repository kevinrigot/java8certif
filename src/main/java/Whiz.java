import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class Whiz {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		UnaryOperator<String> un = UnaryOperator.identity();
		list.forEach(s -> un.apply(s));
		System.out.println(list);
		
		IntFunction<String> in = Integer::toString;
		IntStream ints = IntStream.of(2,1,4,3) ;
		//ints.boxed().map(Integer::toString); --> Ambigous
		ints.mapToObj(i-> Integer.toString(i));
		
	}
}