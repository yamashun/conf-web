package conf.app.confpaper;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import conf.app.confpaper.EmpIndForm;

public class CreateConfForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String mailPresence;
	
	@NotNull
	@Size(min = 1, max = 400)
	private String reason;
	
	@NotNull
	@Size(min = 1, max = 8)  	//excelの協議書に合わせて８人分をMaxとする
	@Valid						//ネストしたBeanのBean Validationを有効にするため
	private List<EmpIndForm> empInd;
	

	public String getMailPresence() {
		return mailPresence;
	}

	public void setMailPresence(String mailPresence) {
		this.mailPresence = mailPresence;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public List<EmpIndForm> getEmpInd() {
		return empInd;
	}

	public void setEmpInd(List<EmpIndForm> empInd) {
		this.empInd = empInd;
	}

}
