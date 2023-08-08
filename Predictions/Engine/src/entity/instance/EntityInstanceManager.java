package entity.instance;

import java.util.List;

public class EntityInstanceManager {
    private final String name;
    private final List<EntityInstance> entityInstanceList;

    public EntityInstanceManager(String name, List<EntityInstance> list) {
        this.name = name;
        this.entityInstanceList = list;
    }

    public List<EntityInstance> getEntityInstanceList() {
        return entityInstanceList;
    }

    public void killEntity(EntityInstance entityToKill){

        entityInstanceList.remove(entityToKill);
    }
    public String getName() {
        return name;
    }
}
