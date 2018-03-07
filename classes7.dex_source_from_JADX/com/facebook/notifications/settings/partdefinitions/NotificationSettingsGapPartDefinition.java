package com.facebook.notifications.settings.partdefinitions;

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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.ViewType;

@ContextScoped
/* compiled from: minutiae_verb_picker_fetch_time */
public class NotificationSettingsGapPartDefinition extends MultiRowSinglePartDefinition<Void, Void, AnyEnvironment, View> {
    public static final ViewType f8774a = ViewType.a(2130905480);
    private static NotificationSettingsGapPartDefinition f8775b;
    private static final Object f8776c = new Object();

    private static NotificationSettingsGapPartDefinition m10724c() {
        return new NotificationSettingsGapPartDefinition();
    }

    public final ViewType m10725a() {
        return f8774a;
    }

    public final boolean m10726a(Object obj) {
        return true;
    }

    public static NotificationSettingsGapPartDefinition m10723a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsGapPartDefinition c;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8776c) {
                NotificationSettingsGapPartDefinition notificationSettingsGapPartDefinition;
                if (a2 != null) {
                    notificationSettingsGapPartDefinition = (NotificationSettingsGapPartDefinition) a2.a(f8776c);
                } else {
                    notificationSettingsGapPartDefinition = f8775b;
                }
                if (notificationSettingsGapPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        c = m10724c();
                        if (a2 != null) {
                            a2.a(f8776c, c);
                        } else {
                            f8775b = c;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    c = notificationSettingsGapPartDefinition;
                }
            }
            return c;
        } finally {
            a.c(b);
        }
    }
}
