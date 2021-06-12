package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Estate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EstateRepo extends JpaRepository<Estate,Long> {
}
