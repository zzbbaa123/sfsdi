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
		//���� ���� ����� ModelAndView, ����ָ��������ҳ�� 
		return new ModelAndView("index");
	}
 //�����ִ�ֵ��ʽ
 @RequestMapping(value="/index7")
 public String index7(String username,Map<String, Object> model) {
	 model.put("username", username);
	 User user = new User();
	 user.setUsername("С��");
	 model.put("user", user);
	 //model ���ǽ����ݴ���� request
	 return "index";
	 
 }
 
 @RequestMapping(value="index8 ")
 //ֱ���ڷ�����д�� �β� HttpServletRequest �Ϳ��Ի�ȡ��
 public String index8(String username,Model model, HttpServletRequest req, HttpSession session) {
	 session.setAttribute("username",username);
	 return "redirect:/welcome/hello";
  }
 /*
 @RequestMapping(value="/index9")
 public String index9(User user,String model()) {
	 model.put("user",user);
	 //model ���ǽ����ݴ����request
	 return "index";
	 
 }*/
}
