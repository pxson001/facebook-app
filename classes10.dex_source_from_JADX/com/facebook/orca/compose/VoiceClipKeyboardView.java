package com.facebook.orca.compose;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl.DisableSwipeToOpenDrawerInterceptor;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.messaging.audio.composer.AudioComposerContentView;
import com.facebook.messaging.audio.composer.AudioComposerContentView.AudioComposerCallback;
import com.facebook.messaging.audio.playback.AudioClipPlayerQueue;
import com.facebook.messaging.audio.record.AudioRecorder;
import com.facebook.messaging.audio.record.AudioRecorderAsync;
import com.facebook.messaging.keyboard.PermissionRequestKeyboardView;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.runtimepermissions.RequestPermissionsPrefKeys;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.facebook.ui.media.attachments.MediaResourceUtil;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.ViewStubHolder;
import com.facebook.widget.ViewStubHolder.OnInflateListener;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: org.torproject.android.intent.action.START */
public class VoiceClipKeyboardView extends CustomFrameLayout {
    public AudioRecorderAsync f5683a;
    private AudioClipPlayerQueue f5684b;
    private AnalyticsLogger f5685c;
    private FbSharedPreferences f5686d;
    private MediaResourceUtil f5687e;
    private RuntimePermissionsUtil f5688f;
    private ViewOrientationLockHelper f5689g;
    public Handler f5690h;
    public AudioComposerContentView f5691i;
    private ViewStubHolder<PermissionRequestKeyboardView> f5692j;
    public Listener f5693k;
    public ThreadKey f5694l;
    private ThreadKey f5695m;
    public final Runnable f5696n = new C08141(this);

    /* compiled from: org.torproject.android.intent.action.START */
    public interface Listener {
        void mo161a(MediaResource mediaResource, ThreadKey threadKey);

        void mo162a(String[] strArr);
    }

    /* compiled from: org.torproject.android.intent.action.START */
    class C08141 implements Runnable {
        final /* synthetic */ VoiceClipKeyboardView f5678a;

        C08141(VoiceClipKeyboardView voiceClipKeyboardView) {
            this.f5678a = voiceClipKeyboardView;
        }

        public void run() {
            this.f5678a.f5691i.setVolumeLevel(this.f5678a.f5683a.c.e());
            HandlerDetour.b(this.f5678a.f5690h, this, 50, -585456895);
        }
    }

    /* compiled from: org.torproject.android.intent.action.START */
    class C08162 implements OnInflateListener<PermissionRequestKeyboardView> {
        final /* synthetic */ VoiceClipKeyboardView f5680a;

        /* compiled from: org.torproject.android.intent.action.START */
        class C08151 implements OnClickListener {
            final /* synthetic */ C08162 f5679a;

            C08151(C08162 c08162) {
                this.f5679a = c08162;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1267561712);
                if (this.f5679a.f5680a.f5693k != null) {
                    this.f5679a.f5680a.f5693k.mo162a(new String[]{"android.permission.RECORD_AUDIO"});
                }
                Logger.a(2, EntryType.UI_INPUT_END, -369004159, a);
            }
        }

        C08162(VoiceClipKeyboardView voiceClipKeyboardView) {
            this.f5680a = voiceClipKeyboardView;
        }

