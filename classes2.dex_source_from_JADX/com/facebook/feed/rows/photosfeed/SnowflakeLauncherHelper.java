package com.facebook.feed.rows.photosfeed;

import android.content.Context;
import android.view.View;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.attachments.photos.PhotoAttachmentUtil;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.util.ContextPrecondition;
import com.facebook.feed.util.composer.InlineCommentComposerCache;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams;
import com.facebook.photos.mediafetcher.MediaFetcherFactory;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcherConstructionRule;
import com.facebook.photos.mediafetcher.query.NodesMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.SetTokenMediaQueryProvider;
import com.facebook.photos.mediafetcher.query.param.MediaTypeQueryParam;
import com.facebook.photos.mediafetcher.query.param.MultiIdQueryParam;
import com.facebook.photos.mediagallery.launcher.animation.AnimationParamProvider;
import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: groups_native_photos_more_menu */
public class SnowflakeLauncherHelper<E extends HasInvalidate> {
    private static SnowflakeLauncherHelper f21548g;
    private static final Object f21549h = new Object();
    private final AnalyticsLogger f21550a;
    private final NewsFeedAnalyticsEventBuilder f21551b;
    private final Context f21552c;
    private final MediaFetcherFactory f21553d;
    private final InlineCommentComposerCache f21554e;
    private final PhotoAttachmentUtil f21555f;

    private static SnowflakeLauncherHelper m29262b(InjectorLike injectorLike) {
        return new SnowflakeLauncherHelper(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), (Context) injectorLike.getInstance(Context.class), MediaFetcherFactory.m29266b(injectorLike), InlineCommentComposerCache.m14459a(injectorLike), PhotoAttachmentUtil.m29272a(injectorLike));
    }

    public static SnowflakeLauncherHelper m29260a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SnowflakeLauncherHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21549h) {
                SnowflakeLauncherHelper snowflakeLauncherHelper;
                if (a2 != null) {
                    snowflakeLauncherHelper = (SnowflakeLauncherHelper) a2.mo818a(f21549h);
                } else {
                    snowflakeLauncherHelper = f21548g;
                }
                if (snowflakeLauncherHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m29262b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21549h, b3);
                        } else {
                            f21548g = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = snowflakeLauncherHelper;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public SnowflakeLauncherHelper(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Context context, MediaFetcherFactory mediaFetcherFactory, InlineCommentComposerCache inlineCommentComposerCache, PhotoAttachmentUtil photoAttachmentUtil) {
        this.f21550a = analyticsLogger;
        this.f21551b = newsFeedAnalyticsEventBuilder;
        this.f21552c = context;
        ContextPrecondition.m29275a(context);
        this.f21553d = mediaFetcherFactory;
        this.f21554e = inlineCommentComposerCache;
        this.f21555f = photoAttachmentUtil;
    }

    public final void m29263a(FeedProps<GraphQLStoryAttachment> feedProps, int i, View view, FeedListType feedListType, String str, boolean z, @Nullable AnimationParamProvider animationParamProvider, E e) {
        MediaFetcherConstructionRule a;
        MediaFetcherConstructionRule mediaFetcherConstructionRule;
        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) feedProps.m19804a();
        FeedUnit c = AttachmentProps.m28714c(feedProps);
        m29261a(feedProps, (GraphQLStoryAttachment) graphQLStoryAttachment.m23985x().get(i), m29259a(feedListType), view);
        this.f21554e.m14462a(c, e, Boolean.valueOf(true));
        String t = graphQLStoryAttachment.m23981t();
        if (t == null) {
            Builder builder = ImmutableList.builder();
            Builder builder2 = ImmutableList.builder();
            ImmutableList x = graphQLStoryAttachment.m23985x();
            int size = x.size();
            for (int i2 = 0; i2 < size; i2++) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) x.get(i2);
                if (graphQLStoryAttachment.m23979r() != null) {
                    String b = graphQLStoryAttachment.m23979r().m24452b();
                    builder.m1069c(b);
                    if (GraphQLStoryAttachmentUtil.m28053b(graphQLStoryAttachment)) {
                        builder2.m1069c(b);
                    }
                }
            }
            a = MediaFetcherConstructionRule.a(NodesMediaQueryProvider.class, new MultiIdQueryParam(builder.m1068b()));
            if (z) {
                mediaFetcherConstructionRule = a;
            } else {
                mediaFetcherConstructionRule = a;
                a = MediaFetcherConstructionRule.a(NodesMediaQueryProvider.class, new MultiIdQueryParam(builder2.m1068b()));
            }
        } else {
            a = MediaFetcherConstructionRule.a(SetTokenMediaQueryProvider.class, MediaTypeQueryParam.a(t));
            if (z) {
                mediaFetcherConstructionRule = a;
            } else {
                mediaFetcherConstructionRule = a;
                a = MediaFetcherConstructionRule.a(SetTokenMediaQueryProvider.class, MediaTypeQueryParam.b(t));
            }
        }
        PhotosFeedFragment a2 = PhotosFeedFragment.a(feedProps, i, str, this.f21553d, mediaFetcherConstructionRule, a);
        PhotoAnimationDialogLaunchParams.Builder a3 = new PhotoAnimationDialogLaunchParams.Builder(PhotoAttachmentUtil.m29274a(feedListType)).a(Direction.RIGHT);
        a3.f = Direction.RIGHT.flag();
        a3 = a3.a(str);
        a3.g = this.f21552c.getResources().getColor(2131363087);
        if (!PhotoAnimationDialogFragment.a(this.f21552c, a2, a3.a(), animationParamProvider, null)) {
            a2.aq();
        }
    }

    private static StoryRenderContext m29259a(FeedListType feedListType) {
        switch (1.a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return StoryRenderContext.TIMELINE;
            case 3:
                return StoryRenderContext.PERMALINK;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
                return StoryRenderContext.GROUP;
            case 7:
                return StoryRenderContext.EVENT;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
                return StoryRenderContext.PAGE;
            default:
                return StoryRenderContext.NEWSFEED;
        }
    }

    private void m29261a(FeedProps<GraphQLStoryAttachment> feedProps, GraphQLStoryAttachment graphQLStoryAttachment, StoryRenderContext storyRenderContext, View view) {
        if (graphQLStoryAttachment != null && graphQLStoryAttachment.m23987z() != null) {
            GraphQLStory c = AttachmentProps.m28714c(feedProps);
            FeedProps feedProps2 = feedProps.f13445b;
            boolean z = c != null && c.mo2895u();
            HoneyClientEvent a = NewsFeedAnalyticsEventBuilder.m14110a(graphQLStoryAttachment.m23987z().dp(), z, feedProps2 != null ? TrackableFeedProps.m27452b(feedProps2) : null, storyRenderContext);
            TrackingNodes.m27142a(a, view);
            this.f21550a.mo528a(a);
        }
    }
}
