package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Spectacol  extends ContractActor{

    String tara, denumirea;
    double buget;
    int nr_actori;

    public Spectacol(){};

    public Spectacol(String tara, String denumirea, double buget, int nr_actori) {
        this.tara = tara;
        this.denumirea = denumirea;
        this.buget = buget;
        this.nr_actori = nr_actori;
    }

    public Spectacol(String nume, String prenume, String titlu, String premii, String tara, String denumirea, double buget, int nr_actori) {
        super(nume, prenume, titlu, premii);
        this.tara = tara;
        this.denumirea = denumirea;
        this.buget = buget;
        this.nr_actori = nr_actori;
    }

    public Spectacol(String nume, String prenume, String titlu, String premii, String rol, int stagi, int km, double salariu, double premiu, String tara, String denumirea, double buget, int nr_actori) {
        super(nume, prenume, titlu, premii, rol, stagi, km, salariu, premiu);
        this.tara = tara;
        this.denumirea = denumirea;
        this.buget = buget;
        this.nr_actori = nr_actori;
    }

    public Spectacol(String denumirea, double buget) {
        this.denumirea = denumirea;
        this.buget = buget;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getDenumirea() {
        return denumirea;
    }

    public void setDenumirea(String denumirea) {
        this.denumirea = denumirea;
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) {
        this.buget = buget;
    }

    public int getNr_actori() {
        return nr_actori;
    }

    public void setNr_actori(int nr_actori) {
        this.nr_actori = nr_actori;
    }

    @Override
    public String toString() {
        return "Spectacol{" +
                "tara='" + tara + '\'' +
                ", denumirea='" + denumirea + '\'' +
                ", buget=" + buget +
                ", nr_actori=" + nr_actori +
                '}';
    }

    static ArrayList<Spectacol> Cit() throws IOException {
        ArrayList<Spectacol> Sp = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader("src/files/Spectacol.txt"));
        while (reader.hasNext()) {
            String tara = reader.next();
            String denumirea = reader.next();
            double buget = Double.parseDouble(reader.next());
            int nr_actori = Integer.parseInt(reader.next());
            Sp.add(new Spectacol( tara, denumirea, buget, nr_actori));
        }
        reader.close();
        return Sp;
    }

    public static void Afisare() {
        System.out.println();
        System.out.println();
        ArrayList<Spectacol> Citire = new ArrayList<>();
        try {
            Citire = Cit();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Spectacol i : Citire) {
            System.out.println(i.getTara()+ "   "+ i.getDenumirea() + "   " + i.getBuget() + "   " + i.getNr_actori());
        }
    }
}
