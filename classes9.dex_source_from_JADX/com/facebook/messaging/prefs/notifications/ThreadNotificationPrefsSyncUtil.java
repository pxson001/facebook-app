package com.facebook.messaging.prefs.notifications;

import android.content.Context;
import android.content.Intent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.userscope.UserScopedComponentManager;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.NotificationSetting;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
/* compiled from: developer_section */
public class ThreadNotificationPrefsSyncUtil {
    private static final Class<?> f16359a = ThreadNotificationPrefsSyncUtil.class;
    private static final Object f16360g = new Object();
    private final Context f16361b;
    private final FbSharedPreferences f16362c;
    private final Provider<DbCache> f16363d;
    private final ExecutorService f16364e;
    private final Provider<UserScopedComponentManager> f16365f;

    private static ThreadNotificationPrefsSyncUtil m16424b(InjectorLike injectorLike) {
        return new ThreadNotificationPrefsSyncUtil((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 7803), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4970));
    }

    @Inject
    public ThreadNotificationPrefsSyncUtil(Context context, FbSharedPreferences fbSharedPreferences, Provider<DbCache> provider, ExecutorService executorService, Provider<UserScopedComponentManager> provider2) {
        this.f16361b = context;
        this.f16362c = fbSharedPreferences;
        this.f16363d = provider;
        this.f16364e = executorService;
        this.f16365f = provider2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil m16423a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f16360g;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m16424b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16360g;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f16360g;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil");
    }

    public final void m16428a(final ThreadKey threadKey) {
        ExecutorDetour.a(this.f16364e, new Runnable(this) {
            final /* synthetic */ ThreadNotificationPrefsSyncUtil f16356b;

            public void run() {
                this.f16356b.m16432c(threadKey);
            }
        }, -27444411);
    }

    public final void m16429a(final ThreadSummary threadSummary) {
        ExecutorDetour.a(this.f16364e, new Runnable(this) {
            final /* synthetic */ ThreadNotificationPrefsSyncUtil f16358b;

            public void run() {
                this.f16358b.m16431b(threadSummary);
            }
        }, 1720030803);
    }

    final NotificationSettingDelta m16430b(ThreadKey threadKey) {
        return new NotificationSettingDelta(m16426d(threadKey), m16427e(threadKey));
    }

    private NotificationSettingDelta m16425c(ThreadSummary threadSummary) {
        return new NotificationSettingDelta(m16426d(threadSummary.a), threadSummary.C);
    }

    @VisibleForTesting
    private NotificationSetting m16426d(ThreadKey threadKey) {
        return NotificationSetting.b(this.f16362c.a(MessagingPrefKeys.a(threadKey), 0));
    }

    @Nullable
    @VisibleForTesting
    private NotificationSetting m16427e(ThreadKey threadKey) {
        ThreadSummary a = ((DbCache) this.f16363d.get()).m11099a(threadKey);
        if (a == null) {
            return null;
        }
        return a.C;
    }

    @VisibleForTesting
    final void m16432c(ThreadKey threadKey) {
        threadKey.toString();
        Intent a = ((UserScopedComponentManager) this.f16365f.get()).m5783a(this.f16361b, NotificationPrefsSyncService.class, "NotificationsPrefsService.SYNC_THREAD_FROM_CLIENT");
        a.putExtra("THREAD_KEY_STRING", threadKey.toString());
        this.f16361b.startService(a);
    }

    @VisibleForTesting
    final void m16431b(ThreadSummary threadSummary) {
        if (m16425c(threadSummary).m16422a()) {
            ThreadKey threadKey = threadSummary.a;
            threadKey.toString();
            Intent a = ((UserScopedComponentManager) this.f16365f.get()).m5783a(this.f16361b, NotificationPrefsSyncService.class, "NotificationsPrefsService.SYNC_THREAD_FROM_SERVER");
            a.putExtra("THREAD_KEY_STRING", threadKey.toString());
            this.f16361b.startService(a);
        }
    }
}
