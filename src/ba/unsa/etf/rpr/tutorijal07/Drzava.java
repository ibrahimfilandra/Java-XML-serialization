package ba.unsa.etf.rpr.tutorijal07;

public class Drzava {

   private String naziv, jedinicazapovrsinu;
    private int brojstanovnika;
    private double povrsina;
    private Grad glavnigrad;

    public Drzava() {
        this. naziv="";
        this.jedinicazapovrsinu="";
        this.brojstanovnika=0;
        this.povrsina=0;
        this.glavnigrad=new Grad();
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getJedinicazapovrsinu() {
        return jedinicazapovrsinu;
    }

    public void setJedinicazapovrsinu(String jedinicazapovrsinu) {
        this.jedinicazapovrsinu = jedinicazapovrsinu;
    }

    public int getBrojstanovnika() {
        return brojstanovnika;
    }

    public void setBrojstanovnika(int brojstanovnika) {
        this.brojstanovnika = brojstanovnika;
    }

    public double getPovrsina() {
        return povrsina;
    }

    public void setPovrsina(double povrsina) {
        this.povrsina = povrsina;
    }

    public Grad getGlavnigrad() {
        return glavnigrad;
    }

    public void setGlavnigrad(Grad glavnigrad) {
        this.glavnigrad = glavnigrad;
    }
}
