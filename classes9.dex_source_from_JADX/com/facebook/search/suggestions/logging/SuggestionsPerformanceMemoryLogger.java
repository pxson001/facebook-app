package com.facebook.search.suggestions.logging;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.search.abtest.SearchAbTestGatekeepers;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.logging.SuggestionsPerformanceLogger.SuggestionsTypeaheadSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.ui.typeahead.TypeaheadRequest;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: zero_rating_declined */
public class SuggestionsPerformanceMemoryLogger extends SuggestionsPerformanceLogger {
    private static volatile SuggestionsPerformanceMemoryLogger f161g;
    private final SuggestionsTypeaheadSequenceDefinition f162e;
    public final DefaultAndroidThreadUtil f163f;

    public static com.facebook.search.suggestions.logging.SuggestionsPerformanceMemoryLogger m280a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f161g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.suggestions.logging.SuggestionsPerformanceMemoryLogger.class;
        monitor-enter(r1);
        r0 = f161g;	 Catch:{ all -> 0x003a }
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
        r0 = m281b(r0);	 Catch:{ all -> 0x0035 }
        f161g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f161g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.suggestions.logging.SuggestionsPerformanceMemoryLogger.a(com.facebook.inject.InjectorLike):com.facebook.search.suggestions.logging.SuggestionsPerformanceMemoryLogger");
    }

    private static SuggestionsPerformanceMemoryLogger m281b(InjectorLike injectorLike) {
        return new SuggestionsPerformanceMemoryLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), QuickPerformanceLoggerMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike));
    }

    @Inject
    public SuggestionsPerformanceMemoryLogger(SequenceLogger sequenceLogger, QuickPerformanceLogger quickPerformanceLogger, GatekeeperStoreImpl gatekeeperStoreImpl, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        SuggestionsTypeaheadSequenceDefinition suggestionsTypeaheadSequenceDefinition;
        super(sequenceLogger, quickPerformanceLogger);
        if (gatekeeperStoreImpl.a(SearchAbTestGatekeepers.f).asBoolean(false)) {
            suggestionsTypeaheadSequenceDefinition = new SuggestionsTypeaheadSequenceDefinition(458783, "GraphSearchMemorySuggestionsTypeahead");
        } else {
            suggestionsTypeaheadSequenceDefinition = new SuggestionsTypeaheadSequenceDefinition(458770, "SimpleSearchMemorySuggestionsTypeahead");
        }
        this.f162e = suggestionsTypeaheadSequenceDefinition;
        this.f163f = defaultAndroidThreadUtil;
    }

    public final void mo32a(TypeaheadRequest typeaheadRequest) {
        this.f163f.a();
        SequenceLoggerDetour.a(m273b(), "end_to_end", String.valueOf(this.f155d), null, -771739806);
        SequenceLoggerDetour.a(m273b(), "end_to_end_prerendering", String.valueOf(this.f155d), null, -1500275159);
    }

    public final void mo35a(List<TypeaheadUnit> list) {
        this.f163f.a();
        Sequence e = this.f152a.e(mo31a());
        if (e != null) {
            String valueOf = String.valueOf(this.f155d - 1);
            if (!e.c("end_to_end", valueOf)) {
                return;
            }
            if (list.isEmpty()) {
                SequenceLoggerDetour.a(e, "end_to_end", valueOf, -312271534);
            } else {
                SequenceLoggerDetour.b(e, "end_to_end", valueOf, null, -371418630);
            }
        }
    }

    public final void mo36c(TypeaheadRequest typeaheadRequest) {
        throw new UnsupportedOperationException();
    }

    public final void mo33a(TypeaheadRequest typeaheadRequest, int i) {
        throw new UnsupportedOperationException();
    }

    public final void mo34a(TypeaheadRequest typeaheadRequest, List<TypeaheadUnit> list) {
        throw new UnsupportedOperationException();
    }

    public final void mo37d(TypeaheadRequest typeaheadRequest) {
        throw new UnsupportedOperationException();
    }

    public final SuggestionsTypeaheadSequenceDefinition mo31a() {
        return this.f162e;
    }
}
