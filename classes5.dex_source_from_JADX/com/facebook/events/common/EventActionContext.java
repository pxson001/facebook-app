package com.facebook.events.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import org.json.JSONObject;

@Immutable
/* compiled from: ZTT; */
public class EventActionContext implements Parcelable {
    public static final Creator<EventActionContext> CREATOR = new C11211();
    public static final EventActionContext f12075a = new EventActionContext(ActionSource.UNKNOWN, ActionSource.UNKNOWN, false);
    public static final EventActionContext f12076b = new EventActionContext(ActionSource.DASHBOARD, ActionSource.MOBILE_BOOKMARK_TAB, false);
    public static final EventActionContext f12077c = new EventActionContext(ActionSource.PERMALINK, ActionSource.UNKNOWN, false);
    public static final EventActionContext f12078d = new EventActionContext(ActionSource.MOBILE_EVENT_COMPOSER, ActionSource.UNKNOWN, false);
    @Nonnull
    public final ActionSource f12079e;
    @Nonnull
    public final ActionSource f12080f;
    public final ActionMechanism f12081g;
    public final ActionMechanism f12082h;
    public final boolean f12083i;
    public JSONObject f12084j;

    /* compiled from: ZTT; */
    final class C11211 implements Creator<EventActionContext> {
        C11211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventActionContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventActionContext[i];
        }
    }

    public EventActionContext(ActionSource actionSource, ActionSource actionSource2, boolean z) {
        this(actionSource, null, actionSource2, null, z);
    }

    public EventActionContext(ActionSource actionSource, ActionMechanism actionMechanism, ActionSource actionSource2, ActionMechanism actionMechanism2, boolean z) {
        if (actionSource == null) {
            actionSource = ActionSource.UNKNOWN;
        }
        this.f12079e = actionSource;
        this.f12081g = actionMechanism;
        if (actionSource2 == null) {
            actionSource2 = ActionSource.UNKNOWN;
        }
        this.f12080f = actionSource2;
        this.f12082h = actionMechanism2;
        this.f12083i = z;
    }

    protected EventActionContext(Parcel parcel) {
        this.f12079e = (ActionSource) parcel.readParcelable(ActionSource.class.getClassLoader());
        this.f12081g = (ActionMechanism) parcel.readParcelable(ActionMechanism.class.getClassLoader());
        this.f12080f = (ActionSource) parcel.readParcelable(ActionSource.class.getClassLoader());
        this.f12082h = (ActionMechanism) parcel.readParcelable(ActionMechanism.class.getClassLoader());
        this.f12083i = ParcelUtil.m3827a(parcel);
    }

    public final ActionSource m20116a() {
        return this.f12079e;
    }

    public final EventActionContext m20117a(ActionMechanism actionMechanism) {
        return new EventActionContext(this.f12079e, actionMechanism, this.f12080f, this.f12082h, this.f12083i);
    }

    public final EventActionContext m20118a(ActionSource actionSource) {
        return new EventActionContext(actionSource, null, this.f12079e, this.f12081g, this.f12083i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12079e, i);
        parcel.writeParcelable(this.f12081g, i);
        parcel.writeParcelable(this.f12080f, i);
        parcel.writeParcelable(this.f12082h, i);
        ParcelUtil.m3826a(parcel, this.f12083i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventActionContext eventActionContext = (EventActionContext) obj;
        if (this.f12083i != eventActionContext.f12083i) {
            return false;
        }
        if (this.f12080f != eventActionContext.f12080f) {
            return false;
        }
        if (this.f12079e != eventActionContext.f12079e) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f12083i ? 1 : 0) + (((this.f12079e.hashCode() * 31) + this.f12080f.hashCode()) * 31);
    }
}
