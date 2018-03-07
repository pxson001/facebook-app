package com.facebook.messaging.media.upload;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.BaseFbBroadcastManager.SelfRegistrableReceiverImpl;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.debug.log.BLog;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.database.handlers.DbFetchThreadHandler;
import com.facebook.messaging.intents.MessagesBroadcastIntents;
import com.facebook.messaging.media.upload.util.MediaUploadKey;
import com.facebook.messaging.model.messages.Message;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource$Type;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.inject.Inject;

@UserScoped
/* compiled from: mAction */
public class TwoPhaseSendHandler {
    private static final Class<?> f8774a = TwoPhaseSendHandler.class;
    private static final Object f8775m = new Object();
    private final DbFetchThreadHandler f8776b;
    public final UpdateMessageForHiResMethod f8777c;
    public final ApiMethodRunnerImpl f8778d;
    private final TwoPhaseSendAnalyticsLogger f8779e;
    private final DefaultAndroidThreadUtil f8780f;
    private final GatekeeperStoreImpl f8781g;
    public final ListeningExecutorService f8782h;
    private final BaseFbBroadcastManager f8783i;
    private final SelfRegistrableReceiverImpl f8784j;
    private final Cache<String, List<MediaUploadKey>> f8785k = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();
    public final Cache<String, Boolean> f8786l = CacheBuilder.newBuilder().a(2073600000, TimeUnit.MILLISECONDS).q();

    /* compiled from: mAction */
    class C04191 implements ActionReceiver {
        final /* synthetic */ TwoPhaseSendHandler f8850a;

        C04191(TwoPhaseSendHandler twoPhaseSendHandler) {
            this.f8850a = twoPhaseSendHandler;
        }

