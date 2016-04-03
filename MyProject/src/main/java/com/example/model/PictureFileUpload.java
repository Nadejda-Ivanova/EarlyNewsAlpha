package com.example.model;

import java.util.List;
//OT VCHERA
import org.springframework.web.multipart.MultipartFile;

public class PictureFileUpload {
	private List<MultipartFile> files;
	 
    public List<MultipartFile> getFiles() {
        return files;
    }
 
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
