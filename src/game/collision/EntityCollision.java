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
        entities.forEach(entity -> {
            if (entity == myEntity) return;
            double diameter = entity.getEntity().getRadius() * 2;
            if (entity.getXProperty() - diameter <= myEntity.getXProperty() && entity.getXProperty() + diameter >= myEntity.getXProperty()) {
                if (entity.getYProperty() - diameter <= myEntity.getYProperty() && entity.getYProperty() + diameter >= myEntity.getYProperty()) {
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
