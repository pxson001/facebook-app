package com.facebook.attachments.photos.launcherhelper;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.widget.ImageView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.attachments.photos.PhotoAttachmentUtil;
import com.facebook.attachments.photos.ui.HasPhotoAttachment;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.view.DraweeView;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.util.ContextPrecondition;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.graphql.model.GraphQLPrivacyScope;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.galleryutil.GalleryDeepLinkBinder.DeepLinkBinderConfig;
import com.facebook.photos.mediagallery.MediaGalleryLauncherParamsFactory;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncher;
import com.facebook.photos.mediagallery.launcher.MediaGalleryLauncherParams.Builder;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParams;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.photos.mediagallery.ui.DefaultMediaGalleryLauncher;
import com.facebook.photos.mediagallery.util.MediaGalleryAttachmentFilter;
import com.facebook.story.GraphQLStoryHelper;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: use_neighborhood_datasource */
public class PhotoGalleryLauncherHelper {
    public static final StoryRenderContext f916a = StoryRenderContext.NEWSFEED;
    private static PhotoGalleryLauncherHelper f917j;
    private static final Object f918k = new Object();
    private final AnalyticsLogger f919b;
    private final NewsFeedAnalyticsEventBuilder f920c;
    private final Context f921d;
    private final MediaGalleryLauncher f922e;
    private final MediaGalleryLauncherParamsFactory f923f;
    private final MediaGalleryAttachmentFilter f924g;
    private final InstagramUtils f925h;
    private final PhotoAttachmentUtil f926i;

