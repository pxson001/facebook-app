package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command implements Parcelable {
    @Deprecated
    public static final Creator<Command> CREATOR = new C03301();
    public String f3575a;
    public String f3576b;
    public String f3577c;

    final class C03301 implements Creator<Command> {
        C03301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new Command(parcel);
        }

        public final Object[] newArray(int i) {
            return new Command[i];
        }
    }

    @Deprecated
    Command(Parcel parcel) {
        this.f3575a = parcel.readString();
        this.f3576b = parcel.readString();
        this.f3577c = parcel.readString();
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3575a);
        parcel.writeString(this.f3576b);
        parcel.writeString(this.f3577c);
    }
}
