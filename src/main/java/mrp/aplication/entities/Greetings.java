package mrp.aplication.entities;

public class Greetings {

    private final long id;
    private final String content;

    public Greetings(long idParam, String contentParam) {
        id = idParam;
        content = contentParam;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
