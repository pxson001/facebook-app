package com.facebook.video.subtitles.controller;

import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.inject.InjectorLike;
import com.facebook.video.subtitles.controller.compat.CustomSubtitleAdapter;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: primary_action_truncated */
public class SubtitleAdapterFactory {
    private static volatile SubtitleAdapterFactory f9071b;
    private final FbHandlerThreadFactory f9072a;

    public static com.facebook.video.subtitles.controller.SubtitleAdapterFactory m13946a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9071b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.video.subtitles.controller.SubtitleAdapterFactory.class;
        monitor-enter(r1);
        r0 = f9071b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m13947b(r0);	 Catch:{ all -> 0x0035 }
        f9071b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9071b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.video.subtitles.controller.SubtitleAdapterFactory.a(com.facebook.inject.InjectorLike):com.facebook.video.subtitles.controller.SubtitleAdapterFactory");
    }

    private static SubtitleAdapterFactory m13947b(InjectorLike injectorLike) {
        return new SubtitleAdapterFactory(FbHandlerThreadFactory.m3575a(injectorLike));
    }

    @Inject
    public SubtitleAdapterFactory(FbHandlerThreadFactory fbHandlerThreadFactory) {
        this.f9072a = fbHandlerThreadFactory;
    }

    public final CustomSubtitleAdapter m13948a() {
        return new CustomSubtitleAdapter(this.f9072a);
    }
}
