package com.facebook.photos.dialog;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.fbui.draggable.Direction;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: liveVideoCta */
public class PhotoAnimationDialogLaunchParams implements Parcelable {
    public static final Creator<PhotoAnimationDialogLaunchParams> CREATOR = new C08501();
    public final String f10111a;
    @Nullable
    public final String f10112b;
    public final int f10113c;
    public final FullscreenGallerySource f10114d;
    public final Direction f10115e;
    public final int f10116f;
    public final int f10117g;
    public final boolean f10118h;

    /* compiled from: liveVideoCta */
    final class C08501 implements Creator<PhotoAnimationDialogLaunchParams> {
        C08501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new PhotoAnimationDialogLaunchParams(parcel);
        }

        public final Object[] newArray(int i) {
            return new PhotoAnimationDialogLaunchParams[i];
        }
    }

    /* compiled from: liveVideoCta */
    public class Builder {
        private String f10103a;
        private String f10104b;
        private int f10105c = -1;
        private FullscreenGallerySource f10106d = null;
        private Direction f10107e;
        public int f10108f;
        public int f10109g;
        public boolean f10110h = true;

        public Builder(FullscreenGallerySource fullscreenGallerySource) {
            this.f10106d = fullscreenGallerySource;
        }

        public Builder(MediaGalleryLauncherParams mediaGalleryLauncherParams) {
            this.f10103a = mediaGalleryLauncherParams.f10691a;
            this.f10104b = mediaGalleryLauncherParams.f10696f;
            this.f10106d = mediaGalleryLauncherParams.f10707q;
            this.f10105c = mediaGalleryLauncherParams.f10706p;
            this.f10107e = mediaGalleryLauncherParams.f10709s;
            this.f10108f = mediaGalleryLauncherParams.f10710t;
            this.f10109g = 0;
        }

        public final Builder m11992a(Direction direction) {
            this.f10107e = (Direction) Preconditions.checkNotNull(direction);
            return this;
        }

        public final Builder m11993a(String str) {
            Preconditions.checkState(this.f10104b == null, "Multiple start id's set");
            this.f10104b = str;
            return this;
        }

        public final PhotoAnimationDialogLaunchParams m11994a() {
            Preconditions.checkNotNull(this.f10106d, "must set gallery source");
            Preconditions.checkNotNull(this.f10107e, "must set dismiss direction");
            if (this.f10110h) {
                boolean z;
                if (this.f10108f > 0) {
                    z = true;
                } else {
                    z = false;
                }
                Preconditions.checkArgument(z, "must set swipe dismiss direction flags");
            }
            return new PhotoAnimationDialogLaunchParams(this.f10103a, this.f10104b, this.f10105c, this.f10106d, this.f10107e, this.f10108f, this.f10109g, this.f10110h);
        }
    }

    private PhotoAnimationDialogLaunchParams(String str, @Nullable String str2, int i, FullscreenGallerySource fullscreenGallerySource, Direction direction, int i2, int i3, boolean z) {
        if (str == null) {
            str = SafeUUIDGenerator.a().toString();
        }
        this.f10111a = str;
        this.f10112b = str2;
        this.f10113c = i;
        this.f10114d = fullscreenGallerySource;
        this.f10115e = direction;
        this.f10116f = i2;
        this.f10117g = i3;
        this.f10118h = z;
    }

    public PhotoAnimationDialogLaunchParams(Parcel parcel) {
        this.f10111a = parcel.readString();
        this.f10112b = parcel.readString();
        this.f10113c = parcel.readInt();
        this.f10114d = FullscreenGallerySource.valueOf(parcel.readString());
        this.f10115e = Direction.valueOf(parcel.readString());
        this.f10116f = parcel.readInt();
        this.f10117g = parcel.readInt();
        this.f10118h = ParcelUtil.a(parcel);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f10111a);
        parcel.writeString(this.f10112b);
        parcel.writeInt(this.f10113c);
        parcel.writeString(this.f10114d.name());
        parcel.writeString(this.f10115e.name());
        parcel.writeInt(this.f10116f);
        parcel.writeInt(this.f10117g);
        ParcelUtil.a(parcel, this.f10118h);
    }
}
