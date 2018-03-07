package com.facebook.timeline.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.LikableHeaderSelectorPartDefinition;
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
/* compiled from: extra_theme_selector_event_name */
public class TimelineHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TimelineHeaderSelectorPartDefinition f12612c;
    private static final Object f12613d = new Object();
    private final LikableHeaderSelectorPartDefinition f12614a;
    private final DefaultHeaderSelectorPartDefinition f12615b;

    private static TimelineHeaderSelectorPartDefinition m12574b(InjectorLike injectorLike) {
        return new TimelineHeaderSelectorPartDefinition(DefaultHeaderSelectorPartDefinition.a(injectorLike), LikableHeaderSelectorPartDefinition.a(injectorLike));
    }

    public final Object m12575a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12614a, feedProps).a(this.f12615b, feedProps);
        return null;
    }

    @Inject
    public TimelineHeaderSelectorPartDefinition(DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, LikableHeaderSelectorPartDefinition likableHeaderSelectorPartDefinition) {
        this.f12614a = likableHeaderSelectorPartDefinition;
        this.f12615b = defaultHeaderSelectorPartDefinition;
    }

    public final boolean m12576a(Object obj) {
        return true;
    }

    public static TimelineHeaderSelectorPartDefinition m12573a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12613d) {
                TimelineHeaderSelectorPartDefinition timelineHeaderSelectorPartDefinition;
                if (a2 != null) {
                    timelineHeaderSelectorPartDefinition = (TimelineHeaderSelectorPartDefinition) a2.a(f12613d);
                } else {
                    timelineHeaderSelectorPartDefinition = f12612c;
                }
                if (timelineHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12574b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12613d, b3);
                        } else {
                            f12612c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
