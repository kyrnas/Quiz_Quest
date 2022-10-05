package cs0.DBApi;

import cs0.DBApi.Models.*;
import cs0.DBApi.Repositories.PlaceRepository;
import cs0.DBApi.Repositories.QuestionRepository;
import cs0.DBApi.Repositories.QuizResultRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class DbApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbApiApplication.class, args);
	}

	@Bean
	CommandLineRunner placeRepositoryRunner (PlaceRepository repository){
		return args -> {
			if(repository.findAll().isEmpty()){
				List<String> list = new ArrayList<>();
				Coordinates coordinates = new Coordinates(41.86782338889795, -87.61402433603956);
				Location location = new Location(coordinates, "Chicago", "Illinois", "South Loop");
				list.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT89JhkGfKUYQ811DL7a6LkrP802MwReeBlb-d8HVZbbfWck078qaj7Ptl0Z8VQo0JZE-VdKKlr3H-cXDhcbosDpA");
				list.add("https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcQ1TOkHQ60jd6aQKRgW5jeASlPT8ZsCDI5EH88BkbGcsNtT6ns3A5yE8xQjosuaYyB5sWclqw4fZ8zOmwjq-RnF-A");
				list.add("https://encrypted-tbn1.gstatic.com/licensed-image?q=tbn:ANd9GcStK4B8Bsnb_JzPX5_bkMv_jDwS0S-a0jbCV5BqofcCTlShNdoij6vc9saXzmAbbzeEZ_2cbAgIazjWACeN0miY0A");
				repository.save(new PlaceDescription(
						"Shedd Aquarium",
						"Shedd Aquarium is an indoor public aquarium in Chicago, Illinois, in the United States. " +
								"Opened on May 30, 1930, the 5 million US gal aquarium was for some time the largest indoor " +
								"facility in the world. Today it holds about 32,000 animals. Shedd Aquarium was the first " +
								"inland aquarium with a permanent saltwater fish collection. It is located on Lake Michigan, " +
								"on the Museum Campus Chicago, along with the Adler Planetarium and the Field Museum of Natural " +
								"History. In 2015, the aquarium had 2.02 million visitors. It was the most visited aquarium in " +
								"the U.S. in 2005, and in 2007, it surpassed the Field Museum as the most popular cultural " +
								"attraction in Chicago. The aquarium contains 1,500 species, including fish, marine mammals, " +
								"birds, snakes, amphibians, and insects. The aquarium received awards for \"best exhibit\" from " +
								"the Association of Zoos and Aquariums for Seahorse Symphony in 1999, Amazon Rising in 2001, " +
								"and Wild Reef in 2004. It was designated a National Historic Landmark in 1987.",
						list,
						location));
				System.out.println("Added");
			}
		};
	}

	@Bean
	CommandLineRunner questionRepositoryRunner (QuestionRepository repository){
		return args -> {
			if(repository.findAll().isEmpty()){
				repository.save(new Question(
						"6155b90c1a8ab24f145703b8",
						"What does ARC stand for?",
						"Academic and Residential Complex",
						"Alliance of Righthanded Clowns",
						"Advanced Risc Computing",
						"Acrobats Residing in Colombia"
				));
				System.out.println("Added");
			}
		};
	}

	@Bean
	CommandLineRunner quizResultRunner (QuizResultRepository repository){
		return args -> {
			if(repository.findAll().isEmpty()){
				repository.save(new QuizResult(
						"6155b90c1a8ab24f145703b8",
						"kyr",
						5,
						5
				));
				System.out.println("Added");
			}
		};
	}
}
