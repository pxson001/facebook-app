package com.facebook.sounds.configurator;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Preconditions;

/* compiled from: event_promotion_xout */
public class SoundUtil {

    /* compiled from: event_promotion_xout */
    public final class C11311 extends Handler {
        final /* synthetic */ int f16009a;
        final /* synthetic */ boolean f16010b;
        final /* synthetic */ Context f16011c;
        final /* synthetic */ AudioConfigRegistry f16012d;
        private MediaPlayer f16013e;

        public C11311(Looper looper, int i, boolean z, Context context, AudioConfigRegistry audioConfigRegistry) {
            this.f16009a = i;
            this.f16010b = z;
            this.f16011c = context;
            this.f16012d = audioConfigRegistry;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                case 2:
                    if (this.f16013e == null) {
                        Object obj;
                        boolean z;
                        int i = this.f16009a;
                        boolean z2 = this.f16010b;
                        Context context = this.f16011c;
                        AudioConfigRegistry audioConfigRegistry = this.f16012d;
                        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Preconditions.checkState(z, "Trying to play a sound on the UI Thread");
                        MediaPlayer create = MediaPlayer.create(context, i);
                        create.setAudioStreamType(2);
                        create.setLooping(z2);
                        float a = audioConfigRegistry.m23615a(i);
                        create.setVolume(a, a);
                        this.f16013e = create;
                    }
                    if (!this.f16013e.isPlaying()) {
                        if (message.what == 2) {
                            this.f16013e.seekTo(0);
                        }
                        float a2 = this.f16012d.m23615a(this.f16009a);
                        this.f16013e.setVolume(a2, a2);
                        this.f16013e.start();
                        return;
                    }
                    return;
                case 3:
                    if (this.f16013e != null && this.f16013e.isPlaying()) {
                        this.f16013e.pause();
                        return;
                    }
                    return;
                case 4:
                    if (this.f16013e != null) {
                        if (this.f16013e.isPlaying()) {
                            this.f16013e.pause();
                        }
                        MediaPlayer mediaPlayer = this.f16013e;
                        if (mediaPlayer != null) {
                            if (mediaPlayer.isPlaying()) {
                                mediaPlayer.stop();
                            }
                            mediaPlayer.reset();
                            mediaPlayer.release();
                        }
                        Looper.myLooper().quit();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: event_promotion_xout */
    public final class C11332 {
        public boolean f16015a;
        final /* synthetic */ Handler f16016b;
        final /* synthetic */ boolean f16017c;
        final /* synthetic */ Context f16018d;
        public OnAudioFocusChangeListener f16019e;

        /* compiled from: event_promotion_xout */
        public class C11321 implements OnAudioFocusChangeListener {
            final /* synthetic */ C11332 f16014a;

            public C11321(C11332 c11332) {
                this.f16014a = c11332;
            }

            public void onAudioFocusChange(int i) {
            }
        }

        public C11332(Handler handler, boolean z, Context context) {
            this.f16016b = handler;
            this.f16017c = z;
            this.f16018d = context;
        }

        public final boolean m23655a(boolean z) {
            if (this.f16015a) {
                return false;
            }
            if (z) {
                this.f16016b.sendEmptyMessage(2);
            } else {
                this.f16016b.sendEmptyMessage(1);
            }
            if (this.f16017c) {
                AudioManager audioManager = (AudioManager) this.f16018d.getSystemService("audio");
                if (this.f16019e == null) {
                    this.f16019e = new C11321(this);
                }
                audioManager.requestAudioFocus(this.f16019e, 3, 4);
            }
            this.f16015a = true;
            return true;
        }

        public final void m23654a() {
            this.f16015a = false;
            this.f16016b.sendEmptyMessage(4);
        }
    }
}
