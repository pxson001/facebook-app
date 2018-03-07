package com.facebook.katana.activity.codegenerator;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: sms_log_upsell_seen_today */
public class LegacyFetchCodeParams implements Parcelable {
    public static final Creator<FetchCodeParams> CREATOR = new C01051();
    public final String f2067a;
    public final String f2068b;
    public final String f2069c;

    /* compiled from: sms_log_upsell_seen_today */
    final class C01051 implements Creator<FetchCodeParams> {
        C01051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FetchCodeParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new FetchCodeParams[i];
        }
    }

    public LegacyFetchCodeParams(String str, String str2, String str3) {
        this.f2067a = str;
        this.f2068b = str2;
        this.f2069c = str3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2067a);
        parcel.writeString(this.f2068b);
        parcel.writeString(this.f2069c);
    }
}
