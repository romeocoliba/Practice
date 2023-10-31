package com.company;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner Nr = new Scanner(System.in);
        System.out.println();
        int ch;
        do {
            System.out.println();
            System.out.println();
            System.out.println("0 - Iesire din program");
            System.out.println("1 - Date angajati");
            System.out.println("2 - Date angajati cu salariu in euro");
            System.out.println("3 - Date actori");
            System.out.println("4 - Date actori cu salariu in euro");
            System.out.println("5 - Date actori cu premiile calculate");
            System.out.println("6 - Date spectacol");
            System.out.println();
            System.out.print("Introduceti ce alegere doriti sa faceti :>");
            ch = Nr.nextInt();
            switch (ch) {
                case 1 -> { Angajat.Citire(); Angajat.Afisare(); }
                case 2 -> { Angajat.Citire(); Angajat.getEuro(); }
                case 3 -> { ContractActor.Reader(); ContractActor.Afisare(); }
                case 4 -> { ContractActor.Reader(); ContractActor.getEuro(); }
                case 5 -> { ContractActor.adaugsalariu(); }
                case 6 -> { Spectacol.Cit(); Spectacol.Afisare(); }
            }
        }
        while (ch != 0);



    }
}
