package com.facebook.payments.contactinfo.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: browser_prefetch_load_url_cache_miss_pity */
public class PhoneNumberContactInfo implements ContactInfo {
    public static final Creator<PhoneNumberContactInfo> CREATOR = new C21761();
    private String f18687a;
    public String f18688b;
    private boolean f18689c;

    /* compiled from: browser_prefetch_load_url_cache_miss_pity */
    final class C21761 implements Creator<PhoneNumberContactInfo> {
        C21761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhoneNumberContactInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhoneNumberContactInfo[i];
        }
    }

    public static PhoneNumberContactInfoBuilder newBuilder() {
        return new PhoneNumberContactInfoBuilder();
    }

    public PhoneNumberContactInfo(Parcel parcel) {
        this.f18687a = parcel.readString();
        this.f18688b = parcel.readString();
        this.f18689c = ParcelUtil.a(parcel);
    }

    public final String mo736a() {
        return this.f18687a;
    }

    public final boolean mo737b() {
        return this.f18689c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18687a);
        parcel.writeString(this.f18688b);
        ParcelUtil.a(parcel, this.f18689c);
    }

    public int describeContents() {
        return 0;
    }
}
