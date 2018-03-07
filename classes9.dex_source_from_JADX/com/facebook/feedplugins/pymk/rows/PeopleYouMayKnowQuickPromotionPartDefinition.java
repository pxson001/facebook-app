package com.facebook.feedplugins.pymk.rows;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ViewGroupFragmentHost;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPContextStateKey;
import com.facebook.feedplugins.pymk.PeopleYouMayKnowPersistentState.QPPersistentState;
import com.facebook.feedplugins.pymk.quickpromotion.PymkQpFragmentController;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKController;
import com.facebook.feedplugins.pymk.quickpromotion.QuickPromotionFeedPYMKFragment;
import com.facebook.graphql.model.GraphQLPaginatedPeopleYouMayKnowFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.quickpromotion.controller.QuickPromotionController;
import com.facebook.quickpromotion.ui.QuickPromotionFragment;
import javax.inject.Inject;

@ContextScoped
/* compiled from: TIMED_OUT_UPLOAD */
public class PeopleYouMayKnowQuickPromotionPartDefinition<E extends HasPositionInformation & HasPersistentState & HasInvalidate> extends MultiRowSinglePartDefinition<FeedProps<GraphQLPaginatedPeopleYouMayKnowFeedUnit>, State, E, SegmentedLinearLayout> {
    public static final ViewType f24824a = ViewType.a(2130906167);
    private static PeopleYouMayKnowQuickPromotionPartDefinition f24825d;
    private static final Object f24826e = new Object();
    private final BackgroundPartDefinition f24827b;
    private final PymkQpFragmentController f24828c;

    /* compiled from: TIMED_OUT_UPLOAD */
    public class State {
        public final QPPersistentState f24822a;
        public final Runnable f24823b;

        public State(QPPersistentState qPPersistentState, Runnable runnable) {
            this.f24822a = qPPersistentState;
            this.f24823b = runnable;
        }
    }

    private static PeopleYouMayKnowQuickPromotionPartDefinition m26635b(InjectorLike injectorLike) {
        return new PeopleYouMayKnowQuickPromotionPartDefinition(BackgroundPartDefinition.a(injectorLike), PymkQpFragmentController.m26595a(injectorLike));
    }

    public final Object m26637a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        final HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        final GraphQLPaginatedPeopleYouMayKnowFeedUnit graphQLPaginatedPeopleYouMayKnowFeedUnit = (GraphQLPaginatedPeopleYouMayKnowFeedUnit) feedProps.a;
        Builder a = Builder.a();
        a.c = -8.0f;
        a = a;
        if (hasPositionInformation.h() == null) {
            a.b = -8.0f;
        }
        subParts.a(this.f24827b, new StylingData(feedProps, a.i()));
        final QPContextStateKey qPContextStateKey = new QPContextStateKey(graphQLPaginatedPeopleYouMayKnowFeedUnit.g(), new QPPersistentState(false, null));
        return new State((QPPersistentState) ((HasPersistentState) hasPositionInformation).a(qPContextStateKey, graphQLPaginatedPeopleYouMayKnowFeedUnit), new Runnable(this) {
            final /* synthetic */ PeopleYouMayKnowQuickPromotionPartDefinition f24821d;

            public void run() {
                ((HasPersistentState) hasPositionInformation).a(qPContextStateKey, new QPPersistentState(false, null));
                ((HasInvalidate) hasPositionInformation).a(new Object[]{graphQLPaginatedPeopleYouMayKnowFeedUnit});
            }
        });
    }

    public final /* bridge */ /* synthetic */ void m26638a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 792300885);
        m26634a((State) obj2, (SegmentedLinearLayout) view);
        Logger.a(8, EntryType.MARK_POP, -974271577, a);
    }

    @Inject
    public PeopleYouMayKnowQuickPromotionPartDefinition(BackgroundPartDefinition backgroundPartDefinition, PymkQpFragmentController pymkQpFragmentController) {
        this.f24827b = backgroundPartDefinition;
        this.f24828c = pymkQpFragmentController;
    }

    public final ViewType m26636a() {
        return f24824a;
    }

    public static PeopleYouMayKnowQuickPromotionPartDefinition m26633a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PeopleYouMayKnowQuickPromotionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24826e) {
                PeopleYouMayKnowQuickPromotionPartDefinition peopleYouMayKnowQuickPromotionPartDefinition;
                if (a2 != null) {
                    peopleYouMayKnowQuickPromotionPartDefinition = (PeopleYouMayKnowQuickPromotionPartDefinition) a2.a(f24826e);
                } else {
                    peopleYouMayKnowQuickPromotionPartDefinition = f24825d;
                }
                if (peopleYouMayKnowQuickPromotionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m26635b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24826e, b3);
                        } else {
                            f24825d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = peopleYouMayKnowQuickPromotionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m26639a(Object obj) {
        return true;
    }

    private void m26634a(State state, SegmentedLinearLayout segmentedLinearLayout) {
        if (state.f24822a.f24688a && state.f24822a.f24689b != null) {
            Intent intent;
            PymkQpFragmentController pymkQpFragmentController = this.f24828c;
            InterstitialTrigger interstitialTrigger = state.f24822a.f24689b;
            Runnable runnable = state.f24823b;
            QuickPromotionController quickPromotionController = (QuickPromotionController) pymkQpFragmentController.f24729a.a(interstitialTrigger, QuickPromotionFeedPYMKController.class);
            if (quickPromotionController == null) {
                intent = null;
            } else {
                intent = quickPromotionController.a(segmentedLinearLayout.getContext());
            }
            Intent intent2 = intent;
            int i;
            if (intent2 == null) {
                i = 0;
                return;
            }
            QuickPromotionFragment a = pymkQpFragmentController.f24730b.a(intent2);
            if (a instanceof QuickPromotionFeedPYMKFragment) {
                ((QuickPromotionFeedPYMKFragment) a).f24732a = runnable;
                ViewGroupFragmentHost viewGroupFragmentHost = new ViewGroupFragmentHost(segmentedLinearLayout);
                viewGroupFragmentHost.c();
                viewGroupFragmentHost.p().a().a(2130968715, 0).b(2131565830, a).b();
                return;
            }
            i = 0;
        }
    }
}
