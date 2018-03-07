package com.facebook.feedplugins.attachments.collage;

import android.annotation.SuppressLint;
import android.content.Context;
import com.facebook.attachments.photos.PostpostTaggingUtil;
import com.facebook.feed.collage.StoryCollageItem;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.data.protocol.PhotosMetadataConversionHelper;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.util.MediaGalleryAttachmentFilter;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@SuppressLint({"DeprecatedClass"})
/* compiled from: TOMORROW */
public class CollageMediaGalleryLaunchHelper {
    private final Lazy<MediaGalleryLauncher> f22569a;
    private final Lazy<MediaGalleryLauncherParamsFactory> f22570b;
    private final MediaGalleryAttachmentFilter f22571c;
    private final PostpostTaggingUtil f22572d;

    @Inject
    public CollageMediaGalleryLaunchHelper(Lazy<MediaGalleryLauncher> lazy, Lazy<MediaGalleryLauncherParamsFactory> lazy2, MediaGalleryAttachmentFilter mediaGalleryAttachmentFilter, PostpostTaggingUtil postpostTaggingUtil) {
        this.f22569a = lazy;
        this.f22570b = lazy2;
        this.f22571c = mediaGalleryAttachmentFilter;
        this.f22572d = postpostTaggingUtil;
    }

    public final void m25262a(CollageAttachmentView<StoryCollageItem> collageAttachmentView, int i, FeedProps<GraphQLStoryAttachment> feedProps, ImageRequest imageRequest, FullscreenGallerySource fullscreenGallerySource, boolean z, boolean z2) {
        m25261a(collageAttachmentView.getContext(), m25260a(collageAttachmentView, imageRequest), i, feedProps, imageRequest, fullscreenGallerySource, z, z2);
    }

    private void m25261a(Context context, AnimationParamProvider animationParamProvider, int i, FeedProps<GraphQLStoryAttachment> feedProps, ImageRequest imageRequest, FullscreenGallerySource fullscreenGallerySource, boolean z, boolean z2) {
        String str = null;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a();
        FeedProps e = AttachmentProps.e(feedProps);
        String arrayNode = e == null ? null : TrackableFeedProps.a(e).toString();
        String g = e == null ? null : ((GraphQLStory) e.a()).g();
        String c = e == null ? null : ((GraphQLStory) e.a()).c();
        if (e != null) {
            str = ((GraphQLStory) e.a()).ai();
        }
        boolean z3 = e != null && StoryProps.p(e);
        Builder a = m25259a(z2, graphQLStoryAttachment, i).m12719a(imageRequest).m12720a(fullscreenGallerySource);
        a.f10663o = z;
        a = a;
        a.f10656h = g;
        a = a;
        a.f10659k = c;
        a = a;
        a.f10657i = str;
        a = a;
        a.f10660l = z3;
        a = a;
        a.f10658j = arrayNode;
        MediaGalleryLauncherParams b = a.m12726b();
        if (z) {
            this.f22572d.b(AttachmentProps.c(feedProps));
        }
        ((MediaGalleryLauncher) this.f22569a.get()).mo602a(context, b, animationParamProvider);
    }

    private AnimationParamProvider m25260a(final CollageAttachmentView<StoryCollageItem> collageAttachmentView, final ImageRequest imageRequest) {
        return new AnimationParamProvider(this) {
            final /* synthetic */ CollageMediaGalleryLaunchHelper f22568c;

            public final AnimationParams mo47a(String str) {
                ImmutableList visibleAttachments = collageAttachmentView.getVisibleAttachments();
                for (int i = 0; i < visibleAttachments.size(); i++) {
                    if (str.equals(((StoryCollageItem) visibleAttachments.get(i)).b().b())) {
                        return new AnimationParams(DrawingRule.m12760a(collageAttachmentView.d(i), collageAttachmentView, collageAttachmentView.c(i)), imageRequest);
                    }
                }
                return null;
            }
        };
    }

    private Builder m25259a(boolean z, GraphQLStoryAttachment graphQLStoryAttachment, int i) {
        ImmutableList x;
        if (z) {
            this.f22570b.get();
            x = graphQLStoryAttachment.x();
            Preconditions.checkNotNull(x);
            ImmutableList.Builder builder = ImmutableList.builder();
            ImmutableList.Builder builder2 = ImmutableList.builder();
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                GraphQLStoryAttachment graphQLStoryAttachment2 = (GraphQLStoryAttachment) x.get(i2);
                if (graphQLStoryAttachment2.r() != null) {
                    builder.c(graphQLStoryAttachment2.r().b());
                    builder2.c(PhotosMetadataConversionHelper.a(graphQLStoryAttachment2.r()));
                }
            }
            Builder builder3 = new MediaGalleryLauncherParamsFactory.Builder(MediaFetcherConstructionRule.m12416a(NodesMediaQueryProvider.class, new MultiIdQueryParam(builder.b())));
            builder3.m12722a(builder2.b());
            if (i >= 0 && i < x.size() && x.get(i) != null && ((GraphQLStoryAttachment) x.get(i)).r() != null) {
                builder3.m12723a(((GraphQLStoryAttachment) x.get(i)).r().b());
            }
            return builder3;
        }
        x = this.f22571c.m12807a(graphQLStoryAttachment.x());
        this.f22570b.get();
        return MediaGalleryLauncherParamsFactory.m12740a(x, i);
    }
}
