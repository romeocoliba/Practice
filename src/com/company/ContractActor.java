package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ContractActor extends Premii implements Euro{

    String  Nume, Prenume, titlu, premii, rol;
    int stagi, km;
    double salariu, premiu;

    public ContractActor(){}

    public ContractActor(String nume, String prenume, String titlu, String premii) {
        Nume = nume;
        Prenume = prenume;
        this.titlu = titlu;
        this.premii = premii;
    }

    public ContractActor(String nume, String prenume, String titlu, String premii, String rol, int stagi, int km, double salariu, double premiu) {
        Nume = nume;
        Prenume = prenume;
        this.titlu = titlu;
        this.premii = premii;
        this.rol = rol;
        this.stagi = stagi;
        this.km = km;
        this.salariu = salariu;
        this.premiu = premiu;
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

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getPremii() {
        return premii;
    }

    public void setPremii(String premii) {
        this.premii = premii;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getStagi() {
        return stagi;
    }

    public void setStagi(int stagi) {
        this.stagi = stagi;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }

    public double getPremiu() {
        return premiu;
    }

    public void setPremiu(double premiu) {
        this.premiu = premiu;
    }

    @Override
    public String toString() {
        return "ContractActor{" +
                "Nume='" + Nume + '\'' +
                ", Prenume='" + Prenume + '\'' +
                ", titlu='" + titlu + '\'' +
                ", premii='" + premii + '\'' +
                ", rol='" + rol + '\'' +
                ", stagi=" + stagi +
                ", km=" + km +
                ", salariu=" + salariu +
                ", premiu=" + premiu +
                '}';
    }

    static ArrayList<ContractActor> Reader() throws IOException {
        ArrayList<ContractActor> Ca = new ArrayList<>();
        Scanner reader = new Scanner(new FileReader("src/files/ContractActor.txt"));
        while (reader.hasNext()) {
            String  Nume = reader.next();
            String Prenume = reader.next();
            String titlu = reader.next();
            String premii = reader.next();
            String rol = reader.next();
            int stagi = Integer.parseInt(reader.next());
            int km = Integer.parseInt(reader.next());
            double salariu = Double.parseDouble(reader.next());
            double premiu = Double.parseDouble(reader.next()) ;
            Ca.add(new ContractActor(Nume, Prenume, titlu, premii, rol, stagi, km, salariu, premiu));
        }
        reader.close();
        return Ca;
    }

    public static void Afisare() {
        System.out.println();
        System.out.println();
        System.out.println();
        ArrayList<ContractActor> Citire = new ArrayList<>();
        try {
            Citire = Reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ContractActor i : Citire) {
            System.out.println(i.getNume()+ "   " + i.getPrenume() + "   " + i.getTitlu() + "   " + i.getPremii() + "   " + i.getRol() + "   " + i.getStagi()
                    + "   " + i.getSalariu());
        }
    }


    public static void getEuro(){
        ArrayList<ContractActor> Citire = new ArrayList<>();
        try {
            Citire = Reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ContractActor i : Citire) {
            i.setSalariu(i.getSalariu() / E);
            i.setSalariu(Angajat.round(i.getSalariu(),2));
            System.out.println(i.getNume()+ "   " + i.getPrenume() + "   " + i.getTitlu() + "   " + i.getPremii() + "   " + i.getRol() + "   " + i.getStagi()
                    + "   " + i.getSalariu());
        }
    }

    public static void adaugsalariu(){
        int p=20;
        ArrayList<ContractActor> Citire = new ArrayList<>();
        try {
            Citire = Reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ContractActor i : Citire) {
            i.setPremiu(p * i.getKm());
            System.out.println(i.getNume()+ "   " + i.getPrenume() + "   " + i.getTitlu() + "   " + i.getPremii() + "   " + i.getRol() + "   " + i.getStagi() + "   " + i.getKm()
                    + "   " + i.getSalariu() + "   " + i.getPremiu());
        }
    }
// calculeaza premiul dupa nr de km
}
