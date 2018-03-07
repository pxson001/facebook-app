package com.facebook.registration.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.SystemClock;
import com.facebook.common.alarm.FbAlarmManagerImpl;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.content.SecurePendingIntent;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.registration.logging.SimpleRegLogger;
import com.facebook.registration.notification.RegistrationNotificationService.OperationType;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: key-value-pairs */
public class RegistrationNotificationHelper {
    private static RegistrationNotificationHelper f8905e;
    private static final Object f8906f = new Object();
    private final Context f8907a;
    private final FbAlarmManagerImpl f8908b;
    private final NotificationManager f8909c;
    private final SimpleRegLogger f8910d;

    private static RegistrationNotificationHelper m8890b(InjectorLike injectorLike) {
        return new RegistrationNotificationHelper((Context) injectorLike.getInstance(Context.class), FbAlarmManagerImpl.a(injectorLike), NotificationManagerMethodAutoProvider.b(injectorLike), SimpleRegLogger.b(injectorLike));
    }

    @Inject
    public RegistrationNotificationHelper(Context context, FbAlarmManagerImpl fbAlarmManagerImpl, NotificationManager notificationManager, SimpleRegLogger simpleRegLogger) {
        this.f8907a = context;
        this.f8908b = fbAlarmManagerImpl;
        this.f8909c = notificationManager;
        this.f8910d = simpleRegLogger;
    }

    public final void m8892a() {
        this.f8910d.c();
        this.f8908b.b(3, SystemClock.elapsedRealtime() + TimeUnit.HOURS.toMillis(1), m8891c());
    }

    public final void m8893b() {
        this.f8909c.cancel(OperationType.CREATE_FINISH_REGISTRATION_NOTIFICATION.name(), 0);
        this.f8908b.a(m8891c());
    }

    public static RegistrationNotificationHelper m8889a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            RegistrationNotificationHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8906f) {
                RegistrationNotificationHelper registrationNotificationHelper;
                if (a2 != null) {
                    registrationNotificationHelper = (RegistrationNotificationHelper) a2.a(f8906f);
                } else {
                    registrationNotificationHelper = f8905e;
                }
                if (registrationNotificationHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8890b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8906f, b3);
                        } else {
                            f8905e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = registrationNotificationHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private PendingIntent m8891c() {
        return SecurePendingIntent.c(this.f8907a, 0, RegistrationNotificationService.m8894a(this.f8907a, OperationType.CREATE_FINISH_REGISTRATION_NOTIFICATION), 134217728);
    }
}
