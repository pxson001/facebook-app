package com.facebook.presence;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.LruCache;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.CounterLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.collect.WeakHashSets;
import com.facebook.common.cursors.CursorIterator;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.util.TriState;
import com.facebook.contacts.protocol.push.ContactsMessengerUserMap;
import com.facebook.contacts.upload.ContactsUploadState;
import com.facebook.contacts.upload.ContactsUploadState.Status;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.localstats.LocalStatsLogger;
import com.facebook.localstats.LocalStatsLoggerImpl;
import com.facebook.localstats.LocalStatsLoggerMethodAutoProvider;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messages.Message;
import com.facebook.mqtt.messages.MqttQOSLevel;
import com.facebook.mqtt.model.thrift.AdditionalContacts;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.presence.PresenceManager.OnContactPresenceStateChangedListener;
import com.facebook.presence.PresenceManager.PresenceListener;
import com.facebook.presence.PresenceState.Builder;
import com.facebook.presence.TypingPresenceManager.TypingState;
import com.facebook.presence.configs.DisableGenericPresenceTimerXConfig;
import com.facebook.presence.configs.PresenceLruCacheXConfig;
import com.facebook.push.mqtt.external.PushStateEvent;
import com.facebook.push.mqtt.persistence.MqttSubscriptionPersistence;
import com.facebook.push.mqtt.service.ChannelConnectivityTracker;
import com.facebook.push.mqtt.service.ForceAutoSubscriberUpdate;
import com.facebook.push.mqtt.service.MqttDynamicTopic;
import com.facebook.push.mqtt.service.MqttDynamicTopicsSetProvider;
import com.facebook.push.mqtt.service.MqttPushServiceWrapper;
import com.facebook.push.prefs.PushPrefKeys;
import com.facebook.thrift.TException;
import com.facebook.thrift.TSerializer;
import com.facebook.thrift.protocol.TCompactProtocol.Factory;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.user.model.LastActive;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.xconfig.core.XConfigReader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: msg_reliability */
public class DefaultPresenceManager implements INeedInit {
    private static volatile DefaultPresenceManager f7415S;
    private static final Class<?> f7416a = DefaultPresenceManager.class;
    private final ConcurrentMap<UserKey, UserState> f7417A;
    private final Runnable f7418B = new C03591(this);
    public final LruCache<UserKey, UserKey> f7419C;
    public final LruCache<UserKey, UserKey> f7420D;
    public final Set<UserKey> f7421E;
    public volatile boolean f7422F;
    private volatile boolean f7423G;
    @GuardedBy("ui thread")
    private final DebugInfo f7424H;
    private Set<Object> f7425I = WeakHashSets.m7798a();
    private boolean f7426J;
    public PresenceManager$PresenceDownloadState f7427K;
    public PresenceManager$PresenceDownloadState f7428L;
    public MqttDynamicTopic f7429M;
    private MqttDynamicTopicsSetProvider f7430N;
    private Set<UserKey> f7431O;
    public ScheduledFuture f7432P;
    public long f7433Q = -1;
    private long f7434R = -1;
    private final Lazy<MqttPushServiceWrapper> f7435b;
    private final Lazy<ChannelConnectivityTracker> f7436c;
    private final Provider<ContactPresenceIterators> f7437d;
    private final Lazy<AndroidThreadUtil> f7438e;
    private final Lazy<ListeningExecutorService> f7439f;
    private final Lazy<Executor> f7440g;
    private final FbSharedPreferences f7441h;
    private final BaseFbBroadcastManager f7442i;
    private final OnSharedPreferenceChangeListener f7443j;
    private final Lazy<Clock> f7444k;
    public final Provider<Boolean> f7445l;
    private final AbstractFbErrorReporter f7446m;
    private final CounterLogger f7447n;
    private final LocalStatsLoggerImpl f7448o;
    public final Provider<Boolean> f7449p;
    private final AnalyticsLogger f7450q;
    public final ForceAutoSubscriberUpdate f7451r;
    public final Provider<Boolean> f7452s;
    public final Provider<Boolean> f7453t;
    private final ScheduledExecutorService f7454u;
    private final Provider<XConfigReader> f7455v;
    private final SelfRegistrableReceiverImpl f7456w;
    private final Provider<Boolean> f7457x;
    @GuardedBy("ui thread")
    private final Multimap<UserKey, OnContactPresenceStateChangedListener> f7458y;
    public final ConcurrentMap<PresenceListener, Boolean> f7459z;

