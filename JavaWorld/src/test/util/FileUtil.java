package test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	//private static Logger log;

	public FileUtil() {
		//log = Logger.getLogger(FileUtil.class);
	}
	
	public static boolean makeDir(String path) {
		File dir = new File(path);
	
		if (!(dir.exists())) {
			try {
				boolean result = dir.mkdirs();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
	
	
	public static boolean writeFileFromFile(File srcFile, String savePath, String saveFileName) {
		if ((srcFile == null) || (srcFile.length() <= 0L)) return false;
		makeDir(savePath);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		boolean result = false;
		
		try {
			int offset = 0;
			byte[] buf = new byte[1024];

			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(savePath + File.separator + saveFileName);

			while ((offset = fis.read(buf)) != -1)
			fos.write(buf, 0, offset);
			result = true;
		} catch (IOException ioe) {
			//log.error("Raised exception while write file - " + ioe.getMessage());
			result = false;
		} finally {
			if (fos != null) try { fos.close(); } catch (Exception localException2) { }
			if (fis != null) try { fis.close(); } catch (Exception localException3) { }
		}
		return result;
	}

	public static boolean exists(String path, String fileName) {
		return exists(addSeparator(path) + fileName);
	}

	public static boolean exists(String path) {
		File file = new File(addSeparator(path));
		return file.exists();
	}

	public static String addSeparator(String path) {
		if ((path != null) && (!(path.equals(""))) && (path.lastIndexOf(File.separator) != path.length() - 1)) path = path + File.separator;

		return path;
	}

	public static String getUniqueFilename(String path, String fileName) {
		String tempName = fileName;
		int delim = fileName.lastIndexOf(46);

		String name = fileName.substring(0, delim);
		String ext = fileName.substring(delim);
		if (!(exists(addSeparator(path), tempName))) return tempName;
			for (int j = 1; j < 10000; ++j) {
				if (j < 10) tempName = name + "_000" + j + ext;
				else if (j < 100) tempName = name + "_00" + j + ext;
				else if (j < 1000) tempName = name + "_0" + j + ext;
				else tempName = name + "_" + j + ext;

				if (!(exists(addSeparator(path), tempName)))
					break;
			}
		return tempName;
	}
	
	public static String getUniqueDirName() {
		return String.valueOf(System.currentTimeMillis());
	}

	public static boolean delete(File file) {
		if (file.exists()) return file.delete();
			return false;
	}

	public static boolean delDir(File file) {
		if (!(file.exists())) return false;

		File[] files = file.listFiles();
			
		for (int i = 0; i < files.length; ++i) {
			if (files[i].isDirectory()) delDir(files[i]);
			else files[i].delete();
		}
	
		return file.delete();
	}
	
	public static String getFileExtension(String fileName) {
		if ((StringUtil.isEmpty(fileName)) || (fileName.indexOf(".") < 0)) return null;
		int dotLastIndex = fileName.lastIndexOf(".");
		String ext = fileName.substring(dotLastIndex + 1);
		return ext;
	}
	

	

}
