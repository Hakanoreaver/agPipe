package FarmEd.beta.InformationPipeline.Queries;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer> {
    @Query("Select q FROM Question q WHERE q.answered = :answer")
    List<Question> findByAnswered(@Param("answer")boolean answer);

    @Query("Select q FROM Question q WHERE q.id = :id")
    Question findById(@Param("id")int id);

    @Query("Select q FROM Question q WHERE q.userNum = :userNum")
    List<Question> findByUser(@Param("userNum")int userNum);
}
