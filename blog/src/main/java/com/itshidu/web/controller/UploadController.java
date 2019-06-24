package com.itshidu.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itshidu.web.vo.Result;

import net.coobird.thumbnailator.Thumbnails;


@Controller
public class UploadController {
	
	@Value("${STORE_ROOT_PATH}")
	String StoreRootPath; //存储根目录

	@ResponseBody
	@RequestMapping("/post/upload")
	public Object upload(int size,MultipartFile file,HttpServletRequest request) {
		System.out.println("文件大小："+file.getSize());
		System.out.println("缩放尺寸："+size);
		System.out.println(StoreRootPath);
		try {
			
			BufferedImage bi = ImageIO.read(file.getInputStream());
			int w=bi.getWidth();
			int h=bi.getHeight();
			int max = (int) Math.max(w, h);
	        int tow = w;
	        int toh = h;
	        if (max > size) {
	            if (w > h) {
	                tow = size;
	                toh = h * size / w;
	            } else {
	                tow = w * size / h;
	                toh = size;
	            }
	        }
	        
	        String filename = "/store/temp/"+UUID.randomUUID().toString()+".jpg";
	        File tempFile = new File(StoreRootPath,filename); //临时文件
	        File parent = tempFile.getParentFile();
	        if(!parent.exists()) {
	        	parent.mkdirs();
	        }
	        Thumbnails.of(file.getInputStream())
		        		.size(tow, toh)
		        		.outputFormat("jpg")
		        		.toFile(tempFile);
	        return Result.of(1, "上传成功",filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Result.of(2, "上传失败");
	}
	
}
