package car_app.repository;

import car_app.entityes.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MarksRepository extends JpaRepository<MarksEntity, Long> {
    public ArrayList<MarksEntity> getAllByName(String name);
    public MarksEntity getByName(String name);
}
