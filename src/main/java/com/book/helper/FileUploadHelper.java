package com.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

//	public final String UPLOAD_DIR = "E:\\Study\\LearnCodeWithDurgeshTiwari\\"
//			+ "Durgesh_WorkSpace\\BootBookProject_CRUD\\src\\main\\resources\\static\\image";
	
	public final String UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException {
		
	}
	public boolean uploadFile(MultipartFile file) {
		boolean f = false;
		try {
//			InputStream inputStream = file.getInputStream();
//			byte data[] = new byte[inputStream.available()];
//			inputStream.read(data);
//
//			// write file at given location
//			FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR + "\\" + file.getOriginalFilename());
//			fileOutputStream.write(data);
//			fileOutputStream.flush();
//			fileOutputStream.close();

			// Alternate way
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
