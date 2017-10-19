package pattern.strategy;

public class Dog implements Comparable{
	private int food;

	public Dog(int food) {
		this.food = food;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int food) {
		this.food = food;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Dog ){
			Dog c = (Dog)o;
			if(this.getFood() > c.getFood()) {
				return 1;
			}else if(this.getFood() < c.getFood()) {
				return -1;
			}else {
				return 0;
			}
		}else {
			return -100;
		}
	}
}
