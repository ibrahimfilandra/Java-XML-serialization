package ba.unsa.etf.rpr.tutorijal07;

public class Grad {

    private String naziv;
    private int brojstanovnika;
    private double [] temperature = new double[1000];


    public Grad() {
        this.naziv="";
        brojstanovnika=0;
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
