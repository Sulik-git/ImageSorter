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
        File newDir = new File("D:\\REPO\\ImgSorter\\test_folder\\newDir");
        String name;
        File[] files;
        boolean isDirCreated = newDir.mkdir();

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
                    images.add(new Image(file,ys,ms)); //Adding new image to imageslist
                    //System.out.println(ys);
                    //System.out.println(ms);
                }

            }

            for (Image i : images){
              String path = i.getPath().getPath();
              StringBuilder sb = new StringBuilder();
              sb.append(path);
              sb.append("\\");
              sb.append(i.getYear());
              boolean newDirectory = false;

              for (File l : lista){
                  if(l.getName().equals(sb.toString())){
                      newDirectory = true;
                  }else{
                      newDirectory = false;
                  }
              }
              if(!newDirectory){
                  newDirectory = new File(sb.toString()).mkdir();
              } else {
                  System.out.println(sb);
                  System.out.println("Directory already exists");
              }

            }



    }
}
