package com.facebook.rtc.audio;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.qe.api.QeAccessor;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.C22981;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import com.facebook.rtc.prefs.VoipPrefKeys;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

/* compiled from: audio_file */
public class RtcAudioHandler implements OnCompletionListener, OnPreparedListener {
    private static final Class<?> f19232a = RtcAudioHandler.class;
    private final Context f19233b;
    private final ScheduledExecutorService f19234c;
    private final FbSharedPreferences f19235d;
    private final DefaultAndroidThreadUtil f19236e;
    private final Resources f19237f;
    public final RtcAudioFocusHandler f19238g;
    public final C22981 f19239h;
    private final QeAccessor f19240i;
    public boolean f19241j;
    public MediaPlayer f19242k;
    private Future f19243l;
    public boolean f19244m;
    public boolean f19245n = false;

    /* compiled from: audio_file */
    public class C22721 {
        public final /* synthetic */ RtcAudioHandler f19220a;

        C22721(RtcAudioHandler rtcAudioHandler) {
            this.f19220a = rtcAudioHandler;
        }
    }

    /* compiled from: audio_file */
    class C22732 implements Runnable {
        final /* synthetic */ RtcAudioHandler f19221a;

        C22732(RtcAudioHandler rtcAudioHandler) {
            this.f19221a = rtcAudioHandler;
        }

        public void run() {
            if (!this.f19221a.f19244m) {
                this.f19221a.f19244m = true;
                this.f19221a.m19281a(Tone.SEARCHING);
            }
        }
    }

    /* compiled from: audio_file */
    class C22754 implements OnCompletionListener {
        final /* synthetic */ RtcAudioHandler f19226a;

        C22754(RtcAudioHandler rtcAudioHandler) {
            this.f19226a = rtcAudioHandler;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f19226a.m19281a(Tone.SEARCHING);
        }
    }

    /* compiled from: audio_file */
    class C22765 implements OnSeekCompleteListener {
        final /* synthetic */ RtcAudioHandler f19227a;

