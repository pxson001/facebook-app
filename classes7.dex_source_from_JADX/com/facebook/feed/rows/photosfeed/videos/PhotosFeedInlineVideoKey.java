package com.facebook.feed.rows.photosfeed.videos;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;

/* compiled from: _from_ */
public class PhotosFeedInlineVideoKey implements ContextStateKey<String, PhotosFeedInlineVideoPersistentState> {
    private String f20344a;

    public PhotosFeedInlineVideoKey(MediaMetadata mediaMetadata) {
        this.f20344a = PhotosFeedInlineVideoKey.class.getSimpleName() + mediaMetadata.d();
    }

    public final Object m23466a() {
        return new PhotosFeedInlineVideoPersistentState();
    }

    public final Object m23467b() {
        return this.f20344a;
    }
}
