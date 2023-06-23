package com.sjacob;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifDirectoryBase;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    //TODO: Test app
    public static void main(String[] args) throws JpegProcessingException {
        File file = new File("src/main/resources/IMG_20221016_101316.jpg");
        Class<ExifDirectoryBase> type;
        try {
            Metadata metadata = JpegMetadataReader.readMetadata(file);
            for(Directory d : metadata.getDirectoriesOfType())
            {
                for(Tag tag : d.getTags())
                {
                    System.out.println(tag);
                }
                //System.out.println(d.getDate(5));
            }

        } catch (ImageProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
