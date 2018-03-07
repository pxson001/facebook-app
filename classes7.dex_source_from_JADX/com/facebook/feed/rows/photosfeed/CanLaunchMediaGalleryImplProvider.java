package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.consumptiongallery.snowflake.SnowflakeMediaGalleryHelper;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediagallery.launcher.MediaGalleryScrollListener;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import java.util.concurrent.Callable;

/* compiled from: activity_picker_first_keystroke */
public class CanLaunchMediaGalleryImplProvider extends AbstractAssistedProvider<CanLaunchMediaGalleryImpl> {
    public final CanLaunchMediaGalleryImpl m23201a(Context context, MediaMetadataListCollection mediaMetadataListCollection, MediaGalleryScrollListener mediaGalleryScrollListener, AnimationParamProvider animationParamProvider, MediaFetcherConstructionRule mediaFetcherConstructionRule, int i, String str, boolean z, Callable<FeedProps<GraphQLStory>> callable) {
        return new CanLaunchMediaGalleryImpl(SnowflakeMediaGalleryHelper.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), context, mediaMetadataListCollection, mediaGalleryScrollListener, animationParamProvider, mediaFetcherConstructionRule, i, str, z, callable, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
