package com.ANNBets.entities;

import javax.persistence.*;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
@Entity
@Table(name = "File_Status")
public class FileStatus {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "File_status")
    private String fileStatus;

    public FileStatus() {}

    public FileStatus(Long id, String fileStatus) {
        this.id = id;
        this.fileStatus = fileStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(String fileStatus) {
        this.fileStatus = fileStatus;
    }
}
