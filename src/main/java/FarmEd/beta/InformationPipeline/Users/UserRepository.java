package FarmEd.beta.InformationPipeline.Users;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("Select u FROM User u WHERE u.userName = :userName")
    User findByUserName(@Param("userName")String userName);

    @Query("Select u FROM User u WHERE u.id = :id")
    User findById(@Param("id")int id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.farmName = :farmName, u.province = :province, u.division = :division, u.extent = :extent," +
            "u.c = :c, u.n = :n, u.p = :p, u.k = :k, u.pH = :pH," +
            "u.soilTest = :soilTest, u.micronutrients = :micronutrients, u.waterSource = :waterSource, u.aggrozone = :aggrozone WHERE u.id = :id")
    public void updateUser(@Param("id") int id, @Param("farmName") String farmName,  @Param("province") String province,  @Param("division") String division,  @Param("extent") double extent,
                           @Param("c") double c,  @Param("n") double n,  @Param("p") double p,  @Param("k") double k, @Param("pH") double pH,
                           @Param("soilTest") boolean soilTest,  @Param("micronutrients") String micronutrients,  @Param("waterSource") String waterSource,  @Param("aggrozone") int aggrozone);
}
