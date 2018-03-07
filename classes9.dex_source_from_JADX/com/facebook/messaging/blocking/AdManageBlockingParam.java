package com.facebook.messaging.blocking;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: onboarding */
public class AdManageBlockingParam extends ManageBlockingParam {
    public static final Creator<ManageBlockingParam> CREATOR = new C09261();
    public final String f8244a;
    public final boolean f8245b;

    /* compiled from: onboarding */
    final class C09261 implements Creator<ManageBlockingParam> {
        C09261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AdManageBlockingParam(parcel);
        }

        public final Object[] newArray(int i) {
            return new AdManageBlockingParam[i];
        }
    }

    /* compiled from: onboarding */
    public class AdManageBlockingParamBuilder {
        public String f8241a;
        public boolean f8242b;
    }

    public AdManageBlockingParam(AdManageBlockingParamBuilder adManageBlockingParamBuilder) {
        this.f8244a = adManageBlockingParamBuilder.f8241a;
        this.f8245b = adManageBlockingParamBuilder.f8242b;
    }

    public AdManageBlockingParam(Parcel parcel) {
        this.f8244a = parcel.readString();
        this.f8245b = parcel.readInt() != 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8244a);
        parcel.writeInt(this.f8245b ? 1 : 0);
    }
}
