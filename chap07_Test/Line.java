package chap07_Test;

public class Line extends Geometry {
    Point start;
    Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    void draw() {
        System.out.println("Line from (" + start.x + ", " + start.y + ") to (" + end.x + ", " + end.y + ")");
    }
}

Math.sqrt(Math.powe)