package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Flat;
import mas.myestate.Models.Entities.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlatRepo extends JpaRepository<Flat,Long> {
}
