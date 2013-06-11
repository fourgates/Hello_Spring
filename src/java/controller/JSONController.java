/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import controller.Name;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class JSONController {
        
        private Name data;
	@RequestMapping(value="/content", method=RequestMethod.GET)
	public @ResponseBody ModelAndView getShopInJSON(@PathVariable String name) {
            
              ModelAndView mav = new ModelAndView();
              mav.addObject(name);
              return mav;
	}
 
}