package com.facebook.photos.consumptiongallery.snowflake;

import android.content.Context;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.MediaGalleryScrollListener;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.story.GraphQLStoryHelper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: state_home_creation_logger_data */
public class SnowflakeMediaGalleryHelper {
    private MediaGalleryLauncher f2147a;

    public static SnowflakeMediaGalleryHelper m2337b(InjectorLike injectorLike) {
        return new SnowflakeMediaGalleryHelper((MediaGalleryLauncher) DefaultMediaGalleryLauncher.m2459a(injectorLike));
    }

    @Inject
    public SnowflakeMediaGalleryHelper(MediaGalleryLauncher mediaGalleryLauncher) {
        this.f2147a = mediaGalleryLauncher;
    }

    public final void m2338a(Context context, MediaFetcherConstructionRule mediaFetcherConstructionRule, ImmutableList<MediaMetadata> immutableList, String str, @Nullable AnimationParamProvider animationParamProvider, ImageRequest imageRequest, boolean z, int i, @Nullable MediaGalleryScrollListener mediaGalleryScrollListener, @Nullable FullscreenGallerySource fullscreenGallerySource, int i2, String str2, @Nullable FeedProps<GraphQLStory> feedProps) {
        String str3;
        ArrayNode arrayNode;
        String arrayNode2;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        boolean z2 = false;
        if (feedProps != null) {
            String c = ((GraphQLStory) feedProps.a()).c();
            str4 = ((GraphQLStory) feedProps.a()).g();
            str5 = ((GraphQLStory) feedProps.a()).ai();
            boolean p = StoryProps.p(feedProps);
            ArrayNode a = TrackableFeedProps.a(feedProps);
            GraphQLPrivacyScope c2 = GraphQLStoryHelper.c((GraphQLStory) feedProps.a());
            if (c2 == null || c2.s() == null) {
                str3 = null;
                arrayNode = a;
                z2 = p;
                str6 = str5;
                str5 = str4;
                str4 = c;
            } else {
                str3 = c2.s();
                arrayNode = a;
                z2 = p;
                str6 = str5;
                str5 = str4;
                str4 = c;
            }
        } else {
            arrayNode = null;
            str3 = null;
        }
        Builder a2 = new MediaGalleryLauncherParamsFactory.Builder(mediaFetcherConstructionRule).a(immutableList);
        if (fullscreenGallerySource == null) {
            fullscreenGallerySource = FullscreenGallerySource.UNKNOWN;
        }
        Builder d = a2.a(fullscreenGallerySource).b(20).a(str).a(imageRequest).c(z).a(i).a(mediaGalleryScrollListener).c(i2).e(str2).f(str4).b(str5).c(str6).d(z2);
        if (arrayNode != null) {
            arrayNode2 = arrayNode.toString();
        } else {
            arrayNode2 = null;
        }
        this.f2147a.a(context, d.d(arrayNode2).g(str3).b(), animationParamProvider);
    }

    public final void m2339a(Context context, ImmutableList<MediaMetadata> immutableList, String str, @Nullable AnimationParamProvider animationParamProvider, ImageRequest imageRequest, boolean z, int i, @Nullable MediaGalleryScrollListener mediaGalleryScrollListener, @Nullable FullscreenGallerySource fullscreenGallerySource) {
        m2338a(context, MediaGalleryLauncherParamsFactory.d(immutableList), immutableList, str, animationParamProvider, imageRequest, z, i, mediaGalleryScrollListener, fullscreenGallerySource, 0, null, null);
    }
}
