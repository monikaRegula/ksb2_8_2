package pl.regula.ksb2_8_2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    private String title;

    private String input;

    public Note() {
    }

    public Note(String title, String noteContent) {
        this.title = title;
        this.input = noteContent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String xd) {
        this.input = xd;
    }
}
