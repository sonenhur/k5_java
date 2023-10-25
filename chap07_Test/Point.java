package chap07_Test;

public class Point extends Geometry {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    void draw() {
        System.out.println("Point at (" + x + ", " + y + ")");
    }
	public void addPoint(int i, int j) {		
	}
	public void printPoint() {
	}

}