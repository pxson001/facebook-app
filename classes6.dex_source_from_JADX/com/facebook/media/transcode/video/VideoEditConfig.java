package com.facebook.media.transcode.video;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* compiled from: keyword_semantic */
public class VideoEditConfig implements Parcelable {
    public static final Creator<VideoEditConfig> CREATOR = new C07551();
    boolean f11870a;
    int f11871b;
    int f11872c;
    int f11873d;
    boolean f11874e;
    RectF f11875f;

    /* compiled from: keyword_semantic */
    final class C07551 implements Creator<VideoEditConfig> {
        C07551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoEditConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoEditConfig[i];
        }
    }

    /* compiled from: keyword_semantic */
    public class Builder {
        public boolean f11864a = false;
        public int f11865b = -1;
        public int f11866c = -2;
        public int f11867d;
        public boolean f11868e;
        public RectF f11869f;
    }

    public VideoEditConfig(Parcel parcel) {
        boolean z = true;
        this.f11870a = parcel.readInt() == 1;
        this.f11871b = parcel.readInt();
        this.f11872c = parcel.readInt();
        this.f11873d = parcel.readInt();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.f11874e = z;
        this.f11875f = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
    }

    public VideoEditConfig(Builder builder) {
        this.f11870a = builder.f11864a;
        this.f11871b = builder.f11865b;
        this.f11872c = builder.f11866c;
        this.f11873d = builder.f11867d;
        this.f11874e = builder.f11868e;
        this.f11875f = builder.f11869f;
    }

    public static VideoEditConfig m18830a() {
        VideoEditConfig videoEditConfig = new VideoEditConfig();
        videoEditConfig.f11870a = false;
        videoEditConfig.f11871b = -1;
        videoEditConfig.f11872c = -2;
        videoEditConfig.f11873d = 0;
        videoEditConfig.f11874e = false;
        videoEditConfig.f11875f = null;
        return videoEditConfig;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f11870a ? 1 : 0);
        parcel.writeInt(this.f11871b);
        parcel.writeInt(this.f11872c);
        parcel.writeInt(this.f11873d);
        if (!this.f11874e) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeParcelable(this.f11875f, 0);
    }
}
