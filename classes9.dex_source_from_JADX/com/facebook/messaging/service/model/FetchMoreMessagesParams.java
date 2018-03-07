package com.facebook.messaging.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.messaging.model.threadkey.ThreadKey;

/* compiled from: createCursor returns null. */
public class FetchMoreMessagesParams implements Parcelable {
    public static final Creator<FetchMoreMessagesParams> CREATOR = new C20151();
    public final ThreadKey f17066a;
    public final String f17067b;
    public final long f17068c;
    public final int f17069d;

    /* compiled from: createCursor returns null. */
    final class C20151 implements Creator<FetchMoreMessagesParams> {
        C20151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchMoreMessagesParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchMoreMessagesParams[i];
        }
    }

    public FetchMoreMessagesParams(ThreadKey threadKey, String str, long j, int i) {
        this.f17066a = threadKey;
        this.f17067b = str;
        this.f17068c = j;
        this.f17069d = i;
    }

    public FetchMoreMessagesParams(Parcel parcel) {
        this.f17066a = (ThreadKey) parcel.readParcelable(ThreadKey.class.getClassLoader());
        this.f17067b = parcel.readString();
        this.f17068c = parcel.readLong();
        this.f17069d = parcel.readInt();
    }

    public final ThreadKey m17086a() {
        return this.f17066a;
    }

    public final long m17087c() {
        return this.f17068c;
    }

    public final int m17088d() {
        return this.f17069d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f17066a, i);
        parcel.writeString(this.f17067b);
        parcel.writeLong(this.f17068c);
        parcel.writeInt(this.f17069d);
    }
}
