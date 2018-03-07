package com.facebook.videocodec.trimmer;

import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ThreadInitDetour;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: android.provider.Telephony.SMS_DELIVER */
public class VideoTrimmer {
    private static volatile VideoTrimmer f20436c;
    public final Provider<VideoTrimOperation> f20437a;
    public final BackgroundWorkLogger f20438b;

    public static com.facebook.videocodec.trimmer.VideoTrimmer m20001a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f20436c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.videocodec.trimmer.VideoTrimmer.class;
        monitor-enter(r1);
        r0 = f20436c;	 Catch:{ all -> 0x003a }
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
        r0 = m20002b(r0);	 Catch:{ all -> 0x0035 }
        f20436c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20436c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.trimmer.VideoTrimmer.a(com.facebook.inject.InjectorLike):com.facebook.videocodec.trimmer.VideoTrimmer");
    }

    private static VideoTrimmer m20002b(InjectorLike injectorLike) {
        return new VideoTrimmer(IdBasedProvider.a(injectorLike, 11739), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(injectorLike));
    }

    @Inject
    public VideoTrimmer(Provider<VideoTrimOperation> provider, BackgroundWorkLogger backgroundWorkLogger) {
        this.f20437a = provider;
        this.f20438b = backgroundWorkLogger;
    }

    public final ListenableFuture<Void> m20003a(final VideoTrimmerParams videoTrimmerParams) {
        final SettableFuture f = SettableFuture.f();
        ThreadInitDetour.a(new Runnable(this) {
            final /* synthetic */ VideoTrimmer f20435c;

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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r4 = 0;
                r0 = r5.f20435c;
                r0 = r0.f20438b;
                r1 = "VideoTrimmer";
                r2 = "start";
                r1 = r0.a(r1, r2);
                if (r1 == 0) goto L_0x0012;
            L_0x000f:
                r1.a();
            L_0x0012:
                r0 = r5.f20435c;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r0 = r0.f20437a;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r0 = r0.get();	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r0 = (com.facebook.videocodec.trimmer.VideoTrimOperation) r0;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r2 = r5;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r0.m20000a(r2);	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r0 = r0;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r2 = 0;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r3 = 1414631050; // 0x54518e8a float:3.60015829E12 double:6.989206033E-315;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                com.facebook.tools.dextr.runtime.detour.FutureDetour.a(r0, r2, r3);	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                if (r1 == 0) goto L_0x0030;
            L_0x002c:
                r0 = 1;
                r1.a(r0);
            L_0x0030:
                return;
            L_0x0031:
                r0 = move-exception;
                r2 = r0;	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                r2.a(r0);	 Catch:{ Throwable -> 0x0031, all -> 0x003d }
                if (r1 == 0) goto L_0x0030;
            L_0x0039:
                r1.a(r4);
                goto L_0x0030;
            L_0x003d:
                r0 = move-exception;
                if (r1 == 0) goto L_0x0043;
            L_0x0040:
                r1.a(r4);
            L_0x0043:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.videocodec.trimmer.VideoTrimmer.1.run():void");
            }
        }, "Video Trimmer", -917091729).start();
        return f;
    }
}
