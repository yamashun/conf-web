package conf.app.confpaper;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpIndForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@Size(min = 1, max = 20)
	private String empName;
	
	@NotNull
	@Size(min = 1, max = 7)
	private String empNum;
	
	@NotNull
	@Size(min = 8, max = 10)
	private String targetDay;
	
	@Size(max = 1)
	private String divisionCode;
	
	@Size(max = 5)
	private String scheduledTimeStart;
	
	@Size(max = 5)
	private String scheduledTimeFinish;
	
	@Size(min = 8, max = 10)
	private String changeDay;
	
	@Size(max = 5)
	private String monthTotalHour;
	
	@Size(max = 5)
	private String yearTotalHour;
	
	@Size(max = 40)
	private String notes;
	
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpNum() {
		return empNum;
	}
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}
	public String getTargetDay() {
		return targetDay;
	}
	public void setTargetDay(String targetDay) {
		this.targetDay = targetDay;
	}
	public String getDivisionCode() {
		return divisionCode;
	}
	public void setDivisionCode(String divisionCode) {
		this.divisionCode = divisionCode;
	}
	public String getScheduledTimeStart() {
		return scheduledTimeStart;
	}
	public void setScheduledTimeStart(String scheduledTimeStart) {
		this.scheduledTimeStart = scheduledTimeStart;
	}
	public String getScheduledTimeFinish() {
		return scheduledTimeFinish;
	}
	public void setScheduledTimeFinish(String scheduledTimeFinish) {
		this.scheduledTimeFinish = scheduledTimeFinish;
	}
	public String getChangeDay() {
		return changeDay;
	}
	public void setChangeDay(String changeDay) {
		this.changeDay = changeDay;
	}
	public String getMonthTotalHour() {
		return monthTotalHour;
	}
	public void setMonthTotalHour(String monthTotalHour) {
		this.monthTotalHour = monthTotalHour;
	}
	public String getYearTotalHour() {
		return yearTotalHour;
	}
	public void setYearTotalHour(String yearTotalHour) {
		this.yearTotalHour = yearTotalHour;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
