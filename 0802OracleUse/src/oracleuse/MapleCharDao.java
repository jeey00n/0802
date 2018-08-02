package oracleuse;

import java.util.List;

public interface MapleCharDao {
	// 데이터를 삽입하는 메소드
	public boolean insertMapleChar(MapleChar mapleChar);
	// 데이터를 수정하는 메소드
	public boolean updateMapleChar(MapleChar mapleChar);
	// 데이터를 삭제하는 메소드
	public boolean deleteMapleChar(int accessnum);
	
	// 데이터 전체를 읽어오는 메소드
	// 데이터가 0개 이상이므로 List로 리턴하고 읽어 올 컬럼들을 저장할 DTO클래스나 Map으로 제너릭을 적용
	public List<MapleChar> allMapleChar ();
	
	// 닉네임을 가지고 조회하는 메소드
	public List<MapleChar> nicknameMapleChar (String nickname);
}
