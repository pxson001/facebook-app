package com.facebook.presence;

import android.content.Context;
import android.content.Intent;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CounterLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.mqtt.model.thrift.ThreadPresenceFromClientThrift;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.sync.model.thrift.MqttThriftHeader;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.UserKey;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: server_action_hide_inline_notification_nux */
public class ThreadPresenceManager implements INeedInit, Runnable {
    private static final Class<?> f2550a = ThreadPresenceManager.class;
    private static volatile ThreadPresenceManager f2551u;
    public final Lazy<MqttPushServiceWrapper> f2552b;
    public final Lazy<AndroidThreadUtil> f2553c;
    private final Lazy<ListeningExecutorService> f2554d;
    private final Executor f2555e;
    private final BaseFbBroadcastManager f2556f;
    private final Lazy<Clock> f2557g;
    public final CounterLogger f2558h;
    private final AnalyticsLogger f2559i;
    private final SelfRegistrableReceiverImpl f2560j;
    public final Provider<Boolean> f2561k;
    private final Provider<Boolean> f2562l;
    private String f2563m;
    private String f2564n;
    private long f2565o = -1;
    private long f2566p = -1;
    private final ScheduledExecutorService f2567q;
    public int f2568r = ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_NONE.getValue();
    @GuardedBy("ui thread")
    public final Multimap<UserKey, OnThreadPresenceStateChangedListener> f2569s;
    @GuardedBy("this")
    private final ConcurrentMap<UserKey, UserThreadPresenceState> f2570t;

    /* compiled from: server_action_hide_inline_notification_nux */
    public enum ThreadPresenceCapability {
        THREAD_PRESENCE_CAPABILITY_NONE(0),
        THREAD_PRESENCE_CAPABILITY_INSTANT_MVP(1),
        THREAD_PRESENCE_CAPABILITY_INSTANT(2),
        THREAD_PRESENCE_CAPABILITY_SILENT(4),
        THREAD_PRESENCE_CAPABILITY_MASK(255);
        
        private int value;

        public final int getValue() {
            return this.value;
        }

        private ThreadPresenceCapability(int i) {
            this.value = i;
        }
    }

    /* compiled from: server_action_hide_inline_notification_nux */
    class C01203 implements ActionReceiver {
        final /* synthetic */ ThreadPresenceManager f2571a;

