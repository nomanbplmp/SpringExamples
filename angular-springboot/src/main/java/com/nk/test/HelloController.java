package com.nk.test;
import java.io.Serializable;

import javax.websocket.server.PathParam;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("serv/")
public class HelloController {

@RequestMapping( value="/show/{user}", method=RequestMethod.POST)
public String show(@RequestBody Data data, @PathVariable String user){	
	System.out.println("In controller");
	System.out.println(user);
	System.out.println(data.getName());
	
	return "";
}


@RequestMapping( value="/show/json", method=RequestMethod.GET)
public String showjson(Model model){	
	 model.addAttribute("name", "one");
	    model.addAttribute("userid", "2");
	/* Gson gson = new Gson();
	String json = gson.toJson(model);*/
	return "user";
}


}

class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}

