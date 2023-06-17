package com.jacobsulikowski;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageSorter {



    //TODO: Zrobione wczytywanie nazwy, zrobione oddzielny String dla roku i miesiąca.

    public static void main(String[] args){
        List<File> lista = new ArrayList<File>();
        File file = new File("D:\\REPO\\Img_Sorter\\test_folder");
        String name;

        File[] files= file.listFiles();



            lista.addAll(Arrays.asList(files));

            for (File f : lista
                 ) {
                List<Character> listC = new ArrayList<>();
                List<Character> listYear;
                List<Character> listMonth;
                name = f.getName();
                char[] ch = name.toCharArray();
                for (char c : ch){
                    if(Character.isDigit(c)){
                        listC.add(c);
                    }
                }

                listC.subList(8,14).clear();


                listYear = listC.subList(0,4);
                listMonth = listC.subList(4,6);

                StringBuilder sb = new StringBuilder();
                for (Character c : listYear) {
                    sb.append(c);
                }

                String ys = sb.toString();
                sb.delete(0,sb.length());

                for (Character c : listMonth) {
                    sb.append(c);
                }
                String ms = sb.toString();


                ArrayList<Character> arrayList = new ArrayList<Character>();

                System.out.println(ms);
            }


    }
}
