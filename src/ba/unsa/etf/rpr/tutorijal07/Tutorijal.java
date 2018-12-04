package ba.unsa.etf.rpr.tutorijal07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Tutorijal {

    static ArrayList<Grad> ucitajGradove() {

        Scanner ulaz;

        try {
             ulaz=new Scanner(new FileReader("gradovi.txt"));
        }
catch(FileNotFoundException e) {
    System.out.println("Datoteka gradovi.txt ne postoji ili se ne može otvoriti.");
    System.out.println("Greška: " + e);
    return null;
}

ArrayList<Grad> gradovi = new ArrayList<Grad>();
        int i=0;
while(ulaz.hasNext()) {
    String pomocni= ulaz.next();
    gradovi.add(new Grad());
String [] elementi=pomocni.split(",");
gradovi.get(i).setNaziv(elementi[0]);
int j=0;
double [] temperature = new double[1000];
while(true) {
    try{
        temperature[j]=Double.parseDouble(elementi[j+1]);
    }
    catch(ArrayIndexOutOfBoundsException e) {
        break;
    }
    j++;
}
gradovi.get(i).setTemperature(temperature);
i++;
}

return gradovi;
}

    public static void main (String []args){

    }



}
