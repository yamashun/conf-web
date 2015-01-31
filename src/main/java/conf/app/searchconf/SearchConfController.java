package conf.app.searchconf;

import java.util.Collection;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import conf.domain.model.SearchDto;
import conf.domain.service.search.SearchConfService;



@Controller
@RequestMapping("searchconf")
public class SearchConfController {
	
	@ModelAttribute
	public SearchForm setUpForm(){
		SearchForm searchForm = new SearchForm();
		return searchForm;
	}
	
	@Inject
	protected Mapper beanMapper;
	
	@Inject
	protected SearchConfService searchConfService;
	
	@RequestMapping("searchPage")
	public String searchPage(Model model){

		return "confpaper/search";

	}
	
	@RequestMapping(value="search", method = RequestMethod.GET)
	public String searchConf(@Validated SearchForm searchForm, BindingResult bindingResult,
			Model model){
		
//		if (bindingResult.hasErrors()) {
//			System.out.println("---------------------単項目チェックエラー---------------------");
//			
//			return "confpaper/search";
//		}
		
		SearchDto searchDto = beanMapper.map(searchForm, SearchDto.class);
		
		Collection<SearchDto> resultList = searchConfService.findRelateConf(searchDto);
		
		model.addAttribute("resultList", resultList);
		
		return "confpaper/search";

	}

}
