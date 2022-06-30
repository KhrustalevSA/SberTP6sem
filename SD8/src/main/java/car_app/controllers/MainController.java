package car_app.controllers;

import car_app.entityes.MarksEntity;
import car_app.entityes.ModelsEntity;
import car_app.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    MainService service;


    //////////////////////////////////////////////////////////////////
    //MarksServiceController
    //////////////////////////////////////////////////////////////////

    @GetMapping("/")
    public String getHomePage(){
        return "It's a home page";
    }

    @GetMapping("/addMarksEntity")
    public MarksEntity addMarksEntity(@RequestParam(value = "name") Optional<String> name){
        if (name.isPresent()) {
            MarksEntity marksEntity = new MarksEntity(name.get());
            service.addMark(marksEntity);
            return marksEntity;
        }
        return null;
    }

    @GetMapping("/getMarksEntity")
    public List<MarksEntity> getAllMarksEntity(){
        return service.getAllMarks();
    }

    @GetMapping("/hideMark")
    public String hideMark(@RequestParam(value = "markName") String markName){
        service.hideMark(markName);
        return "Mark " + markName + " was hide;";
    }

    @GetMapping("/showMark")
    public String showMark(@RequestParam(value = "markName") String markName){
        service.showMark(markName);
        return "Mark " + markName + " was show;";
    }


    //////////////////////////////////////////////////////////////////
    //ModelsServiceController
    //////////////////////////////////////////////////////////////////


    @GetMapping("/addModelEntity")
    public ModelsEntity addModelEntity(@RequestParam(value = "name") Optional<String> name,
                                       @RequestParam(value = "markName") Optional<String> markName){
        if (markName.isPresent()){
            if (name.isPresent()){
                MarksEntity marksEntity = service.getByName(markName.get());
                ModelsEntity modelsEntity = new ModelsEntity(name.get(),marksEntity);
                service.addModelToMArk(marksEntity, modelsEntity);
                service.addModel(modelsEntity);
                return modelsEntity;
            }
        }
        return null;
    }

    @GetMapping("/getModelsEntity")
    public List<ModelsEntity> getAllModelEntity(){
        return service.getAllModels();
    }
}
