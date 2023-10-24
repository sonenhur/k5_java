package chap07.Inherit.Test;

public class Marine extends Unit {
	public Marine() {
		super(50L);
	}

	@Override
	public void attack() {
		super.attack();
		System.out.println("총을 쏩니다");
	}

	public void attack(Tank t) {
		t.attacked(this);
	}
}
