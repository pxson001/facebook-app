package com.facebook.events.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.graphql.enums.GraphQLEventSeenState;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;

/* compiled from: swipe_left */
public class EventUser implements Parcelable {
    public static final Creator<EventUser> CREATOR = new C02361();
    public final EventUserType f2746a;
    public final String f2747b;
    public final String f2748c;
    public final String f2749d;
    public final String f2750e;
    public final String f2751f;
    public final int f2752g;
    public final GraphQLFriendshipStatus f2753h;
    public final GraphQLEventSeenState f2754i;
    public final boolean f2755j;
    public boolean f2756k;

    /* compiled from: swipe_left */
    final class C02361 implements Creator<EventUser> {
        C02361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EventUser(parcel);
        }

        public final Object[] newArray(int i) {
            return new EventUser[i];
        }
    }

    /* compiled from: swipe_left */
    public class Builder {
        public EventUserType f2736a;
        public String f2737b;
        public String f2738c;
        public String f2739d;
        public String f2740e;
        public String f2741f;
        public int f2742g;
        public GraphQLFriendshipStatus f2743h;
        public GraphQLEventSeenState f2744i;
        public boolean f2745j = true;

        public Builder(EventUser eventUser) {
            this.f2736a = eventUser.f2746a;
            this.f2737b = eventUser.f2748c;
            this.f2738c = eventUser.f2747b;
            this.f2739d = eventUser.f2749d;
            this.f2740e = eventUser.f2750e;
            this.f2742g = eventUser.f2752g;
            this.f2743h = eventUser.f2753h;
            this.f2744i = eventUser.f2754i;
            this.f2745j = eventUser.f2755j;
        }

        public final EventUser m3019a() {
            return new EventUser(this);
        }
    }

    /* compiled from: swipe_left */
    public enum EventUserType {
        USER,
        PAGE,
        EMAIL_USER,
        EMAIL_SYNTHETIC,
        SMS_USER,
        SMS_SYNTHETIC
    }

    public EventUser(Builder builder) {
        this.f2746a = builder.f2736a;
        this.f2748c = builder.f2737b;
        this.f2747b = builder.f2738c;
        this.f2749d = builder.f2739d;
        this.f2750e = builder.f2740e;
        this.f2751f = builder.f2741f;
        this.f2752g = builder.f2742g;
        this.f2753h = builder.f2743h;
        this.f2754i = builder.f2744i;
        this.f2755j = builder.f2745j;
    }

    public EventUser(Parcel parcel) {
        String readString = parcel.readString();
        this.f2746a = readString == null ? null : EventUserType.valueOf(readString);
        this.f2747b = parcel.readString();
        this.f2748c = parcel.readString();
        this.f2749d = parcel.readString();
        this.f2750e = parcel.readString();
        this.f2751f = parcel.readString();
        this.f2752g = parcel.readInt();
        this.f2753h = GraphQLFriendshipStatus.fromString(parcel.readString());
        this.f2754i = GraphQLEventSeenState.fromString(parcel.readString());
        this.f2755j = ParcelUtil.a(parcel);
    }

    public final EventUserType m3020c() {
        return this.f2746a;
    }

    public final String m3021d() {
        return this.f2748c;
    }

    public final String m3022e() {
        return this.f2747b;
    }

    public final Uri m3023i() {
        return this.f2749d == null ? null : Uri.parse(this.f2749d);
    }

    public final GraphQLFriendshipStatus m3024k() {
        return this.f2753h;
    }

    public final boolean m3025m() {
        return this.f2755j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        String str = null;
        parcel.writeString(this.f2746a == null ? null : this.f2746a.name());
        parcel.writeString(this.f2747b);
        parcel.writeString(this.f2748c);
        parcel.writeString(this.f2749d);
        parcel.writeString(this.f2750e);
        parcel.writeString(this.f2751f);
        parcel.writeInt(this.f2752g);
        parcel.writeString(this.f2753h == null ? null : this.f2753h.name());
        if (this.f2754i != null) {
            str = this.f2754i.name();
        }
        parcel.writeString(str);
        ParcelUtil.a(parcel, this.f2755j);
    }
}
