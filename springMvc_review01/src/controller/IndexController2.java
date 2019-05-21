package controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.User;
//添加注解 告诉spring 这是一个 控制器
@Controller

//访问本类中的方法 url 的时候 需要在 路径前 添加上
@RequestMapping("/welcome")
public class IndexController2 {
	private static final Logger log = Logger.getLogger(IndexController2.class);
	//@RequestMapping 用来指定此方法 处理的 url
	//@RequestMapping 可以 使一个方法，绑定多个url
	@RequestMapping({"/hello","/hello666666"})
	public String hello() {
		log.info("hello!SpringMVC");
		// 当返回值是 字符串的时候， 会找到视图解析器中 根据 我们配置 进行 拼接
		return "index";
	}
	//一个类中 可以 根据访问路径 编写不同的 处理方式
	@RequestMapping({"/hello","/hello666666"})
	public String hello2() {
		log.info("hello!SpringMVCXXXXXXXXX");
		return "index";
		}
	
	@RequestMapping({"/index"})
	//@RequestParam 可以与 请求中 携带 参数 进行 获取 需求
	//形参 名字 与请求中 携带 参数 key 一致
	public String index(@RequestParam String username) {
		log.info("测试"+ username);
		return "index";
		}
	
	//第二种传值的方式
	@RequestMapping("/index2")
	//value 用来 对应· 前端 传递过来的 key required=false 指定此参数可以为空
public String index2(@RequestParam(value="username",required=false)String XXX,
					 @RequestParam(value="password", required=false) String ddd) {
		log.info("测试2"+XXX+"密码为："+ddd);
		return "index";
	}
	
	@RequestMapping("/index3")
	//value 用来 对应· 前端 传递过来的 key required=false 指定此参数可以为空
public String index3(@RequestParam(value="intA",required=false)Integer aaa,
					 @RequestParam(value="intB", required=false) Integer bbb) {
		log.info("测试3"+aaa+"密码为："+bbb);
		return "index";
	}
	
	//params 代表传入的key 用此方法用于处理提交格式
	@RequestMapping(value="/index4", params="username", method=RequestMethod.GET)
	public String index4(String username) {
		log.info(username);
		
		//直接 返回 字符串地址， 默认 是转发，转发是服务器内部行为   就去调用视图解析器，可以访问WEB-INF中的内容
		//重定向 是 外部行为， 实际上是 告诉客户端进行再一次访问的 请求地址:"+重定向地址"
		return "redirect:index";
	}
	
	@RequestMapping(value="/index5")
	//
	public String index5(String username,Model model) {
		log.info(username);
		//传递 键值对 类型 key 是 String value 是 Object 
		model.addAttribute("KeyUsername",username);
		//直接传递 基础类型 取值时 key 用类型名 string
		model.addAttribute(username);
		//传递pojo对象
		User user = new User();
		user.setUsername("小明");
		model.addAttribute(user);
		return "index";
	}

	//第二种传值方式
	@RequestMapping(value="/index6")
	//向视图层 传值 通过
	public String index6(String username, Model model) {
			//创建ModelAndView对象
			ModelAndView modelAndView = new ModelAndView();
			//把参数 添加进对象
			modelAndView.addObject("username",username);
			//设置转发的地址
			modelAndView.setViewName("index");
			return username;
		
	}
	}

