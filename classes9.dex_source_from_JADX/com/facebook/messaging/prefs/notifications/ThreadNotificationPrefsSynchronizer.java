package com.facebook.messaging.prefs.notifications;

import android.os.Bundle;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.threads.DbCache;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.prefs.notifications.NotificationPrefsSyncService.C19251;
import com.facebook.messaging.service.model.ModifyThreadParams;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: detailed_battery_v2 */
public class ThreadNotificationPrefsSynchronizer {
    private static final Class<?> f16368a = ThreadNotificationPrefsSynchronizer.class;
    private static volatile ThreadNotificationPrefsSynchronizer f16369m;
    private final FbSharedPreferences f16370b;
    private final DefaultBlueServiceOperationFactory f16371c;
    private final Provider<ThreadNotificationPrefsSyncUtil> f16372d;
    private final ScheduledExecutorService f16373e;
    private final Provider<DbCache> f16374f;
    @GuardedBy("this")
    private OperationFuture f16375g;
    @GuardedBy("this")
    private Map<ThreadKey, ModifyThreadParams> f16376h;
    @GuardedBy("this")
    private ModifyThreadParams f16377i;
    @GuardedBy("this")
    private long f16378j;
    @GuardedBy("this")
    private int f16379k;
    public volatile C19251 f16380l;

    /* compiled from: detailed_battery_v2 */
    class C19301 implements Runnable {
        final /* synthetic */ ThreadNotificationPrefsSynchronizer f16366a;

        C19301(ThreadNotificationPrefsSynchronizer threadNotificationPrefsSynchronizer) {
            this.f16366a = threadNotificationPrefsSynchronizer;
        }

        public void run() {
            ThreadNotificationPrefsSynchronizer.m16437d(this.f16366a);
        }
    }

    /* compiled from: detailed_battery_v2 */
    class C19312 implements FutureCallback<OperationResult> {
        final /* synthetic */ ThreadNotificationPrefsSynchronizer f16367a;

        C19312(ThreadNotificationPrefsSynchronizer threadNotificationPrefsSynchronizer) {
            this.f16367a = threadNotificationPrefsSynchronizer;
        }

        public void onSuccess(Object obj) {
            ThreadNotificationPrefsSynchronizer.m16438e(this.f16367a);
        }

        public void onFailure(Throwable th) {
            ThreadNotificationPrefsSynchronizer.m16439f(this.f16367a);
        }
    }

