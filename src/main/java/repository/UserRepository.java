package repository;

import model.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface UserRepository extends MongoRepository<UserModel, String> {
}
