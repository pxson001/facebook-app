package com.facebook.rtc.voicemail;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

/* compiled from: app_discovery_lite_load_failed */
class VoicemailHandler$2 implements OnCompletionListener {
    final /* synthetic */ VoicemailHandler f20366a;

    VoicemailHandler$2(VoicemailHandler voicemailHandler) {
        this.f20366a = voicemailHandler;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        VoicemailHandler.l(this.f20366a);
    }
}
