package com.facebook.messaging.media.upload.util;

import android.net.Uri;
import com.facebook.common.util.ExifOrientation;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.base.Objects;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: lastDisconnectionTimeStampMS= */
public class MediaUploadKey {
    public final Uri f12231a;
    public final Type f12232b;
    @Nullable
    public final String f12233c;
    public final ExifOrientation f12234d;
    public final int f12235e;
    public final int f12236f;

    public static MediaUploadKey m12720a(MediaResource mediaResource) {
        return new MediaUploadKey(mediaResource.c, mediaResource.d, mediaResource.D, mediaResource.l, mediaResource.s, mediaResource.t);
    }

    public static MediaUploadKey m12721b(MediaResource mediaResource) {
        if (mediaResource.h != null) {
            mediaResource = mediaResource.h;
        }
        return m12720a(mediaResource);
    }

    private MediaUploadKey(Uri uri, Type type, String str, ExifOrientation exifOrientation, int i, int i2) {
        this.f12231a = uri;
        this.f12232b = type;
        this.f12233c = str;
        this.f12234d = exifOrientation;
        this.f12235e = i;
        this.f12236f = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MediaUploadKey mediaUploadKey = (MediaUploadKey) obj;
        if (Objects.equal(this.f12231a, mediaUploadKey.f12231a) && Objects.equal(this.f12232b, mediaUploadKey.f12232b) && Objects.equal(this.f12233c, mediaUploadKey.f12233c) && Objects.equal(this.f12234d, mediaUploadKey.f12234d) && Objects.equal(Integer.valueOf(this.f12235e), Integer.valueOf(mediaUploadKey.f12235e)) && Objects.equal(Integer.valueOf(this.f12236f), Integer.valueOf(mediaUploadKey.f12236f))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f12231a, this.f12232b, this.f12233c, this.f12234d, Integer.valueOf(this.f12235e), Integer.valueOf(this.f12236f)});
    }
}
