package com.facebook.api.ufiservices.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.fbservice.service.DataFreshnessParam;
import javax.annotation.Nullable;

/* compiled from: android_phone_app */
public class FetchNodeListParams implements Parcelable {
    public static final Creator<FetchNodeListParams> CREATOR = new C09901();
    public final String f10299a;
    public final int f10300b;
    public final String f10301c;
    public final String f10302d;
    public final DataFreshnessParam f10303e;

    /* compiled from: android_phone_app */
    final class C09901 implements Creator<FetchNodeListParams> {
        C09901() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchNodeListParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchNodeListParams[i];
        }
    }

    public FetchNodeListParams(String str, int i, @Nullable String str2, @Nullable String str3, DataFreshnessParam dataFreshnessParam) {
        this.f10299a = str;
        this.f10300b = i;
        this.f10301c = str2;
        this.f10302d = str3;
        this.f10303e = dataFreshnessParam;
    }

    protected FetchNodeListParams(Parcel parcel) {
        this.f10299a = parcel.readString();
        this.f10300b = parcel.readInt();
        this.f10301c = parcel.readString();
        this.f10302d = parcel.readString();
        this.f10303e = DataFreshnessParam.valueOf(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10299a);
        parcel.writeInt(this.f10300b);
        parcel.writeString(this.f10301c);
        parcel.writeString(this.f10302d);
        parcel.writeString(this.f10303e.toString());
    }

    public int describeContents() {
        return 0;
    }
}
