package com.facebook.privacy.selector;

import android.content.Context;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.device.yearclass.YearClass;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.SequenceLogger;
import com.facebook.sequencelogger.SequenceLoggerImpl;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: fbf31027bdb9441fc5a945820e04894d */
public class AudienceSelectorPerformanceLogger {
    public static final AudienceSelectorTTISequenceDefinition f15147a = new AudienceSelectorTTISequenceDefinition();
    private static volatile AudienceSelectorPerformanceLogger f15148f;
    public final SequenceLogger f15149b;
    private final Context f15150c;
    public final Lazy<FbErrorReporter> f15151d;
    public boolean f15152e = false;

    /* compiled from: fbf31027bdb9441fc5a945820e04894d */
    public final class AudienceSelectorTTISequenceDefinition extends AbstractSequenceDefinition {
        public AudienceSelectorTTISequenceDefinition() {
            String str = "LaunchAudienceSelectorSequence";
            Builder builder = new Builder();
            for (Caller caller : Caller.values()) {
                builder.c(caller.toString());
            }
            super(1441793, str, true, builder.b());
        }
    }

    /* compiled from: fbf31027bdb9441fc5a945820e04894d */
    public enum Caller {
        ALBUM_CREATOR_FRAGMENT("com.facebook.photos.albumcreator.AlbumCreatorFragment"),
        CHANNEL_CREATOR_ACTIVITY("com.facebook.channels.activity.ChannelCreatorActivity"),
        COMPOSER_AUDIENCE_FRAGMENT("com.facebook.composer.privacy.common.ComposerAudienceFragment"),
        COMPOSER_FRAGMENT("com.facebook.composer.activity.ComposerFragment"),
        EDIT_STORY_PRIVACY_FRAGMENT("com.facebook.privacy.edit.EditStoryPrivacyFragment"),
        FACECAST_ACTIVITY("com.facebook.facecast.FacecastActivity"),
        PRIVACY_SAMPLE_APP("com.facebook.samples.privacy.MainFragment"),
        NOW_AUDIENCE_ACTIVITY("com.facebook.now.NowSettingsHostActivity"),
        PRIVACY_CHECKUP_STEP_FRAGMENT("com.facebook.privacy.checkup.PrivacyCheckupStepFragment");
        
        private final String caller;

        private Caller(String str) {
            this.caller = str;
        }

        public final String toString() {
            return this.caller;
        }
    }

    public static com.facebook.privacy.selector.AudienceSelectorPerformanceLogger m22742a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15148f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.class;
        monitor-enter(r1);
        r0 = f15148f;	 Catch:{ all -> 0x003a }
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
        r0 = m22743b(r0);	 Catch:{ all -> 0x0035 }
        f15148f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15148f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.selector.AudienceSelectorPerformanceLogger.a(com.facebook.inject.InjectorLike):com.facebook.privacy.selector.AudienceSelectorPerformanceLogger");
    }

    private static AudienceSelectorPerformanceLogger m22743b(InjectorLike injectorLike) {
        return new AudienceSelectorPerformanceLogger((SequenceLogger) SequenceLoggerImpl.a(injectorLike), (Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 494));
    }

    @Inject
    public AudienceSelectorPerformanceLogger(SequenceLogger sequenceLogger, Context context, Lazy<FbErrorReporter> lazy) {
        this.f15149b = sequenceLogger;
        this.f15150c = context;
        this.f15151d = lazy;
    }

    public final void m22744a(Caller caller) {
        this.f15149b.a(f15147a, ImmutableMap.of("year_class", String.valueOf(YearClass.a(this.f15150c)), "caller", caller.toString()));
        this.f15152e = true;
    }
}
