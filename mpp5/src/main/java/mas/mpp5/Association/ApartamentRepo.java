package mas.mpp5.Association;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApartamentRepo extends JpaRepository<Apartment,Long> {
}
