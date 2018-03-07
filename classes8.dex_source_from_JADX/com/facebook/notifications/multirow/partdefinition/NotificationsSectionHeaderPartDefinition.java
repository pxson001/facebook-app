package com.facebook.notifications.multirow.partdefinition;

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
import com.facebook.notifications.sections.NotificationsSectionHeader;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;

@ContextScoped
/* compiled from: custom_cta_click_edit_cancel_mobile */
public class NotificationsSectionHeaderPartDefinition extends MultiRowSinglePartDefinition<NotificationsSectionHeader, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f16149a = ViewType.a(2130905499);
    private static NotificationsSectionHeaderPartDefinition f16150b;
    private static final Object f16151c = new Object();

    private static NotificationsSectionHeaderPartDefinition m18971b() {
        return new NotificationsSectionHeaderPartDefinition();
    }

    public final /* bridge */ /* synthetic */ void m18973a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1658084328);
        ((BetterTextView) view).setText(((NotificationsSectionHeader) obj).a);
        Logger.a(8, EntryType.MARK_POP, 579361157, a);
    }

    public final boolean m18974a(Object obj) {
        NotificationsSectionHeader notificationsSectionHeader = (NotificationsSectionHeader) obj;
        return (notificationsSectionHeader == null || Strings.isNullOrEmpty(notificationsSectionHeader.a)) ? false : true;
    }

    public final ViewType m18972a() {
        return f16149a;
    }

    public static NotificationsSectionHeaderPartDefinition m18970a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsSectionHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16151c) {
                NotificationsSectionHeaderPartDefinition notificationsSectionHeaderPartDefinition;
                if (a2 != null) {
                    notificationsSectionHeaderPartDefinition = (NotificationsSectionHeaderPartDefinition) a2.a(f16151c);
                } else {
                    notificationsSectionHeaderPartDefinition = f16150b;
                }
                if (notificationsSectionHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        b3 = m18971b();
                        if (a2 != null) {
                            a2.a(f16151c, b3);
                        } else {
                            f16150b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsSectionHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
