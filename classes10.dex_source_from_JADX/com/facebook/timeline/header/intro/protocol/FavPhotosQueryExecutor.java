package com.facebook.timeline.header.intro.protocol;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.protocol.SizeAwareImageUtil;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fetch_fav_photos */
public class FavPhotosQueryExecutor {
    public static final Set<String> f11844a;
    public static final CallerContext f11845b = CallerContext.a(FavPhotosQueryExecutor.class, "timeline");
    private static volatile FavPhotosQueryExecutor f11846f;
    public final GraphQLQueryExecutor f11847c;
    public final GraphQLImageHelper f11848d;
    public final SizeAwareImageUtil f11849e;

    public static com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor m11941a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f11846f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor.class;
        monitor-enter(r1);
        r0 = f11846f;	 Catch:{ all -> 0x003a }
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
        r0 = m11942b(r0);	 Catch:{ all -> 0x0035 }
        f11846f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f11846f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor.a(com.facebook.inject.InjectorLike):com.facebook.timeline.header.intro.protocol.FavPhotosQueryExecutor");
    }

    private static FavPhotosQueryExecutor m11942b(InjectorLike injectorLike) {
        return new FavPhotosQueryExecutor(GraphQLQueryExecutor.a(injectorLike), GraphQLImageHelper.a(injectorLike), SizeAwareImageUtil.a(injectorLike));
    }

    static {
        Set hashSet = new HashSet();
        f11844a = hashSet;
        hashSet.add("com.facebook.timeline.header.intro.protocol.favPhotosQueryTag");
    }

    @Inject
    public FavPhotosQueryExecutor(GraphQLQueryExecutor graphQLQueryExecutor, GraphQLImageHelper graphQLImageHelper, SizeAwareImageUtil sizeAwareImageUtil) {
        this.f11847c = graphQLQueryExecutor;
        this.f11848d = graphQLImageHelper;
        this.f11849e = sizeAwareImageUtil;
    }
}
