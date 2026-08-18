package hu.programon.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "felhasznalo")
public class Felhasznalo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nev;

    @Column(nullable = false, unique = true, length = 255)
    private String email;

    @Column(nullable = false, length = 255)
    private String jelszo;

    @ManyToOne
    @JoinColumn(name = "jogosultsag_id", nullable = false)
    private Jogosultsag jogosultsag;

    @Column(nullable = false)
    private Boolean aktiv = true;

    @Column(name = "letrehozas_datuma", nullable = false)
    private LocalDateTime letrehozasDatuma;

    @Column(nullable = false, unique = true, length = 100)
    private String felhasznalonev;

    @Column(length = 30)
    private String telefonszam;

    public Felhasznalo() {
    }

    public Felhasznalo(
            String nev,
            String email,
            String jelszo,
            Jogosultsag jogosultsag,
            Boolean aktiv,
            LocalDateTime letrehozasDatuma,
            String felhasznalonev,
            String telefonszam) {

        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
        this.jogosultsag = jogosultsag;
        this.aktiv = aktiv;
        this.letrehozasDatuma = letrehozasDatuma;
        this.felhasznalonev = felhasznalonev;
        this.telefonszam = telefonszam;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public Jogosultsag getJogosultsag() {
        return jogosultsag;
    }

    public void setJogosultsag(Jogosultsag jogosultsag) {
        this.jogosultsag = jogosultsag;
    }

    public Boolean getAktiv() {
        return aktiv;
    }

    public void setAktiv(Boolean aktiv) {
        this.aktiv = aktiv;
    }

    public LocalDateTime getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDateTime letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getTelefonszam() {
        return telefonszam;
    }

    public void setTelefonszam(String telefonszam) {
        this.telefonszam = telefonszam;
    }
}