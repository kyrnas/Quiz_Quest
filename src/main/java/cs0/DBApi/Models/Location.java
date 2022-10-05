package cs0.DBApi.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Location {
    @Field
    private Coordinates coordinates;
    @Field
    private String city;
    @Field
    private String state;
    @Field
    private String additionalLocation;

    public Location (Coordinates coordinates, String city, String state, String additionalLocation){
        this.coordinates = coordinates;
        this.city = city;
        this.state = state;
        this.additionalLocation = additionalLocation;
    }
}
