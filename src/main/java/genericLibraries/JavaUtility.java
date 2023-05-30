package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * this class contains reusable methods of java
	 * @author anuja
	 */
	public class JAvaUtility {
		/**
		 * this method generates random no.within the limit
		 * @param limit
		 * @return
		 */
	public int generateRandomNum(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
		}
	/**
	 * this method gets system date
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd_mm_yy_hh_mm_sss");
		return sdf.format(date);
		
	}
	}


}