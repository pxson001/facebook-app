package com.facebook.notifications.settings;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_verb_table */
public class NotificationSettingsHeaderPartDefinition extends MultiRowSinglePartDefinition<NotifOptionSetNode, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType f8723a = ViewType.a(2130905481);
    private static NotificationSettingsHeaderPartDefinition f8724c;
    private static final Object f8725d = new Object();
    private final TextPartDefinition f8726b;

    private static NotificationSettingsHeaderPartDefinition m10692b(InjectorLike injectorLike) {
        return new NotificationSettingsHeaderPartDefinition(TextPartDefinition.a(injectorLike));
    }

    public final Object m10694a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f8726b, ((NotifOptionSetNode) obj).f8710a.mo468d().m10513g().a());
        return null;
    }

    public static boolean m10691a(NotifOptionSetNode notifOptionSetNode) {
        return (notifOptionSetNode.f8710a.mo468d() == null || notifOptionSetNode.f8710a.mo468d().m10513g() == null || Strings.isNullOrEmpty(notifOptionSetNode.f8710a.mo468d().m10513g().a())) ? false : true;
    }

    @Inject
    public NotificationSettingsHeaderPartDefinition(TextPartDefinition textPartDefinition) {
        this.f8726b = textPartDefinition;
    }

    public final ViewType m10693a() {
        return f8723a;
    }

    public static NotificationSettingsHeaderPartDefinition m10690a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8725d) {
                NotificationSettingsHeaderPartDefinition notificationSettingsHeaderPartDefinition;
                if (a2 != null) {
                    notificationSettingsHeaderPartDefinition = (NotificationSettingsHeaderPartDefinition) a2.a(f8725d);
                } else {
                    notificationSettingsHeaderPartDefinition = f8724c;
                }
                if (notificationSettingsHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10692b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8725d, b3);
                        } else {
                            f8724c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
