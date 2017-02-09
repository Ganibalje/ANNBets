package com.ANNBets.sheludes;

import com.ANNBets.FileStatuses;
import com.ANNBets.entities.File;
import com.ANNBets.parser.Parser;
import com.ANNBets.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by siarhei_beliabniou on 27.1.17.
 */
@Component
public class FileParseShelude {

    @Autowired
    private FileService fileService;

    @Scheduled(fixedRate = 300000)
    public void findFileToParse(){
        File fileByStatus = fileService.getFileByStatus(FileStatuses.uploaded);
        if(fileByStatus != null)
            Parser.doParsing(fileByStatus);
    }

}
