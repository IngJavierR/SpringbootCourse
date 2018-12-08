package mx.com.example.persistence;

import mx.com.example.model.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UserDAO extends PagingAndSortingRepository<UserDO, Long> {

}
