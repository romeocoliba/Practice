package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Math.round;

public class Angajat implements Euro{

    String Nume, Prenume, Adresa, Nr_telefon, Functia;
    int IDNP;
    double Salariu;

    public Angajat() {}
    //constructori
    public Angajat( int IDNP, String nume, String prenume, String adresa, String nr_telefon, String functia, double salariu) {
        Nume = nume;
        Prenume = prenume;
        Adresa = adresa;
        Nr_telefon = nr_telefon;
        Functia = functia;
        this.IDNP = IDNP;
        Salariu = salariu;
    }

    public Angajat(String nume, String prenume, String adresa, String nr_telefon) {
        Nume = nume;
        Prenume = prenume;
        Adresa = adresa;
        Nr_telefon = nr_telefon;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getAdresa() {
        return Adresa;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public String getNr_telefon() {
        return Nr_telefon;
    }

    public void setNr_telefon(String nr_telefon) {
        Nr_telefon = nr_telefon;
    }

    public String getFunctia() {
        return Functia;
    }

    public void setFunctia(String functia) {
        Functia = functia;
    }

    public int getIDNP() {
        return IDNP;
    }

    public void setIDNP(int IDNP) {
        this.IDNP = IDNP;
    }

    public double getSalariu() {
        return Salariu;
    }

    public void setSalariu(double salariu) {
        Salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", Adresa='" + Adresa + '\'' +
                ", Nr_telefon='" + Nr_telefon + '\'' +
                ", Functia='" + Functia + '\'' +
                ", IDNP=" + IDNP +
                ", Salariu=" + Salariu +
                '}';
    }

    static ArrayList<Angajat> Citire() throws IOException {
        ArrayList<Angajat> An = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader("src/files/Angajati.txt"));
        while (reader.hasNext()) {
            int IDNP = Integer.parseInt(reader.next());
            String  Nume = reader.next();
            String Prenume = reader.next();
            String Adresa = reader.next();
            String Nr_telefon = reader.next();
            String Functia = reader.next();
            double Salariu = parseDouble(reader.next());
            An.add(new Angajat( IDNP, Nume, Prenume, Adresa, Nr_telefon, Functia, Salariu));
        }
        reader.close();
        return An;
    }

    public static void Afisare() {
        System.out.println();
        System.out.println();
        ArrayList<Angajat> Citire = new ArrayList<>();
        try {
            Citire = Citire();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Angajat i : Citire) {
            System.out.println(i.getIDNP() + "   "+ i.getNume() + "   " + i.getPrenume() + "   " + i.getAdresa() + "   " + i.getNr_telefon() + "   " + i.getFunctia() + "   " + i.getSalariu());
        }
    }

    public static void getEuro(){
        ArrayList<Angajat> Citire = new ArrayList<>();
        try {
            Citire = Citire();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Angajat i : Citire) {
            i.setSalariu(i.getSalariu() / E);
            i.setSalariu(round((i.getSalariu()),2));
            System.out.println(i.getIDNP() + "   "+ i.getNume() + "   " + i.getPrenume() + "   " + i.getAdresa() + "   " + i.getNr_telefon() + "   " + i.getFunctia() + "   " + i.getSalariu());
        }
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
