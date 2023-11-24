package chap4_StackAndQueue;
import java.util.Comparator;

class X {
    // 필드, 메소드 등
    public static final Comparator<T> COMPARATOR = new Comp();

    private static class Comp implements Comparator<T> {
        public <T> int compare(T d1, T d2) {
            // d1이 d2보다 크면 양의 값을,
            // d1이 d2보다 작으면 음의 값을,
            // d1이 d2와 같으면 0을 반환합니다.
        }

		@Override
		public int compare(T o1, T o2) {
			return 0;
		}
    }
}