package swt6.spring.basics.ioc.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import swt6.spring.basics.ioc.logic.WorkLogFacade;
import swt6.spring.basics.ioc.logic.factorybased.WorkLogImpl;
import swt6.spring.basics.ioc.logic.javaconfig.WorkLogConfig;
import swt6.util.PrintUtil;

public class IocTest {

  private static void testSimple() {
    WorkLogImpl workLog = new WorkLogImpl();
    workLog.findAllEmployees();
    workLog.findEmployeeById(3l);
  }

  private static void testXMLConfig()
  {
    try(AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "swt6/spring/basics/ioc/test/applicationContext-xml-config.xml"))
    {
      System.out.println("=====> Workloag setter injected");
      WorkLogFacade wl1 = context.getBean("workLog-setter-injected", WorkLogFacade.class);
      wl1.findAllEmployees();
      wl1.findEmployeeById(3L);
      System.out.println("=====> Workloag constructor injected");
      WorkLogFacade wl2 = context.getBean("workLog-constructor-injected", WorkLogFacade.class);
      wl2.findAllEmployees();
      wl2.findEmployeeById(3L);
    }
  }

  private static void testAnnotationConfig()
  {
    try(AbstractApplicationContext context =
                new ClassPathXmlApplicationContext(
                        "swt6/spring/basics/ioc/test/applicationContext-annotation-config.xml"))
    {
      System.out.println("=====> Worklog injected");
      WorkLogFacade wl = context.getBean("workLog", WorkLogFacade.class);
      wl.findAllEmployees();
      wl.findEmployeeById(3L);
    }
  }

  private static void testJavaConfig()
  {
    try(AbstractApplicationContext context =
                new AnnotationConfigApplicationContext(WorkLogConfig.class))
    {
      System.out.println("=====> Worklog injected");
      //WorkLogFacade wl = context.getBean("workLog", WorkLogFacade.class);
      WorkLogFacade wl = context.getBean(WorkLogFacade.class);
      wl.findAllEmployees();
      wl.findEmployeeById(3L);
    }
  }

  public static void main(String[] args) {
    PrintUtil.printTitle("testSimple", 60);
    //testSimple();
    //testXMLConfig();
    //testAnnotationConfig();
    testJavaConfig();

    PrintUtil.printSeparator(60);
  }
}
