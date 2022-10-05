package cs0.DBApi.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document
public class QuizResult {
    @Id
    private String id;
    @Field
    private String landmarkId;
    @Field
    private String userName;
    @Field
    private LocalDateTime taken;
    @Field
    private Integer answeredCorrectly;
    @Field
    private Integer totalQuestions;

    public QuizResult(String landmarkId, String userName, Integer answeredCorrectly, Integer totalQuestions) {
        this.landmarkId = landmarkId;
        this.userName = userName;
        this.taken = LocalDateTime.now();
        this.answeredCorrectly = answeredCorrectly;
        this.totalQuestions = totalQuestions;
    }
}
