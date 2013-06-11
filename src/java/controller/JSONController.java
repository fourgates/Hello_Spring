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
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JSONController {

    private Name data;

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView getShopInJSON(@PathVariable String name) {

        ModelAndView mav = new ModelAndView();
        mav.addObject(name);
              
        return mav;
    }

    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public@ResponseBody
    void handleRequest(Exception exception,
            HttpServletRequest request, HttpServletResponse response) throws IOException 
    {
        response.setContentType("application/json");
        String json = "{\"Name\": 50}";
        PrintWriter out = response.getWriter();
        out.write(json);
    }
}