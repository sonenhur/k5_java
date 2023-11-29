package chap4_StackAndQueue;

//List를 사용한 선형 큐 구현  - 큐는 배열 사용한다 
import java.util.Random;
import java.util.Scanner;

// Point3 클래스: 2차원 좌표를 나타내는 클래스
class Point3 {
	private int ix;
	private int iy;

	public Point3(int x, int y) {
		ix = x;
		iy = y;
	}

	@Override
	public String toString() {
		return "<" + ix + ", " + iy + ">";
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}

	// 두 Point3 객체가 같은지 확인
	@Override
	public boolean equals(Object p) {
		if ((this.ix == ((Point3) p).ix) && (this.iy == ((Point3) p).iy))
			return true;
		else
			return false;
	}
}

// 큐를 배열을 사용하여 구현한 클래스
class objectQueue2 {
	private Point3[] que;
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	private int num; // 현재 데이터 개수

	// 큐가 비어있을 때 발생하는 예외
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {
		}
	}

	// 큐가 가득 찼을 때 발생하는 예외
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {
		}
	}

	// 생성자: 큐의 크기를 받아 초기화
	public objectQueue2(int maxlen) {
		que = new Point3[maxlen];
		capacity = maxlen;
		front = rear = num = 0;
	}

	// 큐에 데이터를 인큐
	public int enque(Point3 x) throws OverflowQueueException {
		if (num >= capacity)
			throw new OverflowQueueException();
		que[rear++] = x;
		num++;
		if (rear == capacity)
			rear = 0;
		return num;
	}

	// 큐에서 데이터를 디큐
	public Point3 deque() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException();
		Point3 x = que[front++];
		num--;
		if (front == capacity)
			front = 0;
		return x;
	}

	// 큐에서 데이터를 피크(프런트 데이터를 들여다봄)
	public Point3 peek() throws EmptyQueueException {
		if (num <= 0)
			throw new EmptyQueueException();
		return que[front];
	}

	// 큐를 비움
	public void clear() {
		num = front = rear = 0;
	}

	// 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환
	public int indexOf(Point3 x) {
		for (int i = 0; i < num; i++)
			if (que[(i + front) % capacity].equals(x))
				return i;
		return -1;
	}

	// 큐의 크기를 반환
	public int getCapacity() {
		return capacity;
	}

	// 큐에 쌓여 있는 데이터 개수를 반환
	public int size() {
		return num;
	}

	// 큐가 비어있는가?
	public boolean isEmpty() {
		return num <= 0;
	}

	// 큐가 가득 찼는가?
	public boolean isFull() {
		return num >= capacity;
	}

	// 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력
	public void dump() {
		if (num <= 0)
			System.out.println("큐가 비어 있습니다.");
		else {
			for (int i = 0; i < num; i++)
				System.out.print(que[(i + front) % capacity] + " ");
			System.out.println();
		}
	}
}

// 메인 클래스: 객체 선형 큐를 테스트하는 프로그램
public class _4_4객체선형큐배열 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		objectQueue2 oq = new objectQueue2(4); // 최대 4개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, rndy = 0;
		Point3 p = null;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
				case 1: // 인큐
					rndx = random.nextInt(20);
					rndy = random.nextInt(20);
					System.out.print("입력데이터: (" + rndx + ", " + rndy + ")");
					p = new Point3(rndx, rndy);
					try {
						oq.enque(p);
					} catch (objectQueue2.OverflowQueueException e) {
						System.out.println("큐가 가득찼있습니다.");
					}
					break;

				case 2: // 디큐
					try {
						p = oq.deque();
						System.out.println("디큐한 데이터는 " + p + "입니다.");
					} catch (objectQueue2.EmptyQueueException e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;

				case 3: // 피크
					try {
						p = oq.peek();
						System.out.println("피크한 데이터는 " + p + "입니다.");
					} catch (objectQueue2.EmptyQueueException e) {
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