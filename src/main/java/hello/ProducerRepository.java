package hello;


import model.Producer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProducerRepository extends MongoRepository<Producer,Integer> {
    public Producer findByName(String name);
    public Producer findBySurname(String surname);
}
