package com.facebook.privacy.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;

/* compiled from: staticDiskUri */
public final class SetPrivacyEducationStateParams implements Parcelable {
    public static final Creator<SetPrivacyEducationStateParams> CREATOR = new C02461();
    public final String f4190a;
    public final String f4191b;
    public final String f4192c;
    public final Long f4193d;

    /* compiled from: staticDiskUri */
    final class C02461 implements Creator<SetPrivacyEducationStateParams> {
        C02461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetPrivacyEducationStateParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetPrivacyEducationStateParams[i];
        }
    }

    /* compiled from: staticDiskUri */
    public enum EducationStateOperation {
        Seen("seen"),
        Dismissed("dismissed");
        
        private final String name;

        private EducationStateOperation(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public SetPrivacyEducationStateParams(String str, EducationStateOperation educationStateOperation, Long l) {
        this.f4190a = str;
        this.f4191b = educationStateOperation.toString();
        this.f4192c = "fb4a_permalink";
        this.f4193d = l;
    }

    public SetPrivacyEducationStateParams(Parcel parcel) {
        this.f4190a = parcel.readString();
        this.f4191b = parcel.readString();
        this.f4192c = parcel.readString();
        this.f4193d = Long.valueOf(parcel.readLong());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4190a);
        parcel.writeString(this.f4191b);
        parcel.writeString(this.f4192c);
        parcel.writeLong(this.f4193d.longValue());
    }

    public final String toString() {
        return Objects.toStringHelper(SetPrivacyEducationStateParams.class).add("educationType", this.f4190a).add("operation", this.f4191b).add("surface", this.f4192c).add("eventTime", this.f4193d).toString();
    }
}
