package com.facebook.composer.analytics;

import android.content.Context;
import com.facebook.device.yearclass.YearClass;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.model.ComposerEntryPicker;
import com.facebook.perf.InteractionTTILogger;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.Sequence;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: phprof_sample */
public class ComposerPerformanceLogger {
    public static final AbstractSequenceDefinition f9870a = new C04151(917505, "LaunchTextComposerSequence", false, ImmutableSet.of("com.facebook.composer.activity.ComposerFragment", "com.facebook.composer.activity.ComposerActivity"));
    public static final AbstractSequenceDefinition f9871b = new C04162(917511, "ComposerPostDrawPhase", false, ImmutableSet.of("com.facebook.composer.activity.ComposerFragment", "com.facebook.composer.activity.ComposerActivity"));
    private static volatile ComposerPerformanceLogger f9872h;
    public final PerformanceLogger f9873c;
    public final SequenceLogger f9874d;
    public final InteractionTTILogger f9875e;
    private final Context f9876f;
    public boolean f9877g;

    /* compiled from: phprof_sample */
    final class C04151 extends AbstractSequenceDefinition {
        C04151(int i, String str, boolean z, ImmutableSet immutableSet) {
            super(i, str, z, immutableSet);
        }
    }

    /* compiled from: phprof_sample */
    final class C04162 extends AbstractSequenceDefinition {
        C04162(int i, String str, boolean z, ImmutableSet immutableSet) {
            super(i, str, z, immutableSet);
        }
    }

    public static com.facebook.composer.analytics.ComposerPerformanceLogger m14909a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9872h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.composer.analytics.ComposerPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f9872h;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m14910b(r0);	 Catch:{ all -> 0x0035 }
        f9872h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9872h;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.composer.analytics.ComposerPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.composer.analytics.ComposerPerformanceLogger");
    }

    private static ComposerPerformanceLogger m14910b(InjectorLike injectorLike) {
        return new ComposerPerformanceLogger(DelegatingPerformanceLogger.m2803a(injectorLike), SequenceLoggerImpl.m3464a(injectorLike), InteractionTTILogger.m4228a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ComposerPerformanceLogger(PerformanceLogger performanceLogger, SequenceLogger sequenceLogger, InteractionTTILogger interactionTTILogger, Context context) {
        this.f9873c = performanceLogger;
        this.f9874d = sequenceLogger;
        this.f9875e = interactionTTILogger;
        this.f9876f = context;
    }

    public final void m14911a(String str) {
        Preconditions.checkState(this.f9877g, "Can't start a TTI marker before or after the composer launch phase");
        Sequence e = this.f9874d.mo524e(f9870a);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, 925047908);
        }
    }

    public final void m14914b(String str) {
        Preconditions.checkState(this.f9877g, "Can't stop a TTI marker before or after the composer launch phase");
        Sequence e = this.f9874d.mo524e(f9870a);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, 167439721);
        }
    }

    public final void m14916c(String str) {
        Sequence e = this.f9874d.mo524e(f9871b);
        if (e != null) {
            SequenceLoggerDetour.a(e, str, -1935462044);
        }
    }

    public final void m14917d(String str) {
        Sequence e = this.f9874d.mo524e(f9871b);
        if (e != null) {
            SequenceLoggerDetour.b(e, str, 18061128);
        }
    }

    public final void m14915c() {
        this.f9873c.mo389c(917512, "ComposerActionButtonPressed");
        this.f9873c.mo374a(917513, "ComposerSelectedPrivacyAvailable");
    }

    public final void m14913a(String str, String str2) {
        this.f9875e.m4252a(str, str2);
        SequenceLoggerDetour.a(this.f9874d.mo510a(f9870a), "RefHandOff", 1451551385);
    }

    public final void m14912a(String str, ComposerConfiguration composerConfiguration) {
        Sequence e = this.f9874d.mo524e(f9870a);
        if (e != null) {
            Object analyticsName;
            String str2 = "ComposerFragmentOnCreate";
            String str3 = "composer_uuid";
            String str4 = "composer_type";
            if (composerConfiguration.getLaunchLoggingParams().getEntryPicker() != ComposerEntryPicker.NONE) {
                analyticsName = composerConfiguration.getLaunchLoggingParams().getEntryPicker().getAnalyticsName();
            } else {
                analyticsName = composerConfiguration.getComposerType().toString();
            }
            String str5 = str;
            SequenceLoggerDetour.b(e, str2, null, ImmutableMap.of(str3, str5, str4, analyticsName, "year_class", String.valueOf(YearClass.m30095a(this.f9876f)), "ref", composerConfiguration.getSourceType().toString()), -747510694);
        }
    }
}
