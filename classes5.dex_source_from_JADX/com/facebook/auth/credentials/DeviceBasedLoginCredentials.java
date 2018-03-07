package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.infer.annotation.PrivacySource;
import javax.annotation.Nullable;

/* compiled from: taggedIds */
public class DeviceBasedLoginCredentials implements LoginCredentials {
    public static final Creator<DeviceBasedLoginCredentials> CREATOR = new C01381();
    @PrivacySource
    public final String f2256a;
    @PrivacySource
    public final String f2257b;
    @PrivacySource
    public final String f2258c;
    public final Type f2259d;

    /* compiled from: taggedIds */
    final class C01381 implements Creator<DeviceBasedLoginCredentials> {
        C01381() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeviceBasedLoginCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeviceBasedLoginCredentials[i];
        }
    }

    /* compiled from: taggedIds */
    public enum Type {
        DEVICE_BASED_LOGIN_TYPE("device_based_login");
        
        private final String mServerValue;

        private Type(String str) {
            this.mServerValue = str;
        }

        @Nullable
        public final String getServerValue() {
            return this.mServerValue;
        }
    }

    public DeviceBasedLoginCredentials(String str, String str2, String str3, Type type) {
        this.f2256a = str;
        this.f2257b = str2;
        this.f2258c = str3;
        this.f2259d = type;
    }

    public DeviceBasedLoginCredentials(Parcel parcel) {
        this.f2256a = parcel.readString();
        this.f2257b = parcel.readString();
        this.f2258c = parcel.readString();
        this.f2259d = (Type) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2256a);
        parcel.writeString(this.f2257b);
        parcel.writeString(this.f2258c);
        parcel.writeSerializable(this.f2259d);
    }
}
