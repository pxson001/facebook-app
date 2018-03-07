package com.facebook.platform.auth.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: location_selector */
public class AuthorizeAppMethod$Result implements Parcelable {
    public static final Creator<AuthorizeAppMethod$Result> CREATOR = new C12611();
    private final String f8460a;
    private final long f8461b;
    private final List<String> f8462c;

    /* compiled from: location_selector */
    final class C12611 implements Creator<AuthorizeAppMethod$Result> {
        C12611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AuthorizeAppMethod$Result(parcel);
        }

        public final Object[] newArray(int i) {
            return new AuthorizeAppMethod$Result[i];
        }
    }

    public AuthorizeAppMethod$Result(String str, long j, List<String> list) {
        this.f8460a = str;
        this.f8461b = j;
        this.f8462c = list;
    }

    public AuthorizeAppMethod$Result(Parcel parcel) {
        this.f8460a = parcel.readString();
        this.f8461b = parcel.readLong();
        this.f8462c = Lists.a();
        parcel.readStringList(this.f8462c);
    }

    public final String m8374a() {
        return this.f8460a;
    }

    public final List<String> m8375b() {
        return this.f8462c;
    }

    public final long m8376c() {
        return this.f8461b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8460a);
        parcel.writeLong(this.f8461b);
        parcel.writeStringList(this.f8462c);
    }
}
