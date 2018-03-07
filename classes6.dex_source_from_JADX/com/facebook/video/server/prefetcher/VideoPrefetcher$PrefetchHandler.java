package com.facebook.video.server.prefetcher;

import android.net.Uri;
import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.PartialFileStorage.PartialFile;
import com.facebook.ui.media.cache.Range;
import com.facebook.video.server.AsyncWriter$Handler;
import com.facebook.video.server.FileResource.Reader;
import com.facebook.video.server.FileResource.SimpleReader;
import com.facebook.video.server.InterceptedReader;
import com.facebook.video.server.ReadableCacheWriter;
import com.facebook.video.server.VideoCacheKey;
import com.facebook.video.server.prefetcher.PrefetchEvents.PrefetchRangeBeginEvent;
import com.facebook.video.server.prefetcher.PrefetchEvents.PrefetchRangeEndEvent;
import com.facebook.video.server.prefetcher.PrefetchEvents.RetrieveMetadataEndEvent;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms.maps.model.internal.ITileProviderDelegate */
class VideoPrefetcher$PrefetchHandler implements AsyncWriter$Handler {
    public final Range f19591a;
    final /* synthetic */ VideoPrefetcher f19592b;
    private final SettableFuture<PartialFile<VideoCacheKey>> f19593c = SettableFuture.f();
    private final SettableFuture<Reader> f19594d = SettableFuture.f();
    public final ReadableCacheWriter f19595e;
    private final PartialFile<VideoCacheKey> f19596f;
    private final Uri f19597g;
    private final int f19598h;
    private final int f19599i;
    private final List<Range> f19600j;
    private VideoPrefetcher$CancellableOutputStream f19601k;

    public VideoPrefetcher$PrefetchHandler(VideoPrefetcher videoPrefetcher, ReadableCacheWriter readableCacheWriter, PartialFile<VideoCacheKey> partialFile, Uri uri, int i, int i2, List<Range> list, Range range) {
        this.f19592b = videoPrefetcher;
        this.f19595e = readableCacheWriter;
        this.f19596f = partialFile;
        this.f19597g = uri;
        this.f19598h = i;
        this.f19599i = i2;
        this.f19600j = list;
        this.f19591a = range;
    }

    public final void mo1419a(IOException iOException) {
        this.f19593c.a(iOException);
    }

    public final OutputStream mo1418a(FileMetadata fileMetadata) {
        try {
            this.f19592b.r.lock();
            try {
                if (VideoPrefetcher.b(this.f19592b, this.f19597g)) {
                    this.f19593c.a(new InterruptedIOException("cancelled"));
                }
                OutputStream a = this.f19595e.m28250a(fileMetadata);
                if (this.f19596f == null) {
                    this.f19592b.t.a(new RetrieveMetadataEndEvent(this.f19598h, this.f19599i, this.f19600j));
                    this.f19592b.t.a(new PrefetchRangeBeginEvent(this.f19598h, this.f19591a));
                }
                this.f19601k = new VideoPrefetcher$CancellableOutputStream(a);
                FutureDetour.a(this.f19594d, this.f19595e.m28249a(), -1367394900);
                return this.f19601k;
            } finally {
                this.f19592b.r.unlock();
            }
        } catch (Throwable e) {
            VideoPrefetcher.b();
            new Object[1][0] = Long.valueOf(Thread.currentThread().getId());
            this.f19593c.a(e);
            return null;
        }
    }

    public final void mo1420a(OutputStream outputStream, IOException iOException) {
        VideoPrefetcher$CancellableOutputStream videoPrefetcher$CancellableOutputStream = (VideoPrefetcher$CancellableOutputStream) outputStream;
        try {
            outputStream.close();
        } catch (Throwable e) {
            BLog.a(VideoPrefetcher.a, e, "Error closing prefetch writing stream", new Object[0]);
        }
        this.f19592b.t.a(new PrefetchRangeEndEvent(this.f19598h, (long) videoPrefetcher$CancellableOutputStream.m28296c(), videoPrefetcher$CancellableOutputStream.m28295b()));
        if (iOException != null) {
            this.f19593c.a(iOException);
        } else {
            FutureDetour.a(this.f19593c, this.f19595e.m28251b(), 251219514);
        }
    }

    public final InterceptedReader m28301a(boolean z) {
        try {
            SimpleReader simpleReader = (SimpleReader) FutureDetour.a(this.f19594d, 1166157389);
            this.f19593c.a(new VideoPrefetcher$InterceptedException());
            if (!z) {
                return new InterceptedReader(this.f19591a, simpleReader);
            }
            this.f19601k.m28294a();
            simpleReader.m28229b().close();
            return null;
        } catch (ExecutionException e) {
            Throwables.propagateIfPossible(e.getCause(), IOException.class);
            throw new IOException("Error waiting for result", e.getCause());
        } catch (Throwable th) {
            Throwables.propagateIfPossible(th, IOException.class);
            IOException iOException = new IOException("Error waiting for result", th);
        }
    }

    public final PartialFile<VideoCacheKey> m28300a() {
        try {
            return (PartialFile) FutureDetour.a(this.f19593c, 1780500012);
        } catch (ExecutionException e) {
            Throwables.propagateIfPossible(e.getCause(), IOException.class);
            throw new IOException("Error waiting for result", e.getCause());
        } catch (Throwable th) {
            Throwables.propagateIfPossible(th, IOException.class);
            IOException iOException = new IOException("Error waiting for result", th);
        }
    }
}
