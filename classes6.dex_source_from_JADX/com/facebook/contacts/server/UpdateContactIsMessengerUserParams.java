package com.facebook.contacts.server;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.parcels.ParcelUtil;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: packFragment */
public class UpdateContactIsMessengerUserParams implements Parcelable {
    public static final Creator<UpdateContactIsMessengerUserParams> CREATOR = new C05461();
    public final String f8461a;
    public final boolean f8462b;

    /* compiled from: packFragment */
    final class C05461 implements Creator<UpdateContactIsMessengerUserParams> {
        C05461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new UpdateContactIsMessengerUserParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new UpdateContactIsMessengerUserParams[i];
        }
    }

    public UpdateContactIsMessengerUserParams(String str, boolean z) {
        this.f8461a = str;
        this.f8462b = z;
    }

    public UpdateContactIsMessengerUserParams(Parcel parcel) {
        this.f8461a = parcel.readString();
        this.f8462b = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8461a);
        ParcelUtil.a(parcel, this.f8462b);
    }

    public String toString() {
        return "UpdateContactIsMessengerUserParams {contactRepresentedProfileFbId = '" + this.f8461a + '\'' + ", isMessengerUser = " + this.f8462b + '}';
    }
}
