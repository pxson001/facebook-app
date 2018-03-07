package com.facebook.notifications.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: isSelectable */
public class NotificationsLogger$NotificationLogObject implements Parcelable {
    public static final Creator<NotificationsLogger$NotificationLogObject> CREATOR = new C07911();
    public String f12168A;
    public String f12169a;
    public NotificationType f12170b;
    public String f12171c;
    public int f12172d;
    public long f12173e;
    public String f12174f;
    public String f12175g;
    public String f12176h;
    public String f12177i;
    public boolean f12178j;
    public boolean f12179k;
    public boolean f12180l;
    public boolean f12181m;
    public boolean f12182n;
    public boolean f12183o;
    public boolean f12184p;
    public int f12185q;
    public String f12186r;
    public String f12187s;
    public String f12188t;
    public long f12189u;
    public int f12190v;
    public boolean f12191w;
    public String f12192x;
    public String f12193y;
    public int f12194z;

    /* compiled from: isSelectable */
    final class C07911 implements Creator<NotificationsLogger$NotificationLogObject> {
        C07911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new NotificationsLogger$NotificationLogObject(parcel);
        }

        public final Object[] newArray(int i) {
            return new NotificationsLogger$NotificationLogObject[i];
        }
    }

    public final NotificationsLogger$NotificationLogObject m19109a(@Nullable GraphQLStorySeenState graphQLStorySeenState) {
        this.f12168A = graphQLStorySeenState != null ? graphQLStorySeenState.name() : null;
        return this;
    }

    public final NotificationType m19110b() {
        return this.f12170b == null ? NotificationType.UNKNOWN : this.f12170b;
    }

    @Nullable
    public final String m19111c() {
        return this.f12170b == null ? null : this.f12170b.toString();
    }

    @Nullable
    public final String m19112d() {
        return this.f12171c;
    }

    public final long m19113f() {
        return this.f12173e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.f12169a);
        parcel.writeParcelable(this.f12170b, i);
        parcel.writeString(this.f12171c);
        parcel.writeInt(this.f12172d);
        parcel.writeLong(this.f12173e);
        parcel.writeString(this.f12174f);
        parcel.writeString(this.f12175g);
        parcel.writeString(this.f12176h);
        parcel.writeString(this.f12177i);
        parcel.writeByte((byte) (this.f12178j ? 1 : 0));
        if (this.f12179k) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f12180l) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f12181m) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f12182n) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f12183o) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (this.f12184p) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f12185q);
        parcel.writeString(this.f12186r);
        parcel.writeString(this.f12187s);
        parcel.writeString(this.f12188t);
        parcel.writeLong(this.f12189u);
        parcel.writeInt(this.f12190v);
        if (!this.f12191w) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.f12192x);
        parcel.writeString(this.f12193y);
        parcel.writeInt(this.f12194z);
        parcel.writeString(this.f12168A);
    }

    public NotificationsLogger$NotificationLogObject(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f12169a = parcel.readString();
        this.f12170b = (NotificationType) parcel.readParcelable(NotificationType.class.getClassLoader());
        this.f12171c = parcel.readString();
        this.f12172d = parcel.readInt();
        this.f12173e = parcel.readLong();
        this.f12174f = parcel.readString();
        this.f12175g = parcel.readString();
        this.f12176h = parcel.readString();
        this.f12177i = parcel.readString();
        this.f12178j = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12179k = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12180l = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12181m = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12182n = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12183o = z;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f12184p = z;
        this.f12185q = parcel.readInt();
        this.f12186r = parcel.readString();
        this.f12187s = parcel.readString();
        this.f12188t = parcel.readString();
        this.f12189u = parcel.readLong();
        this.f12190v = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f12191w = z2;
        this.f12192x = parcel.readString();
        this.f12193y = parcel.readString();
        this.f12194z = parcel.readInt();
        this.f12168A = parcel.readString();
    }

    public String toString() {
        return Objects.toStringHelper(NotificationsLogger.class).add("notif_type", this.f12170b).add("client_tag", this.f12171c).add("unread_count", this.f12172d).add("alert_id", this.f12173e).add("graphql_id", this.f12174f).add("object_id", this.f12175g).add("is_unread", this.f12179k).add("system_tray_id", this.f12185q).add("system_tray_tag", this.f12186r).add("push_source", this.f12187s).add("push_id", this.f12188t).add("highlight_enabled", this.f12191w).add("highlight_type", this.f12192x).add("highlight_state", this.f12193y).add("like_count", this.f12194z).add("seen_state", this.f12168A).toString();
    }
}
