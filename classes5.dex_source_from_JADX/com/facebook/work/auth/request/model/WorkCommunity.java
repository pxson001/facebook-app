package com.facebook.work.auth.request.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: com.facebook.fragment.POP_ENTER_ANIM */
public class WorkCommunity implements Parcelable {
    public static final Creator<WorkCommunity> CREATOR = new C05341();
    public final String f5888a;
    public final String f5889b;
    private final String f5890c;
    private final String f5891d;
    public final String f5892e;

    /* compiled from: com.facebook.fragment.POP_ENTER_ANIM */
    final class C05341 implements Creator<WorkCommunity> {
        C05341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WorkCommunity(parcel);
        }

        public final Object[] newArray(int i) {
            return new WorkCommunity[i];
        }
    }

    public WorkCommunity(String str, String str2, String str3, String str4, String str5) {
        this.f5888a = str;
        this.f5889b = str2;
        this.f5890c = str3;
        this.f5891d = str4;
        this.f5892e = str5;
    }

    public final String m10617a() {
        return this.f5888a;
    }

    public final String m10618b() {
        return this.f5889b;
    }

    public final String m10619c() {
        return this.f5891d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5888a);
        parcel.writeString(this.f5889b);
        parcel.writeString(this.f5890c);
        parcel.writeString(this.f5891d);
        parcel.writeString(this.f5892e);
    }

    protected WorkCommunity(Parcel parcel) {
        this.f5888a = parcel.readString();
        this.f5889b = parcel.readString();
        this.f5890c = parcel.readString();
        this.f5891d = parcel.readString();
        this.f5892e = parcel.readString();
    }
}
