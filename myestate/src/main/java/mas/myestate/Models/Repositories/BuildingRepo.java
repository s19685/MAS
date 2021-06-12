package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepo extends JpaRepository<Building,Long> {
}
