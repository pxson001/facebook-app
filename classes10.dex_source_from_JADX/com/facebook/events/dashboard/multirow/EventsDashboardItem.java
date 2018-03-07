package com.facebook.events.dashboard.multirow;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: com.facebook.sdk.EXTRA_NEW_PROFILE */
public class EventsDashboardItem<T> {
    public final T f17049a;
    public final EventsDashboardPartDefinitionKey<T> f17050b;

    private EventsDashboardItem(EventsDashboardPartDefinitionKey<T> eventsDashboardPartDefinitionKey, T t) {
        Preconditions.checkNotNull(t);
        this.f17050b = eventsDashboardPartDefinitionKey;
        this.f17049a = t;
    }

    public static <T> EventsDashboardItem<T> m17358a(EventsDashboardPartDefinitionKey<T> eventsDashboardPartDefinitionKey, @Nullable T t) {
        return t == null ? null : new EventsDashboardItem(eventsDashboardPartDefinitionKey, t);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EventsDashboardItem)) {
            return false;
        }
        EventsDashboardItem eventsDashboardItem = (EventsDashboardItem) obj;
        if (Objects.equal(eventsDashboardItem.f17049a, this.f17049a) && Objects.equal(eventsDashboardItem.f17050b, this.f17050b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f17050b, this.f17049a});
    }
}
