package com.facebook.feed.rows.sections;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.external.AdInterfacesIntentUtil;
import com.facebook.adinterfaces.external.abtest.ExperimentsForAdInterfacesExternalModule;
import com.facebook.adinterfaces.external.events.AdInterfacesExternalEventBus;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.BoostedComponentModule;
import com.facebook.adinterfaces.external.logging.AdInterfacesExternalLogger.Event;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.config.application.FbAppType;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.views.StoryInsightsFooterView;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.model.GraphQLBoostedComponent;
import com.facebook.graphql.model.GraphQLBoostedComponentMessage;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryInsights;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.graphql.model.StorySponsoredHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: feedback_node_id */
public class StoryPromotionPartDefinition<E extends HasFeedListType & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, State, E, StoryInsightsFooterView> {
    public static final ViewType f24422a = new C09881();
    private static final Map<FeedListName, String> f24423b = ImmutableMap.of(FeedListName.PERMALINK, "permalink", FeedListName.PAGE_TIMELINE, "new_timeline", FeedListName.FEED, "story");
    private static StoryPromotionPartDefinition f24424k;
    private static final Object f24425l = new Object();
    private final FeedStoryUtil f24426c;
    private final BackgroundPartDefinition f24427d;
    public final SecureContextHelper f24428e;
    private final AdInterfacesExternalEventBus f24429f;
    public final AdInterfacesExternalLogger f24430g;
    private final QeAccessor f24431h;
    public final AbstractFbErrorReporter f24432i;
    public final FbAppType f24433j;

    /* compiled from: feedback_node_id */
    final class C09881 extends ViewType {
        C09881() {
        }

        public final View mo1995a(Context context) {
            return new StoryInsightsFooterView(context);
        }
    }

