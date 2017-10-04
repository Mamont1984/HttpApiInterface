package ru.emamontov.HttpApiInterface.entities;

import java.io.Serializable;


public class Entity implements Serializable {

    protected boolean success;

    public Entity() {
    }

    public Entity(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
