package com.facebook.platform.server.protocol;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.IOException;

/* compiled from: fetch_news_feed_streaming */
public class UploadStagingResourcePhotoMethod$Params implements Parcelable {
    public static final Creator<UploadStagingResourcePhotoMethod$Params> CREATOR = new C09911();
    public final String f14941a;
    public final Bitmap f14942b;

    /* compiled from: fetch_news_feed_streaming */
    final class C09911 implements Creator<UploadStagingResourcePhotoMethod$Params> {
        C09911() {
        }

        public final Object createFromParcel(Parcel parcel) {
            try {
                return new UploadStagingResourcePhotoMethod$Params(parcel);
            } catch (IOException e) {
                return null;
            }
        }

        public final Object[] newArray(int i) {
            return new UploadStagingResourcePhotoMethod$Params[i];
        }
    }

    public UploadStagingResourcePhotoMethod$Params(String str, Bitmap bitmap) {
        this.f14941a = str;
        this.f14942b = bitmap;
    }

    public UploadStagingResourcePhotoMethod$Params(Parcel parcel) {
        this.f14941a = parcel.readString();
        this.f14942b = (Bitmap) parcel.readParcelable(null);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f14941a);
        parcel.writeParcelable(this.f14942b, i);
    }
}
