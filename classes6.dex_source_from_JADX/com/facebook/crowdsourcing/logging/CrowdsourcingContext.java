package com.facebook.crowdsourcing.logging;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: opening_page */
public class CrowdsourcingContext implements Parcelable {
    public static final Creator<CrowdsourcingContext> CREATOR = new C05691();
    public final CrowdEntryPoint f8648a;
    public final CrowdEndpoint f8649b;

    /* compiled from: opening_page */
    final class C05691 implements Creator<CrowdsourcingContext> {
        C05691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CrowdsourcingContext(parcel);
        }

        public final Object[] newArray(int i) {
            return new CrowdsourcingContext[i];
        }
    }

    public CrowdsourcingContext(CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
        this.f8648a = crowdEntryPoint;
        this.f8649b = crowdEndpoint;
    }

    public CrowdsourcingContext(Parcel parcel) {
        this.f8648a = CrowdEntryPoint.valueOf(parcel.readString());
        this.f8649b = CrowdEndpoint.valueOf(parcel.readString());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8648a.name());
        parcel.writeString(this.f8649b.name());
    }
}
