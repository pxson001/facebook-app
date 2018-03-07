package com.facebook.composer.publish.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: photo_picker_galley_swipe_photos */
public class SimplePhotoUploadResult implements Parcelable {
    public static final Creator<SimplePhotoUploadResult> CREATOR = new C04921();
    private final String f8076a;
    private final String f8077b;

    /* compiled from: photo_picker_galley_swipe_photos */
    final class C04921 implements Creator<SimplePhotoUploadResult> {
        C04921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SimplePhotoUploadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new SimplePhotoUploadResult[i];
        }
    }

    public SimplePhotoUploadResult(String str, String str2) {
        this.f8076a = str;
        this.f8077b = str2;
    }

    public SimplePhotoUploadResult(Parcel parcel) {
        this.f8076a = parcel.readString();
        this.f8077b = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f8076a);
        parcel.writeString(this.f8077b);
    }
}