        C01203(ThreadPresenceManager threadPresenceManager) {
            this.f2571a = threadPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -14629428);
            ThreadPresenceManager.m2840a(this.f2571a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1400130492, a);
        }
    }

    /* compiled from: server_action_hide_inline_notification_nux */
    class C01212 implements ActionReceiver {
        final /* synthetic */ ThreadPresenceManager f2572a;

        C01212(ThreadPresenceManager threadPresenceManager) {
            this.f2572a = threadPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1456968805);
            switch (PushStateEvent.fromValue(intent.getIntExtra("event", -1))) {
                case CHANNEL_DISCONNECTED:
                    ThreadPresenceManager.m2845c(this.f2572a);
                    break;
            }
            LogUtils.e(769015018, a);
        }
    }

    /* compiled from: server_action_hide_inline_notification_nux */
    class C01221 implements ActionReceiver {
        final /* synthetic */ ThreadPresenceManager f2573a;

        C01221(ThreadPresenceManager threadPresenceManager) {
            this.f2573a = threadPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1418231022);
            ThreadPresenceManager.m2846d(this.f2573a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1604662681, a);
        }
    }

    public static com.facebook.presence.ThreadPresenceManager m2838a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2551u;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.presence.ThreadPresenceManager.class;
        monitor-enter(r1);
        r0 = f2551u;	 Catch:{ all -> 0x003a }
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
        r0 = m2843b(r0);	 Catch:{ all -> 0x0035 }
        f2551u = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2551u;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.presence.ThreadPresenceManager.a(com.facebook.inject.InjectorLike):com.facebook.presence.ThreadPresenceManager");
    }

    private static ThreadPresenceManager m2843b(InjectorLike injectorLike) {
        return new ThreadPresenceManager(IdBasedSingletonScopeProvider.b(injectorLike, 3210), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 3834), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedProvider.a(injectorLike, 4270), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedProvider.a(injectorLike, 4296), ScheduledExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), CounterLogger.a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike));
    }

    public void run() {
        m2839a();
    }

    @Inject
    public ThreadPresenceManager(Lazy<MqttPushServiceWrapper> lazy, Lazy<AndroidThreadUtil> lazy2, Lazy<ListeningExecutorService> lazy3, FbBroadcastManager fbBroadcastManager, Provider<Boolean> provider, Lazy<Clock> lazy4, Provider<Boolean> provider2, ScheduledExecutorService scheduledExecutorService, Executor executor, CounterLogger counterLogger, AnalyticsLogger analyticsLogger) {
        this.f2552b = lazy;
        this.f2553c = lazy2;
        this.f2554d = lazy3;
        this.f2555e = executor;
        this.f2556f = fbBroadcastManager;
        this.f2557g = lazy4;
        this.f2558h = counterLogger;
        this.f2559i = analyticsLogger;
        this.f2561k = provider;
        this.f2569s = HashMultimap.u();
        this.f2570t = Maps.e();
        this.f2567q = scheduledExecutorService;
        this.f2562l = provider2;
        this.f2560j = this.f2556f.a().a("com.facebook.presence.ACTION_THREAD_PRESENCE_CHANGED", new C01203(this)).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C01212(this)).a(AppStateManager.c, new C01221(this)).a();
        this.f2560j.b();
        this.f2567q.scheduleAtFixedRate(this, 0, 5, TimeUnit.SECONDS);
    }

    public void init() {
    }

    public final void m2850a(int i) {
        this.f2568r = i;
    }

    private static int m2837a(int i, int i2) {
        return ((ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_MASK.getValue() & i2) << 2) | i;
    }

    private static int m2842b(int i) {
        return (i >> 2) & ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_MASK.getValue();
    }

    public final void m2851a(String str, int i) {
        if (((Boolean) this.f2561k.get()).booleanValue()) {
            if (i == 1) {
                if (this.f2565o <= 0 || ((Clock) this.f2557g.get()).a() - this.f2565o >= 5000 || !str.equals(this.f2563m)) {
                    this.f2563m = str;
                    this.f2565o = ((Clock) this.f2557g.get()).a();
                    this.f2566p = -1;
                    this.f2564n = "";
                } else {
                    return;
                }
            } else if (i != 0 || this.f2565o <= 0) {
                if (i != 2) {
                    return;
                }
            } else if (this.f2566p <= 0 || !str.equals(this.f2564n) || ((Clock) this.f2557g.get()).a() - this.f2566p >= 5000) {
                if (str.equals(this.f2563m)) {
                    long a = ((Clock) this.f2557g.get()).a() - this.f2565o;
                    this.f2559i.a(new HoneyClientEvent("thread_presence_local_duration").a("duration_ms", a).b("other_user_id", str).g("thread_presence"));
                    this.f2558h.a("thread_presence_local_duration_instance");
                    Long.valueOf(a);
                }
                this.f2566p = this.f2565o;
                this.f2564n = this.f2563m;
                this.f2565o = -1;
                this.f2563m = "";
            } else {
                return;
            }
            if (((Boolean) this.f2562l.get()).booleanValue()) {
                ThreadPresenceFromClientThrift threadPresenceFromClientThrift = new ThreadPresenceFromClientThrift(Long.valueOf(Long.parseLong(str)), Long.valueOf(0), Integer.valueOf(m2837a(i, this.f2568r)));
                try {
                    MqttThriftHeader mqttThriftHeader = new MqttThriftHeader("");
                    TSerializer tSerializer = new TSerializer(new Factory());
                    ((ListeningExecutorService) this.f2554d.get()).a(new 4(this, i, m2841a(tSerializer.a(mqttThriftHeader), tSerializer.a(threadPresenceFromClientThrift))));
                } catch (TException e) {
                    String message;
                    Object[] objArr = new Object[1];
                    if (e.getMessage() != null) {
                        message = e.getMessage();
                    } else {
                        message = "NULL";
                    }
                    objArr[0] = message;
                }
            }
        }
    }

    private static byte[] m2841a(byte[] bArr, byte[] bArr2) {
        Object copyOf = Arrays.copyOf(bArr, bArr.length + bArr2.length);
        System.arraycopy(bArr2, 0, copyOf, bArr.length, bArr2.length);
        return copyOf;
    }

    private synchronized UserThreadPresenceState m2847g(UserKey userKey) {
        UserThreadPresenceState userThreadPresenceState;
        userThreadPresenceState = (UserThreadPresenceState) this.f2570t.get(userKey);
        if (userThreadPresenceState == null) {
            UserThreadPresenceState userThreadPresenceState2 = new UserThreadPresenceState();
            userThreadPresenceState2.a = userKey;
            userThreadPresenceState = (UserThreadPresenceState) this.f2570t.putIfAbsent(userKey, userThreadPresenceState2);
            if (userThreadPresenceState == null) {
                userThreadPresenceState = userThreadPresenceState2;
            }
        }
        return userThreadPresenceState;
    }

    public static synchronized void m2848h(ThreadPresenceManager threadPresenceManager, UserKey userKey) {
        synchronized (threadPresenceManager) {
            ((DefaultAndroidThreadUtil) threadPresenceManager.f2553c.get()).a();
            if (userKey != null && threadPresenceManager.f2569s.f(userKey) && threadPresenceManager.f2570t.containsKey(userKey)) {
                boolean d = threadPresenceManager.m2854d(userKey);
                Boolean.valueOf(d);
                threadPresenceManager.f2570t.get(userKey);
                for (OnThreadPresenceStateChangedListener a : threadPresenceManager.f2569s.c(userKey)) {
                    a.a(d);
                }
            }
        }
    }

    private synchronized ThreadPresenceState m2849i(UserKey userKey) {
        ThreadPresenceState threadPresenceState;
        UserThreadPresenceState userThreadPresenceState = (UserThreadPresenceState) this.f2570t.get(userKey);
        if (userThreadPresenceState == null || userThreadPresenceState.b.size() == 0) {
            threadPresenceState = null;
        } else {
            threadPresenceState = (ThreadPresenceState) userThreadPresenceState.b.values().iterator().next();
        }
        return threadPresenceState;
    }

    public final synchronized String m2852b(UserKey userKey) {
        String str;
        ThreadPresenceState i = m2849i(userKey);
        if (i == null) {
            str = null;
        } else {
            str = i.d;
        }
        return str;
    }

    public final synchronized String m2853c(UserKey userKey) {
        String str;
        ThreadPresenceState i = m2849i(userKey);
        if (i == null) {
            str = null;
        } else {
            str = i.c;
        }
        return str;
    }

    public final synchronized boolean m2854d(@Nullable UserKey userKey) {
        boolean z;
        if (userKey == null) {
            z = false;
        } else {
            UserThreadPresenceState userThreadPresenceState = (UserThreadPresenceState) this.f2570t.get(userKey);
            z = userThreadPresenceState != null && userThreadPresenceState.b.size() > 0;
        }
        return z;
    }

    public final synchronized boolean m2855e(@Nullable UserKey userKey) {
        boolean z;
        z = m2854d(userKey) && userKey.b().equals(this.f2563m);
        return z;
    }

    public final synchronized int m2856f(@Nullable UserKey userKey) {
        int i;
        if (userKey != null) {
            UserThreadPresenceState userThreadPresenceState = (UserThreadPresenceState) this.f2570t.get(userKey);
            if (userThreadPresenceState != null && userThreadPresenceState.b.size() > 0) {
                Iterator it = userThreadPresenceState.b.values().iterator();
                if (it.hasNext()) {
                    i = ((ThreadPresenceState) it.next()).b & this.f2568r;
                }
            }
        }
        i = ThreadPresenceCapability.THREAD_PRESENCE_CAPABILITY_NONE.getValue();
        return i;
    }

    public static void m2840a(ThreadPresenceManager threadPresenceManager, Intent intent) {
        if (((Boolean) threadPresenceManager.f2562l.get()).booleanValue()) {
            String stringExtra = intent.getStringExtra("extra_device_id");
            String stringExtra2 = intent.getStringExtra("extra_app_id");
            int intExtra = intent.getIntExtra("extra_new_state", -1);
            if (intExtra != -1 && stringExtra.length() != 0 && stringExtra2.length() != 0) {
                UserKey userKey = (UserKey) intent.getParcelableExtra("extra_user_key");
                String concat = stringExtra2.concat(stringExtra);
                threadPresenceManager.f2558h.a("thread_presence_received");
                UserThreadPresenceState g = threadPresenceManager.m2847g(userKey);
                long a = ((Clock) threadPresenceManager.f2557g.get()).a();
                int b = m2842b(intExtra);
                int i = intExtra & 3;
                if (i == 0 && g.b.containsKey(concat)) {
                    ThreadPresenceState threadPresenceState = (ThreadPresenceState) g.b.get(concat);
                    HoneyClientEvent a2 = new HoneyClientEvent("thread_presence_remote_duration").a("duration_ms", a - threadPresenceState.e);
                    a2.c = "thread_presence";
                    a2 = a2;
                    if (!(userKey == null || userKey.b() == null)) {
                        a2.b("other_user_id", userKey.b());
                    }
                    threadPresenceManager.f2559i.a(a2);
                    threadPresenceManager.f2558h.a("thread_presence_remote_duration_instance");
                    userKey.b();
                    Integer.valueOf(i);
                    Long.valueOf(a - threadPresenceState.e);
                    Integer.valueOf(b);
                    g.b.remove(concat);
                }
                if (i == 1 || i == 2) {
                    if (g.b.containsKey(concat)) {
                        g.b.replace(concat, new ThreadPresenceState(stringExtra, stringExtra2, true, a, b));
                    } else {
                        g.b.putIfAbsent(concat, new ThreadPresenceState(stringExtra, stringExtra2, true, a, b));
                    }
                    userKey.b();
                    Integer.valueOf(i);
                    Integer.valueOf(b);
                    if (i == 1 && userKey.b() != null && userKey.b().equals(threadPresenceManager.f2563m)) {
                        threadPresenceManager.m2851a(userKey.b(), 2);
                    }
                }
                m2848h(threadPresenceManager, userKey);
            }
        }
    }

    private synchronized void m2839a() {
        long a = ((Clock) this.f2557g.get()).a();
        if (this.f2565o > 0 && a - this.f2565o > 25000) {
            m2851a(this.f2563m, 1);
            this.f2558h.a("thread_presence_ping_post");
        }
        for (UserThreadPresenceState userThreadPresenceState : this.f2570t.values()) {
            Object obj = null;
            for (ThreadPresenceState threadPresenceState : userThreadPresenceState.b.values()) {
                Object obj2;
                if (a - threadPresenceState.e > 30000) {
                    String concat = threadPresenceState.c.concat(threadPresenceState.d);
                    if (userThreadPresenceState.a.b() != null) {
                        userThreadPresenceState.a.b().toString();
                        threadPresenceState.toString();
                    }
                    userThreadPresenceState.b.remove(concat);
                    obj2 = 1;
                } else {
                    obj2 = obj;
                }
                obj = obj2;
            }
            if (obj != null) {
                ExecutorDetour.a(this.f2555e, new 5(this, userThreadPresenceState.a), -961156035);
            }
        }
    }

    private synchronized void m2844b() {
        for (UserThreadPresenceState userThreadPresenceState : this.f2570t.values()) {
            userThreadPresenceState.b.clear();
        }
    }

    public static void m2845c(ThreadPresenceManager threadPresenceManager) {
        threadPresenceManager.m2844b();
        for (UserKey h : threadPresenceManager.f2569s.q()) {
            m2848h(threadPresenceManager, h);
        }
    }

    public static void m2846d(ThreadPresenceManager threadPresenceManager) {
        threadPresenceManager.m2844b();
        for (UserKey h : threadPresenceManager.f2569s.q()) {
            m2848h(threadPresenceManager, h);
        }
    }
}
