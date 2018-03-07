package com.facebook.commerce.core.intent;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: preview_text */
public class MerchantInfoViewData implements Parcelable {
    public static final Creator<MerchantInfoViewData> CREATOR = new C04491();
    public final String f7501a;
    public final String f7502b;
    public final String f7503c;
    public final int f7504d;
    public final String f7505e;
    public final String f7506f;

    /* compiled from: preview_text */
    final class C04491 implements Creator<MerchantInfoViewData> {
        C04491() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new MerchantInfoViewData(parcel);
        }

        public final Object[] newArray(int i) {
            return new MerchantInfoViewData[i];
        }
    }

    public MerchantInfoViewData(String str, String str2, String str3, int i, String str4, String str5) {
        this.f7501a = str;
        this.f7502b = str3;
        this.f7503c = str2;
        this.f7504d = i;
        this.f7505e = str4;
        this.f7506f = str5;
    }

    public int describeContents() {
        return 0;
    }

    public MerchantInfoViewData(Parcel parcel) {
        this.f7501a = parcel.readString();
        this.f7502b = parcel.readString();
        this.f7503c = parcel.readString();
        this.f7505e = parcel.readString();
        this.f7504d = parcel.readInt();
        this.f7506f = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7501a);
        parcel.writeString(this.f7502b);
        parcel.writeString(this.f7503c);
        parcel.writeString(this.f7505e);
        parcel.writeInt(this.f7504d);
        parcel.writeString(this.f7506f);
    }
}
