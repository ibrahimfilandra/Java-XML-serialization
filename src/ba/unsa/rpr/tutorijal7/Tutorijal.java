package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Tutorijal {

    static ArrayList<Grad> ucitajGradove() {

        Scanner ulaz;

        try {
            ulaz = new Scanner(new FileReader("gradovi.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Datoteka gradovi.txt ne postoji ili se ne može otvoriti.");
            System.out.println("Greška: " + e);
            return null;
        }

        ArrayList<Grad> gradovi = new ArrayList<Grad>();
        int i = 0;
        while (ulaz.hasNext()) {
            String pomocni = ulaz.next();
            gradovi.add(new Grad());
            String[] elementi = pomocni.split(",");
            gradovi.get(i).setNaziv(elementi[0]);
            int j = 0;
            double[] temperature = new double[1000];
            while (true) {
                try {
                    temperature[j] = Double.parseDouble(elementi[j + 1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
                j++;
            }
            gradovi.get(i).setTemperature(temperature);
            i++;
        }

        return gradovi;
    }

    static UN ucitajXml(ArrayList<Grad> lista) {

        Document xmldoc = null;
        try {
            DocumentBuilder docReader
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            xmldoc = docReader.parse(new File("drzave.xml"));
        } catch (Exception e) {
            System.out.println("drzave.xml nije validan XML dokument");
            return null;
        }

        Element korijen = xmldoc.getDocumentElement();
       ArrayList<Drzava> listadrzava = new ArrayList<>();
        UcitajElement(korijen,listadrzava);
      UN un= new UN();
      un.setListadrzava(listadrzava);
        Iterator it1 = listadrzava.iterator();
        Iterator it2= lista.iterator();
      while(it1.hasNext()) {
          Grad grad =(Grad) it1.next();

          while(it2.hasNext()){

              Drzava drzava= (Drzava) it2.next();
              if (drzava.getGlavnigrad().getNaziv().equals(grad.getNaziv())  ){
                 double niz1 [] = drzava.getGlavnigrad().getTemperature();
                 double niz2 [] = grad.getTemperature();
                 int i=0;
                 while(true){
                     try{
                         niz1[i]=niz2[i];
                         i++;
                     }
                     catch(ArrayIndexOutOfBoundsException e) {
                         break;
                     }

              }


              }
          }
      }



        return un;
    }

   static void UcitajElement(Element element, ArrayList<Drzava> listadrzava){

        NodeList djeca=element.getChildNodes();
        for(int i=0;i<djeca.getLength();i++) {
            Node drzava=djeca.item(i);
            int brstanovnika=   Integer.parseInt (((Element)drzava).getAttribute("stanovnika"));
           NodeList listazadrzavu= ((Element) drzava).getChildNodes();

           Element naziv=  (Element)listazadrzavu.item(0);
           String nazivdrzave= naziv.getTextContent();

           Element glavnigrad = (Element)listazadrzavu.item(1);
           int brstanovnikagrada= Integer.parseInt (glavnigrad.getAttribute("stanovnika"));
           NodeList listazagrad=glavnigrad.getChildNodes();
           String nazivgrada= listazagrad.item(0).getTextContent();

           Element povrsina = (Element)listazadrzavu.item(2);
           String jedinicazapovrsinu = (povrsina).getAttribute("jedinica");
           double povrsinadrzave = Double.parseDouble(povrsina.getTextContent());
listadrzava.add(new Drzava(nazivdrzave, jedinicazapovrsinu, brstanovnika, povrsinadrzave, new Grad(nazivgrada, brstanovnikagrada, new double[1000]) ));


        }



    }

    static void upisiXML(UN un) {


        try {
            XMLEncoder izlaz = new XMLEncoder(new FileOutputStream("un.xml"));
            izlaz.writeObject(un);
            izlaz.close();
        }
        catch(Exception e) {
System.out.println("Greska: "+e);
        }


    }

    public static void main(String[] args) {

    }


}
