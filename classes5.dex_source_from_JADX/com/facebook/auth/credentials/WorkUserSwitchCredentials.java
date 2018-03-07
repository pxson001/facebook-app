package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.infer.annotation.PrivacySource;

/* compiled from: taggable_activity */
public class WorkUserSwitchCredentials implements LoginCredentials {
    public static final Creator<WorkUserSwitchCredentials> CREATOR = new C01401();
    @PrivacySource
    public final String f2262a;
    @PrivacySource
    public final String f2263b;
    @PrivacySource
    public final String f2264c;

    /* compiled from: taggable_activity */
    final class C01401 implements Creator<WorkUserSwitchCredentials> {
        C01401() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new WorkUserSwitchCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new WorkUserSwitchCredentials[i];
        }
    }

    public WorkUserSwitchCredentials(String str, String str2, String str3) {
        this.f2262a = str;
        this.f2263b = str2;
        this.f2264c = str3;
    }

    public WorkUserSwitchCredentials(Parcel parcel) {
        this.f2262a = parcel.readString();
        this.f2263b = parcel.readString();
        this.f2264c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2262a);
        parcel.writeString(this.f2263b);
        parcel.writeString(this.f2264c);
    }
}
