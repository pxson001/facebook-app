package com.facebook.photos.albums.video;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.photos.albums.video.VideoAlbumPermalinkActivity.VideoAlbumEntityType;

/* compiled from: confirmAccount/?normalized_contactpoint={%s}&contactpoint_type={%s} */
public class VideoAlbumPermalinkAdapterProvider extends AbstractAssistedProvider<VideoAlbumPermalinkAdapter> {
    public final VideoAlbumPermalinkAdapter m21353a(Long l, VideoAlbumEntityType videoAlbumEntityType) {
        return new VideoAlbumPermalinkAdapter(l, videoAlbumEntityType, IdBasedLazy.a(this, 3561), IdBasedLazy.a(this, 2164), IdBasedSingletonScopeProvider.b(this, 30));
    }
}
