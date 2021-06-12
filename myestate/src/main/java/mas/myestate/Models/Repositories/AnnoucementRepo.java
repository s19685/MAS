package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Annoucement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AnnoucementRepo extends JpaRepository<Annoucement,Long> {
}
