package com.facebook.orca.threadview;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.accessibility.AccessibilityManagerCompat;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.android.AccessibilityManagerMethodAutoProvider;
import com.facebook.common.android.ConnectivityManagerMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.errorreporting.SoftErrorBuilder;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.ui.util.ViewOrientationLockHelper;
import com.facebook.common.ui.util.ViewOrientationLockHelperProvider;
import com.facebook.common.util.ColorUtil;
import com.facebook.common.util.SizeUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.iorg.common.upsell.ui.FbZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController;
import com.facebook.iorg.common.zero.ui.ZeroDialogController.Listener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.attachments.AudioAttachmentData;
import com.facebook.messaging.audio.playback.AudioClipPlayer;
import com.facebook.messaging.audio.playback.AudioClipPlayer.Event;
import com.facebook.messaging.audio.playback.AudioClipPlayer.PlaybackListener;
import com.facebook.messaging.audio.playback.AudioClipPlayerQueue;
import com.facebook.messaging.audio.playback.AudioPlayerBubbleView;
import com.facebook.messaging.audio.playback.AudioPlayerBubbleView.Type;
import com.facebook.messaging.audio.playback.AudioUriCache;
import com.facebook.messaging.audio.playback.ClipProgressLayout;
import com.facebook.messaging.audio.playback.FetchAudioExecutor;
import com.facebook.messaging.audio.playback.FetchAudioParams;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.ViewStubHolder;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: message_block_select_cancel_from_blocked_warning_alert */
public class ThreadViewAudioAttachmentView extends CustomViewGroup {
    @Inject
    AudioUriCache f7474a;
    @Inject
    AudioClipPlayerQueue f7475b;
    @Inject
    FetchAudioExecutor f7476c;
    @Inject
    @ForUiThread
    Executor f7477d;
    @Inject
    AnalyticsLogger f7478e;
    @Inject
    AccessibilityManager f7479f;
    @Inject
    ViewOrientationLockHelperProvider f7480g;
    @Inject
    AbstractFbErrorReporter f7481h;
    @Inject
    ZeroDialogController f7482i;
    @Inject
    ConnectivityManager f7483j;
    public final AudioPlayerBubbleView f7484k;
    private final AudioPlayerBubbleView f7485l;
    private final ClipProgressLayout f7486m;
    private ViewStubHolder<ThreadViewAudioAttachmentView> f7487n;
    public FragmentManager f7488o;
    public ViewOrientationLockHelper f7489p;
    private final PlaybackListener f7490q;
    public AudioClipPlayer f7491r;
    public ListenableFuture<Uri> f7492s;
    public AudioState f7493t;
    public AudioAttachmentData f7494u;
    private Uri f7495v;
    private long f7496w;

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    class C11201 implements PlaybackListener {
        final /* synthetic */ ThreadViewAudioAttachmentView f7464a;

        C11201(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
            this.f7464a = threadViewAudioAttachmentView;
        }

        public final void m7105a(Event event) {
            switch (C11267.f7472a[event.ordinal()]) {
                case 1:
                case 2:
                    this.f7464a.f7493t;
                    this.f7464a.f7489p.a();
                    return;
                case 3:
                    this.f7464a.m7136b();
                    return;
                case 4:
                case 5:
                case 6:
                    this.f7464a.f7488o;
                    this.f7464a.f7489p.b();
                    return;
                case 7:
                    this.f7464a.f7493t;
                    this.f7464a.f7489p.b();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    class C11212 implements OnClickListener {
        final /* synthetic */ ThreadViewAudioAttachmentView f7465a;

        C11212(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
            this.f7465a = threadViewAudioAttachmentView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2141102872);
            if (this.f7465a.f7493t != AudioState.DOWNLOADED) {
                this.f7465a.f7482i.a(ZeroFeatureKey.AUDIO_PLAY_INTERSTITIAL, this.f7465a.f7488o);
            } else {
                this.f7465a.m7120c();
            }
            LogUtils.a(-374415759, a);
        }
    }

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    class C11223 implements OnLongClickListener {
        final /* synthetic */ ThreadViewAudioAttachmentView f7466a;

        C11223(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
            this.f7466a = threadViewAudioAttachmentView;
        }

        public boolean onLongClick(View view) {
            return view.showContextMenu();
        }
    }

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    class C11234 implements Listener {
        final /* synthetic */ ThreadViewAudioAttachmentView f7467a;

        C11234(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
            this.f7467a = threadViewAudioAttachmentView;
        }

        public final void m7107a(Object obj) {
            if (this.f7467a.f7493t != AudioState.DOWNLOADED) {
                this.f7467a.f7488o;
                this.f7467a.m7118b(this.f7467a.f7494u.b);
            }
            this.f7467a.m7120c();
        }

        public final void m7106a() {
        }
    }

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    /* synthetic */ class C11267 {
        static final /* synthetic */ int[] f7472a = new int[Event.values().length];

        static {
            f7473b = new int[AudioState.values().length];
            try {
                f7473b[AudioState.DOWNLOADED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7473b[AudioState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f7472a[Event.PLAYBACK_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f7472a[Event.PLAYBACK_RESUMED.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f7472a[Event.PLAYBACK_POSITION_UPDATED.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f7472a[Event.PLAYBACK_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f7472a[Event.PLAYBACK_ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f7472a[Event.PLAYBACK_STOPPED.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f7472a[Event.PLAYBACK_PAUSED.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: message_block_select_cancel_from_blocked_warning_alert */
    enum AudioState {
        INIT,
        DOWNLOADED,
        ERROR
    }

    private static <T extends View> void m7115a(Class<T> cls, T t) {
        m7116a((Object) t, t.getContext());
    }

    private static void m7116a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ThreadViewAudioAttachmentView) obj).m7112a(AudioUriCache.a(fbInjector), AudioClipPlayerQueue.a(fbInjector), FetchAudioExecutor.a(fbInjector), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector), AccessibilityManagerMethodAutoProvider.b(fbInjector), (ViewOrientationLockHelperProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(ViewOrientationLockHelperProvider.class), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), (ZeroDialogController) FbZeroDialogController.b(fbInjector), ConnectivityManagerMethodAutoProvider.b(fbInjector));
    }

    private void m7112a(AudioUriCache audioUriCache, AudioClipPlayerQueue audioClipPlayerQueue, FetchAudioExecutor fetchAudioExecutor, Executor executor, AnalyticsLogger analyticsLogger, AccessibilityManager accessibilityManager, ViewOrientationLockHelperProvider viewOrientationLockHelperProvider, AbstractFbErrorReporter abstractFbErrorReporter, ZeroDialogController zeroDialogController, ConnectivityManager connectivityManager) {
        this.f7474a = audioUriCache;
        this.f7475b = audioClipPlayerQueue;
        this.f7476c = fetchAudioExecutor;
        this.f7477d = executor;
        this.f7478e = analyticsLogger;
        this.f7479f = accessibilityManager;
        this.f7480g = viewOrientationLockHelperProvider;
        this.f7481h = abstractFbErrorReporter;
        this.f7482i = zeroDialogController;
        this.f7483j = connectivityManager;
    }

    public ThreadViewAudioAttachmentView(Context context) {
        this(context, null);
    }

    public ThreadViewAudioAttachmentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7490q = new C11201(this);
        this.f7493t = AudioState.INIT;
        this.f7496w = -1;
        m7115a(ThreadViewAudioAttachmentView.class, (View) this);
        this.f7489p = this.f7480g.a(this);
        setContentView(2130905567);
        this.f7484k = (AudioPlayerBubbleView) getView(2131564447);
        this.f7485l = (AudioPlayerBubbleView) getView(2131564450);
        this.f7486m = (ClipProgressLayout) getView(2131564449);
        OnClickListener c11212 = new C11212(this);
        this.f7484k.setOnClickListener(c11212);
        this.f7485l.setOnClickListener(c11212);
        this.f7487n = ViewStubHolder.a((ViewStubCompat) getView(2131564448));
        OnLongClickListener c11223 = new C11223(this);
        this.f7484k.setOnLongClickListener(c11223);
        this.f7485l.setOnLongClickListener(c11223);
        this.f7484k.setContentDescription(getResources().getString(2131231618));
        this.f7482i.a(ZeroFeatureKey.AUDIO_PLAY_INTERSTITIAL, getContext().getString(2131232934), new C11234(this));
    }

    public void setForMeUser(boolean z) {
        this.f7484k.setType(z ? Type.SELF_NORMAL : Type.OTHER_NORMAL);
        this.f7485l.setType(z ? Type.SELF_HIGHLIGHTED : Type.OTHER_HIGHLIGHTED);
    }

    public void setHasText(boolean z) {
        if (z) {
            this.f7487n.f();
        } else {
            this.f7487n.e();
        }
    }

    public void setColor(int i) {
        this.f7484k.setColor(i);
        this.f7485l.setColor(ColorUtil.a(i, 0.8f));
    }

    protected void onMeasure(int i, int i2) {
        if (MeasureSpec.getMode(i) == 0) {
            super.onMeasure(i, i2);
            return;
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        super.onMeasure(MeasureSpec.makeMeasureSpec(m7108a(MeasureSpec.getSize(i) - paddingLeft) + paddingLeft, 1073741824), i2);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (AccessibilityManagerCompat.b(this.f7479f) && m7120c()) {
            return true;
        }
        return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public void setAudioAttachmentData(AudioAttachmentData audioAttachmentData) {
        Preconditions.checkNotNull(audioAttachmentData);
        if (!Objects.equal(this.f7494u, audioAttachmentData)) {
            this.f7494u = audioAttachmentData;
            this.f7493t = AudioState.INIT;
            this.f7496w = this.f7494u.a;
            if (this.f7496w > 60000000) {
                String str = "Invalid audio attachment duration: " + this.f7496w;
                BLog.b("ThreadViewAudioAttachmentView", str);
                this.f7481h.a(SoftError.b("t6487242", str));
                this.f7496w = -1;
            }
            m7110a(this.f7496w);
            if (this.f7491r != null) {
                this.f7491r.b(this.f7490q);
                this.f7491r = null;
            }
            Uri uri = this.f7494u.b;
            if (uri == null) {
                this.f7488o;
                this.f7484k.setIsLoading(true);
            } else {
                Uri uri2 = (Uri) this.f7474a.a.a(uri);
                if (uri2 == null) {
                    NetworkInfo networkInfo = this.f7483j.getNetworkInfo(1);
                    if (this.f7482i.a(ZeroFeatureKey.AUDIO_PLAY_INTERSTITIAL) || networkInfo == null || !networkInfo.isConnected() || !networkInfo.isAvailable()) {
                        this.f7484k.setIsLoading(false);
                        m7129g();
                    } else {
                        this.f7488o;
                        m7118b(uri);
                    }
                } else {
                    m7111a(uri2);
                    m7134a();
                    this.f7484k.setIsLoading(false);
                }
            }
            requestLayout();
        }
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.f7488o = fragmentManager;
    }

    public final void m7134a() {
        if (m7120c()) {
            this.f7493t;
        } else {
            this.f7488o;
        }
    }

    private void m7111a(Uri uri) {
        AudioClipPlayer audioClipPlayer;
        this.f7495v = uri;
        this.f7484k.setIsLoading(false);
        this.f7493t = AudioState.DOWNLOADED;
        AudioClipPlayerQueue audioClipPlayerQueue = this.f7475b;
        if (audioClipPlayerQueue.g == null || !com.facebook.common.internal.Objects.a(audioClipPlayerQueue.g.h, uri)) {
            for (AudioClipPlayer audioClipPlayer2 : audioClipPlayerQueue.d) {
                if (com.facebook.common.internal.Objects.a(audioClipPlayer2.h, uri)) {
                    break;
                }
            }
            audioClipPlayer2 = null;
        } else {
            audioClipPlayer2 = audioClipPlayerQueue.g;
        }
        AudioClipPlayer audioClipPlayer3 = audioClipPlayer2;
        if (audioClipPlayer3 != null) {
            audioClipPlayer3.a(this.f7490q);
            this.f7491r = audioClipPlayer3;
            m7136b();
        }
    }

    private int m7108a(int i) {
        int max = Math.max(SizeUtil.a(getContext(), 100.0f), getSuggestedMinimumWidth());
        if (i <= 0) {
            return max;
        }
        return Math.min(Math.max(max, ((int) ((1.0d - Math.pow(10.0d, (Math.max(5000.0d, (double) (this.f7496w == -1 ? 0 : this.f7496w)) / 1000.0d) / -30.0d)) * ((double) (i - max)))) + max), i);
    }

    private void m7120c() {
        AnalyticsLogger analyticsLogger;
        HoneyClientEvent honeyClientEvent;
        switch (this.f7493t) {
            case DOWNLOADED:
                if (!m7120c()) {
                    analyticsLogger = this.f7478e;
                    honeyClientEvent = new HoneyClientEvent("audio_clips_playback_start");
                    honeyClientEvent.c = "audio_clips";
                    analyticsLogger.a(honeyClientEvent);
                    this.f7491r = this.f7475b.a(this.f7495v);
                    this.f7491r.a(this.f7490q);
                    return;
                } else if (this.f7491r.f()) {
                    this.f7491r.e();
                    analyticsLogger = this.f7478e;
                    honeyClientEvent = new HoneyClientEvent("audio_clips_playback_resume");
                    honeyClientEvent.c = "audio_clips";
                    analyticsLogger.a(honeyClientEvent);
                    return;
                } else {
                    this.f7491r.d();
                    analyticsLogger = this.f7478e;
                    honeyClientEvent = new HoneyClientEvent("audio_clips_playback_pause");
                    honeyClientEvent.c = "audio_clips";
                    analyticsLogger.a(honeyClientEvent);
                    return;
                }
            case ERROR:
                analyticsLogger = this.f7478e;
                honeyClientEvent = new HoneyClientEvent("audio_clips_playback_error");
                honeyClientEvent.c = "audio_clips";
                analyticsLogger.a(honeyClientEvent);
                Toast.makeText(getContext(), getContext().getString(2131231614), 0).show();
                return;
            default:
                return;
        }
    }

    public static void m7123d(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
        boolean z;
        boolean z2 = true;
        AudioPlayerBubbleView audioPlayerBubbleView = threadViewAudioAttachmentView.f7484k;
        if (threadViewAudioAttachmentView.f7491r.f()) {
            z = false;
        } else {
            z = true;
        }
        audioPlayerBubbleView.setIsPlaying(z);
        AudioPlayerBubbleView audioPlayerBubbleView2 = threadViewAudioAttachmentView.f7485l;
        if (threadViewAudioAttachmentView.f7491r.f()) {
            z2 = false;
        }
        audioPlayerBubbleView2.setIsPlaying(z2);
    }

    public static void m7125e(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
        threadViewAudioAttachmentView.m7129g();
        if (threadViewAudioAttachmentView.f7493t == AudioState.DOWNLOADED) {
            threadViewAudioAttachmentView.f7484k.setIsPlaying(false);
            threadViewAudioAttachmentView.f7485l.setIsPlaying(false);
        }
    }

    public static boolean m7127f(ThreadViewAudioAttachmentView threadViewAudioAttachmentView) {
        if (!(threadViewAudioAttachmentView.f7495v == null || threadViewAudioAttachmentView.f7491r == null || !threadViewAudioAttachmentView.f7491r.h.equals(threadViewAudioAttachmentView.f7495v))) {
            if ((threadViewAudioAttachmentView.f7491r.i != null ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    private void m7129g() {
        m7110a(this.f7496w);
        this.f7486m.setProgress(0.0d);
    }

    public final void m7136b() {
        boolean z = true;
        if (this.f7491r == null) {
            String str = "Invalid audio clip player: { state: %s, hasData: %b, hasUri: %b }";
            Object[] objArr = new Object[3];
            objArr[0] = this.f7493t;
            objArr[1] = Boolean.valueOf(this.f7494u != null);
            if (this.f7495v == null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            String a = StringFormatUtil.a(str, objArr);
            BLog.b("ThreadViewAudioAttachmentView", a);
            this.f7481h.a(SoftError.b("t6691775", a));
            m7129g();
            return;
        }
        int duration;
        int a2 = this.f7491r.e.a();
        AudioClipPlayer audioClipPlayer = this.f7491r;
        if (audioClipPlayer.i != null) {
            duration = audioClipPlayer.i.getDuration();
        } else {
            duration = 0;
        }
        int i = duration;
        long j = ((long) i) - ((((long) a2) / 1000) * 1000);
        if (j > 60000000) {
            a = StringFormatUtil.a("Invalid audio clip progress: (%dms of %dms)", new Object[]{Integer.valueOf(a2), Integer.valueOf(i)});
            SoftErrorBuilder a3 = SoftError.a("t6487242", a);
            a3.e = 10000;
            SoftError g = a3.g();
            BLog.b("ThreadViewAudioAttachmentView", a);
            this.f7481h.a(g);
            m7110a(-1);
            return;
        }
        m7110a(j);
        this.f7486m.setProgress(((double) a2) / ((double) i));
    }

    private void m7110a(long j) {
        this.f7484k.setTimerDuration(j);
        this.f7485l.setTimerDuration(j);
    }

    private void m7118b(Uri uri) {
        if (this.f7492s != null) {
            this.f7492s.cancel(false);
        }
        this.f7492s = this.f7476c.a(new FetchAudioParams(uri));
        final ListenableFuture listenableFuture = this.f7492s;
        Futures.a(listenableFuture, new FutureCallback<Uri>(this) {
            final /* synthetic */ ThreadViewAudioAttachmentView f7469b;

            public void onSuccess(Object obj) {
                Uri uri = (Uri) obj;
                if (listenableFuture == this.f7469b.f7492s) {
                    this.f7469b.m7111a(uri);
                    this.f7469b.m7134a();
                }
            }

            public void onFailure(Throwable th) {
                if (listenableFuture == this.f7469b.f7492s) {
                    BLog.b("ThreadViewAudioAttachmentView", "downloading audio failed!", th);
                    this.f7469b.f7484k.setIsLoading(false);
                    this.f7469b.f7484k.setTimerDuration(-1);
                    this.f7469b.f7493t = AudioState.ERROR;
                    AnalyticsLogger analyticsLogger = this.f7469b.f7478e;
                    HoneyClientEvent b = new HoneyClientEvent("audio_clips_download_error").b("error_message", th.toString());
                    b.c = "audio_clips";
                    analyticsLogger.a(b);
                }
            }
        }, this.f7477d);
        this.f7484k.setIsLoading(true);
    }

    public final void m7135a(final MessageItemView messageItemView) {
        OnLongClickListener c11256 = new OnLongClickListener(this) {
            final /* synthetic */ ThreadViewAudioAttachmentView f7471b;

            public boolean onLongClick(View view) {
                if (this.f7471b.f7493t == AudioState.DOWNLOADED && this.f7471b.m7120c()) {
                    this.f7471b.f7491r.d();
                }
                messageItemView.m6758a(null);
                return true;
            }
        };
        this.f7484k.setOnLongClickListener(c11256);
        this.f7485l.setOnLongClickListener(c11256);
    }
}
