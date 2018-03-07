package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
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
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.settings.NotifOptionNode;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_suggestion_action */
public class NotificationSettingsWashTextPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<NotifOptionNode, Void, E, BetterTextView> {
    public static final ViewType f8834a = ViewType.a(2130905485);
    private static NotificationSettingsWashTextPartDefinition f8835e;
    private static final Object f8836f = new Object();
    private final ClickListenerPartDefinition f8837b;
    public final NotificationsActionExecutor f8838c;
    private final TextPartDefinition f8839d;

    private static NotificationSettingsWashTextPartDefinition m10761b(InjectorLike injectorLike) {
        return new NotificationSettingsWashTextPartDefinition(ClickListenerPartDefinition.a(injectorLike), NotificationsActionExecutor.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m10763a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NotifOptionNode notifOptionNode = (NotifOptionNode) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f8839d, notifOptionNode.f8709a.mo462d().m10463j().a());
        if (!(notifOptionNode.f8709a.mo460b() == null || notifOptionNode.f8709a.mo460b().mo456b() == null)) {
            subParts.a(this.f8837b, new OnClickListener(this) {
                final /* synthetic */ NotificationSettingsWashTextPartDefinition f8833c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1999822087);
                    this.f8833c.f8838c.a(hasContext.getContext(), notifOptionNode.f8709a, Surface.WASH_TEXT);
                    Logger.a(2, EntryType.UI_INPUT_END, -453968188, a);
                }
            });
        }
        return null;
    }

    public final boolean m10764a(Object obj) {
        NotifOptionNode notifOptionNode = (NotifOptionNode) obj;
        return (notifOptionNode.f8709a.mo462d() == null || notifOptionNode.f8709a.mo462d().m10463j() == null || Strings.isNullOrEmpty(notifOptionNode.f8709a.mo462d().m10463j().a())) ? false : true;
    }

    public final ViewType m10762a() {
        return f8834a;
    }

    @Inject
    public NotificationSettingsWashTextPartDefinition(ClickListenerPartDefinition clickListenerPartDefinition, NotificationsActionExecutor notificationsActionExecutor, TextPartDefinition textPartDefinition) {
        this.f8837b = clickListenerPartDefinition;
        this.f8838c = notificationsActionExecutor;
        this.f8839d = textPartDefinition;
    }

    public static NotificationSettingsWashTextPartDefinition m10760a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsWashTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8836f) {
                NotificationSettingsWashTextPartDefinition notificationSettingsWashTextPartDefinition;
                if (a2 != null) {
                    notificationSettingsWashTextPartDefinition = (NotificationSettingsWashTextPartDefinition) a2.a(f8836f);
                } else {
                    notificationSettingsWashTextPartDefinition = f8835e;
                }
                if (notificationSettingsWashTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10761b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8836f, b3);
                        } else {
                            f8835e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsWashTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
