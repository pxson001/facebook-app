package com.facebook.photos.pandora.logging;

import com.facebook.inject.InjectorLike;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: com.facebook.platform.extra.COMPOSER_EXCEPTION */
public class PandoraSequenceLogger {
    private static volatile PandoraSequenceLogger f17579b;
    public final SequenceLogger f17580a;

    public static com.facebook.photos.pandora.logging.PandoraSequenceLogger m21549a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17579b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.photos.pandora.logging.PandoraSequenceLogger.class;
        monitor-enter(r1);
        r0 = f17579b;	 Catch:{ all -> 0x003a }
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
        r0 = m21550b(r0);	 Catch:{ all -> 0x0035 }
        f17579b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17579b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.pandora.logging.PandoraSequenceLogger.a(com.facebook.inject.InjectorLike):com.facebook.photos.pandora.logging.PandoraSequenceLogger");
    }

    private static PandoraSequenceLogger m21550b(InjectorLike injectorLike) {
        return new PandoraSequenceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike));
    }

    @Inject
    public PandoraSequenceLogger(SequenceLogger sequenceLogger) {
        this.f17580a = sequenceLogger;
    }

    public final void m21551a(String str) {
        Sequence e = this.f17580a.e(PandoraSequences.f17581a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, 360970558);
        }
    }

    public final void m21553b(String str) {
        Sequence e = this.f17580a.e(PandoraSequences.f17581a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, 445023935);
        }
    }

    public final void m21552a(String str, String str2, String str3) {
        Sequence e = this.f17580a.e(PandoraSequences.f17581a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, null, ImmutableBiMap.b(str2, str3), 127506514);
        }
    }
}
