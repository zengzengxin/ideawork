package springmvc.myexceptionHandle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class myexceptionhandle {

	@ExceptionHandler()
	public ModelAndView error(Exception ex){
		System.out.println("≥ˆ“Ï≥£¡À£∫"+ex);
		ModelAndView modelAndView = new ModelAndView("error");
		modelAndView.addObject("exception" ,ex);
		return modelAndView;
		
	}
}
