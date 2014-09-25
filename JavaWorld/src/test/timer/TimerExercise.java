package test.timer;

import java.util.*;
import java.io.*;

public class TimerExercise {
	public static void main(String[] args) {
		final String lookupPath = "C:/programe files/altools"; 	// 모니터링 대상 경로
		final String lookupPath2 = "D:/fileTestDir";				// 모니터링 대상 경로	
		
		final String resultSavePath = "C:/result.txt"; 			// 저장파일 경로

		Timer timer = new Timer("Directory Size Check");
		
		timer.schedule(new TimerTask() {
			
			private long totalSize = 0L;

			/**
			 * 재귀호출 방식을 이용해 디렉토리를 순회하여 모든 파일의 크기를 얻는다.
			 */
			private void traverse(File file) {
				if (file == null || !file.exists()) {
					return;
				}

				if (file.isDirectory()) {
					String[] child = file.list();
					if (child != null) {
						for (int i = 0; i < child.length; i++) {
							traverse(new File(file, child[i]));
						}
					}
				} else {
					totalSize += (long) file.length();
				}
			}

			/** 
			 * 파일에 디렉토리 크기를 저장한다. 
			 */
			private void writeFile(String data) throws IOException {
				BufferedWriter writer = null;
				try {
					writer = new BufferedWriter(new FileWriter(resultSavePath));
					writer.write(data);
				} finally {
					if (writer != null)
						try {
							writer.close();
						} catch (Exception e) {
						}
				}
			}

			/**
			 * Timer 에 의해 주기적으로 실행된다.
			 */
			public void run() {
				System.out.println("size checking started!");
				File file = new File(lookupPath);

				// 모니터링 대상 경로의 모든 하위 파일의 크기를 구한다.
				totalSize = 0L;
				traverse(file);

				// 파일에 디렉토리 크기를 저장한다.
				try {
					writeFile("Directory Size : " + totalSize + "byte");
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}, 1000 * 60, 1000 * 60);
	}
}
