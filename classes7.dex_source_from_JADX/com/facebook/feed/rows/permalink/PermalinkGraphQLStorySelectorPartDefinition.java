package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_location_comment_place_info */
public class PermalinkGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkGraphQLStorySelectorPartDefinition f19908f;
    private static final Object f19909g = new Object();
    private final Lazy<PermalinkSharedStoryPartDefinition> f19910a;
    private final Lazy<PermalinkAggregatedStoryGroupPartDefinition> f19911b;
    private final Lazy<PermalinkEdgeStoryGroupPartDefinition> f19912c;
    private final Lazy<PermalinkBasicGroupPartDefinition> f19913d;
    private final Lazy<HiddenUnitGroupPartDefinition> f19914e;

    private static PermalinkGraphQLStorySelectorPartDefinition m23124b(InjectorLike injectorLike) {
        return new PermalinkGraphQLStorySelectorPartDefinition(IdBasedLazy.a(injectorLike, 1666), IdBasedLazy.a(injectorLike, 5908), IdBasedLazy.a(injectorLike, 5909), IdBasedLazy.a(injectorLike, 5906), IdBasedLazy.a(injectorLike, 5915));
    }

    public final Object m23125a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19914e, feedProps).a(this.f19912c, feedProps).a(this.f19911b, feedProps).a(this.f19910a, feedProps).a(this.f19913d, feedProps);
        return null;
    }

    @Inject
    public PermalinkGraphQLStorySelectorPartDefinition(Lazy<HiddenUnitGroupPartDefinition> lazy, Lazy<PermalinkBasicGroupPartDefinition> lazy2, Lazy<PermalinkEdgeStoryGroupPartDefinition> lazy3, Lazy<PermalinkAggregatedStoryGroupPartDefinition> lazy4, Lazy<PermalinkSharedStoryPartDefinition> lazy5) {
        this.f19910a = lazy5;
        this.f19911b = lazy4;
        this.f19912c = lazy3;
        this.f19913d = lazy2;
        this.f19914e = lazy;
    }

    public final boolean m23126a(Object obj) {
        return true;
    }

    public static PermalinkGraphQLStorySelectorPartDefinition m23123a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19909g) {
                PermalinkGraphQLStorySelectorPartDefinition permalinkGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    permalinkGraphQLStorySelectorPartDefinition = (PermalinkGraphQLStorySelectorPartDefinition) a2.a(f19909g);
                } else {
                    permalinkGraphQLStorySelectorPartDefinition = f19908f;
                }
                if (permalinkGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23124b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19909g, b3);
                        } else {
                            f19908f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
