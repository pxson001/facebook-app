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

/* compiled from: initial_privacy_override */
public class VaultLocalPhoto extends VaultPhoto {
    public static final Creator<VaultLocalPhoto> CREATOR = new C08071();
    private String f12757c;
    private int f12758d;
    private long f12759e;
    public String f12760f;

    /* compiled from: initial_privacy_override */
    final class C08071 implements Creator<VaultLocalPhoto> {
        C08071() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new VaultLocalPhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new VaultLocalPhoto[i];
        }
    }

    /* compiled from: initial_privacy_override */
    class LocalPhotoImageProcessor extends UrlImageProcessor {
        private final String f12756b;

        public LocalPhotoImageProcessor(int i, PhotoSize photoSize) {
            this.f12756b = ":" + i + ":" + photoSize;
        }

        public final Bitmap mo1096a(Bitmap bitmap) {
            return bitmap;
        }

        public final String mo1097a() {
            return this.f12756b;
        }
    }

    public VaultLocalPhoto(long j, String str, int i, long j2, String str2) {
        this.f12744a = j;
        this.f12757c = str;
        this.f12758d = i;
        this.f12759e = j2;
        this.f12760f = str2;
    }

    public VaultLocalPhoto(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
        this.f12757c = parcel.readString();
        this.f12758d = parcel.readInt();
        this.f12759e = parcel.readLong();
        this.f12760f = parcel.readString();
    }

    public final FetchImageParams mo1095a(PhotoSize photoSize) {
        if (this.f12757c == null) {
            return null;
        }
        UrlImageProcessor localPhotoImageProcessor;
        OptionsBuilder newBuilder = Options.newBuilder();
        switch (photoSize) {
            case SCREENNAIL:
                newBuilder.a(true);
                localPhotoImageProcessor = new LocalPhotoImageProcessor(this.f12758d, PhotoSize.SCREENNAIL);
                break;
            case THUMBNAIL:
                newBuilder.a(240, 240);
                localPhotoImageProcessor = new LocalPhotoImageProcessor(this.f12758d, PhotoSize.THUMBNAIL);
                break;
            default:
                throw new IllegalArgumentException("unknown size: " + photoSize);
        }
        Options f = newBuilder.f();
        Builder a = FetchImageParams.a(Uri.parse("file://" + this.f12757c));
        a.d = localPhotoImageProcessor;
        Builder builder = a;
        builder.e = f;
        return builder.a();
    }

    public final long mo1098b() {
        return this.f12759e;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f12744a);
        parcel.writeParcelable(this.f12745b, i);
        parcel.writeString(this.f12757c);
        parcel.writeInt(this.f12758d);
        parcel.writeLong(this.f12759e);
        parcel.writeString(this.f12760f);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof VaultLocalPhoto)) {
            return false;
        }
        VaultLocalPhoto vaultLocalPhoto = (VaultLocalPhoto) obj;
        if (Objects.equal(Long.valueOf(this.f12744a), Long.valueOf(vaultLocalPhoto.f12744a)) && Objects.equal(this.f12745b, vaultLocalPhoto.f12745b) && Objects.equal(this.f12757c, vaultLocalPhoto.f12757c) && Objects.equal(Integer.valueOf(this.f12758d), Integer.valueOf(vaultLocalPhoto.f12758d)) && Objects.equal(Long.valueOf(this.f12759e), Long.valueOf(vaultLocalPhoto.f12759e)) && Objects.equal(this.f12760f, vaultLocalPhoto.f12760f)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{Long.valueOf(this.f12744a), this.f12745b, this.f12757c, Long.valueOf(this.f12759e), this.f12760f});
    }
}
