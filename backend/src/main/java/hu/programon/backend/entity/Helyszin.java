package hu.programon.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "helyszin")
public class Helyszin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nev;

    @Column(nullable = false, length = 255)
    private String cim;

    @Column(nullable = false, length = 100)
    private String telepules;

    @Column(nullable = false)
    private Boolean aktiv = true;

    public Helyszin() {
    }

    public Helyszin(
            String nev,
            String cim,
            String telepules,
            Boolean aktiv) {

        this.nev = nev;
        this.cim = cim;
        this.telepules = telepules;
        this.aktiv = aktiv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getCim() {
        return cim;
    }

    public void setCim(String cim) {
        this.cim = cim;
    }

    public String getTelepules() {
        return telepules;
    }

    public void setTelepules(String telepules) {
        this.telepules = telepules;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }
}