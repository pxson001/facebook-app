package com.facebook.feed.loader;

import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;

/* compiled from: selfupdate_install_activity_shows */
public class InitializationStatus {
    public Type f5722a = Type.NOT_INITIALIZED;

    /* compiled from: selfupdate_install_activity_shows */
    public enum Type {
        NOT_INITIALIZED,
        INITIAL_FETCH_STARTED,
        INITIAL_HEAD_LOAD_COMPLETE,
        INITIAL_TAIL_LOAD_COMPLETE,
        INITIALIZED
    }

    public static InitializationStatus m9851a(InjectorLike injectorLike) {
        return new InitializationStatus();
    }

    public final boolean m9852a() {
        return this.f5722a == Type.INITIALIZED;
    }

    public final void m9853b() {
        Preconditions.checkState(this.f5722a == Type.NOT_INITIALIZED);
        this.f5722a = Type.INITIAL_FETCH_STARTED;
    }

    public final void m9854f() {
        this.f5722a = Type.INITIALIZED;
    }

    public final boolean m9855g() {
        return this.f5722a == Type.INITIAL_FETCH_STARTED || this.f5722a == Type.INITIAL_HEAD_LOAD_COMPLETE || this.f5722a == Type.INITIAL_TAIL_LOAD_COMPLETE;
    }
}
