package com.app.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Component
public class StorageSeviceImpl implements StorageService {

    private final FileUploadProperties fileUploadProperties;
    private String BASEPATH;

    @Autowired
    public StorageSeviceImpl(FileUploadProperties fileUploadProperties) {
        this.fileUploadProperties = fileUploadProperties;
    }

    @PostConstruct
    public void init() {
        if (fileUploadProperties == null || fileUploadProperties.getLocation() == null) {
            throw new IllegalStateException("FileUploadProperties bean or location property is not properly configured.");
        }

        this.BASEPATH = Paths.get(fileUploadProperties.getLocation()).toAbsolutePath().normalize().toString();
        try {
            File file = new File(BASEPATH);
            System.err.println(BASEPATH);
            if (file.mkdirs()) {
                System.out.println("Directory Created");
            }
        } catch (Exception ex) {
            System.err.println("Could not Create upload dir! " + ex.getMessage());
        }
    }


    @Override
    public List<String> loadAll() {
        File dirPath = new File(BASEPATH);
        return Arrays.asList(dirPath.list());
    }

    @Override
    public String store(MultipartFile file) {
        System.out.println(file.getOriginalFilename());

        // File extension
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(ext);

        // Random name generated and extension attached as seller may upload photo with same name
        String fileName = UUID.randomUUID().toString().replaceAll("-", "") + ext;

        // Basepath and new file name saved
        File filePath = new File(BASEPATH, fileName);

        // Output stream is for writing data to a file
        try (FileOutputStream out = new FileOutputStream(filePath)) {

            // getInputStream() returns an input stream for reading bytes of file and
            // then it is copied to out
            FileCopyUtils.copy(file.getInputStream(), out);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Resource load(String fileName) {
        File filePath = new File(BASEPATH, fileName);
        if (filePath.exists())
            return new FileSystemResource(filePath);
        return null;
    }

    @Override
    public void delete(String fileName) {
        File filePath = new File(BASEPATH, fileName);
        if (filePath.exists())
            filePath.delete();
    }
}
