package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepo extends JpaRepository<Board,Long> {
}
