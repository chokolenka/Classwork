package com.company;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.*;
import java.util.*;

public class Vocabulary {
    public static void main(String[] args) {
        int count = 'z' - 'a' + 1;
        System.out.println(count);
        List<String> vocabulary = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/com/company/vocabulary.txt"))) {
            String s;
            do {
                s = br.readLine();
                if (s != null) vocabulary.add(s);
            } while (s != null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Size of vocabulary: " + vocabulary.size());
        // отсортировали
        Collections.sort(vocabulary);

        vocabulary.stream().forEach(System.out::println);
        // цикл повторяющийся 10 раз и выводим i элемент
        // вывести первые 10 слов
        for (int i = 0; i < 10; i++)
            System.out.println(vocabulary.get(i));

        // вывести последние 10 слов

        for (int i = vocabulary.size() - 1; i > vocabulary.size() - 11; i--)
            System.out.println(vocabulary.get(i));

        // самое длинное слово

        int max = 0;
        // каждый элемент из словаря
        for (String s : vocabulary)
            if (max < s.length()) {
                max = s.length();
                System.out.println(s);
            }
        System.out.println(max);
        // создали массив по максимальному размеру
        //распределение слов по количеству букв хистограмма hist
        int[] hist = new int[max];
        for (String s : vocabulary)
            hist[s.length() - 1]++;
        // это мы посчитали количество букв (i+1)  в слове затем посчитали количество слов %n перевод на следующую строку
        for (int i = 0; i < max; i++)
            // форматированный вывод
            System.out.printf("%d - %d%n", i + 1, hist[i]);
        // палиндром ; сравниваем с исходной строкой
        for (String s : vocabulary)
            if (s.equals(new StringBuilder(s).reverse().toString()))
                System.out.println(s);

        // Анаграмма
        // мультиколлекция multimap
        // каждую строку преобразовали в массив, из символа отсортировали, получили ключ, добавили в анаграмму ключи s
        Multimap<String, String> anagrams = ArrayListMultimap.create();
        for (String s : vocabulary) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            anagrams.put(key, s);
        }
        String key = "", key2 = "";
        Map.Entry<String, String> entry2 = null;
        for (Map.Entry<String, String> entry : anagrams.entries()) {
            key = entry.getKey();
            if (key.equals(key2))
                System.out.println(entry2.getValue() + " " + entry.getValue());
            key2 = key;
            entry2 = entry;
        }
        //  с тремя одинаковыми буквами
        for (String s : vocabulary) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr); // arr массив из букв
            count = 1;
            char c = ' ';
            for (int i = 0; i < arr.length; i++) {
                char c2 = arr[i];
                if (c == c2) count++;
                else count = 1;
                if (count == 3) {
                    System.out.println(s);
                    break;
                }
                c = c2;
            }
        }

        // найти слово в котором 3 буквы следую по алфавиту
        for (String s : vocabulary) {
            char[] arr = s.toCharArray();
            count = 1;
            char c = ' ';
            for (int i = 0; i < arr.length; i++) {
                char c2 = arr[i];
                if (c2 - c == 1) count++;
                else count = 1;
                if (count == 3) {
                    System.out.println(s);
                    break;
                }
                c = c2;
            }
        }
    }
}