    /* compiled from: msg_reliability */
    class C03591 implements Runnable {
        final /* synthetic */ DefaultPresenceManager f7478a;

        C03591(DefaultPresenceManager defaultPresenceManager) {
            this.f7478a = defaultPresenceManager;
        }

        public void run() {
            this.f7478a.f7432P = null;
            if (((Boolean) this.f7478a.f7452s.get()).booleanValue() || ((Boolean) this.f7478a.f7453t.get()).booleanValue()) {
                DefaultPresenceManager.m7739l(this.f7478a);
                if (this.f7478a.f7429M.c) {
                    this.f7478a.f7429M.c = false;
                    this.f7478a.f7451r.m7772a();
                    this.f7478a.f7433Q = -1;
                }
            }
        }
    }

    /* compiled from: msg_reliability */
    class DebugInfo {
        public long f7479a = -1;
        public long f7480b = -1;
        public int f7481c = -1;
        public long f7482d = -1;
        public PresenceManager$PresenceDownloadState f7483e = PresenceManager$PresenceDownloadState.TP_DISABLED;

        public String toString() {
            return Objects.toStringHelper(this).add("lastUpdateTimestamp", this.f7479a).add("lastFullUpdateTimestamp", this.f7480b).add("lastFullUpdateSize", this.f7481c).add("lastMqttDisconnect", this.f7482d).add("lastPresenceFullListDownloadState", this.f7483e).toString();
        }
    }

    /* compiled from: msg_reliability */
    class C03609 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7491a;

        C03609(DefaultPresenceManager defaultPresenceManager) {
            this.f7491a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1484997355);
            DefaultPresenceManager.m7742o(this.f7491a);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1015258245, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03618 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7492a;

