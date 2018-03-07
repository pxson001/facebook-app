package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithSeeFirstLayout;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feedplugins.graphqlstory.header.SeeFirstTooltipPartDefinition;
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
/* compiled from: http.nonProxyHosts */
public class HeaderWithSeeFirstLayoutPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithSeeFirstLayout> {
    private static HeaderWithSeeFirstLayoutPartDefinition f20790d;
    private static final Object f20791e = new Object();
    private final SeeFirstTooltipPartDefinition<HeaderViewWithSeeFirstLayout> f20792a;
    private final SeeFirstStateManager f20793b;
    private final DefaultHeaderPartDefinition<E> f20794c;

    private static HeaderWithSeeFirstLayoutPartDefinition m28509b(InjectorLike injectorLike) {
        return new HeaderWithSeeFirstLayoutPartDefinition(DefaultHeaderPartDefinition.m28390a(injectorLike), SeeFirstTooltipPartDefinition.m28502a(injectorLike), SeeFirstStateManager.m16868a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20794c, feedProps);
        subParts.mo2756a(this.f20792a, graphQLStory);
        return null;
    }

    public final boolean m28512a(Object obj) {
        return m28508a((FeedProps) obj, this.f20793b);
    }

    @Inject
    public HeaderWithSeeFirstLayoutPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition, SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition, SeeFirstStateManager seeFirstStateManager) {
        this.f20794c = defaultHeaderPartDefinition;
        this.f20792a = seeFirstTooltipPartDefinition;
        this.f20793b = seeFirstStateManager;
    }

    public final ViewType<HeaderViewWithSeeFirstLayout> mo2547a() {
        return HeaderViewWithSeeFirstLayout.j;
    }

    public static HeaderWithSeeFirstLayoutPartDefinition m28507a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderWithSeeFirstLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20791e) {
                HeaderWithSeeFirstLayoutPartDefinition headerWithSeeFirstLayoutPartDefinition;
                if (a2 != null) {
                    headerWithSeeFirstLayoutPartDefinition = (HeaderWithSeeFirstLayoutPartDefinition) a2.mo818a(f20791e);
                } else {
                    headerWithSeeFirstLayoutPartDefinition = f20790d;
                }
                if (headerWithSeeFirstLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28509b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20791e, b3);
                        } else {
                            f20790d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerWithSeeFirstLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public static boolean m28508a(FeedProps<GraphQLStory> feedProps, SeeFirstStateManager seeFirstStateManager) {
        return SeeFirstStateManager.m16870a((GraphQLStory) feedProps.f13444a) && BaseHeaderPartDefinition.m28398b((FeedProps) feedProps);
    }
}
