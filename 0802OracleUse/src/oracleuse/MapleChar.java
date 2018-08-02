package oracleuse;
import java.sql.Date;

public class MapleChar {
	private int accessnum;
	private String nexonid;
	private Date createdate;
	private String nickname;
	private String job;
	
	public int getAccessnum() {
		return accessnum;
	}
	public void setAccessnum(int accessnum) {
		this.accessnum = accessnum;
	}
	public String getNexonid() {
		return nexonid;
	}
	public void setNexonid(String nexonid) {
		this.nexonid = nexonid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
	@Override
	public String toString() {
		return "DTO [accessnum=" + accessnum + ", nexonid=" + nexonid + ", createdate=" + createdate + ", nickname="
				+ nickname + ", job=" + job + "]";
	}
}
