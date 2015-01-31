package conf.app.searchconf;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SearchForm implements Serializable {
	
	private static final long serialVersionUID = -6565350073425257119L;
	
	@NotNull
	@Size(max = 20)
	private String submitPerson;

	@NotNull
	@Size(max = 20)
	private String practitioner;
	
	@NotNull
	@Size(max = 7)
	private String employeeNum;
	
	@NotNull
	@Pattern(regexp = "[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}")
	private String targetDay;
	
	@NotNull
	private String status;
	
	@NotNull
	private String confPaperNo;
	
	
	public String getSubmitPerson() {
		return submitPerson;
	}
	public void setSubmitPerson(String submitPerson) {
		this.submitPerson = submitPerson;
	}
	public String getPractitioner() {
		return practitioner;
	}
	public void setPractitioner(String practitioner) {
		this.practitioner = practitioner;
	}
	public String getEmployeeNum() {
		return employeeNum;
	}
	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	public String getTargetDay() {
		return targetDay;
	}
	public void setTargetDay(String targetDay) {
		this.targetDay = targetDay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConfPaperNo() {
		return confPaperNo;
	}
	public void setConfPaperNo(String confPaperNo) {
		this.confPaperNo = confPaperNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
