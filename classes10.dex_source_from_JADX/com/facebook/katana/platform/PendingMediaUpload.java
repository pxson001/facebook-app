package com.facebook.katana.platform;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: two_line_composer_view */
public class PendingMediaUpload implements Parcelable {
    public static final Creator<PendingMediaUpload> CREATOR = new C01871();
    public final String f1115a;
    public final String f1116b;

    /* compiled from: two_line_composer_view */
    final class C01871 implements Creator<PendingMediaUpload> {
        C01871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PendingMediaUpload(parcel);
        }

        public final Object[] newArray(int i) {
            return new PendingMediaUpload[i];
        }
    }

    public PendingMediaUpload(String str, String str2) {
        this.f1115a = str;
        this.f1116b = str2;
    }

    public PendingMediaUpload(Parcel parcel) {
        this.f1115a = parcel.readString();
        this.f1116b = parcel.readString();
    }

    public final String m1145b() {
        return this.f1116b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1115a);
        parcel.writeString(this.f1116b);
    }
}
