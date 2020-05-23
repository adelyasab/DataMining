import javafx.util.Pair;

import java.io.*;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws IOException {
        Vector<Pair<String, Long>> products;
        int NUM = 20;
        products = new Vector<>();
        boolean flag = false;
        BufferedReader bf = new BufferedReader(new FileReader("transactions.csv"));
        String str;
        while ((str = bf.readLine()) != null){

            String[] line = str.split(";");
            if (flag) {
                products.add(new Pair<>(line[0], Long.parseLong(line[1])));
            }
            flag = true;
        }

        Collections.sort(products, new Comparator<Pair<String, Long>>() {
            @Override
            public int compare(Pair<String, Long> o1, Pair<String, Long> o2) {
                if (o1.getValue() > o2.getValue())
                    return -1;
                else {
                    if (o1.getValue() == o2.getValue()) {
                        return 0;
                    }
                }
                return 1;
            }
            } );

            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            for (int i = 0; i < NUM; i++) {

                bw.write(products.get(i).getKey() + ";");
                bw.write(products.get(i).getValue() + "\n");
            }
            bw.flush();
            bf.close();
    }
}
