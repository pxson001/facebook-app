package com.facebook.groups.editfavorites.event;

import com.facebook.content.event.FbEvent;

/* compiled from: adapter must be set */
public class GroupFavoriteStatusEvent implements FbEvent {
    public final EventType f10108a;

    /* compiled from: adapter must be set */
    public enum EventType {
        REORDER,
        STATUS_CHANGE,
        EDIT_DONE
    }

    public GroupFavoriteStatusEvent(EventType eventType) {
        this.f10108a = eventType;
    }
}
