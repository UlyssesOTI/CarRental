package com.ulyssess.carrental.file;

import org.springframework.web.multipart.MultipartFile;

public class FileClass {
		 
		MultipartFile file;
		
		public MultipartFile getFile() {
			return file;
		}

		public void setFile(MultipartFile file) {
			this.file = file;
		}		
}