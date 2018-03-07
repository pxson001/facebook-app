package com.facebook.videocodec.resizer;

import android.annotation.TargetApi;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@TargetApi(16)
/* compiled from: restrictedToPlaces */
public class VideoResizer {
    private static volatile VideoResizer f5667c;
    public final Provider<VideoResizeOperation> f5668a;
    public final BackgroundWorkLogger f5669b;

    /* compiled from: restrictedToPlaces */
    public class ResizeInterruptableFuture extends AbstractFuture<VideoResizeResult> {
        final /* synthetic */ VideoResizer f5665a;
        public Thread f5666b;

        public ResizeInterruptableFuture(VideoResizer videoResizer) {
            this.f5665a = videoResizer;
        }

        public final boolean m8278a(@Nullable VideoResizeResult videoResizeResult) {
            return super.a(videoResizeResult);
        }

        public final void m8277a(Thread thread) {
            this.f5666b = thread;
        }

        protected final void m8276a() {
            if (this.f5666b != null) {
                this.f5666b.interrupt();
            }
        }
    }

    public static com.facebook.videocodec.resizer.VideoResizer m8280a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5667c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.resizer.VideoResizer.class;
        monitor-enter(r1);
        r0 = f5667c;	 Catch:{ all -> 0x003a }
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
        r0 = m8281b(r0);	 Catch:{ all -> 0x0035 }
        f5667c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5667c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.resizer.VideoResizer.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.resizer.VideoResizer");
    }

    private static VideoResizer m8281b(InjectorLike injectorLike) {
        return new VideoResizer(IdBasedProvider.a(injectorLike, 11734), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(injectorLike));
    }

    @Inject
    public VideoResizer(Provider<VideoResizeOperation> provider, BackgroundWorkLogger backgroundWorkLogger) {
        this.f5668a = provider;
        this.f5669b = backgroundWorkLogger;
    }

    public final ListenableFuture<VideoResizeResult> m8282a(final VideoResizerParams videoResizerParams) {
        final ResizeInterruptableFuture resizeInterruptableFuture = new ResizeInterruptableFuture(this);
        Thread a = ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ VideoResizer f5664c;

            public void run() {
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r4 = this;
                r3 = 0;
                r0 = r4.f5664c;
                r0 = r0.f5669b;
                r1 = "VideoResizer";
                r2 = "start";
                r1 = r0.a(r1, r2);
                if (r1 == 0) goto L_0x0012;
            L_0x000f:
                r1.a();
            L_0x0012:
                r0 = r4.f5664c;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0 = r0.f5668a;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0 = r0.get();	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0 = (com.facebook.videocodec.resizer.VideoResizeOperation) r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r2 = r5;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0 = r0.m8274a(r2);	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r2 = r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r2.m8278a(r0);	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0 = r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r2 = 0;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r0.m8277a(r2);	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                if (r1 == 0) goto L_0x0033;
            L_0x002f:
                r0 = 1;
                r1.a(r0);
            L_0x0033:
                return;
            L_0x0034:
                r0 = move-exception;
                r2 = r0;	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                r2.a(r0);	 Catch:{ Throwable -> 0x0034, all -> 0x0040 }
                if (r1 == 0) goto L_0x0033;
            L_0x003c:
                r1.a(r3);
                goto L_0x0033;
            L_0x0040:
                r0 = move-exception;
                if (r1 == 0) goto L_0x0046;
            L_0x0043:
                r1.a(r3);
            L_0x0046:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.resizer.VideoResizer.1.run():void");
            }
        }, "Video Resizer", 71417025);
        resizeInterruptableFuture.f5666b = a;
        a.start();
        return resizeInterruptableFuture;
    }
}
