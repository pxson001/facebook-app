package com.facebook.tagging.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: deltaPageAdminReply */
public class FetchGroupMembersParams implements Parcelable {
    public static final Creator<FetchGroupMembersParams> CREATOR = new C12811();
    public final long f17566a;
    public final String f17567b;
    public final int f17568c;

    /* compiled from: deltaPageAdminReply */
    final class C12811 implements Creator<FetchGroupMembersParams> {
        C12811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchGroupMembersParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchGroupMembersParams[i];
        }
    }

    /* compiled from: deltaPageAdminReply */
    public class Builder {
        public long f17563a;
        public String f17564b;
        public int f17565c = 50;
    }

    public FetchGroupMembersParams(long j, String str, int i) {
        this.f17566a = j;
        this.f17567b = str;
        this.f17568c = i;
    }

    public FetchGroupMembersParams(Parcel parcel) {
        this.f17566a = parcel.readLong();
        this.f17567b = parcel.readString();
        this.f17568c = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f17566a);
        parcel.writeString(this.f17567b);
        parcel.writeInt(this.f17568c);
    }
}
