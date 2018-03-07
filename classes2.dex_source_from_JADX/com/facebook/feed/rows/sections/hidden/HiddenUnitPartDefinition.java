package com.facebook.feed.rows.sections.hidden;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.common.android.FragmentActivityMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.animation.CollapseAnimation;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.FeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.HiddenUnitView;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.graphql.model.NegativeFeedbackActionsUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: java.lang.ref.WeakReference */
public class HiddenUnitPartDefinition<T extends HideableUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, Void, HasFeedListType, HiddenUnitView> {
    public static final ViewType f18676a = new C07411();
    private static HiddenUnitPartDefinition f18677j;
    private static final Object f18678k = new Object();
    private final ClickListenerPartDefinition f18679b;
    public final FragmentActivity f18680c;
    private final IFeedIntentBuilder f18681d;
    private final AnalyticsLogger f18682e;
    private final NewsFeedAnalyticsEventBuilder f18683f;
    public final QeAccessor f18684g;
    private final Lazy<FbErrorReporter> f18685h;
    private final OptimisticStoryStateCache f18686i;

    /* compiled from: java.lang.ref.WeakReference */
    final class C07411 extends ViewType {
        C07411() {
        }

        public final View mo1995a(Context context) {
            return new HiddenUnitView(context);
        }
    }

