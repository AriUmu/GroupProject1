import java.util.Date;

public class Magazine {

    private Integer id;
    private String name;
    private Integer id_publisher;
    private Integer id_genre;
    private Date date_release;
    private String describe;

    public Magazine(Integer id, String name, Integer id_publisher, Integer id_genre, Date date_release, String describe) {
        this.id = id;
        this.name = name;
        this.id_publisher = id_publisher;
        this.id_genre = id_genre;
        this.date_release = date_release;
        this.describe = describe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(Integer id_publisher) {
        this.id_publisher = id_publisher;
    }

    public Integer getId_genre() {
        return id_genre;
    }

    public void setId_genre(Integer id_genre) {
        this.id_genre = id_genre;
    }

    public Date getDate_release() {
        return date_release;
    }

    public void setDate_release(Date date_release) {
        this.date_release = date_release;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
