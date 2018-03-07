package com.facebook.entitycards.model.event;

import javax.annotation.Nullable;

/* compiled from: home_session_id */
public class EntityModelChangedEvent<T> extends EntityCardsModelEvent {
    public final Object f11080a;
    public final String f11081b;
    public final T f11082c;

    public EntityModelChangedEvent(Object obj, @Nullable String str, T t) {
        this.f11080a = obj;
        this.f11081b = str;
        this.f11082c = t;
    }
}