    private static HiddenUnitPartDefinition m26205b(InjectorLike injectorLike) {
        return new HiddenUnitPartDefinition(ClickListenerPartDefinition.m19353a(injectorLike), FragmentActivityMethodAutoProvider.m15506b(injectorLike), DefaultFeedIntentBuilder.m26214a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), QeInternalImplMethodAutoProvider.m3744a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494), OptimisticStoryStateCache.m9726a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.mo2756a(this.f18679b, new 2(this, (FeedProps) obj, (HasFeedListType) anyEnvironment));
        return null;
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        HiddenUnitView hiddenUnitView = (HiddenUnitView) view;
        if (hiddenUnitView.f != null && !hiddenUnitView.f.hasEnded()) {
            hiddenUnitView.f.cancel();
            hiddenUnitView.f = null;
        }
    }

    public static HiddenUnitPartDefinition m26199a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HiddenUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f18678k) {
                HiddenUnitPartDefinition hiddenUnitPartDefinition;
                if (a2 != null) {
                    hiddenUnitPartDefinition = (HiddenUnitPartDefinition) a2.mo818a(f18678k);
                } else {
                    hiddenUnitPartDefinition = f18677j;
                }
                if (hiddenUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m26205b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f18678k, b3);
                        } else {
                            f18677j = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = hiddenUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public HiddenUnitPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, FragmentActivity fragmentActivity, IFeedIntentBuilder iFeedIntentBuilder, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, QeAccessor qeAccessor, Lazy<FbErrorReporter> lazy, OptimisticStoryStateCache optimisticStoryStateCache) {
        this.f18679b = clickListenerPartDefinition;
        this.f18680c = fragmentActivity;
        this.f18681d = iFeedIntentBuilder;
        this.f18682e = analyticsLogger;
        this.f18683f = newsFeedAnalyticsEventBuilder;
        this.f18684g = qeAccessor;
        this.f18685h = lazy;
        this.f18686i = optimisticStoryStateCache;
    }

    public final ViewType mo2547a() {
        return f18676a;
    }

    public final boolean m26210a(Object obj) {
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m26202a(com.facebook.feed.rows.sections.hidden.HiddenUnitPartDefinition r9, android.content.Context r10, com.facebook.feed.rows.core.props.FeedProps r11, com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation r12) {
        /*
        r6 = r11.f13444a;
        r0 = r6;
        r0 = (com.facebook.graphql.model.HideableUnit) r0;
        if (r0 == 0) goto L_0x000d;
    L_0x0007:
        r1 = r0.mo2881q();
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r1 = com.facebook.feed.rows.core.props.TrackableFeedProps.m27452b(r11);
        r1 = r1.toString();
        r2 = m26206b(r0);
        if (r2 == 0) goto L_0x0055;
    L_0x001c:
        r6 = com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation.NEWSFEED;
        if (r12 != r6) goto L_0x00a0;
    L_0x0020:
        r6 = 1;
    L_0x0021:
        r2 = r6;
        if (r2 != 0) goto L_0x0030;
    L_0x0024:
        r6 = 0;
        r7 = com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation.TIMELINE_SELF;
        if (r12 == r7) goto L_0x00a2;
    L_0x0029:
        r7 = com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE;
        if (r12 == r7) goto L_0x00a2;
    L_0x002d:
        r2 = r6;
        if (r2 == 0) goto L_0x0055;
    L_0x0030:
        r2 = new com.facebook.negativefeedback.logging.NegativeFeedbackAnalyticsLogger$ParamsBuilder;
        r2.<init>();
        r1 = r2.a(r1);
        r0 = m26206b(r0);
        r2 = r12.stringValueOf();
        r6 = r1.b;
        r1 = r6;
        r0 = com.facebook.negativefeedback.ui.NegativeFeedbackDialogFragment.a(r0, r2, r1);
        r6 = r9.f18680c;
        r6 = r6.kO_();
        r1 = r6;
        r2 = "dialog";
        r0.m213a(r1, r2);
        goto L_0x000d;
    L_0x0055:
        r2 = r0.mo2881q();
        r6 = new com.facebook.analytics.logger.HoneyClientEvent;
        r7 = "requested_afro_faceweb";
        r6.<init>(r7);
        r7 = "hideable_token";
        r6 = r6.m5090b(r7, r2);
        r7 = "native_newsfeed";
        r6.f3099c = r7;
        r6 = r6;
        r2 = r6;
        r3 = r9.f18682e;
        r3.mo526a(r2);
        r2 = com.facebook.common.fblinks.FBLinks.cA;
        r3 = 5;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r0.mo2881q();
        r3[r4] = r5;
        r4 = 1;
        r5 = m26206b(r0);
        r3[r4] = r5;
        r4 = 2;
        r0 = m26200a(r0);
        r3[r4] = r0;
        r0 = 3;
        r4 = r12.stringValueOf();
        r3[r0] = r4;
        r0 = 4;
        r3[r0] = r1;
        r0 = com.facebook.common.util.StringLocaleUtil.m21640a(r2, r3);
        r1 = r9.f18681d;
        r1.mo3016a(r10, r0);
        goto L_0x000d;
    L_0x00a0:
        r6 = 0;
        goto L_0x0021;
    L_0x00a2:
        r7 = r9.f18684g;
        r8 = com.facebook.feed.rows.abtest.ExperimentsForMultipleRowsStoriesAbtestModule.f6723m;
        r6 = r7.mo596a(r8, r6);
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.rows.sections.hidden.HiddenUnitPartDefinition.a(com.facebook.feed.rows.sections.hidden.HiddenUnitPartDefinition, android.content.Context, com.facebook.feed.rows.core.props.FeedProps, com.facebook.common.negativefeedback.NegativeFeedbackExperienceLocation):void");
    }

    private void m26201a(FeedProps<T> feedProps, HasFeedListType hasFeedListType, HiddenUnitView hiddenUnitView) {
        HideableUnit hideableUnit = (HideableUnit) feedProps.f13444a;
        if (hideableUnit.mo2879o() == StoryVisibility.GONE) {
            hiddenUnitView.setContentVisibility(8);
            return;
        }
        hiddenUnitView.setContentVisibility(0);
        if (hideableUnit.mo2879o() == StoryVisibility.CONTRACTING) {
            int p = hideableUnit.mo2880p();
            int height = hiddenUnitView.getHeight();
            hiddenUnitView.a.setVisibility(0);
            hiddenUnitView.a.getLayoutParams().height = p;
            hiddenUnitView.f = new CollapseAnimation(hiddenUnitView.a, p, height);
            hiddenUnitView.f.setDuration(200);
            hiddenUnitView.startAnimation(hiddenUnitView.f);
        } else {
            hiddenUnitView.a.setVisibility(8);
        }
        m26203a(hiddenUnitView, hideableUnit, m26198a(this, hasFeedListType.mo2446c()));
    }

    public static NegativeFeedbackExperienceLocation m26198a(HiddenUnitPartDefinition hiddenUnitPartDefinition, FeedListType feedListType) {
        switch (3.a[feedListType.mo2419a().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return NegativeFeedbackExperienceLocation.NEWSFEED;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return NegativeFeedbackExperienceLocation.PERMALINK;
            case 3:
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
            case 5:
            case 6:
                return NegativeFeedbackExperienceLocation.GROUP;
            case 7:
                return NegativeFeedbackExperienceLocation.EVENT;
            case HTTPTransportCallback.LAST_BODY_BYTE_ACKED /*8*/:
            case 9:
                return NegativeFeedbackExperienceLocation.TIMELINE_SELF;
            case 10:
                return NegativeFeedbackExperienceLocation.THROWBACK;
            case 11:
            case 12:
                return NegativeFeedbackExperienceLocation.TIMELINE_SOMEONE_ELSE;
            case 13:
                return NegativeFeedbackExperienceLocation.PAGE_TIMELINE;
            case 14:
            case 15:
                return NegativeFeedbackExperienceLocation.VIDEO_CHANNEL;
            default:
                ((AbstractFbErrorReporter) hiddenUnitPartDefinition.f18685h.get()).m2350b("Unknown FeedListType", "FeedLitType was " + feedListType.mo2419a().name());
                return NegativeFeedbackExperienceLocation.UNKNOWN;
        }
    }

    private boolean m26204a(FeedUnit feedUnit) {
        if (!(feedUnit instanceof GraphQLStory)) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) feedUnit;
        if ((graphQLStory.m22350c() != null || !this.f18686i.m9730b(graphQLStory)) && graphQLStory.m22330P()) {
            return true;
        }
        return false;
    }

    private void m26203a(HiddenUnitView hiddenUnitView, HideableUnit hideableUnit, NegativeFeedbackExperienceLocation negativeFeedbackExperienceLocation) {
        TextView textView = hiddenUnitView.b;
        TextView textView2 = hiddenUnitView.c;
        View view = hiddenUnitView.d;
        textView.setVisibility(0);
        textView.setText(2131233438);
        textView2.setVisibility(8);
        view.setVisibility(8);
        if (hideableUnit instanceof NegativeFeedbackActionsUnit) {
            GraphQLNegativeFeedbackActionType s = ((NegativeFeedbackActionsUnit) hideableUnit).mo2893s();
            if (s == GraphQLNegativeFeedbackActionType.HIDE && negativeFeedbackExperienceLocation == NegativeFeedbackExperienceLocation.VIDEO_CHANNEL) {
                hiddenUnitView.setContentVisibility(8);
            }
            if (s != null && negativeFeedbackExperienceLocation == NegativeFeedbackExperienceLocation.TIMELINE_SELF && (s == GraphQLNegativeFeedbackActionType.UNTAG || s == GraphQLNegativeFeedbackActionType.HIDE_FROM_TIMELINE)) {
                textView2.setText(2131233437);
                textView2.setVisibility(0);
                view.setVisibility(0);
                textView.setText(2131233439);
            } else {
                textView2.setVisibility(8);
                view.setVisibility(8);
            }
            if (hideableUnit.mo2881q() == null || m26204a((FeedUnit) hideableUnit)) {
                textView.setVisibility(8);
            }
        }
    }

    private static String m26200a(HideableUnit hideableUnit) {
        if (!(hideableUnit instanceof NegativeFeedbackActionsUnit)) {
            return "HIDE";
        }
        GraphQLNegativeFeedbackActionType s = ((NegativeFeedbackActionsUnit) hideableUnit).mo2893s();
        if (s == null) {
            return "HIDE";
        }
        return s.name();
    }

    private static String m26206b(HideableUnit hideableUnit) {
        if (hideableUnit instanceof NegativeFeedbackActionsUnit) {
            return ((NegativeFeedbackActionsUnit) hideableUnit).mo2892r();
        }
        return null;
    }
}
