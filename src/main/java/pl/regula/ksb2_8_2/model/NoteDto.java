package pl.regula.ksb2_8_2.model;

public class NoteDto {
    private String title;
    private String input;

    public NoteDto(String title, String noteContent) {
        this.title = title;
        this.input = noteContent;
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

    public void setInput(String input) {
        this.input = input;
    }
}
