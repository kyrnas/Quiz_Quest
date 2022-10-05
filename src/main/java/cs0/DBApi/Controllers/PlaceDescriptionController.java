package cs0.DBApi.Controllers;

import cs0.DBApi.Models.PlaceDescription;
import cs0.DBApi.Services.PlaceDescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlaceDescriptionController {

    private final PlaceDescriptionService placeDescriptionService;

    @GetMapping("api/placeDescriptions")
    public List<PlaceDescription> fetchAllPlaceDescriptions(){
        return placeDescriptionService.getAllPlaceDescriptions();
    }

    @GetMapping("api/placeDescription")
    public PlaceDescription fetchPlaceDescriptionByName(@RequestParam(value="placeName") String placeName){
        return placeDescriptionService.getPlaceDescriptionByName(placeName);
    }

    @GetMapping("api/placeDescriptionsLoc")
    public List<PlaceDescription> fetchPlaceDescriptionsByLocation(@RequestParam(value="lat") double lat, @RequestParam(value="lon") double lon){
        return placeDescriptionService.getByLocation(lat, lon);
    }

}
