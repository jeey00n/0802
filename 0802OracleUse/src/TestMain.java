import javax.sound.midi.Soundbank;

public class TestMain {

	public static void main(String[] args) {
		// 생성자를 이용해서 객체를 생성
//		T obj1 = new T();
//		T obj2 = new T();

		// 싱글톤 패턴을 적용한 클래스의 객체 만들기
		T obj1 = T.getInstance();
		T obj2 = T.getInstance();
		//해시코드 출력
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
	}
}
