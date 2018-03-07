package com.facebook.timeline.feed.parts;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger.InitialUnitsLoadingIndicatorVisibility;
import com.facebook.timeline.units.model.TimelineSectionData.LoadingIndicator;
import javax.inject.Inject;

@ContextScoped
/* compiled from: friends_nearby_dashboard_selfview_report_name */
public class TimelineInvisibleLoadingIndicatorPartDefinition extends MultiRowSinglePartDefinition<LoadingIndicator, Void, AnyEnvironment, View> {
    public static final ViewType f11177a = new C16191();
    private static TimelineInvisibleLoadingIndicatorPartDefinition f11178c;
    private static final Object f11179d = new Object();
    public final TimelinePerformanceLogger f11180b;

    /* compiled from: friends_nearby_dashboard_selfview_report_name */
    final class C16191 extends ViewType {
        C16191() {
        }

        public final View m11313a(Context context) {
            return new View(context);
        }
    }

    private static TimelineInvisibleLoadingIndicatorPartDefinition m11315b(InjectorLike injectorLike) {
        return new TimelineInvisibleLoadingIndicatorPartDefinition(TimelinePerformanceLogger.a(injectorLike));
    }

    public final /* synthetic */ void m11317a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1651280846);
        if (((LoadingIndicator) obj).f12776a == null) {
            this.f11180b.a(true, InitialUnitsLoadingIndicatorVisibility.INVISIBLE);
        }
        Logger.a(8, EntryType.MARK_POP, 312165246, a);
    }

    public final boolean m11318a(Object obj) {
        return ((LoadingIndicator) obj).m12735a();
    }

    public final void m11319b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        if (((LoadingIndicator) obj).f12776a == null) {
            this.f11180b.a(false, InitialUnitsLoadingIndicatorVisibility.INVISIBLE);
        }
    }

    @Inject
    public TimelineInvisibleLoadingIndicatorPartDefinition(TimelinePerformanceLogger timelinePerformanceLogger) {
        this.f11180b = timelinePerformanceLogger;
    }

    public final ViewType m11316a() {
        return f11177a;
    }

    public static TimelineInvisibleLoadingIndicatorPartDefinition m11314a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineInvisibleLoadingIndicatorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11179d) {
                TimelineInvisibleLoadingIndicatorPartDefinition timelineInvisibleLoadingIndicatorPartDefinition;
                if (a2 != null) {
                    timelineInvisibleLoadingIndicatorPartDefinition = (TimelineInvisibleLoadingIndicatorPartDefinition) a2.a(f11179d);
                } else {
                    timelineInvisibleLoadingIndicatorPartDefinition = f11178c;
                }
                if (timelineInvisibleLoadingIndicatorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m11315b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11179d, b3);
                        } else {
                            f11178c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineInvisibleLoadingIndicatorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
