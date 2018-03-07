package com.facebook.auth.login.ui;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: profile_intro_card */
public class AuthFragmentConfig<T extends AuthFragmentControlBase> implements Parcelable {
    public static final Creator<AuthFragmentConfig> CREATOR = new C04301();
    public final Class<? extends AuthFragmentViewGroup<T>> f7366a;
    public final Bundle f7367b;

    /* compiled from: profile_intro_card */
    final class C04301 implements Creator<AuthFragmentConfig> {
        C04301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new AuthFragmentConfig(parcel);
            } catch (ClassNotFoundException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new AuthFragmentConfig[i];
        }
    }

    public AuthFragmentConfig(Parcel parcel) {
        this.f7366a = Class.forName(parcel.readString());
        this.f7367b = (Bundle) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f7366a.getCanonicalName());
        parcel.writeParcelable(this.f7367b, i);
    }
}