    private static PhotoGalleryLauncherHelper m898b(InjectorLike injectorLike) {
        return new PhotoGalleryLauncherHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), (Context) injectorLike.getInstance(Context.class), (MediaGalleryLauncher) DefaultMediaGalleryLauncher.a(injectorLike), MediaGalleryLauncherParamsFactory.m12745a(injectorLike), MediaGalleryAttachmentFilter.m12806b(injectorLike), InstagramUtils.a(injectorLike), PhotoAttachmentUtil.a(injectorLike));
    }

    public static PhotoGalleryLauncherHelper m893a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PhotoGalleryLauncherHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f918k) {
                PhotoGalleryLauncherHelper photoGalleryLauncherHelper;
                if (a2 != null) {
                    photoGalleryLauncherHelper = (PhotoGalleryLauncherHelper) a2.a(f918k);
                } else {
                    photoGalleryLauncherHelper = f917j;
                }
                if (photoGalleryLauncherHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m898b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f918k, b3);
                        } else {
                            f917j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = photoGalleryLauncherHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PhotoGalleryLauncherHelper(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Context context, MediaGalleryLauncher mediaGalleryLauncher, MediaGalleryLauncherParamsFactory mediaGalleryLauncherParamsFactory, MediaGalleryAttachmentFilter mediaGalleryAttachmentFilter, InstagramUtils instagramUtils, PhotoAttachmentUtil photoAttachmentUtil) {
        this.f919b = analyticsLogger;
        this.f920c = newsFeedAnalyticsEventBuilder;
        this.f922e = mediaGalleryLauncher;
        this.f923f = mediaGalleryLauncherParamsFactory;
        this.f924g = mediaGalleryAttachmentFilter;
        this.f925h = instagramUtils;
        this.f921d = context;
        this.f926i = photoAttachmentUtil;
        ContextPrecondition.a(context);
    }

    @Nullable
    public static DrawingRule m895a(View view) {
        if (view instanceof HasPhotoAttachment) {
            return DrawingRule.m12761a(((HasPhotoAttachment) view).getUnderlyingDraweeView());
        }
        if (view instanceof DraweeView) {
            return DrawingRule.m12761a((DraweeView) view);
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() != null) {
                return DrawingRule.m12759a(imageView);
            }
        }
        return null;
    }

    private void m897a(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable final DrawingRule drawingRule, final ImageRequest imageRequest, @Nullable DeepLinkBinderConfig deepLinkBinderConfig, boolean z, int i, @Nullable FeedProps<GraphQLStoryAttachment> feedProps2, @Nullable OnDismissListener onDismissListener) {
        Object obj;
        Builder a;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (feedProps2 == null || ((GraphQLStoryAttachment) feedProps2.a).r() == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            a = MediaGalleryLauncherParamsFactory.m12739a(this.f924g.m12807a(graphQLStoryAttachment.x())).m12723a(((GraphQLStoryAttachment) feedProps2.a).r().b());
        } else {
            a = MediaGalleryLauncherParamsFactory.m12737a(graphQLStoryAttachment);
        }
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e.a;
        Builder a2 = a.m12720a(PhotoAttachmentUtil.a(f916a));
        a2.f10656h = graphQLStory.g();
        a2 = a2;
        a2.f10657i = graphQLStory.ai();
        a2 = a2;
        a2.f10659k = graphQLStory.c();
        a2 = a2;
        a2.f10660l = StoryProps.p(e);
        a2 = a2;
        a2.f10658j = TrackableFeedProps.a(e).toString();
        Builder a3 = a2.m12719a(imageRequest);
        a3.f10666r = deepLinkBinderConfig;
        a3 = a3;
        a3.f10663o = z;
        a3.f10664p = i;
        if (graphQLStory.aJ() != null) {
            a.f10673y = graphQLStory.aJ().b();
        }
        GraphQLPrivacyScope c = GraphQLStoryHelper.c(graphQLStory);
        if (!(graphQLStory.aJ() == null || graphQLStory.aJ().j() == null)) {
            a.f10672x = graphQLStory.aJ().j().g();
        }
        if (c != null) {
            a.f10674z = c.s();
        }
        this.f922e.mo603a(this.f921d, a.m12726b(), new AnimationParamProvider(this) {
            final /* synthetic */ PhotoGalleryLauncherHelper f915c;

            public final AnimationParams mo47a(String str) {
                if (drawingRule == null) {
                    return null;
                }
                return new AnimationParams(drawingRule, imageRequest);
            }
        }, onDismissListener);
    }

    public final void m899a(FeedProps<GraphQLStoryAttachment> feedProps, View view, ImageRequest imageRequest, boolean z) {
        m900a(feedProps, view, imageRequest, z, -1, null);
    }

    public final void m900a(FeedProps<GraphQLStoryAttachment> feedProps, View view, ImageRequest imageRequest, boolean z, int i, @Nullable OnDismissListener onDismissListener) {
        m901a(feedProps, null, view, imageRequest, z, i, onDismissListener);
    }

    public final void m901a(FeedProps<GraphQLStoryAttachment> feedProps, @Nullable FeedProps<GraphQLStoryAttachment> feedProps2, View view, ImageRequest imageRequest, boolean z, int i, @Nullable OnDismissListener onDismissListener) {
        FeedProps feedProps3;
        if (feedProps2 == null) {
            feedProps3 = feedProps;
        } else {
            FeedProps<GraphQLStoryAttachment> feedProps4 = feedProps2;
        }
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps3.a();
        if (graphQLStoryAttachment != null && graphQLStoryAttachment.r() != null && graphQLStoryAttachment.r().b() != null) {
            DeepLinkBinderConfig a = m894a(feedProps3);
            m896a(feedProps3, view);
            m897a(feedProps, m895a(view), imageRequest, a, z, i, feedProps2, onDismissListener);
        }
    }

    @Nullable
    private DeepLinkBinderConfig m894a(FeedProps<GraphQLStoryAttachment> feedProps) {
        GraphQLStory c = AttachmentProps.c(feedProps);
        String a = GraphQLStoryUtil.a(c);
        if (InstagramUtils.a(c) && this.f925h.a(InstagramEntryPoint.Photo)) {
            return InstagramUtils.a(false, null, a);
        }
        return null;
    }

    private void m896a(FeedProps<GraphQLStoryAttachment> feedProps, View view) {
        String str;
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.a;
        if (graphQLStoryAttachment.z() == null) {
            str = null;
        } else {
            str = graphQLStoryAttachment.z().dp();
        }
        HoneyClientEvent a = NewsFeedAnalyticsEventBuilder.a(str, StoryProps.p(e), TrackableFeedProps.a(e), f916a);
        if (!TrackingNodes.a(a)) {
            TrackingNodes.a(a, view);
        }
        this.f919b.a(a);
    }
}
