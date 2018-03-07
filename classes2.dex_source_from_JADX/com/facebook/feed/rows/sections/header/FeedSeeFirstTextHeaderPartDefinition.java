package com.facebook.feed.rows.sections.header;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasAnchoredTooltipProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ui.TextWithSeeFirstAndMenuButtonView;
import com.facebook.feed.seefirst.SeeFirstStateManager;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
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
/* compiled from: feedback == null */
public class FeedSeeFirstTextHeaderPartDefinition<E extends HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPositionInformation & HasPersistentState & HasInvalidate & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, TextWithSeeFirstAndMenuButtonView> {
    private static FeedSeeFirstTextHeaderPartDefinition f24468f;
    private static final Object f24469g = new Object();
    private final TextHeaderPartDefinition<E, TextWithSeeFirstAndMenuButtonView> f24470a;
    private final TextLinkPartDefinition f24471b;
    private final StoryMenuButtonPartDefinition<E, TextWithSeeFirstAndMenuButtonView> f24472c;
    private final SeeFirstTooltipPartDefinition<TextWithSeeFirstAndMenuButtonView> f24473d;
    private final SeeFirstStateManager f24474e;

    private static FeedSeeFirstTextHeaderPartDefinition m32778b(InjectorLike injectorLike) {
        return new FeedSeeFirstTextHeaderPartDefinition(StoryMenuButtonPartDefinition.m28407a(injectorLike), TextHeaderPartDefinition.m32782a(injectorLike), TextLinkPartDefinition.m28402a(injectorLike), SeeFirstTooltipPartDefinition.m28502a(injectorLike), SeeFirstStateManager.m16868a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f24470a, feedProps);
        subParts.mo2756a(this.f24471b, feedProps);
        subParts.mo2756a(this.f24472c, feedProps);
        subParts.mo2756a(this.f24473d, feedProps.f13444a);
        return null;
    }

    public final boolean m32781a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return SeeFirstStateManager.m16870a((GraphQLStory) feedProps.f13444a) && TextHeaderPartDefinition.m32784a(feedProps);
    }

    @Inject
    public FeedSeeFirstTextHeaderPartDefinition(StoryMenuButtonPartDefinition storyMenuButtonPartDefinition, TextHeaderPartDefinition textHeaderPartDefinition, TextLinkPartDefinition textLinkPartDefinition, SeeFirstTooltipPartDefinition seeFirstTooltipPartDefinition, SeeFirstStateManager seeFirstStateManager) {
        this.f24470a = textHeaderPartDefinition;
        this.f24471b = textLinkPartDefinition;
        this.f24472c = storyMenuButtonPartDefinition;
        this.f24473d = seeFirstTooltipPartDefinition;
        this.f24474e = seeFirstStateManager;
    }

    public static FeedSeeFirstTextHeaderPartDefinition m32777a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FeedSeeFirstTextHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f24469g) {
                FeedSeeFirstTextHeaderPartDefinition feedSeeFirstTextHeaderPartDefinition;
                if (a2 != null) {
                    feedSeeFirstTextHeaderPartDefinition = (FeedSeeFirstTextHeaderPartDefinition) a2.mo818a(f24469g);
                } else {
                    feedSeeFirstTextHeaderPartDefinition = f24468f;
                }
                if (feedSeeFirstTextHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m32778b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f24469g, b3);
                        } else {
                            f24468f = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = feedSeeFirstTextHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final ViewType mo2547a() {
        return TextWithSeeFirstAndMenuButtonView.a;
    }
}
