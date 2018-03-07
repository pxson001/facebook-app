package com.facebook.auth.component;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: tagged_id */
public class AccountSwitchingAuthenticationResult implements Parcelable {
    public static final Creator<AccountSwitchingAuthenticationResult> CREATOR = new C01371();
    @Nullable
    public final String f2252a;
    @Nullable
    public final String f2253b;
    public final AuthenticationResult f2254c;

    /* compiled from: tagged_id */
    final class C01371 implements Creator<AccountSwitchingAuthenticationResult> {
        C01371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AccountSwitchingAuthenticationResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new AccountSwitchingAuthenticationResult[i];
        }
    }

    public AccountSwitchingAuthenticationResult(@Nullable String str, @Nullable String str2, AuthenticationResult authenticationResult) {
        this.f2252a = str;
        this.f2253b = str2;
        this.f2254c = authenticationResult;
    }

    AccountSwitchingAuthenticationResult(Parcel parcel) {
        this.f2252a = parcel.readString();
        this.f2253b = parcel.readString();
        this.f2254c = (AuthenticationResult) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2252a);
        parcel.writeString(this.f2253b);
        parcel.writeParcelable(this.f2254c, i);
    }
}
