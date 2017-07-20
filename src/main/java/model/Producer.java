package model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document(collection = "producer")
public class Producer {
    private String name;
    private String surname;
    private String patronymic;
    private List<Film> filmList=new ArrayList<>();
    @Id
    private String id;

    public Producer(){}
    public Producer(String name, String surname, String patronymic){
        this.name=name;
        this.surname=surname;
        this.patronymic=patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void addFilm(Film film){
        this.filmList.add(film);
    }
    public void setFilmList(ArrayList <Film> filmList){
        this.filmList=filmList;
    }
    public List<Film> getFilmList(){
        return  this.filmList;
    }
}
