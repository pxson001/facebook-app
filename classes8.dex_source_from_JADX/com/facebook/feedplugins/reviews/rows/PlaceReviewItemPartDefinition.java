package com.facebook.feedplugins.reviews.rows;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.ContextUtils;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.protocol.NewsFeedMutations.PlaceReviewXoutString;
import com.facebook.feed.protocol.NewsFeedMutationsModels.PlaceReviewXoutModel;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feedplugins.reviews.events.PlaceReviewEvents.XOutEvent;
import com.facebook.feedplugins.reviews.protocol.XOutGraphQLMutation;
import com.facebook.feedplugins.reviews.views.PlaceReviewItemView;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.calls.PlaceReviewXoutInputData;
import com.facebook.graphql.calls.PlaceReviewXoutInputData.Surface;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLContactRecommendationField;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnit;
import com.facebook.graphql.model.GraphQLPlaceReviewFeedUnitItem;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.model.ItemListFeedUnitImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friendIds */
public class PlaceReviewItemPartDefinition extends BaseSinglePartDefinition<Props, State, AnyEnvironment, PlaceReviewItemView> {
    public static final CallerContext f12978a = CallerContext.a(PlaceReviewItemPartDefinition.class);
    public static final String f12979b = PlaceReviewItemPartDefinition.class.getName();
    private static PlaceReviewItemPartDefinition f12980k;
    private static final Object f12981l = new Object();
    private final NewsFeedAnalyticsEventBuilder f12982c;
    public final AnalyticsLogger f12983d;
    public final Lazy<ReviewComposerLauncherAndHandler> f12984e;
    public final Lazy<FbErrorReporter> f12985f;
    public final FeedEventBus f12986g;
    private final Lazy<TasksManager> f12987h;
    private final Lazy<XOutGraphQLMutation> f12988i;
    public final FbUriIntentHandler f12989j;

    /* compiled from: friendIds */
    class C13544 extends AbstractDisposableFutureCallback<GraphQLResult<PlaceReviewXoutModel>> {
        final /* synthetic */ PlaceReviewItemPartDefinition f12967a;

        C13544(PlaceReviewItemPartDefinition placeReviewItemPartDefinition) {
            this.f12967a = placeReviewItemPartDefinition;
        }

        protected final void m14693a(Throwable th) {
        }
    }

    /* compiled from: friendIds */
    public class Props {
        public final GraphQLPlaceReviewFeedUnitItem f12968a;
        public final GraphQLPlaceReviewFeedUnit f12969b;
        public final boolean f12970c;

        public Props(GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem, GraphQLPlaceReviewFeedUnit graphQLPlaceReviewFeedUnit, boolean z) {
            this.f12968a = graphQLPlaceReviewFeedUnitItem;
            this.f12969b = graphQLPlaceReviewFeedUnit;
            this.f12970c = z;
        }
    }

    /* compiled from: friendIds */
    public class State {
        public final String f12971a;
        public final String f12972b;
        public final Uri f12973c;
        public final StaticMapOptions f12974d;
        public final OnClickListener f12975e;
        public final OnClickListener f12976f;
        public final OnClickListener f12977g;

        public State(String str, String str2, Uri uri, StaticMapOptions staticMapOptions, OnClickListener onClickListener, OnClickListener onClickListener2, OnClickListener onClickListener3) {
            this.f12971a = str;
            this.f12972b = str2;
            this.f12973c = uri;
            this.f12974d = staticMapOptions;
            this.f12975e = onClickListener;
            this.f12976f = onClickListener2;
            this.f12977g = onClickListener3;
        }
    }

