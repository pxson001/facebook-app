package com.facebook.search.suggestions.logging;

import com.facebook.inject.InjectorLike;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.ui.typeahead.FetchSource;
import com.facebook.ui.typeahead.TypeaheadRequest;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: {MANAGE_OR_DELETE_TOKEN} */
public class DelegatingSuggestionsPerformanceLogger {
    private static volatile DelegatingSuggestionsPerformanceLogger f144f;
    public final SuggestionsPerformanceLocalLogger f145a;
    public final SuggestionsPerformanceRemoteLogger f146b;
    public final SuggestionsPerformanceRemoteEntityLogger f147c;
    public final SuggestionsPerformanceRemoteKeywordLogger f148d;
    public final SuggestionsPerformanceMemoryLogger f149e;

    /* compiled from: {MANAGE_OR_DELETE_TOKEN} */
    /* synthetic */ class C00221 {
        static final /* synthetic */ int[] f143a = new int[FetchSource.values().length];

        static {
            try {
                f143a[FetchSource.REMOTE_ENTITY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f143a[FetchSource.REMOTE_KEYWORD.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger m258a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f144f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f144f;	 Catch:{ all -> 0x003a }
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
        r0 = m260b(r0);	 Catch:{ all -> 0x0035 }
        f144f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f144f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.logging.DelegatingSuggestionsPerformanceLogger");
    }

    private static DelegatingSuggestionsPerformanceLogger m260b(InjectorLike injectorLike) {
        return new DelegatingSuggestionsPerformanceLogger(SuggestionsPerformanceLocalLogger.m277a(injectorLike), SuggestionsPerformanceRemoteLogger.m295a(injectorLike), SuggestionsPerformanceRemoteEntityLogger.m289a(injectorLike), SuggestionsPerformanceRemoteKeywordLogger.m292a(injectorLike), SuggestionsPerformanceMemoryLogger.m280a(injectorLike));
    }

    @Inject
    public DelegatingSuggestionsPerformanceLogger(SuggestionsPerformanceLocalLogger suggestionsPerformanceLocalLogger, SuggestionsPerformanceRemoteLogger suggestionsPerformanceRemoteLogger, SuggestionsPerformanceRemoteEntityLogger suggestionsPerformanceRemoteEntityLogger, SuggestionsPerformanceRemoteKeywordLogger suggestionsPerformanceRemoteKeywordLogger, SuggestionsPerformanceMemoryLogger suggestionsPerformanceMemoryLogger) {
        this.f145a = suggestionsPerformanceLocalLogger;
        this.f146b = suggestionsPerformanceRemoteLogger;
        this.f147c = suggestionsPerformanceRemoteEntityLogger;
        this.f148d = suggestionsPerformanceRemoteKeywordLogger;
        this.f149e = suggestionsPerformanceMemoryLogger;
    }

    public final void m262a(FetchSource fetchSource, TypeaheadRequest typeaheadRequest, int i) {
        m259a(fetchSource).mo33a(typeaheadRequest, i);
    }

    public final void m264a(FetchSource fetchSource, List<TypeaheadUnit> list, TypeaheadRequest typeaheadRequest) {
        m259a(fetchSource).mo34a(typeaheadRequest, (List) list);
    }

    public final void m261a(FetchSource fetchSource, TypeaheadRequest typeaheadRequest) {
        m259a(fetchSource).mo37d(typeaheadRequest);
    }

    public final void m263a(FetchSource fetchSource, ImmutableMap<String, String> immutableMap) {
        SuggestionsPerformanceLogger a = m259a(fetchSource);
        if (a.f152a.e(a.mo31a()) != null) {
            a.f152a.b(a.mo31a(), immutableMap);
        }
        a.f156e.clear();
        a.f154c.clear();
        a.f158g.clear();
        a.f157f.clear();
        a.f155d = 0;
    }

    public final void m265d(TypeaheadRequest typeaheadRequest) {
        this.f145a.mo37d(typeaheadRequest);
    }

    private SuggestionsPerformanceLogger m259a(FetchSource fetchSource) {
        switch (C00221.f143a[fetchSource.ordinal()]) {
            case 1:
                return this.f147c;
            case 2:
                return this.f148d;
            default:
                return this.f146b;
        }
    }
}