        public final void m5359a(View view) {
            ((PermissionRequestKeyboardView) view).setButtonListener(new C08151(this));
        }
    }

    /* compiled from: org.torproject.android.intent.action.START */
    class C08173 implements AudioComposerCallback {
        final /* synthetic */ VoiceClipKeyboardView f5681a;

        C08173(VoiceClipKeyboardView voiceClipKeyboardView) {
            this.f5681a = voiceClipKeyboardView;
        }

        public final void m5360a() {
            this.f5681a.f5683a.b();
            HandlerDetour.a(this.f5681a.f5690h, this.f5681a.f5696n, -1495693884);
        }

        public final void m5361b() {
            this.f5681a.f5683a.e();
            HandlerDetour.a(this.f5681a.f5690h, this.f5681a.f5696n);
            this.f5681a.f5691i.setVolumeLevel(0.0d);
        }

        public final void m5362c() {
            this.f5681a.f5683a.d();
            HandlerDetour.a(this.f5681a.f5690h, this.f5681a.f5696n);
            this.f5681a.f5691i.setVolumeLevel(0.0d);
        }

        public final void m5363d() {
            this.f5681a.f5683a.c();
            HandlerDetour.a(this.f5681a.f5690h, this.f5681a.f5696n);
            this.f5681a.f5691i.setVolumeLevel(0.0d);
        }
    }

    /* compiled from: org.torproject.android.intent.action.START */
    public class C08184 {
        final /* synthetic */ VoiceClipKeyboardView f5682a;

        C08184(VoiceClipKeyboardView voiceClipKeyboardView) {
            this.f5682a = voiceClipKeyboardView;
        }

        public final void m5364a() {
            this.f5682a.f5691i.c();
            this.f5682a.m5381g();
        }

        public final void m5366b() {
            this.f5682a.f5691i.d();
        }

        public final void m5365a(@Nullable MediaResource mediaResource) {
            if (mediaResource == null) {
                this.f5682a.f5691i.f();
                VoiceClipKeyboardView.m5383h(this.f5682a);
                return;
            }
            MediaResourceBuilder a = MediaResource.a().a(mediaResource);
            a.c = Source.VOICE_CLIP;
            this.f5682a.m5370a(a.C());
        }
    }

    private static <T extends View> void m5371a(Class<T> cls, T t) {
        m5372a((Object) t, t.getContext());
    }

    private static void m5372a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        VoiceClipKeyboardView voiceClipKeyboardView = (VoiceClipKeyboardView) obj;
        AudioRecorderAsync audioRecorderAsync = new AudioRecorderAsync(DefaultSerialListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.b(fbInjector), DefaultAndroidThreadUtil.b(fbInjector), AudioRecorder.a(fbInjector));
        AudioClipPlayerQueue a = AudioClipPlayerQueue.a(fbInjector);
        AnalyticsLogger a2 = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) FbSharedPreferencesImpl.a(fbInjector);
        MediaResourceUtil a3 = MediaResourceUtil.a(fbInjector);
        RuntimePermissionsUtil b = RuntimePermissionsUtil.b(fbInjector);
        ViewOrientationLockHelperProvider viewOrientationLockHelperProvider = (ViewOrientationLockHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class);
        Toaster.b(fbInjector);
        Handler b2 = Handler_ForUiThreadMethodAutoProvider.b(fbInjector);
        SystemClockMethodAutoProvider.a(fbInjector);
        voiceClipKeyboardView.m5368a(audioRecorderAsync, a, a2, fbSharedPreferences, a3, b, viewOrientationLockHelperProvider, b2);
    }

    public VoiceClipKeyboardView(Context context) {
        super(context);
        m5378e();
    }

    public VoiceClipKeyboardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m5378e();
    }

    public VoiceClipKeyboardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5378e();
    }

    private void m5378e() {
        setContentView(2130905565);
        m5371a(VoiceClipKeyboardView.class, (View) this);
        setFocusableInTouchMode(true);
        this.f5691i = (AudioComposerContentView) c(2131559749);
        this.f5692j = ViewStubHolder.a((ViewStubCompat) c(2131564439));
        this.f5692j.c = new C08162(this);
        this.f5691i.H = new C08173(this);
        this.f5683a.g = new C08184(this);
    }

    @Inject
    private void m5368a(AudioRecorderAsync audioRecorderAsync, AudioClipPlayerQueue audioClipPlayerQueue, AnalyticsLogger analyticsLogger, FbSharedPreferences fbSharedPreferences, MediaResourceUtil mediaResourceUtil, RuntimePermissionsUtil runtimePermissionsUtil, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider, Handler handler) {
        this.f5683a = audioRecorderAsync;
        this.f5684b = audioClipPlayerQueue;
        this.f5685c = analyticsLogger;
        this.f5686d = fbSharedPreferences;
        this.f5687e = mediaResourceUtil;
        this.f5688f = runtimePermissionsUtil;
        this.f5689g = viewOrientationLockHelperProvider.a(this);
        this.f5690h = handler;
    }

    final void m5388a() {
        AnalyticsLogger analyticsLogger = this.f5685c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("audio_clips_show_composer");
        honeyClientEvent.c = "audio_clips";
        analyticsLogger.a(honeyClientEvent);
        requestFocus();
        this.f5691i.b();
        m5379f();
    }

    private void m5379f() {
        if (VERSION.SDK_INT <= 21 || this.f5688f.a("android.permission.RECORD_AUDIO")) {
            if (VERSION.SDK_INT > 21) {
                this.f5691i.setImportantForAccessibility(0);
            }
            this.f5692j.e();
            return;
        }
        this.f5691i.setImportantForAccessibility(4);
        this.f5692j.f();
    }

    final void m5390b() {
        AudioComposerContentView.q(this.f5691i);
        this.f5689g.b();
    }

    void setThreadKey(ThreadKey threadKey) {
        this.f5694l = threadKey;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        this.f5683a.e();
        return super.onKeyDown(i, keyEvent);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1249787241);
        super.onDetachedFromWindow();
        this.f5683a.e();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1427940258, a);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onWindowFocusChanged(boolean z) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1219881585);
        super.onWindowFocusChanged(z);
        if (!z) {
            this.f5683a.e();
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 22003120, a);
    }

    public void setListener(Listener listener) {
        this.f5693k = listener;
    }

    private void m5381g() {
        this.f5689g.a();
        setKeepScreenOn(true);
        m5384i();
        AudioClipPlayerQueue audioClipPlayerQueue = this.f5684b;
        if (audioClipPlayerQueue.g != null) {
            audioClipPlayerQueue.h = false;
            audioClipPlayerQueue.g.d();
        }
        this.f5695m = this.f5694l;
    }

    private void m5370a(MediaResource mediaResource) {
        setKeepScreenOn(false);
        m5374b(mediaResource);
        m5386k();
    }

    public static void m5383h(VoiceClipKeyboardView voiceClipKeyboardView) {
        voiceClipKeyboardView.setKeepScreenOn(false);
        AnalyticsLogger analyticsLogger = voiceClipKeyboardView.f5685c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("audio_clips_cancelled_by_user");
        honeyClientEvent.c = "audio_clips";
        analyticsLogger.a(honeyClientEvent);
        voiceClipKeyboardView.m5386k();
    }

    private void m5374b(MediaResource mediaResource) {
        AnalyticsLogger analyticsLogger = this.f5685c;
        HoneyClientEvent honeyClientEvent = new HoneyClientEvent("audio_clips_send");
        honeyClientEvent.c = "audio_clips";
        analyticsLogger.a(honeyClientEvent);
        if (MediaResourceUtil.a(mediaResource)) {
            this.f5693k.mo161a(mediaResource, this.f5695m);
            return;
        }
        Toast.makeText(getContext(), getContext().getString(2131231620), 0).show();
        analyticsLogger = this.f5685c;
        honeyClientEvent = new HoneyClientEvent("audio_clips_creation_failed").b("error_message", "The attachment instance for audio clip can't be created.");
        honeyClientEvent.c = "audio_clips";
        analyticsLogger.a(honeyClientEvent);
    }

    private void m5384i() {
        if (getContext() instanceof DivebarEnabledActivity) {
            DrawerBasedDivebarControllerImpl f = ((DivebarEnabledActivity) getContext()).f();
            if (f != null && f.e() && f.l == null) {
                f.l = new DisableSwipeToOpenDrawerInterceptor();
                f.d.a(f.l);
            }
        }
    }

    private void m5385j() {
        if (getContext() instanceof DivebarEnabledActivity) {
            DrawerBasedDivebarControllerImpl f = ((DivebarEnabledActivity) getContext()).f();
            if (f != null) {
                f.i();
            }
        }
    }

    private void m5386k() {
        this.f5689g.b();
        m5385j();
    }

    public final void m5389a(Map<String, Integer> map) {
        Integer num = (Integer) map.get("android.permission.RECORD_AUDIO");
        if (num != null) {
            switch (num.intValue()) {
                case 0:
                    this.f5692j.e();
                    return;
                case 1:
                    this.f5686d.edit().putBoolean(RequestPermissionsPrefKeys.a, false).commit();
                    return;
                case 2:
                    m5387l();
                    return;
                default:
                    return;
            }
        }
    }

    private void m5387l() {
        if (this.f5686d.a(RequestPermissionsPrefKeys.a, false)) {
            this.f5688f.b();
        } else {
            this.f5686d.edit().putBoolean(RequestPermissionsPrefKeys.a, true).commit();
        }
    }
}
