package com.facebook.payments.contactinfo.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;

/* compiled from: bundle_topic_model */
public class EmailContactInfo implements ContactInfo {
    public static final Creator<EmailContactInfo> CREATOR = new C21741();
    private String f18680a;
    public String f18681b;
    private boolean f18682c;

    /* compiled from: bundle_topic_model */
    final class C21741 implements Creator<EmailContactInfo> {
        C21741() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EmailContactInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new EmailContactInfo[i];
        }
    }

    public static EmailContactInfoBuilder newBuilder() {
        return new EmailContactInfoBuilder();
    }

    public EmailContactInfo(Parcel parcel) {
        this.f18680a = parcel.readString();
        this.f18681b = parcel.readString();
        this.f18682c = ParcelUtil.a(parcel);
    }

    public final String mo736a() {
        return this.f18680a;
    }

    public final boolean mo737b() {
        return this.f18682c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f18680a);
        parcel.writeString(this.f18681b);
        ParcelUtil.a(parcel, this.f18682c);
    }

    public int describeContents() {
        return 0;
    }
}
