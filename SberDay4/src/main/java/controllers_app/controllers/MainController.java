package controllers_app.controllers;

import controllers_app.entitys.PeopleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedList;
import java.util.List;

@org.springframework.stereotype.Controller
public class MainController {
    private List<PeopleEntity> list = new LinkedList<>();

    @GetMapping("/")
    public String getHomePage(){
        return "homepage";
    }

    @GetMapping("get")
    public String getAll(Model model){
        model.addAttribute("peopleList", this.list);
        return "get_people";
    }

    @PostMapping("get")
    public String getAllPost(){
        return "redirect:/add";
    }

    @GetMapping("/add")
    public String addPeopleGet(){
        return "add_people";
    }

    @PostMapping("/add")
    public String addPeoplePost(Model model,@RequestParam(value = "firstName") String  firstName,
                                  @RequestParam(value = "secondName") String  secondName,
                                  @RequestParam(value = "lastName") String lastName){
        PeopleEntity entity = new PeopleEntity(firstName,secondName,lastName);
        list.add(entity);
        return "redirect:/get";
    }

}
