package com.facebook.video.server.prefetcher;

import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.exoplayer.ipc.VideoPrefetchRequest;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.ui.media.cache.PartialFileStorage$PartialFile;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.exoserviceclient.ExoServiceClient.PrefetchOrigin;
import com.facebook.video.server.AsyncWriter;
import com.facebook.video.server.FileResource.SimpleReader;
import com.facebook.video.server.InterceptedReader;
import com.facebook.video.server.NetworkAsyncWriter;
import com.facebook.video.server.ReadableCacheWriter;
import com.facebook.video.server.VideoCacheKey;
import com.facebook.video.server.prefetcher.VideoPrefetcher.InterceptedException;
import com.facebook.video.server.prefetcher.VideoPrefetcher.PrefetchHandler;
import java.util.List;

/* compiled from: SubtitlesLocalesKey */
class VideoPrefetcher$PrefetchItemTask {
    public final int f380a;
    public final Uri f381b;
    public final VideoPrefetchItem f382c;
    final /* synthetic */ VideoPrefetcher f383d;
    private boolean f384e;
    private PrefetchHandler f385f;
    private NetworkAsyncWriter f386g;

    private boolean m343a(int r16, android.net.Uri r17, int r18) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x0081 in {7, 16, 19, 23, 25, 27, 33, 34, 35, 36, 39} preds:[]
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
        r15 = this;
        r2 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = r2.m;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r0 = r17;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r12 = r2.a(r0);	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = new com.facebook.video.server.NetworkAsyncWriter;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r4 = r3.o;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r5 = 0;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r6 = com.facebook.http.interfaces.RequestPriority.CAN_WAIT;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r7 = "rangeRequestForVideo";	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r8 = r3.g;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r9 = r3.w;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r10 = r3.x;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r11 = r3.q;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r17;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11);	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r15.f386g = r2;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r8 = new com.facebook.video.server.prefetcher.VideoPrefetcher$CountingAsyncWriter;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = r15.f386g;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r3 = r3.u;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r8.<init>(r2, r3);	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = r15.f383d;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = r2.r;	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2.lock();	 Catch:{ InterceptedException -> 0x0089, InterruptedIOException -> 0x00e7, IOException -> 0x00f8 }
        r2 = r15.f383d;	 Catch:{ all -> 0x0080 }
        r2 = r2.d;	 Catch:{ all -> 0x0080 }
        r7 = r2.b(r12);	 Catch:{ all -> 0x0080 }
        r2 = r15.f383d;
        r2 = r2.r;
        r2.unlock();
        r2 = new com.facebook.ui.media.cache.Range;	 Catch:{  }
        r4 = 0;	 Catch:{  }
        r0 = r18;	 Catch:{  }
        r10 = (long) r0;	 Catch:{  }
        r2.<init>(r4, r10);	 Catch:{  }
        if (r7 != 0) goto L_0x009a;	 Catch:{  }
    L_0x0059:
        r10 = com.google.common.collect.ImmutableList.of(r2);	 Catch:{  }
    L_0x005d:
        r2 = r10.isEmpty();	 Catch:{  }
        if (r2 != 0) goto L_0x00c3;
    L_0x0063:
        r11 = r10.iterator();	 Catch:{ all -> 0x00c5 }
    L_0x0067:
        r2 = r11.hasNext();	 Catch:{ all -> 0x00c5 }
        if (r2 == 0) goto L_0x00a3;	 Catch:{ all -> 0x00c5 }
    L_0x006d:
        r5 = r11.next();	 Catch:{ all -> 0x00c5 }
        r5 = (com.facebook.ui.media.cache.Range) r5;	 Catch:{ all -> 0x00c5 }
        r2 = r15;	 Catch:{ all -> 0x00c5 }
        r3 = r16;	 Catch:{ all -> 0x00c5 }
        r4 = r17;	 Catch:{ all -> 0x00c5 }
        r6 = r12;	 Catch:{ all -> 0x00c5 }
        r9 = r18;	 Catch:{ all -> 0x00c5 }
        r7 = r2.m342a(r3, r4, r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x00c5 }
        goto L_0x0067;
    L_0x0080:
        r2 = move-exception;
        r3 = r15.f383d;	 Catch:{ all -> 0x0080 }
        r3 = r3.r;	 Catch:{ all -> 0x0080 }
        r3.unlock();	 Catch:{ all -> 0x0080 }
        throw r2;	 Catch:{ all -> 0x0080 }
    L_0x0089:
        r2 = move-exception;
        com.facebook.video.server.prefetcher.VideoPrefetcher.b();
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        java.lang.Long.valueOf(r2);
        r2 = 1;
    L_0x0099:
        return r2;
    L_0x009a:
        r3 = r7.mo14f();	 Catch:{ all -> 0x00c5 }
        r10 = r2.m387a(r3);	 Catch:{ all -> 0x00c5 }
        goto L_0x005d;	 Catch:{ all -> 0x00c5 }
    L_0x00a3:
        r2 = r15.f383d;
        r2 = r2.n;
        r6 = r2.get();
        r6 = (com.facebook.video.analytics.VideoPerformanceTracking) r6;
        r0 = r18;
        r2 = (long) r0;
        r11 = r8.m362a();
        r4 = r15.f382c;
        r4 = r4.m341a();
        r13 = r4.f355a;
        r14 = 0;
        r7 = r17;
        r8 = r2;
        r6.a(r7, r8, r10, r11, r13, r14);
    L_0x00c3:
        r2 = 1;	 Catch:{ all -> 0x00c5 }
        goto L_0x0099;	 Catch:{ all -> 0x00c5 }
    L_0x00c5:
        r2 = move-exception;	 Catch:{ all -> 0x00c5 }
        r3 = r15.f383d;	 Catch:{ all -> 0x00c5 }
        r3 = r3.n;	 Catch:{ all -> 0x00c5 }
        r6 = r3.get();	 Catch:{ all -> 0x00c5 }
        r6 = (com.facebook.video.analytics.VideoPerformanceTracking) r6;	 Catch:{ all -> 0x00c5 }
        r0 = r18;	 Catch:{ all -> 0x00c5 }
        r4 = (long) r0;	 Catch:{ all -> 0x00c5 }
        r11 = r8.m362a();	 Catch:{ all -> 0x00c5 }
        r3 = r15.f382c;	 Catch:{ all -> 0x00c5 }
        r3 = r3.m341a();	 Catch:{ all -> 0x00c5 }
        r13 = r3.f355a;	 Catch:{ all -> 0x00c5 }
        r14 = 0;	 Catch:{ all -> 0x00c5 }
        r7 = r17;	 Catch:{ all -> 0x00c5 }
        r8 = r4;	 Catch:{ all -> 0x00c5 }
        r6.a(r7, r8, r10, r11, r13, r14);	 Catch:{ all -> 0x00c5 }
        throw r2;	 Catch:{ all -> 0x00c5 }
    L_0x00e7:
        r2 = move-exception;
        com.facebook.video.server.prefetcher.VideoPrefetcher.b();
        r2 = java.lang.Thread.currentThread();
        r2 = r2.getId();
        java.lang.Long.valueOf(r2);
        r2 = 0;
        goto L_0x0099;
    L_0x00f8:
        r2 = move-exception;
        com.facebook.video.server.prefetcher.VideoPrefetcher.b();
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Thread.currentThread();
        r6 = r5.getId();
        r5 = java.lang.Long.valueOf(r6);
        r3[r4] = r5;
        r3 = r15.f383d;
        r3 = r3.g;
        r4 = com.facebook.video.server.prefetcher.VideoPrefetcher.a;
        r5 = "Error while prefetching video";
        r3.a(r4, r5, r2);
        r2 = 1;
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.server.prefetcher.VideoPrefetcher$PrefetchItemTask.a(int, android.net.Uri, int):boolean");
    }

    private boolean m344a(int i, VideoPrefetchItem videoPrefetchItem) {
        Uri uri = videoPrefetchItem.f378b.f356c;
        long id = Thread.currentThread().getId();
        int a = VideoPrefetcher.a(this.f383d, videoPrefetchItem);
        String str = VideoPrefetcher.a;
        Long.valueOf(id);
        Integer.valueOf(a);
        if (a > 0) {
            return this.f383d.y.j ? this.f383d.y.b(new VideoPrefetchRequest(uri, videoPrefetchItem.f378b.f355a, videoPrefetchItem.f378b.f362i, a, PrefetchOrigin.FEED.toString())) : m343a(i, uri, a);
        } else {
            str = VideoPrefetcher.a;
            Long.valueOf(id);
            return true;
        }
    }

    public VideoPrefetcher$PrefetchItemTask(VideoPrefetcher videoPrefetcher, int i, VideoPrefetchItem videoPrefetchItem) {
        this.f383d = videoPrefetcher;
        this.f380a = i;
        this.f381b = videoPrefetchItem.f378b.f356c;
        this.f382c = videoPrefetchItem;
    }

    public final boolean m346a() {
        if (!VideoPrefetcher.a(this.f383d, this)) {
            return true;
        }
        try {
            this.f383d.t.a(new PrefetchEvents$PrefetchItemBeginEvent(this.f380a, this.f381b));
            boolean a = m344a(this.f380a, this.f382c);
            this.f383d.t.a(new PrefetchEvents$PrefetchItemEndEvent(this.f380a));
            return a;
        } finally {
            VideoPrefetcher.b(this.f383d, this);
        }
    }

    public final synchronized InterceptedReader m345a(boolean z) {
        InterceptedReader a;
        this.f384e = true;
        if (this.f385f != null) {
            if (this.f386g != null) {
                this.f386g.m360a(RequestPriority.NON_INTERACTIVE);
            }
            a = this.f385f.a(z);
        } else {
            a = null;
        }
        return a;
    }

    private PartialFileStorage$PartialFile m342a(int i, Uri uri, Range range, VideoCacheKey videoCacheKey, PartialFileStorage$PartialFile partialFileStorage$PartialFile, AsyncWriter asyncWriter, int i2, List<Range> list) {
        synchronized (this) {
            if (this.f384e) {
                throw new InterceptedException();
            }
            if (partialFileStorage$PartialFile == null) {
                this.f383d.t.a(new PrefetchEvents$RetrieveMetadataBeginEvent(i));
            } else {
                this.f383d.t.a(new PrefetchEvents$PrefetchRangeBeginEvent(i, range));
            }
            this.f385f = new PrefetchHandler(this.f383d, new ReadableCacheWriter(this.f383d.d, videoCacheKey, partialFileStorage$PartialFile, range.f419a, this.f383d.p), partialFileStorage$PartialFile, uri, i, i2, list, range);
        }
        try {
            asyncWriter.mo7a(range.f419a, range.f420b, this.f385f);
            PartialFileStorage$PartialFile a = this.f385f.a();
            synchronized (this) {
                if (!this.f384e) {
                    VideoPrefetcher.b();
                    try {
                        SimpleReader a2 = this.f385f.e.a();
                        if (a2 != null) {
                            a2.b().close();
                        }
                    } catch (Throwable e) {
                        BLog.a(VideoPrefetcher.a, e, "Error closing readableWriter", new Object[0]);
                    }
                }
                this.f385f = null;
            }
            return a;
        } catch (Throwable th) {
            synchronized (this) {
                if (!this.f384e) {
                    VideoPrefetcher.b();
                    try {
                        SimpleReader a3 = this.f385f.e.a();
                        if (a3 != null) {
                            a3.b().close();
                        }
                    } catch (Throwable e2) {
                        BLog.a(VideoPrefetcher.a, e2, "Error closing readableWriter", new Object[0]);
                    }
                }
                this.f385f = null;
            }
        }
    }
}
