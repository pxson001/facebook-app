package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.auth.component.AuthenticationResult;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.common.util.TriState;
import com.google.common.base.Preconditions;

/* compiled from: sync_feed */
public class AuthenticationResultImpl implements AuthenticationResult {
    public static final Creator<AuthenticationResult> CREATOR = new C00791();
    private final String f1495a;
    private final FacebookCredentials f1496b;
    private final String f1497c;
    private final TriState f1498d;
    private final String f1499e;
    private final String f1500f;

    /* compiled from: sync_feed */
    final class C00791 implements Creator<AuthenticationResult> {
        C00791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AuthenticationResultImpl(parcel);
        }

        public final Object[] newArray(int i) {
            return new AuthenticationResult[i];
        }
    }

    public AuthenticationResultImpl(String str, FacebookCredentials facebookCredentials, String str2, TriState triState, String str3, String str4) {
        this.f1495a = (String) Preconditions.checkNotNull(str);
        this.f1496b = facebookCredentials;
        this.f1497c = str2;
        if (triState == null) {
            triState = TriState.UNSET;
        }
        this.f1498d = triState;
        this.f1499e = str3;
        this.f1500f = str4;
    }

    public AuthenticationResultImpl(Parcel parcel) {
        this.f1495a = parcel.readString();
        this.f1496b = (FacebookCredentials) parcel.readParcelable(null);
        this.f1497c = parcel.readString();
        this.f1498d = TriState.fromDbValue(parcel.readInt());
        this.f1499e = parcel.readString();
        this.f1500f = parcel.readString();
    }

    public final String mo88a() {
        return this.f1495a;
    }

    public final FacebookCredentials mo89b() {
        return this.f1496b;
    }

    public final String mo90c() {
        return this.f1497c;
    }

    public final TriState mo91d() {
        return this.f1498d;
    }

    public final String mo92e() {
        return this.f1499e;
    }

    public final String mo93f() {
        return this.f1500f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1495a);
        parcel.writeParcelable(this.f1496b, i);
        parcel.writeString(this.f1497c);
        parcel.writeInt(this.f1498d.getDbValue());
        parcel.writeString(this.f1499e);
        parcel.writeString(this.f1500f);
    }
}
