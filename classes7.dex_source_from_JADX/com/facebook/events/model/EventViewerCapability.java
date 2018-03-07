package com.facebook.events.model;

import java.util.EnumSet;
import java.util.Iterator;

/* compiled from: swipe_count */
public enum EventViewerCapability {
    ADMIN,
    JOIN,
    MAYBE,
    DECLINE,
    INVITE,
    POST,
    EDIT,
    REPORT,
    DELETE,
    SAVE,
    SHARE,
    SEND_MESSAGE_TO_GUESTS,
    EDIT_HOST,
    REMOVE_SELF,
    SEEN,
    UNSEEN,
    UNKNOWN_SEEN_STATE,
    PROMOTE,
    EDIT_PROMOTION;

    public static long serializeCapabilities(EnumSet<EventViewerCapability> enumSet) {
        Iterator it = enumSet.iterator();
        long j = 0;
        while (it.hasNext()) {
            j = (1 << ((EventViewerCapability) it.next()).ordinal()) | j;
        }
        return j;
    }

    public static EnumSet<EventViewerCapability> deserializeCapabilities(long j) {
        EnumSet<EventViewerCapability> noneOf = EnumSet.noneOf(EventViewerCapability.class);
        for (EventViewerCapability eventViewerCapability : values()) {
            long ordinal = 1 << eventViewerCapability.ordinal();
            if ((j & ordinal) == ordinal) {
                noneOf.add(eventViewerCapability);
            }
        }
        return noneOf;
    }
}
