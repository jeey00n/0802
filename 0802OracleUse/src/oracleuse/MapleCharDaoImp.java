package oracleuse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MapleCharDaoImp implements MapleCharDao {
	// 모든 메소드에서 공통으로 사용할 변수
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// DB 연결을 수행해주는 메소드
	private void connect() {
		try {
			// 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 데이터베이스 연결
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	// 데이터베이스 자원을 해제해주는 메소드
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
	}

	// 가장 큰 num을 찾아오는 메소드
	// sql: select max(accessnum) from maplechar
	private int getMaxNum() {
		int result = -1;

//		Connection con = null;
//		PreparedStatement pstmt = null;
//		// select구문의 결과를 저장하기 위한 변수
//		ResultSet rs = null;
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			connect();
			// 가장 큰 글 번호를 찾아오는 sql을 실행하는 객체 생성
			pstmt = con.prepareStatement("select max(accessnum) from maplechar");
			// sql 실행
			rs = pstmt.executeQuery();
			// 결과 읽기
			while (rs.next()) {
				// select절의 첫 번째 컬럼의 값을 정수로 읽어서 result에 저장
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (Exception e) {
//			}
			close();
		}
		return result;
	}

	@Override
	// 데이터를 삽입하는 메소드
	public boolean insertMapleChar(MapleChar mapleChar) {
		boolean result = false;
//		Connection con = null;
//		PreparedStatement pstmt = null;
		try {
			// 가장 큰 번호 찾아오는 SQL 실행
			int maxNum = getMaxNum();

//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			connect();
			pstmt = con.prepareStatement(
					"insert into maplechar(accessnum, nexonid, createdate, nickname, job) values (?, ?, ?, ?, ?)");
			// 물음표에 값 바인딩
			// 가장 큰 번호+1로 설정
			pstmt.setInt(1, maxNum + 1);
			pstmt.setString(2, mapleChar.getNexonid());
			pstmt.setDate(3, mapleChar.getCreatedate());
			pstmt.setString(4, mapleChar.getNickname());
			pstmt.setString(5, mapleChar.getJob());

			// select를 제외한 실행구문은 executeUpdate로 실행
			// 실행결과는 영향받은 행의 개수를 정수로 리턴
			int r = pstmt.executeUpdate();
			if (r > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (con != null)
//					con.close();
//			} catch (Exception e) {
//			}
			close();
		}

		return result;
	}

	@Override
	public boolean updateMapleChar(MapleChar mapleChar) {
		boolean result = false;
		connect();
		try {
			// SQL 생성
			pstmt = con.prepareStatement("update maplechar set nexonid=?, createdate=?, nickname=?, job=? where accessnum=?");
			// ?에 실제 데이터 바인딩
			pstmt.setString(1, mapleChar.getNexonid());
			pstmt.setDate(2, mapleChar.getCreatedate());
			pstmt.setString(3, mapleChar.getNickname());
			pstmt.setString(4, mapleChar.getJob());
			pstmt.setInt(5, mapleChar.getAccessnum());
			
			// SQL 실행
			int r = pstmt.executeUpdate();
			if(r>0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}

	@Override
	public boolean deleteMapleChar(int accessnum) {
		boolean result = false;
		connect();
		try {
			pstmt = con.prepareStatement("delete from maplechar where accessnum=?");
			pstmt.setInt(1, accessnum);
			int r = pstmt.executeUpdate();
			if(r>0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		close();
		return result;
	}

	@Override
	public List<MapleChar> allMapleChar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MapleChar> nicknameMapleChar(String nickname) {
		// TODO Auto-generated method stub
		return null;
	}

}
