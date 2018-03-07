package com.facebook.feedplugins.graphqlstory.followup;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.controller.mutation.util.FeedbackGraphQLGenerator;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.animation.CollapseAnimation;
import com.facebook.feed.data.followup.cache.FollowUpStateCache;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.logging.viewport.FeedLoggingViewportEventListener;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
import com.facebook.feed.thirdparty.instagram.InstagramEntryPoint;
import com.facebook.feed.thirdparty.instagram.InstagramUtils;
import com.facebook.feed.ui.chaining.HScrollChainingView;
import com.facebook.feed.ui.chaining.HScrollChainingViewController;
import com.facebook.feed.ui.chaining.HScrollChainingViewController.ItemListRecyclablePagerAdapter;
import com.facebook.feed.ui.chaining.HScrollChainingViewControllerManager;
import com.facebook.graphql.enums.ChainingSectionViewState;
import com.facebook.graphql.model.GraphQLArticleChainingFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.PropertyHelper;
import com.facebook.graphql.model.ScrollableItemListFeedUnit;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: imp_seq */
public class FollowUpPartDefinition<E extends HasInvalidate & HasPersistentState & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<GraphQLStory, State, E, HScrollChainingView> implements HasSpecialStyling {
    public static final ViewType f20323a = new C08221();
    private static FollowUpPartDefinition f20324l;
    private static final Object f20325m = new Object();
    private final ScreenUtil f20326b;
    public final FeedLoggingViewportEventListener f20327c;
    private final Lazy<HScrollChainingViewControllerManager> f20328d;
    private final AbstractFbErrorReporter f20329e;
    private final Lazy<RecyclableViewPoolManager> f20330f;
    public final AnalyticsLogger f20331g;
    private final NewsFeedAnalyticsEventBuilder f20332h;
    public final InstagramUtils f20333i;
    public final Lazy<FeedbackGraphQLGenerator> f20334j;
    private final FollowUpStateCache f20335k;

    /* compiled from: imp_seq */
    final class C08221 extends ViewType {
        C08221() {
        }

        public final View mo1995a(Context context) {
            return new HScrollChainingView(context);
        }
    }

    private static FollowUpPartDefinition m27988b(InjectorLike injectorLike) {
        return new FollowUpPartDefinition(FeedLoggingViewportEventListener.m15105a(injectorLike), IdBasedLazy.m1808a(injectorLike, 6074), FbErrorReporterImpl.m2317a(injectorLike), AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), NewsFeedAnalyticsEventBuilder.m14112a(injectorLike), IdBasedLazy.m1808a(injectorLike, 3581), ScreenUtil.m8695a(injectorLike), InstagramUtils.m22703a(injectorLike), IdBasedLazy.m1808a(injectorLike, 995), FollowUpStateCache.m14602a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        CacheableEntity cacheableEntity = (GraphQLStory) obj;
        HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        2 2 = new 2(this, cacheableEntity);
        InstagramEntryPoint entryPoint = InstagramEntryPoint.getEntryPoint(this.f20335k.m14607b(cacheableEntity.mo2507g()));
        FollowUpPersistentState followUpPersistentState = (FollowUpPersistentState) ((HasPersistentState) hasInvalidate).mo2425a(new FollowUpPersistentStateKey(cacheableEntity), cacheableEntity);
        return new State(new 3(this, entryPoint, cacheableEntity), new 4(this, cacheableEntity, followUpPersistentState), new 5(this, cacheableEntity, hasInvalidate), 2, followUpPersistentState, entryPoint);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        GraphQLStory graphQLStory = (GraphQLStory) obj;
        HScrollChainingView hScrollChainingView = (HScrollChainingView) view;
        hScrollChainingView.setRemoveButtonClickListener(null);
        hScrollChainingView.setMenuButtonClickListener(null);
        hScrollChainingView.setOnPageChangeListener(null);
        hScrollChainingView.setInstallInstagramButtonClickListener(null);
        HScrollChainingViewController a = ((HScrollChainingViewControllerManager) this.f20328d.get()).a(((ScrollableItemListFeedUnit) PropertyHelper.m21288b(graphQLStory)).getClass());
        if (a != null) {
            a.d = null;
        }
    }