        C22765(RtcAudioHandler rtcAudioHandler) {
            this.f19227a = rtcAudioHandler;
        }

        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (this.f19227a.f19245n) {
                mediaPlayer.start();
            }
        }
    }

    /* compiled from: audio_file */
    class ErrorListener implements OnErrorListener {
        final /* synthetic */ RtcAudioHandler f19229a;
        private final boolean f19230b;
        private final boolean f19231c;

        public ErrorListener(RtcAudioHandler rtcAudioHandler, boolean z, boolean z2) {
            this.f19229a = rtcAudioHandler;
            this.f19230b = z;
            this.f19231c = z2;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (this.f19230b) {
                RtcAudioHandler.m19274d(this.f19229a, this.f19231c);
            }
            return true;
        }
    }

    /* compiled from: audio_file */
    public enum Tone {
        RINGBACK,
        END_CALL,
        LOW_BATTERY,
        VIDEO_ON,
        CONNECT,
        DISCONNECT,
        SEARCHING,
        DROPPED_CALL,
        CONFERENCE_JOIN,
        CONFERENCE_LEAVE,
        INCOMING_INSTANT_VIDEO
    }

    @Inject
    public RtcAudioHandler(Context context, ScheduledExecutorService scheduledExecutorService, FbSharedPreferences fbSharedPreferences, DefaultAndroidThreadUtil defaultAndroidThreadUtil, Resources resources, RtcAudioFocusHandlerProvider rtcAudioFocusHandlerProvider, @Assisted C22981 c22981, QeAccessor qeAccessor) {
        this.f19233b = context;
        this.f19234c = scheduledExecutorService;
        this.f19235d = fbSharedPreferences;
        this.f19236e = defaultAndroidThreadUtil;
        this.f19237f = resources;
        this.f19238g = new RtcAudioFocusHandler(AudioManagerMethodAutoProvider.b(rtcAudioFocusHandlerProvider), WebrtcLoggingHandler.a(rtcAudioFocusHandlerProvider), new C22721(this));
        this.f19239h = c22981;
        this.f19240i = qeAccessor;
    }

    public final void m19281a(Tone tone) {
        this.f19236e.a();
        if (!this.f19241j || tone == Tone.INCOMING_INSTANT_VIDEO) {
            switch (tone) {
                case INCOMING_INSTANT_VIDEO:
                    m19267a(2131165307);
                    return;
                case END_CALL:
                    m19267a(2131165213);
                    return;
                case LOW_BATTERY:
                    m19267a(2131165345);
                    return;
                case CONNECT:
                    m19267a(2131165343);
                    return;
                case DISCONNECT:
                    m19271c(2131165344);
                    return;
                case VIDEO_ON:
                    m19267a(2131165342);
                    return;
                case SEARCHING:
                    m19270b(2131165346);
                    return;
                case DROPPED_CALL:
                    m19268a(this, 2131165211, false, 50);
                    return;
                case RINGBACK:
                    m19268a(this, 2131165263, true, 50);
                    return;
                case CONFERENCE_JOIN:
                    m19267a(2131165305);
                    return;
                case CONFERENCE_LEAVE:
                    m19267a(2131165306);
                    return;
                default:
                    return;
            }
        }
    }

    public final void m19280a() {
        this.f19238g.m19266e();
        this.f19238g.m19265d();
        m19285d();
        this.f19244m = false;
    }

    public final boolean m19283b() {
        if (this.f19244m) {
            return true;
        }
        m19285d();
        this.f19244m = true;
        return false;
    }

    public final void m19284c() {
        if (!this.f19241j) {
            m19285d();
            this.f19243l = this.f19234c.schedule(new C22732(this), 2, TimeUnit.SECONDS);
        }
    }

    public final void m19285d() {
        if (this.f19243l != null) {
            this.f19243l.cancel(false);
            this.f19243l = null;
        }
    }

    public static void m19268a(RtcAudioHandler rtcAudioHandler, final int i, final boolean z, final int i2) {
        rtcAudioHandler.m19285d();
        if (rtcAudioHandler.f19242k != null && rtcAudioHandler.f19242k.isPlaying() && i2 != 0) {
            float f = ((float) i2) / 50.0f;
            rtcAudioHandler.f19242k.setVolume(f, f);
            rtcAudioHandler.f19243l = rtcAudioHandler.f19234c.schedule(new Runnable(rtcAudioHandler) {
                final /* synthetic */ RtcAudioHandler f19225d;

                public void run() {
                    RtcAudioHandler.m19268a(this.f19225d, i, z, i2 - 1);
                }
            }, 10, TimeUnit.MILLISECONDS);
        } else if (z) {
            rtcAudioHandler.m19270b(i);
        } else {
            rtcAudioHandler.m19267a(i);
        }
    }

    public final void m19286f() {
        this.f19238g.m19266e();
        if (this.f19242k != null) {
            this.f19242k.reset();
            this.f19242k.release();
            this.f19242k = null;
        }
        this.f19245n = false;
    }

    private void m19267a(int i) {
        m19272c(true);
        this.f19242k.setOnCompletionListener(this);
        m19275e(i);
    }

    private void m19270b(int i) {
        m19272c(true);
        if (m19279l()) {
            this.f19242k.setLooping(false);
            this.f19245n = true;
        } else {
            this.f19242k.setLooping(true);
        }
        this.f19242k.setOnCompletionListener(this);
        m19275e(i);
    }

    private void m19271c(int i) {
        m19272c(true);
        this.f19242k.setOnCompletionListener(new C22754(this));
        m19275e(i);
    }

    public final void m19282b(boolean z) {
        if (!this.f19241j) {
            m19269a(true, z);
        }
    }

    private void m19269a(boolean z, boolean z2) {
        m19272c(false);
        this.f19242k.setAudioStreamType(2);
        if (m19279l()) {
            this.f19242k.setLooping(false);
            this.f19245n = true;
        } else {
            this.f19242k.setLooping(true);
        }
        this.f19242k.setOnErrorListener(new ErrorListener(this, z, z2));
        if (z2) {
            this.f19242k.setVolume(0.32f, 0.32f);
        }
        this.f19242k.setOnCompletionListener(this);
        try {
            this.f19242k.setDataSource(this.f19233b, m19276h());
            m19277i();
        } catch (Exception e) {
            m19286f();
            if (z) {
                m19274d(this, z2);
            }
        }
    }

    private Uri m19276h() {
        Object a = this.f19235d.a(VoipPrefKeys.f19917d, null);
        if (StringUtil.a(a)) {
            return m19273d(2131165236);
        }
        return Uri.parse(a);
    }

    private Uri m19273d(int i) {
        return new Builder().scheme("android.resource").authority(this.f19237f.getResourcePackageName(i)).appendPath(this.f19237f.getResourceTypeName(i)).appendPath(this.f19237f.getResourceEntryName(i)).build();
    }

    private void m19277i() {
        this.f19242k.setOnPreparedListener(this);
        try {
            this.f19242k.prepareAsync();
        } catch (Throwable e) {
            BLog.b(f19232a, "Failed to prepare mediaPlayer", e);
            m19286f();
        }
    }

    private void m19275e(int i) {
        this.f19242k.setAudioStreamType(0);
        this.f19242k.setOnErrorListener(new ErrorListener(this, false, false));
        if (i == 2131165305 || i == 2131165306) {
            this.f19242k.setVolume(0.2f, 0.2f);
        }
        try {
            this.f19242k.setDataSource(this.f19233b, m19273d(i));
            m19277i();
        } catch (Exception e) {
            m19286f();
        }
    }

    private void m19272c(boolean z) {
        m19286f();
        m19285d();
        this.f19245n = false;
        if (z) {
            this.f19238g.m19263b();
        } else {
            this.f19238g.m19264c();
        }
        this.f19242k = new MediaPlayer();
    }

    public static void m19274d(RtcAudioHandler rtcAudioHandler, boolean z) {
        PrefKey prefKey = VoipPrefKeys.f19917d;
        Editor edit = rtcAudioHandler.f19235d.edit();
        edit.a(prefKey, null);
        edit.commit();
        rtcAudioHandler.m19269a(false, z);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (!this.f19245n || this.f19242k == null) {
            m19286f();
            return;
        }
        this.f19242k.seekTo(0);
        this.f19242k.setOnSeekCompleteListener(new C22765(this));
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        m19278k(this);
    }

    public static void m19278k(RtcAudioHandler rtcAudioHandler) {
        if (rtcAudioHandler.f19242k != null && !rtcAudioHandler.f19242k.isPlaying()) {
            rtcAudioHandler.f19242k.start();
        }
    }

    private static boolean m19279l() {
        if (VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }
}
