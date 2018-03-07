package com.facebook.privacy.checkup.photofeed;

import android.content.Context;
import com.facebook.feed.rows.photosfeed.CanLaunchMediaGallery;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.consumptiongallery.snowflake.SnowflakeMediaGalleryHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Small */
public class PrivacyFeedMediaGalleryLauncher implements CanLaunchMediaGallery {
    private final SnowflakeMediaGalleryHelper f11053a;
    private final Context f11054b;
    private final AnimationParamProvider f11055c;

    @Inject
    public PrivacyFeedMediaGalleryLauncher(SnowflakeMediaGalleryHelper snowflakeMediaGalleryHelper, @Assisted Context context, @Nullable @Assisted AnimationParamProvider animationParamProvider) {
        this.f11053a = snowflakeMediaGalleryHelper;
        this.f11054b = context;
        this.f11055c = animationParamProvider;
    }

    public final void m11453a(MediaMetadata mediaMetadata, ImageRequest imageRequest, boolean z, int i) {
        this.f11053a.a(this.f11054b, ImmutableList.of(mediaMetadata), mediaMetadata.d(), this.f11055c, imageRequest, z, i, null, null);
    }
}
