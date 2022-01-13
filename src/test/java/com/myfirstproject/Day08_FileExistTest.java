package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest  {
    @Test
    public void isExist(){
       String homePath =  System.getProperty("user.home"); // root path until Desktop  - Downloads
        System.out.println("homePath = "+ homePath); ///Users/melekberahmed

        // I stored file on Desktop
        // /Users/admin/Desktop/download.png


        String pathOfImage = homePath + "/Desktop/download.png";
        System.out.println("pathOfImage = " + pathOfImage);

        // Verify if the file exist or not with Java

        boolean isExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);
    }
}
