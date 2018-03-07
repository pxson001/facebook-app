package com.facebook.messaging.media.upload.udp;

import com.facebook.backgroundtasks.BackgroundTaskManager;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Future;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: last_import_timestamp */
public class UDPChunkManager {
    private static volatile UDPChunkManager f12166e;
    private final Map<UDPUploadSession, UDPChunkDetails> f12167a = new HashMap();
    private final BlockingByteBufferQueue f12168b;
    private final BlockingByteBufferQueue f12169c;
    private final BackgroundTaskManager f12170d;

    /* compiled from: last_import_timestamp */
    class UDPChunkDetails {
        public final UDPUploadSession f12156a;
        public final File f12157b;
        private final Set<Integer> f12158c;
        public final int f12159d;
        public final SettableFuture<String> f12160e;
        private long f12161f = 0;
        private final long f12162g;

        public UDPChunkDetails(UDPChunkUploadParams uDPChunkUploadParams) {
            this.f12156a = new UDPUploadSession(uDPChunkUploadParams.f12163a, uDPChunkUploadParams.f12164b);
            this.f12157b = uDPChunkUploadParams.f12165c;
            this.f12158c = new HashSet();
            this.f12159d = (int) (((this.f12157b.length() - 1) / 1500) + 1);
            this.f12160e = SettableFuture.f();
            this.f12162g = (300 * this.f12157b.length()) / 100;
        }

        public static void m12665a(UDPChunkDetails uDPChunkDetails, List list) {
            synchronized (uDPChunkDetails.f12156a) {
                Collection hashSet = new HashSet();
                for (UDPChunk uDPChunk : list) {
                    if (uDPChunkDetails.f12158c.remove(Integer.valueOf(uDPChunk.f12154a))) {
                        hashSet.add(uDPChunk);
                    }
                }
                list.removeAll(hashSet);
            }
        }

        public static boolean m12666a(UDPChunkDetails uDPChunkDetails) {
            boolean z;
            synchronized (uDPChunkDetails.f12156a) {
                z = uDPChunkDetails.f12161f >= uDPChunkDetails.f12162g;
            }
            return z;
        }

        public static void m12664a(UDPChunkDetails uDPChunkDetails, long j) {
            synchronized (uDPChunkDetails.f12156a) {
                uDPChunkDetails.f12161f += j;
            }
        }
    }

    /* compiled from: last_import_timestamp */
    public class UDPChunkUploadParams {
        public final int f12163a;
        public final long f12164b;
        public final File f12165c;

        public UDPChunkUploadParams(int i, long j, File file) {
            this.f12163a = i;
            this.f12164b = j;
            this.f12165c = file;
        }
    }

