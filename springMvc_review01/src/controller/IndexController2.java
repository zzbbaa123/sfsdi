package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
//���ע�� ����spring ����һ�� ������
@Controller

//���ʱ����еķ��� url ��ʱ�� ��Ҫ�� ·��ǰ �����
@RequestMapping("/welcome")
public class IndexController2 {
	private static final Logger log = Logger.getLogger(IndexController2.class);
	//@RequestMapping ����ָ���˷��� ����� url
	//@RequestMapping ���� ʹһ���������󶨶��url
	@RequestMapping({"/hello","/hello666666"})
	public String hello() {
		log.info("hello!SpringMVC");
		// ������ֵ�� �ַ�����ʱ�� ���ҵ���ͼ�������� ���� �������� ���� ƴ��
		return "index";
	}
	//һ������ ���� ���ݷ���·�� ��д��ͬ�� ����ʽ
	@RequestMapping({"/hello","/hello666666"})
	public String hello2() {
		log.info("hello!SpringMVCXXXXXXXXX");
		return "index";
		}
	
	@RequestMapping({"/index"})
	//@RequestParam ������ ������ Я�� ���� ���� ��ȡ ����
	//�β� ���� �������� Я�� ���� key һ��
	public String index(@RequestParam String username) {
		log.info("����"+ username);
		return "index";
		}
	
	//�ڶ��ִ�ֵ�ķ�ʽ
	@RequestMapping("/index2")
	//value ���� ��Ӧ�� ǰ�� ���ݹ����� key required=false ָ���˲�������Ϊ��
public String index2(@RequestParam(value="username",required=false)String XXX,
					 @RequestParam(value="password", required=false) String ddd) {
		log.info("����2"+XXX+"����Ϊ��"+ddd);
		return "index";
	}
	
	@RequestMapping("/index3")
	//value ���� ��Ӧ�� ǰ�� ���ݹ����� key required=false ָ���˲�������Ϊ��
public String index3(@RequestParam(value="intA",required=false)Integer aaa,
					 @RequestParam(value="intB", required=false) Integer bbb) {
		log.info("����3"+aaa+"����Ϊ��"+bbb);
		return "index";
	}
	
	//params �������key �ô˷������ڴ����ύ��ʽ
	@RequestMapping(value="/index4", params="username", method=RequestMethod.GET)
	public String index4(String username) {
		log.info(username);
		
		//ֱ�� ���� �ַ�����ַ�� Ĭ�� ��ת����ת���Ƿ������ڲ���Ϊ   ��ȥ������ͼ�����������Է���WEB-INF�е�����
		//�ض��� �� �ⲿ��Ϊ�� ʵ������ ���߿ͻ��˽�����һ�η��ʵ� �����ַ:"+�ض����ַ"
		return "redirect:index";
	}
	
	@RequestMapping(value="/index5")
	//
	public String index5(String username,Model model) {
		log.info(username);
		//���� ��ֵ�� ���� key �� String value �� Object 
		model.addAttribute("KeyUsername",username);
		//ֱ�Ӵ��� �������� ȡֵʱ key �������� string
		model.addAttribute(username);
		//����pojo����
		User user = new User();
		user.setUsername("С��");
		model.addAttribute(user);
		return "index";
	}

	//�ڶ��ִ�ֵ��ʽ
	@RequestMapping(value="/index6")
	//����ͼ�� ��ֵ ͨ��
	public String index6(String username, Model model) {
			//����ModelAndView����
			ModelAndView modelAndView = new ModelAndView();
			//�Ѳ��� ��ӽ�����
			modelAndView.addObject("username",username);
			//����ת���ĵ�ַ
			modelAndView.setViewName("index");
			return username;
		
	}
	}

