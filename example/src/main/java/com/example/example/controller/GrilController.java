package com.example.example.controller;

import com.example.example.entry.Result;
import com.example.example.properties.GrilProperties;
import com.example.example.entry.Gril;
import com.example.example.reproperitory.GrilRepository;
import com.example.example.service.GrilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GrilController {
    private final static Logger logger=LoggerFactory.getLogger(GrilController.class);
    @Autowired
    private GrilRepository grilRepository;
    @Autowired
    private GrilService grilService;
    @Autowired
    private GrilProperties grilProperties;


    @RequestMapping(value = {"/showgril","showboy"},method=RequestMethod.GET)
    public String show(){
        return grilProperties.getCupSize()+grilProperties.getAge();

    }

    @GetMapping("/hello")
    public Gril test(){
        Gril g=new Gril();
        g.setAge(18);
        g.setCupSize("B");
        return g;
    }
    @PostMapping("/insert")
    public Object insert(@Valid  Gril g1, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            //改进 统一异常处理 @Autowrite引入报错
                Result result=new Result();
                result.setCode(1);
                result.setMsg(bindingResult.getFieldError().getDefaultMessage());
                result.setData(null);
                return result;

        }
        Gril g=new Gril();
        g.setAge(g1.getAge());
        g.setCupSize(g1.getCupSize());
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(grilRepository.save(g));

        return result;

    }

    @GetMapping("/select")
    public List<Gril> findall(){
        return grilRepository.findAll();
    }

    @PostMapping("/inserTwo")
    public void insertTwo(){
        grilService.insertTwo();
    }

    @GetMapping(value = "/getAge/{id}")
    public void getAge(@PathVariable("id")Integer id)throws Exception{
        grilService.getAge(id);
    }

    @GetMapping("/grilList")
    public List<Gril> grilList(){
        return  grilRepository.findAll();
    }

}
