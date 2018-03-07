package com.facebook.rtc.audio;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.facebook.debug.log.BLog;
import com.facebook.inject.Assisted;
import com.facebook.rtc.audio.RtcAudioHandler.C22721;
import com.facebook.rtc.logging.WebrtcLoggingHandler;
import javax.inject.Inject;

/* compiled from: audio_quality */
public class RtcAudioFocusHandler {
    private static final Class<?> f19214a = RtcAudioFocusHandler.class;
    private final AudioManager f19215b;
    private final WebrtcLoggingHandler f19216c;
    public final C22721 f19217d;
    private OnAudioFocusChangeListener f19218e;
    private OnAudioFocusChangeListener f19219f;

    /* compiled from: audio_quality */
    class AudioFocusChangeListener implements OnAudioFocusChangeListener {
        final /* synthetic */ RtcAudioFocusHandler f19213a;

        AudioFocusChangeListener(RtcAudioFocusHandler rtcAudioFocusHandler) {
            this.f19213a = rtcAudioFocusHandler;
        }

        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    RtcAudioHandler rtcAudioHandler = this.f19213a.f19217d.f19220a;
                    if (rtcAudioHandler.f19242k != null && rtcAudioHandler.f19242k.isPlaying()) {
                        rtcAudioHandler.f19242k.pause();
                    }
                    return;
                case -1:
                    Object obj;
                    C22721 c22721 = this.f19213a.f19217d;
                    c22721.f19220a.m19286f();
                    if (c22721.f19220a.f19239h.f19439a.ak == 3) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        RtcAudioFocusHandler.m19260a(this.f19213a, "Lost audio focus");
                        return;
                    }
                    return;
                case 1:
                    RtcAudioHandler.m19278k(this.f19213a.f19217d.f19220a);
                    return;
                default:
                    return;
            }
        }
    }

    @Inject
    public RtcAudioFocusHandler(AudioManager audioManager, WebrtcLoggingHandler webrtcLoggingHandler, @Assisted C22721 c22721) {
        this.f19215b = audioManager;
        this.f19216c = webrtcLoggingHandler;
        this.f19217d = c22721;
    }

    public final void m19262a() {
        m19265d();
        m19266e();
        this.f19219f = new AudioFocusChangeListener(this);
        if (m19261a(this.f19219f, 0, 1)) {
            m19260a(this, "Failed to get audio focus for call");
        }
    }

    public final void m19263b() {
        if (this.f19219f == null && this.f19218e == null) {
            this.f19218e = new AudioFocusChangeListener(this);
            m19261a(this.f19218e, 0, 2);
        }
    }

    public final void m19264c() {
        if (this.f19219f == null && this.f19218e == null) {
            this.f19218e = new AudioFocusChangeListener(this);
            m19261a(this.f19218e, 2, 2);
        }
    }

    private boolean m19261a(OnAudioFocusChangeListener onAudioFocusChangeListener, int i, int i2) {
        if (this.f19215b.requestAudioFocus(onAudioFocusChangeListener, i, i2) != 1) {
            return true;
        }
        return false;
    }

    public final void m19265d() {
        if (this.f19219f != null) {
            this.f19215b.abandonAudioFocus(this.f19219f);
            this.f19219f = null;
        }
    }

    public final void m19266e() {
        if (this.f19218e != null) {
            this.f19215b.abandonAudioFocus(this.f19218e);
            this.f19218e = null;
        }
    }

    public static void m19260a(RtcAudioFocusHandler rtcAudioFocusHandler, String str) {
        BLog.a(f19214a, str);
        rtcAudioFocusHandler.f19216c.a(str);
    }
}
