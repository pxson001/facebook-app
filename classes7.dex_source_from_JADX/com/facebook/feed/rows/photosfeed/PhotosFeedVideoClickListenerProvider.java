package com.facebook.feed.rows.photosfeed;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;

/* compiled from: _graphCallback */
public class PhotosFeedVideoClickListenerProvider extends AbstractAssistedProvider<PhotosFeedVideoClickListener> {
    public final PhotosFeedVideoClickListener m23465a(MediaMetadata mediaMetadata, boolean z, CanLaunchMediaGallery canLaunchMediaGallery, ImageRequest imageRequest) {
        return new PhotosFeedVideoClickListener(mediaMetadata, z, canLaunchMediaGallery, imageRequest, FullscreenVideoPlayerLauncher.b(this));
    }
}
