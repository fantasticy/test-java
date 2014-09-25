package test.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CopyFiles {
	public static void main (String[] args) throws Exception {
		CopyFiles copyFiles = new CopyFiles(args);
	
		copyFiles.copy();
	}
	
	private static final String DELIM = ";";
	
	private String[] args = null;
	private List<String> srcFiles = null;
	private String destDir = null;
	
	public CopyFiles(String[] args) {
		this.args = args;	
	}
	
	public boolean prepare() {
		
		if (args == null || args.length < 2) return false;
		
		setSrcFile(args[0]);
		
		setdestDir(args[1]);
		
		return true;
	}
	
	public boolean copy() throws IOException {
		prepare();
		
		File destDir = new File(this.destDir);
		if (!destDir.exists()) {
			System.out.println(destDir + " is not exist.");
			return false;
		}
		
		if (!destDir.isDirectory()) {
			System.out.println(destDir + " is not directory.");
			return false;
		}
		

		BufferedInputStream bis = null;
		FileInputStream fis = null;
		
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		
		for (String fileStr : srcFiles) {
			File srcFile = new File(fileStr);
			File destFile = null;
			if (!srcFile.exists()) {
				System.out.println(fileStr + " is not exist.");
				continue;
			}
			
			if (!srcFile.isFile()) {
				System.out.println(fileStr + " is not file.");
				continue;
			}
			
			System.out.println("filename : " + srcFile.getName());
			
			destFile = new File(this.destDir + File.separator + srcFile.getName());
			
			/*
			if (destFile.exists()) {
				System.out.println(fileStr + " is already exist.");
				continue;
			}
			*/
			
			destFile.createNewFile();
			
			fis = new FileInputStream(srcFile);
			bis = new BufferedInputStream(fis);
		
			fos = new FileOutputStream(destFile);
			bos = new BufferedOutputStream(fos);
			
			int i = 0;
			while((i = bis.read()) != -1) {
				bos.write(i);
			}
			
			bis.close();
			bos.close();
			fis.close();
			fos.close();
			
		}
		
		return true;
	}
	
	private boolean setSrcFile(String arg) {
		if (arg == null) return false;
		
		String[] srcFileArr = arg.split(DELIM);
		
		if (srcFileArr == null || srcFileArr.length == 0) return false;
		
		this.srcFiles = new ArrayList<String>(Arrays.asList(srcFileArr));
	
		return true;
	}
	
	private boolean setdestDir(String arg) {
		if (arg == null) return false;
		
		this.destDir = arg;
		
		return true;
	}
	
	private void printHowToUse() {
		System.out.println("");
	}
}
