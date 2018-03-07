package com.facebook.auth.login.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.collect.ImmutableMap;

/* compiled from: profPicURIMap */
public class AuthStateMachineConfig$ParcelableConfigInformation implements Parcelable {
    public static final Creator<AuthStateMachineConfig$ParcelableConfigInformation> CREATOR = new C04361();
    public ImmutableMap<String, AuthFragmentConfig<? extends AuthFragmentControlBase>> f7377a;
    public Class<? extends Object> f7378b;

    /* compiled from: profPicURIMap */
    final class C04361 implements Creator<AuthStateMachineConfig$ParcelableConfigInformation> {
        C04361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new AuthStateMachineConfig$ParcelableConfigInformation(parcel);
        }

        public final Object[] newArray(int i) {
            return new AuthStateMachineConfig$ParcelableConfigInformation[i];
        }
    }

    public AuthStateMachineConfig$ParcelableConfigInformation(Parcel parcel) {
        this.f7377a = ImmutableMap.copyOf(parcel.readHashMap(AuthFragmentConfig.class.getClassLoader()));
        try {
            this.f7378b = Class.forName(parcel.readString());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Parceled fragment class for auth start was incorrect: " + e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.f7377a);
        parcel.writeString(this.f7378b.getName());
    }
}
