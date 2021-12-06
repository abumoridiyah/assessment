package com.assesment.assesment.Repository;

import com.assesment.assesment.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<Users,String> {
}
