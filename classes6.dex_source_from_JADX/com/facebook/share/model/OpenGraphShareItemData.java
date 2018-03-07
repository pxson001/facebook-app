package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: server_info_data */
public class OpenGraphShareItemData implements Parcelable {
    public static final Creator<OpenGraphShareItemData> CREATOR = new C02981();
    public final String f4901a;
    public final String f4902b;
    public final String f4903c;

    /* compiled from: server_info_data */
    final class C02981 implements Creator<OpenGraphShareItemData> {
        C02981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new OpenGraphShareItemData(parcel);
        }

        public final Object[] newArray(int i) {
            return new OpenGraphShareItemData[i];
        }
    }

    protected OpenGraphShareItemData(Parcel parcel) {
        this.f4901a = parcel.readString();
        this.f4902b = parcel.readString();
        this.f4903c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4901a);
        parcel.writeString(this.f4902b);
        parcel.writeString(this.f4903c);
    }
}
