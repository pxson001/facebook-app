package com.facebook.platform.composer.logging;

import com.facebook.inject.InjectorLike;
import com.facebook.platform.common.module.String_PlatformPerformanceLoggingCommonTagsMethodAutoProvider;
import com.facebook.platform.composer.composer.PlatformComposerActivity;
import com.facebook.platform.composer.composer.PlatformComposerFragment;
import com.facebook.platform.perflogging.AbstractPlatformLaunchSequenceDefinition;
import com.facebook.platform.perflogging.PlatformPerformanceLogger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: rich_document_block_creation */
public class PlatformComposerPerformanceLogger {
    private static volatile PlatformComposerPerformanceLogger f4158d;
    public final SequenceLogger f4159a;
    private final PlatformPerformanceLogger f4160b;
    public final PlatformComposerLaunchSequenceDefinition f4161c;

    @Singleton
    /* compiled from: rich_document_block_creation */
    public final class PlatformComposerLaunchSequenceDefinition extends AbstractPlatformLaunchSequenceDefinition {
        private static volatile PlatformComposerLaunchSequenceDefinition f4157a;

        public static com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.PlatformComposerLaunchSequenceDefinition m4115a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = f4157a;
            if (r0 != 0) goto L_0x0032;
        L_0x0004:
            r1 = com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.PlatformComposerLaunchSequenceDefinition.class;
            monitor-enter(r1);
            r0 = f4157a;	 Catch:{ all -> 0x003a }
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
            r0 = m4116b(r0);	 Catch:{ all -> 0x0035 }
            f4157a = r0;	 Catch:{ all -> 0x0035 }
            com.facebook.inject.SingletonScope.a(r4);
            r2.c(r3);
        L_0x0031:
            monitor-exit(r1);	 Catch:{  }
        L_0x0032:
            r0 = f4157a;
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
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.PlatformComposerLaunchSequenceDefinition.a(com.facebook.inject.InjectorLike):com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger$PlatformComposerLaunchSequenceDefinition");
        }

        private static PlatformComposerLaunchSequenceDefinition m4116b(InjectorLike injectorLike) {
            return new PlatformComposerLaunchSequenceDefinition(String_PlatformPerformanceLoggingCommonTagsMethodAutoProvider.a(injectorLike));
        }

        @Inject
        public PlatformComposerLaunchSequenceDefinition(String str) {
            super(8060932, "PlatformComposerTTI", ImmutableSet.of(PlatformComposerFragment.class.getName(), PlatformComposerActivity.class.getName(), "com.facebook.composer.shareintent.ImplicitShareIntentHandler"), str);
        }
    }

    public static com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger m4117a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4158d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f4158d;	 Catch:{ all -> 0x003a }
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
        r0 = m4118b(r0);	 Catch:{ all -> 0x0035 }
        f4158d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4158d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.platform.composer.logging.PlatformComposerPerformanceLogger");
    }

    private static PlatformComposerPerformanceLogger m4118b(InjectorLike injectorLike) {
        return new PlatformComposerPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), PlatformPerformanceLogger.a(injectorLike), PlatformComposerLaunchSequenceDefinition.m4115a(injectorLike));
    }

    @Inject
    public PlatformComposerPerformanceLogger(SequenceLogger sequenceLogger, PlatformPerformanceLogger platformPerformanceLogger, PlatformComposerLaunchSequenceDefinition platformComposerLaunchSequenceDefinition) {
        this.f4159a = sequenceLogger;
        this.f4160b = platformPerformanceLogger;
        this.f4161c = platformComposerLaunchSequenceDefinition;
    }

    public final void m4121a(long j, boolean z, Map<String, String> map) {
        this.f4160b.a(j, z, new Builder().a(map).b("is_native_intent", "true").b());
        m4119e();
    }

    public final void m4120a() {
        m4119e();
    }

    private void m4119e() {
        this.f4160b.a(this.f4161c);
        Sequence e = this.f4159a.e(this.f4161c);
        if (e != null) {
            SequenceLoggerDetour.a(e, "PlatformShareDialogSetup", -619244452);
        }
    }

    public final void m4122b() {
        Sequence e = this.f4159a.e(this.f4161c);
        if (e != null) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "PlatformShareDialogSetup", -1011837107), "PlatformComposerLaunch", 1613545976);
        }
    }
}
