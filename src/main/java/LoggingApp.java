import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import util.LogInstance;


public class LoggingApp {
	final static Logger log = Logger.getLogger(LoggingApp.class);

	public static void main(String[] args) throws InterruptedException {
		/* // TODO Auto-generated method stub
		Integer timeLeft = TIME_TO_RUN; 
		while (timeLeft >0){
			log.info("this is a sample message..." + timeLeft);
			if (timeLeft == 90){
				log.info("waiting an extra minute...");
				Thread.sleep(60000);
			}else {
				log.info("sleeping normally...");
				Thread.sleep(500);
			}
			timeLeft --;
		} */
		String path = "/Users/brianhensel/Documents/workspace/test/";

		new Thread(new LogInstance("thread+A", path, "thread-A")).start();
		new Thread(new LogInstance("thread+B", path,  "thread-B")).start();
		
	}




}
