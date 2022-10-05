package cs0.DBApi.Repositories;

import cs0.DBApi.Models.QuizResult;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizResultRepository extends MongoRepository<QuizResult, String> {
    List<QuizResult> findQuizResultsByUserNameAndLandmarkId(String userName, String landmarkId);
    List<QuizResult> findTop10ByLandmarkIdOrderByAnsweredCorrectlyDesc(String landmarkId);
}
