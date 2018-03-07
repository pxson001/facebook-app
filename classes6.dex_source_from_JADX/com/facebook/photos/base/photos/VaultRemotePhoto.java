package com.facebook.photos.base.photos;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.photos.base.photos.Photo.PhotoSize;
import com.facebook.ui.images.base.UrlImageProcessor;
import com.facebook.ui.images.cache.ImageCacheKey.Options;
import com.facebook.ui.images.cache.ImageCacheKey.OptionsBuilder;
import com.facebook.ui.images.fetch.FetchImageParams;
import com.facebook.ui.images.fetch.FetchImageParams.Builder;
import com.google.common.base.Objects;

/* compiled from: initial_location_info */
public class VaultRemotePhoto extends VaultPhoto {
    public static final Creator<VaultRemotePhoto> CREATOR = new C08091();
    private String f12763c;
    private long f12764d;

    /* compiled from: initial_location_info */
    final class C08091 implements Creator<VaultRemotePhoto> {
        C08091() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VaultRemotePhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new VaultRemotePhoto[i];
        }
    }

    /* compiled from: initial_location_info */
    class RemotePhotoImageProcessor extends UrlImageProcessor {
        private final String f12762b;

        public RemotePhotoImageProcessor(PhotoSize photoSize) {
            this.f12762b = ":" + photoSize;
        }

        public final Bitmap mo1096a(Bitmap bitmap) {
            return bitmap;
        }

        public final String mo1097a() {
            return this.f12762b;
        }
    }

    public VaultRemotePhoto(long j, String str, long j2) {
        this.f12744a = j;
        this.f12763c = str;
        this.f12764d = j2;
    }

    public VaultRemotePhoto(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
        this.f12763c = parcel.readString();
        this.f12764d = parcel.readLong();
    }

    public final FetchImageParams mo1095a(PhotoSize photoSize) {
        if (this.f12763c == null) {
            return null;
        }
        UrlImageProcessor remotePhotoImageProcessor;
        OptionsBuilder newBuilder = Options.newBuilder();
        switch (photoSize) {
            case SCREENNAIL:
                newBuilder.a(true);
                remotePhotoImageProcessor = new RemotePhotoImageProcessor(PhotoSize.SCREENNAIL);
                break;
            case THUMBNAIL:
                newBuilder.a(240, 240);
                remotePhotoImageProcessor = new RemotePhotoImageProcessor(PhotoSize.THUMBNAIL);
                break;
            default:
                throw new IllegalArgumentException("unknown size: " + photoSize);
        }
        Options f = newBuilder.f();
        Builder a = FetchImageParams.a(Uri.parse(this.f12763c));
        a.d = remotePhotoImageProcessor;
        Builder builder = a;
        builder.e = f;
        return builder.a();
    }

    public final long mo1098b() {
        return this.f12764d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12744a);
        parcel.writeParcelable(this.f12745b, i);
        parcel.writeString(this.f12763c);
        parcel.writeLong(this.f12764d);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VaultRemotePhoto)) {
            return false;
        }
        VaultRemotePhoto vaultRemotePhoto = (VaultRemotePhoto) obj;
        if (Objects.equal(Long.valueOf(this.f12744a), Long.valueOf(vaultRemotePhoto.f12744a)) && Objects.equal(this.f12745b, vaultRemotePhoto.f12745b) && Objects.equal(this.f12763c, vaultRemotePhoto.f12763c) && Objects.equal(Long.valueOf(this.f12764d), Long.valueOf(vaultRemotePhoto.f12764d))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f12744a), this.f12745b, this.f12763c, Long.valueOf(this.f12764d)});
    }
}
