package com.facebook.messaging.media.retry;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForNonUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.content.ActionReceiver;
import com.facebook.content.BroadcastReceiverLike;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.connectivity.ConnectionStatusMonitor;
import com.facebook.messaging.connectivity.ConnectionStatusMonitorMethodAutoProvider;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

@UserScoped
/* compiled from: saved_items */
public class MediaRetryQueue implements ActionReceiver {
    public static final CallerContext f3211j = CallerContext.a(MediaRetryQueue.class, "media_retry", "image_retry");
    private static final Object f3212l = new Object();
    @Inject
    public DefaultAndroidThreadUtil f3213a;
    @Inject
    public ConnectionStatusMonitor f3214b;
    @Inject
    ConnectivityManager f3215c;
    @ForNonUiThread
    @Inject
    public ExecutorService f3216d;
    @Inject
    AbstractFbErrorReporter f3217e;
    @Inject
    ImagePipeline f3218f;
    @Inject
    public MediaRetryNetworkReceiver f3219g;
    @Inject
    MonotonicClock f3220h;
    @Inject
    QeAccessor f3221i;
    public final ConcurrentHashMap<Uri, MediaRetryItem> f3222k = new ConcurrentHashMap();

    /* compiled from: saved_items */
    public class C05191 implements Runnable {
        final /* synthetic */ Uri f3208a;
        final /* synthetic */ MediaRetryQueue f3209b;

        /* compiled from: saved_items */
        class C05181 extends BaseDataSubscriber {
            final /* synthetic */ C05191 f3207a;

            C05181(C05191 c05191) {
                this.f3207a = c05191;
            }

            protected final void m3142e(DataSource dataSource) {
                if (dataSource.b()) {
                    this.f3207a.f3209b.f3222k.remove(this.f3207a.f3208a);
                }
            }

            protected final void m3143f(DataSource dataSource) {
                MediaRetryItem mediaRetryItem = (MediaRetryItem) this.f3207a.f3209b.f3222k.get(this.f3207a.f3208a);
                if (mediaRetryItem != null) {
                    mediaRetryItem.m3138a();
                }
                if (!mediaRetryItem.m3140c()) {
                    this.f3207a.f3209b.f3222k.remove(this.f3207a.f3208a);
                }
            }
        }

        public C05191(MediaRetryQueue mediaRetryQueue, Uri uri) {
            this.f3209b = mediaRetryQueue;
            this.f3208a = uri;
        }

        public void run() {
            this.f3209b.f3218f.f(ImageRequest.a(this.f3208a), MediaRetryQueue.f3211j).a(new C05181(this), this.f3209b.f3216d);
        }
    }

    /* compiled from: saved_items */
    class C05202 implements Runnable {
        final /* synthetic */ MediaRetryQueue f3210a;

        C05202(MediaRetryQueue mediaRetryQueue) {
            this.f3210a = mediaRetryQueue;
        }

        public void run() {
            MediaRetryQueue mediaRetryQueue = this.f3210a;
            if (mediaRetryQueue.m3148b()) {
                mediaRetryQueue.f3213a.b();
                MediaRetryNetworkReceiver mediaRetryNetworkReceiver = mediaRetryQueue.f3219g;
                if (mediaRetryNetworkReceiver.f3206b != null) {
                    mediaRetryNetworkReceiver.f3206b.c();
                    mediaRetryNetworkReceiver.f3206b = null;
                }
                for (Uri uri : mediaRetryQueue.f3222k.keySet()) {
                    if (!mediaRetryQueue.f3214b.b()) {
                        mediaRetryQueue.f3219g.m3141a(mediaRetryQueue);
                        return;
                    } else if (FacebookUriUtil.k(uri) || ((MediaRetryItem) mediaRetryQueue.f3222k.get(uri)).m3139b()) {
                        mediaRetryQueue.f3222k.remove(uri);
                    } else {
                        ExecutorDetour.a(mediaRetryQueue.f3216d, new C05191(mediaRetryQueue, uri), -1812618245);
                    }
                }
            }
        }
    }

    private static MediaRetryQueue m3146b(InjectorLike injectorLike) {
        MediaRetryQueue mediaRetryQueue = new MediaRetryQueue();
        DefaultAndroidThreadUtil b = DefaultAndroidThreadUtil.b(injectorLike);
        ConnectionStatusMonitor a = ConnectionStatusMonitorMethodAutoProvider.a(injectorLike);
        ConnectivityManager b2 = ConnectivityManagerMethodAutoProvider.b(injectorLike);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike);
        AbstractFbErrorReporter abstractFbErrorReporter = (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike);
        ImagePipeline a2 = ImagePipelineMethodAutoProvider.a(injectorLike);
        MediaRetryNetworkReceiver mediaRetryNetworkReceiver = new MediaRetryNetworkReceiver();
        mediaRetryNetworkReceiver.f3205a = (BaseFbBroadcastManager) LocalFbBroadcastManager.a(injectorLike);
        mediaRetryQueue.m3145a(b, a, b2, executorService, abstractFbErrorReporter, a2, mediaRetryNetworkReceiver, (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
        return mediaRetryQueue;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.retry.MediaRetryQueue m3144a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f3212l;	 Catch:{ all -> 0x006c }
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
        r1 = m3146b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f3212l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.retry.MediaRetryQueue) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.retry.MediaRetryQueue) r0;	 Catch:{  }
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
        r0 = f3212l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.retry.MediaRetryQueue) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.retry.MediaRetryQueue.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.retry.MediaRetryQueue");
    }

    public final void m3147a(ImageRequest imageRequest) {
        this.f3213a.b();
        if (this.f3221i.a(Liveness.Cached, ExperimentsForMediaRetryModule.f3197b, false)) {
            int a = this.f3221i.a(Liveness.Cached, ExperimentsForMediaRetryModule.f3198c, 1);
            long a2 = ((long) this.f3221i.a(Liveness.Cached, ExperimentsForMediaRetryModule.f3199d, 1)) * 86400000;
            Uri uri = imageRequest.c;
            this.f3222k.putIfAbsent(uri, new MediaRetryItem(uri, a2 + this.f3220h.now(), a, this.f3220h));
            this.f3219g.m3141a(this);
        }
    }

    public final boolean m3148b() {
        return this.f3221i.a(Liveness.Cached, ExperimentsForMediaRetryModule.f3197b, false);
    }

    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, -1910324462);
        if (this.f3222k.isEmpty()) {
            this.f3217e.a("media_retry", "Media retry network receiver is wake up with empty queue..");
            Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 379122406, a);
            return;
        }
        NetworkInfo activeNetworkInfo = this.f3215c.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.isAvailable()) {
            ExecutorDetour.a(this.f3216d, new C05202(this), -619930752);
        }
        LogUtils.e(-2139965605, a);
    }

    private void m3145a(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ConnectionStatusMonitor connectionStatusMonitor, ConnectivityManager connectivityManager, ExecutorService executorService, AbstractFbErrorReporter abstractFbErrorReporter, ImagePipeline imagePipeline, MediaRetryNetworkReceiver mediaRetryNetworkReceiver, MonotonicClock monotonicClock, QeAccessor qeAccessor) {
        this.f3213a = defaultAndroidThreadUtil;
        this.f3214b = connectionStatusMonitor;
        this.f3215c = connectivityManager;
        this.f3216d = executorService;
        this.f3217e = abstractFbErrorReporter;
        this.f3218f = imagePipeline;
        this.f3219g = mediaRetryNetworkReceiver;
        this.f3220h = monotonicClock;
        this.f3221i = qeAccessor;
    }
}
