package com.facebook.photos.pandora.common.ui.renderer.highlights;

import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.photos.pandora.protocols.PandoraQueryModels.PandoraMediaModel;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.google.android.gms.cast.metadata.COMPOSER */
public class PandoraHighlightsCalculator {
    private static volatile PandoraHighlightsCalculator f17496a;

    public static com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator m21485a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f17496a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator.class;
        monitor-enter(r1);
        r0 = f17496a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m21484a();	 Catch:{ all -> 0x0034 }
        f17496a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f17496a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.ui.renderer.highlights.PandoraHighlightsCalculator");
    }

    private static PandoraHighlightsCalculator m21484a() {
        return new PandoraHighlightsCalculator();
    }

    public static double m21482a(GraphQLPhoto graphQLPhoto) {
        if (graphQLPhoto == null || graphQLPhoto.F() == null) {
            return 1.0d;
        }
        return Math.max(1.0d, (double) ((GraphQLHelper.f(graphQLPhoto.F()) + GraphQLHelper.p(graphQLPhoto.F())) * 2));
    }

    public static double m21483a(PandoraMediaModel pandoraMediaModel) {
        if (pandoraMediaModel == null || pandoraMediaModel.C() == null || pandoraMediaModel.C().n() == null || pandoraMediaModel.C().m() == null) {
            return 1.0d;
        }
        return Math.max(1.0d, (double) ((pandoraMediaModel.C().n().a() + pandoraMediaModel.C().m().a()) * 2));
    }
}
