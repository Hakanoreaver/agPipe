package FarmEd.beta.InformationPipeline.Users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {
    @Query("Select a FROM Admin a WHERE a.userName = :userName")
    Admin findByUserName(@Param("userName")String userName);
}
