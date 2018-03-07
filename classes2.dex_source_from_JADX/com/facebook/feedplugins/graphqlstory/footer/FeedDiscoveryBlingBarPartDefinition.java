package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.binding.StoryKeyUtil;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.FlyoutLauncher;
import com.facebook.feedback.logging.FeedDiscoveryFunnelLoggerUtil;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBar;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBarAnimationController;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBarAnimationController.FeedDiscoveryViewState;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBarAnimationControllerProvider;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLFeedbackRealTimeActivityInfo;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: hashtag_feed */
public class FeedDiscoveryBlingBarPartDefinition<V extends View & FeedDiscoveryBlingBar, E extends HasPositionInformation & HasPersistentState & HasScrollListenerSupport> extends BaseSinglePartDefinition<FeedProps<GraphQLStory>, State, E, V> {
    private static FeedDiscoveryBlingBarPartDefinition f21212d;
    private static final Object f21213e = new Object();
    private final FeedDiscoveryBlingBarAnimationControllerProvider f21214a;
    public final FeedDiscoveryFunnelLoggerUtil f21215b;
    public final FlyoutLauncher f21216c;

    private static FeedDiscoveryBlingBarPartDefinition m28938b(InjectorLike injectorLike) {
        return new FeedDiscoveryBlingBarPartDefinition((FeedDiscoveryBlingBarAnimationControllerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(FeedDiscoveryBlingBarAnimationControllerProvider.class), FeedDiscoveryFunnelLoggerUtil.m28891a(injectorLike), FlyoutLauncher.m28357a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        CacheableEntity cacheableEntity = (GraphQLStory) feedProps.f13444a;
        FeedDiscoveryPersistentState feedDiscoveryPersistentState = (FeedDiscoveryPersistentState) ((HasPersistentState) ((HasPositionInformation) anyEnvironment)).mo2425a((ContextStateKey) new FeedDiscoveryStateKey(StoryKeyUtil.m28909a(cacheableEntity)), cacheableEntity);
        1 1 = new 1(this, feedDiscoveryPersistentState);
        GraphQLFeedbackRealTimeActivityInfo F = cacheableEntity.mo2890l().m23212F();
        FeedDiscoveryBlingBarAnimationControllerProvider feedDiscoveryBlingBarAnimationControllerProvider = this.f21214a;
        FeedDiscoveryViewState feedDiscoveryViewState = feedDiscoveryPersistentState.a;
        ImmutableList a = F.m27544a().a();
        List arrayList = new ArrayList();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((GraphQLActor) a.get(i)).ai().mo2924b());
        }
        FeedDiscoveryBlingBarAnimationController a2 = feedDiscoveryBlingBarAnimationControllerProvider.m28942a(feedDiscoveryViewState, 1, Lists.m1301a(arrayList), F.m27547k());
        return new State(feedDiscoveryPersistentState, a2, new 2(this, a2), new 3(this, feedProps), m28935a(feedProps, feedDiscoveryPersistentState));
    }

    public final /* bridge */ /* synthetic */ void mo2543a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 132646153);
        m28937a((State) obj2, (HasPositionInformation) anyEnvironment, view);
        Logger.a(8, EntryType.MARK_POP, 1770175923, a);
    }

    public final void mo2544b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        State state = (State) obj2;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        view.setOnClickListener(null);
        ((FeedDiscoveryBlingBar) view).setAnimationEventListener(null);
        ((FeedDiscoveryBlingBar) view).e();
        ((FeedDiscoveryBlingBar) view).h();
        ((HasScrollListenerSupport) hasPositionInformation).mo2421b(state.b);
    }

    public static FeedDiscoveryBlingBarPartDefinition m28936a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedDiscoveryBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21213e) {
                FeedDiscoveryBlingBarPartDefinition feedDiscoveryBlingBarPartDefinition;
                if (a2 != null) {
                    feedDiscoveryBlingBarPartDefinition = (FeedDiscoveryBlingBarPartDefinition) a2.mo818a(f21213e);
                } else {
                    feedDiscoveryBlingBarPartDefinition = f21212d;
                }
                if (feedDiscoveryBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28938b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21213e, b3);
                        } else {
                            f21212d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedDiscoveryBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    private FeedDiscoveryAnimationEventListener m28935a(FeedProps<GraphQLStory> feedProps, FeedDiscoveryPersistentState feedDiscoveryPersistentState) {
        return new 4(this, (GraphQLStory) feedProps.f13444a, feedDiscoveryPersistentState);
    }

    @Inject
    public FeedDiscoveryBlingBarPartDefinition(FeedDiscoveryBlingBarAnimationControllerProvider feedDiscoveryBlingBarAnimationControllerProvider, FeedDiscoveryFunnelLoggerUtil feedDiscoveryFunnelLoggerUtil, FlyoutLauncher flyoutLauncher) {
        this.f21214a = feedDiscoveryBlingBarAnimationControllerProvider;
        this.f21215b = feedDiscoveryFunnelLoggerUtil;
        this.f21216c = flyoutLauncher;
    }

    private static void m28937a(State state, E e, V v) {
        ((FeedDiscoveryBlingBar) v).setAnimationEventListener(state.e);
        v.setOnClickListener(state.d);
        ((FeedDiscoveryBlingBar) v).setAnimationController(state.a);
        ((HasScrollListenerSupport) e).mo2420a(state.b);
        if (state.a.d != FeedDiscoveryViewState.SHOWING_BLING_BAR || state.c.b) {
            ((FeedDiscoveryBlingBar) v).g();
        } else {
            ((FeedDiscoveryBlingBar) v).f();
        }
    }
}
