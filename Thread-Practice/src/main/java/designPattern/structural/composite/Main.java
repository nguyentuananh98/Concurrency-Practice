package designPattern.structural.composite;

import designPattern.structural.composite.component.Permission;
import designPattern.structural.composite.composite.PermissionGroup;
import designPattern.structural.composite.leaf.SimplePermission;

public class Main {
    public static void main(String[] args) {
        Permission read = new SimplePermission("READ");
        Permission write = new SimplePermission("WRITE");

        PermissionGroup admin = new PermissionGroup();
        admin.add(read);
        admin.add(write);

        PermissionGroup employee = new PermissionGroup();
        employee.add(read);

        // ADMIN
        System.out.println(admin.isGranted("READ"));
        System.out.println(admin.isGranted("REMOVE"));

        // EMPLOYEE
        System.out.println(employee.isGranted("READ"));
        System.out.println(employee.isGranted("WRITE"));
    }
}
