package com.facebook.feedplugins.graphqlstory.location;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.CommonEventsBuilder;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.NavigationLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.checkin.rows.BaseCheckinStoryPartDefinition;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.util.ContextPrecondition;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.feedplugins.graphqlstory.location.ui.SavableLocationView;
import com.facebook.graphql.model.GraphQLGeoRectangle;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLLocation;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.ExternalMapLauncher;
import com.facebook.maps.rows.MapPartDefinition;
import com.facebook.maps.rows.MapPartDefinition.Props;
import com.facebook.maps.rows.MapSizeHelper;
import com.facebook.maps.rows.PrefetchMapPartDefinition;
import com.facebook.maps.rows.StaticMapOptionsHelper;
import com.facebook.maps.rows.TravelStoryHelper;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: new_ccu_upload */
public class LocationPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStoryAttachment>, HoneyClientEvent, FeedEnvironment, SavableLocationView> {
    public static final ViewType f7136a = new C03411();
    private static LocationPartDefinition f7137p;
    private static final Object f7138q = new Object();
    public final Lazy<AnalyticsLogger> f7139b;
    private final Context f7140c;
    private final BackgroundPartDefinition f7141d;
    private final CommonEventsBuilder f7142e;
    private final TextLinkPartDefinition f7143f;
    private final MapPartDefinition f7144g;
    private final PrefetchMapPartDefinition f7145h;
    public final Lazy<NavigationLogger> f7146i;
    public final Lazy<ExternalMapLauncher> f7147j;
    private final ClickListenerPartDefinition f7148k;
    private final BaseCheckinStoryPartDefinition f7149l;
    private final TravelStoryHelper f7150m;
    private final QeAccessor f7151n;
    private final MapSizeHelper f7152o;

    /* compiled from: new_ccu_upload */
    final class C03411 extends ViewType {
        C03411() {
        }

        public final View m7475a(Context context) {
            return new SavableLocationView(context);
        }
    }

