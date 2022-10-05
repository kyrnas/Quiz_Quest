package cs0.DBApi.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Coordinates {
    @Field
    private Double latitude;
    @Field
    private Double longitude;

    public Coordinates(Double latitude, Double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