        public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 616865655);
            ExecutorDetour.a(this.f8850a.f8782h, new 1(this, intent.getStringExtra("message_id"), intent.getStringExtra("offline_threading_id")), 156688264);
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, -935591861, a);
        }
    }

    private static TwoPhaseSendHandler m9090b(InjectorLike injectorLike) {
        return new TwoPhaseSendHandler(DbFetchThreadHandler.m9097a(injectorLike), UpdateMessageForHiResMethod.m9200a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), TwoPhaseSendAnalyticsLogger.m9205a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.TwoPhaseSendHandler m9086a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f8775m;	 Catch:{ all -> 0x006c }
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
        r1 = m9090b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f8775m;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.TwoPhaseSendHandler) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.TwoPhaseSendHandler) r0;	 Catch:{  }
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
        r0 = f8775m;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.TwoPhaseSendHandler) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.TwoPhaseSendHandler.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.TwoPhaseSendHandler");
    }

    @Inject
    @SuppressLint({"ConstructorMayLeakThis"})
    public TwoPhaseSendHandler(DbFetchThreadHandler dbFetchThreadHandler, UpdateMessageForHiResMethod updateMessageForHiResMethod, ApiMethodRunnerImpl apiMethodRunnerImpl, TwoPhaseSendAnalyticsLogger twoPhaseSendAnalyticsLogger, DefaultAndroidThreadUtil defaultAndroidThreadUtil, GatekeeperStoreImpl gatekeeperStoreImpl, ListeningExecutorService listeningExecutorService, BaseFbBroadcastManager baseFbBroadcastManager) {
        this.f8776b = dbFetchThreadHandler;
        this.f8777c = updateMessageForHiResMethod;
        this.f8778d = apiMethodRunnerImpl;
        this.f8779e = twoPhaseSendAnalyticsLogger;
        this.f8780f = defaultAndroidThreadUtil;
        this.f8781g = gatekeeperStoreImpl;
        this.f8782h = listeningExecutorService;
        this.f8783i = baseFbBroadcastManager;
        this.f8784j = this.f8783i.a().a(MessagesBroadcastIntents.j, new C04191(this)).a();
        this.f8784j.b();
    }

    public final boolean m9093a(MediaResource mediaResource) {
        if (mediaResource.d == MediaResource$Type.PHOTO && mediaResource.x == null && mediaResource.y == null) {
            return m9091b();
        }
        return false;
    }

    private boolean m9091b() {
        return this.f8781g.a(341, false);
    }

    public final synchronized boolean m9094b(MediaResource mediaResource) {
        boolean z;
        if (m9091b()) {
            String str = mediaResource.m;
            if (str == null) {
                BLog.a(f8774a, "Offline threading id is null, can't add hi-res upload");
                z = false;
            } else {
                try {
                    ((List) this.f8785k.a(str, new 2(this, str))).add(MediaUploadKey.a(mediaResource));
                    this.f8779e.m9208a(mediaResource);
                    z = true;
                } catch (Throwable e) {
                    BLog.b(f8774a, "It's quite impossible but creating pending uploads list failed.", e);
                    z = false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void m9092a(MediaResource mediaResource, Throwable th) {
        if (m9091b()) {
            String str = mediaResource.m;
            if (str == null) {
                BLog.a(f8774a, "Offline threading id is null, can't remove hi-res upload");
            } else {
                List list = (List) this.f8785k.a(str);
                if (list != null) {
                    list.remove(MediaUploadKey.a(mediaResource));
                    if (th == null) {
                        this.f8786l.a(str, Boolean.valueOf(true));
                        this.f8779e.m9213b(mediaResource);
                    } else {
                        this.f8779e.m9209a(mediaResource, th);
                    }
                    if (list.isEmpty()) {
                        this.f8780f.b("Need to run DbFetchThreadHandler on non UI thread");
                        Message c = this.f8776b.m9111c(str);
                        if (!(c == null || c.a == null)) {
                            m9088a(c);
                        }
                    }
                }
            }
        }
    }

    public static synchronized void m9087a(TwoPhaseSendHandler twoPhaseSendHandler, String str, String str2) {
        synchronized (twoPhaseSendHandler) {
            if (twoPhaseSendHandler.m9091b()) {
                if (str == null || str2 == null) {
                    BLog.a(f8774a, "messageId: %s, offlineThreadingId: %s, can't handle message sent", new Object[]{str, str2});
                } else {
                    List list = (List) twoPhaseSendHandler.f8785k.a(str2);
                    if (list != null && list.isEmpty()) {
                        twoPhaseSendHandler.f8780f.b("Need to run DbFetchThreadHandler on non UI thread");
                        Message b = twoPhaseSendHandler.f8776b.m9110b(str);
                        if (b != null) {
                            if (str2.equals(b.n)) {
                                twoPhaseSendHandler.m9088a(b);
                            } else {
                                BLog.b(f8774a, "offlineThreadingId doesn't match, expected: %s, actual: %s", new Object[]{str2, b.n});
                            }
                        }
                    }
                }
            }
        }
    }

    private void m9088a(Message message) {
        String str = message.n;
        Boolean bool = (Boolean) this.f8786l.a(str);
        if (bool == null || !bool.booleanValue()) {
            m9089a(str);
            return;
        }
        String str2 = message.a;
        this.f8779e.m9210a(str, str2);
        Exception exception = null;
        int i = 0;
        try {
            ListenableFuture a = this.f8782h.a(new 3(this, message, str2));
            int i2 = 0;
            while (true) {
                try {
                    bool = (Boolean) FutureDetour.a(a, 5000, TimeUnit.MILLISECONDS, 523012701);
                    break;
                } catch (TimeoutException e) {
                    exception = e;
                    bool = Boolean.valueOf(false);
                } catch (Exception e2) {
                    if (i < 5) {
                        i++;
                        int i3 = (int) (((long) i2) + (((long) i) * 1000));
                        this.f8780f.a((long) i3);
                        i2 = i3;
                    } else {
                        bool = Boolean.valueOf(false);
                        exception = e2;
                    }
                }
            }
            bool = Boolean.valueOf(false);
            exception = e2;
        } catch (Exception e3) {
            exception = e3;
            bool = Boolean.valueOf(false);
        }
        if (bool.booleanValue()) {
            this.f8779e.m9211a(str, str2, i);
        } else {
            this.f8779e.m9212a(str, str2, i, exception);
        }
        m9089a(str);
    }

    private void m9089a(String str) {
        this.f8785k.b(str);
        this.f8786l.b(str);
    }
}
