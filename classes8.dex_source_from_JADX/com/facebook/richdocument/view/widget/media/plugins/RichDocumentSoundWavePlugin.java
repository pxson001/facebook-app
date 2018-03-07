package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.SoundWavePlugin;

/* compiled from: numTryAnotherClicks */
public class RichDocumentSoundWavePlugin extends SoundWavePlugin {
    public boolean f7696b;

    public RichDocumentSoundWavePlugin(Context context) {
        super(context, null);
    }

    protected final void m7979a(State state) {
        if (state != State.PLAYING || this.f7696b) {
            this.a.setVisibility(8);
            this.a.b();
            return;
        }
        this.a.a();
        this.a.setVisibility(0);
    }
}
