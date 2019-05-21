package controller;





import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import entity.User;

public class IndexController extends AbstractController{
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0, HttpServletResponse arg1) {
		System.out.println("HELLO!SPRINGMVC!!!");
		//返回 交给 适配的 ModelAndView, 可以指定条件的页面 
		return new ModelAndView("index");
	}
 //第三种传值方式
 @RequestMapping(value="/index7")
 public String index7(String username,Map<String, Object> model) {
	 model.put("username", username);
	 User user = new User();
	 user.setUsername("小明");
	 model.put("user", user);
	 //model 都是将数据存放在 request
	 return "index";
	 
 }
 
 @RequestMapping(value="index8 ")
 //直接在方法中写入 形参 HttpServletRequest 就可以获取它
 public String index8(String username,Model model, HttpServletRequest req, HttpSession session) {
	 session.setAttribute("username",username);
	 return "redirect:/welcome/hello";
  }
 /*
 @RequestMapping(value="/index9")
 public String index9(User user,String model()) {
	 model.put("user",user);
	 //model 都是将数据存放在request
	 return "index";
	 
 }*/
}
