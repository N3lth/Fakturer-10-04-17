package eu.programisci.Test.animal.dto;

public class AnimalDTO {

    private Long id;
    private String gatunek;
    private String rasa;
    private String imie;
    private Integer wiek;
    private String kolor;
    private String uwagi;

    public AnimalDTO() {
    }

    public AnimalDTO(Long id, String gatunek, String rasa, String imie, Integer wiek, String kolor, String uwagi) {
        this.id = id;
        this.gatunek = gatunek;
        this.rasa = rasa;
        this.imie = imie;
        this.wiek = wiek;
        this.kolor = kolor;
        this.uwagi = uwagi;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getRasa() {
        return rasa;
    }

    public void setRasa(String rasa) {
        this.rasa = rasa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public Integer getWiek() {
        return wiek;
    }

    public void setWiek(Integer wiek) {
        this.wiek = wiek;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }
}
