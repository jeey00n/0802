package oracleuse;

import java.sql.Date;
import java.util.Calendar;

public class MapleCharMain {

	public static void main(String[] args) {
//		// 인터페이스나 클래스를 상속한 경우 상위 인터페이스나 클래스 이름으로 변수를 만들고 하위 클래스의 인스턴스를 생성해서 대입한다.
		MapleCharDao dao = new MapleCharDaoImp();
		MapleChar mapleChar = new MapleChar();
		mapleChar.setAccessnum(5);
		mapleChar.setNexonid("");
		mapleChar.setNickname("뜨끈한손난로");
		mapleChar.setJob("아크");
		
		//현재 시간을 저장할 캘린더 생성
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2018);
		cal.set(Calendar.MONTH, 7);
		cal.set(Calendar.DAY_OF_MONTH, 27);
		Date createDate = new Date(cal.getTimeInMillis());
		mapleChar.setCreatedate(createDate);
		
		// 데이터를 삭제하는 메소드 호출
		boolean result = dao.insertMapleChar(mapleChar);
		if (result == true) {
			System.out.println("삽입 성공");
		} else {
			System.out.println("삽입 실패 - 예외를 확인하세요.");
		}
	}
}
