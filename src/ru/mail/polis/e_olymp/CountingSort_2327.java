package ru.mail.polis.e_olymp;


import java.io.*;
import java.util.StringTokenizer;

public class CountingSort_2327 {
    public static void main(String[] args) {

        FastScanner bi = new FastScanner();
        int line;
        StringBuilder stringBuilder = new StringBuilder();

        int[] ii = null;
        line = bi.nextInt();
        int n = line;
        ii = new int[n];
        int j = 0;

        int[] count = new int[100001];
        for (int i = 0; i<n; i++) {
            count[bi.nextInt()]++;
        }

        int pos = 0;
        for (int k = 0; k <= 100000; k++) {
            for (int i = 0; i < count[k]; i++) {
                ii[pos++] = k;
            }
        }

        for (int i : ii) {
            stringBuilder.append(i).append(" ");
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter(new File("output.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        out.print(stringBuilder.toString());

        out.close();
    }

    static class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastScanner() {
            try {
                bufferedReader = new BufferedReader(new FileReader(new File("input.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }


}


