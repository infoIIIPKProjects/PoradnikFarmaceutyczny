package skoczny.jedynak.poradnik.model;

import javax.persistence.*;

@Entity(name = "choroba")
@Table(name = "choroba")
public class Choroba {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "lek_id")
    private Lek lek;

    @ManyToOne
    @JoinColumn(name = "kategoriaChoroby_id")
    private KategoriaChoroby kategoriaChoroby;

    @Column(columnDefinition="TEXT")
    private String description;

    private String nazwa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KategoriaChoroby getKategoriaChoroby() {
        return kategoriaChoroby;
    }

    public void setKategoriaChoroby(KategoriaChoroby kategoriaChoroby) {
        this.kategoriaChoroby = kategoriaChoroby;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    @Override
    public String toString() {
        return nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Choroba choroba = (Choroba) o;

        if (id != choroba.id) return false;
        if (lek != null ? !lek.equals(choroba.lek) : choroba.lek != null) return false;
        if (kategoriaChoroby != null ? !kategoriaChoroby.equals(choroba.kategoriaChoroby) : choroba.kategoriaChoroby != null)
            return false;
        if (description != null ? !description.equals(choroba.description) : choroba.description != null) return false;
        return nazwa != null ? nazwa.equals(choroba.nazwa) : choroba.nazwa == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (lek != null ? lek.hashCode() : 0);
        result = 31 * result + (kategoriaChoroby != null ? kategoriaChoroby.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }
}