    private static PlaceReviewItemPartDefinition m14697b(InjectorLike injectorLike) {
        return new PlaceReviewItemPartDefinition(NewsFeedAnalyticsEventBuilder.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 10287), IdBasedSingletonScopeProvider.b(injectorLike, 494), FeedEventBus.a(injectorLike), IdBasedLazy.a(injectorLike, 3561), IdBasedLazy.a(injectorLike, 6526), FbUriIntentHandler.a(injectorLike));
    }

    public final Object m14706a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        String str;
        Uri uri;
        final Props props = (Props) obj;
        GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem = props.f12968a;
        if (graphQLPlaceReviewFeedUnitItem.l() == null) {
            str = null;
        } else {
            str = graphQLPlaceReviewFeedUnitItem.l().aG();
        }
        final String str2 = str;
        if (graphQLPlaceReviewFeedUnitItem.m() == null) {
            str = null;
        } else {
            str = graphQLPlaceReviewFeedUnitItem.m().a();
        }
        String str3 = str;
        if (graphQLPlaceReviewFeedUnitItem.n() == null) {
            uri = null;
        } else {
            uri = ImageUtil.a(graphQLPlaceReviewFeedUnitItem.n());
        }
        return new State(str2, str3, uri, m14700e(graphQLPlaceReviewFeedUnitItem), new OnClickListener(this) {
            final /* synthetic */ PlaceReviewItemPartDefinition f12964c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1038916973);
                if (PlaceReviewItemPartDefinition.m14698b(props.f12968a) == null) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1356710378, a);
                    return;
                }
                PlaceReviewItemPartDefinition.m14699d(this.f12964c, props);
                Activity activity = (Activity) ContextUtils.a(view.getContext(), Activity.class);
                if (activity == null) {
                    ((AbstractFbErrorReporter) this.f12964c.f12985f.get()).a(PlaceReviewItemPartDefinition.f12979b, "Could not find containing Activity");
                    LogUtils.a(-1022619481, a);
                    return;
                }
                ((ReviewComposerLauncherAndHandler) this.f12964c.f12984e.get()).m4945a(1759, activity, ComposerSourceType.PLACE_REVIEW_FEED_UNIT, CurationSurface.NATIVE_NETEGO, CurationMechanism.REVIEW_BUTTON, PlaceReviewItemPartDefinition.m14701f(this.f12964c, props.f12968a), Long.parseLong(PlaceReviewItemPartDefinition.m14698b(props.f12968a)), str2, PlaceReviewItemPartDefinition.m14703g(this.f12964c, props.f12968a), PlaceReviewItemPartDefinition.m14704h(this.f12964c, props.f12968a), null);
                LogUtils.a(1989872754, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ PlaceReviewItemPartDefinition f12966b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1667983074);
                String a2 = PlaceReviewItemPartDefinition.m14698b(props.f12968a);
                PlaceReviewItemPartDefinition.m14696a(this.f12966b, a2);
                PlaceReviewItemPartDefinition placeReviewItemPartDefinition = this.f12966b;
                Props props = props;
                if (ItemListFeedUnitImpl.a(props.f12969b) != null) {
                    placeReviewItemPartDefinition.f12986g.a(new XOutEvent(props.f12969b.g(), a2));
                }
                Logger.a(2, EntryType.UI_INPUT_END, -262545477, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ PlaceReviewItemPartDefinition f12961b;

            public void onClick(View view) {
                HoneyAnalyticsEvent honeyAnalyticsEvent;
                int a = Logger.a(2, EntryType.UI_INPUT_START, 712718771);
                PlaceReviewItemPartDefinition placeReviewItemPartDefinition = this.f12961b;
                Props props = props;
                ArrayNode f = PlaceReviewItemPartDefinition.m14702f(props);
                String b = PlaceReviewItemPartDefinition.m14698b(props.f12968a);
                if (NewsFeedAnalyticsEventBuilder.B(f)) {
                    honeyAnalyticsEvent = null;
                } else {
                    HoneyClientEvent b2 = new HoneyClientEvent("place_review_ego_launched_page").a("tracking", f).b("page_id", b);
                    b2.c = "native_newsfeed";
                    honeyAnalyticsEvent = b2;
                }
                placeReviewItemPartDefinition.f12983d.b(honeyAnalyticsEvent);
                this.f12961b.f12989j.a(view.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, PlaceReviewItemPartDefinition.m14698b(props.f12968a)));
                Logger.a(2, EntryType.UI_INPUT_END, -1755592257, a);
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m14707a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 900104900);
        Props props = (Props) obj;
        State state = (State) obj2;
        PlaceReviewItemView placeReviewItemView = (PlaceReviewItemView) view;
        placeReviewItemView.f13004c.setText(state.f12971a);
        placeReviewItemView.f13005d.setText(state.f12972b);
        if (state.f12973c != null || state.f12974d == null) {
            placeReviewItemView.f13006e.a(state.f12973c, f12978a);
            placeReviewItemView.setMainImageVisibility(0);
            placeReviewItemView.setMapImageVisibility(8);
        } else {
            placeReviewItemView.f13007f.setMapOptions(state.f12974d);
            placeReviewItemView.setMapImageVisibility(0);
            placeReviewItemView.setMainImageVisibility(8);
        }
        placeReviewItemView.setReviewButtonOnClickListener(state.f12975e);
        placeReviewItemView.setXOutIconOnClickListener(state.f12976f);
        placeReviewItemView.setOnClickListener(state.f12977g);
        placeReviewItemView.setTitleOnClickListener(state.f12977g);
        placeReviewItemView.setBottomSectionContainerOnClickListener(state.f12977g);
        boolean z = props.f12970c;
        LayoutParams layoutParams = placeReviewItemView.f13003b.getLayoutParams();
        layoutParams.width = z ? -1 : (int) placeReviewItemView.getResources().getDimension(2131429111);
        placeReviewItemView.f13003b.setLayoutParams(layoutParams);
        Logger.a(8, EntryType.MARK_POP, 1390611202, a);
    }

    public final void m14708b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        PlaceReviewItemView placeReviewItemView = (PlaceReviewItemView) view;
        placeReviewItemView.setBottomSectionContainerOnClickListener(null);
        placeReviewItemView.setReviewButtonOnClickListener(null);
        placeReviewItemView.setXOutIconOnClickListener(null);
        placeReviewItemView.setOnClickListener(null);
        placeReviewItemView.setTitleOnClickListener(null);
    }

    public static PlaceReviewItemPartDefinition m14694a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PlaceReviewItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12981l) {
                PlaceReviewItemPartDefinition placeReviewItemPartDefinition;
                if (a2 != null) {
                    placeReviewItemPartDefinition = (PlaceReviewItemPartDefinition) a2.a(f12981l);
                } else {
                    placeReviewItemPartDefinition = f12980k;
                }
                if (placeReviewItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14697b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12981l, b3);
                        } else {
                            f12980k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = placeReviewItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public PlaceReviewItemPartDefinition(NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger, Lazy<ReviewComposerLauncherAndHandler> lazy, Lazy<FbErrorReporter> lazy2, FeedEventBus feedEventBus, Lazy<TasksManager> lazy3, Lazy<XOutGraphQLMutation> lazy4, FbUriIntentHandler fbUriIntentHandler) {
        this.f12982c = newsFeedAnalyticsEventBuilder;
        this.f12983d = analyticsLogger;
        this.f12984e = lazy;
        this.f12985f = lazy2;
        this.f12986g = feedEventBus;
        this.f12987h = lazy3;
        this.f12988i = lazy4;
        this.f12989j = fbUriIntentHandler;
    }

    public static void m14696a(PlaceReviewItemPartDefinition placeReviewItemPartDefinition, String str) {
        TasksManager tasksManager = (TasksManager) placeReviewItemPartDefinition.f12987h.get();
        String str2 = "key_x_out_mutation" + str;
        XOutGraphQLMutation xOutGraphQLMutation = (XOutGraphQLMutation) placeReviewItemPartDefinition.f12988i.get();
        GraphQLQueryExecutor graphQLQueryExecutor = xOutGraphQLMutation.f12940a;
        PlaceReviewXoutInputData placeReviewXoutInputData = new PlaceReviewXoutInputData();
        placeReviewXoutInputData.a("actor_id", xOutGraphQLMutation.f12941b);
        GraphQlCallInput graphQlCallInput = placeReviewXoutInputData;
        graphQlCallInput.a("place_id", str);
        graphQlCallInput = graphQlCallInput;
        graphQlCallInput.a("surface", Surface.EGO_MOBILE);
        tasksManager.a(str2, graphQLQueryExecutor.a(GraphQLRequest.a((PlaceReviewXoutString) new PlaceReviewXoutString().a("input", graphQlCallInput))), new C13544(placeReviewItemPartDefinition));
    }

    @Nullable
    public static String m14698b(GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        return graphQLPlaceReviewFeedUnitItem.l() == null ? null : graphQLPlaceReviewFeedUnitItem.l().ae();
    }

    @Nullable
    private static StaticMapOptions m14700e(GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        if (graphQLPlaceReviewFeedUnitItem.l() == null || graphQLPlaceReviewFeedUnitItem.l().az() == null) {
            return null;
        }
        GraphQLLocation az = graphQLPlaceReviewFeedUnitItem.l().az();
        return new StaticMapOptions("place_review_ego_unit").a(az.a(), az.b()).a(13);
    }

    public static int m14701f(PlaceReviewItemPartDefinition placeReviewItemPartDefinition, GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        GraphQLContactRecommendationField i = m14705i(graphQLPlaceReviewFeedUnitItem);
        return i == null ? 0 : i.q();
    }

    @Nullable
    public static String m14703g(PlaceReviewItemPartDefinition placeReviewItemPartDefinition, GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        GraphQLContactRecommendationField i = m14705i(graphQLPlaceReviewFeedUnitItem);
        return (i == null || i.y() == null) ? null : i.y().a();
    }

    @Nullable
    public static GraphQLPrivacyOption m14704h(PlaceReviewItemPartDefinition placeReviewItemPartDefinition, GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        GraphQLContactRecommendationField i = m14705i(graphQLPlaceReviewFeedUnitItem);
        return (i == null || i.s() == null || i.s().p() == null || i.s().p().a() == null || i.s().p().a().isEmpty()) ? null : ((GraphQLPrivacyOptionsContentEdge) i.s().p().a().get(0)).j();
    }

    @Nullable
    private static GraphQLContactRecommendationField m14705i(GraphQLPlaceReviewFeedUnitItem graphQLPlaceReviewFeedUnitItem) {
        return graphQLPlaceReviewFeedUnitItem.l() == null ? null : graphQLPlaceReviewFeedUnitItem.l().cA();
    }

    public static void m14699d(PlaceReviewItemPartDefinition placeReviewItemPartDefinition, Props props) {
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        ArrayNode f = m14702f(props);
        String b = m14698b(props.f12968a);
        if (NewsFeedAnalyticsEventBuilder.B(f)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent b2 = new HoneyClientEvent("place_review_ego_launched_review_composer").a("tracking", f).b("page_id", b);
            b2.c = "native_newsfeed";
            honeyAnalyticsEvent = b2;
        }
        placeReviewItemPartDefinition.f12983d.b(honeyAnalyticsEvent);
    }

    public static ArrayNode m14702f(Props props) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        arrayNode.a(FeedTrackableUtil.a(props.f12968a));
        arrayNode.h(props.f12969b.k());
        return arrayNode;
    }
}
