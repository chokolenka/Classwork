package BettyBotter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

public class bettybotter {
    public static void main(String[] args) {
        SortedSet<String> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com.company/bettybotter.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null) {
                    sb.append(s);
                    sb.append(System.lineSeparator());

                }}
            while (s != null) ;

        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        //System.out.println(sb);
        // преобразуем в строку
        String content = sb.toString();
        content = content.replaceAll ("[^A-Za-z]", " ");
        //System.out.println(content);
        // помещаем все слова в массив строк
        String [] words = content.split(" ");
        //System.out.println(Arrays.toString(words));
        // для каждого слова входящего в массив выполнить действия
        for (String word:words) {
            if ((word.length()!=0)&&((word.charAt(0)=='b')||(word.charAt(0)=='B')))
                treeSet.add(word);
        }
        System.out.println(treeSet.toString());
    }
}

