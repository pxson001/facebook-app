package com.facebook.push.fbpushtoken;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.push.registration.ServiceType;

/* compiled from: identifier_value */
public class RegisterPushTokenParams implements Parcelable {
    public static final Creator<RegisterPushTokenParams> CREATOR = new C04781();
    private final ServiceType f10519a;
    public final String f10520b;
    public final String f10521c;
    public final String f10522d;
    public final boolean f10523e;
    public final int f10524f;
    public final int f10525g;
    public final long f10526h;

    /* compiled from: identifier_value */
    final class C04781 implements Creator<RegisterPushTokenParams> {
        C04781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new RegisterPushTokenParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new RegisterPushTokenParams[i];
        }
    }

    public RegisterPushTokenParams(ServiceType serviceType, String str, String str2, boolean z, int i, int i2, long j, String str3) {
        this.f10519a = serviceType;
        this.f10520b = str;
        this.f10521c = str2;
        this.f10523e = z;
        this.f10524f = i;
        this.f10525g = i2;
        this.f10526h = j;
        this.f10522d = str3;
    }

    public RegisterPushTokenParams(Parcel parcel) {
        this.f10519a = (ServiceType) parcel.readSerializable();
        this.f10520b = parcel.readString();
        this.f10521c = parcel.readString();
        this.f10523e = parcel.readInt() == 1;
        this.f10524f = parcel.readInt();
        this.f10525g = parcel.readInt();
        this.f10526h = parcel.readLong();
        this.f10522d = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f10519a);
        parcel.writeString(this.f10520b);
        parcel.writeString(this.f10521c);
        parcel.writeInt(this.f10523e ? 1 : 0);
        parcel.writeInt(this.f10524f);
        parcel.writeInt(this.f10525g);
        parcel.writeLong(this.f10526h);
        parcel.writeString(this.f10522d);
    }
}
