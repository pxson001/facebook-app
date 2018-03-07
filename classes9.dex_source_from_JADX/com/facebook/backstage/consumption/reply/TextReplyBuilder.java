package com.facebook.backstage.consumption.reply;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.data.LocalShot.MediaType;
import com.facebook.backstage.media.MediaProcessor;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.module.PlatformBitmapFactoryMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: retval */
public class TextReplyBuilder {
    private static volatile TextReplyBuilder f4978d;
    private final MediaProcessor f4979a;
    private final ExecutorService f4980b;
    private final PlatformBitmapFactory f4981c;

    public static com.facebook.backstage.consumption.reply.TextReplyBuilder m4812a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4978d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.consumption.reply.TextReplyBuilder.class;
        monitor-enter(r1);
        r0 = f4978d;	 Catch:{ all -> 0x003a }
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
        r0 = m4814b(r0);	 Catch:{ all -> 0x0035 }
        f4978d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4978d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.consumption.reply.TextReplyBuilder.a(com.facebook.inject.InjectorLike):com.facebook.backstage.consumption.reply.TextReplyBuilder");
    }

    private static TextReplyBuilder m4814b(InjectorLike injectorLike) {
        return new TextReplyBuilder(MediaProcessor.m5621a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), PlatformBitmapFactoryMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public TextReplyBuilder(MediaProcessor mediaProcessor, ExecutorService executorService, PlatformBitmapFactory platformBitmapFactory) {
        this.f4979a = mediaProcessor;
        this.f4980b = executorService;
        this.f4981c = platformBitmapFactory;
    }

    public final ListenableFuture<LocalShot> m4815a(String str, int i) {
        final CloseableReference a = m4813a(i);
        final LocalShot localShot = new LocalShot(MediaType.PHOTO, (Bitmap) a.a(), null, 0, 0, false, 1.0f);
        localShot.f5132h = str;
        final SettableFuture f = SettableFuture.f();
        Futures.a(this.f4979a.m5623a(localShot), new FutureCallback(this) {
            final /* synthetic */ TextReplyBuilder f4977d;

            public void onSuccess(@Nullable Object obj) {
                FutureDetour.a(f, localShot, -1076389698);
                a.close();
            }

            public void onFailure(Throwable th) {
                f.a(th);
                a.close();
            }
        }, this.f4980b);
        return f;
    }

    private CloseableReference<Bitmap> m4813a(int i) {
        CloseableReference closeableReference = null;
        try {
            closeableReference = this.f4981c.a(1, 1, Config.RGB_565);
            new Canvas((Bitmap) closeableReference.a()).drawColor(i);
            CloseableReference<Bitmap> b = CloseableReference.b(closeableReference);
            return b;
        } finally {
            if (closeableReference != null) {
                closeableReference.close();
            }
        }
    }
}
