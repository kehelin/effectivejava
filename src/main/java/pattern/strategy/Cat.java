package pattern.strategy;

import sun.tools.tree.InstanceOfExpression;

public class Cat implements Comparable{
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
	public int comparteTo(Object o) {
		if(o instanceof Cat) {
			Cat c = (Cat)o;
			if(this.getHeight() > c.getHeight()) {
				return 1;
			}else if(this.getHeight() < c.getHeight()) {
				return -1;
			}else {
				return 0;
			}
		}else {
			return -100;
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
