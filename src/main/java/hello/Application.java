package hello;


import model.Film;
import model.Genre;
import model.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EnableAutoConfiguration
@Controller
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private ProducerRepository producerRepository;

    private List<Producer> prodList;//=new ArrayList<Producer>();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/hello")
    public String showHello(Map<String,Object> map) {
        this.prodList=new ArrayList<Producer>();
        for (Producer producer : producerRepository.findAll()){
            this.prodList.add(producer);}
        map.put("prodList",prodList);
        return "filmsList";
    }
    @RequestMapping(value = "/getAddFilm", method = RequestMethod.POST)
    public String getAddFilm() {
        return "addFilm";
    }

    @RequestMapping(value = "/addFilm",method = RequestMethod.POST)
    public String addFilm(@RequestParam("name_producer") String name, @RequestParam("surname_producer") String surname, @RequestParam("patronymic_producer") String patronymic, @RequestParam("film") String film, @RequestParam("genre") String genre){
        this.genreRepository.deleteAll();
        Genre genre1=new Genre(genre);
        this.genreRepository.save(genre1);
        this.filmRepository.deleteAll();
        Film film1=new Film();
        film1.setName(film);
        film1.addGenry(genre1);
        this.filmRepository.save(film1);
        this.producerRepository.deleteAll();
        Producer producer1=new Producer();
        producer1.setName(name);
        producer1.setSurname(surname);
        producer1.setPatronymic(patronymic);
        producer1.addFilm(film1);
        this.producerRepository.save(producer1);
        return "addFilm";
    }



    @Override
    public void run(String... args) throws Exception {
    }
    }
