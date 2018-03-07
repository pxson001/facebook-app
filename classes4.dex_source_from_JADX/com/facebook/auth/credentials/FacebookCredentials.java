package com.facebook.auth.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.infer.annotation.PrivacySource;
import javax.annotation.Nullable;

/* compiled from: sync_hit_max_sync_failure */
public class FacebookCredentials implements Parcelable {
    public static final Creator<FacebookCredentials> CREATOR = new C00781();
    @PrivacySource
    public final String f1489a;
    @PrivacySource
    public final String f1490b;
    @PrivacySource
    public final String f1491c;
    @PrivacySource
    public final String f1492d;
    @PrivacySource
    public final String f1493e;
    @PrivacySource
    public final String f1494f;

    /* compiled from: sync_hit_max_sync_failure */
    final class C00781 implements Creator<FacebookCredentials> {
        C00781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new FacebookCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new FacebookCredentials[i];
        }
    }

    public FacebookCredentials(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f1489a = str;
        this.f1490b = str2;
        this.f1491c = str3;
        this.f1492d = str4;
        this.f1493e = str5;
        this.f1494f = str6;
    }

    public FacebookCredentials(Parcel parcel) {
        this.f1489a = parcel.readString();
        this.f1490b = parcel.readString();
        this.f1491c = parcel.readString();
        this.f1492d = parcel.readString();
        this.f1493e = parcel.readString();
        this.f1494f = parcel.readString();
    }

    public final String m1698a() {
        return this.f1489a;
    }

    public final String m1699b() {
        return this.f1490b;
    }

    public final String m1700c() {
        return this.f1492d;
    }

    public final String m1701d() {
        return this.f1491c;
    }

    public final String m1702e() {
        return this.f1493e;
    }

    public final String m1703f() {
        return this.f1494f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1489a);
        parcel.writeString(this.f1490b);
        parcel.writeString(this.f1491c);
        parcel.writeString(this.f1492d);
        parcel.writeString(this.f1493e);
        parcel.writeString(this.f1494f);
    }
}
