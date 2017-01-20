package com.ANNBets.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Entity
@Table
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "File_name")
    private String fileName;

    @Column(name = "File_data")
    private byte[] fileData;

    @Column(name = "Upload_date")
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "File_status_id")
    private FileStatus fileStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public FileStatus getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(FileStatus fileStatus) {
        this.fileStatus = fileStatus;
    }
}
