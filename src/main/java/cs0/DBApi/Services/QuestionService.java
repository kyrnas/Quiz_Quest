package cs0.DBApi.Services;

import cs0.DBApi.Models.Question;
import cs0.DBApi.Repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getQuestionsByLandmarkId(String landmarkId){
        return questionRepository.findQuestionsByLandmarkId(landmarkId);
    }

}
