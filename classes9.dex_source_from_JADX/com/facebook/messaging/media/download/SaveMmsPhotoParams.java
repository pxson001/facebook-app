package com.facebook.messaging.media.download;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mDismissUrl */
public class SaveMmsPhotoParams implements Parcelable {
    public static final Creator<SaveMmsPhotoParams> CREATOR = new C12991();
    public final Uri f11559a;

    /* compiled from: mDismissUrl */
    final class C12991 implements Creator<SaveMmsPhotoParams> {
        C12991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new SaveMmsPhotoParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new SaveMmsPhotoParams[i];
        }
    }

    public SaveMmsPhotoParams(Uri uri) {
        this.f11559a = uri;
    }

    public SaveMmsPhotoParams(Parcel parcel) {
        this.f11559a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f11559a, i);
    }
}
