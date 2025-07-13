package alex.spring_mongodb.repository;

import alex.spring_mongodb.entityClass.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByName(String name);

    List<User> findByAgeGreaterThan(int age);
}