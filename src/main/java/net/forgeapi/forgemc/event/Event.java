package net.forgeapi.forgemc.event;

public abstract class Event<T> {
    public abstract void register(T listener);
}
