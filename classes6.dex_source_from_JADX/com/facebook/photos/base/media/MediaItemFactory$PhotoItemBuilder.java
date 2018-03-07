package com.facebook.photos.base.media;

import android.net.Uri;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import javax.annotation.Nullable;

/* compiled from: initiator */
public class MediaItemFactory$PhotoItemBuilder {
    public long f12714a = 0;
    long f12715b = 0;
    boolean f12716c = false;
    boolean f12717d = false;
    @Nullable
    String f12718e = null;
    @Nullable
    public LocalMediaData f12719f = null;
    @Nullable
    String f12720g = null;
    private long f12721h = 0;
    private String f12722i = "";
    private Builder f12723j = new Builder().a(Uri.EMPTY).a(Type.Photo);
    public LocalMediaData.Builder f12724k = new LocalMediaData.Builder();

    public final MediaItemFactory$PhotoItemBuilder m20095a(LocalMediaData localMediaData) {
        this.f12719f = localMediaData;
        return this;
    }

    public final MediaItemFactory$PhotoItemBuilder m20094a(long j) {
        this.f12715b = j;
        return this;
    }

    public final MediaItemFactory$PhotoItemBuilder m20097a(boolean z) {
        this.f12716c = z;
        return this;
    }

    public final MediaItemFactory$PhotoItemBuilder m20100b(boolean z) {
        this.f12717d = z;
        return this;
    }

    public final MediaItemFactory$PhotoItemBuilder m20096a(String str) {
        this.f12718e = str;
        return this;
    }

    @Deprecated
    public final MediaItemFactory$PhotoItemBuilder m20101c(long j) {
        this.f12721h = j;
        this.f12724k.d = j;
        return this;
    }

    @Deprecated
    public final MediaItemFactory$PhotoItemBuilder m20099b(String str) {
        this.f12723j.a(MediaItemFactory.b(str));
        this.f12722i = str;
        return this;
    }

    @Deprecated
    public final MediaItemFactory$PhotoItemBuilder m20102d(String str) {
        this.f12723j.a(MimeType.a(str));
        return this;
    }

    @Deprecated
    public final MediaItemFactory$PhotoItemBuilder m20093a(int i) {
        this.f12723j.e = i;
        return this;
    }

    public final PhotoItem m20098a() {
        if (this.f12719f == null) {
            this.f12723j.a(new MediaIdKey(this.f12722i, this.f12721h).toString());
            this.f12719f = this.f12724k.a(this.f12723j.a()).a();
        }
        return new PhotoItem(this);
    }
}
