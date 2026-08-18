package hu.programon.backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "ertesites")
public class Ertesites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cimzett_felhasznalo_id", nullable = false)
    private Felhasznalo cimzettFelhasznalo;

    @ManyToOne
    @JoinColumn(name = "kuldo_felhasznalo_id")
    private Felhasznalo kuldoFelhasznalo;

    @ManyToOne
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ErtesitesTipus tipus;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String uzenet;

    @Column(nullable = false)
    private Boolean olvasott = false;

    @Column(name = "email_kuldes", nullable = false)
    private Boolean emailKuldes = false;

    @Column(name = "letrehozas_datuma", nullable = false)
    private LocalDateTime letrehozasDatuma;

    @Column(name = "elkuldes_datuma")
    private LocalDateTime elkuldesDatuma;

    @Column(name = "deduplikacios_kulcs", unique = true, length = 255)
    private String deduplikaciosKulcs;

    public Ertesites() {
    }

    public Ertesites(
            Felhasznalo cimzettFelhasznalo,
            Felhasznalo kuldoFelhasznalo,
            Program program,
            ErtesitesTipus tipus,
            String uzenet,
            Boolean olvasott,
            Boolean emailKuldes,
            LocalDateTime letrehozasDatuma,
            LocalDateTime elkuldesDatuma,
            String deduplikaciosKulcs) {

        this.cimzettFelhasznalo = cimzettFelhasznalo;
        this.kuldoFelhasznalo = kuldoFelhasznalo;
        this.program = program;
        this.tipus = tipus;
        this.uzenet = uzenet;
        this.olvasott = olvasott;
        this.emailKuldes = emailKuldes;
        this.letrehozasDatuma = letrehozasDatuma;
        this.elkuldesDatuma = elkuldesDatuma;
        this.deduplikaciosKulcs = deduplikaciosKulcs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Felhasznalo getCimzettFelhasznalo() {
        return cimzettFelhasznalo;
    }

    public void setCimzettFelhasznalo(Felhasznalo cimzettFelhasznalo) {
        this.cimzettFelhasznalo = cimzettFelhasznalo;
    }

    public Felhasznalo getKuldoFelhasznalo() {
        return kuldoFelhasznalo;
    }

    public void setKuldoFelhasznalo(Felhasznalo kuldoFelhasznalo) {
        this.kuldoFelhasznalo = kuldoFelhasznalo;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public ErtesitesTipus getTipus() {
        return tipus;
    }

    public void setTipus(ErtesitesTipus tipus) {
        this.tipus = tipus;
    }

    public String getUzenet() {
        return uzenet;
    }

    public void setUzenet(String uzenet) {
        this.uzenet = uzenet;
    }

    public Boolean getOlvasott() {
        return olvasott;
    }

    public void setOlvasott(Boolean olvasott) {
        this.olvasott = olvasott;
    }

    public Boolean getEmailKuldes() {
        return emailKuldes;
    }

    public void setEmailKuldes(Boolean emailKuldes) {
        this.emailKuldes = emailKuldes;
    }

    public LocalDateTime getLetrehozasDatuma() {
        return letrehozasDatuma;
    }

    public void setLetrehozasDatuma(LocalDateTime letrehozasDatuma) {
        this.letrehozasDatuma = letrehozasDatuma;
    }

    public LocalDateTime getElkuldesDatuma() {
        return elkuldesDatuma;
    }

    public void setElkuldesDatuma(LocalDateTime elkuldesDatuma) {
        this.elkuldesDatuma = elkuldesDatuma;
    }

    public String getDeduplikaciosKulcs() {
        return deduplikaciosKulcs;
    }

    public void setDeduplikaciosKulcs(String deduplikaciosKulcs) {
        this.deduplikaciosKulcs = deduplikaciosKulcs;
    }
}