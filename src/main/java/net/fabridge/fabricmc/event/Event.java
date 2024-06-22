package net.fabridge.fabricmc.event;

public abstract class Event<T> {
    public abstract void register(T listener);
}
