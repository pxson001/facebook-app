package com.facebook.timeline.feed.parts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;
import com.facebook.timeline.units.model.TimelineSectionData.NoStoriesMarker;

@ContextScoped
/* compiled from: friends_nearby_dashboard_section_expand */
public class TimelineNoStoriesPartDefinition extends MultiRowSinglePartDefinition<NoStoriesMarker, Void, AnyEnvironment, View> {
    public static final ViewType f11195a = new C16221();
    private static TimelineNoStoriesPartDefinition f11196b;
    private static final Object f11197c = new Object();

    /* compiled from: friends_nearby_dashboard_section_expand */
    final class C16221 extends ViewType {
        C16221() {
        }

        public final View m11333a(Context context) {
            return LayoutInflater.from(context).inflate(2130907469, null, false);
        }
    }

    private static TimelineNoStoriesPartDefinition m11335c() {
        return new TimelineNoStoriesPartDefinition();
    }

    public final ViewType m11336a() {
        return f11195a;
    }

    public final boolean m11337a(Object obj) {
        return true;
    }

    public static TimelineNoStoriesPartDefinition m11334a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineNoStoriesPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11197c) {
                TimelineNoStoriesPartDefinition timelineNoStoriesPartDefinition;
                if (a2 != null) {
                    timelineNoStoriesPartDefinition = (TimelineNoStoriesPartDefinition) a2.a(f11197c);
                } else {
                    timelineNoStoriesPartDefinition = f11196b;
                }
                if (timelineNoStoriesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m11335c();
                        if (a2 != null) {
                            a2.a(f11197c, c);
                        } else {
                            f11196b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = timelineNoStoriesPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
