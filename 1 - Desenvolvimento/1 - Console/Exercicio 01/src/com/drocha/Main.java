package com.drocha;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        PublicFuns publicFuns = new PublicFuns();

        publicFuns.StartStuff();

        publicFuns.WriteStuff(publicFuns.SelectMode(Integer.parseInt(scan.nextLine())));
    }
}
