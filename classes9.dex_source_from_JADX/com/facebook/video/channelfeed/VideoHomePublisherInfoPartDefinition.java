package com.facebook.video.channelfeed;

import android.content.Context;
import android.support.annotation.ColorRes;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ViewColorPartDefinition;
import com.facebook.video.analytics.VideoAnalytics.ClickTarget;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.LaunchChannelFeedClickListener.OnLaunchCallback;
import com.facebook.video.engine.ExitFullScreenResult;
import com.facebook.video.videohome.logging.VideoHomeChannelLoggingData;
import com.facebook.video.videohome.logging.VideoHomeLoggingUtils;
import com.facebook.video.videohome.sessionmanager.VideoHomeSessionManager;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: submit_flow_click */
public class VideoHomePublisherInfoPartDefinition<E extends HasPersistentState & HasContext> extends MultiRowSinglePartDefinition<Props, Void, E, View> {
    public static final ViewType<View> f2701a = ViewType.a(2130907723);
    private static VideoHomePublisherInfoPartDefinition f2702i;
    private static final Object f2703j = new Object();
    private final PublisherInfoPartDefinition<E> f2704b;
    private final ChannelFeedHeaderParamsFactory f2705c;
    private final ChannelFeedGenericLauncherPartDefinition f2706d;
    private final VideoChannelSubscribeButtonPartDefinition<E> f2707e;
    private final ViewColorPartDefinition f2708f;
    public final VideoHomeSessionManager f2709g;
    public final VideoHomeLoggingUtils f2710h;

    /* compiled from: submit_flow_click */
    public class C02462 implements FullscreenTransitionListener {
        final /* synthetic */ VideoHomePublisherInfoPartDefinition f2684a;

        public C02462(VideoHomePublisherInfoPartDefinition videoHomePublisherInfoPartDefinition) {
            this.f2684a = videoHomePublisherInfoPartDefinition;
        }

        public final void m2583a(ExitFullScreenResult exitFullScreenResult) {
            if (this.f2684a.f2709g.g() && this.f2684a.f2709g.i()) {
                this.f2684a.f2709g.c();
            }
        }
    }

    /* compiled from: submit_flow_click */
    public final class Props {
        public final GraphQLStory f2693a;
        public final boolean f2694b;
        public final boolean f2695c;
        public final boolean f2696d;
        @ColorRes
        public final int f2697e;
        public final String f2698f;
        public final GraphQLTextWithEntities f2699g;
        public final int f2700h;

        /* compiled from: submit_flow_click */
        public class Builder {
            private GraphQLStory f2685a;
            private boolean f2686b = true;
            public boolean f2687c = true;
            public boolean f2688d = false;
            public int f2689e = 2131362143;
            public String f2690f = null;
            public GraphQLTextWithEntities f2691g;
            public int f2692h = -1;

            public Builder(GraphQLStory graphQLStory) {
                this.f2685a = graphQLStory;
            }

            public final Props m2584a() {
                return new Props(this.f2685a, this.f2686b, this.f2687c, this.f2688d, this.f2689e, this.f2690f, this.f2691g, this.f2692h);
            }
        }

        private Props(GraphQLStory graphQLStory, boolean z, boolean z2, boolean z3, int i, String str, GraphQLTextWithEntities graphQLTextWithEntities, int i2) {
            this.f2693a = graphQLStory;
            this.f2694b = z;
            this.f2695c = z2;
            this.f2696d = z3;
            this.f2697e = i;
            this.f2698f = str;
            this.f2699g = graphQLTextWithEntities;
            this.f2700h = i2;
        }

        public static Builder m2585a(GraphQLStory graphQLStory) {
            return new Builder(graphQLStory);
        }
    }

    private static VideoHomePublisherInfoPartDefinition m2588b(InjectorLike injectorLike) {
        return new VideoHomePublisherInfoPartDefinition(PublisherInfoPartDefinition.m2541a(injectorLike), ChannelFeedHeaderParamsFactory.m2263a(injectorLike), ChannelFeedGenericLauncherPartDefinition.m2243a(injectorLike), VideoChannelSubscribeButtonPartDefinition.m2577a(injectorLike), ViewColorPartDefinition.a(injectorLike), VideoHomeSessionManager.a(injectorLike), VideoHomeLoggingUtils.a(injectorLike));
    }

