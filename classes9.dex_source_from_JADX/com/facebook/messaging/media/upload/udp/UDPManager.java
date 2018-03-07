package com.facebook.messaging.media.upload.udp;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.tempfile.BackingFileResolver;
import com.facebook.common.util.TriState;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.OperationResultFutureCallback2;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.udp.UDPChunkManager.UDPChunkUploadParams;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.File;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;

@UserScoped
@ThreadSafe
/* compiled from: last_fetch_pinned_threads_client_time_ms */
public class UDPManager {
    private static final Object f12182l = new Object();
    private final Provider<String> f12183a;
    private final UDPUploadConnectionManager f12184b;
    private final UDPChunkManager f12185c;
    public final StunPingManager f12186d;
    private final BackgroundTaskManager f12187e;
    private final BackingFileResolver f12188f;
    private final DefaultAndroidThreadUtil f12189g;
    private final Provider<TriState> f12190h;
    private final MediaHashCache f12191i;
    private long f12192j;
    private final Cache<String, UDPUploadDetails> f12193k = CacheBuilder.newBuilder().a(600000, TimeUnit.MILLISECONDS).a(1000).a(new UDPUploadCacheRemovalListener(this)).q();

    /* compiled from: last_fetch_pinned_threads_client_time_ms */
    /* synthetic */ class C13502 {
        static final /* synthetic */ int[] f12178a = new int[RemovalCause.values().length];

        static {
            try {
                f12178a[RemovalCause.EXPIRED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12178a[RemovalCause.SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    /* compiled from: last_fetch_pinned_threads_client_time_ms */
    class UDPUploadCacheRemovalListener implements RemovalListener<String, UDPUploadDetails> {
        final /* synthetic */ UDPManager f12179a;

        public void onRemoval(RemovalNotification<String, UDPUploadDetails> removalNotification) {
            String str;
            switch (C13502.f12178a[removalNotification.c.ordinal()]) {
                case 1:
                    str = "Upload time limit exceeded. Aborting upload with operationID: " + ((String) removalNotification.getKey());
                    break;
                case 2:
                    str = "Too many concurrent UDP requests. Aborting upload with operationID: " + ((String) removalNotification.getKey());
                    break;
                default:
                    return;
            }
            UDPManager.m12690a(this.f12179a, (UDPUploadDetails) removalNotification.getValue(), str);
        }

        public UDPUploadCacheRemovalListener(UDPManager uDPManager) {
            this.f12179a = uDPManager;
        }
    }

    /* compiled from: last_fetch_pinned_threads_client_time_ms */
    class UDPUploadDetails {
        UDPUploadSession f12180a;
        public final long f12181b;

        public UDPUploadDetails(int i, long j, long j2) {
            this.f12180a = new UDPUploadSession(i, j);
            this.f12181b = j2;
        }
    }

    private static UDPManager m12691b(InjectorLike injectorLike) {
        return new UDPManager(IdBasedProvider.a(injectorLike, 4442), UDPPacketManager.m12702a(injectorLike), UDPUploadConnectionManager.m12710a(injectorLike), UDPChunkManager.m12668a(injectorLike), StunPingManager.m12653a(injectorLike), BackgroundTaskManager.a(injectorLike), BackingFileResolver.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 714), MediaHashCache.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.udp.UDPManager m12688a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12182l;	 Catch:{ all -> 0x006c }
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
        r1 = m12691b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12182l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.udp.UDPManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.udp.UDPManager) r0;	 Catch:{  }
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
        r0 = f12182l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.udp.UDPManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.UDPManager");
    }

    @Inject
    public UDPManager(Provider<String> provider, UDPPacketManager uDPPacketManager, UDPUploadConnectionManager uDPUploadConnectionManager, UDPChunkManager uDPChunkManager, StunPingManager stunPingManager, BackgroundTaskManager backgroundTaskManager, BackingFileResolver backingFileResolver, AndroidThreadUtil androidThreadUtil, Provider<TriState> provider2, MediaHashCache mediaHashCache) {
        this.f12183a = provider;
        this.f12184b = uDPUploadConnectionManager;
        this.f12185c = uDPChunkManager;
        this.f12186d = stunPingManager;
        this.f12187e = backgroundTaskManager;
        this.f12188f = backingFileResolver;
        this.f12189g = androidThreadUtil;
        this.f12190h = provider2;
        this.f12184b.m12717a(uDPPacketManager);
        this.f12191i = mediaHashCache;
        m12689a();
    }

    private void m12689a() {
        this.f12192j = System.currentTimeMillis() & 4294967295L;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m12692a(java.lang.String r7, com.facebook.ui.media.attachments.MediaResource r8) {
        /*
        r6 = this;
        r4 = 0;
        r0 = 1;
        r1 = 0;
        r2 = r6.f12190h;
        r2 = r2.get();
        r3 = com.facebook.common.util.TriState.YES;
        if (r2 != r3) goto L_0x0039;
    L_0x000e:
        monitor-enter(r6);
        r2 = r6.f12193k;	 Catch:{ all -> 0x002e }
        r2 = r2.a(r7);	 Catch:{ all -> 0x002e }
        if (r2 == 0) goto L_0x0019;
    L_0x0017:
        monitor-exit(r6);	 Catch:{ all -> 0x002e }
    L_0x0018:
        return r0;
    L_0x0019:
        monitor-exit(r6);	 Catch:{ all -> 0x002e }
        r2 = r8.p;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0031;
    L_0x0020:
        r2 = r6.f12188f;
        r3 = r8.c;
        r2 = r2.b(r3);
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0031;
    L_0x002c:
        r0 = r1;
        goto L_0x0018;
    L_0x002e:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{  }
        throw r0;
    L_0x0031:
        r2 = r8.d;
        r3 = com.facebook.ui.media.attachments.MediaResource.Type.PHOTO;
        if (r2 == r3) goto L_0x0018;
    L_0x0037:
        r0 = r1;
        goto L_0x0018;
    L_0x0039:
        r0 = r1;
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPManager.a(java.lang.String, com.facebook.ui.media.attachments.MediaResource):boolean");
    }

    public final String m12693b(String str, MediaResource mediaResource) {
        UDPUploadDetails uDPUploadDetails;
        ListenableFuture b;
        File a = this.f12188f.a(mediaResource.c);
        Preconditions.checkNotNull(a, "Unable to get file for UDP Upload");
        synchronized (this) {
            uDPUploadDetails = (UDPUploadDetails) this.f12193k.a(str);
            if (uDPUploadDetails == null || uDPUploadDetails.f12181b != a.length()) {
                long j = this.f12192j;
                this.f12192j = 1 + j;
                this.f12193k.a(str, new UDPUploadDetails((int) j, Long.parseLong((String) this.f12183a.get()), a.length()));
            }
        }
        uDPUploadDetails = (UDPUploadDetails) this.f12193k.a(str);
        String b2 = this.f12191i.b(mediaResource);
        try {
            b = this.f12184b.m12718b(mediaResource, b2, uDPUploadDetails.f12180a);
        } catch (Throwable e) {
            BLog.b(UDPManager.class, "Exception when refreshing server connection. Retrying upload without refresh", e);
            b = this.f12184b.m12716a(mediaResource, b2, uDPUploadDetails.f12180a);
        }
        Futures.a(b, new OperationResultFutureCallback2(this) {
            final /* synthetic */ UDPManager f12177b;

            protected final void m12687a(CancellationException cancellationException) {
                super.a(cancellationException);
                UDPManager.m12690a(this.f12177b, uDPUploadDetails, "Metadata upload to server was cancelled. Cancellation message: " + cancellationException.getMessage());
            }

            protected final void m12686a(Throwable th) {
                super.a(th);
                UDPManager.m12690a(this.f12177b, uDPUploadDetails, "Exception when trying to upload metadata to server. The actual problem was: " + th.getMessage());
            }

            protected final void m12684a(OperationResult operationResult) {
                super.a(operationResult);
                this.f12177b.f12186d.m12657b();
            }
        }, MoreExecutors.a());
        try {
            Future a2 = this.f12185c.m12674a(new UDPChunkUploadParams(uDPUploadDetails.f12180a.f12225b, uDPUploadDetails.f12180a.f12224a, a));
            while (!a2.isDone()) {
                synchronized (this) {
                    this.f12193k.c();
                }
                try {
                    if (b.isDone()) {
                        FutureDetour.a(b, -1509915891);
                    }
                } catch (Exception e2) {
                }
                if (this.f12186d.m12656a()) {
                    this.f12187e.a();
                }
                try {
                    this.f12189g.a(550);
                } catch (InterruptedException e3) {
                }
            }
            String str2 = (String) FutureDetour.a(a2, 960572481);
            this.f12193k.b(str);
            return str2;
        } catch (Throwable e4) {
            BLog.b(UDPManager.class, "Exception when trying to upload file through UDP.", e4);
            throw e4;
        }
    }

    public static void m12690a(UDPManager uDPManager, UDPUploadDetails uDPUploadDetails, String str) {
        if (uDPUploadDetails != null) {
            uDPManager.f12185c.m12676a(uDPUploadDetails.f12180a, str);
        }
    }
}
