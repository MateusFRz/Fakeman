package game.collision;

import game.entity.Entity;

import java.util.List;

public class EntityCollision {

    private List<Entity> entities;

    public EntityCollision(List<Entity> entities) {
        this.entities = entities;
    }

    public Entity entityHit(Entity myEntity) {
        for (Entity entity : entities) {
            if (entity == myEntity) continue;
            if (entity.getXProperty() == myEntity.getXProperty()) {
                if (entity.getYProperty() == myEntity.getYProperty())
                    return entity;
            }
        }
        return null;
    }

    public boolean isHitting(Entity myEntity) {
        for (Entity entity : entities) {
            if (entity == myEntity) continue;
            if (entity.getXProperty() == myEntity.getXProperty()) {
                if (entity.getYProperty() == myEntity.getYProperty())
                    return true;
            }
        }
        return false;
    }
}
