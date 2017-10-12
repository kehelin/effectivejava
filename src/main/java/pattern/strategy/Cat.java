package pattern.strategy;

public class Cat {
	private int height;
	private int weight;

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
	public String toString() {
		return "Cat{" +
				"height=" + height +
				", weight=" + weight +
				'}';
	}
}
