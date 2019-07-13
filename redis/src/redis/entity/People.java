package redis.entity;

import java.io.Serializable;
import java.util.Date;

public class People implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4008306636063761658L;
	private String perId;
	private String perName;
	private Date perBirthday;
	
	
	public People(String perId, String perName, Date perBirthday) {
		super();
		this.perId = perId;
		this.perName = perName;
		this.perBirthday = perBirthday;
	}
	public String getPerId() {
		return perId;
	}
	public void setPerId(String perId) {
		this.perId = perId;
	}
	public String getPerName() {
		return perName;
	}
	public void setPerName(String perName) {
		this.perName = perName;
	}
	public Date getPerBirthday() {
		return perBirthday;
	}
	public void setPerBirthday(Date perBirthday) {
		this.perBirthday = perBirthday;
	}
	
	@Override
	public String toString() {
		return "People [perId=" + perId + ", perName=" + perName + ", perBirthday=" + perBirthday + "]";
	}
}
