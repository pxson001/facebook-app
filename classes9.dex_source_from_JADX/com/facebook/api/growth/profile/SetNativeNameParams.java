package com.facebook.api.growth.profile;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;

/* compiled from: sendMessageToPendingThread */
public class SetNativeNameParams implements Parcelable {
    public static final Creator<SetNativeNameParams> CREATOR = new C03681();
    public final String f4043a;
    public final String f4044b;
    public final String f4045c;
    public final String f4046d;
    public final String f4047e;

    /* compiled from: sendMessageToPendingThread */
    final class C03681 implements Creator<SetNativeNameParams> {
        C03681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SetNativeNameParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SetNativeNameParams[i];
        }
    }

    public SetNativeNameParams(String str, String str2, String str3, String str4, String str5) {
        this.f4043a = str;
        this.f4044b = str2;
        this.f4045c = str3;
        this.f4046d = str4;
        this.f4047e = str5;
    }

    public SetNativeNameParams(Parcel parcel) {
        this.f4043a = parcel.readString();
        this.f4044b = parcel.readString();
        this.f4045c = parcel.readString();
        this.f4046d = parcel.readString();
        this.f4047e = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4043a);
        parcel.writeString(this.f4044b);
        parcel.writeString(this.f4045c);
        parcel.writeString(this.f4046d);
        parcel.writeString(this.f4047e);
    }

    public String toString() {
        ToStringHelper add = Objects.toStringHelper(this).add("first_name", this.f4043a).add("last_name", this.f4044b).add("locale", this.f4047e);
        if (this.f4045c != null) {
            add.add("first_name_extra", this.f4045c);
        }
        if (this.f4046d != null) {
            add.add("last_name_extra", this.f4046d);
        }
        return add.toString();
    }
}
