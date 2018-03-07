package com.facebook.ipc.creativecam;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.media.SupportedMediaType;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Collection;

/* compiled from: places.db */
public class CreativeCamLaunchConfig implements Parcelable {
    public static final Creator<CreativeCamLaunchConfig> CREATOR = new C05541();
    public final boolean f6165a;
    public final boolean f6166b;
    public final boolean f6167c;
    public final boolean f6168d;
    public final boolean f6169e;
    public final SupportedMediaType f6170f;
    public final int f6171g;
    @Nullable
    public final ImmutableList<FramePack> f6172h;
    @Nullable
    public final String f6173i;
    @Nullable
    public final int f6174j;
    public final CreativeCamSource f6175k;
    private final AspectRatio f6176l;
    public final ComposerConfiguration f6177m;

    /* compiled from: places.db */
    final class C05541 implements Creator<CreativeCamLaunchConfig> {
        C05541() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new CreativeCamLaunchConfig(parcel);
        }

        public final Object[] newArray(int i) {
            return new CreativeCamLaunchConfig[i];
        }
    }

    /* compiled from: places.db */
    public enum AspectRatio {
        SQUARE,
        PORTRAIT_4_3
    }

    /* compiled from: places.db */
    public class Builder {
        private boolean f6152a;
        public boolean f6153b;
        public boolean f6154c;
        public boolean f6155d;
        public boolean f6156e;
        public SupportedMediaType f6157f;
        public int f6158g = 0;
        @Nullable
        public ImmutableList<FramePack> f6159h;
        @Nullable
        public String f6160i;
        @Nullable
        public int f6161j;
        public ComposerConfiguration f6162k;
        public CreativeCamSource f6163l = CreativeCamSource.UNKNOWN;
        private AspectRatio f6164m = AspectRatio.SQUARE;

        public final CreativeCamLaunchConfig m8045a() {
            return new CreativeCamLaunchConfig(this.f6152a, this.f6153b, this.f6154c, this.f6155d, this.f6156e, this.f6157f, this.f6158g, this.f6159h, this.f6160i, this.f6161j, this.f6162k, this.f6163l, this.f6164m);
        }
    }

    private CreativeCamLaunchConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, SupportedMediaType supportedMediaType, int i, @Nullable ImmutableList<FramePack> immutableList, @Nullable String str, @Nullable int i2, @Nullable ComposerConfiguration composerConfiguration, CreativeCamSource creativeCamSource, AspectRatio aspectRatio) {
        this.f6165a = z;
        this.f6166b = z2;
        this.f6167c = z3;
        this.f6168d = z4;
        this.f6169e = z5;
        this.f6170f = supportedMediaType;
        if (i == 1 && !this.f6170f.supportsVideos()) {
            this.f6171g = 0;
        } else if (i != 0 || this.f6170f.supportsPhotos()) {
            this.f6171g = i;
        } else {
            this.f6171g = 1;
        }
        this.f6172h = immutableList;
        this.f6173i = str;
        this.f6174j = i2;
        this.f6175k = creativeCamSource;
        if (this.f6173i != null) {
            boolean z6 = (this.f6172h == null || this.f6172h.isEmpty()) ? false : true;
            Preconditions.checkArgument(z6, "Initial frame id was set, but no frame pack was set");
        }
        this.f6177m = composerConfiguration;
        this.f6176l = aspectRatio;
    }

    public CreativeCamLaunchConfig(Parcel parcel) {
        this.f6165a = ParcelUtil.a(parcel);
        this.f6166b = ParcelUtil.a(parcel);
        this.f6167c = ParcelUtil.a(parcel);
        this.f6168d = ParcelUtil.a(parcel);
        this.f6169e = ParcelUtil.a(parcel);
        this.f6170f = (SupportedMediaType) ParcelUtil.c(parcel, SupportedMediaType.class);
        this.f6171g = parcel.readInt();
        Collection b = FlatBufferModelHelper.b(parcel);
        this.f6172h = b == null ? null : ImmutableList.copyOf(b);
        this.f6173i = parcel.readString();
        this.f6177m = (ComposerConfiguration) parcel.readParcelable(ComposerConfiguration.class.getClassLoader());
        this.f6174j = parcel.readInt();
        this.f6175k = (CreativeCamSource) ParcelUtil.c(parcel, CreativeCamSource.class);
        this.f6176l = (AspectRatio) ParcelUtil.c(parcel, AspectRatio.class);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ParcelUtil.a(parcel, this.f6165a);
        ParcelUtil.a(parcel, this.f6166b);
        ParcelUtil.a(parcel, this.f6167c);
        ParcelUtil.a(parcel, this.f6168d);
        ParcelUtil.a(parcel, this.f6169e);
        ParcelUtil.a(parcel, this.f6170f);
        parcel.writeInt(this.f6171g);
        FlatBufferModelHelper.a(parcel, this.f6172h);
        parcel.writeString(this.f6173i);
        parcel.writeParcelable(this.f6177m, i);
        parcel.writeInt(this.f6174j);
        ParcelUtil.a(parcel, this.f6175k);
        ParcelUtil.a(parcel, this.f6176l);
    }
}
