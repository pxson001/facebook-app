package com.facebook.profile.inforequest.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.List;

/* compiled from: loadWasFromUserAction */
public class InfoRequestParams implements Parcelable {
    public static final Creator<InfoRequestParams> CREATOR = new C12761();
    public final String f8574a;
    public final List<String> f8575b;
    public final String f8576c;

    /* compiled from: loadWasFromUserAction */
    final class C12761 implements Creator<InfoRequestParams> {
        C12761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new InfoRequestParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new InfoRequestParams[i];
        }
    }

    public InfoRequestParams(String str, List<String> list, String str2) {
        this.f8574a = str;
        this.f8575b = list;
        this.f8576c = str2;
    }

    public InfoRequestParams(Parcel parcel) {
        this.f8574a = parcel.readString();
        this.f8575b = parcel.readArrayList(String.class.getClassLoader());
        this.f8576c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8574a);
        parcel.writeList(this.f8575b);
        parcel.writeString(this.f8576c);
    }
}
