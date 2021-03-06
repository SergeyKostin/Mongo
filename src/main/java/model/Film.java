package model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "film")
public class Film {
    private String name;
    @Id
    private String id_film;
    private List<Genre> genreList=new ArrayList<>();

    public Film(){}
    public Film(String name){
        this.name=name;
    }
    public Film(String name, ArrayList<Genre> genreList){
        this.name=name;
        this.genreList=genreList;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void addGenry(Genre genre){
        this.genreList.add(genre);
    }
    @Override
    public String toString() {
        return "Film: " + this.name+"  Id: " + this.id_film;
    }
}
