package cs0.DBApi.Controllers;

import cs0.DBApi.Models.QuizResult;
import cs0.DBApi.Services.QuizResultService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
public class QuizResultController {
    private final QuizResultService quizResultService;

    @PostMapping("api/submitQuizResult")
    public void submitQuizResult(@Valid @RequestBody QuizResult quizResult){
        quizResult.setTaken(LocalDateTime.now());
        quizResultService.addQuizResult(quizResult);
    }

    @GetMapping("api/getHistory")
    public List<QuizResult> getHistory(@RequestParam(value="userName") String userName,
                                       @RequestParam(value="landmarkId") String landmarkId){
        return quizResultService.getHistory(userName, landmarkId);
    }

    @GetMapping("api/getLeaderboard")
    public List<QuizResult> getLeaderboard(@RequestParam(value="landmarkId") String landmarkId){
        return quizResultService.getLeaderBoard(landmarkId);
    }
}
