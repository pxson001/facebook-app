package com.facebook.events.dashboard.multirow;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
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

@ContextScoped
/* compiled from: com.facebook.sdk.EXTRA_OLD_PROFILE */
public class EventsDashboardDateBucketHeaderPartDefinition extends MultiRowSinglePartDefinition<String, Void, AnyEnvironment, View> {
    public static final ViewType f17038a = ViewType.a(2130904134);
    private static EventsDashboardDateBucketHeaderPartDefinition f17039b;
    private static final Object f17040c = new Object();

    private static EventsDashboardDateBucketHeaderPartDefinition m17347c() {
        return new EventsDashboardDateBucketHeaderPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m17349a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1725499608);
        m17346a((String) obj, view);
        Logger.a(8, EntryType.MARK_POP, 1781628933, a);
    }

    public final boolean m17350a(Object obj) {
        return true;
    }

    public final ViewType<View> m17348a() {
        return f17038a;
    }

    private static void m17346a(String str, View view) {
        ((TextView) view).setText(str);
    }

    public static EventsDashboardDateBucketHeaderPartDefinition m17345a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            EventsDashboardDateBucketHeaderPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17040c) {
                EventsDashboardDateBucketHeaderPartDefinition eventsDashboardDateBucketHeaderPartDefinition;
                if (a2 != null) {
                    eventsDashboardDateBucketHeaderPartDefinition = (EventsDashboardDateBucketHeaderPartDefinition) a2.a(f17040c);
                } else {
                    eventsDashboardDateBucketHeaderPartDefinition = f17039b;
                }
                if (eventsDashboardDateBucketHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m17347c();
                        if (a2 != null) {
                            a2.a(f17040c, c);
                        } else {
                            f17039b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = eventsDashboardDateBucketHeaderPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
