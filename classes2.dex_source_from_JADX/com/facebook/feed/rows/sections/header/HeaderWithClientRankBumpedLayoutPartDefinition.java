package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rerank.ClientRerankIndicatorManager;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.ClientSideBumpIconIndicatorDefinition;
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithClientSideBumpLayout;
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
/* compiled from: http.agent */
public class HeaderWithClientRankBumpedLayoutPartDefinition<E extends HasFeedListType & HasMenuButtonProvider & HasPositionInformation & HasPrefetcher> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithClientSideBumpLayout> {
    private static HeaderWithClientRankBumpedLayoutPartDefinition f20795d;
    private static final Object f20796e = new Object();
    private final ClientRerankIndicatorManager f20797a;
    private final DefaultHeaderPartDefinition f20798b;
    private final ClientSideBumpIconIndicatorDefinition f20799c;

    private static HeaderWithClientRankBumpedLayoutPartDefinition m28514b(InjectorLike injectorLike) {
        return new HeaderWithClientRankBumpedLayoutPartDefinition(DefaultHeaderPartDefinition.m28390a(injectorLike), ClientRerankIndicatorManager.m28518a(injectorLike), ClientSideBumpIconIndicatorDefinition.m28527a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20798b, feedProps);
        subParts.mo2756a(this.f20799c, graphQLStory);
        return null;
    }

    public final boolean m28517a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        boolean z = this.f20797a.m28525a() && BaseHeaderPartDefinition.m28398b(feedProps);
        if (z && this.f20797a.m28526b()) {
            this.f20799c.m28530a();
        }
        return z;
    }

    @Inject
    public HeaderWithClientRankBumpedLayoutPartDefinition(DefaultHeaderPartDefinition defaultHeaderPartDefinition, ClientRerankIndicatorManager clientRerankIndicatorManager, ClientSideBumpIconIndicatorDefinition clientSideBumpIconIndicatorDefinition) {
        this.f20798b = defaultHeaderPartDefinition;
        this.f20797a = clientRerankIndicatorManager;
        this.f20799c = clientSideBumpIconIndicatorDefinition;
    }

    public final ViewType mo2547a() {
        return HeaderViewWithClientSideBumpLayout.j;
    }

    public static HeaderWithClientRankBumpedLayoutPartDefinition m28513a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderWithClientRankBumpedLayoutPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20796e) {
                HeaderWithClientRankBumpedLayoutPartDefinition headerWithClientRankBumpedLayoutPartDefinition;
                if (a2 != null) {
                    headerWithClientRankBumpedLayoutPartDefinition = (HeaderWithClientRankBumpedLayoutPartDefinition) a2.mo818a(f20796e);
                } else {
                    headerWithClientRankBumpedLayoutPartDefinition = f20795d;
                }
                if (headerWithClientRankBumpedLayoutPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28514b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20796e, b3);
                        } else {
                            f20795d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerWithClientRankBumpedLayoutPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
