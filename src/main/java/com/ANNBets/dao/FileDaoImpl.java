package com.ANNBets.dao;

import com.ANNBets.entities.File;
import com.ANNBets.entities.FileStatus;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Repository
public class FileDaoImpl implements FileDao{

    private SessionFactory sessionFactory;

    public FileDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long addFile(File file) {
        return (Long)sessionFactory.getCurrentSession().save(file);
    }

    @Override
    public Long updateFile(File file) {
        sessionFactory.getCurrentSession().update(file);
        return file.getId();
    }

    @Override
    public List<File> listFile() {
        return sessionFactory.getCurrentSession().createQuery("from File").list();
    }

    @Override
    public File getFileById(Long id) {
        return sessionFactory.getCurrentSession().get(File.class, id);
    }

    @Override
    public Long removeFile(File file) {
        sessionFactory.getCurrentSession().delete(file);
        return file.getId();
    }

    @Override
    public File getFileByStatus(FileStatus fileStatus) {
        List files = sessionFactory.getCurrentSession().createQuery("from File where fileStatus=:fileStatus")
                .setParameter("fileStatus", fileStatus).list();
        return files.size() == 0 ? null : (File)files.get(0);
    }

}
