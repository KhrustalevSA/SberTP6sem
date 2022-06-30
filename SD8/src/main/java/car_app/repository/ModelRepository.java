package car_app.repository;

import car_app.entityes.ModelsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ModelRepository extends JpaRepository<ModelsEntity, Long> {
    public ArrayList<ModelsEntity> getAllByName(String name);
}
