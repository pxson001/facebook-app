package com.facebook.feed.ufi;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.R;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.api.ufiservices.common.GraphQLActorCacheImpl;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerLauncherImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.analytics.IsStorySharingAnalyticsEnabled;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.analytics.NewsfeedAnalyticsLogger;
import com.facebook.feed.analytics.StoryRenderContext;
import com.facebook.feed.annotations.IsUFIShareActionEnabled;
import com.facebook.feed.logging.StoryLikeHistoryLogger;
import com.facebook.feed.logging.StoryLikeHistoryLogger.Type;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.ufi.FullscreenVideoFeedbackActionButtonBarHelper.FeedbackActionButton;
import com.facebook.feed.ufi.UFIFooterButtonStyleDefinition.FooterLayoutType;
import com.facebook.feed.util.event.DataSetEvents.DataSetUpdatedEvent;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedplugins.share.Boolean_IsStorySharingAnalyticsEnabledMethodAutoProvider;
import com.facebook.feedplugins.share.ShareMenuPopoverFactory;
import com.facebook.feedplugins.share.ShareMenuPopoverFactory.OnPopoverDismissCallback;
import com.facebook.feedplugins.share.ShareMenuPopoverFactory.WritePostOnClickCallback;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLActorCache;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfiguration.Builder;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ufiservices.analytics.UFIServicesAnalyticsEventBuilder;
import com.facebook.ufiservices.event.FlyoutEventBus;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnDismissEvent;
import com.facebook.ufiservices.event.FlyoutEvents.FlyoutOnResumeEvent;
import com.facebook.ufiservices.event.UfiEvents.CommentButtonClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeClickedEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeStoryEvent;
import com.facebook.ufiservices.event.UfiEvents.LikeUpdatedUIEvent;
import com.facebook.ufiservices.event.UfiEvents.ShareStoryPublishEvent;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listeners.ANRAwareViewOnClickListener;
import com.facebook.widget.springbutton.TouchSpring;
import com.fasterxml.jackson.databind.node.ArrayNode;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@Deprecated
/* compiled from: Trying to send command to a non-existing view with tag  */
public class FullscreenVideoFeedbackActionButtonBar extends SegmentedLinearLayout {
    private ComposerConfiguration f21693A;
    public View f21694B;
    private GraphQLFeedOptimisticPublishState f21695C;
    private StoryRenderContext f21696D;
    @Inject
    private ShareMenuPopoverFactory f21697E;
    @Inject
    private FullscreenVideoFeedbackActionButtonBarHelper f21698F;
    @Inject
    private Provider<ViewerContext> f21699G;
    @Inject
    private StoryLikeHistoryLogger f21700H;
    @Inject
    private DefaultFeedUnitRenderer f21701a;
    @Inject
    private IFeedIntentBuilder f21702b;
    @Inject
    public FeedEventBus f21703c;
    @Inject
    private FlyoutEventBus f21704d;
    @Inject
    private NewsFeedAnalyticsEventBuilder f21705e;
    @Inject
    private UFIServicesAnalyticsEventBuilder f21706f;
    @Inject
    private AnalyticsLogger f21707g;
    @Inject
    private ComposerLauncher f21708h;
    @Inject
    private OptimisticStoryStateCache f21709i;
    @Inject
    private AbstractFbErrorReporter f21710j;
    @Inject
    private NewsfeedAnalyticsLogger f21711k;
    @Inject
    private FeedStoryMutator f21712l;
    @Inject
    @IsStorySharingAnalyticsEnabled
    private Boolean f21713m;
    @Inject
    private Provider<TouchSpring> f21714n;
    @Inject
    private UFIStyleProvider f21715o;
    @Inject
    @Lazy
    private com.facebook.inject.Lazy<GraphQLActorCache> f21716p;
    private final FeedbackCustomPressStateButton f21717q;
    private final FeedbackCustomPressStateButton f21718r;
    private final FeedbackCustomPressStateButton f21719s;
    private final FeedbackCustomPressStateButton[] f21720t;
    public boolean f21721u;
    private boolean f21722v;
    @IsUFIShareActionEnabled
    @Inject
    private Boolean f21723w;
    public FeedProps<GraphQLStory> f21724x;
    private UFIStyle f21725y;
    private OnClickListener f21726z;

