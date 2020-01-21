package game.collision;

import game.entity.Entity;

import java.util.List;

/**
 * This is a model to detect collision between entities
 * */
public class EntityCollision {

    private List<Entity> entities;
    private Entity entityHit = null;

    /**
     * EntityCollision constructor initialize game entities
     *
     * @param entities List of all entities in the game
     * */
    public EntityCollision(List<Entity> entities) {
        this.entities = entities;
    }

    /**
     * Detect if a entity have a collision with another entity
     *
     * @param myEntity The entity tested if she have collision with another entity
     * */
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

    /**
     * Get entity that have been hit
     *
     * @return entity Entity hit
     * */
    public Entity getEntityHit() {
        return entityHit;
    }
}
