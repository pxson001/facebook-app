package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.TextHeaderPartDefinition;
import com.facebook.feed.rows.sections.header.ui.TextWithSeeFirstAndMenuButtonView;
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
/* compiled from: ad520371982c81d0a3af45bbb7240bd5 */
public class PermalinkSeeFirstTextHeaderPartDefinition<E extends HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithSeeFirstAndMenuButtonView> {
    private static PermalinkSeeFirstTextHeaderPartDefinition f19933e;
    private static final Object f19934f = new Object();
    private final TextHeaderPartDefinition<E, TextWithSeeFirstAndMenuButtonView> f19935a;
    private final SeeFirstTooltipPartDefinition<TextWithSeeFirstAndMenuButtonView> f19936b;
    private final SeeFirstStateManager f19937c;
    private final PermalinkStoryMenuButtonPartDefinition<TextWithSeeFirstAndMenuButtonView> f19938d;

    private static PermalinkSeeFirstTextHeaderPartDefinition m23141b(InjectorLike injectorLike) {
        return new PermalinkSeeFirstTextHeaderPartDefinition(PermalinkStoryMenuButtonPartDefinition.m23149a(injectorLike), TextHeaderPartDefinition.a(injectorLike), SeeFirstTooltipPartDefinition.a(injectorLike), SeeFirstStateManager.a(injectorLike));
    }

    public final Object m23143a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        subParts.a(this.f19935a, feedProps);
        subParts.a(this.f19938d, feedProps);
        subParts.a(this.f19936b, graphQLStory);
        return null;
    }

    public final boolean m23144a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return SeeFirstStateManager.a((GraphQLStory) feedProps.a) && TextHeaderPartDefinition.a(feedProps);
    }

    @Inject
    public PermalinkSeeFirstTextHeaderPartDefinition(PermalinkStoryMenuButtonPartDefinition permalinkStoryMenuButtonPartDefinition, TextHeaderPartDefinition textHeaderPartDefinition, SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition, SeeFirstStateManager seeFirstStateManager) {
        this.f19935a = textHeaderPartDefinition;
        this.f19936b = seeFirstTooltipPartDefinition;
        this.f19937c = seeFirstStateManager;
        this.f19938d = permalinkStoryMenuButtonPartDefinition;
    }

    public final ViewType m23142a() {
        return TextWithSeeFirstAndMenuButtonView.f21425a;
    }

    public static PermalinkSeeFirstTextHeaderPartDefinition m23140a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkSeeFirstTextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19934f) {
                PermalinkSeeFirstTextHeaderPartDefinition permalinkSeeFirstTextHeaderPartDefinition;
                if (a2 != null) {
                    permalinkSeeFirstTextHeaderPartDefinition = (PermalinkSeeFirstTextHeaderPartDefinition) a2.a(f19934f);
                } else {
                    permalinkSeeFirstTextHeaderPartDefinition = f19933e;
                }
                if (permalinkSeeFirstTextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23141b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19934f, b3);
                        } else {
                            f19933e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkSeeFirstTextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
