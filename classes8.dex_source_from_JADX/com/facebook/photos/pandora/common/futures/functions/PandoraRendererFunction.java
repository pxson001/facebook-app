package com.facebook.photos.pandora.common.futures.functions;

import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.PandoraInstanceId;
import com.facebook.photos.pandora.common.data.PandoraSlicedFeedResult;
import com.facebook.photos.pandora.common.futures.PandoraFutures.PandoraFunction;
import com.facebook.photos.pandora.common.source.PandoraRequestSource;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController;
import com.facebook.photos.pandora.common.ui.renderer.PandoraRendererResult;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererGridConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererCacheConfig;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: commercial_break_skywalker_receive_intent */
public class PandoraRendererFunction extends PandoraFunction<OperationResult, OperationResult, ParamWrapper> {
    private static volatile PandoraRendererFunction f17411c;
    private final Lazy<PandoraRendererController> f17412a;
    private final Lazy<PandoraRendererGridConfiguration> f17413b;

    /* compiled from: commercial_break_skywalker_receive_intent */
    public class ParamWrapper {
        public final PandoraInstanceId f17406a;
        public final int f17407b = -1;
        public final int f17408c = -1;
        public final PandoraRequestSource f17409d;
        public final PandoraRendererConfiguration f17410e;

        public ParamWrapper(PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource) {
            this.f17406a = pandoraInstanceId;
            this.f17409d = pandoraRequestSource;
            this.f17410e = null;
        }

        public ParamWrapper(PandoraInstanceId pandoraInstanceId, PandoraRequestSource pandoraRequestSource, PandoraRendererConfiguration pandoraRendererConfiguration) {
            this.f17406a = pandoraInstanceId;
            this.f17409d = pandoraRequestSource;
            this.f17410e = pandoraRendererConfiguration;
        }
    }

    public static com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction m21391a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17411c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction.class;
        monitor-enter(r1);
        r0 = f17411c;	 Catch:{ all -> 0x003a }
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
        r0 = m21392b(r0);	 Catch:{ all -> 0x0035 }
        f17411c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17411c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.futures.functions.PandoraRendererFunction");
    }

    private static PandoraRendererFunction m21392b(InjectorLike injectorLike) {
        return new PandoraRendererFunction(IdBasedSingletonScopeProvider.b(injectorLike, 9384), IdBasedLazy.a(injectorLike, 9385));
    }

    public final Object mo1042a(Object obj, @Nullable Object obj2) {
        ParamWrapper paramWrapper = (ParamWrapper) obj;
        OperationResult operationResult = (OperationResult) obj2;
        if (!operationResult.b) {
            return operationResult;
        }
        PandoraSlicedFeedResult pandoraSlicedFeedResult = (PandoraSlicedFeedResult) operationResult.h();
        if ((pandoraSlicedFeedResult.f17361b == null || pandoraSlicedFeedResult.f17361b.isEmpty()) && operationResult.b) {
            return OperationResult.a(new PandoraRendererResult(RegularImmutableList.a));
        }
        return OperationResult.a(new PandoraRendererResult(((PandoraRendererController) this.f17412a.get()).m21447a(new PandoraRendererCacheConfig(paramWrapper.f17406a, paramWrapper.f17407b, paramWrapper.f17408c, paramWrapper.f17409d, pandoraSlicedFeedResult.f17360a.b()), paramWrapper.f17410e != null ? paramWrapper.f17410e : (PandoraRendererConfiguration) this.f17413b.get(), pandoraSlicedFeedResult.f17361b, false)));
    }

    @Inject
    public PandoraRendererFunction(Lazy<PandoraRendererController> lazy, Lazy<PandoraRendererGridConfiguration> lazy2) {
        this.f17412a = lazy;
        this.f17413b = lazy2;
    }
}
