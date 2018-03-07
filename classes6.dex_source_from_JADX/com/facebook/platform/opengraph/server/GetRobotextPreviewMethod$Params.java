package com.facebook.platform.opengraph.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: filePath == null */
public class GetRobotextPreviewMethod$Params implements Parcelable {
    public static final Creator<GetRobotextPreviewMethod$Params> CREATOR = new C09801();
    public final String f14904a;
    public final String f14905b;
    public final String f14906c;
    public final String f14907d;
    public final String f14908e;

    /* compiled from: filePath == null */
    final class C09801 implements Creator<GetRobotextPreviewMethod$Params> {
        C09801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GetRobotextPreviewMethod$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new GetRobotextPreviewMethod$Params[i];
        }
    }

    public GetRobotextPreviewMethod$Params(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null);
    }

    private GetRobotextPreviewMethod$Params(String str, String str2, String str3, String str4, String str5) {
        this.f14904a = str;
        this.f14905b = str2;
        this.f14906c = str3;
        this.f14907d = str4;
        this.f14908e = str5;
    }

    public GetRobotextPreviewMethod$Params(Parcel parcel) {
        this.f14904a = parcel.readString();
        this.f14905b = parcel.readString();
        this.f14906c = parcel.readString();
        this.f14907d = parcel.readString();
        this.f14908e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14904a);
        parcel.writeString(this.f14905b);
        parcel.writeString(this.f14906c);
        parcel.writeString(this.f14907d);
        parcel.writeString(this.f14908e);
    }
}
