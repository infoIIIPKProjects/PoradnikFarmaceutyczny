package skoczny.jedynak.poradnik.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "lek")
@Table(name = "lek")
public class Lek {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String lekName;

    @Column(name = "cena")
    private double cena;

    @Column(name = "dostepnosc")
    private boolean czyDostepny;

    @OneToMany(mappedBy = "lek", fetch = FetchType.EAGER, orphanRemoval = true,cascade = CascadeType.ALL)
    private Collection<Choroba> chorobas = new ArrayList<Choroba>();

    public Collection<Choroba> getChorobas() {
        return chorobas;
    }

    public void setChorobas(Collection<Choroba> chorobas) {
        this.chorobas = chorobas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLekName() {
        return lekName;
    }

    public void setLekName(String lekName) {
        this.lekName = lekName;
    }

    @Override
    public String toString() {
        return "" + lekName;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public boolean isCzyDostepny() {
        return czyDostepny;
    }

    public void setCzyDostepny(boolean czyDostepny) {
        this.czyDostepny = czyDostepny;
    }
}
