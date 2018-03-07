package com.facebook.goodfriends.data;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: mSrcUrlBigWebp */
public class FriendData implements Parcelable {
    public static final Creator<FriendData> CREATOR = new C06681();
    public final String f10888a;
    public final String f10889b;
    public final Uri f10890c;
    public Status f10891d;
    public final String f10892e;

    /* compiled from: mSrcUrlBigWebp */
    final class C06681 implements Creator<FriendData> {
        C06681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FriendData(parcel);
        }

        public final Object[] newArray(int i) {
            return new FriendData[i];
        }
    }

    /* compiled from: mSrcUrlBigWebp */
    public enum Status {
        NOT_SELECTED,
        SUGGESTED,
        SELECTED
    }

    public FriendData(String str, String str2, Uri uri, Status status, String str3) {
        this.f10888a = str;
        this.f10889b = str2;
        this.f10890c = uri;
        this.f10891d = status;
        this.f10892e = str3;
    }

    protected FriendData(Parcel parcel) {
        this.f10888a = parcel.readString();
        this.f10889b = parcel.readString();
        this.f10890c = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f10891d = Status.values()[parcel.readInt()];
        this.f10892e = parcel.readString();
    }

    public final boolean m17446b() {
        return this.f10891d == Status.SELECTED;
    }

    public final String m17447c() {
        return this.f10888a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10888a);
        parcel.writeString(this.f10889b);
        parcel.writeParcelable(this.f10890c, i);
        parcel.writeInt(this.f10891d.ordinal());
        parcel.writeString(this.f10892e);
    }
}