    private static LocationPartDefinition m7470b(InjectorLike injectorLike) {
        return new LocationPartDefinition((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 175), BackgroundPartDefinition.a(injectorLike), CommonEventsBuilder.b(injectorLike), TextLinkPartDefinition.a(injectorLike), MapPartDefinition.m7476a(injectorLike), PrefetchMapPartDefinition.m7480a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 137), IdBasedSingletonScopeProvider.b(injectorLike, 7475), ClickListenerPartDefinition.a(injectorLike), BaseCheckinStoryPartDefinition.m7445a(injectorLike), TravelStoryHelper.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), MapSizeHelper.m7484a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m7473a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1202087092);
        m7468a((FeedProps) obj, (HoneyClientEvent) obj2, (SavableLocationView) view);
        Logger.a(8, EntryType.MARK_POP, 497132136, a);
    }

    public static LocationPartDefinition m7466a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LocationPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7138q) {
                LocationPartDefinition locationPartDefinition;
                if (a2 != null) {
                    locationPartDefinition = (LocationPartDefinition) a2.a(f7138q);
                } else {
                    locationPartDefinition = f7137p;
                }
                if (locationPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m7470b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7138q, b3);
                        } else {
                            f7137p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = locationPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LocationPartDefinition(Context context, Lazy<AnalyticsLogger> lazy, BackgroundPartDefinition backgroundPartDefinition, CommonEventsBuilder commonEventsBuilder, TextLinkPartDefinition textLinkPartDefinition, MapPartDefinition mapPartDefinition, PrefetchMapPartDefinition prefetchMapPartDefinition, Lazy<NavigationLogger> lazy2, Lazy<ExternalMapLauncher> lazy3, ClickListenerPartDefinition clickListenerPartDefinition, BaseCheckinStoryPartDefinition baseCheckinStoryPartDefinition, TravelStoryHelper travelStoryHelper, QeAccessor qeAccessor, MapSizeHelper mapSizeHelper) {
        ContextPrecondition.a(context);
        this.f7140c = context;
        this.f7139b = lazy;
        this.f7141d = backgroundPartDefinition;
        this.f7142e = commonEventsBuilder;
        this.f7143f = textLinkPartDefinition;
        this.f7144g = mapPartDefinition;
        this.f7145h = prefetchMapPartDefinition;
        this.f7146i = lazy2;
        this.f7147j = lazy3;
        this.f7148k = clickListenerPartDefinition;
        this.f7149l = baseCheckinStoryPartDefinition;
        this.f7150m = travelStoryHelper;
        this.f7151n = qeAccessor;
        this.f7152o = mapSizeHelper;
    }

    public final ViewType m7471a() {
        return f7136a;
    }

    public final boolean m7474a(Object obj) {
        return true;
    }

    private HoneyClientEvent m7465a(SubParts<FeedEnvironment> subParts, FeedProps<GraphQLStoryAttachment> feedProps) {
        Object stylingData;
        FeedProps e = AttachmentProps.e(feedProps);
        GraphQLStory graphQLStory = (GraphQLStory) e.a();
        GraphQLPlace a = m7467a(graphQLStory);
        if (this.f7151n.a(ExperimentsForCheckinAbTestModule.f13674j, false)) {
            stylingData = new StylingData(e, PaddingStyle.a, 2130840178, -1);
        } else {
            stylingData = new StylingData(e, PaddingStyle.a, 2130840171, -1);
        }
        subParts.a(this.f7141d, stylingData);
        if (a != null) {
            StaticMapOptions a2;
            boolean z;
            int a3;
            GraphQLLocation z2 = a.z();
            GraphQLGeoRectangle A = a.A();
            if (this.f7150m.a(graphQLStory)) {
                a2 = TravelStoryHelper.a(graphQLStory, "checkin_story");
                z = false;
            } else {
                a2 = StaticMapOptionsHelper.m14455a(A, "checkin_story", z2);
                z = true;
            }
            int a4 = this.f7152o.m7487a(e);
            int a5 = this.f7152o.m7486a();
            boolean b = TravelStoryHelper.b(graphQLStory);
            if (!b && this.f7151n.a(ExperimentsForCheckinAbTestModule.f13667c, false)) {
                a5 = MapSizeHelper.m7483a(a4, 1.9f);
            }
            if (b && this.f7151n.a(ExperimentsForCheckinAbTestModule.f13668d, false)) {
                a3 = MapSizeHelper.m7483a(a4, 1.9f);
            } else {
                a3 = a5;
            }
            subParts.a(2131564018, this.f7144g, new Props(a2, z, a4, a3));
            subParts.a(2131564018, this.f7148k, m7464a(e, a));
            subParts.a(2131564018, this.f7145h, new PrefetchMapPartDefinition.Props(e, a2, a4, a3));
        }
        subParts.a(this.f7143f, e);
        subParts.a(2131562015, this.f7149l, new BaseCheckinStoryPartDefinition.Props(graphQLStory, a, true));
        return m7469b(e, a);
    }

    private void m7468a(FeedProps<GraphQLStoryAttachment> feedProps, HoneyClientEvent honeyClientEvent, SavableLocationView savableLocationView) {
        FeedProps e = AttachmentProps.e(feedProps);
        savableLocationView.f13362a.m14450a(e, m7467a((GraphQLStory) e.a), honeyClientEvent);
    }

    private OnClickListener m7464a(final FeedProps<GraphQLStory> feedProps, final GraphQLPlace graphQLPlace) {
        return new OnClickListener(this) {
            final /* synthetic */ LocationPartDefinition f13682c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -994281802);
                ((NavigationLogger) this.f13682c.f7146i.get()).a("tap_story_attachment");
                AnalyticsLogger analyticsLogger = (AnalyticsLogger) this.f13682c.f7139b.get();
                HoneyClientEvent honeyClientEvent = new HoneyClientEvent("checkin_story_map_opened_on_savable_story");
                honeyClientEvent.c = "native_newsfeed";
                analyticsLogger.a(honeyClientEvent.a("tracking", TrackableFeedProps.a(feedProps)).b("place_id", graphQLPlace.x()));
                ExternalMapLauncher externalMapLauncher = (ExternalMapLauncher) this.f13682c.f7147j.get();
                Context context = view.getContext();
                String curationSurface = CurationSurface.NATIVE_STORY.toString();
                double a2 = graphQLPlace.z().a();
                double b = graphQLPlace.z().b();
                String B = graphQLPlace.B();
                String m = (graphQLPlace.k() == null || TextUtils.isEmpty(graphQLPlace.k().p())) ? null : graphQLPlace.k().m();
                externalMapLauncher.a(context, curationSurface, a2, b, B, m);
                LogUtils.a(481950249, a);
            }
        };
    }

    @Nullable
    private HoneyClientEvent m7469b(FeedProps<GraphQLStory> feedProps, GraphQLPlace graphQLPlace) {
        return this.f7142e.a(graphQLPlace.X(), StoryProps.p(feedProps), TrackableFeedProps.a(feedProps), "native_newsfeed");
    }

    private GraphQLPlace m7467a(GraphQLStory graphQLStory) {
        GraphQLStoryAttachment o = StoryAttachmentHelper.o(graphQLStory);
        if (o != null && this.f7150m.a(graphQLStory)) {
            return TravelStoryHelper.a(o.z());
        }
        if (GraphQLHelper.m(graphQLStory)) {
            return graphQLStory.Y();
        }
        if (GraphQLHelper.n(graphQLStory)) {
            return TravelStoryHelper.a(o.z());
        }
        return null;
    }
}
