public class Employee {
    public static int id = 1;
    public int ID;
    public String name;
    public double baseSalary;
    public Employee manager;
    public String currentStatus;
    public Employee() {
        this.ID = id;
        id++;
    }
    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.ID = id;
        id++;
    }
    public double getBaseSalary() {
        return this.baseSalary;
    }
    public String getName() {
        return this.name;
    }
    public int getEmployeeID() {
        return this.ID;
    }
    public Employee getManager() {
        return this.manager;
    }
    public boolean equals(Employee other) {
        if (this.ID == other.ID) return true;
        else return false;
    }
    public String toString() {
       return ("ID: " + getEmployeeID() + " Name: " + getName());
    }
    public String employeeStatus() {
        return this.currentStatus;
    }
}

class TechnicalEmployee extends Employee {
    public TechnicalEmployee() {
        this.baseSalary = 75000.0;
    }
    public TechnicalEmployee(String name) {
        this.baseSalary = 75000.0;
        this.name = name;
    }
    public String employeeStatus() {
        return this.currentStatus;
    }
}

class BusinessEmployee extends Employee {
    private int bonusBudget = 0;
    public BusinessEmployee() {
        this.baseSalary = 50000.0;
    }
    public BusinessEmployee(String name) {
        this.baseSalary = 50000.0;
        this.name = name;
    }
    public double getBonusBudget() {
        return this.bonusBudget;
    }
}   

class SoftwareEngineer extends TechnicalEmployee {
    public SoftwareEngineer(String name) {
        this.name = name;
    }
    public boolean getCodeAccess() {
        return true;
    }
    public int getSuccesfullCheckIns() {
        return 0;
    }
    public boolean checkInCode() {
        return true;
    }
}

class Accountant extends BusinessEmployee {
    private int team = null;
    public Accountant(String name) {
        this.team = null;
    }
    public TechnicalLead getTeamSupported() {
        return this.team;
    }
    public void supportTeam(TechnicalLead lead) {

    }
}

class TechnicalLead extends Employee {
    TechnicalEmployee placeholder = new TechnicalEmployee();
    public TechnicalLead(String name) {
        this.name = name;
        this.baseSalary = placeholder.getBaseSalary() * 1.3;
    }
}