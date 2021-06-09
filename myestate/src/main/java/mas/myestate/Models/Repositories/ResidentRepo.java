package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Furniture;
import mas.myestate.Models.Entities.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResidentRepo extends JpaRepository<Resident,Long> {
}
