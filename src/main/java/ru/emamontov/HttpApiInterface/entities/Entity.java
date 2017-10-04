package ru.emamontov.HttpApiInterface.entities;

import java.io.Serializable;


public class Entity implements Serializable {

    protected final boolean success;

    public Entity(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
