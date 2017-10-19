public class Publisher {
    private Integer id;
    private String publisher_house;

    public Publisher(){

    }

    public Publisher(Integer id, String publisher_house) {
        this.id = id;
        this.publisher_house = publisher_house;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisher_house() {
        return publisher_house;
    }

    public void setPublisher_house(String publisher_house) {
        this.publisher_house = publisher_house;
    }
}