    /* compiled from: Trying to send command to a non-existing view with tag  */
    class C18171 implements OnClickListener {
        final /* synthetic */ FullscreenVideoFeedbackActionButtonBar f21685a;

        C18171(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
            this.f21685a = fullscreenVideoFeedbackActionButtonBar;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1829604786);
            FullscreenVideoFeedbackActionButtonBar.m24296c(this.f21685a);
            Logger.a(2, EntryType.UI_INPUT_END, 1865540156, a);
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    class C18182 implements WritePostOnClickCallback {
        final /* synthetic */ FullscreenVideoFeedbackActionButtonBar f21686a;

        C18182(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
            this.f21686a = fullscreenVideoFeedbackActionButtonBar;
        }

        public final void mo282a(String str) {
            this.f21686a.m24288a(str);
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    class C18193 implements OnPopoverDismissCallback {
        final /* synthetic */ FullscreenVideoFeedbackActionButtonBar f21687a;

        C18193(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
            this.f21687a = fullscreenVideoFeedbackActionButtonBar;
        }

        public final void mo283a() {
            this.f21687a.f21724x;
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    class C18204 extends ANRAwareViewOnClickListener {
        final /* synthetic */ FullscreenVideoFeedbackActionButtonBar f21688a;

        C18204(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
            this.f21688a = fullscreenVideoFeedbackActionButtonBar;
        }

        public final void m24277a() {
            FullscreenVideoFeedbackActionButtonBar.m24303e(this.f21688a, true);
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    /* synthetic */ class C18215 {
        static final /* synthetic */ int[] f21689a = new int[StoryRenderContext.values().length];
        static final /* synthetic */ int[] f21690b = new int[GraphQLFeedOptimisticPublishState.values().length];

        static {
            try {
                f21690b[GraphQLFeedOptimisticPublishState.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21690b[GraphQLFeedOptimisticPublishState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21689a[StoryRenderContext.NEWSFEED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21689a[StoryRenderContext.TIMELINE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21689a[StoryRenderContext.GROUP.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21689a[StoryRenderContext.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21689a[StoryRenderContext.EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f21689a[StoryRenderContext.PERMALINK.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f21689a[StoryRenderContext.FULLSCREEN_VIDEO_PLAYER.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    public class LikeButtonSpringListener {
        private final FeedEventBus f21691a;

        public LikeButtonSpringListener(FeedEventBus feedEventBus) {
            this.f21691a = feedEventBus;
        }

        public final void m24278a() {
            this.f21691a.a(new DataSetUpdatedEvent());
        }
    }

    /* compiled from: Trying to send command to a non-existing view with tag  */
    class LikeStoryEventSubscriber extends com.facebook.ufiservices.event.UfiEvents.LikeStoryEventSubscriber {
        final /* synthetic */ FullscreenVideoFeedbackActionButtonBar f21692a;

        public LikeStoryEventSubscriber(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
            this.f21692a = fullscreenVideoFeedbackActionButtonBar;
        }

        public final void m24279b(FbEvent fbEvent) {
            LikeStoryEvent likeStoryEvent = (LikeStoryEvent) fbEvent;
            if (this.f21692a.f21721u && !((GraphQLStory) this.f21692a.f21724x.a).B() && likeStoryEvent.a.equals(((GraphQLStory) this.f21692a.f21724x.a).l().z_())) {
                FullscreenVideoFeedbackActionButtonBar.m24303e(this.f21692a, false);
            }
        }
    }

    private static <T extends View> void m24286a(Class<T> cls, T t) {
        m24287a((Object) t, t.getContext());
    }

    private static void m24287a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FullscreenVideoFeedbackActionButtonBar) obj).m24280a(DefaultFeedUnitRenderer.a(injectorLike), (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(injectorLike), FeedEventBus.a(injectorLike), FlyoutEventBus.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), UFIServicesAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (ComposerLauncher) ComposerLauncherImpl.a(injectorLike), OptimisticStoryStateCache.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), NewsfeedAnalyticsLogger.a(injectorLike), FeedStoryMutator.a(injectorLike), Boolean_IsStorySharingAnalyticsEnabledMethodAutoProvider.m5761a(injectorLike), IdBasedProvider.a(injectorLike, 3736), (UFIStyleProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(UFIStyleProvider.class), IdBasedSingletonScopeProvider.b(injectorLike, 262), Boolean_IsUFIShareActionEnabledMethodAutoProvider.m24273a(injectorLike), ShareMenuPopoverFactory.m5773a(injectorLike), FullscreenVideoFeedbackActionButtonBarHelper.m24307a(injectorLike), IdBasedProvider.a(injectorLike, 372), StoryLikeHistoryLogger.m22799a(injectorLike));
    }

    public FullscreenVideoFeedbackActionButtonBar(Context context) {
        this(context, null);
    }

    public FullscreenVideoFeedbackActionButtonBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21716p = UltralightRuntime.b;
        this.f21721u = false;
        this.f21722v = false;
        m24286a(FullscreenVideoFeedbackActionButtonBar.class, (View) this);
        setContentView(2130904298);
        this.f21725y = this.f21715o.a(FooterLayoutType.INLINE);
        this.f21717q = (FeedbackCustomPressStateButton) a(2131560943);
        this.f21718r = (FeedbackCustomPressStateButton) a(2131560944);
        this.f21719s = (FeedbackCustomPressStateButton) a(2131560945);
        this.f21694B = this.f21719s;
        m24290a(this.f21714n, true);
        this.f21720t = m24292a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FullscreenVideoFeedbackActionButtonBar);
        DownstateType a = FullscreenVideoFeedbackActionButtonBarHelper.m24309a(obtainStyledAttributes.getInt(0, 1));
        obtainStyledAttributes.recycle();
        setupDownstates(a);
        a(new LikeStoryEventSubscriber(this));
        TrackingNodes.a(this, TrackingNode.FEEDBACK_SECTION);
        TrackingNodes.a(this.f21717q, TrackingNode.LIKE_LINK);
        TrackingNodes.a(this.f21718r, TrackingNode.COMMENT_LINK);
        TrackingNodes.a(this.f21719s, TrackingNode.SHARE_LINK);
    }

    private void setupDownstates(DownstateType downstateType) {
        this.f21717q.setDownstateType(downstateType);
        this.f21718r.setDownstateType(downstateType);
        this.f21719s.setDownstateType(downstateType);
    }

    public final void m24305a(FeedProps<GraphQLStory> feedProps, StoryRenderContext storyRenderContext) {
        this.f21696D = storyRenderContext;
        this.f21724x = feedProps;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        this.f21693A = null;
        boolean z = graphQLStory.z();
        boolean A = graphQLStory.A();
        boolean z2 = GraphQLStoryUtil.o(feedProps) != null && this.f21723w.booleanValue();
        this.f21695C = this.f21709i.a(graphQLStory);
        if (z || A || z2) {
            m24282a(feedProps, z, A, z2);
            setupFeedbackBarPublishState(graphQLStory);
            return;
        }
        m24302e();
    }

    private void m24290a(Provider<TouchSpring> provider, boolean z) {
        this.f21717q.setText(FullscreenVideoFeedbackActionButtonBarHelper.m24306a(FeedbackActionButton.LIKE));
        this.f21717q.setImageDrawable(this.f21698F.m24313b(FeedbackActionButton.LIKE));
        this.f21718r.setText(FullscreenVideoFeedbackActionButtonBarHelper.m24306a(FeedbackActionButton.COMMENT));
        this.f21718r.setImageDrawable(this.f21698F.m24313b(FeedbackActionButton.COMMENT));
        this.f21719s.setText(FullscreenVideoFeedbackActionButtonBarHelper.m24306a(FeedbackActionButton.SHARE));
        this.f21719s.setImageDrawable(this.f21698F.m24313b(FeedbackActionButton.SHARE));
        m24289a((Provider) provider);
        m24291a(z);
    }

    private void m24289a(Provider<TouchSpring> provider) {
        TouchSpring touchSpring = (TouchSpring) provider.get();
        touchSpring.k = new LikeButtonSpringListener(this.f21703c);
        this.f21717q.setSpring(touchSpring);
        this.f21718r.setSpring((TouchSpring) provider.get());
        this.f21719s.setSpring((TouchSpring) provider.get());
    }

    private void m24291a(boolean z) {
        if (z) {
            this.f21717q.setSoundEffectsEnabled(false);
            this.f21718r.setSoundEffectsEnabled(false);
            this.f21719s.setSoundEffectsEnabled(false);
        }
    }

    private FeedbackCustomPressStateButton[] m24292a() {
        return new FeedbackCustomPressStateButton[]{this.f21717q, this.f21718r, this.f21719s};
    }

    private OnClickListener m24293b() {
        if (this.f21726z != null) {
            return this.f21726z;
        }
        this.f21726z = new C18171(this);
        return this.f21726z;
    }

    public static void m24296c(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
        PopoverMenuWindow a = fullscreenVideoFeedbackActionButtonBar.f21697E.m5785a(GraphQLStoryUtil.o(fullscreenVideoFeedbackActionButtonBar.f21724x), fullscreenVideoFeedbackActionButtonBar.f21694B, "newsfeed_ufi", new C18182(fullscreenVideoFeedbackActionButtonBar), new C18193(fullscreenVideoFeedbackActionButtonBar), fullscreenVideoFeedbackActionButtonBar.getComposerSourceType());
        if (a == null) {
            fullscreenVideoFeedbackActionButtonBar.m24288a(null);
            return;
        }
        fullscreenVideoFeedbackActionButtonBar.f21704d.a(new FlyoutOnResumeEvent());
        a.d();
    }

    public static void m24300d(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar) {
        fullscreenVideoFeedbackActionButtonBar.f21704d.a(new FlyoutOnDismissEvent());
    }

    private void m24288a(@Nullable String str) {
        FeedProps o = GraphQLStoryUtil.o(this.f21724x);
        GraphQLStory graphQLStory = (GraphQLStory) o.a;
        if (this.f21713m.booleanValue()) {
            this.f21711k.a("newsfeed_ufi", graphQLStory.c(), ((ViewerContext) this.f21699G.get()).mUserId, StorySharingHelper.a(graphQLStory));
        }
        if (this.f21693A == null && graphQLStory != null) {
            Builder a = this.f21702b.a(o, getComposerSourceType());
            if (!StringUtil.a("newsfeed_ufi")) {
                a.setNectarModule("group_composer");
            }
            a.setReactionSurface(getReactionSurface());
            this.f21693A = a.a();
        }
        if (this.f21693A != null) {
            HoneyClientEvent c = NewsFeedAnalyticsEventBuilder.c(StoryProps.p(this.f21724x), TrackableFeedProps.a(this.f21724x));
            TrackingNodes.a(c, this);
            this.f21707g.a(c);
            GraphQLStory c2 = StoryProps.c(o);
            this.f21703c.a(new ShareStoryPublishEvent(graphQLStory.g(), graphQLStory.l() != null ? graphQLStory.l().j() : null, c2 != null ? c2.g() : null));
            this.f21708h.a(str, this.f21693A, 1756, (Activity) ContextUtils.a(getContext(), Activity.class));
        }
    }

    private ComposerSourceType getComposerSourceType() {
        switch (C18215.f21689a[this.f21696D.ordinal()]) {
            case 1:
                return ComposerSourceType.FEED;
            case 2:
                return ComposerSourceType.TIMELINE;
            case 3:
                return ComposerSourceType.GROUP;
            case 4:
                return ComposerSourceType.PAGE;
            case 5:
                return ComposerSourceType.EVENT;
            case 6:
                return ComposerSourceType.PERMALINK;
            default:
                this.f21710j.a("composer_source_type_not_found", "No ComposerSourceType for story render context " + this.f21696D);
                return ComposerSourceType.UNKNOWN;
        }
    }

    private Surface getReactionSurface() {
        switch (C18215.f21689a[this.f21696D.ordinal()]) {
            case 1:
                return Surface.ANDROID_FEED_COMPOSER;
            case 2:
                return Surface.ANDROID_TIMELINE_COMPOSER;
            case 3:
                return Surface.ANDROID_GROUP_COMPOSER;
            case 4:
                return Surface.ANDROID_PAGE_COMPOSER;
            case 7:
                return Surface.ANDROID_VIDEO_COMPOSER;
            default:
                return Surface.ANDROID_COMPOSER;
        }
    }

    private void m24282a(FeedProps<GraphQLStory> feedProps, boolean z, boolean z2, boolean z3) {
        setVisibility(0);
        m24297c(z);
        m24295b(((GraphQLStory) feedProps.a).B());
        m24281a((FeedProps) feedProps, z2);
        m24301d(z3);
    }

    private void m24302e() {
        setVisibility(8);
    }

    private void setupFeedbackBarPublishState(GraphQLStory graphQLStory) {
        switch (C18215.f21690b[this.f21709i.a(graphQLStory).ordinal()]) {
            case 1:
            case 2:
                this.f21717q.setOnClickListener(null);
                this.f21718r.setOnClickListener(null);
                this.f21719s.setOnClickListener(null);
                this.f21721u = false;
                this.f21722v = false;
                return;
            default:
                return;
        }
    }

    public void setSharePopoverAnchor(View view) {
        this.f21694B = view;
    }

    private void m24295b(boolean z) {
        this.f21717q.setTextColor(this.f21698F.m24312a(z));
        this.f21717q.setImageDrawable(this.f21698F.m24314b(z));
        if (!this.f21721u && m24304f()) {
            this.f21717q.setOnClickListener(new C18204(this));
            this.f21721u = true;
        }
    }

    private void m24297c(boolean z) {
        this.f21717q.setVisibility(z ? 0 : 8);
    }

    private void m24281a(FeedProps<GraphQLStory> feedProps, boolean z) {
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        this.f21718r.setTag(2131558515, null);
        this.f21718r.setVisibility(z ? 0 : 8);
        if (z && m24304f()) {
            String g;
            GraphQLStory c = StoryProps.c(feedProps);
            String g2 = graphQLStory.g();
            if (c != null) {
                g = c.g();
            } else {
                g = null;
            }
            this.f21718r.setTag(2131558515, new CommentButtonClickedEvent(g2, g));
            boolean p = StoryProps.p(feedProps);
            ArrayNode a = TrackableFeedProps.a(feedProps);
            this.f21718r.setTag(2131558521, Boolean.valueOf(true));
            this.f21701a.a(this.f21718r, graphQLStory.l(), new FeedbackLoggingParams(a, "newsfeed_ufi", this.f21696D.analyticModule), UFIServicesAnalyticsEventBuilder.a(p, null, graphQLStory.l().z_(), graphQLStory.l().j(), a, this.f21696D.analyticModule), "tap_footer_comment");
        }
    }

    private void m24301d(boolean z) {
        if (z) {
            this.f21719s.setVisibility(0);
            this.f21719s.setOnClickListener(m24293b());
            this.f21722v = true;
            return;
        }
        this.f21719s.setVisibility(8);
        this.f21719s.setOnClickListener(null);
        this.f21722v = false;
    }

    private boolean m24304f() {
        return this.f21695C == GraphQLFeedOptimisticPublishState.SUCCESS || this.f21695C == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
    }

    public static void m24303e(FullscreenVideoFeedbackActionButtonBar fullscreenVideoFeedbackActionButtonBar, boolean z) {
        GraphQLActor a = ((GraphQLActorCacheImpl) fullscreenVideoFeedbackActionButtonBar.f21716p.get()).a();
        GraphQLStory graphQLStory = (GraphQLStory) fullscreenVideoFeedbackActionButtonBar.f21724x.a;
        fullscreenVideoFeedbackActionButtonBar.f21700H.m22801a(graphQLStory.g(), fullscreenVideoFeedbackActionButtonBar, graphQLStory.z(), a == null ? "actor is null" : "actor is available", Type.CLICK);
        if (graphQLStory.z() && a != null) {
            FeedProps a2 = fullscreenVideoFeedbackActionButtonBar.f21712l.a(fullscreenVideoFeedbackActionButtonBar.f21724x, a, !graphQLStory.B());
            GraphQLStory graphQLStory2 = (GraphQLStory) a2.a;
            fullscreenVideoFeedbackActionButtonBar.f21724x = fullscreenVideoFeedbackActionButtonBar.f21724x.b(graphQLStory2);
            FeedUnit f = StoryProps.f(a2);
            GraphQLFeedback l = graphQLStory2.l();
            fullscreenVideoFeedbackActionButtonBar.f21703c.a(new LikeClickedEvent(graphQLStory2.g(), l.j(), f != null ? f.g() : null, l.y_(), z, fullscreenVideoFeedbackActionButtonBar.f21696D.analyticModule));
            fullscreenVideoFeedbackActionButtonBar.m24295b(graphQLStory2.B());
            fullscreenVideoFeedbackActionButtonBar.f21703c.a(new LikeUpdatedUIEvent(graphQLStory2.l().j(), graphQLStory2.B(), z, graphQLStory2.l()));
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f21724x != null) {
            GraphQLStory graphQLStory = (GraphQLStory) this.f21724x.a;
            this.f21725y.a(graphQLStory.z(), graphQLStory.A(), GraphQLStoryUtil.o(this.f21724x) != null).a(MeasureSpec.getSize(i), this.f21720t);
        }
        super.onMeasure(i, i2);
    }

    protected FeedEventBus getEventBus() {
        return this.f21703c;
    }

    private String getNectarModule() {
        return "newsfeed_ufi";
    }

    private void m24280a(DefaultFeedUnitRenderer defaultFeedUnitRenderer, IFeedIntentBuilder iFeedIntentBuilder, FeedEventBus feedEventBus, FlyoutEventBus flyoutEventBus, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, UFIServicesAnalyticsEventBuilder uFIServicesAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, ComposerLauncher composerLauncher, OptimisticStoryStateCache optimisticStoryStateCache, FbErrorReporter fbErrorReporter, NewsfeedAnalyticsLogger newsfeedAnalyticsLogger, FeedStoryMutator feedStoryMutator, Boolean bool, Provider<TouchSpring> provider, UFIStyleProvider uFIStyleProvider, com.facebook.inject.Lazy<GraphQLActorCache> lazy, Boolean bool2, ShareMenuPopoverFactory shareMenuPopoverFactory, FullscreenVideoFeedbackActionButtonBarHelper fullscreenVideoFeedbackActionButtonBarHelper, Provider<ViewerContext> provider2, StoryLikeHistoryLogger storyLikeHistoryLogger) {
        this.f21701a = defaultFeedUnitRenderer;
        this.f21702b = iFeedIntentBuilder;
        this.f21703c = feedEventBus;
        this.f21704d = flyoutEventBus;
        this.f21705e = newsFeedAnalyticsEventBuilder;
        this.f21706f = uFIServicesAnalyticsEventBuilder;
        this.f21707g = analyticsLogger;
        this.f21708h = composerLauncher;
        this.f21709i = optimisticStoryStateCache;
        this.f21710j = fbErrorReporter;
        this.f21711k = newsfeedAnalyticsLogger;
        this.f21712l = feedStoryMutator;
        this.f21713m = bool;
        this.f21714n = provider;
        this.f21715o = uFIStyleProvider;
        this.f21716p = lazy;
        this.f21723w = bool2;
        this.f21697E = shareMenuPopoverFactory;
        this.f21698F = fullscreenVideoFeedbackActionButtonBarHelper;
        this.f21699G = provider2;
        this.f21700H = storyLikeHistoryLogger;
    }
}
