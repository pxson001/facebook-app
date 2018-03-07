package com.facebook.rtc.voicemail;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.net.Uri.Builder;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.application.FbAppType;
import com.facebook.config.application.Product;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.messaging.audio.record.AudioRecorder;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.ExposureLogging;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.activities.WebrtcIncallActivity.16;
import com.facebook.rtc.activities.WebrtcIncallActivity.17;
import com.facebook.rtc.assetdownloader.AssetDownloader;
import com.facebook.rtc.assetdownloader.DownloadListener;
import com.facebook.rtc.fbwebrtc.abtests.ExperimentsForRtcModule;
import com.facebook.rtc.interfaces.VoipMessageCreator;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.xconfig.core.XConfigReader;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: locales */
public class VoicemailHandler implements OnCompletionListener, INeedInit, DownloadListener {
    private static final Class<?> f9161a = VoicemailHandler.class;
    public static final CallerContext f9162b = CallerContext.a(VoicemailHandler.class, "voip_voicemail_audio");
    private static volatile VoicemailHandler f9163t;
    public final AudioRecorder f9164c;
    private final Context f9165d;
    private final WebrtcLoggingHandler f9166e;
    public final AssetDownloader f9167f;
    private final Lazy<ExecutorService> f9168g;
    private final QeAccessor f9169h;
    public final VoicemailAssetUrlFetcher f9170i;
    public final DefaultAndroidThreadUtil f9171j;
    private final FbAppType f9172k;
    private boolean f9173l = false;
    public boolean f9174m;
    private MediaPlayer f9175n;
    public String f9176o;
    private File f9177p;
    public File f9178q;
    public 16 f9179r;
    public 17 f9180s;

