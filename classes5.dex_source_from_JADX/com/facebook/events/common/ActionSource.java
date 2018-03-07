package com.facebook.events.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nonnull;

/* compiled from: ZZ */
public enum ActionSource implements Parcelable {
    UNKNOWN(0),
    PERMALINK(1),
    DASHBOARD(2),
    NEWSFEED(3),
    GROUP(4),
    PAGE(5),
    TIMELINE(22),
    NOTIFICATION(29),
    GRAPH_SEARCH(70),
    LAUNCHER(78),
    PAGE_UPCOMING_EVENTS_CARD(98),
    MOBILE_SUGGESTIONS_DASHBOARD(201),
    MOBILE_SUGGESTIONS_LIST(202),
    MOBILE_EVENT_COMPOSER(203),
    MOBILE_BOOKMARK_TAB(206),
    MOBILE_SYSTEM_NOTIFICATION(207),
    MOBILE_SUBSCRIPTIONS_DASHBOARD(208),
    MOBILE_SUBSCRIPTIONS_LIST(209),
    GUESTS_VIEW(400);
    
    public static final Creator<ActionSource> CREATOR = null;
    private final int mParamValue;

    /* compiled from: ZZ */
    final class C11201 implements Creator<ActionSource> {
        C11201() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return ActionSource.valueOf(parcel.readString());
        }

        public final Object[] newArray(int i) {
            return new ActionSource[i];
        }
    }

    static {
        CREATOR = new C11201();
    }

    public static void putActionRef(@Nonnull Bundle bundle, ActionSource actionSource) {
        bundle.putParcelable("action_ref", actionSource);
    }

    private ActionSource(int i) {
        this.mParamValue = i;
    }

    public final int getParamValue() {
        return this.mParamValue;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name());
    }
}
