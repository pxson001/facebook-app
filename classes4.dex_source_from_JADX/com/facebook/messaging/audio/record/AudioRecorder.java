package com.facebook.messaging.audio.record;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaRecorder;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.tempfile.TempFileManager;
import com.facebook.common.tempfile.TempFileManager.Privacy;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: locale_list */
public class AudioRecorder {
    private static final Class<?> f9181a = AudioRecorder.class;
    private static volatile AudioRecorder f9182p;
    private double f9183b = 0.0d;
    private final AudioManager f9184c;
    private final TempFileManager f9185d;
    public final AnalyticsLogger f9186e;
    private final Clock f9187f;
    private final FocusChangeListener f9188g;
    private final ExecutorService f9189h;
    private long f9190i;
    public long f9191j;
    public boolean f9192k;
    private boolean f9193l;
    private boolean f9194m;
    private File f9195n;
    private MediaRecorder f9196o;

    /* compiled from: locale_list */
    class FocusChangeListener implements OnAudioFocusChangeListener {
        final /* synthetic */ AudioRecorder f9197a;

        public FocusChangeListener(AudioRecorder audioRecorder) {
            this.f9197a = audioRecorder;
        }

        public void onAudioFocusChange(int i) {
            switch (i) {
                case -1:
                    this.f9197a.m9535b();
                    return;
                default:
                    return;
            }
        }
    }

    private android.net.Uri m9527a(com.facebook.messaging.audio.record.AudioRecorder.Cause r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
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
        r5 = this;
        r4 = 0;
        r1 = 0;
        r0 = r5.f9196o;
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r0 = r5.f9192k;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        if (r0 == 0) goto L_0x0013;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
    L_0x000b:
        r0 = r5.f9196o;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        r0.stop();	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        r5.m9533j();	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
    L_0x0013:
        r0 = m9530b(r6);	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        if (r0 == 0) goto L_0x005d;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
    L_0x0019:
        r0 = r5.f9194m;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        if (r0 != 0) goto L_0x005d;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
    L_0x001d:
        r0 = r5.f9195n;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        r0 = android.net.Uri.fromFile(r0);	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
    L_0x0023:
        r5.f9192k = r4;
        r2 = r5.f9196o;
        r2.reset();
        r2 = r5.f9196o;
        r2.release();
        r5.f9196o = r1;
    L_0x0031:
        r5.f9193l = r4;
        r1 = r0;
        goto L_0x0006;
    L_0x0035:
        r0 = move-exception;
        r2 = f9181a;	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        r3 = "";	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        com.facebook.debug.log.BLog.a(r2, r3, r0);	 Catch:{ RuntimeException -> 0x0035, all -> 0x004d }
        r5.f9192k = r4;
        r0 = r5.f9196o;
        r0.reset();
        r0 = r5.f9196o;
        r0.release();
        r5.f9196o = r1;
        r0 = r1;
        goto L_0x0031;
    L_0x004d:
        r0 = move-exception;
        r5.f9192k = r4;
        r2 = r5.f9196o;
        r2.reset();
        r2 = r5.f9196o;
        r2.release();
        r5.f9196o = r1;
        throw r0;
    L_0x005d:
        r0 = r1;
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.record.AudioRecorder.a(com.facebook.messaging.audio.record.AudioRecorder$Cause):android.net.Uri");
    }

    public static com.facebook.messaging.audio.record.AudioRecorder m9528a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9182p;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.audio.record.AudioRecorder.class;
        monitor-enter(r1);
        r0 = f9182p;	 Catch:{ all -> 0x003a }
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
        r0 = m9529b(r0);	 Catch:{ all -> 0x0035 }
        f9182p = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9182p;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.record.AudioRecorder.a(com.facebook.inject.InjectorLike):com.facebook.messaging.audio.record.AudioRecorder");
    }

    private static AudioRecorder m9529b(InjectorLike injectorLike) {
        return new AudioRecorder(AudioManagerMethodAutoProvider.b(injectorLike), TempFileManager.m8903a(injectorLike), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AudioRecorder(AudioManager audioManager, TempFileManager tempFileManager, AnalyticsLogger analyticsLogger, Clock clock, ExecutorService executorService) {
        this.f9184c = audioManager;
        this.f9185d = tempFileManager;
        this.f9186e = analyticsLogger;
        this.f9187f = clock;
        this.f9188g = new FocusChangeListener(this);
        this.f9189h = executorService;
    }

    public final void m9534a() {
        this.f9183b = 0.0d;
        m9532i();
        try {
            this.f9196o = new MediaRecorder();
            this.f9195n = this.f9185d.m8907a("orca-audio-", ".mp4", Privacy.REQUIRE_PRIVATE);
            this.f9196o.setAudioSource(1);
            this.f9196o.setOutputFormat(2);
            this.f9196o.setAudioEncoder(3);
            this.f9196o.setAudioChannels(1);
            this.f9196o.setAudioSamplingRate(8000);
            this.f9196o.setOutputFile(this.f9195n.getAbsolutePath());
            this.f9196o.prepare();
            if (1 != this.f9184c.requestAudioFocus(this.f9188g, 0, 2)) {
                throw new RuntimeException("Failed to acquire the audio focus.");
            }
            this.f9196o.start();
            this.f9192k = true;
        } catch (Exception e) {
            ExecutorDetour.a(this.f9189h, new 1(this, e), -639289683);
            m9531h();
        }
    }

    public final void m9535b() {
        try {
            if (this.f9192k) {
                this.f9196o.stop();
                this.f9192k = false;
                m9533j();
            }
        } catch (Throwable e) {
            this.f9194m = true;
            BLog.a(f9181a, e, Boolean.toString(this.f9194m), new Object[0]);
        }
        this.f9193l = true;
    }

    public final void m9536c() {
        m9527a(this.f9193l ? Cause.TIME_LIMIT_REACHED_CANCELLED : Cause.CANCELLED);
    }

    public final Uri m9537d() {
        return m9527a(this.f9193l ? Cause.TIME_LIMIT_REACHED_SUCCESS : Cause.SUCCESS);
    }

    private void m9531h() {
        m9527a(Cause.ERROR);
    }

    public final double m9538e() {
        try {
            if (this.f9196o != null && m9539f()) {
                this.f9183b = (((double) this.f9196o.getMaxAmplitude()) * 0.4d) + (0.6d * this.f9183b);
                return this.f9183b;
            }
        } catch (Throwable th) {
            BLog.a(f9181a, "Error occurred when querying the recorder amplitude.", th);
        }
        return 0.0d;
    }

    public final boolean m9539f() {
        return this.f9192k;
    }

    private void m9532i() {
        this.f9190i = this.f9187f.a();
        this.f9191j = 0;
    }

    private void m9533j() {
        this.f9191j = this.f9187f.a() - this.f9190i;
        this.f9190i = 0;
    }

    private static boolean m9530b(Cause cause) {
        return cause == Cause.SUCCESS || cause == Cause.TIME_LIMIT_REACHED_SUCCESS;
    }
}
