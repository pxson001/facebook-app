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
import com.facebook.feed.rows.sections.header.ui.HeaderViewWithTextLayout;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.HasSpecialStyling;
import com.facebook.feed.rows.styling.HasSpecialStyling.SpecialStylingType;
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
/* compiled from: i */
public class DefaultHeaderPartDefinition<E extends HasFeedListType & HasInvalidate & HasAnchoredTooltipProvider & HasMenuButtonProvider & HasPersistentState & HasPositionInformation & HasPrefetcher & HasRowKey & HasContext> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, HeaderViewWithTextLayout> implements HasSpecialStyling {
    private static DefaultHeaderPartDefinition f20641d;
    private static final Object f20642e = new Object();
    private final BaseHeaderPartDefinition<E> f20643a;
    private final BackgroundPartDefinition f20644b;
    private final StoryHeaderUtil f20645c;

    private static DefaultHeaderPartDefinition m28391b(InjectorLike injectorLike) {
        return new DefaultHeaderPartDefinition(BaseHeaderPartDefinition.m28396a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), StoryHeaderUtil.m28330a(injectorLike));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.mo2756a(this.f20643a, feedProps);
        subParts.mo2756a(this.f20644b, this.f20645c.m28334a(feedProps));
        return null;
    }

    @Inject
    public DefaultHeaderPartDefinition(BaseHeaderPartDefinition baseHeaderPartDefinition, BackgroundPartDefinition backgroundPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f20643a = baseHeaderPartDefinition;
        this.f20644b = backgroundPartDefinition;
        this.f20645c = storyHeaderUtil;
    }

    public final ViewType mo2547a() {
        return this.f20643a.mo2547a();
    }

    public static DefaultHeaderPartDefinition m28390a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20642e) {
                DefaultHeaderPartDefinition defaultHeaderPartDefinition;
                if (a2 != null) {
                    defaultHeaderPartDefinition = (DefaultHeaderPartDefinition) a2.mo818a(f20642e);
                } else {
                    defaultHeaderPartDefinition = f20641d;
                }
                if (defaultHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28391b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20642e, b3);
                        } else {
                            f20641d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final SpecialStylingType mo3125b() {
        return SpecialStylingType.HEADER;
    }
}