    public static com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSynchronizer m16433a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16369m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSynchronizer.class;
        monitor-enter(r1);
        r0 = f16369m;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16434b(r0);	 Catch:{ all -> 0x0035 }
        f16369m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16369m;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSynchronizer.a(com.facebook.inject.InjectorLike):com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSynchronizer");
    }

    private static ThreadNotificationPrefsSynchronizer m16434b(InjectorLike injectorLike) {
        return new ThreadNotificationPrefsSynchronizer((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), DefaultBlueServiceOperationFactory.b(injectorLike), IdBasedProvider.a(injectorLike, 8302), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 7803));
    }

    @Inject
    public ThreadNotificationPrefsSynchronizer(FbSharedPreferences fbSharedPreferences, BlueServiceOperationFactory blueServiceOperationFactory, Provider<ThreadNotificationPrefsSyncUtil> provider, ScheduledExecutorService scheduledExecutorService, Provider<DbCache> provider2) {
        this.f16370b = fbSharedPreferences;
        this.f16371c = blueServiceOperationFactory;
        this.f16372d = provider;
        this.f16373e = scheduledExecutorService;
        this.f16374f = provider2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void m16441a(com.facebook.messaging.model.threadkey.ThreadKey r6) {
        /*
        r5 = this;
        r1 = 1;
        r2 = 0;
        r6.toString();
        r0 = r5.f16372d;
        r0 = r0.get();
        r0 = (com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSyncUtil) r0;
        r3 = r0.m16430b(r6);
        monitor-enter(r5);
        r0 = r5.f16376h;	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0029;
    L_0x0016:
        r0 = r5.f16376h;	 Catch:{ all -> 0x0054 }
        r0 = r0.containsKey(r6);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0029;
    L_0x001e:
        r0 = r1;
    L_0x001f:
        if (r0 != 0) goto L_0x002b;
    L_0x0021:
        r0 = r3.m16422a();	 Catch:{ all -> 0x0054 }
        if (r0 != 0) goto L_0x002b;
    L_0x0027:
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
    L_0x0028:
        return;
    L_0x0029:
        r0 = r2;
        goto L_0x001f;
    L_0x002b:
        monitor-exit(r5);	 Catch:{ all -> 0x0054 }
        r6.toString();
        monitor-enter(r5);
        r0 = r5.f16374f;	 Catch:{ all -> 0x0051 }
        r0 = r0.get();	 Catch:{ all -> 0x0051 }
        r0 = (com.facebook.messaging.database.threads.DbCache) r0;	 Catch:{ all -> 0x0051 }
        r0 = r0.m11099a(r6);	 Catch:{ all -> 0x0051 }
        if (r0 != 0) goto L_0x0057;
    L_0x003e:
        r0 = f16368a;	 Catch:{ all -> 0x0051 }
        r1 = "Failed to fetch thread %s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0051 }
        r3 = 0;
        r4 = r6.toString();	 Catch:{ all -> 0x0051 }
        r2[r3] = r4;	 Catch:{ all -> 0x0051 }
        com.facebook.debug.log.BLog.a(r0, r1, r2);	 Catch:{ all -> 0x0051 }
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        goto L_0x0028;
    L_0x0051:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0051 }
        throw r0;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{  }
        throw r0;
    L_0x0057:
        r0 = new com.facebook.messaging.service.model.ModifyThreadParamsBuilder;	 Catch:{  }
        r0.<init>();	 Catch:{  }
        r0 = r0.m17157a(r6);	 Catch:{  }
        r1 = r3.f16353a;	 Catch:{  }
        r0 = r0.m17158a(r1);	 Catch:{  }
        r0 = r0.m17161q();	 Catch:{  }
        r1 = r5.m16435b();	 Catch:{  }
        r1.put(r6, r0);	 Catch:{  }
        monitor-exit(r5);	 Catch:{  }
        r5.m16440g();
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.prefs.notifications.ThreadNotificationPrefsSynchronizer.a(com.facebook.messaging.model.threadkey.ThreadKey):void");
    }

    final void m16443b(ThreadKey threadKey) {
        threadKey.toString();
        NotificationSettingDelta b = ((ThreadNotificationPrefsSyncUtil) this.f16372d.get()).m16430b(threadKey);
        if (b.m16422a()) {
            synchronized (this) {
                if ((this.f16377i == null || !Objects.equal(this.f16377i.m17155a(), threadKey)) && (this.f16376h == null || !this.f16376h.containsKey(threadKey))) {
                    threadKey.toString();
                    Editor edit = this.f16370b.edit();
                    edit.a(MessagingPrefKeys.a(threadKey), b.f16354b.a());
                    edit.commit();
                }
            }
            m16440g();
        }
    }

    final synchronized boolean m16442a() {
        boolean z;
        z = (this.f16375g == null && ((this.f16376h == null || this.f16376h.isEmpty()) && this.f16377i == null)) ? false : true;
        return z;
    }

    @GuardedBy("this")
    private Map<ThreadKey, ModifyThreadParams> m16435b() {
        if (this.f16376h == null) {
            this.f16376h = Maps.c();
            this.f16378j = 4000;
            m16436c();
        }
        return this.f16376h;
    }

    private void m16436c() {
        this.f16373e.schedule(new C19301(this), this.f16378j, TimeUnit.MILLISECONDS);
    }

    public static synchronized void m16437d(ThreadNotificationPrefsSynchronizer threadNotificationPrefsSynchronizer) {
        synchronized (threadNotificationPrefsSynchronizer) {
            if (threadNotificationPrefsSynchronizer.f16376h != null && threadNotificationPrefsSynchronizer.f16375g == null) {
                Iterator it = threadNotificationPrefsSynchronizer.f16376h.values().iterator();
                if (it.hasNext()) {
                    ModifyThreadParams modifyThreadParams = (ModifyThreadParams) it.next();
                    it.remove();
                    threadNotificationPrefsSynchronizer.f16377i = modifyThreadParams;
                    modifyThreadParams.m17155a().toString();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("modifyThreadParams", modifyThreadParams);
                    threadNotificationPrefsSynchronizer.f16375g = BlueServiceOperationFactoryDetour.a(threadNotificationPrefsSynchronizer.f16371c, "modify_thread", bundle, 1458211606).a();
                    Futures.a(threadNotificationPrefsSynchronizer.f16375g, new C19312(threadNotificationPrefsSynchronizer));
                } else {
                    threadNotificationPrefsSynchronizer.f16376h = null;
                    threadNotificationPrefsSynchronizer.m16440g();
                }
            }
        }
    }

    public static synchronized void m16438e(ThreadNotificationPrefsSynchronizer threadNotificationPrefsSynchronizer) {
        synchronized (threadNotificationPrefsSynchronizer) {
            threadNotificationPrefsSynchronizer.f16377i.m17155a().toString();
            threadNotificationPrefsSynchronizer.f16375g = null;
            threadNotificationPrefsSynchronizer.f16377i = null;
            threadNotificationPrefsSynchronizer.f16378j = 4000;
            threadNotificationPrefsSynchronizer.f16379k = 0;
            m16437d(threadNotificationPrefsSynchronizer);
            threadNotificationPrefsSynchronizer.m16440g();
        }
    }

    public static synchronized void m16439f(ThreadNotificationPrefsSynchronizer threadNotificationPrefsSynchronizer) {
        synchronized (threadNotificationPrefsSynchronizer) {
            threadNotificationPrefsSynchronizer.f16375g = null;
            if (threadNotificationPrefsSynchronizer.f16376h == null) {
                threadNotificationPrefsSynchronizer.f16376h = Maps.c();
            }
            ThreadKey a = threadNotificationPrefsSynchronizer.f16377i.m17155a();
            if (!threadNotificationPrefsSynchronizer.f16376h.containsKey(a)) {
                threadNotificationPrefsSynchronizer.f16376h.put(a, threadNotificationPrefsSynchronizer.f16377i);
            }
            threadNotificationPrefsSynchronizer.f16377i = null;
            if (((long) threadNotificationPrefsSynchronizer.f16379k) < 5) {
                threadNotificationPrefsSynchronizer.f16379k++;
                threadNotificationPrefsSynchronizer.f16378j = Math.min(2 * threadNotificationPrefsSynchronizer.f16378j, 600000);
                new StringBuilder("Failed to update thread notification settings. Retrying in ").append(threadNotificationPrefsSynchronizer.f16378j / 1000).append(" seconds");
                threadNotificationPrefsSynchronizer.m16436c();
            } else {
                threadNotificationPrefsSynchronizer.f16379k = 0;
                threadNotificationPrefsSynchronizer.f16378j = 4000;
                threadNotificationPrefsSynchronizer.f16376h = null;
            }
            threadNotificationPrefsSynchronizer.m16440g();
        }
    }

    private void m16440g() {
        C19251 c19251 = this.f16380l;
        if (c19251 != null) {
            c19251.m16407a();
        }
    }
}
