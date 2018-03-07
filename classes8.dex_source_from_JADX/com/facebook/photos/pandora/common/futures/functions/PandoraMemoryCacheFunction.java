package com.facebook.photos.pandora.common.futures.functions;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache;
import com.facebook.photos.pandora.common.cache.PandoraStoryMemoryCache.MemoryCacheEntryKey;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.data.PandoraStoryPagedCollection;
import com.facebook.photos.pandora.common.futures.PandoraFutures.PandoraFunction;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: commercial_break_skywalker_receive_invalid_message */
public class PandoraMemoryCacheFunction extends PandoraFunction<OperationResult, OperationResult, MemoryCacheEntryKey> {
    private static volatile PandoraMemoryCacheFunction f17404b;
    private final Lazy<PandoraStoryMemoryCache> f17405a;

    public static com.facebook.photos.pandora.common.futures.functions.PandoraMemoryCacheFunction m21388a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17404b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.futures.functions.PandoraMemoryCacheFunction.class;
        monitor-enter(r1);
        r0 = f17404b;	 Catch:{ all -> 0x003a }
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
        r0 = m21389b(r0);	 Catch:{ all -> 0x0035 }
        f17404b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17404b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.futures.functions.PandoraMemoryCacheFunction.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.futures.functions.PandoraMemoryCacheFunction");
    }

    private static PandoraMemoryCacheFunction m21389b(InjectorLike injectorLike) {
        return new PandoraMemoryCacheFunction(IdBasedLazy.a(injectorLike, 9373));
    }

    public final Object mo1042a(Object obj, @Nullable Object obj2) {
        MemoryCacheEntryKey memoryCacheEntryKey = (MemoryCacheEntryKey) obj;
        OperationResult operationResult = (OperationResult) obj2;
        if (operationResult.b) {
            PandoraStoryPagedCollection a = ((PandoraStoryMemoryCache) this.f17405a.get()).m21363a(memoryCacheEntryKey);
            if (a != null) {
                a.m21367a((PandoraSlicedFeedResult) operationResult.h());
            }
        }
        return operationResult;
    }

    @Inject
    public PandoraMemoryCacheFunction(Lazy<PandoraStoryMemoryCache> lazy) {
        this.f17405a = lazy;
    }
}
