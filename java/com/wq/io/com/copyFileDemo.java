package com.wq.io.com;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class copyFileDemo {
	/**
	 * 文件复制
	 * @throws Exception 
	 *//*
	public static void main(String[] args) throws Exception  {
		String filePath = "E:/wqw.txt";
		String newFilePath = "E:/wqq.txt";
		copyFile(filePath,newFilePath);
	}*/
	
	public static void copyFile(File files, File file) throws Exception{
		   //读取一个文件
				FileInputStream fis = new FileInputStream(files);
				//缓冲流
				BufferedInputStream bis = new BufferedInputStream(fis);
				//写出文件
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				int d = -1;
				while((d=bis.read())!=-1){
					bos.write(d);
				}
				System.out.println("复制完成！");
				bos.close();
				bis.close();
	}
	
	
	public static void main(String[] args) throws Exception {
		 String dirPath="E:/这是一个测试文件夹"; 
		 String newDirPath="E:/这是一个测试文件夹的副本";
		 copyDir(dirPath,newDirPath);
	}
	public static void copyDir(String dirPath, String newDirPath) throws Exception{
		File resourceFile = new File(dirPath);
		if(!resourceFile.exists()){
			throw new Exception("目标文件不存在");
		}
		File targetFile = new File(newDirPath);
		if(!targetFile.exists()){
			throw new Exception("存放的路径不存在");
		}
		//目标文件下的所有文件
		File[] resourceFiles = resourceFile.listFiles();
		for (File file : resourceFiles) {
			File file1 = new File(targetFile.getAbsolutePath() + File.separator +resourceFile.getName());
			//复制文件
			if (file.isFile()) {
				System.out.println("文件:"+file.getName());
				if (! file1.exists()) {
					file1.mkdirs();
					
				}
				File tergetFile1 = new File(file1.getAbsolutePath() +File.separator + file.getName());
				copyFile(file, tergetFile1);
			}
			//复制文件夹
			if(file.isDirectory()){
				String dir1 = file1.getAbsolutePath();
				//目的文件夹
				String dir2 = file1.getAbsolutePath();
				copyDir(dir1, dir2);
			}
		}
 	}
}

