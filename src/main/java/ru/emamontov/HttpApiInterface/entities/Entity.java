package ru.emamontov.HttpApiInterface.entities;

import java.io.Serializable;


public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
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
