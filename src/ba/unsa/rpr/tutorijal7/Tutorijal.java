package ba.unsa.rpr.tutorijal7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Array;
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

        Iterator it1 = listadrzava.iterator();
        Iterator it2= lista.iterator();

    /*  while(it1.hasNext()) {
          Grad grad1 =  ( (Drzava) it1.next()).getGlavnigrad() ;

          while(it2.hasNext()){

              Grad grad2= (Grad) it2.next();
              if (grad2.getNaziv().equals(grad1.getNaziv())  ){
                 double niz1 [] = grad1.getTemperature();
                 double niz2 [] = grad2.getTemperature();
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
      } */
un.setDrzave(listadrzava);


        return un;
    }

   static void UcitajElement(Element element, ArrayList<Drzava> listadrzava){

        NodeList djeca=element.getChildNodes();
        System.out.println(djeca.getLength());
        for(int i=0;i<djeca.getLength();i++) {
            Node drzava1=djeca.item(i);
            if(drzava1 instanceof Element) {
                Element drzava = (Element) drzava1;
                System.out.println("ok");

                int brstanovnika = Integer.parseInt(drzava.getAttribute("stanovnika"));
                NodeList listazadrzavu = drzava.getChildNodes();
                System.out.println(listazadrzavu.getLength());
                for (int j = 0; j < listazadrzavu.getLength(); j++){
                    if (listazadrzavu.item(j) instanceof Element ) {

String nazivdrzave="";
                        Element elementnovi = (Element) listazadrzavu.item(j);
                        if (elementnovi.getTagName() == "naziv") {
                             nazivdrzave = elementnovi.getTextContent();
                        }

                        int brstanovnikagrada=0;
                            if(elementnovi.getTagName()=="glavnigrad") {
                                brstanovnikagrada = Integer.parseInt(elementnovi.getAttribute("stanovnika"));
                            }
                            NodeList listazagrad = elementnovi.getChildNodes();
                            String nazivgrada = listazagrad.item(0).getTextContent();


                                Element povrsina = (Element) listazadrzavu.item(2);
                                String jedinicazapovrsinu = (povrsina).getAttribute("jedinica");
                                double povrsinadrzave = Double.parseDouble(povrsina.getTextContent());
                                listadrzava.add(new Drzava(nazivdrzave, jedinicazapovrsinu, brstanovnika, povrsinadrzave, new Grad(nazivgrada, brstanovnikagrada, new double[1000])));

                                System.out.println("dodano je");


                    }
            }
            }

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

        ArrayList<Grad> lista = new ArrayList<>();
        lista=ucitajGradove();

        UN un= new UN();

        un=ucitajXml(lista);
      /*   System.out.println(un.getDrzave().get(0).getGlavnigrad().getNaziv());
        System.out.println(un.getDrzave().get(0).getGlavnigrad().getBrojstanovnika());
        System.out.println(un.getDrzave().get(0).getBrojstanovnika());
        System.out.println(un.getDrzave().get(0).getNaziv());
        System.out.println(un.getDrzave().get(0).getJedinicazapovrsinu());
        System.out.println(un.getDrzave().get(0).getPovrsina());
*/
      System.out.println(un.getDrzave().size());

       // upisiXML(un);


    }


}
