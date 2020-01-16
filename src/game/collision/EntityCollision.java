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
        entityHit = null;
        entities.forEach( entity -> {
            if (entity == myEntity)return;
            if (entity.getXProperty()-2 <= myEntity.getXProperty() && entity.getXProperty()+2 >= myEntity.getXProperty()) {
                if (entity.getYProperty()-2 <= myEntity.getYProperty() && entity.getYProperty()+2 >= myEntity.getYProperty()) {
                    entityHit = entity;
                }
            }
        });
        return entityHit != null;
    }

    public Entity getEntityHit() {
        return entityHit;
    }
}
