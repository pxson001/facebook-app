package com.facebook.pages.common.actionbar.blueservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;

/* compiled from: step_title */
public class ReportPlaceParams implements Parcelable {
    public static final Creator<ReportPlaceParams> CREATOR = new C01801();
    public final String f1354a;
    public final String f1355b;
    public final CrowdEntryPoint f1356c;
    public final CrowdEndpoint f1357d;

    /* compiled from: step_title */
    final class C01801 implements Creator<ReportPlaceParams> {
        C01801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportPlaceParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportPlaceParams[i];
        }
    }

    public ReportPlaceParams(String str, String str2, CrowdEntryPoint crowdEntryPoint, CrowdEndpoint crowdEndpoint) {
        this.f1354a = str;
        this.f1355b = str2;
        this.f1356c = crowdEntryPoint;
        this.f1357d = crowdEndpoint;
    }

    public ReportPlaceParams(Parcel parcel) {
        this.f1354a = parcel.readString();
        this.f1355b = parcel.readString();
        this.f1356c = CrowdEntryPoint.valueOf(parcel.readString());
        this.f1357d = CrowdEndpoint.valueOf(parcel.readString());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1354a);
        parcel.writeString(this.f1355b);
        parcel.writeString(this.f1356c.toString());
        parcel.writeString(this.f1357d.toString());
    }

    public int describeContents() {
        return 0;
    }
}
