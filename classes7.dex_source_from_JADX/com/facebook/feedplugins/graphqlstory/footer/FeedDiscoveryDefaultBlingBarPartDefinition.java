package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasScrollListenerSupport;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.feedplugins.base.blingbar.BlingBarAnimationsPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition;
import com.facebook.feedplugins.base.blingbar.BlingBarPartDefinition.Props;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBar;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryDefaultBlingBarView;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Some results have errors or have been skipped */
public class FeedDiscoveryDefaultBlingBarPartDefinition<V extends View & FeedDiscoveryBlingBar, E extends HasPositionInformation & HasPersistentState & HasScrollListenerSupport> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static FeedDiscoveryDefaultBlingBarPartDefinition f23233f;
    private static final Object f23234g = new Object();
    private final FeedDiscoveryExperimentUtil f23235a;
    private final BlingBarPartDefinition f23236b;
    private final BackgroundPartDefinition f23237c;
    private final FeedDiscoveryBlingBarPartDefinition f23238d;
    private final FeedStoryUtil f23239e;

    private static FeedDiscoveryDefaultBlingBarPartDefinition m25614b(InjectorLike injectorLike) {
        return new FeedDiscoveryDefaultBlingBarPartDefinition(FeedDiscoveryExperimentUtil.a(injectorLike), BlingBarPartDefinition.m25426a(injectorLike), BackgroundPartDefinition.a(injectorLike), FeedDiscoveryBlingBarPartDefinition.a(injectorLike), FeedStoryUtil.a(injectorLike));
    }

    public final Object m25616a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f23237c, new StylingData(feedProps, BlingBarRootPartDefinition.f22896a));
        subParts.a(2131561892, this.f23236b, new Props(feedProps, BlingBarAnimationsPartDefinition.m25423a(graphQLStory)));
        subParts.a(this.f23238d, feedProps);
        return null;
    }

    public final boolean m25617a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        return this.f23235a.a() && this.f23239e.b(feedProps);
    }

    @Inject
    public FeedDiscoveryDefaultBlingBarPartDefinition(FeedDiscoveryExperimentUtil feedDiscoveryExperimentUtil, BlingBarPartDefinition blingBarPartDefinition, BackgroundPartDefinition backgroundPartDefinition, FeedDiscoveryBlingBarPartDefinition feedDiscoveryBlingBarPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f23235a = feedDiscoveryExperimentUtil;
        this.f23236b = blingBarPartDefinition;
        this.f23237c = backgroundPartDefinition;
        this.f23238d = feedDiscoveryBlingBarPartDefinition;
        this.f23239e = feedStoryUtil;
    }

    public static FeedDiscoveryDefaultBlingBarPartDefinition m25613a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedDiscoveryDefaultBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23234g) {
                FeedDiscoveryDefaultBlingBarPartDefinition feedDiscoveryDefaultBlingBarPartDefinition;
                if (a2 != null) {
                    feedDiscoveryDefaultBlingBarPartDefinition = (FeedDiscoveryDefaultBlingBarPartDefinition) a2.a(f23234g);
                } else {
                    feedDiscoveryDefaultBlingBarPartDefinition = f23233f;
                }
                if (feedDiscoveryDefaultBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25614b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23234g, b3);
                        } else {
                            f23233f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = feedDiscoveryDefaultBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<V> m25615a() {
        return FeedDiscoveryDefaultBlingBarView.f23323b;
    }
}
