package hello;


import model.Film;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmRepository extends MongoRepository<Film,Integer> {
    public Film findByName(String name);

}
