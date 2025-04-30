/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalstaffmanager;

/**
 *
 * @author maryl
 */
public class Employee {
    
    protected String name;
    protected ManagerType managerType;
    protected Department department;

    public Employee(String name, ManagerType managerType, Department department) {
        this.name = name;
        this.managerType = managerType;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public ManagerType getManagerType() {
        return managerType;
    }

    public Department getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return name + " - " + managerType + " - " + department;
    }
}


