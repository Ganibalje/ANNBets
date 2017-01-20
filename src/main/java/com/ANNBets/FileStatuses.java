package com.ANNBets;

import com.ANNBets.entities.FileStatus;

/**
 * Created by siarhei_beliabniou on 19.1.17.
 */
public class FileStatuses {
    public static final FileStatus uploaded = new FileStatus(1L, "Uploaded");
    public static final FileStatus parsing = new FileStatus(2L, "Parsing...");
    public static final FileStatus error = new FileStatus(3L, "Error");
    public static final FileStatus success = new FileStatus(4L, "Successfully Parsed");
}
