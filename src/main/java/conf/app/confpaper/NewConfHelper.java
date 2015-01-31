package conf.app.confpaper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import conf.app.confpaper.CreateConfForm;
import conf.app.confpaper.EmpIndForm;
import conf.domain.model.ConfPaperDto;
import conf.domain.model.ConfPaperInfo;
import conf.domain.model.EmployeeInd;
import conf.domain.model.OverTimeConfPaper;
import conf.domain.util.ToDateUtil;

public class NewConfHelper {
	
	@Value("${label.common.supervisor}")
	private String superVisor;

	ConfPaperDto confFormConver(CreateConfForm form){
		

		
		ConfPaperDto confPaperDto = new ConfPaperDto();
		ConfPaperInfo confPaperInfo = new ConfPaperInfo();
		OverTimeConfPaper overTimeConfPaper = new OverTimeConfPaper();
		List<EmployeeInd> empIndList = new ArrayList<EmployeeInd>();
		
		//ConfPaperInfoへの詰め替え
		confPaperInfo.setConfpaperNum("");
		confPaperInfo.setConfpaperType("01");  //現状は01のみ。協議書の種類が増えた場合は画面から受け取ったコードをセットする
		confPaperInfo.setConfCommitee("01");	//現状は固定。　時間があれば画面表示時に定数テーブルから取得し、その値をセットするように変更
		confPaperInfo.setStatus("01");	//テストのため固定。　→　後で変更
		try {												//テストのため固定で設定　→　後で修正
			Date dt = ToDateUtil.toDate("2014/10/30");
			confPaperInfo.setSubmitDay(dt);
		} catch (ParseException e){
			e.printStackTrace();
		}
		confPaperInfo.setSubmitPerson("上長");	//現状は固定。　時間があれば画面表示時に定数テーブルから取得し、その値をセットするように変更
		confPaperInfo.setSupervisor(superVisor);
		confPaperInfo.setCompApproval("0");
		confPaperInfo.setUnionApproval("0");
		
		
		//OverTimeConfPaperへの詰め替え
		overTimeConfPaper.setReason(form.getReason());
		boolean mailUmu;
		if(form.getMailPresence().equals("1")){
			mailUmu = true;
		} else if(form.getMailPresence().equals("2")){
			mailUmu = false;
		} else{
			mailUmu = true;
		}
		overTimeConfPaper.setMailPresence(mailUmu); 
		
		
		//EmployeeIndへの詰め替え
		for(EmpIndForm empInd: form.getEmpInd()){
			EmployeeInd employeeInd = new EmployeeInd();
			employeeInd.setEmployeeNum(empInd.getEmpNum());
			try{
				employeeInd.setTargetDay(ToDateUtil.toDate(empInd.getTargetDay()));
			}catch (ParseException e){
				e.printStackTrace();
			}
			employeeInd.setDivisionCode(empInd.getDivisionCode());
			employeeInd.setScheduledTimeStart(empInd.getScheduledTimeStart());
			employeeInd.setScheduledTimeFinish(empInd.getScheduledTimeFinish());
			employeeInd.setMonthTotalHour(empInd.getMonthTotalHour());
			employeeInd.setYearTotalHour(empInd.getYearTotalHour());
			employeeInd.setNotes(empInd.getNotes());
			employeeInd.setIndProgressStatus("01");
			
			empIndList.add(employeeInd);
		}
		
		confPaperDto.setConPaperInfo(confPaperInfo);
		confPaperDto.setOverTimeConfPaper(overTimeConfPaper);
		confPaperDto.setListEmployeeInd(empIndList);
		
		return confPaperDto;
	}
	
}
