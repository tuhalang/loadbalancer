package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("info", "Server 1");
        return "index";
    }

    @RequestMapping("sendRequest")
    public ModelAndView send(ModelAndView model, HttpServletRequest request){

        String id = request.getParameter("id");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("====== Start id = " + id + " ======");
                try{
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("====== End id = " + id + " ======");
            }
        });
        thread.start();
        model = new ModelAndView("index");
        model.addObject("info", "Server 1");
        return model;
    }


}
