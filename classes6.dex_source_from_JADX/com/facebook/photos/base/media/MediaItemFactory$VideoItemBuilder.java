package com.facebook.photos.base.media;

import android.net.Uri;
import com.facebook.ipc.media.MediaIdKey;
import com.facebook.ipc.media.data.LocalMediaData;
import com.facebook.ipc.media.data.MediaData.Builder;
import com.facebook.ipc.media.data.MediaData.Type;
import com.facebook.ipc.media.data.MimeType;
import javax.annotation.Nullable;

/* compiled from: initiator */
public class MediaItemFactory$VideoItemBuilder {
    long f12725a = 0;
    long f12726b = 0;
    public String f12727c = null;
    public long f12728d = -1;
    @Nullable
    public LocalMediaData f12729e = null;
    @Nullable
    String f12730f = null;
    public long f12731g = 0;
    private String f12732h = "";
    public Builder f12733i = new Builder().a(Uri.EMPTY).a(Type.Video);
    public LocalMediaData.Builder f12734j = new LocalMediaData.Builder();

    public final MediaItemFactory$VideoItemBuilder m20104a(LocalMediaData localMediaData) {
        this.f12729e = localMediaData;
        return this;
    }

    public final MediaItemFactory$VideoItemBuilder m20103a(long j) {
        this.f12725a = j;
        return this;
    }

    public final MediaItemFactory$VideoItemBuilder m20106b(long j) {
        this.f12728d = j;
        return this;
    }

    @Deprecated
    public final MediaItemFactory$VideoItemBuilder m20107b(String str) {
        this.f12733i.a(MediaItemFactory.b(str));
        this.f12732h = str;
        return this;
    }

    @Deprecated
    public final MediaItemFactory$VideoItemBuilder m20108c(String str) {
        this.f12733i.a(MimeType.a(str));
        return this;
    }

    public final VideoItem m20105a() {
        if (this.f12729e == null) {
            this.f12733i.a(new MediaIdKey(this.f12732h, this.f12731g).toString());
            this.f12729e = this.f12734j.a(this.f12733i.a()).a();
        }
        return new VideoItem(this);
    }
}
