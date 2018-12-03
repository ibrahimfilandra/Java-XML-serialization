package ba.unsa.etf.rpr.tutorijal07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Tutorijal {

    void ucitajGradove() {

        Scanner ulaz;

        try {
             ulaz=new Scanner(new FileReader("gradovi.txt"));
        }
catch(FileNotFoundException e) {
    System.out.println("Datoteka gradovi.txt ne postoji ili se ne može otvoriti.");
    System.out.println("Greška: " + e);
    return;
}


    }

    public static void main (String []args){


    }



}
