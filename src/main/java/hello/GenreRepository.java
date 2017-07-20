package hello;


import model.Genre;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenreRepository extends MongoRepository<Genre,String> {
    public Genre findByName(String name);
}