    public static com.facebook.rtc.voicemail.VoicemailHandler m9510a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9163t;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.voicemail.VoicemailHandler.class;
        monitor-enter(r1);
        r0 = f9163t;	 Catch:{ all -> 0x003a }
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
        r0 = m9513b(r0);	 Catch:{ all -> 0x0035 }
        f9163t = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9163t;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.voicemail.VoicemailHandler.a(com.facebook.inject.InjectorLike):com.facebook.rtc.voicemail.VoicemailHandler");
    }

    private static VoicemailHandler m9513b(InjectorLike injectorLike) {
        return new VoicemailHandler(AudioRecorder.m9528a(injectorLike), (Context) injectorLike.getInstance(Context.class), WebrtcLoggingHandler.m9451a(injectorLike), AssetDownloader.m9542b(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3832), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), new VoicemailAssetUrlFetcher((FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), XConfigReader.a(injectorLike)), DefaultAndroidThreadUtil.b(injectorLike), (FbAppType) injectorLike.getInstance(FbAppType.class));
    }

    @Inject
    public VoicemailHandler(AudioRecorder audioRecorder, Context context, WebrtcLoggingHandler webrtcLoggingHandler, AssetDownloader assetDownloader, Lazy<ExecutorService> lazy, QeAccessor qeAccessor, VoicemailAssetUrlFetcher voicemailAssetUrlFetcher, AndroidThreadUtil androidThreadUtil, FbAppType fbAppType) {
        this.f9164c = audioRecorder;
        this.f9165d = context;
        this.f9166e = webrtcLoggingHandler;
        this.f9167f = assetDownloader;
        this.f9168g = lazy;
        this.f9169h = qeAccessor;
        this.f9170i = voicemailAssetUrlFetcher;
        this.f9171j = androidThreadUtil;
        this.f9172k = fbAppType;
    }

    public void init() {
        m9520b();
    }

    public final void m9520b() {
        boolean z;
        if (this.f9172k.j == Product.MESSENGER) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.f9169h.a(Liveness.Cached, ExposureLogging.Off, ExperimentsForRtcModule.dc, false)) {
            ExecutorDetour.a((ExecutorService) this.f9168g.get(), new 1(this), -1729126422);
        }
    }

    public final void mo737a(String str, File file) {
        this.f9176o = str;
        this.f9177p = file;
    }

    public final void mo736a() {
    }

    public final boolean m9521c() {
        this.f9173l = false;
        this.f9174m = true;
        this.f9176o = this.f9170i.m9552b();
        this.f9177p = this.f9167f.m9545a(this.f9176o);
        boolean k = m9515k();
        this.f9166e.m9480a("voicemail_prompt_started", k);
        return k;
    }

    public final void m9522d() {
        m9512a(m9509a(2131165213), "final_tone", "3", 1.0f, null);
        m9523e();
    }

    public final void m9523e() {
        if (this.f9164c.f9192k) {
            long j;
            this.f9164c.m9535b();
            Uri d = this.f9164c.m9537d();
            if (!(this.f9180s == null || d == null || this.f9164c.f9191j <= 2000)) {
                17 17 = this.f9180s;
                j = this.f9164c.f9191j;
                VoipMessageCreator voipMessageCreator = 17.a.A;
                long j2 = 17.a.ai;
                this.f9166e.m9480a("voicemail_recorded", true);
                this.f9166e.m9484b("voicemail_duration", this.f9164c.f9191j);
            }
            j = 0;
            this.f9166e.logCallAction(0, j, "voicemail", String.valueOf(this.f9164c.f9191j));
            this.f9174m = false;
            return;
        }
        this.f9173l = true;
        this.f9174m = false;
    }

    public final void m9524f() {
        m9514j();
        if (this.f9164c.f9192k) {
            this.f9164c.m9536c();
            this.f9166e.logCallAction(0, 0, "voicemail", "cancel");
        }
        this.f9174m = false;
    }

    public final void m9518a(File file) {
        this.f9178q = file;
    }

    private void m9514j() {
        if (this.f9175n != null) {
            if (this.f9175n.isPlaying()) {
                this.f9175n.stop();
            }
            this.f9175n.reset();
            this.f9175n.release();
            this.f9175n = null;
        }
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m9514j();
        if (this.f9173l) {
            this.f9166e.logCallAction(0, 0, "voicemail", "early_cancel");
        } else if (this.f9179r != null) {
            this.f9166e.m9480a("voicemail_prompt_finished", true);
            this.f9164c.m9534a();
            this.f9179r.a();
        } else {
            this.f9166e.logCallAction(0, 0, "voicemail", "null_listener");
        }
    }

    private boolean m9515k() {
        Uri fromFile;
        2 2 = new 2(this);
        if (this.f9177p != null) {
            fromFile = Uri.fromFile(this.f9177p);
        } else {
            fromFile = m9509a(2131165308);
        }
        return m9512a(fromFile, "greeting", "1", 0.3f, 2);
    }

    public static boolean m9516l(VoicemailHandler voicemailHandler) {
        return voicemailHandler.m9512a(voicemailHandler.m9509a(2131165309), "tone", "2", 0.1f, voicemailHandler);
    }

    private boolean m9512a(Uri uri, String str, String str2, float f, OnCompletionListener onCompletionListener) {
        this.f9175n = new MediaPlayer();
        this.f9175n.setAudioStreamType(0);
        this.f9175n.setOnErrorListener(new VoicemailErrorListener(this, str));
        this.f9175n.setVolume(f, f);
        try {
            this.f9175n.setDataSource(this.f9165d, uri);
            this.f9175n.prepare();
            if (onCompletionListener != null) {
                this.f9175n.setOnCompletionListener(onCompletionListener);
            }
            this.f9175n.start();
            return true;
        } catch (Exception e) {
            m9511a(this, str2);
            if (this.f9177p == null) {
                return false;
            }
            this.f9177p.getName();
            this.f9177p.delete();
            return false;
        }
    }

    private Uri m9509a(int i) {
        Resources resources = this.f9165d.getResources();
        return new Builder().scheme("android.resource").authority(resources.getResourcePackageName(i)).appendPath(resources.getResourceTypeName(i)).appendPath(resources.getResourceEntryName(i)).build();
    }

    public static void m9511a(VoicemailHandler voicemailHandler, String str) {
        voicemailHandler.f9166e.logCallAction(0, 0, "voicemail_error", str);
        voicemailHandler.f9174m = false;
    }
}
