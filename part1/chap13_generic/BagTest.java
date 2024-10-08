package part1.chap13_generic;

class Bag<T> {
    private T thing;

    public Bag(T thing) {
        this.thing = thing;
    }

    public T getThing() {
        return thing;
    }

    public void setThing(T thing) {
        this.thing = thing;
    }

    void showType() {
        System.out.println("T의 타입은 " + thing.getClass().getName());
    }
}

class Book {
}

class PencilCase {
}

class Notebook {
}

public class BagTest {

    public static void main(String[] args) {
        Bag<Book> bag = new Bag<>(new Book());
        Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
        Bag<Notebook> bag3 = new Bag<>(new Notebook());

        bag.showType();
        bag2.showType();
        bag3.showType();

        Book b = bag.getThing();
        PencilCase pc = bag2.getThing();
        Notebook nb = bag3.getThing();

//		bag = bag2;
//		bag2 = bag3;
        //에러 발생= 좋은거(엄격한 제네릭)
    }
}