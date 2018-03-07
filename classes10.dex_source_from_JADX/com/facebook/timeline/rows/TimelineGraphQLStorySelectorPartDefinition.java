package com.facebook.timeline.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AggregatedStoryGroupPartDefinition;
import com.facebook.feed.rows.sections.EdgeStoryGroupPartDefinition;
import com.facebook.feed.rows.sections.offline.OfflineStoryPartDefinition;
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
/* compiled from: extra_title_bar_content */
public class TimelineGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TimelineGraphQLStorySelectorPartDefinition f12605f;
    private static final Object f12606g = new Object();
    private final OfflineStoryPartDefinition f12607a;
    private final TimelineSharedStoryPartDefinition f12608b;
    private final EdgeStoryGroupPartDefinition f12609c;
    private final AggregatedStoryGroupPartDefinition f12610d;
    private final BasicTimelineGroupPartDefinition f12611e;

    private static TimelineGraphQLStorySelectorPartDefinition m12570b(InjectorLike injectorLike) {
        return new TimelineGraphQLStorySelectorPartDefinition(BasicTimelineGroupPartDefinition.m12564a(injectorLike), AggregatedStoryGroupPartDefinition.a(injectorLike), EdgeStoryGroupPartDefinition.a(injectorLike), TimelineSharedStoryPartDefinition.m12583a(injectorLike), OfflineStoryPartDefinition.a(injectorLike));
    }

    public final Object m12571a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12607a, feedProps).a(this.f12609c, feedProps).a(this.f12610d, feedProps).a(this.f12608b, feedProps).a(this.f12611e, feedProps);
        return null;
    }

    @Inject
    public TimelineGraphQLStorySelectorPartDefinition(BasicTimelineGroupPartDefinition basicTimelineGroupPartDefinition, AggregatedStoryGroupPartDefinition aggregatedStoryGroupPartDefinition, EdgeStoryGroupPartDefinition edgeStoryGroupPartDefinition, TimelineSharedStoryPartDefinition timelineSharedStoryPartDefinition, OfflineStoryPartDefinition offlineStoryPartDefinition) {
        this.f12607a = offlineStoryPartDefinition;
        this.f12608b = timelineSharedStoryPartDefinition;
        this.f12609c = edgeStoryGroupPartDefinition;
        this.f12610d = aggregatedStoryGroupPartDefinition;
        this.f12611e = basicTimelineGroupPartDefinition;
    }

    public final boolean m12572a(Object obj) {
        return true;
    }

    public static TimelineGraphQLStorySelectorPartDefinition m12569a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12606g) {
                TimelineGraphQLStorySelectorPartDefinition timelineGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    timelineGraphQLStorySelectorPartDefinition = (TimelineGraphQLStorySelectorPartDefinition) a2.a(f12606g);
                } else {
                    timelineGraphQLStorySelectorPartDefinition = f12605f;
                }
                if (timelineGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m12570b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12606g, b3);
                        } else {
                            f12605f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
