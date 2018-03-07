package com.facebook.video.engine;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.spherical.model.SphericalVideoParams;
import com.facebook.video.analytics.VideoPlaybackAnalyticsParams;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.io.IOException;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: photo_thumb_uri */
public class VideoPlayerParams implements Parcelable, VideoPlaybackAnalyticsParams {
    public static final Creator<VideoPlayerParams> CREATOR = new C02121();
    public final ImmutableList<VideoDataSource> f4832a;
    public final String f4833b;
    public final int f4834c;
    public String f4835d;
    public final ArrayNode f4836e;
    public final boolean f4837f;
    public final boolean f4838g;
    public final boolean f4839h;
    public final boolean f4840i;
    public final boolean f4841j;
    public final boolean f4842k;
    public final int f4843l;
    public final int f4844m;
    public final int f4845n;
    public final boolean f4846o;
    public final int f4847p;
    public final int f4848q;
    public final int f4849r;
    @Nullable
    public final SphericalVideoParams f4850s;

    /* compiled from: photo_thumb_uri */
    final class C02121 implements Creator<VideoPlayerParams> {
        C02121() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VideoPlayerParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new VideoPlayerParams[i];
        }
    }

    VideoPlayerParams(VideoPlayerParamsBuilder videoPlayerParamsBuilder) {
        int i;
        this.f4832a = ImmutableList.copyOf(videoPlayerParamsBuilder.f4851a);
        this.f4833b = videoPlayerParamsBuilder.f4852b;
        this.f4834c = videoPlayerParamsBuilder.f4853c;
        this.f4835d = videoPlayerParamsBuilder.f4854d;
        this.f4836e = videoPlayerParamsBuilder.f4855e;
        this.f4837f = videoPlayerParamsBuilder.f4856f;
        this.f4840i = videoPlayerParamsBuilder.f4857g;
        this.f4847p = videoPlayerParamsBuilder.f4859i;
        this.f4848q = videoPlayerParamsBuilder.f4860j;
        this.f4838g = videoPlayerParamsBuilder.f4869s;
        this.f4839h = videoPlayerParamsBuilder.f4858h;
        this.f4849r = videoPlayerParamsBuilder.f4861k;
        this.f4850s = videoPlayerParamsBuilder.f4862l;
        this.f4841j = videoPlayerParamsBuilder.f4863m;
        this.f4842k = videoPlayerParamsBuilder.f4864n;
        this.f4843l = videoPlayerParamsBuilder.f4865o;
        if (videoPlayerParamsBuilder.f4866p <= 0) {
            i = videoPlayerParamsBuilder.f4853c;
        } else {
            i = videoPlayerParamsBuilder.f4866p;
        }
        this.f4844m = i;
        this.f4845n = videoPlayerParamsBuilder.f4867q;
        this.f4846o = videoPlayerParamsBuilder.f4868r;
    }

    public static VideoPlayerParamsBuilder newBuilder() {
        return new VideoPlayerParamsBuilder();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VideoPlayerParams)) {
            return false;
        }
        VideoPlayerParams videoPlayerParams = (VideoPlayerParams) obj;
        if (Objects.equal(this.f4832a, videoPlayerParams.f4832a) && Objects.equal(this.f4833b, videoPlayerParams.f4833b) && Objects.equal(Integer.valueOf(this.f4834c), Integer.valueOf(videoPlayerParams.f4834c)) && Objects.equal(this.f4835d, videoPlayerParams.f4835d) && Objects.equal(this.f4836e, videoPlayerParams.f4836e) && Objects.equal(Boolean.valueOf(this.f4837f), Boolean.valueOf(videoPlayerParams.f4837f)) && Objects.equal(Boolean.valueOf(this.f4840i), Boolean.valueOf(videoPlayerParams.f4840i)) && Objects.equal(this.f4850s, videoPlayerParams.f4850s) && Objects.equal(Boolean.valueOf(this.f4842k), Boolean.valueOf(videoPlayerParams.f4842k)) && Objects.equal(Integer.valueOf(this.f4843l), Integer.valueOf(videoPlayerParams.f4843l)) && Objects.equal(Integer.valueOf(this.f4844m), Integer.valueOf(videoPlayerParams.f4844m)) && Objects.equal(Integer.valueOf(this.f4845n), Integer.valueOf(videoPlayerParams.f4845n)) && Objects.equal(Boolean.valueOf(this.f4838g), Boolean.valueOf(videoPlayerParams.f4838g)) && Objects.equal(Boolean.valueOf(this.f4846o), Boolean.valueOf(videoPlayerParams.f4846o))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f4832a, this.f4833b, Integer.valueOf(this.f4834c), this.f4835d, this.f4836e, Boolean.valueOf(this.f4837f), Boolean.valueOf(this.f4840i), this.f4850s, Boolean.valueOf(this.f4841j), Boolean.valueOf(this.f4842k), Integer.valueOf(this.f4843l), Integer.valueOf(this.f4844m), Integer.valueOf(this.f4845n), Boolean.valueOf(this.f4846o), Boolean.valueOf(this.f4838g)});
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeString(this.f4836e.toString());
        parcel.writeTypedList(this.f4832a);
        parcel.writeString(this.f4833b);
        parcel.writeInt(this.f4834c);
        parcel.writeString(this.f4835d);
        parcel.writeByte(this.f4837f ? (byte) 1 : (byte) 0);
        if (this.f4839h) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.f4840i) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.f4847p);
        parcel.writeInt(this.f4848q);
        parcel.writeInt(this.f4849r);
        parcel.writeParcelable(this.f4850s, i);
        if (this.f4841j) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.f4842k) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeInt(this.f4843l);
        parcel.writeInt(this.f4844m);
        parcel.writeInt(this.f4845n);
        if (this.f4846o) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (!this.f4838g) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
    }

    public VideoPlayerParams(Parcel parcel) {
        boolean z = true;
        try {
            boolean z2;
            this.f4836e = (ArrayNode) FbObjectMapper.i().a(parcel.readString());
            Builder builder = ImmutableList.builder();
            Iterable arrayList = new ArrayList();
            parcel.readTypedList(arrayList, VideoDataSource.CREATOR);
            builder.b(arrayList);
            this.f4832a = builder.b();
            this.f4833b = parcel.readString();
            this.f4834c = parcel.readInt();
            this.f4835d = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4837f = z2;
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4839h = z2;
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4840i = z2;
            this.f4847p = parcel.readInt();
            this.f4848q = parcel.readInt();
            this.f4849r = parcel.readInt();
            this.f4850s = (SphericalVideoParams) parcel.readParcelable(null);
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4841j = z2;
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4842k = z2;
            this.f4843l = parcel.readInt();
            this.f4844m = parcel.readInt();
            this.f4845n = parcel.readInt();
            if (parcel.readByte() != (byte) 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f4846o = z2;
            if (parcel.readByte() == (byte) 0) {
                z = false;
            }
            this.f4838g = z;
        } catch (IOException e) {
            throw new ParcelFormatException("Failed to process event " + e.toString());
        }
    }

    public final boolean m5255a() {
        return this.f4839h;
    }

    public final boolean m5256b() {
        return this.f4838g;
    }

    public final String m5257c() {
        return this.f4850s == null ? "" : "CUBEMAP";
    }
}
