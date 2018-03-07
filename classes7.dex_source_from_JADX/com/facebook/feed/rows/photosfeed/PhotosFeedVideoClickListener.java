package com.facebook.feed.rows.photosfeed;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStory.Builder;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import javax.inject.Inject;

/* compiled from: _graphFailure */
public class PhotosFeedVideoClickListener implements OnClickListener {
    private final MediaMetadata f20337a;
    private final boolean f20338b;
    private final CanLaunchMediaGallery f20339c;
    private final ImageRequest f20340d;
    private final FullscreenVideoPlayerLauncher f20341e;
    private GraphQLVideo f20342f;

    @Inject
    public PhotosFeedVideoClickListener(@Assisted MediaMetadata mediaMetadata, @Assisted boolean z, @Assisted CanLaunchMediaGallery canLaunchMediaGallery, @Assisted ImageRequest imageRequest, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher) {
        this.f20337a = mediaMetadata;
        this.f20341e = fullscreenVideoPlayerLauncher;
        this.f20339c = canLaunchMediaGallery;
        this.f20338b = z;
        this.f20340d = imageRequest;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1401383585);
        if (this.f20338b) {
            this.f20339c.mo1483a(this.f20337a, this.f20340d, false, -1);
        } else {
            if (this.f20342f == null) {
                MediaMetadata mediaMetadata = this.f20337a;
                GraphQLFeedback a2 = PhotosMetadataConversionHelper.a(mediaMetadata.C());
                Builder a3 = Builder.a(PhotosMetadataConversionHelper.a(mediaMetadata.z()));
                a3.D = a2;
                GraphQLStory a4 = a3.a();
                GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
                builder.H = mediaMetadata.d();
                builder = builder;
                builder.u = a4;
                GraphQLVideo.Builder builder2 = builder;
                builder2.aH = mediaMetadata.P();
                builder2 = builder2;
                builder2.ai = mediaMetadata.J();
                builder2 = builder2;
                builder2.aI = mediaMetadata.Q();
                builder2 = builder2;
                builder2.aJ = mediaMetadata.E();
                builder2 = builder2;
                builder2.aE = mediaMetadata.E();
                this.f20342f = builder2.a();
            }
            this.f20341e.a(this.f20342f, view.getContext(), PlayerOrigin.FEED);
        }
        LogUtils.a(-1609587199, a);
    }
}
