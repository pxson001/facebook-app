package com.facebook.rtc.voicemail;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;

/* compiled from: app_discovery_lite_load_failed */
class VoicemailHandler$VoicemailErrorListener implements OnErrorListener {
    final /* synthetic */ VoicemailHandler f20367a;
    private String f20368b;

    public VoicemailHandler$VoicemailErrorListener(VoicemailHandler voicemailHandler, String str) {
        this.f20367a = voicemailHandler;
        this.f20368b = str;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        VoicemailHandler.a(this.f20367a, this.f20368b);
        return true;
    }
}
