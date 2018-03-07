package com.facebook.notifications.settings;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import javax.inject.Inject;

@ContextScoped
/* compiled from: moduleID */
public class NotificationSettingsBasicSetPartDefinition extends BaseMultiRowGroupPartDefinition<NotifOptionSetNode, Void, AnyEnvironment> {
    private static NotificationSettingsBasicSetPartDefinition f8712b;
    private static final Object f8713c = new Object();
    private final NotificationSettingsOptionsStyleMapper f8714a;

    private static NotificationSettingsBasicSetPartDefinition m10677b(InjectorLike injectorLike) {
        return new NotificationSettingsBasicSetPartDefinition(NotificationSettingsOptionsStyleMapper.m10702a(injectorLike));
    }

    public final Object m10678a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        for (int i = 0; i < notifOptionSetNode.f8710a.mo467c().mo464a().size(); i++) {
            Nodes nodes = (Nodes) notifOptionSetNode.f8710a.mo467c().mo464a().get(i);
            GraphQLNotifOptionRowDisplayStyle gu_ = nodes.mo462d().gu_();
            if (this.f8714a.m10705b(gu_)) {
                baseMultiRowSubParts.a(this.f8714a.m10704a(gu_), new NotifOptionNode(nodes));
            }
        }
        return null;
    }

    public final boolean m10679a(Object obj) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        return notifOptionSetNode.f8710a.mo467c() != null && CollectionUtil.b(notifOptionSetNode.f8710a.mo467c().mo464a());
    }

    @Inject
    public NotificationSettingsBasicSetPartDefinition(NotificationSettingsOptionsStyleMapper notificationSettingsOptionsStyleMapper) {
        this.f8714a = notificationSettingsOptionsStyleMapper;
    }

    public static NotificationSettingsBasicSetPartDefinition m10676a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsBasicSetPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8713c) {
                NotificationSettingsBasicSetPartDefinition notificationSettingsBasicSetPartDefinition;
                if (a2 != null) {
                    notificationSettingsBasicSetPartDefinition = (NotificationSettingsBasicSetPartDefinition) a2.a(f8713c);
                } else {
                    notificationSettingsBasicSetPartDefinition = f8712b;
                }
                if (notificationSettingsBasicSetPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10677b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8713c, b3);
                        } else {
                            f8712b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsBasicSetPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
