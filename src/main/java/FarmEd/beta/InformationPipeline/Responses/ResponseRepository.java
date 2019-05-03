package FarmEd.beta.InformationPipeline.Responses;

import FarmEd.beta.InformationPipeline.Queries.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResponseRepository extends CrudRepository<Response, Integer> {
    @Query("Select r FROM Response r WHERE r.queryNum = :queryNum")
    Response findByQuery(@Param("queryNum")int queryNum);
}
