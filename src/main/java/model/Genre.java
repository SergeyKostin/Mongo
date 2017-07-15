package model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "genre")
public class Genre {
    private String name;
    @Id
    private int id_genre;

    public Genre(){}
    public Genre(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getId_genre() {
        return id_genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_genre(int id_genre) {
        this.id_genre = id_genre;
    }
}
