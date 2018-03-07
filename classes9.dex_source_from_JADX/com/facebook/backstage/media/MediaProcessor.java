package com.facebook.backstage.media;

import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.consumption.Disk;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.media.Decoding.PhotoSpec;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: request_payload */
public class MediaProcessor {
    public static final String f5387a = MediaProcessor.class.getSimpleName();
    private static volatile MediaProcessor f5388d;
    private final ExecutorService f5389b;
    public final TempFileManager f5390c;

    public static com.facebook.backstage.media.MediaProcessor m5621a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5388d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.backstage.media.MediaProcessor.class;
        monitor-enter(r1);
        r0 = f5388d;	 Catch:{ all -> 0x003a }
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
        r0 = m5622b(r0);	 Catch:{ all -> 0x0035 }
        f5388d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5388d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.backstage.media.MediaProcessor.a(com.facebook.inject.InjectorLike):com.facebook.backstage.media.MediaProcessor");
    }

    private static MediaProcessor m5622b(InjectorLike injectorLike) {
        return new MediaProcessor((ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), TempFileManager.a(injectorLike));
    }

    @Inject
    public MediaProcessor(ExecutorService executorService, TempFileManager tempFileManager) {
        this.f5389b = executorService;
        this.f5390c = tempFileManager;
    }

    public final ListenableFuture<Void> m5623a(final LocalShot localShot) {
        final SettableFuture f = SettableFuture.f();
        ExecutorDetour.a(this.f5389b, new Runnable(this) {
            final /* synthetic */ MediaProcessor f5386c;

            public void run() {
                try {
                    if (localShot.m4911i()) {
                        PhotoSpec photoSpec = StacksConstants.f4252b;
                        if (!(localShot.m4907d().getHeight() == 1 && localShot.m4907d().getWidth() == 1)) {
                            localShot.m4905a(Decoding.m5617a(localShot.m4907d(), localShot.m4909g(), localShot.m4910h(), photoSpec, localShot.m4904a(), localShot.m4912k()));
                        }
                        File file = (File) Preconditions.checkNotNull(this.f5386c.f5390c.a("BackstageTemp", ".jpg", Privacy.REQUIRE_PRIVATE));
                        Disk.m4528a(Decoding.m5619a(localShot.m4907d(), 100), file);
                        localShot.m4906a(file.getAbsolutePath());
                        localShot.m4905a(null);
                        FutureDetour.a(f, null, 1398327432);
                        return;
                    }
                    Preconditions.checkNotNull(localShot.m4908e());
                    localShot.m4906a(localShot.m4908e());
                    FutureDetour.a(f, null, 1446635762);
                } catch (Throwable e) {
                    BLog.b(MediaProcessor.f5387a, "Exception trying to process the media", e);
                    f.a(e);
                }
            }
        }, 1406069751);
        return f;
    }
}
