package com.facebook.reportaproblem.base.bugreport.file;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: contentActionIndex */
public class BugReportFile implements Parcelable {
    public static final Creator<BugReportFile> CREATOR = new C04921();
    private final String f5241a;
    public final String f5242b;
    private final String f5243c;

    /* compiled from: contentActionIndex */
    final class C04921 implements Creator<BugReportFile> {
        C04921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new BugReportFile(parcel);
        }

        public final Object[] newArray(int i) {
            return new BugReportFile[i];
        }
    }

    public BugReportFile(String str, String str2, String str3) {
        this.f5241a = str;
        this.f5242b = str2;
        this.f5243c = str3;
    }

    public final String m10142a() {
        return this.f5241a;
    }

    public final String m10143b() {
        return this.f5242b;
    }

    public final String m10144c() {
        return this.f5243c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f5241a);
        parcel.writeString(this.f5242b);
        parcel.writeString(this.f5243c);
    }

    public BugReportFile(Parcel parcel) {
        this.f5241a = parcel.readString();
        this.f5242b = parcel.readString();
        this.f5243c = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BugReportFile bugReportFile = (BugReportFile) obj;
        if (!this.f5241a.equals(bugReportFile.f5241a)) {
            return false;
        }
        if (!this.f5242b.equals(bugReportFile.f5242b)) {
            return false;
        }
        if (this.f5243c.equals(bugReportFile.f5243c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5241a.hashCode() * 31) + this.f5242b.hashCode()) * 31) + this.f5243c.hashCode();
    }
}
