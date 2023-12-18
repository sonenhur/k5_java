package chap4_stackAndQueue;

//선형 큐 구현
import java.util.Scanner;

/*
* Queue of ArrayList
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//int형 고정 길이 큐

class Queue5 {
	private List<Integer> que;// 원형큐로 구현하지 않는다
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

//--- 생성자(constructor) ---//
	public Queue5(int maxlen) {
		capacity = maxlen;
		que = new ArrayList<>();
		front = 0;
		rear = 0;
		num = 0;
	}

//--- 큐에 데이터를 인큐 ---//
	public int enque(int x) throws OverflowQueueException {
		if (num >= capacity)
			throw new OverflowQueueException();
		que.add(x);
		rear = (rear + 1) % capacity;
		num++;
		return x;

	}

//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException();
		int x = que.remove(front);
		front = (front + 1) % capacity;
		num--;
		return x;

	}

//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException();
		return que.get(front);
	}

//--- 큐를 비움 ---//
	public void clear() {
		num = front = rear = 0;
		que.clear();
	}

//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = 0; i < num; i++) {
			if (que.get(i) == x)
				return i;
		}
		return -1;
	}

//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		return num;
	}

//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
		return num <= 0;
	}

//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		return num >= capacity;
	}

//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어있습니다");
		else {
			for (int i = 0; i < num; i++) {
				System.out.print(que.get(i) + " ");
			}
			System.out.println();
		}
	}
}

public class 정수선형큐리스트연습 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue5 oq = new Queue5(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx + ")");
				try {
					oq.enque(rndx);
				} catch (chap4_stackAndQueue.Queue5.OverflowQueueException e) {
					System.out.println("stack이 가득차있습니다.");
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (chap4_stackAndQueue.Queue5.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (chap4_stackAndQueue.Queue5.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다.");
				}
				break;

			case 4: // 덤프
				oq.dump();
				break;
			default:
				break;
			}
		}
	}
}