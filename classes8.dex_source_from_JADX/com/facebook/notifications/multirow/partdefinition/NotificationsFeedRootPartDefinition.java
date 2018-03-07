package com.facebook.notifications.multirow.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.sections.NotificationsSectionHeader;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_cta_click_edit_mobile */
public class NotificationsFeedRootPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, AnyEnvironment> {
    private static NotificationsFeedRootPartDefinition f16146b;
    private static final Object f16147c = new Object();
    private final RootPartSelector<AnyEnvironment> f16148a;

    private static NotificationsFeedRootPartDefinition m18967b(InjectorLike injectorLike) {
        return new NotificationsFeedRootPartDefinition(IdBasedLazy.a(injectorLike, 8704), IdBasedLazy.a(injectorLike, 8702));
    }

    @Inject
    public NotificationsFeedRootPartDefinition(Lazy<NotificationsSectionHeaderPartDefinition> lazy, Lazy<NotificationsFeedItemPartDefinition> lazy2) {
        this.f16148a = RootPartSelector.a().a(NotificationsEdgeFields.class, lazy2).a(NotificationsSectionHeader.class, lazy);
    }

    public final boolean m18969a(Object obj) {
        return true;
    }

    public final Object m18968a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f16148a.a(baseMultiRowSubParts, obj);
        return null;
    }

    public static NotificationsFeedRootPartDefinition m18966a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsFeedRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16147c) {
                NotificationsFeedRootPartDefinition notificationsFeedRootPartDefinition;
                if (a2 != null) {
                    notificationsFeedRootPartDefinition = (NotificationsFeedRootPartDefinition) a2.a(f16147c);
                } else {
                    notificationsFeedRootPartDefinition = f16146b;
                }
                if (notificationsFeedRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18967b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16147c, b3);
                        } else {
                            f16146b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsFeedRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
