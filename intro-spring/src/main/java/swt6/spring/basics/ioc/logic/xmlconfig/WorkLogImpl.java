package swt6.spring.basics.ioc.logic.xmlconfig;

import swt6.spring.basics.ioc.domain.Employee;
import swt6.spring.basics.ioc.logic.WorkLogFacade;
import swt6.spring.basics.ioc.util.Logger;
import swt6.spring.basics.ioc.util.LoggerFactory;

import java.io.IOException;
import java.util.*;

public class WorkLogImpl implements WorkLogFacade {

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

  public WorkLogImpl(Logger logger) {
    this();
    this.logger = logger;
  }

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
