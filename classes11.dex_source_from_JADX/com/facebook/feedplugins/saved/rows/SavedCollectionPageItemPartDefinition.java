package com.facebook.feedplugins.saved.rows;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.common.util.TriState;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.saved.rows.ui.SavedCollectionItemInlineVideoAutoplayPartDefinition;
import com.facebook.feedplugins.saved.rows.ui.SavedCollectionItemView;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.graphql.model.ActionLinkHelper;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLInstantArticle;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnit;
import com.facebook.graphql.model.GraphQLSavedCollectionFeedUnitItem;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.graphql.model.GraphQLVideo;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinitionWithViewType;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.analytics.VideoAnalytics.StreamSourceType;
import com.facebook.video.engine.VideoDataSource;
import com.facebook.video.engine.VideoDataSourceBuilder;
import com.facebook.video.engine.VideoPlayerParams;
import com.facebook.video.engine.VideoPlayerParamsBuilder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: bundle_friend_view_sent */
public class SavedCollectionPageItemPartDefinition extends BaseSinglePartDefinitionWithViewType<Props, State, HasPositionInformation, SavedCollectionItemView> {
    private static final CallerContext f9316a = CallerContext.a(SavedCollectionPageItemPartDefinition.class, "saved_reminders");
    private static SavedCollectionPageItemPartDefinition f9317m;
    private static final Object f9318n = new Object();
    public final AnalyticsLogger f9319b;
    private final DefaultFeedUnitRenderer f9320c;
    private final FbUriIntentHandler f9321d;
    public final GraphQLLinkExtractor f9322e;
    public final NewsFeedAnalyticsEventBuilder f9323f;
    private final FbDraweeControllerBuilder f9324g;
    private final Provider<TriState> f9325h;
    private final SavedCollectionItemInlineVideoAutoplayPartDefinition f9326i;
    private final FullscreenVideoPlayerLauncher f9327j;
    private final GatekeeperStoreImpl f9328k;
    private final AutoplayStateManagerProvider f9329l;

    /* compiled from: bundle_friend_view_sent */
    public class Props {
        public final FeedProps<GraphQLSavedCollectionFeedUnit> f9306a;
        public final GraphQLSavedCollectionFeedUnitItem f9307b;
        public final boolean f9308c;

        public Props(FeedProps<GraphQLSavedCollectionFeedUnit> feedProps, GraphQLSavedCollectionFeedUnitItem graphQLSavedCollectionFeedUnitItem, boolean z) {
            this.f9306a = feedProps;
            this.f9307b = graphQLSavedCollectionFeedUnitItem;
            this.f9308c = z;
        }
    }

    /* compiled from: bundle_friend_view_sent */
    public class State {
        public final GraphQLStoryActionLink f9309a;
        public final OnClickListener f9310b;
        public final OnClickListener f9311c;
        public final OnClickListener f9312d;
        public final ImageRequest f9313e;
        public final VideoPlayerParams f9314f;
        public final ImmutableMap<String, Object> f9315g;

        public State(GraphQLStoryActionLink graphQLStoryActionLink, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3, ImageRequest imageRequest, VideoPlayerParams videoPlayerParams, ImmutableMap<String, Object> immutableMap) {
            this.f9309a = graphQLStoryActionLink;
            this.f9310b = onClickListener;
            this.f9311c = onClickListener2;
            this.f9312d = onClickListener3;
            this.f9313e = imageRequest;
            this.f9314f = videoPlayerParams;
            this.f9315g = immutableMap;
        }
    }

