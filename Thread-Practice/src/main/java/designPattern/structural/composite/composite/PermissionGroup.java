package designPattern.structural.composite.composite;

import designPattern.structural.composite.component.Permission;

import java.util.ArrayList;
import java.util.List;

public class PermissionGroup implements Permission {

    private final List<Permission> permissions = new ArrayList<>();

    public void add (Permission permission) {
        permissions.add(permission);
    }

    public void remove (Permission permission) {
        permissions.remove(permission);
    }

    @Override
    public boolean isGranted(String action) {
        return permissions.stream()
                .anyMatch(p -> p.isGranted(action));
    }
}
