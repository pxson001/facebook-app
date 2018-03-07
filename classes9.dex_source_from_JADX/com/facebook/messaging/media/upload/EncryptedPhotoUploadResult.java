package com.facebook.messaging.media.upload;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;

/* compiled from: location_never_ask_again_shown */
public class EncryptedPhotoUploadResult implements Parcelable {
    public static final Creator<EncryptedPhotoUploadResult> CREATOR = new C13361();
    public final String f11825a;
    public final Uri f11826b;
    public final Status f11827c;
    @Nullable
    public final String f11828d;

    /* compiled from: location_never_ask_again_shown */
    final class C13361 implements Creator<EncryptedPhotoUploadResult> {
        C13361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new EncryptedPhotoUploadResult(parcel);
        }

        public final Object[] newArray(int i) {
            return new EncryptedPhotoUploadResult[i];
        }
    }

    /* compiled from: location_never_ask_again_shown */
    public enum Status {
        Success,
        Failure
    }

    public EncryptedPhotoUploadResult(String str, Uri uri, Status status, String str2) {
        this.f11825a = str;
        this.f11826b = uri;
        this.f11827c = status;
        this.f11828d = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11825a);
        parcel.writeString(this.f11826b.toString());
        parcel.writeString(this.f11827c.name());
        parcel.writeString(this.f11828d);
    }

    public EncryptedPhotoUploadResult(Parcel parcel) {
        this.f11825a = parcel.readString();
        this.f11826b = Uri.parse(parcel.readString());
        this.f11827c = Status.valueOf(parcel.readString());
        this.f11828d = parcel.readString();
    }
}
