package com.ANNBets.service;

import com.ANNBets.dao.FileDao;
import com.ANNBets.entities.File;
import com.ANNBets.entities.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileDao fileDao;

    @Override
    @Transactional
    public Long addFile(File file) {
        return fileDao.addFile(file);
    }

    @Override
    @Transactional
    public Long updateFile(File file) {
        return fileDao.updateFile(file);
    }

    @Override
    @Transactional
    public List<File> listFile() {
        return fileDao.listFile();
    }

    @Override
    @Transactional
    public File getFileById(Long id) {
        return fileDao.getFileById(id);
    }

    @Override
    @Transactional
    public Long removeFile(File file) {
        return fileDao.removeFile(file);
    }

    @Override
    @Transactional
    public File getFileByStatus(FileStatus fileStatus) {
        return fileDao.getFileByStatus(fileStatus);
    }
}
