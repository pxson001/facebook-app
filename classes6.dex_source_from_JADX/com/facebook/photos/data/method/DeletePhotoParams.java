package com.facebook.photos.data.method;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: ignore_survey_id */
public class DeletePhotoParams implements Parcelable {
    public static final Creator<DeletePhotoParams> CREATOR = new C08301();
    public final String f12915a;

    /* compiled from: ignore_survey_id */
    final class C08301 implements Creator<DeletePhotoParams> {
        C08301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new DeletePhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new DeletePhotoParams[i];
        }
    }

    public DeletePhotoParams(String str) {
        this.f12915a = str;
    }

    public DeletePhotoParams(Parcel parcel) {
        this.f12915a = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12915a);
    }
}
