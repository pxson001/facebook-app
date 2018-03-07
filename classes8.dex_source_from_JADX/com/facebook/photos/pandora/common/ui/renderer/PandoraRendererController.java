package com.facebook.photos.pandora.common.ui.renderer;

import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.ui.renderer.configs.PandoraRendererConfiguration;
import com.facebook.photos.pandora.common.ui.renderer.factories.AbstractPandoraRendererSingleDataModelRowFactory;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererCacheConfig;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererGridPhotosRowFactory;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererHighlightPhotosGridRowFactory;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererMultiPhotosRowEntryCache;
import com.facebook.photos.pandora.common.ui.renderer.factories.PandoraRendererRowFactory;
import com.facebook.photos.pandora.common.ui.renderer.rows.PandoraRendererRow;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE */
public class PandoraRendererController {
    private static volatile PandoraRendererController f17470b;
    public final Lazy<PandoraRendererMultiPhotosRowEntryCache> f17471a;

    public static com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController m21445a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17470b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController.class;
        monitor-enter(r1);
        r0 = f17470b;	 Catch:{ all -> 0x003a }
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
        r0 = m21446b(r0);	 Catch:{ all -> 0x0035 }
        f17470b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17470b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.ui.renderer.PandoraRendererController");
    }

    private static PandoraRendererController m21446b(InjectorLike injectorLike) {
        return new PandoraRendererController(IdBasedSingletonScopeProvider.b(injectorLike, 9390));
    }

    @Inject
    public PandoraRendererController(Lazy<PandoraRendererMultiPhotosRowEntryCache> lazy) {
        this.f17471a = lazy;
    }

    public final ImmutableList<PandoraRendererRow> m21447a(PandoraRendererCacheConfig pandoraRendererCacheConfig, PandoraRendererConfiguration pandoraRendererConfiguration, ImmutableList<PandoraDataModel> immutableList, boolean z) {
        ImmutableList a = pandoraRendererConfiguration.mo1045a();
        Builder builder = new Builder();
        PandoraRendererGridPhotosRowFactory pandoraRendererGridPhotosRowFactory = null;
        if (z) {
            this.f17471a.get();
            PandoraRendererMultiPhotosRowEntryCache.m21477b(pandoraRendererCacheConfig);
        }
        if (a.size() == 1 && (a.get(0) instanceof PandoraRendererHighlightPhotosGridRowFactory)) {
            return ((PandoraRendererHighlightPhotosGridRowFactory) a.get(0)).m21471a(pandoraRendererCacheConfig, (ImmutableList) immutableList);
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PandoraDataModel pandoraDataModel = (PandoraDataModel) immutableList.get(i);
            int size2 = a.size();
            int i2 = 0;
            while (i2 < size2) {
                PandoraRendererGridPhotosRowFactory pandoraRendererGridPhotosRowFactory2;
                PandoraRendererRowFactory pandoraRendererRowFactory = (PandoraRendererRowFactory) a.get(i2);
                if (pandoraRendererRowFactory instanceof AbstractPandoraRendererSingleDataModelRowFactory) {
                    AbstractPandoraRendererSingleDataModelRowFactory abstractPandoraRendererSingleDataModelRowFactory = (AbstractPandoraRendererSingleDataModelRowFactory) pandoraRendererRowFactory;
                    if (abstractPandoraRendererSingleDataModelRowFactory.mo1047a(pandoraDataModel)) {
                        pandoraRendererGridPhotosRowFactory2 = pandoraRendererRowFactory instanceof PandoraRendererGridPhotosRowFactory ? (PandoraRendererGridPhotosRowFactory) pandoraRendererRowFactory : null;
                        ImmutableList a2 = abstractPandoraRendererSingleDataModelRowFactory.mo1046a(pandoraRendererCacheConfig, pandoraDataModel);
                        if (!(a2 == null || a2.isEmpty())) {
                            builder.b(a2);
                        }
                    } else if (pandoraRendererGridPhotosRowFactory != null && pandoraRendererGridPhotosRowFactory.m21467a(pandoraRendererCacheConfig)) {
                        ImmutableList b = pandoraRendererGridPhotosRowFactory.m21468b(pandoraRendererCacheConfig);
                        if (!(b == null || b.isEmpty())) {
                            builder.b(b);
                        }
                        pandoraRendererGridPhotosRowFactory2 = pandoraRendererGridPhotosRowFactory;
                    }
                    i2++;
                    pandoraRendererGridPhotosRowFactory = pandoraRendererGridPhotosRowFactory2;
                }
                pandoraRendererGridPhotosRowFactory2 = pandoraRendererGridPhotosRowFactory;
                i2++;
                pandoraRendererGridPhotosRowFactory = pandoraRendererGridPhotosRowFactory2;
            }
        }
        if (!(pandoraRendererGridPhotosRowFactory == null || !pandoraRendererGridPhotosRowFactory.m21467a(pandoraRendererCacheConfig) || pandoraRendererCacheConfig.f17482e)) {
            builder.b(pandoraRendererGridPhotosRowFactory.m21465a(pandoraRendererCacheConfig, true));
        }
        return builder.b();
    }
}
