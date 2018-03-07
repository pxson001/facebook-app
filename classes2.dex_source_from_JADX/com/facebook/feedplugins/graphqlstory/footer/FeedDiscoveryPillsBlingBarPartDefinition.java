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
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.util.story.FeedStoryUtil;
import com.facebook.feedback.abtest.FeedDiscoveryExperimentUtil;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryBlingBar;
import com.facebook.feedplugins.graphqlstory.footer.ui.FeedDiscoveryPillsBlingBarView;
import com.facebook.feedplugins.pillsblingbar.ui.PillsBlingBarWithoutBackgroundPartDefinition;
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
/* compiled from: hdnea */
public class FeedDiscoveryPillsBlingBarPartDefinition<V extends View & FeedDiscoveryBlingBar, E extends HasPositionInformation & HasPersistentState & HasScrollListenerSupport> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, V> {
    private static FeedDiscoveryPillsBlingBarPartDefinition f21188f;
    private static final Object f21189g = new Object();
    private final FeedDiscoveryExperimentUtil f21190a;
    private final PillsBlingBarWithoutBackgroundPartDefinition f21191b;
    private final BackgroundPartDefinition f21192c;
    private final FeedDiscoveryBlingBarPartDefinition f21193d;
    private final FeedStoryUtil f21194e;

    private static FeedDiscoveryPillsBlingBarPartDefinition m28913b(InjectorLike injectorLike) {
        return new FeedDiscoveryPillsBlingBarPartDefinition(FeedDiscoveryExperimentUtil.m10422a(injectorLike), PillsBlingBarWithoutBackgroundPartDefinition.m28918b(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), FeedDiscoveryBlingBarPartDefinition.m28936a(injectorLike), FeedStoryUtil.m18578a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f21192c, new StylingData(feedProps, PaddingStyle.f13085o));
        subParts.mo2755a(2131561892, this.f21191b, feedProps);
        subParts.mo2756a(this.f21193d, feedProps);
        return null;
    }

    public final boolean m28916a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        return this.f21190a.m10424a() && this.f21191b.m28923a(feedProps) && this.f21194e.m18589b(feedProps);
    }

    @Inject
    public FeedDiscoveryPillsBlingBarPartDefinition(FeedDiscoveryExperimentUtil feedDiscoveryExperimentUtil, PillsBlingBarWithoutBackgroundPartDefinition pillsBlingBarWithoutBackgroundPartDefinition, BackgroundPartDefinition backgroundPartDefinition, FeedDiscoveryBlingBarPartDefinition feedDiscoveryBlingBarPartDefinition, FeedStoryUtil feedStoryUtil) {
        this.f21190a = feedDiscoveryExperimentUtil;
        this.f21191b = pillsBlingBarWithoutBackgroundPartDefinition;
        this.f21192c = backgroundPartDefinition;
        this.f21193d = feedDiscoveryBlingBarPartDefinition;
        this.f21194e = feedStoryUtil;
    }

    public static FeedDiscoveryPillsBlingBarPartDefinition m28912a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedDiscoveryPillsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f21189g) {
                FeedDiscoveryPillsBlingBarPartDefinition feedDiscoveryPillsBlingBarPartDefinition;
                if (a2 != null) {
                    feedDiscoveryPillsBlingBarPartDefinition = (FeedDiscoveryPillsBlingBarPartDefinition) a2.mo818a(f21189g);
                } else {
                    feedDiscoveryPillsBlingBarPartDefinition = f21188f;
                }
                if (feedDiscoveryPillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28913b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f21189g, b3);
                        } else {
                            f21188f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedDiscoveryPillsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType<V> mo2547a() {
        return FeedDiscoveryPillsBlingBarView.b;
    }
}
