package com.facebook.ipc.videoeditgallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.StringRes;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import javax.annotation.Nullable;

/* compiled from: place_question_subtitle */
public class VideoEditGalleryLaunchConfiguration implements Parcelable {
    public static final Creator<VideoEditGalleryLaunchConfiguration> CREATOR = new C05571();
    public final VideoEditFeature f6201a;
    @Nullable
    public final String f6202b;
    @Nullable
    public final VideoCreativeEditingData f6203c;
    public final boolean f6204d;
    public final boolean f6205e;
    public final boolean f6206f;
    public final boolean f6207g;
    public final boolean f6208h;
    public final int f6209i;
    public final int f6210j;
    public final int f6211k;
    @StringRes
    public final int f6212l;

    /* compiled from: place_question_subtitle */
    final class C05571 implements Creator<VideoEditGalleryLaunchConfiguration> {
        C05571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoEditGalleryLaunchConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoEditGalleryLaunchConfiguration[i];
        }
    }

    /* compiled from: place_question_subtitle */
    public class Builder {
        private VideoEditFeature f6189a = VideoEditFeature.TRIM;
        public String f6190b = null;
        @Nullable
        public VideoCreativeEditingData f6191c = null;
        public boolean f6192d = false;
        public boolean f6193e = false;
        public boolean f6194f = false;
        public boolean f6195g = false;
        public boolean f6196h = false;
        private int f6197i = 1000;
        public int f6198j = -1;
        @StringRes
        public int f6199k = -1;
        public int f6200l = 0;

        public Builder(VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration) {
            this.f6189a = videoEditGalleryLaunchConfiguration.f6201a;
            this.f6190b = videoEditGalleryLaunchConfiguration.f6202b;
            this.f6191c = videoEditGalleryLaunchConfiguration.f6203c;
            this.f6192d = videoEditGalleryLaunchConfiguration.f6205e;
            this.f6193e = videoEditGalleryLaunchConfiguration.f6206f;
            this.f6194f = videoEditGalleryLaunchConfiguration.f6204d;
            this.f6195g = videoEditGalleryLaunchConfiguration.f6207g;
            this.f6196h = videoEditGalleryLaunchConfiguration.f6208h;
            this.f6197i = videoEditGalleryLaunchConfiguration.f6209i;
            this.f6198j = videoEditGalleryLaunchConfiguration.f6210j;
            this.f6199k = videoEditGalleryLaunchConfiguration.f6212l;
            this.f6200l = videoEditGalleryLaunchConfiguration.f6211k;
        }

        public final Builder m8067a(VideoEditFeature videoEditFeature) {
            if (videoEditFeature != null) {
                this.f6189a = videoEditFeature;
            }
            return this;
        }

        public final VideoEditGalleryLaunchConfiguration m8068a() {
            return new VideoEditGalleryLaunchConfiguration(this.f6189a, this.f6190b, this.f6191c, this.f6192d, this.f6193e, this.f6194f, this.f6195g, this.f6196h, this.f6197i, this.f6198j, this.f6199k, this.f6200l);
        }
    }

    private VideoEditGalleryLaunchConfiguration(VideoEditFeature videoEditFeature, String str, VideoCreativeEditingData videoCreativeEditingData, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, int i2, @StringRes int i3, int i4) {
        this.f6201a = videoEditFeature;
        this.f6202b = str;
        this.f6203c = videoCreativeEditingData;
        this.f6205e = z;
        this.f6206f = z2;
        this.f6204d = z3;
        this.f6207g = z4;
        this.f6208h = z5;
        this.f6209i = i;
        this.f6210j = i2;
        this.f6212l = i3;
        this.f6211k = i4;
    }

    public final boolean m8069d() {
        return this.f6205e;
    }

    public final boolean m8070e() {
        return this.f6206f;
    }

    public final boolean m8071g() {
        return this.f6207g;
    }

    public final boolean m8072h() {
        return this.f6208h;
    }

    public final int m8073i() {
        return this.f6209i;
    }

    public final int m8074j() {
        return this.f6210j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f6201a);
        parcel.writeString(this.f6202b);
        parcel.writeParcelable(this.f6203c, 0);
        ParcelUtil.a(parcel, this.f6205e);
        ParcelUtil.a(parcel, this.f6206f);
        ParcelUtil.a(parcel, this.f6204d);
        ParcelUtil.a(parcel, this.f6207g);
        ParcelUtil.a(parcel, this.f6208h);
        parcel.writeInt(this.f6209i);
        parcel.writeInt(this.f6210j);
        parcel.writeInt(this.f6212l);
        parcel.writeInt(this.f6211k);
    }

    public VideoEditGalleryLaunchConfiguration(Parcel parcel) {
        this.f6201a = (VideoEditFeature) ParcelUtil.c(parcel, VideoEditFeature.class);
        this.f6202b = parcel.readString();
        this.f6203c = (VideoCreativeEditingData) parcel.readParcelable(VideoCreativeEditingData.class.getClassLoader());
        this.f6205e = ParcelUtil.a(parcel);
        this.f6206f = ParcelUtil.a(parcel);
        this.f6204d = ParcelUtil.a(parcel);
        this.f6207g = ParcelUtil.a(parcel);
        this.f6208h = ParcelUtil.a(parcel);
        this.f6209i = parcel.readInt();
        this.f6210j = parcel.readInt();
        this.f6212l = parcel.readInt();
        this.f6211k = parcel.readInt();
    }
}