        C03618(DefaultPresenceManager defaultPresenceManager) {
            this.f7492a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -120121649);
            switch (PushStateEvent.fromValue(intent.getIntExtra("event", -1))) {
                case CHANNEL_DISCONNECTED:
                    DefaultPresenceManager.m7749v(this.f7492a);
                    break;
                case CHANNEL_CONNECTED:
                    DefaultPresenceManager defaultPresenceManager = this.f7492a;
                    defaultPresenceManager.m7751a();
                    defaultPresenceManager.f7427K = PresenceManager$PresenceDownloadState.MQTT_CONNECTED_WAITING_FOR_PRESENCE;
                    for (PresenceListener b : defaultPresenceManager.f7459z.keySet()) {
                        b.b();
                    }
                    break;
            }
            LogUtils.e(-1423927614, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03627 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7493a;

        C03627(DefaultPresenceManager defaultPresenceManager) {
            this.f7493a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 629367977);
            DefaultPresenceManager.m7733d(this.f7493a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1499512444, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03636 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7494a;

        C03636(DefaultPresenceManager defaultPresenceManager) {
            this.f7494a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -410701852);
            DefaultPresenceManager.m7732c(this.f7494a, intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -433504241, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03645 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7495a;

        C03645(DefaultPresenceManager defaultPresenceManager) {
            this.f7495a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1763338722);
            this.f7495a.m7752a(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 135890045, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03654 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7496a;

        C03654(DefaultPresenceManager defaultPresenceManager) {
            this.f7496a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1994668057);
            this.f7496a.m7758b(intent);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -1439936134, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03663 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7497a;

        C03663(DefaultPresenceManager defaultPresenceManager) {
            this.f7497a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1247766882);
            if (((Boolean) this.f7497a.f7449p.get()).booleanValue()) {
                String stringExtra = intent.getStringExtra("DESC_PRESENCE_TOPIC_NAME");
                if (Objects.equal(stringExtra, "/t_p")) {
                    DefaultPresenceManager.m7726a(this.f7497a, PresenceManager$PresenceDownloadState.TP_DISABLED);
                }
                DefaultPresenceManager.m7727a(this.f7497a, stringExtra);
            }
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 715759212, a);
        }
    }

    /* compiled from: msg_reliability */
    class C03672 implements ActionReceiver {
        final /* synthetic */ DefaultPresenceManager f7498a;

        C03672(DefaultPresenceManager defaultPresenceManager) {
            this.f7498a = defaultPresenceManager;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1856568235);
            if (Objects.equal(intent.getStringExtra("DESC_PRESENCE_TOPIC_NAME"), "/t_p")) {
                DefaultPresenceManager.m7726a(this.f7498a, PresenceManager$PresenceDownloadState.TP_WAITING_FOR_FULL_LIST);
            }
            this.f7498a.m7751a();
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1116093954, a);
        }
    }

    public static com.facebook.presence.DefaultPresenceManager m7724a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f7415S;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.presence.DefaultPresenceManager.class;
        monitor-enter(r1);
        r0 = f7415S;	 Catch:{ all -> 0x003a }
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
        r0 = m7731b(r0);	 Catch:{ all -> 0x0035 }
        f7415S = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7415S;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.presence.DefaultPresenceManager.a(com.facebook.inject.InjectorLike):com.facebook.presence.DefaultPresenceManager");
    }

    private static DefaultPresenceManager m7731b(InjectorLike injectorLike) {
        return new DefaultPresenceManager(IdBasedSingletonScopeProvider.b(injectorLike, 3210), IdBasedSingletonScopeProvider.b(injectorLike, 3194), IdBasedSingletonScopeProvider.a(injectorLike, 3087), IdBasedLazy.a(injectorLike, 517), IdBasedSingletonScopeProvider.b(injectorLike, 3834), IdBasedSingletonScopeProvider.b(injectorLike, 3863), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 609), IdBasedProvider.a(injectorLike, 4296), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), CounterLogger.a(injectorLike), LocalStatsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4266), AnalyticsLoggerMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4269), IdBasedProvider.a(injectorLike, 4267), ForceAutoSubscriberUpdate.m7770a(injectorLike), MqttDynamicTopicsSetProvider.m7796a(injectorLike), IdBasedSingletonScopeProvider.a(injectorLike, 3749), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 4268));
    }

    @Inject
    public DefaultPresenceManager(Lazy<MqttPushServiceWrapper> lazy, Lazy<ChannelConnectivityTracker> lazy2, Provider<ContactPresenceIterators> provider, Lazy<AndroidThreadUtil> lazy3, Lazy<ListeningExecutorService> lazy4, Lazy<Executor> lazy5, FbSharedPreferences fbSharedPreferences, FbBroadcastManager fbBroadcastManager, Lazy<Clock> lazy6, Provider<Boolean> provider2, FbErrorReporter fbErrorReporter, CounterLogger counterLogger, LocalStatsLogger localStatsLogger, Provider<Boolean> provider3, AnalyticsLogger analyticsLogger, Provider<Boolean> provider4, Provider<Boolean> provider5, ForceAutoSubscriberUpdate forceAutoSubscriberUpdate, MqttDynamicTopicsSetProvider mqttDynamicTopicsSetProvider, Provider<XConfigReader> provider6, ScheduledExecutorService scheduledExecutorService, Provider<Boolean> provider7) {
        this.f7435b = lazy;
        this.f7436c = lazy2;
        this.f7437d = provider;
        this.f7438e = lazy3;
        this.f7439f = lazy4;
        this.f7440g = lazy5;
        this.f7441h = fbSharedPreferences;
        this.f7442i = fbBroadcastManager;
        this.f7444k = lazy6;
        this.f7445l = provider2;
        this.f7446m = fbErrorReporter;
        this.f7447n = counterLogger;
        this.f7448o = localStatsLogger;
        this.f7449p = provider3;
        this.f7453t = provider5;
        this.f7450q = analyticsLogger;
        this.f7452s = provider4;
        this.f7451r = forceAutoSubscriberUpdate;
        this.f7430N = mqttDynamicTopicsSetProvider;
        this.f7454u = scheduledExecutorService;
        this.f7455v = provider6;
        this.f7457x = provider7;
        this.f7458y = HashMultimap.u();
        this.f7459z = Maps.e();
        this.f7417A = Maps.e();
        this.f7424H = new DebugInfo();
        this.f7419C = new LruCache(((XConfigReader) this.f7455v.get()).a(PresenceLruCacheXConfig.f7486d, 10));
        this.f7420D = new LruCache(((XConfigReader) this.f7455v.get()).a(PresenceLruCacheXConfig.f7487e, 10));
        this.f7421E = new HashSet();
        this.f7431O = new HashSet();
        m7726a(this, PresenceManager$PresenceDownloadState.TP_DISABLED);
        this.f7456w = this.f7442i.a().a("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED", new ActionReceiver(this) {
            final /* synthetic */ DefaultPresenceManager f7489a;

            {
                this.f7489a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 775281471);
                if ("com.facebook.orca.contacts.CONTACTS_UPLOAD_STATE_CHANGED".equals(intent.getAction()) && ((ContactsUploadState) intent.getParcelableExtra("state")).a == Status.RUNNING) {
                    DefaultPresenceManager.m7742o(this.f7489a);
                }
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1674107013, a);
            }
        }).a("com.facebook.contacts.ACTION_CONTACT_SYNC_PROGRESS", new ActionReceiver(this) {
            final /* synthetic */ DefaultPresenceManager f7490a;

            {
                this.f7490a = r1;
            }

            public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1343963103);
                DefaultPresenceManager.m7742o(this.f7490a);
                Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 1738890378, a);
            }
        }).a("com.facebook.contacts.ACTION_CONTACT_ADDED", new C03609(this)).a("com.facebook.push.mqtt.ACTION_CHANNEL_STATE_CHANGED", new C03618(this)).a("com.facebook.presence.ACTION_PUSH_RECEIVED", new C03627(this)).a("com.facebook.presence.ACTION_OTHER_USER_TYPING_CHANGED", new C03636(this)).a("com.facebook.presence.ACTION_PRESENCE_RECEIVED", new C03645(this)).a("com.facebook.presence.ACTION_PUSH_STATE_RECEIVED", new C03654(this)).a("ACTION_CLIENT_PRESENCE_TOPIC_UNSUBSCRIBE", new C03663(this)).a("ACTION_CLIENT_PRESENCE_TOPIC_SUBSCRIBE", new C03672(this)).a();
        this.f7443j = new OnSharedPreferenceChangeListener(this) {
            final /* synthetic */ DefaultPresenceManager f7499a;

            {
                this.f7499a = r1;
            }

            public final void m7801a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
                DefaultPresenceManager.m7741n(this.f7499a);
            }
        };
        this.f7427K = PresenceManager$PresenceDownloadState.MQTT_DISCONNECTED;
    }

    public final void m7756a(Object obj) {
        this.f7425I.add(obj);
        m7736i();
    }

    public final void m7761b(Object obj) {
        this.f7425I.remove(obj);
        m7736i();
    }

    private void m7736i() {
        if (this.f7425I.isEmpty() && this.f7426J) {
            m7738k();
            this.f7426J = false;
        } else if (!this.f7425I.isEmpty() && !this.f7426J) {
            m7737j();
            this.f7426J = true;
        }
    }

    private void m7737j() {
        ((DefaultAndroidThreadUtil) this.f7438e.get()).a();
        m7740m();
        this.f7434R = ((Clock) this.f7444k.get()).a();
        if (((Boolean) this.f7452s.get()).booleanValue() || ((Boolean) this.f7453t.get()).booleanValue()) {
            m7739l(this);
            if (!this.f7429M.c) {
                this.f7433Q = ((Clock) this.f7444k.get()).a();
                this.f7429M.c = true;
                this.f7451r.m7772a();
            }
        }
    }

    private void m7738k() {
        ((DefaultAndroidThreadUtil) this.f7438e.get()).a();
        if (this.f7434R != -1) {
            m7729a("android_generic_presence_interval_test", "android_generic_presence_interval_control", ((Clock) this.f7444k.get()).a() - this.f7434R);
            this.f7434R = -1;
        }
        m7729a("android_generic_presence_active_count_test", "android_generic_presence_active_count_control", (long) m7764c().size());
        m7740m();
        if (((Boolean) this.f7452s.get()).booleanValue() || ((Boolean) this.f7453t.get()).booleanValue()) {
            this.f7432P = this.f7454u.schedule(this.f7418B, ((XConfigReader) this.f7455v.get()).a(DisableGenericPresenceTimerXConfig.f1855d, 300), TimeUnit.SECONDS);
        }
    }

    public static void m7739l(DefaultPresenceManager defaultPresenceManager) {
        if (defaultPresenceManager.f7429M == null) {
            defaultPresenceManager.f7429M = new MqttDynamicTopic("/t_p", 0, MqttSubscriptionPersistence.APP_USE);
            MqttDynamicTopicsSetProvider mqttDynamicTopicsSetProvider = defaultPresenceManager.f7430N;
            mqttDynamicTopicsSetProvider.f7477a.add(defaultPresenceManager.f7429M);
        }
    }

    private void m7740m() {
        if (this.f7432P != null) {
            this.f7432P.cancel(false);
            this.f7432P = null;
        }
    }

    public static void m7741n(DefaultPresenceManager defaultPresenceManager) {
        defaultPresenceManager.f7442i.a(new Intent("com.facebook.presence.PRESENCE_MANAGER_SETTINGS_CHANGED"));
        defaultPresenceManager.m7730a(true);
    }

    public static void m7742o(DefaultPresenceManager defaultPresenceManager) {
        defaultPresenceManager.f7422F = false;
        defaultPresenceManager.m7757b();
    }

    public void init() {
        this.f7456w.b();
        this.f7441h.a(ImmutableSet.of(PushPrefKeys.a), this.f7443j);
    }

    public final void m7755a(UserKey userKey, OnContactPresenceStateChangedListener onContactPresenceStateChangedListener) {
        ((DefaultAndroidThreadUtil) this.f7438e.get()).a();
        this.f7458y.a(userKey, onContactPresenceStateChangedListener);
    }

    public final void m7760b(UserKey userKey, OnContactPresenceStateChangedListener onContactPresenceStateChangedListener) {
        ((DefaultAndroidThreadUtil) this.f7438e.get()).a();
        this.f7458y.c(userKey, onContactPresenceStateChangedListener);
    }

    public final void m7753a(PresenceListener presenceListener) {
        this.f7459z.put(presenceListener, Boolean.valueOf(true));
    }

    public final void m7759b(PresenceListener presenceListener) {
        this.f7459z.remove(presenceListener);
    }

    public final void m7754a(UserKey userKey) {
        if (((UserKey) this.f7419C.a(userKey, userKey)) == null && this.f7420D.a(userKey) == null && !this.f7421E.contains(userKey)) {
            m7751a();
        }
    }

    public final void m7751a() {
        if (((ChannelConnectivityTracker) this.f7436c.get()).f()) {
            ((ListeningExecutorService) this.f7439f.get()).a(new Runnable(this) {
                final /* synthetic */ DefaultPresenceManager f11622a;

                {
                    this.f11622a = r1;
                }

                public void run() {
                    DefaultPresenceManager.m7743p(this.f11622a);
                }
            });
        }
    }

    public static void m7727a(DefaultPresenceManager defaultPresenceManager, String str) {
        defaultPresenceManager.f7447n.a("presence_map_reset_on_topic_unsubscribe");
        defaultPresenceManager.f7448o.a(5832714);
        if (Objects.equal(str, "/t_p") && ((Boolean) defaultPresenceManager.f7452s.get()).booleanValue()) {
            defaultPresenceManager.m7747t();
        } else {
            defaultPresenceManager.m7748u();
        }
        defaultPresenceManager.m7730a(true);
    }

    public static void m7743p(DefaultPresenceManager defaultPresenceManager) {
        ((DefaultAndroidThreadUtil) defaultPresenceManager.f7438e.get()).b();
        if (defaultPresenceManager.f7419C.c() != 0 || defaultPresenceManager.f7420D.c() != 0 || !defaultPresenceManager.f7421E.isEmpty()) {
            defaultPresenceManager.f7423G = false;
        } else if (!defaultPresenceManager.f7423G) {
            defaultPresenceManager.f7423G = true;
        } else {
            return;
        }
        boolean booleanValue = ((Boolean) defaultPresenceManager.f7457x.get()).booleanValue();
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        List linkedList = new LinkedList();
        synchronized (defaultPresenceManager.f7431O) {
            HashSet hashSet = new HashSet();
            defaultPresenceManager.f7431O.clear();
            for (UserKey userKey : defaultPresenceManager.f7419C.d().keySet()) {
                if (userKey.a() == Type.FACEBOOK) {
                    defaultPresenceManager.f7431O.add(userKey);
                    hashSet.add(userKey.b());
                    if (booleanValue) {
                        linkedList.add(Long.valueOf(Long.parseLong(userKey.b())));
                    } else {
                        arrayNode.h(userKey.b());
                    }
                }
            }
            for (UserKey userKey2 : defaultPresenceManager.f7420D.d().keySet()) {
                if (userKey2.a() == Type.FACEBOOK && !hashSet.contains(userKey2.b())) {
                    defaultPresenceManager.f7431O.add(userKey2);
                    hashSet.add(userKey2.b());
                    if (booleanValue) {
                        linkedList.add(Long.valueOf(Long.parseLong(userKey2.b())));
                    } else {
                        arrayNode.h(userKey2.b());
                    }
                }
            }
            for (UserKey userKey22 : defaultPresenceManager.f7421E) {
                if (userKey22.a() == Type.FACEBOOK && !hashSet.contains(userKey22.b())) {
                    defaultPresenceManager.f7431O.add(userKey22);
                    if (booleanValue) {
                        linkedList.add(Long.valueOf(Long.parseLong(userKey22.b())));
                    } else {
                        arrayNode.h(userKey22.b());
                    }
                }
            }
        }
        if (booleanValue) {
            try {
                Object a = new TSerializer(new Factory()).a(new AdditionalContacts(linkedList));
                byte[] bArr = new byte[(a.length + 1)];
                System.arraycopy(a, 0, bArr, 1, a.length);
                ((MqttPushServiceWrapper) defaultPresenceManager.f7435b.get()).m12141a("/t_sac", bArr, MqttQOSLevel.FIRE_AND_FORGET, null);
                return;
            } catch (TException e) {
                BLog.b(f7416a, "/t_sac serialization error", e);
                return;
            }
        }
        JsonNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.c("additional_contacts", arrayNode);
        ((MqttPushServiceWrapper) defaultPresenceManager.f7435b.get()).m12140a("/send_additional_contacts", objectNode, MqttQOSLevel.FIRE_AND_FORGET, null);
    }

    public final void m7757b() {
        if (!this.f7422F) {
            this.f7422F = true;
            Futures.a(((ListeningExecutorService) this.f7439f.get()).a(new Callable<Void>(this) {
                final /* synthetic */ DefaultPresenceManager f11185a;

                {
                    this.f11185a = r1;
                }

                public Object call() {
                    DefaultPresenceManager.m7744q(this.f11185a);
                    return null;
                }
            }), new FutureCallback<Void>(this) {
                final /* synthetic */ DefaultPresenceManager f11186a;

                {
                    this.f11186a = r1;
                }

                public void onSuccess(Object obj) {
                    DefaultPresenceManager.m7746s(this.f11186a);
                }

                public void onFailure(Throwable th) {
                    this.f11186a.f7422F = false;
                }
            }, (Executor) this.f7440g.get());
        }
    }

    public static void m7744q(DefaultPresenceManager defaultPresenceManager) {
        ((DefaultAndroidThreadUtil) defaultPresenceManager.f7438e.get()).b();
        defaultPresenceManager.m7745r();
    }

    private void m7745r() {
        CursorIterator a = ((ContactPresenceIterators) this.f7437d.get()).m11619a();
        while (a.hasNext()) {
            try {
                ContactPushableState contactPushableState = (ContactPushableState) a.next();
                UserState f = m7734f(contactPushableState.f11479a);
                f.f11483b = contactPushableState.f11480b;
                f.f11484c = TriState.valueOf(contactPushableState.f11481c);
            } finally {
                a.close();
            }
        }
    }

    private UserState m7734f(UserKey userKey) {
        UserState userState = (UserState) this.f7417A.get(userKey);
        if (userState != null) {
            return userState;
        }
        UserState userState2 = new UserState();
        userState2.f11489h = userKey;
        userState = (UserState) this.f7417A.putIfAbsent(userKey, userState2);
        if (userState == null) {
            return userState2;
        }
        return userState;
    }

    public static void m7746s(DefaultPresenceManager defaultPresenceManager) {
        ((DefaultAndroidThreadUtil) defaultPresenceManager.f7438e.get()).a();
        defaultPresenceManager.m7730a(true);
    }

    private void m7735g(UserKey userKey) {
        ((DefaultAndroidThreadUtil) this.f7438e.get()).a();
        if (this.f7458y.f(userKey)) {
            PresenceState c = m7763c(userKey);
            for (OnContactPresenceStateChangedListener a : this.f7458y.c(userKey)) {
                a.a(userKey, c);
            }
        }
    }

    public static void m7726a(DefaultPresenceManager defaultPresenceManager, PresenceManager$PresenceDownloadState presenceManager$PresenceDownloadState) {
        defaultPresenceManager.f7424H.f7483e = presenceManager$PresenceDownloadState;
        defaultPresenceManager.f7428L = presenceManager$PresenceDownloadState;
    }

    public final boolean m7762b(UserKey userKey) {
        if (!m7750y()) {
            return false;
        }
        UserState userState = (UserState) this.f7417A.get(userKey);
        return userState != null && userState.f11485d;
    }

    public final PresenceState m7763c(UserKey userKey) {
        UserState userState = (UserState) this.f7417A.get(userKey);
        if (userState == null) {
            return PresenceState.a;
        }
        Availability availability;
        int i;
        if (m7750y() && userState.f11485d) {
            availability = Availability.AVAILABLE;
            i = userState.f11487f;
        } else {
            availability = Availability.NONE;
            i = 0;
        }
        Builder builder = new Builder();
        builder.a = availability;
        Builder builder2 = builder;
        builder2.b = userState.f11483b;
        builder2 = builder2;
        builder2.c = userState.f11484c;
        builder2 = builder2;
        builder2.d = userState.f11482a;
        builder2 = builder2;
        builder2.e = i;
        Builder builder3 = builder2;
        builder3.f = userState.f11488g;
        return builder3.g();
    }

    public final Collection<UserKey> m7764c() {
        if (!m7750y()) {
            return Collections.emptyList();
        }
        List a = Lists.a();
        for (Entry entry : this.f7417A.entrySet()) {
            if (((UserState) entry.getValue()).f11485d) {
                a.add(entry.getKey());
            }
        }
        return a;
    }

    public final LastActive m7766d(UserKey userKey) {
        UserState userState = (UserState) this.f7417A.get(userKey);
        if (userState == null) {
            return null;
        }
        long j = userState.f11486e;
        if (j <= 0) {
            return null;
        }
        if (j > 9223372036854775L) {
            this.f7446m.a("PresenceManagerError", StringFormatUtil.formatStrLocaleSafe("getLastActiveForUser invalid last active (overflow): %d seconds for user %s", Long.valueOf(j), userKey.b()));
            return null;
        }
        long j2 = 1000 * j;
        if (Math.abs(j2 - ((Clock) this.f7444k.get()).a()) <= 15552000000L) {
            return new LastActive(j2);
        }
        this.f7446m.a("PresenceManagerError", StringFormatUtil.formatStrLocaleSafe("getLastActiveForUser stale last active: %d seconds for user %s", Long.valueOf(j), userKey.b()));
        return null;
    }

    public final long m7767e(UserKey userKey) {
        if (!m7750y() || userKey == null) {
            return 0;
        }
        UserState userState = (UserState) this.f7417A.get(userKey);
        if (userState == null || userState.f11488g == 0) {
            return 0;
        }
        if (((ChannelConnectivityTracker) this.f7436c.get()).f()) {
            return userState.f11488g;
        }
        return 0;
    }

    public static void m7732c(DefaultPresenceManager defaultPresenceManager, Intent intent) {
        UserKey userKey = (UserKey) intent.getParcelableExtra("extra_user_key");
        int intExtra = intent.getIntExtra("extra_new_state", -1);
        if (intExtra != -1) {
            Integer.valueOf(intExtra);
            UserState f = defaultPresenceManager.m7734f(userKey);
            f.f11482a = intExtra == TypingState.ACTIVE.value;
            if (f.f11482a) {
                long a = ((Clock) defaultPresenceManager.f7444k.get()).a();
                defaultPresenceManager.f7447n.a("presence_typing");
                defaultPresenceManager.f7448o.a(5832715);
                if (!f.f11485d) {
                    defaultPresenceManager.m7725a(a, userKey.b(), defaultPresenceManager.m7766d(userKey));
                }
                f.f11486e = a / 1000;
            }
            defaultPresenceManager.m7735g(userKey);
        }
    }

    private void m7725a(long j, String str, @Nullable LastActive lastActive) {
        if (lastActive != null) {
            long j2 = lastActive.a;
            if (j - j2 >= 180000) {
                HoneyClientEvent b = new HoneyClientEvent("presence_stale").a("stale_active_time_ms", j2).a("new_active_time_ms", j).b("other_user_id", str).b("source", "typing");
                b.c = "presence_staleness";
                this.f7450q.a(b);
                this.f7447n.a("presence_typing_stale");
                this.f7448o.a(5832716);
            }
        }
    }

    @VisibleForTesting
    final void m7752a(Intent intent) {
        int i = 0;
        this.f7424H.f7479a = ((Clock) this.f7444k.get()).a();
        String stringExtra = intent.getStringExtra("extra_topic_name");
        PresenceList presenceList = (PresenceList) intent.getParcelableExtra("extra_presence_map");
        boolean booleanExtra = intent.getBooleanExtra("extra_full_list", false);
        ImmutableList immutableList = presenceList.f11723a;
        Boolean.valueOf(booleanExtra);
        this.f7447n.a("presence_mqtt_receive");
        this.f7447n.a("presence_mqtt_receive_item_count", (long) immutableList.size());
        this.f7448o.a(5832718, (long) immutableList.size());
        this.f7427K = PresenceManager$PresenceDownloadState.PRESENCE_MAP_RECEIVED;
        if (booleanExtra) {
            if (stringExtra == null || !stringExtra.equals("/t_p")) {
                m7747t();
            } else {
                if ((((Boolean) this.f7452s.get()).booleanValue() || ((Boolean) this.f7453t.get()).booleanValue()) && this.f7433Q != -1) {
                    this.f7447n.a("android_generic_presence_delay", ((Clock) this.f7444k.get()).a() - this.f7433Q);
                }
                m7726a(this, PresenceManager$PresenceDownloadState.TP_FULL_LIST_RECEIVED);
                m7748u();
            }
            this.f7424H.f7480b = this.f7424H.f7479a;
            this.f7424H.f7481c = immutableList.size();
        }
        int size = immutableList.size();
        while (i < size) {
            PresenceItem presenceItem = (PresenceItem) immutableList.get(i);
            UserState f = m7734f(presenceItem.a);
            f.f11485d = presenceItem.b;
            f.f11487f = presenceItem.d;
            if (presenceItem.c >= 0) {
                f.f11486e = presenceItem.c;
            }
            if (presenceItem.e != null) {
                f.f11488g = presenceItem.e.longValue();
            } else {
                f.f11488g = 0;
            }
            m7735g(presenceItem.a);
            i++;
        }
        m7730a(booleanExtra);
        m7736i();
    }

    final void m7758b(Intent intent) {
        if (intent.hasExtra("extra_on_messenger_map")) {
            ContactsMessengerUserMap contactsMessengerUserMap = (ContactsMessengerUserMap) intent.getParcelableExtra("extra_on_messenger_map");
            Iterator it = contactsMessengerUserMap.a.keySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                UserKey userKey = (UserKey) it.next();
                m7734f(userKey).f11484c = TriState.valueOf(((Boolean) contactsMessengerUserMap.a.get(userKey)).booleanValue());
                m7735g(userKey);
                z = true;
            }
            if (z) {
                m7730a(false);
            }
        }
    }

    private void m7747t() {
        synchronized (this.f7431O) {
            for (UserState userState : this.f7417A.values()) {
                if (!this.f7431O.contains(userState.f11489h)) {
                    m7728a(userState);
                }
            }
        }
    }

    private void m7748u() {
        for (UserState a : this.f7417A.values()) {
            m7728a(a);
        }
    }

    private static void m7728a(UserState userState) {
        userState.f11485d = false;
        userState.f11482a = false;
        userState.f11487f = 0;
        userState.f11486e = -1;
        userState.f11488g = 0;
    }

    private void m7730a(boolean z) {
        if (z) {
            for (UserKey g : this.f7458y.q()) {
                m7735g(g);
            }
        }
        for (PresenceListener a : this.f7459z.keySet()) {
            a.a();
        }
    }

    public static void m7733d(DefaultPresenceManager defaultPresenceManager, Intent intent) {
        UserKey userKey = ((Message) intent.getParcelableExtra("extra_message")).e.b;
        UserState userState = (UserState) defaultPresenceManager.f7417A.get(userKey);
        if (userState != null && userState.f11482a) {
            userState.f11482a = false;
            defaultPresenceManager.m7735g(userKey);
        }
    }

    public static void m7749v(DefaultPresenceManager defaultPresenceManager) {
        defaultPresenceManager.f7447n.a("presence_map_reset_on_mqtt_disconnect");
        defaultPresenceManager.f7448o.a(5832719);
        defaultPresenceManager.f7424H.f7482d = ((Clock) defaultPresenceManager.f7444k.get()).a();
        defaultPresenceManager.m7748u();
        defaultPresenceManager.f7427K = PresenceManager$PresenceDownloadState.MQTT_DISCONNECTED;
        defaultPresenceManager.m7730a(true);
    }

    public final PayForPlayPresence m7765d() {
        return ((Boolean) this.f7445l.get()).booleanValue() ? PayForPlayPresence.ENABLED : PayForPlayPresence.DISABLED;
    }

    private boolean m7750y() {
        return m7765d().shouldShowPresence();
    }

    public final Map<UserKey, UserState> m7768g() {
        return this.f7417A;
    }

    public final Set<UserKey> m7769h() {
        Set<UserKey> unmodifiableSet;
        synchronized (this.f7431O) {
            unmodifiableSet = Collections.unmodifiableSet(this.f7431O);
        }
        return unmodifiableSet;
    }

    private void m7729a(String str, String str2, long j) {
        if (((Boolean) this.f7452s.get()).booleanValue() || ((Boolean) this.f7453t.get()).booleanValue()) {
            this.f7447n.a(str, j);
        } else {
            this.f7447n.a(str2, j);
        }
    }
}
