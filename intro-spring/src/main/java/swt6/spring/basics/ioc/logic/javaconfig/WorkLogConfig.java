package swt6.spring.basics.ioc.logic.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import swt6.spring.basics.ioc.logic.WorkLogFacade;
import swt6.spring.basics.ioc.util.Logger;

@Configuration
@ComponentScan(basePackageClasses = {Logger.class, WorkLogImpl.class})
public class WorkLogConfig {

    //@Bean @Log(Log.Type.STANDARD)
    //public Logger consoleLogger() {
    //    return new ConsoleLogger();
    //}
    //@Bean @Log(Log.Type.FILE)
    //public Logger fileLogger() {
    //    return new FileLogger("log.txt");
    //}

    //@Bean
    //public WorkLogFacade workLog()
    //{
    //    //return new WorkLogImpl(consoleLogger());
    //    return new WorkLogImpl();
    //}
}
