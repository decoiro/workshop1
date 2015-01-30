package biz.netcentric.apushop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Caixeiro caixeiro = new Caixeiro();
        try {
            while((input=bufferedReader.readLine()) != null){
                System.out.print(input + " -> ");
                System.out.println(caixeiro.ponmeOutra(input));
            }
        } catch (IOException e) {
            System.out.println("Error!!!");
        }
    }
}
