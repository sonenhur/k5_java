package chap8_list;

import java.util.Comparator;

public class LinkedList<E> {
	// 노드
	class Node<E> {
		private E data;
		private Node<E> next;

//생성자
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node<E> head; // 머리 포인터
	private Node<E> crnt; // 선택 포인터

	// 생성자
	public LinkedList() {
		head = crnt = null;
	}

	// 노드 검색
	public E search(E obj, Comparator<? super E> c) {
		Node<E> ptr = head; // 현재 스캔중인 노드

		while (ptr != null) {
			if (c.compare(obj, ptr.data) == 0) {
				crnt = ptr;
				return ptr.data;
			}
			ptr = ptr.next;
		}
		return null;
	}

	// 머리에 노드 삽입
	public void addFirst(E obj) {
		Node<E> ptr = head; // 삽입 전의 머리 노드
		head = crnt = new Node<E>(obj, ptr);
	}

	// 꼬리에 노드 삽입
	public void addLast(E obj) {
		if (head == null)
			addFirst(obj);
		else {
			Node<E> ptr = head;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = crnt = new Node<E>(obj, null);
		}
	}

	// 머리 노드를 삭제
	public void removeFirst() {
		if (head != null)
			head = crnt = head.next;
	}

	// 꼬리 노드를 삭제
	public void removeLast() {
		if (head != null) {
			if (head.next == null)	//노드가 하나만 있으면
				removeFirst();		//머리 노드를 삭제
			else {
				Node<E> ptr = head; // 스캔 중인 노드
				Node<E> pre = head;	// 스캔 중인 노드의 앞쪽 노드
				
				while (ptr.next != null) {
					pre = ptr;
					ptr = ptr.next;
				}
				pre.next = null;	
				crnt = pre;			// pre는 삭제 후의 꼬리 노드
			}
		}
	}
	
	//노드 p를 삭제
	public void remove(Node p) {
		if (head != null) {
			if (p == head)
				removeFirst();
			else {
				Node<E> ptr = head;
				
				while (ptr.next != p) {
					ptr = ptr.next;
					if (ptr == null) return;
				}
				ptr.next= p.next;
				crnt = ptr;
			}
		}
	}
	
	//선택 노드를 삭제
	public void removeCurrentNode() {
		remove(crnt);
	}
	
	//모든 노드를 삭제
	public void clear() {
		while (head != null)
			removeFirst();
		crnt = null;
	}
	
	//선택 노드를 하나 뒤쪽으로 진행
	public boolean next() {
		if (crnt == null || crnt.next == null)
			return false;
		crnt = crnt.next;
		return true;
	}
}