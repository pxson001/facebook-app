package com.facebook.timeline.feed.parts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;
import com.facebook.timeline.units.model.TimelineSectionData.TimelineSectionLabel;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_search_open */
public class TimelineScrubberLoadingIndicatorPartDefinition extends MultiRowSinglePartDefinition<Scrubber, Void, HasFeedListType, LoadingIndicatorView> {
    private static TimelineScrubberLoadingIndicatorPartDefinition f11203b;
    private static final Object f11204c = new Object();
    private final TimelineLoadingIndicatorPartDefinition f11205a;

    private static TimelineScrubberLoadingIndicatorPartDefinition m11345b(InjectorLike injectorLike) {
        return new TimelineScrubberLoadingIndicatorPartDefinition(TimelineLoadingIndicatorPartDefinition.m11322a(injectorLike));
    }

    public final Object m11347a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f11205a, ((TimelineSectionLabel) ((Scrubber) obj)).f12786d);
        return null;
    }

    public final boolean m11348a(Object obj) {
        Scrubber scrubber = (Scrubber) obj;
        if (!(scrubber instanceof TimelineSectionLabel)) {
            return false;
        }
        TimelineSectionLabel timelineSectionLabel = (TimelineSectionLabel) scrubber;
        if (!timelineSectionLabel.m12736a() || timelineSectionLabel.f12787e) {
            return false;
        }
        return true;
    }

    @Inject
    public TimelineScrubberLoadingIndicatorPartDefinition(TimelineLoadingIndicatorPartDefinition timelineLoadingIndicatorPartDefinition) {
        this.f11205a = timelineLoadingIndicatorPartDefinition;
    }

    public final ViewType m11346a() {
        return TimelineLoadingIndicatorPartDefinition.f11185a;
    }

    public static TimelineScrubberLoadingIndicatorPartDefinition m11344a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineScrubberLoadingIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11204c) {
                TimelineScrubberLoadingIndicatorPartDefinition timelineScrubberLoadingIndicatorPartDefinition;
                if (a2 != null) {
                    timelineScrubberLoadingIndicatorPartDefinition = (TimelineScrubberLoadingIndicatorPartDefinition) a2.a(f11204c);
                } else {
                    timelineScrubberLoadingIndicatorPartDefinition = f11203b;
                }
                if (timelineScrubberLoadingIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11345b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11204c, b3);
                        } else {
                            f11203b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineScrubberLoadingIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
