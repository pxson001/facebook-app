package com.facebook.stethointernal.chrome.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

/* compiled from: android_package */
public class GunzippingOutputStream extends FilterOutputStream {
    public static final ExecutorService f20411b = Executors.newCachedThreadPool();
    private final Future<Void> f20412a;

    /* compiled from: android_package */
    public class GunzippingCallable implements Callable<Void> {
        private final InputStream f20409a;
        private final OutputStream f20410b;

        public GunzippingCallable(InputStream inputStream, OutputStream outputStream) {
            this.f20409a = inputStream;
            this.f20410b = outputStream;
        }

        public Object call() {
            InputStream gZIPInputStream = new GZIPInputStream(this.f20409a);
            try {
                Util.a(gZIPInputStream, this.f20410b, new byte[1024]);
                return null;
            } finally {
                gZIPInputStream.close();
                this.f20410b.close();
            }
        }
    }

    public GunzippingOutputStream(OutputStream outputStream, Future<Void> future) {
        super(outputStream);
        this.f20412a = future;
    }

    public void close() {
        try {
            super.close();
        } finally {
            try {
                m19971a(this.f20412a);
            } catch (IOException e) {
            }
        }
    }

    private static <T> T m19971a(Future<T> future) {
        while (true) {
            try {
                return FutureDetour.a(future, -570507899);
            } catch (InterruptedException e) {
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                ExceptionUtil.a(cause, IOException.class);
                ExceptionUtil.a(cause);
            }
        }
    }
}
