package math_app.controllers;

import math_app.entitys.MathEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
    @RequestMapping("/")
    public String getHomePage(){
        return "It's a home page";
    }
    @RequestMapping("/math")
    public String getMathOperation(@RequestParam(value = "operation", defaultValue = "enter operation") String operation,
                                       @RequestParam(value = "firstValue", defaultValue = "0") double firstValue,
                                       @RequestParam(value = "secondValue", defaultValue = "0") double secondValue){
        MathEntity entity = new MathEntity(operation,firstValue,secondValue);
        return entity.doOperation();
    }
}
