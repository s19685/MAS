package mas.myestate.Models.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IotDeviceRepo extends JpaRepository<IotDeviceRepo,Long> {
}
