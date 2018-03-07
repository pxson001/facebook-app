package com.facebook.registration.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.base.service.FbIntentService;
import com.facebook.common.android.NotificationManagerMethodAutoProvider;
import com.facebook.common.util.TriState;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.content.SecurePendingIntent;
import com.facebook.gk.sessionless.GatekeeperStoreImpl_SessionlessMethodAutoProvider;
import com.facebook.gk.sessionless.Sessionless;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.registration.activity.AccountRegistrationActivity;
import com.facebook.registration.logging.SimpleRegLogger;
import javax.inject.Inject;

/* compiled from: journey_prompt_write_in */
public class RegistrationNotificationService extends FbIntentService {
    @Inject
    NotificationManager f8912a;
    @Inject
    SecureContextHelper f8913b;
    @Inject
    LoggedInUserSessionManager f8914c;
    @Inject
    SimpleRegLogger f8915d;
    @Inject
    @Sessionless
    GatekeeperStoreImpl f8916e;

    /* compiled from: journey_prompt_write_in */
    public enum OperationType {
        CREATE_FINISH_REGISTRATION_NOTIFICATION,
        OPEN_REGISTRATION_FLOW
    }

    private static <T extends Context> void m8896a(Class<T> cls, T t) {
        m8897a((Object) t, (Context) t);
    }

    public static void m8897a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RegistrationNotificationService) obj).m8895a(NotificationManagerMethodAutoProvider.b(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), LoggedInUserSessionManager.a(fbInjector), SimpleRegLogger.b(fbInjector), GatekeeperStoreImpl_SessionlessMethodAutoProvider.a(fbInjector));
    }

    public RegistrationNotificationService() {
        super("RegistrationNotificationService");
    }

    public void onCreate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_SERVICE_START, -1450866118);
        super.onCreate();
        Class cls = RegistrationNotificationService.class;
        m8897a((Object) this, (Context) this);
        Logger.a(2, EntryType.LIFECYCLE_SERVICE_END, -130139094, a);
    }

    protected final void m8899a(Intent intent) {
        if (!this.f8914c.b() && intent.hasExtra("operation_type")) {
            switch ((OperationType) intent.getSerializableExtra("operation_type")) {
                case CREATE_FINISH_REGISTRATION_NOTIFICATION:
                    TriState a = this.f8916e.a(13);
                    this.f8915d.a("finish_reg_notification_1hr", a);
                    if (a == TriState.YES) {
                        this.f8915d.d();
                        Builder builder = new Builder(this);
                        builder.j = 1;
                        Builder a2 = builder.c(true).b(getApplicationContext().getString(2131239852)).e(getApplicationContext().getString(2131239852)).a(getApplicationContext().getString(2131230720)).a(2130843529);
                        a2.d = m8898b();
                        a2.a(new long[]{0, 250, 200, 250}).a(-16776961, 500, 2000);
                        this.f8912a.notify(OperationType.CREATE_FINISH_REGISTRATION_NOTIFICATION.name(), 0, builder.c());
                        return;
                    }
                    return;
                case OPEN_REGISTRATION_FLOW:
                    this.f8915d.e();
                    Intent a3 = AccountRegistrationActivity.a(this, getClass().getSimpleName());
                    a3.setFlags(335544320);
                    this.f8913b.a(a3, this);
                    return;
                default:
                    return;
            }
        }
    }

    public static Intent m8894a(Context context, OperationType operationType) {
        Intent intent = new Intent(context, RegistrationNotificationService.class);
        intent.putExtra("operation_type", operationType);
        return intent;
    }

    private PendingIntent m8898b() {
        return SecurePendingIntent.c(this, 0, m8894a((Context) this, OperationType.OPEN_REGISTRATION_FLOW), 134217728);
    }

    private void m8895a(NotificationManager notificationManager, SecureContextHelper secureContextHelper, LoggedInUserSessionManager loggedInUserSessionManager, SimpleRegLogger simpleRegLogger, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8912a = notificationManager;
        this.f8913b = secureContextHelper;
        this.f8914c = loggedInUserSessionManager;
        this.f8915d = simpleRegLogger;
        this.f8916e = gatekeeperStoreImpl;
    }
}
