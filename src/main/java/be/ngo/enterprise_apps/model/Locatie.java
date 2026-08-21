package be.ngo.enterprise_apps.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "locatie",
        uniqueConstraints = @UniqueConstraint(columnNames = "naam")
)
public class Locatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String naam;

    @Column(nullable = false)
    private String adres;

    @Column(nullable = false)
    private int capaciteit;

    public Locatie() {
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }
}
