package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AggregatedStoryGroupPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: fb4a_draft_error_saved_media_not_found */
public class ThrowbackGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackGraphQLStorySelectorPartDefinition f13732e;
    private static final Object f13733f = new Object();
    private final ThrowbackSharedStoryPartDefinition f13734a;
    private final ThrowbackEdgeStoryGroupPartDefinition f13735b;
    private final AggregatedStoryGroupPartDefinition f13736c;
    private final BasicThrowbackFeedStoryGroupPartDefinition f13737d;

    private static ThrowbackGraphQLStorySelectorPartDefinition m15414b(InjectorLike injectorLike) {
        return new ThrowbackGraphQLStorySelectorPartDefinition(BasicThrowbackFeedStoryGroupPartDefinition.m15278a(injectorLike), AggregatedStoryGroupPartDefinition.a(injectorLike), ThrowbackEdgeStoryGroupPartDefinition.m15304a(injectorLike), ThrowbackSharedStoryPartDefinition.m15450a(injectorLike));
    }

    public final Object m15415a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        Flattenable flattenable = feedProps.a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f13735b, feedProps).a(this.f13736c, feedProps).a(this.f13734a, feedProps).a(this.f13737d, feedProps);
        return null;
    }

    @Inject
    public ThrowbackGraphQLStorySelectorPartDefinition(BasicThrowbackFeedStoryGroupPartDefinition basicThrowbackFeedStoryGroupPartDefinition, AggregatedStoryGroupPartDefinition aggregatedStoryGroupPartDefinition, ThrowbackEdgeStoryGroupPartDefinition throwbackEdgeStoryGroupPartDefinition, ThrowbackSharedStoryPartDefinition throwbackSharedStoryPartDefinition) {
        this.f13734a = throwbackSharedStoryPartDefinition;
        this.f13735b = throwbackEdgeStoryGroupPartDefinition;
        this.f13736c = aggregatedStoryGroupPartDefinition;
        this.f13737d = basicThrowbackFeedStoryGroupPartDefinition;
    }

    public final boolean m15416a(Object obj) {
        return true;
    }

    public static ThrowbackGraphQLStorySelectorPartDefinition m15413a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13733f) {
                ThrowbackGraphQLStorySelectorPartDefinition throwbackGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    throwbackGraphQLStorySelectorPartDefinition = (ThrowbackGraphQLStorySelectorPartDefinition) a2.a(f13733f);
                } else {
                    throwbackGraphQLStorySelectorPartDefinition = f13732e;
                }
                if (throwbackGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15414b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13733f, b3);
                        } else {
                            f13732e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
