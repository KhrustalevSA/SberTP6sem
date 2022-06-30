package car_app.entityes;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ModelsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="mark_id")
    private MarksEntity marksEntity;

    public ModelsEntity(){}

    public ModelsEntity(String name){
        this.name = name;
    }

    public ModelsEntity(String name, MarksEntity marksEntity){
        this.name = name;
        this.marksEntity = marksEntity;
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
    public MarksEntity getMarksEntity() {
        return marksEntity;
    }
    public void setMarksEntity(MarksEntity marksEntity) {
        this.marksEntity = marksEntity;
    }
}
