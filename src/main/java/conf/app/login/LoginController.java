package conf.app.login;

import java.security.Principal;
import java.util.Collection;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.terasoluna.gfw.common.message.ResultMessages;

import conf.app.login.LoginForm;
//import conf.domain.model.RelateConfPaperDto;
import conf.domain.service.confpaper.ConfPaperService;
import conf.domain.service.account.AccountSharedService;
import conf.domain.model.RelateConfPaperDto;

@Controller
public class LoginController {
	
	@Inject
	private AccountSharedService loginService;
	
	@Inject
	private ConfPaperService confPaperService;
	
    @Inject
    protected Mapper beanMapper;
	
	@ModelAttribute
	public LoginForm setUpForm() {
		LoginForm form = new LoginForm();
		return form;
	}
	
	//ログインページへ遷移する
    @RequestMapping(value = "login")
    public String index(Model model) {
    	
        return "login/login";
    }
    
	//ログインページへ遷移する
    @RequestMapping(value = "login", params={"error=true"})
    public String indexError(Model model) {
    	
//    	System.out.println("---------------------ログイン失敗時の画面遷移---------------------------");
    	
    	ResultMessages messages = ResultMessages.error().add("err.01.2001"); // (1)
        model.addAttribute(messages); // (2)
    	
        return "login/login";
    }
    
    
  //ログイン成功後にトップページに遷移する。
    @RequestMapping(value = "/") // (5)
    public String top(Model model, Principal principal) {
    	
    	if (null != principal) {
            model.addAttribute("userName", principal.getName());
        }
    	
    	//userName(社員番号）に関連する協議書を取得する。
    	Collection<RelateConfPaperDto> relateConf = confPaperService.findRelateConf(principal.getName());
    	model.addAttribute("relateConf", relateConf);
    	
    	String path = "confpaper/top";
    	
        return path ; // (7)
    }
	

}
