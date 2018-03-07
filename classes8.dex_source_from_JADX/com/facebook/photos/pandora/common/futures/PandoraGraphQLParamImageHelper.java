package com.facebook.photos.pandora.common.futures;

import android.content.res.Resources;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: commercial_break_skywalker_receive_start */
public class PandoraGraphQLParamImageHelper {
    public static int f17391d = -1;
    public static int f17392e = -1;
    public static int f17393f = -1;
    public static int f17394g = -1;
    public static int f17395h = -1;
    public static int f17396i = -1;
    public static int f17397j = -1;
    private static int f17398k = -1;
    private static int f17399l = -1;
    private static volatile PandoraGraphQLParamImageHelper f17400m;
    private final Lazy<Resources> f17401a;
    public final Lazy<GraphQLImageHelper> f17402b;
    public final Lazy<SizeAwareImageUtil> f17403c;

    public static com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper m21385a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17400m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper.class;
        monitor-enter(r1);
        r0 = f17400m;	 Catch:{ all -> 0x003a }
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
        r0 = m21386b(r0);	 Catch:{ all -> 0x0035 }
        f17400m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17400m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.common.futures.PandoraGraphQLParamImageHelper");
    }

    private static PandoraGraphQLParamImageHelper m21386b(InjectorLike injectorLike) {
        return new PandoraGraphQLParamImageHelper(IdBasedSingletonScopeProvider.b(injectorLike, 30), IdBasedSingletonScopeProvider.b(injectorLike, 2199), IdBasedSingletonScopeProvider.b(injectorLike, 2969));
    }

    @Inject
    public PandoraGraphQLParamImageHelper(Lazy<Resources> lazy, Lazy<GraphQLImageHelper> lazy2, Lazy<SizeAwareImageUtil> lazy3) {
        this.f17401a = lazy;
        this.f17402b = lazy2;
        this.f17403c = lazy3;
        int i = ((Resources) this.f17401a.get()).getDisplayMetrics().widthPixels;
        int dimensionPixelSize = ((Resources) this.f17401a.get()).getDimensionPixelSize(2131430950);
        f17391d = (i - (dimensionPixelSize * 4)) / 3;
        f17392e = (i - (dimensionPixelSize * 3)) - f17391d;
        f17395h = i - (dimensionPixelSize * 2);
        f17396i = f17392e;
        f17393f = f17392e;
        f17394g = (f17391d * 3) + (dimensionPixelSize * 2);
        f17397j = (f17393f * 3) / 2;
        f17398k = (i - (dimensionPixelSize * 3)) / 2;
        f17399l = dimensionPixelSize + (f17398k * 2);
    }

    public final GraphQlQueryString m21387a(GraphQlQueryString graphQlQueryString) {
        ((SizeAwareImageUtil) this.f17403c.get()).a(graphQlQueryString, ((GraphQLImageHelper) this.f17402b.get()).a());
        this.f17402b.get();
        graphQlQueryString.a("image_thumbnail_width", String.valueOf(GraphQLImageHelper.a(f17391d)));
        this.f17402b.get();
        graphQlQueryString.a("image_large_thumbnail_width", String.valueOf(GraphQLImageHelper.a(f17392e)));
        this.f17402b.get();
        graphQlQueryString.a("image_portrait_width", String.valueOf(GraphQLImageHelper.a(f17393f)));
        this.f17402b.get();
        graphQlQueryString.a("image_portrait_height", String.valueOf(GraphQLImageHelper.a(f17394g)));
        this.f17402b.get();
        graphQlQueryString.a("image_landscape_width", String.valueOf(GraphQLImageHelper.a(f17395h)));
        this.f17402b.get();
        graphQlQueryString.a("image_landscape_height", String.valueOf(GraphQLImageHelper.a(f17396i)));
        this.f17402b.get();
        graphQlQueryString.a("large_portrait_height", String.valueOf(GraphQLImageHelper.a(f17397j)));
        this.f17402b.get();
        graphQlQueryString.a("narrow_landscape_height", String.valueOf(GraphQLImageHelper.a(f17398k)));
        this.f17402b.get();
        graphQlQueryString.a("narrow_portrait_height", String.valueOf(GraphQLImageHelper.a(f17399l)));
        return graphQlQueryString;
    }
}
