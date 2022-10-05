package cs0.DBApi.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Data
@Document
public class PlaceDescription {
    @Id
    private String id;
    @Field
    private String placeName;
    @Field
    private String description;
    @Field
    private List<String> pictureUrl;
    private Location location;

    public PlaceDescription(String placeName, String description, List pictureUrl, Location location) {
        this.placeName = placeName;
        this.description = description;
        this.pictureUrl = pictureUrl;
        this.location = location;
    }
}
