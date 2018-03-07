package com.facebook.permalink.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: stories_seen */
public class PermalinkTopLevelFooterPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, CanFeedback> {
    private static PermalinkTopLevelFooterPartSelector f2044d;
    private static final Object f2045e = new Object();
    private final GraphQLStoryUtil f2046a;
    private final PermalinkFooterPartDefinition f2047b;
    private final ReactionsPermalinkFooterPartDefinition f2048c;

    private static PermalinkTopLevelFooterPartSelector m2273b(InjectorLike injectorLike) {
        return new PermalinkTopLevelFooterPartSelector(GraphQLStoryUtil.a(injectorLike), ReactionsPermalinkFooterPartDefinition.m2276a(injectorLike), PermalinkFooterPartDefinition.m2267a(injectorLike));
    }

    public final Object m2274a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f2048c, feedProps).a(this.f2047b, feedProps);
        return null;
    }

    public final boolean m2275a(Object obj) {
        return this.f2046a.c((FeedProps) obj);
    }

    @Inject
    public PermalinkTopLevelFooterPartSelector(GraphQLStoryUtil graphQLStoryUtil, ReactionsPermalinkFooterPartDefinition reactionsPermalinkFooterPartDefinition, PermalinkFooterPartDefinition permalinkFooterPartDefinition) {
        this.f2046a = graphQLStoryUtil;
        this.f2047b = permalinkFooterPartDefinition;
        this.f2048c = reactionsPermalinkFooterPartDefinition;
    }

    public static PermalinkTopLevelFooterPartSelector m2272a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTopLevelFooterPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2045e) {
                PermalinkTopLevelFooterPartSelector permalinkTopLevelFooterPartSelector;
                if (a2 != null) {
                    permalinkTopLevelFooterPartSelector = (PermalinkTopLevelFooterPartSelector) a2.a(f2045e);
                } else {
                    permalinkTopLevelFooterPartSelector = f2044d;
                }
                if (permalinkTopLevelFooterPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2273b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2045e, b3);
                        } else {
                            f2044d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTopLevelFooterPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
