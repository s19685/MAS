package mas.myestate.Models.Repositories;

import mas.myestate.Models.Entities.IotDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IotDeviceRepo extends JpaRepository<IotDevice,Long> {
}