    public static com.facebook.messaging.media.upload.udp.UDPChunkManager m12668a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12166e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.media.upload.udp.UDPChunkManager.class;
        monitor-enter(r1);
        r0 = f12166e;	 Catch:{ all -> 0x003a }
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
        r0 = m12671b(r0);	 Catch:{ all -> 0x0035 }
        f12166e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12166e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.udp.UDPChunkManager.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.udp.UDPChunkManager");
    }

    private static UDPChunkManager m12671b(InjectorLike injectorLike) {
        return new UDPChunkManager(BlockingByteBufferQueue_UDPOutgoingPacketQueueMethodAutoProvider.a(injectorLike), UDPReceivingBackgroundTask.a(injectorLike), BlockingByteBufferQueue_UDPIncomingPacketQueueMethodAutoProvider.a(injectorLike), BackgroundTaskManager.a(injectorLike));
    }

    @Inject
    public UDPChunkManager(BlockingByteBufferQueue blockingByteBufferQueue, UDPReceivingBackgroundTask uDPReceivingBackgroundTask, BlockingByteBufferQueue blockingByteBufferQueue2, BackgroundTaskManager backgroundTaskManager) {
        this.f12168b = blockingByteBufferQueue;
        uDPReceivingBackgroundTask.d.add(this);
        this.f12169c = blockingByteBufferQueue2;
        this.f12170d = backgroundTaskManager;
    }

    public final void m12676a(UDPUploadSession uDPUploadSession, String str) {
        synchronized (this.f12167a) {
            UDPChunkDetails uDPChunkDetails = (UDPChunkDetails) this.f12167a.remove(uDPUploadSession);
        }
        if (uDPChunkDetails != null) {
            synchronized (uDPChunkDetails.f12156a) {
                uDPChunkDetails.f12160e.a(new Throwable(str));
            }
        }
    }

    private void m12673b(UDPUploadSession uDPUploadSession, String str) {
        synchronized (this.f12167a) {
            UDPChunkDetails uDPChunkDetails = (UDPChunkDetails) this.f12167a.remove(uDPUploadSession);
        }
        if (uDPChunkDetails != null) {
            synchronized (uDPChunkDetails.f12156a) {
                FutureDetour.a(uDPChunkDetails.f12160e, str, 548488188);
            }
        }
    }

    private UDPChunkDetails m12670b(UDPChunkUploadParams uDPChunkUploadParams) {
        UDPChunkDetails uDPChunkDetails;
        UDPUploadSession uDPUploadSession = new UDPUploadSession(uDPChunkUploadParams.f12163a, uDPChunkUploadParams.f12164b);
        synchronized (this.f12167a) {
            uDPChunkDetails = (UDPChunkDetails) this.f12167a.get(uDPUploadSession);
            if (uDPChunkDetails == null) {
                uDPChunkDetails = new UDPChunkDetails(uDPChunkUploadParams);
                this.f12167a.put(uDPUploadSession, uDPChunkDetails);
            }
        }
        return uDPChunkDetails;
    }

    private UDPChunkDetails m12667a(UDPUploadSession uDPUploadSession) {
        UDPChunkDetails uDPChunkDetails;
        synchronized (this.f12167a) {
            uDPChunkDetails = (UDPChunkDetails) this.f12167a.get(uDPUploadSession);
        }
        return uDPChunkDetails;
    }

    public final Future<String> m12674a(UDPChunkUploadParams uDPChunkUploadParams) {
        UDPChunkDetails b = m12670b(uDPChunkUploadParams);
        try {
            m12669a(b, m12672b(b.f12156a));
        } catch (Throwable e) {
            BLog.b(UDPChunkManager.class, "unable to create chunks from file", e);
        }
        return b.f12160e;
    }

    public final void m12675a() {
        List arrayList = new ArrayList();
        this.f12169c.a(arrayList);
        for (Entry entry : UDPMessageUtil.m12696a(arrayList).entrySet()) {
            UDPUploadSession uDPUploadSession = (UDPUploadSession) entry.getKey();
            UDPChunkDetails a = m12667a(uDPUploadSession);
            if (a != null) {
                Object obj = null;
                Object obj2 = null;
                Set<Integer> hashSet = new HashSet();
                int i = -1;
                for (UDPMessage uDPMessage : (List) entry.getValue()) {
                    switch (UDPMessageUtil.m12694a(uDPMessage)) {
                        case FINISHED:
                            hashSet.clear();
                            obj = 1;
                            obj2 = UDPMessageUtil.m12697b(uDPMessage);
                            break;
                        case HOLE:
                            i = Math.max(i, UDPMessageUtil.m12698c(uDPMessage));
                            hashSet.addAll(UDPMessageUtil.m12699d(uDPMessage));
                            break;
                    }
                    i = i;
                }
                if (obj != null) {
                    if (StringUtil.a(obj2)) {
                        m12676a(uDPUploadSession, "Unable to get a valid fbid from UDP finished message");
                    } else {
                        m12673b(uDPUploadSession, obj2);
                    }
                } else if (hashSet.isEmpty()) {
                    continue;
                } else {
                    int i2;
                    for (i2 = i + 1; i2 < a.f12159d; i2++) {
                        hashSet.add(Integer.valueOf(i2));
                    }
                    List arrayList2 = new ArrayList();
                    for (Integer intValue : hashSet) {
                        i2 = intValue.intValue();
                        if (i2 >= 0 && i2 < a.f12159d) {
                            arrayList2.add(Integer.valueOf(i2));
                        }
                    }
                    try {
                        m12669a(a, UDPMessageUtil.m12695a(a.f12157b, arrayList2, 1500, uDPUploadSession));
                    } catch (Throwable e) {
                        BLog.b(UDPChunkManager.class, "unable to create chunks from file", e);
                        return;
                    }
                }
            }
        }
    }

    private void m12669a(UDPChunkDetails uDPChunkDetails, List<UDPChunk> list) {
        if (list != null && !list.isEmpty() && uDPChunkDetails != null) {
            synchronized (uDPChunkDetails.f12156a) {
                UDPChunkDetails.m12665a(uDPChunkDetails, (List) list);
                int size = list.size();
                if (size == 0) {
                } else if (UDPChunkDetails.m12666a(uDPChunkDetails)) {
                    m12676a(uDPChunkDetails.f12156a, "Uploaded too many bytes for session: ");
                } else {
                    for (UDPChunk a : list) {
                        this.f12168b.a(a);
                    }
                    UDPChunkDetails.m12664a(uDPChunkDetails, (long) (size * 1500));
                    this.f12170d.a();
                }
            }
        }
    }

    private List<UDPChunk> m12672b(UDPUploadSession uDPUploadSession) {
        UDPChunkDetails a = m12667a(uDPUploadSession);
        if (a == null) {
            return new ArrayList();
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < a.f12159d; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        return UDPMessageUtil.m12695a(a.f12157b, arrayList, 1500, uDPUploadSession);
    }
}
