package com.facebook.messaging.media.externalmedia;

import com.facebook.stickers.model.Sticker;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.collect.ImmutableList;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mCount */
public class ExternalMediaGraphQLResult {
    public final MediaType f11608a;
    public final String f11609b;
    public final String f11610c;
    public final Sticker f11611d;
    public final MediaResource f11612e;
    public final ImmutableList<MediaResource> f11613f;

    /* compiled from: mCount */
    public enum MediaType {
        STICKER,
        MEDIA_RESOURCE
    }

    public ExternalMediaGraphQLResult(MediaType mediaType, String str, String str2, Sticker sticker, MediaResource mediaResource, ImmutableList<MediaResource> immutableList) {
        this.f11608a = mediaType;
        this.f11609b = str;
        this.f11610c = str2;
        this.f11611d = sticker;
        this.f11612e = mediaResource;
        this.f11613f = immutableList;
    }
}
