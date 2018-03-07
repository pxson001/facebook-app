package com.facebook.pages.common.sequencelogger;

import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: error */
public class PagesManagerStartupSequencesHelper {
    private static volatile PagesManagerStartupSequencesHelper f12846b;
    public final SequenceLogger f12847a;

    public static com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper m13680a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f12846b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper.class;
        monitor-enter(r1);
        r0 = f12846b;	 Catch:{ all -> 0x003a }
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
        r0 = m13685b(r0);	 Catch:{ all -> 0x0035 }
        f12846b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f12846b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.sequencelogger.PagesManagerStartupSequencesHelper");
    }

    private static PagesManagerStartupSequencesHelper m13685b(InjectorLike injectorLike) {
        return new PagesManagerStartupSequencesHelper((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public PagesManagerStartupSequencesHelper(SequenceLogger sequenceLogger) {
        this.f12847a = sequenceLogger;
    }

    private PagesManagerStartupSequencesHelper m13688f(String str) {
        return m13682a(PagesManagerStartupSequences.d, str, null, null);
    }

    private PagesManagerStartupSequencesHelper m13689g(String str) {
        return m13687b(PagesManagerStartupSequences.d, str, null, null);
    }

    private PagesManagerStartupSequencesHelper m13690h(String str) {
        return m13686b(PagesManagerStartupSequences.d, str);
    }

    private PagesManagerStartupSequencesHelper m13691i(String str) {
        return m13681a(PagesManagerStartupSequences.d, str);
    }

    private PagesManagerStartupSequencesHelper m13692j(String str) {
        return m13682a(PagesManagerStartupSequences.e, str, null, null);
    }

    private PagesManagerStartupSequencesHelper m13693k(String str) {
        return m13687b(PagesManagerStartupSequences.e, str, null, null);
    }

    private PagesManagerStartupSequencesHelper m13694l(String str) {
        return m13686b(PagesManagerStartupSequences.e, str);
    }

    private PagesManagerStartupSequencesHelper m13695m(String str) {
        return m13681a(PagesManagerStartupSequences.e, str);
    }

    public final PagesManagerStartupSequencesHelper m13698a(String str) {
        m13688f(str);
        m13692j(str);
        return this;
    }

    public final PagesManagerStartupSequencesHelper m13699b(String str) {
        m13689g(str);
        m13693k(str);
        return this;
    }

    public final PagesManagerStartupSequencesHelper m13700c(String str) {
        int i;
        Object obj;
        ImmutableList immutableList = PagesManagerStartupSequences.d;
        int size = immutableList.size();
        for (i = 0; i < size; i++) {
            Sequence e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null && e.f(str)) {
                obj = 1;
                break;
            }
        }
        immutableList = PagesManagerStartupSequences.e;
        size = immutableList.size();
        for (i = 0; i < size; i++) {
            e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null && e.f(str)) {
                int i2 = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            return this;
        }
        return m13699b(str);
    }

    public final PagesManagerStartupSequencesHelper m13701d(String str) {
        m13690h(str);
        m13694l(str);
        return this;
    }

    public final PagesManagerStartupSequencesHelper m13702e(String str) {
        m13691i(str);
        m13695m(str);
        return this;
    }

    private PagesManagerStartupSequencesHelper m13682a(ImmutableList<? extends AbstractSequenceDefinition> immutableList, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.a(e, str, str2, immutableMap, -785923346);
            }
        }
        return this;
    }

    private PagesManagerStartupSequencesHelper m13687b(ImmutableList<? extends AbstractSequenceDefinition> immutableList, String str, @Nullable String str2, @Nullable ImmutableMap<String, String> immutableMap) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.b(e, str, str2, immutableMap, 1822188972);
            }
        }
        return this;
    }

    private PagesManagerStartupSequencesHelper m13681a(ImmutableList<? extends AbstractSequenceDefinition> immutableList, String str) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.d(e, str, -1248658435);
            }
        }
        return this;
    }

    private PagesManagerStartupSequencesHelper m13686b(ImmutableList<? extends AbstractSequenceDefinition> immutableList, String str) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            Sequence e = this.f12847a.e((AbstractSequenceDefinition) immutableList.get(i));
            if (e != null) {
                SequenceLoggerDetour.c(e, str, 151555762);
            }
        }
        return this;
    }

    public final PagesManagerStartupSequencesHelper m13696a() {
        m13683a(PagesManagerStartupSequences.d);
        m13683a(PagesManagerStartupSequences.e);
        return this;
    }

    private void m13683a(ImmutableList<? extends AbstractSequenceDefinition> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            AbstractSequenceDefinition abstractSequenceDefinition = (AbstractSequenceDefinition) immutableList.get(i);
            if (this.f12847a.e(abstractSequenceDefinition) != null) {
                this.f12847a.d(abstractSequenceDefinition);
            }
        }
    }

    public final PagesManagerStartupSequencesHelper m13697a(@Nullable ImmutableMap<String, String> immutableMap) {
        m13684a(PagesManagerStartupSequences.d, (ImmutableMap) immutableMap);
        m13684a(PagesManagerStartupSequences.e, (ImmutableMap) immutableMap);
        return this;
    }

    private void m13684a(ImmutableList<? extends AbstractSequenceDefinition> immutableList, @Nullable ImmutableMap<String, String> immutableMap) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            AbstractSequenceDefinition abstractSequenceDefinition = (AbstractSequenceDefinition) immutableList.get(i);
            if (this.f12847a.e(abstractSequenceDefinition) != null) {
                this.f12847a.b(abstractSequenceDefinition, immutableMap);
            }
        }
    }
}
