package coms.bsc.testApplication.controller;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import coms.bsc.testApplication.model.MinimumCoveragePPO;
import coms.bsc.testApplication.service.MinimumCoveragePPOService;




@Controller
public class PlansController {
	

	@Autowired(required=true)
	@Qualifier(value="minimumCoveragePPOService")
	private MinimumCoveragePPOService minimumCoveragePPOService;
	

	public void setMinimumCoveragePPOService(MinimumCoveragePPOService minimumCoveragePPOService) {
		this.minimumCoveragePPOService = minimumCoveragePPOService;
	}
	
	public Integer ZIPid; 
	
	
	/*@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}
	
	//For add and update person both
	@RequestMapping(value= "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p){
		
		if(p.getId() == 0){
			//new person, add it
			this.personService.addPerson(p);
		}else{
			//existing person, call update
			this.personService.updatePerson(p);
		}
		
		return "redirect:/persons";
		
	}
	
		@RequestMapping(value="/quote")
	public String listMinimumCoveragePPO(Model model) {		
		model.addAttribute("zipCodeForm", new MinimumCoveragePPO());
		model.addAttribute("listMinimumCoveragePPO", this.minimumCoveragePPOService.listMinimumCoveragePPO());		
		return  "zipCodeForm";
	}
	
	@RequestMapping(value="/quote/getRate")
	public String getMinimumCoveragePPO(@ModelAttribute("minimumCoveragePPO") MinimumCoveragePPO mcp) {		
		System.out.println(mcp.getId());		
		return  "redirect:/zipCodeForm";
	}
	
	*/

	@RequestMapping("/quote")
	 public String getID(HttpServletRequest request) {		
        ZIPid = Integer.parseInt(request.getParameter("zip_id"));
  // System.out.println("General mapping req>>>"+ZIPid);
   return "redirect:/monthly_premium";     
	
    }
	
	 @RequestMapping("/monthly_premium")
	 public String getPlanRate(){
		 //System.out.println("ZipID>>"+ZIPid);	 
		Double mp =  this.minimumCoveragePPOService.getPlanRate(ZIPid);
		System.out.println("monthly prem in controller>>>>"+mp);
		return "zipCodeForm";
		 
	 }
	
}