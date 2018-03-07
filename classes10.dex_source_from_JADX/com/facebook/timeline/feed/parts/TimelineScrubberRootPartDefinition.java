package com.facebook.timeline.feed.parts;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.timeline.units.model.TimelineSectionData.Scrubber;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_refresh_button */
public class TimelineScrubberRootPartDefinition extends BaseMultiRowGroupPartDefinition<Scrubber, Void, FeedEnvironment> {
    private static TimelineScrubberRootPartDefinition f11219c;
    private static final Object f11220d = new Object();
    private final TimelineScrubberPartDefinition f11221a;
    private final TimelineScrubberLoadingIndicatorPartDefinition f11222b;

    private static TimelineScrubberRootPartDefinition m11358b(InjectorLike injectorLike) {
        return new TimelineScrubberRootPartDefinition(TimelineScrubberLoadingIndicatorPartDefinition.m11344a(injectorLike), TimelineScrubberPartDefinition.m11350a(injectorLike));
    }

    public final Object m11359a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Scrubber scrubber = (Scrubber) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f11222b, scrubber).a(this.f11221a, scrubber);
        return null;
    }

    @Inject
    public TimelineScrubberRootPartDefinition(TimelineScrubberLoadingIndicatorPartDefinition timelineScrubberLoadingIndicatorPartDefinition, TimelineScrubberPartDefinition timelineScrubberPartDefinition) {
        this.f11221a = timelineScrubberPartDefinition;
        this.f11222b = timelineScrubberLoadingIndicatorPartDefinition;
    }

    public final boolean m11360a(Object obj) {
        return true;
    }

    public static TimelineScrubberRootPartDefinition m11357a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineScrubberRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11220d) {
                TimelineScrubberRootPartDefinition timelineScrubberRootPartDefinition;
                if (a2 != null) {
                    timelineScrubberRootPartDefinition = (TimelineScrubberRootPartDefinition) a2.a(f11220d);
                } else {
                    timelineScrubberRootPartDefinition = f11219c;
                }
                if (timelineScrubberRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11358b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11220d, b3);
                        } else {
                            f11219c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineScrubberRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
