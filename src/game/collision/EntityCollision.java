package game.collision;

import game.entity.Entity;

import java.util.List;

public class EntityCollision {

    private List<Entity> entities;
    private Entity entityHit = null;

    public EntityCollision(List<Entity> entities) {
        this.entities = entities;
    }

    public boolean isHitting(Entity myEntity) {
        entities.forEach( entity -> {
            if (entity == myEntity)return;
            if (entity.getXProperty() == myEntity.getXProperty()) {
                if (entity.getYProperty() == myEntity.getYProperty())
                    entityHit = entity;
            }
        });
        return entityHit != null;
    }

    public Entity getEntityHit() {
        return entityHit;
    }
}
