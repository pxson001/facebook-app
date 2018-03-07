package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rerank.ClientRerankIndicatorManager;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.ClientSideBumpIconIndicatorDefinition;
import com.facebook.feed.rows.sections.header.ui.TextWithClientRankingBumpAndMenuButtonView;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
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
/* compiled from: feed_unit_refreshed */
public class FeedClientSideBumpedTextHeaderPartDefinition<E extends HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithClientRankingBumpAndMenuButtonView> {
    private static FeedClientSideBumpedTextHeaderPartDefinition f24480f;
    private static final Object f24481g = new Object();
    private final TextHeaderPartDefinition<E, TextWithClientRankingBumpAndMenuButtonView> f24482a;
    private final TextLinkPartDefinition f24483b;
    private final StoryMenuButtonPartDefinition<E, TextWithClientRankingBumpAndMenuButtonView> f24484c;
    private final ClientRerankIndicatorManager f24485d;
    private final ClientSideBumpIconIndicatorDefinition<TextWithClientRankingBumpAndMenuButtonView> f24486e;

    private static FeedClientSideBumpedTextHeaderPartDefinition m32789b(InjectorLike injectorLike) {
        return new FeedClientSideBumpedTextHeaderPartDefinition(StoryMenuButtonPartDefinition.m28407a(injectorLike), TextHeaderPartDefinition.m32782a(injectorLike), TextLinkPartDefinition.m28402a(injectorLike), ClientRerankIndicatorManager.m28518a(injectorLike), ClientSideBumpIconIndicatorDefinition.m28527a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24482a, feedProps);
        subParts.mo2756a(this.f24483b, feedProps);
        subParts.mo2756a(this.f24484c, feedProps);
        subParts.mo2756a(this.f24486e, feedProps.f13444a);
        return null;
    }

    public final boolean m32792a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.f13444a;
        boolean z = this.f24485d.m28525a() && TextHeaderPartDefinition.m32784a(feedProps);
        if (z && this.f24485d.m28526b()) {
            this.f24486e.m28530a();
        }
        return z;
    }

    @Inject
    public FeedClientSideBumpedTextHeaderPartDefinition(StoryMenuButtonPartDefinition storyMenuButtonPartDefinition, TextHeaderPartDefinition textHeaderPartDefinition, TextLinkPartDefinition textLinkPartDefinition, ClientRerankIndicatorManager clientRerankIndicatorManager, ClientSideBumpIconIndicatorDefinition clientSideBumpIconIndicatorDefinition) {
        this.f24482a = textHeaderPartDefinition;
        this.f24483b = textLinkPartDefinition;
        this.f24484c = storyMenuButtonPartDefinition;
        this.f24485d = clientRerankIndicatorManager;
        this.f24486e = clientSideBumpIconIndicatorDefinition;
    }

    public final ViewType mo2547a() {
        return TextWithClientRankingBumpAndMenuButtonView.a;
    }

    public static FeedClientSideBumpedTextHeaderPartDefinition m32788a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedClientSideBumpedTextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24481g) {
                FeedClientSideBumpedTextHeaderPartDefinition feedClientSideBumpedTextHeaderPartDefinition;
                if (a2 != null) {
                    feedClientSideBumpedTextHeaderPartDefinition = (FeedClientSideBumpedTextHeaderPartDefinition) a2.mo818a(f24481g);
                } else {
                    feedClientSideBumpedTextHeaderPartDefinition = f24480f;
                }
                if (feedClientSideBumpedTextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32789b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24481g, b3);
                        } else {
                            f24480f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedClientSideBumpedTextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }
}
