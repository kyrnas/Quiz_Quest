package cs0.DBApi.Repositories;

import cs0.DBApi.Models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {
    List<Question> findQuestionsByLandmarkId(String landmarkId);
}