    private static StoryPromotionPartDefinition m32733b(InjectorLike injectorLike) {
        return new StoryPromotionPartDefinition(FeedStoryUtil.m18578a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), DefaultSecureContextHelper.m4636a(injectorLike), AdInterfacesExternalEventBus.m32747a(injectorLike), AdInterfacesExternalLogger.m32748a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), FbErrorReporterImpl.m2317a(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    public static StoryPromotionPartDefinition m32727a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryPromotionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24425l) {
                StoryPromotionPartDefinition storyPromotionPartDefinition;
                if (a2 != null) {
                    storyPromotionPartDefinition = (StoryPromotionPartDefinition) a2.mo818a(f24425l);
                } else {
                    storyPromotionPartDefinition = f24424k;
                }
                if (storyPromotionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32733b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24425l, b3);
                        } else {
                            f24424k = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = storyPromotionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        boolean z;
        FeedProps feedProps = (FeedProps) obj;
        HasFeedListType hasFeedListType = (HasFeedListType) anyEnvironment;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f24427d, new StylingData(feedProps, PaddingStyle.f13071a));
        if (graphQLStory.av() == null || graphQLStory.av().mo2904b() == null || !"Event".equals(graphQLStory.av().mo2904b().m22299e())) {
            z = false;
        } else {
            z = true;
        }
        boolean z2 = z;
        State state = new State(z2, (String) f24423b.get(hasFeedListType.mo2446c().mo2419a()));
        state.c = m32726a(state);
        state.e = m32726a(state);
        state.h = graphQLStory;
        state.g = m32724a(this, graphQLStory, z2);
        state.e = m32730a(graphQLStory) ? state.c : m32732b(state, state.b);
        return state;
    }

    public final boolean m32743a(Object obj) {
        return this.f24426c.m18591c((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        StoryInsightsFooterView storyInsightsFooterView = (StoryInsightsFooterView) view;
        storyInsightsFooterView.setViewInsightsClickListener(null);
        storyInsightsFooterView.setReachCountClickListener(null);
        storyInsightsFooterView.setBoostBarClickListener(null);
        storyInsightsFooterView.setExtendedFooterViewClickListener(null);
        this.f24429f.m4569b(state.f);
    }

    @Inject
    public StoryPromotionPartDefinition(FeedStoryUtil feedStoryUtil, BackgroundPartDefinition backgroundPartDefinition, SecureContextHelper secureContextHelper, AdInterfacesExternalEventBus adInterfacesExternalEventBus, AdInterfacesExternalLogger adInterfacesExternalLogger, QeAccessor qeAccessor, AbstractFbErrorReporter abstractFbErrorReporter, FbAppType fbAppType) {
        this.f24426c = feedStoryUtil;
        this.f24427d = backgroundPartDefinition;
        this.f24428e = secureContextHelper;
        this.f24429f = adInterfacesExternalEventBus;
        this.f24430g = adInterfacesExternalLogger;
        this.f24431h = qeAccessor;
        this.f24432i = abstractFbErrorReporter;
        this.f24433j = fbAppType;
    }

    public final ViewType mo2547a() {
        return f24422a;
    }

    private void m32728a(FeedProps<GraphQLStory> feedProps, State state, StoryInsightsFooterView storyInsightsFooterView) {
        String a;
        boolean z;
        int q;
        int l;
        int n;
        int j;
        int a2;
        String str = null;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        BoostedComponentModule boostedComponentModule = m32738e(this, graphQLStory) ? BoostedComponentModule.BOOSTED_EVENT_MOBILE_MODULE : BoostedComponentModule.BOOSTED_POST_MOBILE_MODULE;
        if (FeedStoryUtil.m18584d(state.h) != null) {
            a = FeedStoryUtil.m18584d(state.h).mo2911a();
        } else {
            a = null;
        }
        AdInterfacesExternalLogger adInterfacesExternalLogger = this.f24430g;
        Event c = m32736c(state.h);
        if (StoryActorHelper.m27492b(graphQLStory) != null) {
            str = StoryActorHelper.m27492b(graphQLStory).m23765H();
        }
        String str2 = state.b;
        String ai = graphQLStory.ai();
        if (a != null) {
            z = true;
        } else {
            z = false;
        }
        adInterfacesExternalLogger.m32751a(boostedComponentModule, c, str, str2, ai, a, z);
        state.d = storyInsightsFooterView;
        GraphQLStoryInsights ag = graphQLStory.ag();
        if (ag != null) {
            q = ag.m24401q();
            l = ag.m24396l();
            n = ag.m24398n();
            j = ag.m24394j();
            a2 = ag.m24390a();
        } else {
            a2 = 0;
            j = 0;
            n = 0;
            l = 0;
            q = 0;
        }
        storyInsightsFooterView.a(q, l, n, j, a2);
        storyInsightsFooterView.setButtonText(state.g);
        storyInsightsFooterView.setViewInsightsClickListener(state.e);
        storyInsightsFooterView.setReachCountClickListener(state.c);
        storyInsightsFooterView.setBoostBarClickListener(state.c);
        storyInsightsFooterView.setExtendedFooterViewClickListener(state.c);
    }

    private OnClickListener m32726a(State state) {
        return new 2(this, state);
    }

    private OnClickListener m32732b(State state, String str) {
        if (!m32739f(state.h)) {
            return new 4(this, state, str);
        }
        GraphQLBoostedComponentMessage n;
        3 3;
        GraphQLBoostedComponent an = state.h.an();
        if (an != null) {
            n = an.m24670n();
        } else {
            n = null;
        }
        GraphQLBoostedComponentMessage graphQLBoostedComponentMessage = n;
        if (graphQLBoostedComponentMessage == null) {
            3 = null;
        } else {
            3 = new 3(this, state, graphQLBoostedComponentMessage, graphQLBoostedComponentMessage.a());
        }
        return 3;
    }

    public static int m32723a(StoryPromotionPartDefinition storyPromotionPartDefinition, GraphQLStory graphQLStory, int i) {
        if (m32738e(storyPromotionPartDefinition, graphQLStory)) {
            return 2131233536;
        }
        return i == 2131234090 ? 2131234090 : 2131234020;
    }

    private boolean m32730a(GraphQLStory graphQLStory) {
        return (StorySponsoredHelper.m29214a(graphQLStory) == GraphQLBoostedPostStatus.ERROR || StorySponsoredHelper.m29214a(graphQLStory) == GraphQLBoostedPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) && !m32739f(graphQLStory);
    }

    public static void m32729a(StoryPromotionPartDefinition storyPromotionPartDefinition, State state, StoryInsightsFooterView storyInsightsFooterView, String str, int i) {
        storyPromotionPartDefinition.f24428e.mo662a(storyPromotionPartDefinition.m32725a(storyInsightsFooterView, state.h, str, i), storyInsightsFooterView.getContext());
        state.f = new 5(storyPromotionPartDefinition, state, storyInsightsFooterView);
        storyPromotionPartDefinition.f24429f.m4568a(state.f);
    }

    private Intent m32725a(StoryInsightsFooterView storyInsightsFooterView, GraphQLStory graphQLStory, String str, int i) {
        String str2 = null;
        if (m32738e(this, graphQLStory)) {
            Context context = storyInsightsFooterView.getContext();
            String b = m32734b(graphQLStory);
            String c = graphQLStory.m22350c();
            String ai = graphQLStory.ai();
            if (StoryActorHelper.m27492b(graphQLStory) != null) {
                str2 = StoryActorHelper.m27492b(graphQLStory).m23765H();
            }
            return AdInterfacesIntentUtil.a(context, i, b, c, ai, str2, str);
        }
        return AdInterfacesIntentUtil.a(storyInsightsFooterView.getContext(), i, graphQLStory.m22350c(), graphQLStory.ai(), StoryActorHelper.m27492b(graphQLStory) != null ? StoryActorHelper.m27492b(graphQLStory).m23765H() : null, str, this.f24431h.mo596a(ExperimentsForAdInterfacesExternalModule.c, false));
    }

    @Nullable
    private static String m32734b(GraphQLStory graphQLStory) {
        if (graphQLStory.av() == null || graphQLStory.av().mo2904b() == null || graphQLStory.av().mo2904b().m22301g() != 67338874) {
            return null;
        }
        return graphQLStory.av().mo2906d();
    }

    public static void m32735b(StoryPromotionPartDefinition storyPromotionPartDefinition, StoryInsightsFooterView storyInsightsFooterView, GraphQLStory graphQLStory, String str, int i) {
        storyPromotionPartDefinition.f24428e.mo662a(AdInterfacesIntentUtil.a(storyInsightsFooterView.getContext(), 2131233525, str, graphQLStory.m22350c(), storyPromotionPartDefinition.m32725a(storyInsightsFooterView, graphQLStory, "post_insights", m32723a(storyPromotionPartDefinition, graphQLStory, i))), storyInsightsFooterView.getContext());
    }

    private static Event m32736c(GraphQLStory graphQLStory) {
        switch (6.a[StorySponsoredHelper.m29214a(graphQLStory).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return Event.EVENT_RENDER_CREATE_ENTRY_POINT;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
            case 7:
                return Event.EVENT_RENDER_EDIT_ENTRY_POINT;
            default:
                if (graphQLStory.an() == null || graphQLStory.an().m24670n() == null) {
                    return Event.EVENT_RENDER_INSIGHTS_ENTRY_POINT;
                }
                return Event.EVENT_RENDER_FAIL_ENTRY_POINT;
        }
    }

    public static int m32724a(StoryPromotionPartDefinition storyPromotionPartDefinition, GraphQLStory graphQLStory, boolean z) {
        return m32738e(storyPromotionPartDefinition, graphQLStory) ? storyPromotionPartDefinition.m32737d(graphQLStory) : storyPromotionPartDefinition.m32731b(graphQLStory, z);
    }

    private int m32731b(GraphQLStory graphQLStory, boolean z) {
        switch (6.a[StorySponsoredHelper.m29214a(graphQLStory).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return z ? 2131234090 : 2131234020;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 2131233533;
            case 3:
                return 2131233532;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                return 2131233530;
            case 6:
            case 7:
                return 2131233531;
            default:
                if (m32739f(graphQLStory)) {
                    return 2131234108;
                }
                return 2131233525;
        }
    }

    private int m32737d(GraphQLStory graphQLStory) {
        switch (6.a[StorySponsoredHelper.m29214a(graphQLStory).ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return 2131233536;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return 2131233540;
            case 3:
                return 2131233541;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
                return 2131233537;
            case 6:
                return 2131233538;
            case 7:
                return 2131233539;
            case 10:
                return 2131233542;
            default:
                if (m32739f(graphQLStory)) {
                    return 2131234108;
                }
                return 2131233525;
        }
    }

    public static boolean m32738e(StoryPromotionPartDefinition storyPromotionPartDefinition, GraphQLStory graphQLStory) {
        return (m32734b(graphQLStory) == null || StoryActionLinkHelper.m28072a(graphQLStory, 957043670) == null || !storyPromotionPartDefinition.f24431h.mo596a(ExperimentsForAdInterfacesExternalModule.b, false)) ? false : true;
    }

    private boolean m32739f(GraphQLStory graphQLStory) {
        return FeedStoryUtil.m18584d(graphQLStory) != null;
    }
}
