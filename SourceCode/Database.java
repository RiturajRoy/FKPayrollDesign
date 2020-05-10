import java.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.FileWriter;
public class Database {

    public static HashMap<Integer,Employee> employees = new HashMap<Integer,Employee>();
    public static HashMap<Integer,Employee> members = new HashMap<Integer, Employee>();

    public void addEmployee(int id, Employee employee) {
        employees.put(id, employee);
        Gson gson = new Gson();
        String json = gson.toJson(employees);
        try
        {
            FileWriter file = new FileWriter("employees.json");
            file.write(json);
            file.close();
        }
        catch (IOException e) 
        {
             e.printStackTrace();
        } 
    }

    public Employee getEmployee(int empId) {
        return employees.get(empId);
    }

    public void deleteEmployee(int id) {
        employees.remove(id);
        Gson gson = new Gson();
        String json = gson.toJson(employees);
        try
        {
            FileWriter file = new FileWriter("employees.json");
            file.write(json);
            file.close();
        }
        catch (IOException e) 
        {
             e.printStackTrace();
        }
    }

    public void addUnionMember(int memberId, Employee e) {
        members.put(memberId, e);
        Gson gson = new Gson();
        String json = gson.toJson(members);
        try
        {
            FileWriter file = new FileWriter("members.json");
            file.write(json);
            file.close();
        }
        catch (IOException er) 
        {
             er.printStackTrace();
        }   
    }

    public Employee getMember(int memberId) {
        return members.get(memberId);
    }

    public void deleteMember(int memberId) 
    {
      members.remove(memberId);
      Gson gson = new Gson();
      String json = gson.toJson(members);
      try
      {
        FileWriter file = new FileWriter("members.json");
        file.write(json);
        file.close();
      }
      catch (IOException e) 
      {
          e.printStackTrace();
      } 
    }

    public Collection<Employee> getAllEmployees() {
      return employees.values();
    }
}