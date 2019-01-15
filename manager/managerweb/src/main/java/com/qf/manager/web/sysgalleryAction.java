package com.qf.manager.web;

import com.qf.manager.po.Sysgallery;
import com.qf.manager.service.CalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class sysgalleryAction {
    @Autowired
    private CalleryService calleryService;
    @GetMapping("index")
    public ModelAndView bannerImage(){
        ModelAndView mav= new ModelAndView();
        List<Sysgallery> sysgalleries = calleryService.listsSysgallery("123");
        mav.addObject("list",sysgalleries);
        return mav;
    }
}
