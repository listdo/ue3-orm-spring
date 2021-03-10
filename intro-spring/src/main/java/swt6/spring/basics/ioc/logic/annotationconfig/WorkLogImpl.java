package swt6.spring.basics.ioc.logic.annotationconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import swt6.spring.basics.ioc.domain.Employee;
import swt6.spring.basics.ioc.logic.WorkLogFacade;
import swt6.spring.basics.ioc.util.FileLogger;
import swt6.spring.basics.ioc.util.Log;
import swt6.spring.basics.ioc.util.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component("workLog") // Spring,
@Service("workLog") // Spring, enthält auch Code für Geschäftslogik
//@Named("workLog") // JSR330
public class WorkLogImpl implements WorkLogFacade {

  @Autowired // Spring Field Injection
  //@Named("consoleLogger")
  @Log(Log.Type.FILE)
  //@Inject JSR-330
  private Logger logger;

  private Map<Long, Employee> employees = new HashMap<Long, Employee>();
  
  private void init() {
    employees.put(1L, new Employee(1L, "Bill", "Gates"));
    employees.put(2L, new Employee(2L, "James", "Goslin"));
    employees.put(3L, new Employee(3L, "Bjarne", "Stroustrup"));
  }
  
  public WorkLogImpl() {
    init();
  }

  // @Autowired // Spring Constructor Injection
  public WorkLogImpl(Logger logger) {
    this();
    this.logger = logger;
  }

  //@Autowired // Spring Setter Injection
  public void setLogger(Logger logger) {
    this.logger = logger;
  }

  @Override
  public Employee findEmployeeById(Long id) {
    // TODO: log method invocation
    Employee empl = employees.get(id);
    logger.log(String.format("findEmployee(%d) --> %s", id, (empl != null ? empl.toString() : null)));
    return employees.get(id);
  }

  @Override
  public List<Employee> findAllEmployees() {
    // TODO: log method invocation
    logger.log(String.format("findEmployees()"));
    return new ArrayList<Employee>(employees.values());
  }
}
