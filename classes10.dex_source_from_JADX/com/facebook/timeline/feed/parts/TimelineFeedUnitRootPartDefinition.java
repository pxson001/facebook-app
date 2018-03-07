package com.facebook.timeline.feed.parts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
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
import com.facebook.timeline.environment.TimelineEnvironment;
import com.facebook.timeline.rows.TimelineGraphQLStorySelectorPartDefinition;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import com.facebook.timeline.units.model.TimelineSectionData.NoStoriesMarker;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;
import com.facebook.timeline.units.model.TimelineSectionData.TimelinePostsLabel;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_settings */
public class TimelineFeedUnitRootPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, TimelineEnvironment> {
    private static TimelineFeedUnitRootPartDefinition f11174b;
    private static final Object f11175c = new Object();
    private final RootPartSelector<TimelineEnvironment> f11176a;

    private static TimelineFeedUnitRootPartDefinition m11310b(InjectorLike injectorLike) {
        return new TimelineFeedUnitRootPartDefinition(IdBasedLazy.a(injectorLike, 11243), IdBasedLazy.a(injectorLike, 11238), IdBasedLazy.a(injectorLike, 11372), IdBasedLazy.a(injectorLike, 1666), IdBasedLazy.a(injectorLike, 11239), IdBasedLazy.a(injectorLike, 11240), IdBasedLazy.a(injectorLike, 6023));
    }

    @Inject
    public TimelineFeedUnitRootPartDefinition(Lazy<TimelineScrubberRootPartDefinition> lazy, Lazy<TimelineLoadingIndicatorRootPartDefinition> lazy2, Lazy<TimelineGraphQLStorySelectorPartDefinition> lazy3, Lazy<HiddenUnitGroupPartDefinition> lazy4, Lazy<TimelineNoStoriesPartDefinition> lazy5, Lazy<TimelinePostsLabelPartDefinition> lazy6, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy7) {
        this.f11176a = RootPartSelector.a().b(HideableUnit.class, lazy4).b(GraphQLStory.class, lazy3).a(Scrubber.class, lazy).a(LoadingIndicator.class, lazy2).a(NoStoriesMarker.class, lazy5).a(TimelinePostsLabel.class, lazy6).a(FeedUnit.class, lazy7);
    }

    public final boolean m11312a(Object obj) {
        return true;
    }

    public static TimelineFeedUnitRootPartDefinition m11309a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineFeedUnitRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11175c) {
                TimelineFeedUnitRootPartDefinition timelineFeedUnitRootPartDefinition;
                if (a2 != null) {
                    timelineFeedUnitRootPartDefinition = (TimelineFeedUnitRootPartDefinition) a2.a(f11175c);
                } else {
                    timelineFeedUnitRootPartDefinition = f11174b;
                }
                if (timelineFeedUnitRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11310b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11175c, b3);
                        } else {
                            f11174b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineFeedUnitRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final Object m11311a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f11176a.a(baseMultiRowSubParts, obj);
        return null;
    }
}
