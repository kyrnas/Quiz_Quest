package cs0.DBApi.Services;

import cs0.DBApi.Models.QuizResult;
import cs0.DBApi.Repositories.QuizResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuizResultService {
    private final QuizResultRepository quizResultRepository;

    public List<QuizResult> getHistory(String userName, String landmarkId){
        return quizResultRepository.findQuizResultsByUserNameAndLandmarkId(userName, landmarkId);
    }

    public List<QuizResult> getLeaderBoard(String landmarkId){
        return quizResultRepository.findTop10ByLandmarkIdOrderByAnsweredCorrectlyDesc(landmarkId);
    }

    public void addQuizResult(QuizResult quizResult){
        quizResultRepository.save(quizResult);
    }

}
