import java.util.Optional;
import java.util.function.IntFunction;

public class Dump {

	public static void main(String[] args) {
		Integer i = 1;
		Integer i2 = i / 2;
		System.out.println(i2);

		
		Optional<String> op = Optional.of("10");
		Optional<Integer> map = op.map(s->Integer.decode(s));
		System.out.println(map);
		Optional<Integer> flatMap = op.flatMap(s->Optional.of(Integer.decode(s)));
		System.out.println(flatMap);
	}

}
