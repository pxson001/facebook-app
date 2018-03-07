package com.facebook.messaging.model.attachment;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: user_reject_place_suggestion */
public class VideoData implements Parcelable {
    public static final Creator<VideoData> CREATOR = new C00801();
    public int f1895a;
    public int f1896b;
    public int f1897c;
    public int f1898d;
    public Source f1899e;
    public Uri f1900f;
    public Uri f1901g;

    /* compiled from: user_reject_place_suggestion */
    final class C00801 implements Creator<VideoData> {
        C00801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoData(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoData[i];
        }
    }

    /* compiled from: user_reject_place_suggestion */
    public enum Source {
        NONQUICKCAM(1, "FILE_ATTACHMENT"),
        QUICKCAM(2, "RECORDED_VIDEO");
        
        public final String apiStringValue;
        public final int intValue;

        private Source(int i, String str) {
            this.intValue = i;
            this.apiStringValue = str;
        }

        public static Source fromIntVal(int i) {
            if (i == QUICKCAM.intValue) {
                return QUICKCAM;
            }
            return NONQUICKCAM;
        }
    }

    public VideoData(int i, int i2, int i3, int i4, Source source, Uri uri, @Nullable Uri uri2) {
        this.f1895a = i;
        this.f1896b = i2;
        this.f1897c = i3;
        this.f1898d = i4;
        this.f1899e = source;
        this.f1900f = uri;
        this.f1901g = uri2;
    }

    public VideoData(Parcel parcel) {
        this.f1895a = parcel.readInt();
        this.f1896b = parcel.readInt();
        this.f1897c = parcel.readInt();
        this.f1898d = parcel.readInt();
        this.f1899e = Source.valueOf(parcel.readString());
        this.f1900f = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f1901g = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1895a);
        parcel.writeInt(this.f1896b);
        parcel.writeInt(this.f1897c);
        parcel.writeInt(this.f1898d);
        parcel.writeString(this.f1899e.name());
        parcel.writeParcelable(this.f1900f, i);
        parcel.writeParcelable(this.f1901g, i);
    }
}
