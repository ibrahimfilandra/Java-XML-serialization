package ba.unsa.rpr.tutorijal7;

public class Grad {

    private String naziv;
    private int brojstanovnika;
    private double [] temperature = new double[1000];


    public Grad() {
        this.naziv="";
        brojstanovnika=0;
    }

    public Grad(String naziv, int brojstanovnika, double[] temperature) {
        this.naziv = naziv;
        this.brojstanovnika = brojstanovnika;
        this.temperature = temperature;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getBrojstanovnika() {
        return brojstanovnika;
    }

    public void setBrojstanovnika(int brojstanovnika) {
        this.brojstanovnika = brojstanovnika;
    }

    public double[] getTemperature() {
        return temperature;
    }

    public void setTemperature(double[] temperature) {
        this.temperature = temperature;
    }


}
