package org.khmeracademy.auction.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.khmeracademy.auction.entities.UploadedFileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
	
	/***
	 * Upload to default location
	 */
	public UploadedFileInfo upload(List<MultipartFile> files, String folder);
	
	public UploadedFileInfo upload(MultipartFile file, String folder);
	
	public UploadedFileInfo upload(List<MultipartFile> files, String folder, HttpServletRequest request);
	
}
