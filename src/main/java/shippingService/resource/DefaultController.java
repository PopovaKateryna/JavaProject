package shippingService.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public ModelAndView register(){
        return new ModelAndView("login");
    }

    @GetMapping("/courses")
    public ModelAndView courses(){
        return new ModelAndView("courses");
    }
    @GetMapping("course/{id}")
    public ModelAndView course(@PathVariable("id") String courseId){
        ModelAndView modelAndView = new ModelAndView("course");
        modelAndView.addObject("courseId", courseId); // Додаємо ID курсу до моделі, якщо потрібно
        return modelAndView;
    }

}
