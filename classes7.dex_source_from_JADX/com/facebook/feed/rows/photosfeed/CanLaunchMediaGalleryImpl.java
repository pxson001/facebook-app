package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.photosfeed.PhotosFeedFragment.PhotosFeedMediaGalleryScrollListener;
import com.facebook.feed.rows.qe.ExperimentsForMultiRowQEModule;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Assisted;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.consumptiongallery.snowflake.SnowflakeMediaGalleryHelper;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediagallery.launcher.MediaGalleryScrollListener;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: activity_picker_first_scroll */
public class CanLaunchMediaGalleryImpl implements CanLaunchMediaGallery {
    private static final String f19993a = CanLaunchMediaGalleryImpl.class.getSimpleName();
    private final SnowflakeMediaGalleryHelper f19994b;
    private final Context f19995c;
    private final MediaMetadataListCollection f19996d;
    private final PhotosFeedMediaGalleryScrollListener f19997e;
    private final AnimationParamProvider f19998f;
    private final MediaFetcherConstructionRule f19999g;
    private final Callable<FeedProps<GraphQLStory>> f20000h;
    private final int f20001i;
    private final String f20002j;
    private final boolean f20003k;
    private final AbstractFbErrorReporter f20004l;
    private final QeAccessor f20005m;

    @Inject
    public CanLaunchMediaGalleryImpl(SnowflakeMediaGalleryHelper snowflakeMediaGalleryHelper, FbErrorReporter fbErrorReporter, @Assisted Context context, @Assisted MediaMetadataListCollection mediaMetadataListCollection, @Assisted MediaGalleryScrollListener mediaGalleryScrollListener, @Assisted AnimationParamProvider animationParamProvider, @Assisted MediaFetcherConstructionRule mediaFetcherConstructionRule, @Assisted int i, @Assisted String str, @Assisted boolean z, @Assisted Callable<FeedProps<GraphQLStory>> callable, QeAccessor qeAccessor) {
        this.f19994b = snowflakeMediaGalleryHelper;
        this.f19995c = context;
        this.f19996d = mediaMetadataListCollection;
        this.f19997e = mediaGalleryScrollListener;
        this.f19998f = animationParamProvider;
        this.f19999g = mediaFetcherConstructionRule;
        this.f20001i = i;
        this.f20002j = str;
        this.f20000h = callable;
        this.f20003k = z;
        this.f20004l = fbErrorReporter;
        this.f20005m = qeAccessor;
    }

    public final void mo1483a(MediaMetadata mediaMetadata, ImageRequest imageRequest, boolean z, int i) {
        ImmutableList of;
        FeedProps feedProps = null;
        try {
            feedProps = (FeedProps) this.f20000h.call();
        } catch (Throwable e) {
            this.f20004l.b(f19993a, "mStoryCallable threw an exception", e);
        }
        SnowflakeMediaGalleryHelper snowflakeMediaGalleryHelper = this.f19994b;
        Context context = this.f19995c;
        MediaFetcherConstructionRule mediaFetcherConstructionRule = this.f19999g;
        if (this.f19996d.m23225a() == 0) {
            of = ImmutableList.of(mediaMetadata);
        } else {
            of = m23199a(this.f19996d.m23228b());
        }
        snowflakeMediaGalleryHelper.a(context, mediaFetcherConstructionRule, of, mediaMetadata.d(), this.f19998f, imageRequest, z, i, this.f19997e, FullscreenGallerySource.PHOTOS_FEED, this.f20001i, this.f20002j, feedProps);
    }

    private ImmutableList<MediaMetadata> m23199a(ImmutableList<MediaMetadata> immutableList) {
        if (this.f20003k) {
            return immutableList;
        }
        Builder builder = ImmutableList.builder();
        boolean a = this.f20005m.a(ExperimentsForMultiRowQEModule.w, false);
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            MediaMetadata mediaMetadata = (MediaMetadata) immutableList.get(i);
            if ((!a && mediaMetadata.J()) || (a && !mediaMetadata.J())) {
                builder.c(mediaMetadata);
            }
        }
        return builder.b();
    }
}
