package com.facebook.feed.rows.photosfeed;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;

/* compiled from: activity_picker_load_failed */
public interface CanLaunchMediaGallery extends AnyEnvironment {
    void mo1483a(MediaMetadata mediaMetadata, ImageRequest imageRequest, boolean z, int i);
}
