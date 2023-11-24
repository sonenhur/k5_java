package part1.chap07.Inherit.Test;

public class Unit {
	private Long health;

	public Unit(Long health) {
		this.health = health;
	}

	public Long getHealth() {
		return health;
	}

	public void setHealth(Long health) {
		this.health = health;
		System.out.println("Health:" + health);
		if (health < 0L) {
			System.out.println("사망");
		}
	}
	public static Long M2T = 30L;
	public static Long T2M = 120L;
	
	public void attack() {
		System.out.print("ddddd");
	}
}
