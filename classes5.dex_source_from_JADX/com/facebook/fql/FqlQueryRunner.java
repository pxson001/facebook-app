package com.facebook.fql;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.io.FbCloseables;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.fql.FqlHelper.Query;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: WWW_NUX_WIZARD */
public class FqlQueryRunner {
    private static volatile FqlQueryRunner f12307d;
    private final Provider<SingleMethodRunner> f12308a;
    private final FqlQueryMethod f12309b;
    private final ObjectMapper f12310c;

    public static com.facebook.fql.FqlQueryRunner m20395a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12307d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fql.FqlQueryRunner.class;
        monitor-enter(r1);
        r0 = f12307d;	 Catch:{ all -> 0x003a }
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
        r0 = m20396b(r0);	 Catch:{ all -> 0x0035 }
        f12307d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12307d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fql.FqlQueryRunner.a(com.facebook.inject.InjectorLike):com.facebook.fql.FqlQueryRunner");
    }

    private static FqlQueryRunner m20396b(InjectorLike injectorLike) {
        return new FqlQueryRunner(IdBasedSingletonScopeProvider.a(injectorLike, 2289), FqlQueryMethod.m20391a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public FqlQueryRunner(Provider<SingleMethodRunner> provider, FqlQueryMethod fqlQueryMethod, ObjectMapper objectMapper) {
        this.f12308a = provider;
        this.f12309b = fqlQueryMethod;
        this.f12310c = objectMapper;
    }

    public final <T> ImmutableList<T> m20397a(Query query, Class<T> cls, CallerContext callerContext) {
        JsonParser c = ((JsonNode) ((AbstractSingleMethodRunner) this.f12308a.get()).a(this.f12309b, query, null, callerContext)).c();
        try {
            c.a(this.f12310c);
            c.c();
            if (c.g() == JsonToken.START_ARRAY) {
                c.c();
            }
            ImmutableList<T> copyOf = ImmutableList.copyOf(c.b(cls));
            return copyOf;
        } finally {
            FbCloseables.a(c);
        }
    }

    public final <T> T m20398a(Query query, Function<JsonNode, T> function, CallerContext callerContext) {
        return function.apply(((AbstractSingleMethodRunner) this.f12308a.get()).a(this.f12309b, query, null, callerContext));
    }
}
