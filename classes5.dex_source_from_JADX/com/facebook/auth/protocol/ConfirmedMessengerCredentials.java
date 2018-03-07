package com.facebook.auth.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Calendar;
import javax.annotation.Nullable;

/* compiled from: supports_audio_suggestions */
public class ConfirmedMessengerCredentials implements Parcelable {
    public static final Creator<ConfirmedMessengerCredentials> CREATOR = new C01431();
    public final String f2313a;
    public final String f2314b;
    public final String f2315c;
    public final String f2316d;
    @Nullable
    public final Calendar f2317e;

    /* compiled from: supports_audio_suggestions */
    final class C01431 implements Creator<ConfirmedMessengerCredentials> {
        C01431() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ConfirmedMessengerCredentials(parcel);
        }

        public final Object[] newArray(int i) {
            return new ConfirmedMessengerCredentials[i];
        }
    }

    public ConfirmedMessengerCredentials(Parcel parcel) {
        this.f2313a = parcel.readString();
        this.f2314b = parcel.readString();
        this.f2315c = parcel.readString();
        this.f2316d = parcel.readString();
        this.f2317e = (Calendar) parcel.readSerializable();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f2313a);
        parcel.writeString(this.f2314b);
        parcel.writeString(this.f2315c);
        parcel.writeString(this.f2316d);
        parcel.writeSerializable(this.f2317e);
    }
}
