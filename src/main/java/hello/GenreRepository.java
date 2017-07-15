package hello;


import model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre,Integer> {
    public Genre findByName(String name);
}
