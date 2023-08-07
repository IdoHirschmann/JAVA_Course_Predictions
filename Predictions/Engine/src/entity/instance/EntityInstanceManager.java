package entity.instance;

import java.util.List;

public class EntityInstanceManager {
    private final String name;
    private final List<EntityInstance> list;

    public EntityInstanceManager(String name, List<EntityInstance> list) {
        this.name = name;
        this.list = list;
    }

    public List<EntityInstance> getList() {
        return list;
    }

    public String getName() {
        return name;
    }
}
