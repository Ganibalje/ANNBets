package com.ANNBets.controllers;

import com.ANNBets.FileStatuses;
import com.ANNBets.entities.File;
import com.ANNBets.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Controller
public class UploadController {
    @Autowired
    private FileService fileService;

    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    public void uplaod(){
        File file = new File();

        String filePath = "/home/siarhei_beliabniou/T1.csv";
        byte[] bFile = null;
        try {
            bFile = Files.readAllBytes(new java.io.File(filePath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.setFileData(bFile);
        file.setFileName("lol");
        file.setFileStatus(FileStatuses.uploaded);
        file.setUploadDate(new Date());

        fileService.addFile(file);

    }
}
