package conf.app.confpaper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.terasoluna.gfw.common.exception.BusinessException;

import conf.app.confpaper.CreateConfForm;
import conf.app.confpaper.EmpIndForm;
import conf.domain.service.confpaper.ConfPaperService;
import conf.app.confpaper.NewConfHelper;
import conf.domain.model.ConfPaperDto;

@Controller
@RequestMapping("confpaper")
public class ConfPaperController {

	@ModelAttribute
	public CreateConfForm setupForm() {
		CreateConfForm createConfForm = new CreateConfForm();
		List<EmpIndForm> empInd = new ArrayList<EmpIndForm>();
		empInd.add(new EmpIndForm());
		createConfForm.setEmpInd(empInd);
		createConfForm.setMailPresence("1");
		return createConfForm;
	}

	@Inject
	protected ConfPaperService confPaperService;

	@RequestMapping("newConfPage")
	public String newConfPape(Model model){

		return "confpaper/newconf";

	}

	@RequestMapping(value="createNewConf", method = RequestMethod.POST)
	public String createNewConf(@Validated CreateConfForm createConfForm,
			BindingResult bindingResult, Model model){

		if (bindingResult.hasErrors()) {
			return "confpaper/newconf";
		}

		NewConfHelper newConfHelper = new NewConfHelper();
		ConfPaperDto confPaperDto = newConfHelper.confFormConver(createConfForm);
		try {
			confPaperService.createConfPaper(confPaperDto);
		} catch (BusinessException e) {
			model.addAttribute(e.getResultMessages());

			System.out.println("--------------------テスト2");
			return "confpaper/newconf";

		}

		return "redirect:newConfPage";

	}


}
