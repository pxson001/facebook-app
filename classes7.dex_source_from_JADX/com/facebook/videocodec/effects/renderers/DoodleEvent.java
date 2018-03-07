package com.facebook.videocodec.effects.renderers;

/* compiled from: deviceParams */
public class DoodleEvent {
    public final Type f15804a;
    public final float f15805b;
    public final float f15806c;
    public final int f15807d;

    /* compiled from: deviceParams */
    public enum Type {
        START,
        MOVE,
        END,
        UNDO,
        CLEAR,
        VIEW_INIT
    }

    public DoodleEvent(Type type) {
        this(type, -1.0f, -1.0f);
    }

    public DoodleEvent(Type type, float f, float f2) {
        this(type, f, f2, -1);
    }

    public DoodleEvent(Type type, float f, float f2, int i) {
        this.f15804a = type;
        this.f15805b = f;
        this.f15806c = f2;
        this.f15807d = i;
    }
}
