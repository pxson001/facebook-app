package com.facebook.platform.auth.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.io.Serializable;

/* compiled from: location_selector */
public class AuthorizeAppMethod$Params implements Parcelable {
    public static final Creator<AuthorizeAppMethod$Params> CREATOR = new C12601();
    public final String f8455a;
    public final String f8456b;
    public final Optional<String> f8457c;
    public final Optional<String> f8458d;
    public final Optional<Boolean> f8459e;

    /* compiled from: location_selector */
    final class C12601 implements Creator<AuthorizeAppMethod$Params> {
        C12601() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AuthorizeAppMethod$Params(parcel);
        }

        public final Object[] newArray(int i) {
            return new AuthorizeAppMethod$Params[i];
        }
    }

    /* compiled from: location_selector */
    public class Builder {
        public final String f8450a;
        public final String f8451b;
        public Optional<String> f8452c = Absent.INSTANCE;
        public Optional<String> f8453d = Absent.INSTANCE;
        public Optional<Boolean> f8454e = Absent.INSTANCE;

        public Builder(String str, String str2) {
            this.f8450a = str;
            this.f8451b = str2;
        }
    }

    private AuthorizeAppMethod$Params(String str, String str2, Optional<String> optional, Optional<String> optional2, Optional<Boolean> optional3) {
        this.f8455a = str;
        this.f8456b = str2;
        this.f8457c = optional;
        this.f8458d = optional2;
        this.f8459e = optional3;
    }

    public AuthorizeAppMethod$Params(Parcel parcel) {
        this.f8455a = parcel.readString();
        this.f8456b = parcel.readString();
        this.f8457c = Optional.fromNullable(parcel.readString());
        this.f8458d = Optional.fromNullable(parcel.readString());
        this.f8459e = Optional.fromNullable((Boolean) parcel.readSerializable());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8455a);
        parcel.writeString(this.f8456b);
        parcel.writeString((String) this.f8457c.orNull());
        parcel.writeString((String) this.f8458d.orNull());
        parcel.writeSerializable((Serializable) this.f8459e.orNull());
    }
}