    public final Object m2590a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final Props props = (Props) obj;
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(props.f2693a);
        FeedProps a = FeedProps.c(props.f2693a).a(o);
        final GraphQLActor a2 = StoryAttachmentHelper.a(o);
        subParts.a(this.f2704b, new com.facebook.video.channelfeed.PublisherInfoPartDefinition.Props(props.f2693a, props.f2696d, props.f2699g));
        if (a2 != null) {
            subParts.a(2131560277, this.f2707e, new com.facebook.video.channelfeed.VideoChannelSubscribeButtonPartDefinition.Props(a, Surface.RECOMMENDED_VIDEO_CHANNEL, VideoChannelUnfollowInputData.Surface.RECOMMENDED_VIDEO_CHANNEL, props.f2695c));
        }
        if (props.f2694b && a2 != null) {
            Builder builder = new Builder();
            builder.k = ChannelFeedHeaderParamsFactory.m2262a(a2);
            builder = builder.b(VideoChannelHelper.m2552a(a2));
            builder.d = EntryPointInputVideoChannelEntryPoint.VIDEO_HOME;
            builder = builder;
            builder.h = EventTriggerType.BY_USER;
            builder = builder;
            builder.g = PlayerOrigin.VIDEO_HOME;
            subParts.a(2131560329, this.f2706d, new com.facebook.video.channelfeed.ChannelFeedGenericLauncherPartDefinition.Props(builder.a(), new AtomicReference(new C02462(this)), new OnLaunchCallback(this) {
                final /* synthetic */ VideoHomePublisherInfoPartDefinition f2683c;

                public final void m2582a() {
                    if (this.f2683c.f2709g.g()) {
                        VideoHomeLoggingUtils videoHomeLoggingUtils = this.f2683c.f2710h;
                        PlayerOrigin playerOrigin = PlayerOrigin.VIDEO_HOME;
                        ClickTarget clickTarget = ClickTarget.CHANNEL_INFO_OVERLAY;
                        VideoHomeChannelLoggingData.Builder builder = new VideoHomeChannelLoggingData.Builder();
                        builder.a = a2.H();
                        builder = builder;
                        builder.b = props.f2698f;
                        builder = builder;
                        builder.c = props.f2700h;
                        videoHomeLoggingUtils.b(playerOrigin, clickTarget, builder.a());
                    }
                }
            }));
        }
        subParts.a(this.f2708f, Integer.valueOf(props.f2697e));
        return null;
    }

    public static VideoHomePublisherInfoPartDefinition m2586a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomePublisherInfoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2703j) {
                VideoHomePublisherInfoPartDefinition videoHomePublisherInfoPartDefinition;
                if (a2 != null) {
                    videoHomePublisherInfoPartDefinition = (VideoHomePublisherInfoPartDefinition) a2.a(f2703j);
                } else {
                    videoHomePublisherInfoPartDefinition = f2702i;
                }
                if (videoHomePublisherInfoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2703j, b3);
                        } else {
                            f2702i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomePublisherInfoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoHomePublisherInfoPartDefinition(PublisherInfoPartDefinition publisherInfoPartDefinition, ChannelFeedHeaderParamsFactory channelFeedHeaderParamsFactory, ChannelFeedGenericLauncherPartDefinition channelFeedGenericLauncherPartDefinition, VideoChannelSubscribeButtonPartDefinition videoChannelSubscribeButtonPartDefinition, ViewColorPartDefinition viewColorPartDefinition, VideoHomeSessionManager videoHomeSessionManager, VideoHomeLoggingUtils videoHomeLoggingUtils) {
        this.f2704b = publisherInfoPartDefinition;
        this.f2705c = channelFeedHeaderParamsFactory;
        this.f2706d = channelFeedGenericLauncherPartDefinition;
        this.f2707e = videoChannelSubscribeButtonPartDefinition;
        this.f2708f = viewColorPartDefinition;
        this.f2709g = videoHomeSessionManager;
        this.f2710h = videoHomeLoggingUtils;
    }

    public static boolean m2587a(Props props) {
        return props != null;
    }

    public final ViewType<View> m2589a() {
        return f2701a;
    }
}
