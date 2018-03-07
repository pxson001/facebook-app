package com.facebook.timeline.profilevideo.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.creativeediting.model.VideoTrimParams;
import com.facebook.share.model.ComposerAppAttribution;
import com.facebook.video.creativeediting.model.VideoCreativeEditingData;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: mPageId */
public final class ProfileVideoModel implements Parcelable {
    public static final Creator<ProfileVideoModel> CREATOR = new C09781();
    public final Uri f9368a;
    public final int f9369b;
    public final int f9370c;
    public final int f9371d;
    public final VideoCreativeEditingData f9372e;
    public final String f9373f;
    public final long f9374g;
    public final ComposerAppAttribution f9375h;

    /* compiled from: mPageId */
    final class C09781 implements Creator<ProfileVideoModel> {
        C09781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new ProfileVideoModel(parcel);
        }

        public final Object[] newArray(int i) {
            return new ProfileVideoModel[i];
        }
    }

    /* compiled from: mPageId */
    public class Builder {
        public Uri f9360a;
        public int f9361b;
        public int f9362c;
        public int f9363d;
        public VideoCreativeEditingData f9364e;
        public String f9365f;
        public long f9366g;
        public ComposerAppAttribution f9367h;

        public Builder(ProfileVideoModel profileVideoModel) {
            this.f9360a = profileVideoModel.f9368a;
            this.f9361b = profileVideoModel.f9369b;
            this.f9362c = profileVideoModel.f9370c;
            this.f9363d = profileVideoModel.f9371d;
            this.f9364e = profileVideoModel.f9372e;
            this.f9365f = profileVideoModel.f9373f;
            this.f9366g = profileVideoModel.f9374g;
            this.f9367h = profileVideoModel.f9375h;
        }

        public final ProfileVideoModel m11121a() {
            return new ProfileVideoModel(this);
        }

        public final Builder m11120a(Uri uri) {
            this.f9360a = uri;
            return this;
        }
    }

    public ProfileVideoModel(Builder builder) {
        this.f9368a = builder.f9360a;
        this.f9369b = builder.f9361b;
        this.f9371d = builder.f9363d;
        this.f9372e = builder.f9364e;
        this.f9373f = builder.f9365f;
        this.f9374g = builder.f9366g;
        this.f9375h = builder.f9367h;
        int i = builder.f9362c;
        if (m11131h() > i) {
            i = m11131h();
        }
        if (i > m11132i()) {
            i = m11132i();
        }
        this.f9370c = i;
    }

    public ProfileVideoModel(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.f9368a = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f9369b = parcel.readInt();
        this.f9370c = parcel.readInt();
        this.f9371d = parcel.readInt();
        this.f9372e = (VideoCreativeEditingData) parcel.readParcelable(VideoCreativeEditingData.class.getClassLoader());
        this.f9373f = parcel.readString();
        this.f9374g = parcel.readLong();
        this.f9375h = (ComposerAppAttribution) parcel.readParcelable(ComposerAppAttribution.class.getClassLoader());
        if (m11131h() <= this.f9370c) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (this.f9370c > m11132i()) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public static ProfileVideoModel m11123a(Uri uri, int i, int i2, int i3, @Nullable ImageOverlayFieldsModel imageOverlayFieldsModel, @Nullable ComposerAppAttribution composerAppAttribution) {
        String str;
        boolean z;
        String str2 = null;
        if (imageOverlayFieldsModel == null || imageOverlayFieldsModel.d() == null) {
            str = null;
        } else {
            str = imageOverlayFieldsModel.d().a();
            str2 = imageOverlayFieldsModel.c();
        }
        com.facebook.video.creativeediting.model.VideoCreativeEditingData.Builder builder = new com.facebook.video.creativeediting.model.VideoCreativeEditingData.Builder();
        builder.a = m11122a(0, i, i, i2);
        builder = builder;
        builder.f = str;
        com.facebook.video.creativeediting.model.VideoCreativeEditingData.Builder builder2 = builder;
        builder2.g = str2;
        builder2 = builder2;
        if (1 == i3) {
            z = true;
        } else {
            z = false;
        }
        builder2.h = z;
        VideoCreativeEditingData a = builder2.a();
        Builder builder3 = new Builder();
        builder3.f9360a = uri;
        builder3 = builder3;
        builder3.f9361b = i;
        builder3 = builder3;
        builder3.f9362c = 0;
        builder3 = builder3;
        builder3.f9363d = i3;
        builder3 = builder3;
        builder3.f9364e = a;
        Builder builder4 = builder3;
        builder4.f9367h = composerAppAttribution;
        return builder4.m11121a();
    }

    public final Uri m11124a() {
        return this.f9368a;
    }

    public final String m11125b() {
        return this.f9368a.toString();
    }

    public final int m11126c() {
        return this.f9369b;
    }

    public final int m11127d() {
        return this.f9370c;
    }

    public final int m11128e() {
        return this.f9371d;
    }

    public final VideoCreativeEditingData m11129f() {
        return this.f9372e;
    }

    public final boolean m11130g() {
        return this.f9372e != null && this.f9372e.c();
    }

    public final int m11131h() {
        if (this.f9372e == null || this.f9372e.a() == null || !this.f9372e.a().isTrimSpecified) {
            return 0;
        }
        return this.f9372e.a().videoTrimStartTimeMs;
    }

    public final int m11132i() {
        if (this.f9372e == null || this.f9372e.a() == null || !this.f9372e.a().isTrimSpecified) {
            return this.f9369b;
        }
        return this.f9372e.a().videoTrimEndTimeMs;
    }

    public final long m11133j() {
        return this.f9374g;
    }

    public final ComposerAppAttribution m11134k() {
        return this.f9375h;
    }

    public final String m11135l() {
        return this.f9373f;
    }

    private static VideoTrimParams m11122a(int i, int i2, int i3, int i4) {
        com.facebook.photos.creativeediting.model.VideoTrimParams.Builder newBuilder = VideoTrimParams.newBuilder();
        if (i2 - i > i4) {
            i2 = i + i4;
        }
        if (!(i == 0 && i2 == i3)) {
            newBuilder.a(i, i2);
        }
        return newBuilder.a();
    }

    public final Builder m11136m() {
        return new Builder(this);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f9368a, i);
        parcel.writeInt(this.f9369b);
        parcel.writeInt(this.f9370c);
        parcel.writeInt(this.f9371d);
        parcel.writeParcelable(this.f9372e, i);
        parcel.writeString(this.f9373f);
        parcel.writeLong(this.f9374g);
        parcel.writeParcelable(this.f9375h, i);
    }

    public final int describeContents() {
        return 0;
    }
}
