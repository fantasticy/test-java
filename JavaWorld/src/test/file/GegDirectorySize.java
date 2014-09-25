/*package test.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GegDirectorySize {

	public static void main(String[] args) {

		long fileVolume = 0;

		List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
		List<Map<String, Long>> usedPublicDataVolList;

		StringBuffer attachPathBuffer = new StringBuffer();
		attachPathBuffer.append(System.getenv("USERPROFILE")).append("/go/attach");
		String attachPath = attachPathBuffer.toString();

		File attachDir = new File(attachPath); 			// attach Directory
		File[] dirsCompany = attachDir.listFiles(); 			// company Directory
		
		if (dirsCompany.length > 0) {

			for (int i = 0; i < dirsCompany.length; i++) {

				String companyId = dirsCompany[i].getName();
				CompanyModel companyModel = new CompanyModel();
				companyModel.setCompanyId(companyId);
				companyModelList.add(companyModel);
			}

			for (int i = 0; i < dirsCompany.length; i++) { 		// 각 회사 폴더에 진입

				fileVolume = 0;

				File[] dirs2 = dirsCompany[i].listFiles();

				for (int j = 0; j < dirs2.length; j++) { 				// post, user, chat ..

					File[] dirs3 = dirs2[j].listFiles();
					
					System.out.println(dirs3.length);

					for (int x = 0; x < dirs3.length; x++) { 		// 20141, 20142,

						File[] files = dirs3[x].listFiles();		 		// Real Files ...

						if (files.length > 0) { 							// 파일이 있을경우에만 용량 계산함.

							for (int y = 0; y < files.length; y++) {

								System.out.println();
								System.out.println(" ------------------------------ ");

								fileVolume += files[y].length();

								System.out.println(" 파일크기 \t" + files[y].length());
								System.out.println(" 총 용량 " + fileVolume);
								System.out.println(" ------------------------------ ");
								System.out.println();
							}

						} else { 
						
							System.out.println(" 파일 없음 ");
							
						 파일이 없으면 읽지 않습니다.  }
					}
				}
				companyModelList.get(i).setUsedPublicDataVolume(fileVolume);
			}

		} else { Company Directory 가 없으면 아무 action 도 일어나지 않습니다.  }
//		
//		for(int k = 0 ; k < companyModelList.size() ; k++){
//			
//			System.out.println();
//			System.out.println(companyModelList.get(k).getCompanyId());
//			System.out.println(companyModelList.get(k).getUsedPublicDataVolume());
//			System.out.println();
//			
//		}
	}
}




public class DirectorySize {
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {

		long fileVolume = 0;

		List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
		List<Map<String, Long>> usedPublicDataVolList;

		StringBuffer attachPathBuffer = new StringBuffer();
		attachPathBuffer.append(System.getenv("USERPROFILE")).append("/go/attach");
		String attachPath = attachPathBuffer.toString();

		File attachDir = new File(attachPath); 			// attach Directory
		File[] dirsCompany = attachDir.listFiles(); 			// company Directory
		
		if (dirsCompany.length > 0){
			
			
			
		}

		for (int i = 0; i < dirsCompany.length; i++) {
			String companyId = dirsCompany[i].getName();
			CompanyModel companyModel = new CompanyModel();
			companyModel.setCompanyId(companyId);
			companyModelList.add(companyModel);
		}

		if (dirsCompany.length >= 1) {

			for (int i = 0; i < dirsCompany.length; i++) { 			// 각 회사 폴더에 진입
				
				fileVolume = 0;
				
				File[] dirs2 = dirsCompany[i].listFiles();

				for (int j = 0; j < dirs2.length; j++) { 		// post, user, chat .. 폴더 진입

					File[] dirs3 = dirs2[j].listFiles();

					for (int x = 0; x < dirs3.length; x++) { // 20141, 20142, 20143 ...

						File[] files = dirs3[x].listFiles(); 		// Real Files ...

						if (files.length > 0) { 					// 파일이 있을경우에만 용량 계산함.

							for (int y = 0; y < files.length; y++) {

								System.out.println();
								System.out.println(" ------------------------------ ");

								fileVolume += files[y].length();

								System.out.println(" 파일크기 \t" + files[y].length());
								System.out.println(" 총 용량 " + fileVolume);
								System.out.println(" ------------------------------ ");
								System.out.println();

							} 

						} else {  Not Act  }

					}

				}

				companyModelList.get(i).setUsedPublicDataVolume(fileVolume);
			} // End dirs1

		} else {  }
//		
//		for(int k = 0 ; k < companyModelList.size() ; k++){
//			
//			System.out.println();
//			System.out.println(companyModelList.get(k).getCompanyId());
//			System.out.println(companyModelList.get(k).getUsedPublicDataVolume());
//			System.out.println();
//			
//		}
	}
}





 * public class DirectorySize {
 * 
 * @SuppressWarnings({ "unused", "null" }) public static void main(String[]
 * args) {
 * 
 * long usedPublicDataVolume = 0; long dir2014TotalVolume = 0; long
 * dir2014sVolume = 0; long dirPostTotalVolume = 0; long dirPostsVolume = 0;
 * long dirFileVolume = 0;
 * 
 * List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
 * List<Map<String, Long>> usedPublicDataVolList;
 * 
 * StringBuffer attachPathBuffer = new StringBuffer();
 * attachPathBuffer.append(System.getenv("USERPROFILE")).append("/go/attach");
 * String attachPath = attachPathBuffer.toString();
 * 
 * File dir = new File(attachPath); // attach File[] dirs1 = dir.listFiles(); //
 * company_id
 * 
 * for (int i = 0 ; i < dirs1.length ; i++){ String companyId =
 * dirs1[i].getName(); CompanyModel companyModel = new CompanyModel();
 * companyModel.setCompanyId(companyId); companyModelList.add(companyModel); }
 * 
 * if (dirs1.length >= 1){
 * 
 * for (int i = 0 ; i < dirs1.length; i++){ // 각 회사 폴더에 진입
 * 
 * if ( i >=1 ) { CompanyModel model = companyModelList.get(i-1);
 * companyModelList.get(i-1).setUsedPublicDataVolume(usedPublicDataVolume); }
 * 
 * usedPublicDataVolume = 0;
 * 
 * File[] dirs2 = dirs1[i].listFiles();
 * 
 * for (int j = 0 ; j < dirs2.length ; j++){ // post, user, chat ..
 * 
 * dir2014sVolume = 0;
 * 
 * File[] dirs3 = dirs2[j].listFiles();
 * 
 * for (int x = 0 ; x < dirs3.length ; x++){ // 20141, 20142, 20143 ...
 * 
 * dirFileVolume = 0;
 * 
 * File[] files = dirs3[x].listFiles(); // Real Files ...
 * 
 * if (files.length > 0){ // 파일이 있을경우에만 용량 계산함.
 * 
 * for (int y = 0 ; y < files.length ; y++){
 * 
 * System.out.println(); System.out.println(" ------------------------------ ");
 * 
 * dirFileVolume += files[y].length();
 * 
 * System.out.println(" 파일크기 \t" + files[y].length());
 * System.out.println(" 총 용량 " + dirFileVolume);
 * System.out.println(" ------------------------------ "); System.out.println();
 * 
 * } // End dirs4
 * 
 * dir2014sVolume += dirFileVolume;
 * 
 * } else { Not Act }
 * 
 * System.out.println(" 2014 폴더 " + x + " 개 계산 마쳤음 ");
 * System.out.println(" dir2014Volume \t" + dir2014sVolume );
 * 
 * }
 * 
 * dirPostsVolume += dir2014sVolume;
 * 
 * System.out.println(); System.out.println(" post 폴더 " + j + " 개 계산 마쳤음 ");
 * System.out.println(" dirPostVolume \t" + dirPostsVolume );
 * 
 * }
 * 
 * dirPostsVolume;
 * 
 * } // End dirs1
 * 
 * 
 * 
 * } else {
 * 
 * }
 * 
 * } }
 


 * package test.file;
 * 
 * import java.io.File; import java.util.ArrayList; import java.util.List;
 * import java.util.Map;
 * 
 * public class DirectorySize {
 * 
 * @SuppressWarnings({ "unused", "null" }) public static void main(String[]
 * args) {
 * 
 * long usedPublicDataVolume = 0; long dir2014TotalVolume = 0; long
 * dir2014sVolume = 0; long dirPostTotalVolume = 0; long dirPostVolume = 0; long
 * dirFileVolume = 0;
 * 
 * List<CompanyModel> companyModelList = new ArrayList<CompanyModel>();
 * List<Map<String, Long>> usedPublicDataVolList;
 * 
 * StringBuffer attachPathBuffer = new StringBuffer();
 * attachPathBuffer.append(System.getenv("USERPROFILE")).append("/go/attach");
 * String attachPath = attachPathBuffer.toString();
 * 
 * File dir = new File(attachPath); // attach File[] dirs1 = dir.listFiles(); //
 * company_id
 * 
 * for (int i = 0 ; i < dirs1.length ; i++){ String companyId =
 * dirs1[i].getName(); CompanyModel companyModel = new CompanyModel();
 * companyModel.setCompanyId(companyId); companyModelList.add(companyModel); }
 * 
 * if (dirs1.length >= 1){
 * 
 * for (int i = 0 ; i < dirs1.length; i++){ // 각 회사 폴더에 진입
 * 
 * System.out.println(); System.out.println(" ============================== ");
 * System.out.println(); System.out.println(" 회사폴더 " + i + " 진입 ");
 * 
 * if ( i >=1 ) {
 * 
 * System.out.println(" 한바퀴 돌고 들어옴 ");
 * 
 * CompanyModel model = companyModelList.get(i-1);
 * companyModelList.get(i-1).setUsedPublicDataVolume(usedPublicDataVolume); }
 * usedPublicDataVolume = 0;
 * 
 * File[] dirs2 = dirs1[i].listFiles();
 * 
 * for (int j = 0 ; j < dirs2.length ; j++){ // post, user, chat ..
 * 
 * dir2014sVolume = 0;
 * 
 * System.out.println(); System.out.println(" ============================== ");
 * System.out.println(); System.out.println(" post 폴더 " + j + " 진입 ");
 * 
 * File[] dirs3 = dirs2[j].listFiles();
 * 
 * for (int x = 0 ; x < dirs3.length ; x++){ // 20141, 20142, 20143 ...
 * 
 * dirFileVolume = 0;
 * 
 * System.out.println(); System.out.println(" 2014 폴더 " + x + "진입");
 * 
 * File[] files = dirs3[x].listFiles(); // Real Files ...
 * 
 * if (files.length > 0){ // 파일이 있을경우에만 용량 계산함.
 * 
 * for (int y = 0 ; y < files.length ; y++){
 * 
 * System.out.println(); System.out.println(" ------------------------------ ");
 * 
 * dirFileVolume += files[y].length();
 * 
 * System.out.println(" 파일크기 \t" + files[y].length());
 * System.out.println(" 총 용량 " + dirFileVolume);
 * System.out.println(" ------------------------------ "); System.out.println();
 * 
 * } // End dirs4
 * 
 * dir2014sVolume += dirFileVolume;
 * 
 * 
 * } else { Not Act }
 * 
 * System.out.println(" 2014 폴더 " + x + " 개 계산 마쳤음 ");
 * System.out.println(" dir2014Volume \t" + dir2014sVolume );
 * 
 * }
 * 
 * dirPostVolume += dir2014sVolume;
 * 
 * System.out.println(); System.out.println(" post 폴더 " + j + " 개 계산 마쳤음 ");
 * System.out.println(" dirPostVolume \t" + dirPostVolume );
 * 
 * } // End dirs2
 * 
 * } // End dirs1
 * 
 * 
 * 
 * } else {
 * 
 * }
 * 
 * } }
 
*/