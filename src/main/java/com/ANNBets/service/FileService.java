package com.ANNBets.service;

import com.ANNBets.entities.File;
import com.ANNBets.entities.FileStatus;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
public interface FileService {
    Long addFile(File file);
    Long updateFile(File file);
    List<File> listFile();
    File getFileById(Long id);
    Long removeFile(File file);
    File getFileByStatus(FileStatus fileStatus);
}
