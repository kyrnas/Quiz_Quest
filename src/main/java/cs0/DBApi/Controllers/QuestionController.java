package cs0.DBApi.Controllers;

import cs0.DBApi.Models.Question;
import cs0.DBApi.Services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("api/questions")
    public List<Question> getQuestionsForLandmark(@RequestParam(value="landmarkId") String landmarkId){
        return questionService.getQuestionsByLandmarkId(landmarkId);
    }
}
