package lamda;

import java.util.ArrayList;
import java.util.List;

public class TestLamda {
	public static void main(String[] args) {
		List<Model> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(new Model("name" + i, i));
		}

		list.forEach((p) -> System.out.println(p.name + ":" + p.value));
		list.forEach((p) -> p.value+=100);
		list.forEach((p) -> System.out.println(p.name + ":" + p.value));

	}

	static class Model {
		String name;
		int value;

		public Model(String name, int value) {
			this.name = name;
			this.value = value;
		}
	}
}
