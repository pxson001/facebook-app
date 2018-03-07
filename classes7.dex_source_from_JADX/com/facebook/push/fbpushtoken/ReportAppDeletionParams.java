package com.facebook.push.fbpushtoken;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: height_of_notification */
public class ReportAppDeletionParams implements Parcelable {
    public static final Creator<ReportAppDeletionParams> CREATOR = new C09941();
    public final String f11308a;
    public final String f11309b;

    /* compiled from: height_of_notification */
    final class C09941 implements Creator<ReportAppDeletionParams> {
        C09941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ReportAppDeletionParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new ReportAppDeletionParams[i];
        }
    }

    public ReportAppDeletionParams(String str, String str2) {
        this.f11308a = str;
        this.f11309b = str2;
    }

    public ReportAppDeletionParams(Parcel parcel) {
        this.f11308a = parcel.readString();
        this.f11309b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11308a);
        parcel.writeString(this.f11309b);
    }
}
