package chap8_list;

import java.util.Comparator;
import java.util.Scanner;

class SimpleObject2 {
    // --- 회원번호로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject2> NO_ORDER = new NoOrderComparator();
    // --- 이름으로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject2> NAME_ORDER = new NameOrderComparator();
    static final int NO = 1; // 번호를 읽어 들일까요?
    static final int NAME = 2; // 이름을 읽어 들일까요?
    String no; // 회원번호
    String name; // 이름

    public SimpleObject2(String sno, String sname) {
        this.no = sno;
        this.name = sname;
    }

    public SimpleObject2() {
        this.no = null;
        this.name = null;
    }

    // --- 문자열 표현을 반환 ---//
    @Override
    public String toString() {
        return "(" + no + ") " + name;
    }

    // --- 데이터를 읽어 들임 ---//
    void scanData(String guide, int sw) {
        Scanner sc = new Scanner(System.in);
        System.out.println(guide + "할 데이터를 입력하세요." + sw);

        if ((sw & NO) == NO) { // & 는 bit 연산자임
            System.out.print("번호: ");
            no = sc.next();
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            name = sc.next();
        }
    }

    private static class NoOrderComparator implements Comparator<SimpleObject2> {
        @Override
        public int compare(SimpleObject2 d1, SimpleObject2 d2) {
            return Integer.compare(d1.no.compareTo(d2.no), 0);
        }
    }

    private static class NameOrderComparator implements Comparator<SimpleObject2> {
        @Override
        public int compare(SimpleObject2 d1, SimpleObject2 d2) {
            return Integer.compare(d1.name.compareTo(d2.name), 0);
        }
    }
}

class Node4 {
    SimpleObject2 data; // 데이터
    Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
    Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

    // --- 생성자(constructor) ---//
    Node4(SimpleObject2 so) {
        this.data = so;
        llink = rlink = this;
    }

    Node4() { // head node로 사용
        this.data = null;
        llink = rlink = this;
    }

    Node4(String sno, String sname) {
        data = new SimpleObject2(sno, sname);
        llink = rlink = this;
    }

    public int compareNode(Node4 n2) {
        SimpleObject2 so1 = this.data;
        return Integer.compare(SimpleObject2.NO_ORDER.compare(so1, n2.data), 0);
    }
}

class DoubledLinkedList2 {
    private final Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

    // --- 생성자(constructor) ---//
    public DoubledLinkedList2() {
        first = new Node4(); // dummy(first) 노드를 생성
    }

    // --- 리스트가 비어있는가? ---//
    public boolean isEmpty() {
        return first.rlink == first;
    }

    // --- 노드를 검색 ---//
    public boolean search(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
        return false;
    }

    // --- 전체 노드 표시 ---//
    public void show() {
        Node4 p = first.rlink; // 다음 노드로의 참조

        while (p != first) {
            System.out.println(p.data);
            p = p.rlink; // 뒤쪽 노드로 이동
        }
    }

    // --- 올림차순으로 정렬이 되도록 insert ---//
    public void add(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
        Node4 p = first; // 스캔중인 노드
        Node4 t = new Node4(obj); // 삽입할 노드

        while (p.rlink != first && c.compare(p.rlink.data, obj) < 0)
            p = p.rlink;
        t.rlink = p.rlink;
        p.rlink.llink = t;
        t.llink = p;
        p.rlink = t;
    }

    // --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
    public void delete(SimpleObject2 obj, Comparator<? super SimpleObject2> c) {
        Node4 p = first.rlink; // 스캔중인 노드

        while (p != first) {
            if (c.compare(p.data, obj) == 0) { // 삭제할 노드 발견
                p.llink.rlink = p.rlink;
                p.rlink.llink = p.llink;
                break;
            }
            p = p.rlink; // 다음 노드로 이동
        }
        if (p == first) // 삭제할 노드 발견하지 못함
            System.out.println("찾는 데이터가 없습니다.");
    }

    public DoubledLinkedList2 merge(DoubledLinkedList2 lst2) {
        DoubledLinkedList2 mergedList = new DoubledLinkedList2();
        Node4 p1 = this.first.rlink;
        Node4 p2 = lst2.first.rlink;

        while (p1 != this.first && p2 != lst2.first) {
            if (SimpleObject2.NO_ORDER.compare(p1.data, p2.data) < 0) {
                mergedList.add(p1.data, SimpleObject2.NO_ORDER);
                p1 = p1.rlink;
            } else {
                mergedList.add(p2.data, SimpleObject2.NO_ORDER);
                p2 = p2.rlink;
            }
        }

        // 첫 번째 리스트의 나머지 노드 추가
        while (p1 != this.first) {
            mergedList.add(p1.data, SimpleObject2.NO_ORDER);
            p1 = p1.rlink;
        }

        // 두 번째 리스트의 나머지 노드 추가
        while (p2 != lst2.first) {
            mergedList.add(p2.data, SimpleObject2.NO_ORDER);
            p2 = p2.rlink;
        }

        return mergedList;
    }
}

public class test_객체이중리스트 {
    // --- 메뉴 선택 ---//
    static Menu SelectMenu() {
        Scanner sc1 = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
                    System.out.println();
            }
            System.out.print(" : ");
            key = sc1.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu; // 메뉴
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Linked List");
        DoubledLinkedList2 lst1 = new DoubledLinkedList2(), lst2 = new DoubledLinkedList2(), lst3;
        String sno1 = null, sname1 = null;
        SimpleObject2 so;
        boolean result = false;
        do {
            switch (menu = SelectMenu()) {
                case Add: // 머리노드 삽입
                    so = new SimpleObject2();
                    so.scanData("입력", 3);
                    lst1.add(so, SimpleObject2.NO_ORDER);
                    break;
                case Delete: // 머리 노드 삭제
                    so = new SimpleObject2();
                    so.scanData("삭제", SimpleObject2.NO);
                    lst1.delete(so, SimpleObject2.NO_ORDER);
                    break;
                case Show: // 꼬리 노드 삭제
                    lst1.show();
                    break;
                case Search: // 회원 번호 검색
                    so = new SimpleObject2();
                    so.scanData("탐색", SimpleObject2.NO);
                    result = lst1.search(so, SimpleObject2.NO_ORDER);
                    if (!result)
                        System.out.println("검색 값 = " + so + "데이터가 없습니다.");
                    else
                        System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
                    break;
                case Merge:
                    for (int i = 0; i < 3; i++) {
                        so = new SimpleObject2();
                        so.scanData("입력", 3);
                        lst2.add(so, SimpleObject2.NO_ORDER);
                    }
                    lst3 = lst1.merge(lst2);
                    System.out.println("list1: ");
                    lst1.show();
                    System.out.println("list2: ");
                    lst2.show();
                    System.out.println("list3: ");
                    lst3.show();
                    break;
                case Exit: // 꼬리 노드 삭제
                    break;
            }
        } while (menu != Menu.Exit);
    }

    enum Menu {
        Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("병합"), Exit("종료");

        private final String message; // 표시할 문자열

        Menu(String string) { // 생성자(constructor)
            message = string;
        }

        static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        String getMessage() { // 표시할 문자열을 반환
            return message;
        }
    }
}
