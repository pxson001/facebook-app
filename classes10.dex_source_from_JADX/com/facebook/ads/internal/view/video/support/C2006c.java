package com.facebook.ads.internal.view.video.support;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.view.View;

public class C2006c implements OnInfoListener {
    private View f14400a;

    public C2006c(View view) {
        this.f14400a = view;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        this.f14400a.setVisibility(8);
        return true;
    }
}
