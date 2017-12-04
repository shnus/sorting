package ru.mail.polis.e_olymp;


import java.io.*;

public class CountingSort_2327 {
    public static void main(String[] args) {

        BufferedReader bi = null;
        try {
            bi = new BufferedReader(new FileReader(new File("input.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;

        int[] ii = null;
        try {
            while ((line = bi.readLine()) != null) {
                int n = Integer.valueOf(line);
                String[] ss = bi.readLine().split(" ");
                ii = new int[n];
                int j = 0;

                int[] count = new int[100001];
                for (String s: ss){
                    int i = Integer.parseInt(s);
                    count[i]++;
                }

                int pos = 0;
                for (int k = 0; k <= 100000; k++) {
                    for (int i = 0; i < count[k]; i++) {
                        ii[pos++] = k;
                    }
                }

                for(Integer i: ii){
                    System.out.print(i+" ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Integer i: ii){
            out.print(i+" ");
        }

        out.close();
    }


}


