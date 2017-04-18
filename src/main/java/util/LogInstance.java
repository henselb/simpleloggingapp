package util;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

public class LogInstance implements Runnable {
	
	Logger log; 
	String threadName;
	final static Integer TIME_TO_RUN=120; 

	
	public LogInstance(String logName, String path, String threadName){
		this.log = this.createLoggerInstance(logName, path);
		this.threadName = threadName;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Integer timeLeft = TIME_TO_RUN; 
		while (timeLeft >0){
			log.info(threadName + " sample message..." + timeLeft);
			try {
				if (timeLeft == 90){
					log.info(threadName + " waiting an extra minute...");
					Thread.sleep(60000);
				}else {
					log.info(threadName + "sleeping normally...");
					Thread.sleep(500);
				}	
			} catch(Exception e){
				System.out.println("Thread Error " + e);
			}
			timeLeft --;
		}
	}

	
	private  Logger createLoggerInstance(String name, String path){
        Logger log = Logger.getLogger(name);

        //Create Logging File Appender
        RollingFileAppender fileAppender = new RollingFileAppender();
        fileAppender.setName(name + "_FileAppender");
        fileAppender.setFile(path +"/"+ name+".log");
        fileAppender.setLayout(new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"));
        fileAppender.setThreshold(Level.toLevel("INFO"));
        fileAppender.setAppend(true);
        fileAppender.activateOptions();
        log.addAppender(fileAppender);
        return log;
	}
	

}
