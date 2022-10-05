package cs0.DBApi.Repositories;

import cs0.DBApi.Models.PlaceDescription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlaceRepository extends MongoRepository<PlaceDescription, String> {
    PlaceDescription findPlaceDescriptionByPlaceName(String placeName);
}
