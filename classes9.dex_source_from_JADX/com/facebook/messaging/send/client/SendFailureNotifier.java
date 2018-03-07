package com.facebook.messaging.send.client;

import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.appstate.AppStateManager;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultSerialListeningExecutorService;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.file.StatFsHelperMethodAutoProvider;
import com.facebook.common.netchecker.NetCheckState;
import com.facebook.common.netchecker.NetChecker;
import com.facebook.common.statfs.StatFsHelper;
import com.facebook.common.statfs.StatFsHelper.StorageType;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.cache.DataCache;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threadkey.ThreadKey.Type;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.notify.FailedToSendMessageNotification;
import com.facebook.messaging.notify.FailedToSendMessageNotification.FailureReason;
import com.facebook.messaging.notify.MessagesNotificationClient;
import com.facebook.messaging.prefs.MessagingPrefKeys;
import com.facebook.messaging.send.common.SendMessageException;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.push.mqtt.service.MqttPushServiceClientManagerImpl;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: delay_ms */
public class SendFailureNotifier {
    private static final Object f16720m = new Object();
    private final AppStateManager f16721a;
    private final MessagesNotificationClient f16722b;
    private final DefaultAndroidThreadUtil f16723c;
    private final AnalyticsLogger f16724d;
    private final Set<String> f16725e = new HashSet();
    public final NetChecker f16726f;
    public final FbSharedPreferences f16727g;
    public final SystemClock f16728h;
    private final MqttPushServiceClientManagerImpl f16729i;
    private final DefaultSerialListeningExecutorService f16730j;
    public final StatFsHelper f16731k;
    private final DataCache f16732l;

    /* compiled from: delay_ms */
    enum SendFailureType {
        PERMANENT,
        CAPTIVE_PORTAL,
        BACKGROUND_DATA_RESTRICTION,
        LONG_QUEUE_TIME,
        MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE
    }

