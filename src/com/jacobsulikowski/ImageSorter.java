package com.jacobsulikowski;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImageSorter {
    private static List<File> lista = new ArrayList<File>();
    private static List<Image> images = new ArrayList<Image>();
    private static File workingDirFile = new File(System.getProperty("user.dir"));
    private String name;
    private int counter = 0;

    public ImageSorter(){

    }

    public void setImages(){
        lista.addAll(Arrays.asList(workingDirFile.listFiles()));

        for (File f : lista) {
            name = f.getName();
            //System.out.println(name);
            char[] ch = name.toCharArray();
            if (name.contains("IMG")) {
                counter++;
                List<Character> listC = new ArrayList<>();
                List<Character> listYear;
                List<Character> listMonth;
                for (char c : ch) {
                    if (Character.isDigit(c)) {
                        listC.add(c);
                    }
                }

                listC.subList(8, 14).clear();
                listYear = listC.subList(0, 4);
                listMonth = listC.subList(4, 6);


                StringBuilder sb = new StringBuilder();
                for (Character c : listYear) {
                    sb.append(c);
                }

                String ys = sb.toString();
                sb.delete(0, sb.length());

                for (Character c : listMonth) {
                    sb.append(c);
                }
                String ms = sb.toString();


                ArrayList<Character> arrayList = new ArrayList<Character>();
                images.add(new Image(workingDirFile, f, name, ys, ms)); //Adding new image to imageslist
                //System.out.println(ys);
                //System.out.println(ms);
            }
        }
        if(!areImagesFound()){
            System.out.println("No images found");
        }
    }

    public void createDirs(){
        for (Image i : images){
            String path = i.getOriginFile().getPath();
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append("\\");
            sb.append(i.getYear());
            if(!lista.contains(new File(sb.toString())))
            {
                //System.out.println(sb);
                new File(sb.toString()).mkdir();
                lista.add(new File(sb.toString()));
            }
            sb.append("\\");
            sb.append(i.getMonth());
            if(lista.contains(new File(sb.toString())))
            {
                //System.out.println("Month already exists");
            } else {
                new File(sb.toString()).mkdir();
                lista.add(new File(sb.toString()));

            }
            File newName = new File(i.getFilePath().getPath());

            sb.append("\\");
            sb.append(i.getImageName());


            //System.out.println(sb);
            newName.renameTo(new File(sb.toString()));
            //System.out.println(i.getFilePath());
        }
    }



    boolean areImagesFound(){
        if(counter == 0){
            return false;
        } else {
            return true;
        }
    }


    //TODO: Test app

    public static void main(String[] args){
        ImageSorter sorter = new ImageSorter();
        sorter.setImages();
        sorter.createDirs();

    }
}
