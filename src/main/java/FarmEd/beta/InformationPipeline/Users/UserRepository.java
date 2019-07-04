package FarmEd.beta.InformationPipeline.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("Select u FROM User u WHERE u.userName = :userName")
    User findByUserName(@Param("userName")String userName);

    @Query("Select u FROM User u WHERE u.id = :id")
    User findById(@Param("id")int id);
}
