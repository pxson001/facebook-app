package com.facebook.notifications.impressionlogging;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

@ContextScoped
/* compiled from: nna/ */
public class NotificationFeedViewportLoggingDataController {
    private static NotificationFeedViewportLoggingDataController f8157b;
    private static final Object f8158c = new Object();
    private final Map<String, TransientNotifImpressionLoggingData> f8159a = new HashMap();

    private static NotificationFeedViewportLoggingDataController m9782a() {
        return new NotificationFeedViewportLoggingDataController();
    }

    public final synchronized TransientNotifImpressionLoggingData m9784a(NotificationsEdgeFields notificationsEdgeFields) {
        TransientNotifImpressionLoggingData transientNotifImpressionLoggingData;
        Preconditions.checkNotNull(notificationsEdgeFields);
        if (notificationsEdgeFields.k() == null || notificationsEdgeFields.k().g() == null) {
            transientNotifImpressionLoggingData = null;
        } else {
            String g = notificationsEdgeFields.k().g();
            transientNotifImpressionLoggingData = (TransientNotifImpressionLoggingData) this.f8159a.get(g);
            if (transientNotifImpressionLoggingData == null) {
                transientNotifImpressionLoggingData = new TransientNotifImpressionLoggingData();
                this.f8159a.put(g, transientNotifImpressionLoggingData);
            }
        }
        return transientNotifImpressionLoggingData;
    }

    public static NotificationFeedViewportLoggingDataController m9783a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationFeedViewportLoggingDataController a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f8158c) {
                NotificationFeedViewportLoggingDataController notificationFeedViewportLoggingDataController;
                if (a3 != null) {
                    notificationFeedViewportLoggingDataController = (NotificationFeedViewportLoggingDataController) a3.a(f8158c);
                } else {
                    notificationFeedViewportLoggingDataController = f8157b;
                }
                if (notificationFeedViewportLoggingDataController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9782a();
                        if (a3 != null) {
                            a3.a(f8158c, a2);
                        } else {
                            f8157b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = notificationFeedViewportLoggingDataController;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}
