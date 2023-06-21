package com.jacobsulikowski;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.jacobsulikowski.Image;

public class ImageSorter {



    //TODO: Zrobione wczytywanie nazwy, zrobione oddzielny String dla roku i miesiąca.

    public static void main(String[] args){
        List<File> lista = new ArrayList<File>();
        List<Image> images = new ArrayList<Image>();
        File file = new File("D:\\REPO\\ImgSorter\\test_folder");
        String name;
        File[] files;

        if(file.listFiles() == null){
            System.out.println("No files found");
        }
        else {
            files = file.listFiles();
            lista.addAll(Arrays.asList(files));
        }

            for (File f : lista) {
                name = f.getName();
                //System.out.println(name);
                char[] ch = name.toCharArray();
                if(name.contains("IMG"))
                {
                    List<Character> listC = new ArrayList<>();
                    List<Character> listYear;
                    List<Character> listMonth;
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
                    images.add(new Image(file,f,ys,ms)); //Adding new image to imageslist
                    //System.out.println(ys);
                    //System.out.println(ms);
                }

            }

            for (Image i : images){
              String path = i.getOriginFile().getPath();
              StringBuilder sb = new StringBuilder();
              sb.append(path);
              sb.append("\\");
              sb.append(i.getYear());
              boolean newDirectory = false;
              boolean newDirMonth = false;
              if(!lista.contains(new File(sb.toString())))
              {
                  //System.out.println(sb);
                  newDirectory = new File(sb.toString()).mkdir();
                  lista.add(new File(sb.toString()));
              }
              sb.append("\\");
              sb.append(i.getMonth());
              if(lista.contains(new File(sb.toString())))
              {
                  //System.out.println("Month already exists");
              } else {
                  newDirMonth = new File(sb.toString()).mkdir();
                  lista.add(new File(sb.toString()));

              }
              File newName = new File(i.getFilePath().getPath());

              sb.append("\\");
              System.out.println();
              /*
              sb.append(i.getYear());
              sb.append('_');
              sb.append(i.getMonth());
              sb.append(".jpg");

               */
              System.out.println(sb);
              newName.renameTo(new File(sb.toString()));
              System.out.println(i.getFilePath());



            }



    }
}
