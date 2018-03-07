package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: iconId */
public class EditPhotoLocationParams implements Parcelable {
    public static final Creator<EditPhotoLocationParams> CREATOR = new C08341();
    public final String f12926a;
    public final String f12927b;
    public final String f12928c;

    /* compiled from: iconId */
    final class C08341 implements Creator<EditPhotoLocationParams> {
        C08341() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EditPhotoLocationParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new EditPhotoLocationParams[i];
        }
    }

    public EditPhotoLocationParams(String str, String str2, @Nullable String str3) {
        this.f12926a = str;
        this.f12927b = str2;
        this.f12928c = str3;
    }

    public EditPhotoLocationParams(Parcel parcel) {
        this.f12926a = parcel.readString();
        this.f12927b = parcel.readString();
        this.f12928c = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12926a);
        parcel.writeString(this.f12927b);
        parcel.writeString(this.f12928c);
    }
}
