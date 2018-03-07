package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
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
/* compiled from: add_place */
public class PermalinkEdgeStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkEdgeStoryGroupPartDefinition f19897c;
    private static final Object f19898d = new Object();
    private final PermalinkAttachedStoryPartDefinition f19899a;
    private final PermalinkTextHeaderSelectorPartDefinition f19900b;

    private static PermalinkEdgeStoryGroupPartDefinition m23116b(InjectorLike injectorLike) {
        return new PermalinkEdgeStoryGroupPartDefinition(PermalinkTextHeaderSelectorPartDefinition.m23174a(injectorLike), PermalinkAttachedStoryPartDefinition.m23106a(injectorLike));
    }

    public final Object m23117a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f19900b, feedProps);
        baseMultiRowSubParts.a(this.f19899a, feedProps);
        return null;
    }

    public final boolean m23118a(Object obj) {
        return StoryProps.m((FeedProps) obj);
    }

    @Inject
    public PermalinkEdgeStoryGroupPartDefinition(PermalinkTextHeaderSelectorPartDefinition permalinkTextHeaderSelectorPartDefinition, PermalinkAttachedStoryPartDefinition permalinkAttachedStoryPartDefinition) {
        this.f19900b = permalinkTextHeaderSelectorPartDefinition;
        this.f19899a = permalinkAttachedStoryPartDefinition;
    }

    public static PermalinkEdgeStoryGroupPartDefinition m23115a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkEdgeStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19898d) {
                PermalinkEdgeStoryGroupPartDefinition permalinkEdgeStoryGroupPartDefinition;
                if (a2 != null) {
                    permalinkEdgeStoryGroupPartDefinition = (PermalinkEdgeStoryGroupPartDefinition) a2.a(f19898d);
                } else {
                    permalinkEdgeStoryGroupPartDefinition = f19897c;
                }
                if (permalinkEdgeStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23116b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19898d, b3);
                        } else {
                            f19897c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkEdgeStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
