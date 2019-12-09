package game.collision;

import game.entity.Entity;
import game.map.Map;

public class EntityCollision extends Collision {

    private Entity entity;
    private Map map;

    public EntityCollision(Entity entity, Map map) {
        this.entity = entity;
        this.map = map;
    }

    public void call() {

    }
}
