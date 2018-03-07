package com.facebook.fbreact.pageserviceaddedit;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: executing */
public class PhotoData implements Parcelable {
    public static final Creator<PhotoData> CREATOR = new C09361();
    public final String f7397a;
    public final String f7398b;
    public final int f7399c;
    public final int f7400d;

    /* compiled from: executing */
    final class C09361 implements Creator<PhotoData> {
        C09361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoData(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoData[i];
        }
    }

    public PhotoData(String str, String str2, int i, int i2) {
        this.f7397a = str;
        this.f7398b = str2;
        this.f7399c = i;
        this.f7400d = i2;
    }

    public PhotoData(Parcel parcel) {
        this.f7397a = parcel.readString();
        this.f7398b = parcel.readString();
        this.f7399c = parcel.readInt();
        this.f7400d = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7397a);
        parcel.writeString(this.f7398b);
        parcel.writeInt(this.f7399c);
        parcel.writeInt(this.f7400d);
    }

    public int describeContents() {
        return 0;
    }
}
