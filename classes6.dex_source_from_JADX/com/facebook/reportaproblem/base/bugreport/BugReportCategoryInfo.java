package com.facebook.reportaproblem.base.bugreport;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: shortcutAlertIcon */
public class BugReportCategoryInfo implements Parcelable {
    public static final Creator<BugReportCategoryInfo> CREATOR = new C02691();
    public final String f4541a;
    public final long f4542b;
    public final int f4543c;

    /* compiled from: shortcutAlertIcon */
    final class C02691 implements Creator<BugReportCategoryInfo> {
        C02691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BugReportCategoryInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new BugReportCategoryInfo[i];
        }
    }

    public BugReportCategoryInfo(String str, long j, int i) {
        this.f4541a = str;
        this.f4542b = j;
        this.f4543c = i;
    }

    public final long m7037b() {
        return this.f4542b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4541a);
        parcel.writeLong(this.f4542b);
        parcel.writeInt(this.f4543c);
    }

    public BugReportCategoryInfo(Parcel parcel) {
        this.f4541a = parcel.readString();
        this.f4542b = parcel.readLong();
        this.f4543c = parcel.readInt();
    }
}
