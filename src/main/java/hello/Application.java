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

    @RequestMapping(value = "/getFilmByProd", method = RequestMethod.POST)
    public String getFilmByProd(Map<String, Object> map, @RequestParam("prod_surname") String surname) {
        List<Producer> prodList1 = new ArrayList<>();
        prodList1.add(this.producerRepository.findBySurname(surname));
        map.put("prodList", prodList1);
        return "filmsList";
    }

    @RequestMapping(value = "/getFilmByName", method = RequestMethod.POST)
    public String getFilmByName(Map<String, Object> map, @RequestParam("film_name") String filmName) {
        List<Producer> prodListbyFilm = new ArrayList<>();
        for (int i = 0; i < this.prodList.size(); i++) {
            Producer producer = new Producer();
            producer = this.prodList.get(i);
            for (int j = 0; j < producer.getFilmList().size(); j++) {
                Film film = new Film();
                film = producer.getFilmList().get(j);
                if (film.getName().equals(filmName)) {
                    prodListbyFilm.add(producer);
                }

            }

        }

        map.put("prodList", prodListbyFilm);
        return "filmsList";
    }

    @RequestMapping(value = "/getFilmByGenre", method = RequestMethod.POST)
    public String getFilmByGenre(Map<String, Object> map, @RequestParam("genre") String genre) {
        List<Producer> prodListbyGenre = new ArrayList<>();
        for (int i = 0; i < this.prodList.size(); i++) {
            Producer producer = new Producer();
            producer = this.prodList.get(i);
            for (int j = 0; j < producer.getFilmList().size(); j++) {
                Film film = new Film();
                film = producer.getFilmList().get(j);
                for (int g = 0; g < film.getGenreList().size(); g++) {
                    Genre genre1 = new Genre();
                    genre1 = film.getGenreList().get(g);
                    if (genre1.getName().equals(genre) == true) {
                        prodListbyGenre.add(producer);
                    }

                }

            }
        }
        map.put("prodList", prodListbyGenre);
        return "filmsList";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delite(Map<String, Object> map, @RequestParam("surn") String surn) {
        Producer producer1 = this.producerRepository.findBySurname(surn);
        this.producerRepository.delete(producer1);
        this.prodList = new ArrayList<Producer>();
        for (Producer producer : producerRepository.findAll()) {
            this.prodList.add(producer);
        }
        map.put("prodList", prodList);
        return "filmsList";
    }

    @RequestMapping(value = "/addFilm",method = RequestMethod.POST)
    public String addFilm(@RequestParam("name_producer") String name, @RequestParam("surname_producer") String surname, @RequestParam("patronymic_producer") String patronymic, @RequestParam("film") String film, @RequestParam("genre") String genre){
        Genre genre1=new Genre(genre);
        Film film1=new Film();
        film1.setName(film);
        film1.addGenry(genre1);
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
