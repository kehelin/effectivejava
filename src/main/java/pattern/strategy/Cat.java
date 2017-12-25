package pattern.strategy;

import java.util.Comparator;

public class Cat implements Comparable{
	private int height;
	private int weight;
	private Comparator<Cat> comparator = new CatComparator();

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Cat(int height, int weight) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Object o) {
		Cat c = (Cat)o;
		if(this.getHeight() > c.getHeight()) {
			return 1;
		}else if(this.getHeight() < c.getHeight()) {
			return -1;
		}else {
			return 0;
		}
	}


	@Override
	public String toString() {
		return "Cat{" +
				"height=" + height +
				", weight=" + weight +
				'}';
	}
}
