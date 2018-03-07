package com.facebook.photos.upload.protocol;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: getLocale */
public final class PhotoUploadPrivacy implements Parcelable {
    public static final Creator<PhotoUploadPrivacy> CREATOR = new C09151();
    public static final PhotoUploadPrivacy f14020a = new PhotoUploadPrivacy("");
    public static final PhotoUploadPrivacy f14021b = new PhotoUploadPrivacy("{\"value\":\"SELF\"}");
    public static final PhotoUploadPrivacy f14022c = new PhotoUploadPrivacy("{\"value\":\"ALL_FRIENDS\"}");
    public static final PhotoUploadPrivacy f14023d = new PhotoUploadPrivacy("{\"value\":\"EVERYONE\"}");
    public final String f14024e;

    /* compiled from: getLocale */
    final class C09151 implements Creator<PhotoUploadPrivacy> {
        C09151() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoUploadPrivacy(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoUploadPrivacy[i];
        }
    }

    public PhotoUploadPrivacy(String str) {
        this.f14024e = str;
    }

    public PhotoUploadPrivacy(Parcel parcel) {
        this.f14024e = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14024e);
    }
}
