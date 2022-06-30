package car_app.services;

import car_app.entityes.MarksEntity;
import car_app.entityes.ModelsEntity;
import car_app.repository.MarksRepository;
import car_app.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MainService {
    @Autowired
    MarksRepository marksRepository;
    @Autowired
    ModelRepository modelRepository;

    /////////////////////////////////////////////////////////////////////////////////////
    ///Marks service
    /////////////////////////////////////////////////////////////////////////////////////

    public void addMark(MarksEntity marksEntity){
        marksRepository.save(marksEntity);
    }

    public void hideMark(String markName){
        marksRepository.getByName(markName).setActive(0L);
    }

    public void showMark(String markName){
        marksRepository.getByName(markName).setActive(1L);
    }


    public ArrayList<MarksEntity> getAllMarks(){
        ArrayList<MarksEntity> marksEntityArrayList = (ArrayList<MarksEntity>) marksRepository.findAll();
        ArrayList<MarksEntity> returnedMarksEntityArrayList = new ArrayList<>();
        for (long i = 1; i <= marksEntityArrayList.size();i++){
            returnedMarksEntityArrayList.add(marksRepository.getById(i));
        }
        return returnedMarksEntityArrayList;
    }

    public void addModelToMArk(MarksEntity marksEntity, ModelsEntity modelsEntity){
        marksEntity.getModelsEntityList().add(modelsEntity);
    }

    public MarksEntity getByName(String name){
        return marksRepository.getByName(name);
    }

    /////////////////////////////////////////////////////////////////////////////////////
    ///Models service
    /////////////////////////////////////////////////////////////////////////////////////

    public void addModel(ModelsEntity modelsEntity){
        modelRepository.save(modelsEntity);
    }

    public ArrayList<ModelsEntity> getAllModels(){
        return (ArrayList<ModelsEntity>) modelRepository.findAll();
    }
}