    public static boolean m16750b(com.facebook.messaging.send.client.SendFailureNotifier r3) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = r3.f16721a;
        r0 = r0.j();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = 0;
        r0 = r3.f16729i;	 Catch:{ all -> 0x0025 }
        r1 = r0.a();	 Catch:{ all -> 0x0025 }
        r0 = r1.e();	 Catch:{ all -> 0x0025 }
        r2 = com.facebook.rti.mqtt.manager.DataRestrictionDetector.BackgroundDataRestriction.YES;	 Catch:{ all -> 0x0025 }
        r2 = r2.toString();	 Catch:{ all -> 0x0025 }
        r0 = r2.equals(r0);	 Catch:{ all -> 0x0025 }
        if (r1 == 0) goto L_0x0009;
    L_0x0021:
        r1.f();
        goto L_0x0009;
    L_0x0025:
        r0 = move-exception;
        if (r1 == 0) goto L_0x002b;
    L_0x0028:
        r1.f();
    L_0x002b:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendFailureNotifier.b(com.facebook.messaging.send.client.SendFailureNotifier):boolean");
    }

    private static SendFailureNotifier m16748b(InjectorLike injectorLike) {
        return new SendFailureNotifier(MessagesNotificationClient.m13115a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), NetChecker.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike), AppStateManager.a(injectorLike), MqttPushServiceClientManagerImpl.a(injectorLike), DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(injectorLike), StatFsHelperMethodAutoProvider.a(injectorLike), DataCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.send.client.SendFailureNotifier m16743a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f16720m;	 Catch:{ all -> 0x006c }
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
        r1 = m16748b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f16720m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendFailureNotifier) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.send.client.SendFailureNotifier) r0;	 Catch:{  }
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
        r0 = f16720m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.send.client.SendFailureNotifier) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.send.client.SendFailureNotifier.a(com.facebook.inject.InjectorLike):com.facebook.messaging.send.client.SendFailureNotifier");
    }

    @Inject
    public SendFailureNotifier(MessagesNotificationClient messagesNotificationClient, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AnalyticsLogger analyticsLogger, NetChecker netChecker, FbSharedPreferences fbSharedPreferences, SystemClock systemClock, AppStateManager appStateManager, MqttPushServiceClientManagerImpl mqttPushServiceClientManagerImpl, DefaultSerialListeningExecutorService defaultSerialListeningExecutorService, StatFsHelper statFsHelper, DataCache dataCache) {
        this.f16722b = messagesNotificationClient;
        this.f16723c = defaultAndroidThreadUtil;
        this.f16724d = analyticsLogger;
        this.f16726f = netChecker;
        this.f16727g = fbSharedPreferences;
        this.f16728h = systemClock;
        this.f16721a = appStateManager;
        this.f16729i = mqttPushServiceClientManagerImpl;
        this.f16730j = defaultSerialListeningExecutorService;
        this.f16731k = statFsHelper;
        this.f16732l = dataCache;
    }

    public final synchronized void m16758a(Message message) {
        this.f16725e.remove(message.n);
    }

    public final synchronized void m16759a(Message message, Throwable th) {
        if (m16747a(th)) {
            m16744a(message, SendFailureType.MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE, null);
        } else {
            m16744a(message, SendFailureType.PERMANENT, null);
        }
    }

    public final synchronized void m16760b(final Message message) {
        ExecutorDetour.a(this.f16730j, new Runnable(this) {
            final /* synthetic */ SendFailureNotifier f16712b;

            public void run() {
                Object obj;
                if (this.f16712b.f16726f.m == NetCheckState.CAPTIVE_PORTAL) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    SendFailureNotifier.m16752d(this.f16712b, message);
                } else if (SendFailureNotifier.m16750b(this.f16712b)) {
                    SendFailureNotifier.m16753e(this.f16712b, message);
                } else {
                    if ((this.f16712b.f16728h.a() - message.c > 10800000 ? 1 : null) != null) {
                        SendFailureNotifier.m16754f(this.f16712b, message);
                    }
                }
            }
        }, 1732928167);
    }

    public final synchronized void m16761c(Message message) {
        SendFailureType sendFailureType = SendFailureType.PERMANENT;
        m16757j(message);
    }

    private static boolean m16747a(Throwable th) {
        if ((th instanceof SendMessageException) && (th.getCause() instanceof FileNotFoundException)) {
            return true;
        }
        return false;
    }

    private synchronized void m16744a(final Message message, final SendFailureType sendFailureType, @Nullable final PrefKey prefKey) {
        if (this.f16725e.add(message.n)) {
            this.f16723c.a(new Runnable(this) {
                final /* synthetic */ SendFailureNotifier f16716d;

                public void run() {
                    boolean a = SendFailureNotifier.m16746a(this.f16716d, message, sendFailureType);
                    if (prefKey != null && a) {
                        SendFailureNotifier sendFailureNotifier = this.f16716d;
                        sendFailureNotifier.f16727g.edit().a(prefKey, sendFailureNotifier.f16728h.a()).commit();
                    }
                }
            }, 10000);
        }
    }

    public static void m16752d(SendFailureNotifier sendFailureNotifier, Message message) {
        if (!sendFailureNotifier.m16751b(MessagingPrefKeys.aQ)) {
            sendFailureNotifier.m16744a(message, SendFailureType.CAPTIVE_PORTAL, MessagingPrefKeys.aQ);
        }
    }

    public static void m16753e(SendFailureNotifier sendFailureNotifier, Message message) {
        if (!sendFailureNotifier.m16751b(MessagingPrefKeys.aS)) {
            sendFailureNotifier.m16744a(message, SendFailureType.BACKGROUND_DATA_RESTRICTION, MessagingPrefKeys.aS);
        }
    }

    public static void m16754f(SendFailureNotifier sendFailureNotifier, Message message) {
        if (!sendFailureNotifier.m16751b(MessagingPrefKeys.aR)) {
            sendFailureNotifier.m16744a(message, SendFailureType.LONG_QUEUE_TIME, MessagingPrefKeys.aR);
        }
    }

    private boolean m16751b(PrefKey prefKey) {
        long a = this.f16728h.a() - this.f16727g.a(prefKey, 0);
        if (a >= 0 && a <= 3600000) {
            return true;
        }
        return false;
    }

    public static synchronized boolean m16746a(SendFailureNotifier sendFailureNotifier, Message message, SendFailureType sendFailureType) {
        boolean h;
        synchronized (sendFailureNotifier) {
            final String str = message.n;
            if (sendFailureNotifier.f16725e.contains(str)) {
                MessagesCollection b = sendFailureNotifier.f16732l.b(message.b);
                Message message2 = (Message) Iterables.a(b == null ? ImmutableList.of() : b.b(), new Predicate<Message>(sendFailureNotifier) {
                    final /* synthetic */ SendFailureNotifier f16718b;

                    public boolean apply(Object obj) {
                        return str.equals(((Message) obj).n);
                    }
                }, null);
                h = message2 != null ? sendFailureType == SendFailureType.PERMANENT ? sendFailureNotifier.m16755h(message2) : sendFailureNotifier.m16749b(message2, sendFailureType) : false;
                sendFailureNotifier.m16758a(message);
            } else {
                h = false;
            }
        }
        return h;
    }

    private boolean m16755h(Message message) {
        ThreadKey threadKey = message.b;
        if (message.l == MessageType.FAILED_SEND) {
            ThreadSummary a = this.f16732l.a(threadKey);
            if (a == null) {
                return false;
            }
            this.f16722b.m13120a(new FailedToSendMessageNotification(a.a, FailureReason.UNKNOWN));
            return true;
        } else if (message.l != MessageType.REGULAR) {
            return false;
        } else {
            m16745a(threadKey);
            return false;
        }
    }

    private boolean m16749b(Message message, SendFailureType sendFailureType) {
        switch (sendFailureType) {
            case CAPTIVE_PORTAL:
                this.f16722b.m13120a(new FailedToSendMessageNotification(message.b, FailureReason.CAPTIVE_PORTAL));
                return true;
            case BACKGROUND_DATA_RESTRICTION:
                this.f16722b.m13120a(new FailedToSendMessageNotification(message.b, FailureReason.RESTRICTED_BACKGROUND_MODE));
                return true;
            case LONG_QUEUE_TIME:
                this.f16722b.m13120a(new FailedToSendMessageNotification(message.b, FailureReason.LONG_QUEUE_TIME));
                return true;
            case MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE:
                return m16756i(message);
            default:
                return false;
        }
    }

    private boolean m16756i(Message message) {
        Object obj = 1;
        if ((this.f16731k.a(StorageType.EXTERNAL) <= 0 && this.f16731k.a(StorageType.INTERNAL) <= 0) || !(this.f16731k.a(StorageType.EXTERNAL, 10240) || this.f16731k.a(StorageType.INTERNAL, 10240))) {
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        this.f16722b.m13120a(new FailedToSendMessageNotification(message.b, FailureReason.MEDIA_UPLOAD_FILE_NOT_FOUND_LOW_DISK_SPACE));
        return true;
    }

    private boolean m16757j(Message message) {
        ThreadKey threadKey = message.b;
        if (ThreadKey.f(threadKey) && message.l == MessageType.FAILED_SEND) {
            this.f16722b.m13120a(new FailedToSendMessageNotification(threadKey, FailureReason.UNKNOWN));
            return true;
        } else if (message.l != MessageType.REGULAR) {
            return false;
        } else {
            m16745a(threadKey);
            return false;
        }
    }

    private void m16745a(ThreadKey threadKey) {
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("spurious_send_failure");
        if (threadKey.a == Type.GROUP) {
            honeyClientEvent.a("thread_fbid", threadKey.b);
        } else {
            honeyClientEvent.a("other_user_id", threadKey.d);
        }
        this.f16724d.a(honeyClientEvent);
    }
}
