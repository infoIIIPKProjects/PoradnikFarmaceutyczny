package skoczny.jedynak.poradnik.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Damian on 2016-06-05.
 */
@Entity
public class PageActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "counter")
    private int counter;

    @Column(name = "date")
    private Date date;

    @Column(name = "pageName")
    private String pageName;


    public void setDate(Date date) {
        this.date = date;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageActivity that = (PageActivity) o;

        if (id != that.id) return false;
        if (counter != that.counter) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return pageName != null ? pageName.equals(that.pageName) : that.pageName == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + counter;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (pageName != null ? pageName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageActivity{" +
                "id=" + id +
                ", counter=" + counter +
                ", date=" + date +
                ", pageName='" + pageName + '\'' +
                '}';
    }
}
