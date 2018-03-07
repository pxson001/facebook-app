package com.facebook.video.server;

import com.facebook.debug.log.BLog;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.ui.media.cache.FileMetadata;
import com.facebook.ui.media.cache.Range;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.io.CountingOutputStream;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* compiled from: commerce_store */
public class AsyncWriterRangeWriter implements RangeWriter {
    public static final String f19447a = AsyncWriterRangeWriter.class.getName();
    public final long f19448b;
    private final long f19449c;
    private final AsyncWriter f19450d;
    public MyHandler f19451e;

    /* compiled from: commerce_store */
    public class MyHandler implements AsyncWriter$Handler {
        public final SettableFuture<FileMetadata> f19444a = SettableFuture.f();
        private final SettableFuture<OutputStream> f19445b = SettableFuture.f();
        private final SettableFuture<Boolean> f19446c = SettableFuture.f();

        public final void m28208a(OutputStream outputStream) {
            Preconditions.checkNotNull(outputStream);
            FutureDetour.a(this.f19445b, outputStream, 563698360);
        }

        public final boolean m28210b() {
            return ((Boolean) AsyncWriterRangeWriter.m28211b(this.f19446c)).booleanValue();
        }

        public final void mo1419a(IOException iOException) {
            this.f19444a.a(iOException);
            this.f19446c.a(iOException);
        }

        public final OutputStream mo1418a(FileMetadata fileMetadata) {
            FutureDetour.a(this.f19444a, fileMetadata, 959388070);
            try {
                return (OutputStream) Uninterruptibles.a(this.f19445b, 200, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                BLog.a(AsyncWriterRangeWriter.f19447a, e, "This should not happen! Exception is never set on this future", new Object[0]);
                FutureDetour.a(this.f19446c, Boolean.valueOf(false), 1396484766);
                return null;
            } catch (Throwable e2) {
                BLog.a(AsyncWriterRangeWriter.f19447a, e2, "writeTo was not called on time after getMetadata!", new Object[0]);
                FutureDetour.a(this.f19446c, Boolean.valueOf(false), -1759848825);
                return null;
            }
        }

        public final void mo1420a(OutputStream outputStream, IOException iOException) {
            if (iOException != null) {
                this.f19446c.a(iOException);
            } else {
                FutureDetour.a(this.f19446c, Boolean.valueOf(true), 855607403);
            }
        }
    }

    public AsyncWriterRangeWriter(long j, long j2, AsyncWriter asyncWriter) {
        this.f19448b = j;
        this.f19449c = j2;
        this.f19450d = asyncWriter;
    }

    public final FileMetadata m28213a() {
        if (this.f19451e == null) {
            this.f19451e = new MyHandler();
            this.f19450d.a(this.f19448b, this.f19449c, this.f19451e);
        }
        return (FileMetadata) m28211b(this.f19451e.f19444a);
    }

    public final long m28212a(Range range, OutputStream outputStream) {
        Object obj;
        OutputStream countingOutputStream = new CountingOutputStream(outputStream);
        if (this.f19451e == null || this.f19448b != range.a) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            MyHandler myHandler = this.f19451e;
            this.f19451e = null;
            myHandler.m28208a(countingOutputStream);
            if (myHandler.m28210b()) {
                return countingOutputStream.a;
            }
        }
        Object myHandler2 = new MyHandler();
        myHandler2.m28208a(countingOutputStream);
        this.f19450d.a(range.a, range.b, myHandler2);
        myHandler2.m28210b();
        return countingOutputStream.a;
    }

    public static <T> T m28211b(Future<T> future) {
        try {
            return Uninterruptibles.a(future);
        } catch (ExecutionException e) {
            Throwables.propagateIfPossible(e.getCause(), IOException.class);
            throw new IOException("Unknown error getting result", e.getCause());
        }
    }
}
