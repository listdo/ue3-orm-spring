package swt6.spring.basics.ioc.logic.factorybased;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import swt6.spring.basics.ioc.domain.Employee;
import swt6.spring.basics.ioc.util.ConsoleLogger;
import swt6.spring.basics.ioc.util.FileLogger;
import swt6.spring.basics.ioc.util.Logger;
import swt6.spring.basics.ioc.util.LoggerFactory;

public class WorkLogImpl {

  //private Logger logger = new ConsoleLogger();
  //private Logger logger = new FileLogger("log.txt");
  private Logger logger;

  private Map<Long, Employee> employees = new HashMap<Long, Employee>();

  private void initLogger() {
    Properties props = new Properties();
   
    try {
      ClassLoader cl = this.getClass().getClassLoader();
      props.load(cl.getResourceAsStream(
        "swt6/spring/basics/ioc/logic/factorybased/worklog.properties"));
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    //
    // TODO: read logger type from configuration
    //

    String type = props.getProperty("loggerType", "console");
    logger = LoggerFactory.getLogger(type);
  }
  
  private void init() {
    employees.put(1L, new Employee(1L, "Bill", "Gates"));
    employees.put(2L, new Employee(2L, "James", "Goslin"));
    employees.put(3L, new Employee(3L, "Bjarne", "Stroustrup"));
  }
  
  public WorkLogImpl() {
    initLogger();
    init();
  }


  public Employee findEmployeeById(Long id) {
    // TODO: log method invocation
    Employee empl = employees.get(id);
    logger.log(String.format("findEmployee(%d) --> %s", id, (empl != null ? empl.toString() : null)));
    return employees.get(id);
  }

  public List<Employee> findAllEmployees() {
    // TODO: log method invocation
    logger.log(String.format("findEmployees()"));
    return new ArrayList<Employee>(employees.values());
  }
}
