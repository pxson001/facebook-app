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
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_selfview_feedback */
public class TimelineLoadingIndicatorRootPartDefinition extends BaseMultiRowGroupPartDefinition<LoadingIndicator, Void, FeedEnvironment> {
    private static TimelineLoadingIndicatorRootPartDefinition f11191c;
    private static final Object f11192d = new Object();
    private final TimelineInvisibleLoadingIndicatorPartDefinition f11193a;
    private final TimelineLoadingIndicatorPartDefinition f11194b;

    private static TimelineLoadingIndicatorRootPartDefinition m11330b(InjectorLike injectorLike) {
        return new TimelineLoadingIndicatorRootPartDefinition(TimelineLoadingIndicatorPartDefinition.m11322a(injectorLike), TimelineInvisibleLoadingIndicatorPartDefinition.m11314a(injectorLike));
    }

    public final Object m11331a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        LoadingIndicator loadingIndicator = (LoadingIndicator) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f11194b, loadingIndicator).a(this.f11193a, loadingIndicator);
        return null;
    }

    @Inject
    public TimelineLoadingIndicatorRootPartDefinition(TimelineLoadingIndicatorPartDefinition timelineLoadingIndicatorPartDefinition, TimelineInvisibleLoadingIndicatorPartDefinition timelineInvisibleLoadingIndicatorPartDefinition) {
        this.f11193a = timelineInvisibleLoadingIndicatorPartDefinition;
        this.f11194b = timelineLoadingIndicatorPartDefinition;
    }

    public final boolean m11332a(Object obj) {
        return true;
    }

    public static TimelineLoadingIndicatorRootPartDefinition m11329a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineLoadingIndicatorRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11192d) {
                TimelineLoadingIndicatorRootPartDefinition timelineLoadingIndicatorRootPartDefinition;
                if (a2 != null) {
                    timelineLoadingIndicatorRootPartDefinition = (TimelineLoadingIndicatorRootPartDefinition) a2.a(f11192d);
                } else {
                    timelineLoadingIndicatorRootPartDefinition = f11191c;
                }
                if (timelineLoadingIndicatorRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11330b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11192d, b3);
                        } else {
                            f11191c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineLoadingIndicatorRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
