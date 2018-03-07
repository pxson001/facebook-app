package com.facebook.events.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ZR */
public class EventAnalyticsParams implements Parcelable {
    public static final Creator<EventAnalyticsParams> CREATOR = new C11221();
    public static final EventAnalyticsParams f12085a = new EventAnalyticsParams(new EventActionContext(ActionSource.DASHBOARD, ActionSource.UNKNOWN, false));
    @Nonnull
    public final EventActionContext f12086b;
    public String f12087c;
    public String f12088d;
    public String f12089e;
    public final String f12090f;

    /* compiled from: ZR */
    final class C11221 implements Creator<EventAnalyticsParams> {
        C11221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventAnalyticsParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventAnalyticsParams[i];
        }
    }

    public EventAnalyticsParams(EventActionContext eventActionContext) {
        this(eventActionContext, null);
    }

    private EventAnalyticsParams(EventActionContext eventActionContext, @Nullable String str) {
        if (eventActionContext == null) {
            eventActionContext = EventActionContext.f12075a;
        }
        this.f12086b = eventActionContext;
        this.f12090f = str;
    }

    public EventAnalyticsParams(EventActionContext eventActionContext, String str, String str2, @Nullable String str3) {
        if (eventActionContext == null) {
            eventActionContext = EventActionContext.f12075a;
        }
        this.f12086b = eventActionContext;
        this.f12087c = str;
        this.f12088d = str2;
        this.f12090f = str3;
    }

    public EventAnalyticsParams(EventActionContext eventActionContext, String str, @Nullable String str2, String str3, @Nullable String str4) {
        if (eventActionContext == null) {
            eventActionContext = EventActionContext.f12075a;
        }
        this.f12086b = eventActionContext;
        this.f12087c = str;
        this.f12088d = str3;
        this.f12089e = str2;
        this.f12090f = str4;
    }

    public EventAnalyticsParams(Parcel parcel) {
        this.f12086b = (EventActionContext) parcel.readParcelable(EventActionContext.class.getClassLoader());
        this.f12087c = parcel.readString();
        this.f12088d = parcel.readString();
        this.f12090f = parcel.readString();
    }

    public final EventAnalyticsParams m20119a(ActionSource actionSource) {
        EventActionContext eventActionContext = this.f12086b;
        return new EventAnalyticsParams(new EventActionContext(actionSource, eventActionContext.f12081g, eventActionContext.f12080f, eventActionContext.f12082h, eventActionContext.f12083i), this.f12087c, this.f12088d, this.f12090f);
    }

    public EventAnalyticsParams(EventAnalyticsParams eventAnalyticsParams, ActionSource actionSource) {
        this.f12086b = eventAnalyticsParams.f12086b.m20118a(actionSource);
        this.f12087c = eventAnalyticsParams.f12087c;
        this.f12088d = eventAnalyticsParams.f12088d;
        this.f12090f = eventAnalyticsParams.f12090f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12086b, i);
        parcel.writeString(this.f12087c);
        parcel.writeString(this.f12088d);
        parcel.writeString(this.f12090f);
    }
}
