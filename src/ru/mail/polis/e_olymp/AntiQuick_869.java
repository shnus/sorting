package ru.mail.polis.e_olymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntiQuick_869 {
    public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            while ((line = bi.readLine()) != null) {
                int n = Integer.parseInt(line);
                for (int i = 0; i<n;i++){
                    System.out.print(i+" ");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