    public static FollowUpPartDefinition m27980a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowUpPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20325m) {
                FollowUpPartDefinition followUpPartDefinition;
                if (a2 != null) {
                    followUpPartDefinition = (FollowUpPartDefinition) a2.mo818a(f20325m);
                } else {
                    followUpPartDefinition = f20324l;
                }
                if (followUpPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m27988b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20325m, b3);
                        } else {
                            f20324l = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followUpPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    static /* synthetic */ HScrollChainingView m27979a(FollowUpPartDefinition followUpPartDefinition, View view) {
        HScrollChainingView hScrollChainingView;
        View view2 = view;
        while (view2 != null) {
            if (view2 instanceof HScrollChainingView) {
                hScrollChainingView = (HScrollChainingView) view2;
                break;
            }
            ViewParent parent = view2.getParent();
            if (!(parent instanceof View)) {
                hScrollChainingView = null;
                break;
            }
            view2 = (View) parent;
        }
        hScrollChainingView = null;
        return hScrollChainingView;
    }

    @Inject
    public FollowUpPartDefinition(FeedLoggingViewportEventListener feedLoggingViewportEventListener, Lazy<HScrollChainingViewControllerManager> lazy, FbErrorReporter fbErrorReporter, AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, Lazy<RecyclableViewPoolManager> lazy2, ScreenUtil screenUtil, InstagramUtils instagramUtils, Lazy<FeedbackGraphQLGenerator> lazy3, FollowUpStateCache followUpStateCache) {
        this.f20327c = feedLoggingViewportEventListener;
        this.f20328d = lazy;
        this.f20329e = fbErrorReporter;
        this.f20330f = lazy2;
        this.f20331g = analyticsLogger;
        this.f20332h = newsFeedAnalyticsEventBuilder;
        this.f20326b = screenUtil;
        this.f20333i = instagramUtils;
        this.f20334j = lazy3;
        this.f20335k = followUpStateCache;
    }

    public final ViewType mo2547a() {
        return f20323a;
    }

    public final boolean m27994a(Object obj) {
        return true;
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.FOLLOWUP_FEEDUNIT;
    }

    private static void m27983a(ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter, HScrollChainingView hScrollChainingView, HScrollChainingViewController hScrollChainingViewController, ScrollableItemListFeedUnit scrollableItemListFeedUnit, List list) {
        ViewPager viewPager = hScrollChainingView.a;
        hScrollChainingViewController.a(scrollableItemListFeedUnit.mo2882v(), viewPager);
        hScrollChainingViewController.a(viewPager, hScrollChainingView.getResources());
        itemListRecyclablePagerAdapter.a(list);
        viewPager.setOffscreenPageLimit(hScrollChainingViewController.b());
        viewPager.m10817a(scrollableItemListFeedUnit.ac_(), false);
    }

    private void m27987a(GraphQLStory graphQLStory, State state, E e, HScrollChainingView hScrollChainingView) {
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) PropertyHelper.m21288b(graphQLStory);
        FeedProps c = FeedProps.m19802c(scrollableItemListFeedUnit);
        HScrollChainingViewController a = ((HScrollChainingViewControllerManager) this.f20328d.get()).a(scrollableItemListFeedUnit.getClass());
        if (a == null) {
            this.f20329e.m2350b("HScrollChainingFeedUnitSection", "No controller for HScrollChainingFeedUnitSection for class " + scrollableItemListFeedUnit.getClass());
            return;
        }
        a.d = e;
        hScrollChainingView.h = a;
        ItemListRecyclablePagerAdapter itemListRecyclablePagerAdapter = new ItemListRecyclablePagerAdapter((RecyclableViewPoolManager) this.f20330f.get(), a, hScrollChainingView, graphQLStory, scrollableItemListFeedUnit);
        if (1 != 0) {
            a.a(c, hScrollChainingView.b);
        } else {
            hScrollChainingView.f.setVisibility(8);
        }
        if (scrollableItemListFeedUnit instanceof GraphQLArticleChainingFeedUnit) {
            hScrollChainingView.setMenuButtonClickListener(state.c);
        } else {
            hScrollChainingView.setRemoveButtonClickListener(state.b);
        }
        hScrollChainingView.setOnPageChangeListener(state.d);
        hScrollChainingView.setInstallInstagramButtonClickListener(state.a);
        hScrollChainingView.a.setAdapter(itemListRecyclablePagerAdapter);
        m27983a(itemListRecyclablePagerAdapter, hScrollChainingView, a, scrollableItemListFeedUnit, scrollableItemListFeedUnit.mo2882v());
        ChainingSectionViewState chainingSectionViewState = state.e.f21187b;
        if (chainingSectionViewState == ChainingSectionViewState.START_ANIMATE) {
            m27985a(graphQLStory, hScrollChainingView, state.f, state.e);
            state.e.f21187b = ChainingSectionViewState.FULL;
            m27984a(graphQLStory, (HasInvalidate) e, hScrollChainingView);
        } else if (chainingSectionViewState == ChainingSectionViewState.FULL) {
            m27986a(graphQLStory, hScrollChainingView, state.e);
        } else if (chainingSectionViewState == ChainingSectionViewState.START_HIDING) {
            m27990c(this, graphQLStory, hScrollChainingView, state.e);
            state.e.f21187b = ChainingSectionViewState.EMPTY;
            m27984a(graphQLStory, (HasInvalidate) e, hScrollChainingView);
        }
    }

    private void m27984a(GraphQLStory graphQLStory, E e, HScrollChainingView hScrollChainingView) {
        hScrollChainingView.post(new 6(this, e, graphQLStory));
    }

    public static void m27982a(HScrollChainingView hScrollChainingView, FollowUpPersistentState followUpPersistentState) {
        hScrollChainingView.g.setVisibility(8);
        hScrollChainingView.e.setVisibility(8);
        followUpPersistentState.f21186a = false;
    }

    private void m27986a(GraphQLStory graphQLStory, HScrollChainingView hScrollChainingView, FollowUpPersistentState followUpPersistentState) {
        ScrollableItemListFeedUnit scrollableItemListFeedUnit = (ScrollableItemListFeedUnit) PropertyHelper.m21288b(graphQLStory);
        hScrollChainingView.getLayoutParams().height = -2;
        this.f20327c.m15109a(scrollableItemListFeedUnit, scrollableItemListFeedUnit.ac_());
        m27989b(graphQLStory, hScrollChainingView, followUpPersistentState);
    }

    private Boolean m27981a(GraphQLStory graphQLStory) {
        boolean z = InstagramUtils.m22705a(graphQLStory) && !this.f20333i.m22716a() && this.f20333i.m22722g();
        return Boolean.valueOf(z);
    }

    private void m27989b(GraphQLStory graphQLStory, HScrollChainingView hScrollChainingView, FollowUpPersistentState followUpPersistentState) {
        if (m27981a(graphQLStory).booleanValue()) {
            followUpPersistentState.f21186a = true;
            hScrollChainingView.b();
            return;
        }
        m27982a(hScrollChainingView, followUpPersistentState);
    }

    private void m27985a(GraphQLStory graphQLStory, HScrollChainingView hScrollChainingView, InstagramEntryPoint instagramEntryPoint, FollowUpPersistentState followUpPersistentState) {
        if (m27981a(graphQLStory).booleanValue()) {
            this.f20333i.m22718b(instagramEntryPoint);
            followUpPersistentState.f21186a = true;
            hScrollChainingView.b();
        }
        hScrollChainingView.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        hScrollChainingView.getLayoutParams().height = 1;
        m27986a(graphQLStory, hScrollChainingView, followUpPersistentState);
        Animation translateAnimation = new TranslateAnimation((float) this.f20326b.m8702c(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(350);
        hScrollChainingView.a.startAnimation(translateAnimation);
    }

    public static void m27990c(FollowUpPartDefinition followUpPartDefinition, GraphQLStory graphQLStory, HScrollChainingView hScrollChainingView, FollowUpPersistentState followUpPersistentState) {
        CollapseAnimation collapseAnimation = new CollapseAnimation(hScrollChainingView, hScrollChainingView.getMeasuredHeight(), 0);
        collapseAnimation.setDuration(400);
        Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        Animation animationSet = new AnimationSet(false);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(collapseAnimation);
        animationSet.setAnimationListener(new 7(followUpPartDefinition, hScrollChainingView, followUpPersistentState, graphQLStory));
        hScrollChainingView.startAnimation(animationSet);
    }
}
