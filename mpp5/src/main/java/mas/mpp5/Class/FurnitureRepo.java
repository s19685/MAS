package mas.mpp5.Class;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureRepo extends JpaRepository<Furniture,Long> {
}