    private static SavedCollectionPageItemPartDefinition m9931b(InjectorLike injectorLike) {
        return new SavedCollectionPageItemPartDefinition(AnalyticsLoggerMethodAutoProvider.a(injectorLike), DefaultFeedUnitRenderer.a(injectorLike), FbUriIntentHandler.a(injectorLike), GraphQLLinkExtractor.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), SavedCollectionItemInlineVideoAutoplayPartDefinition.m9952a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class), FullscreenVideoPlayerLauncher.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 769));
    }

    public static SavedCollectionPageItemPartDefinition m9925a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedCollectionPageItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9318n) {
                SavedCollectionPageItemPartDefinition savedCollectionPageItemPartDefinition;
                if (a2 != null) {
                    savedCollectionPageItemPartDefinition = (SavedCollectionPageItemPartDefinition) a2.a(f9318n);
                } else {
                    savedCollectionPageItemPartDefinition = f9317m;
                }
                if (savedCollectionPageItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9931b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9318n, b3);
                        } else {
                            f9317m = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedCollectionPageItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m9938a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        VideoPlayerParams m;
        Props props = (Props) obj;
        ImmutableMap immutableMap = null;
        GraphQLProfile n = props.f9307b.n();
        ImageRequest a = ImageRequest.a(m9936d(n));
        if (((TriState) this.f9325h.get()).equals(TriState.YES) && m9929a(n)) {
            VideoDataSourceBuilder newBuilder = VideoDataSource.newBuilder();
            newBuilder.f = StreamSourceType.FROM_STREAM;
            newBuilder = newBuilder;
            newBuilder.a = UriUtil.a(n.ab());
            VideoDataSource i = newBuilder.i();
            GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) props.f9306a.a;
            VideoPlayerParamsBuilder a2 = VideoPlayerParams.newBuilder().a(i);
            a2.b = n.b();
            a2 = a2;
            a2.e = GraphQLHelper.a(props.f9307b, graphQLSavedCollectionFeedUnit);
            m = a2.m();
            immutableMap = new Builder().b("CoverImageParamsKey", a).b();
            GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
            builder.aI = n.ab();
            subParts.a(this.f9326i, new com.facebook.feedplugins.saved.rows.ui.SavedCollectionItemInlineVideoAutoplayPartDefinition.Props(new InlineVideoStoryKey(props.f9306a, builder.a(), this.f9329l), graphQLSavedCollectionFeedUnit, n.b()));
        } else {
            m = null;
        }
        return new State(ActionLinkHelper.a(props.f9307b.j(), -908457779), m9923a(props), m9924a(props, m9934c(props)), m9924a(props, m9930b(props)), a, m, immutableMap);
    }

    public final /* bridge */ /* synthetic */ void m9939a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1128689954);
        m9927a((Props) obj, (State) obj2, (SavedCollectionItemView) view);
        Logger.a(8, EntryType.MARK_POP, -178890717, a);
    }

    public final void m9940b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SavedCollectionItemView savedCollectionItemView = (SavedCollectionItemView) view;
        savedCollectionItemView.setMainImageOnClickListener(null);
        savedCollectionItemView.setMainImageController(null);
        savedCollectionItemView.setTextContainerOnClickListener(null);
    }

    @Inject
    public SavedCollectionPageItemPartDefinition(AnalyticsLogger analyticsLogger, DefaultFeedUnitRenderer defaultFeedUnitRenderer, FbUriIntentHandler fbUriIntentHandler, GraphQLLinkExtractor graphQLLinkExtractor, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, FbDraweeControllerBuilder fbDraweeControllerBuilder, SavedCollectionItemInlineVideoAutoplayPartDefinition savedCollectionItemInlineVideoAutoplayPartDefinition, AutoplayStateManagerProvider autoplayStateManagerProvider, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher, GatekeeperStore gatekeeperStore, Provider<TriState> provider) {
        this.f9319b = analyticsLogger;
        this.f9320c = defaultFeedUnitRenderer;
        this.f9321d = fbUriIntentHandler;
        this.f9322e = graphQLLinkExtractor;
        this.f9323f = newsFeedAnalyticsEventBuilder;
        this.f9324g = fbDraweeControllerBuilder;
        this.f9326i = savedCollectionItemInlineVideoAutoplayPartDefinition;
        this.f9329l = autoplayStateManagerProvider;
        this.f9327j = fullscreenVideoPlayerLauncher;
        this.f9328k = gatekeeperStore;
        this.f9325h = provider;
    }

    private void m9927a(Props props, State state, SavedCollectionItemView savedCollectionItemView) {
        Object obj;
        savedCollectionItemView.setFullWidth(props.f9308c);
        savedCollectionItemView.g.setText(m9926a(props.f9307b.p()));
        savedCollectionItemView.setSubtitleText(m9926a(props.f9307b.o()));
        savedCollectionItemView.setContextText(m9926a(props.f9307b.l()));
        if (m9933b() && m9935c(props.f9307b.n())) {
            obj = 1;
        } else {
            obj = null;
        }
        savedCollectionItemView.n.setVisibility(obj != null ? 0 : 8);
        savedCollectionItemView.setTextContainerOnClickListener(state.f9312d);
        if (state.f9314f != null) {
            savedCollectionItemView.a(state.f9314f, state.f9315g);
            savedCollectionItemView.setInlineVideoOnClickListener(state.f9311c);
        } else {
            DraweeController draweeController;
            FbDraweeControllerBuilder fbDraweeControllerBuilder = (FbDraweeControllerBuilder) this.f9324g.a(f9316a).c(state.f9313e);
            if (savedCollectionItemView.e == null) {
                draweeController = null;
            } else {
                draweeController = savedCollectionItemView.e.getController();
            }
            savedCollectionItemView.setMainImageController(((FbDraweeControllerBuilder) fbDraweeControllerBuilder.b(draweeController)).s());
            savedCollectionItemView.setMainImageOnClickListener(state.f9311c);
        }
        if (state.f9309a == null) {
            savedCollectionItemView.setSaveButtonVisibility(8);
            return;
        }
        savedCollectionItemView.m.a(state.f9309a.J(), CurationSurface.NATIVE_NETEGO, props.f9306a, state.f9310b);
        savedCollectionItemView.setSaveButtonVisibility(0);
    }

    private OnClickListener m9923a(final Props props) {
        return new OnClickListener(this) {
            final /* synthetic */ SavedCollectionPageItemPartDefinition f9302b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1574475611);
                GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) props.f9306a.a;
                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f9302b.f9323f;
                this.f9302b.f9319b.c(NewsFeedAnalyticsEventBuilder.b(GraphQLHelper.a(props.f9307b, graphQLSavedCollectionFeedUnit), SavedCollectionPageItemPartDefinition.m9932b(graphQLSavedCollectionFeedUnit), "saved_collection_ego_item_action_link_clicked"));
                Logger.a(2, EntryType.UI_INPUT_END, -270245935, a);
            }
        };
    }

    private OnClickListener m9924a(final Props props, final HoneyClientEvent honeyClientEvent) {
        return new OnClickListener(this) {
            final /* synthetic */ SavedCollectionPageItemPartDefinition f9305c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1276108307);
                SavedCollectionPageItemPartDefinition.m9928a(this.f9305c, props, view);
                this.f9305c.f9319b.a(honeyClientEvent);
                Logger.a(2, EntryType.UI_INPUT_END, -2100893029, a);
            }
        };
    }

    public static void m9928a(SavedCollectionPageItemPartDefinition savedCollectionPageItemPartDefinition, Props props, View view) {
        GraphQLProfile n = props.f9307b.n();
        if (m9929a(n)) {
            GraphQLVideo.Builder builder = new GraphQLVideo.Builder();
            builder.H = n.b();
            builder = builder;
            builder.aI = n.ab();
            savedCollectionPageItemPartDefinition.f9327j.a(builder.a(), view.getContext(), PlayerOrigin.SAVED_REMINDER);
            return;
        }
        Object obj;
        if (n == null || savedCollectionPageItemPartDefinition.f9322e.a(n.j(), n.b()) == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            savedCollectionPageItemPartDefinition.f9320c.a(view, LinkifyTargetBuilder.a(n), null);
        } else if (m9935c(n) && savedCollectionPageItemPartDefinition.m9933b()) {
            String formatStrLocaleSafe;
            GraphQLInstantArticle t = n.aI().J().t();
            if (t.n() != null) {
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.fe, t.m(), Uri.encode(t.n().j()));
            } else {
                formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(FBLinks.fd, t.m());
            }
            savedCollectionPageItemPartDefinition.f9321d.a(view.getContext(), formatStrLocaleSafe);
        } else {
            savedCollectionPageItemPartDefinition.f9321d.a(view.getContext(), n.ax());
        }
    }

    private static boolean m9929a(@Nullable GraphQLProfile graphQLProfile) {
        if (graphQLProfile != null && graphQLProfile.O()) {
            if (!StringUtil.a(new CharSequence[]{graphQLProfile.b(), graphQLProfile.ab()})) {
                return true;
            }
        }
        return false;
    }

    private static boolean m9935c(@Nullable GraphQLProfile graphQLProfile) {
        return (graphQLProfile == null || graphQLProfile.aI() == null || graphQLProfile.aI().J() == null || graphQLProfile.aI().J().t() == null) ? false : true;
    }

    private boolean m9933b() {
        return this.f9328k.a(880, false);
    }

    private HoneyClientEvent m9930b(Props props) {
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) props.f9306a.a;
        return NewsFeedAnalyticsEventBuilder.b(GraphQLHelper.a(props.f9307b, graphQLSavedCollectionFeedUnit), m9932b(graphQLSavedCollectionFeedUnit), "saved_collection_ego_item_title_clicked");
    }

    private HoneyClientEvent m9934c(Props props) {
        GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit = (GraphQLSavedCollectionFeedUnit) props.f9306a.a;
        return NewsFeedAnalyticsEventBuilder.b(GraphQLHelper.a(props.f9307b, graphQLSavedCollectionFeedUnit), m9932b(graphQLSavedCollectionFeedUnit), "saved_collection_ego_item_image_clicked");
    }

    private static Uri m9936d(GraphQLProfile graphQLProfile) {
        if (graphQLProfile == null) {
            return null;
        }
        if (GraphQLHelper.c(graphQLProfile)) {
            Uri a;
            if (GraphQLHelper.c(graphQLProfile)) {
                a = ImageUtil.a(graphQLProfile.z().j().L());
            } else {
                a = null;
            }
            return a;
        } else if (GraphQLHelper.a(graphQLProfile)) {
            return ImageUtil.a(graphQLProfile.ai());
        } else {
            return null;
        }
    }

    public static String m9932b(GraphQLSavedCollectionFeedUnit graphQLSavedCollectionFeedUnit) {
        return graphQLSavedCollectionFeedUnit.y() != null ? graphQLSavedCollectionFeedUnit.y().b() : null;
    }

    private static String m9926a(GraphQLTextWithEntities graphQLTextWithEntities) {
        return graphQLTextWithEntities != null ? graphQLTextWithEntities.a() : null;
    }

    public final ViewType<SavedCollectionItemView> m9937a() {
        return SavedCollectionItemView.a;
    }
}
