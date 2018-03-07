package com.facebook.events.permalink.multirow;

import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: bc94a5e3b816a8171257ece5c7f09107 */
public class EventPermalinkNode<T> {
    public final T f18712a;
    public final EventPartDefinitionKey<T> f18713b;

    private EventPermalinkNode(EventPartDefinitionKey<T> eventPartDefinitionKey, T t) {
        Preconditions.checkNotNull(t);
        this.f18713b = eventPartDefinitionKey;
        this.f18712a = t;
    }

    public static <T> EventPermalinkNode<T> m18998a(EventPartDefinitionKey<T> eventPartDefinitionKey, @Nullable T t) {
        return t == null ? null : new EventPermalinkNode(eventPartDefinitionKey, t);
    }
}
