package cs0.DBApi.Services;

import cs0.DBApi.Models.PlaceDescription;
import cs0.DBApi.Repositories.PlaceRepository;
import cs0.DBApi.Util.CalculateDistance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@Service
public class PlaceDescriptionService {
    private final PlaceRepository placeRepository;

    public List<PlaceDescription> getAllPlaceDescriptions(){
        List<PlaceDescription> placeDescriptions = placeRepository.findAll();
        return placeDescriptions;
    }

    public PlaceDescription getPlaceDescriptionByName(String name){
        return placeRepository.findPlaceDescriptionByPlaceName(name);
    }

    public List<PlaceDescription> getByLocation(double lat, double lon){
        List<PlaceDescription> placeDescriptions = placeRepository.findAll();

        Collections.sort(placeDescriptions, new CompareDescription(lat, lon));

        return placeDescriptions;
    }


    class CompareDescription implements Comparator<PlaceDescription>
    {
        double lat, lon;
        CompareDescription(double lat, double lon){
            this.lat = lat;
            this.lon = lon;
        }

        @Override
        public int compare(PlaceDescription o1, PlaceDescription o2) {
            double dist1 = CalculateDistance.distance(lat, lon, o1.getLocation().getCoordinates().getLatitude(), o1.getLocation().getCoordinates().getLongitude());
            double dist2 = CalculateDistance.distance(lat, lon, o2.getLocation().getCoordinates().getLatitude(), o2.getLocation().getCoordinates().getLongitude());
                if(dist1 > dist2){
                    return 1;
                }
                else{
                    return -1;
                }
        }
    }
}
