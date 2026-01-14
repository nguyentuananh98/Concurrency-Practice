package designPattern.structural.composite.leaf;

import designPattern.structural.composite.component.Permission;

public class SimplePermission implements Permission {
    private final String action;

    public SimplePermission(String action) {
        this.action = action;
    }

    @Override
    public boolean isGranted(String action) {
        return this.action.equals(action);
    }
}
