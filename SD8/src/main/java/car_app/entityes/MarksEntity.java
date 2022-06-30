package car_app.entityes;

import javax.persistence.*;
import java.util.List;

@Entity
public class MarksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;

    private Long active;
    @OneToMany(mappedBy = "marksEntity")
    private List<ModelsEntity> modelsEntityList;

    public MarksEntity(){}

    public MarksEntity(String name){
        this.name = name;
        this.active = 1L;
    }

    public Long getUid() {
        return uid;
    }
    public void setUid(Long uid) {
        this.uid = uid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<ModelsEntity> getModelsEntityList() {
        return modelsEntityList;
    }
    public void setModelsEntityList(List<ModelsEntity> modelsEntityList) {
        this.modelsEntityList = modelsEntityList;
    }
    public Long getActive() {
        return active;
    }
    public void setActive(Long active) {
        this.active = active;
    }
}
