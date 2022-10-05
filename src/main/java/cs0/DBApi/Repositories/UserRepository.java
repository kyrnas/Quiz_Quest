package cs0.DBApi.Repositories;

import cs0.DBApi.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String email);
    User findUserByUsername(String username);
}
