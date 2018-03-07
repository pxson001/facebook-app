package com.facebook.goodwill.feed.rows;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: feed_share_action_bottom */
public class ThrowbackFriend implements Parcelable {
    public static final Creator<ThrowbackFriend> CREATOR = new C14391();
    public final String f13575a;
    public final String f13576b;
    public final String f13577c;
    public final String f13578d;

    /* compiled from: feed_share_action_bottom */
    final class C14391 implements Creator<ThrowbackFriend> {
        C14391() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ThrowbackFriend(parcel);
        }

        public final Object[] newArray(int i) {
            return new ThrowbackFriend[i];
        }
    }

    public ThrowbackFriend(String str, String str2, String str3, String str4) {
        this.f13575a = str;
        this.f13576b = str2;
        this.f13577c = str3;
        this.f13578d = str4;
    }

    public ThrowbackFriend(Parcel parcel) {
        this.f13575a = parcel.readString();
        this.f13576b = parcel.readString();
        this.f13577c = parcel.readString();
        this.f13578d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f13575a);
        parcel.writeString(this.f13576b);
        parcel.writeString(this.f13577c);
        parcel.writeString(this.f13578d);
    }
}
