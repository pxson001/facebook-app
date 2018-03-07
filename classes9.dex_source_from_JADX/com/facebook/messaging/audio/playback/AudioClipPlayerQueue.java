package com.facebook.messaging.audio.playback;

import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.net.Uri;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.audio.playback.AudioClipPlayer.C09012;
import com.facebook.messaging.audio.playback.AudioClipPlayer.C09023;
import com.facebook.messaging.audio.playback.AudioClipPlayer.C09034;
import com.facebook.messaging.audio.playback.AudioClipPlayer.C09045;
import com.facebook.messaging.audio.playback.AudioClipPlayer.Event;
import com.facebook.messaging.audio.playback.AudioClipPlayer.PlaybackListener;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import java.util.LinkedList;
import java.util.Queue;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: origin_fragment */
public class AudioClipPlayerQueue {
    private static volatile AudioClipPlayerQueue f8052i;
    public final AudioManager f8053a;
    public final Provider<AudioClipPlayer> f8054b;
    public final VolumeControlStreamManager f8055c;
    public final Queue<AudioClipPlayer> f8056d;
    private final PlaybackListener f8057e = new C09051(this);
    public final OnAudioFocusChangeListener f8058f = new C09062(this);
    public AudioClipPlayer f8059g;
    public boolean f8060h;

    /* compiled from: origin_fragment */
    class C09051 implements PlaybackListener {
        final /* synthetic */ AudioClipPlayerQueue f8049a;

        C09051(AudioClipPlayerQueue audioClipPlayerQueue) {
            this.f8049a = audioClipPlayerQueue;
        }

        public final void mo299a(Event event) {
            switch (event) {
                case PLAYBACK_COMPLETED:
                case PLAYBACK_STOPPED:
                case PLAYBACK_ERROR:
                    AudioClipPlayerQueue.m8323i(this.f8049a);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: origin_fragment */
    class C09062 implements OnAudioFocusChangeListener {
        final /* synthetic */ AudioClipPlayerQueue f8050a;

        C09062(AudioClipPlayerQueue audioClipPlayerQueue) {
            this.f8050a = audioClipPlayerQueue;
        }

        public void onAudioFocusChange(int i) {
            switch (i) {
                case -3:
                case -2:
                    if (this.f8050a.f8059g != null && !this.f8050a.f8059g.m8318f()) {
                        this.f8050a.f8060h = true;
                        this.f8050a.f8059g.m8316d();
                        return;
                    }
                    return;
                case -1:
                    if (this.f8050a.f8059g != null) {
                        this.f8050a.f8059g.m8315c();
                        return;
                    }
                    return;
                case 1:
                    if (this.f8050a.f8059g != null && this.f8050a.f8059g.m8318f() && this.f8050a.f8060h) {
                        this.f8050a.f8060h = false;
                        this.f8050a.f8059g.m8317e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public static com.facebook.messaging.audio.playback.AudioClipPlayerQueue m8320a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8052i;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.messaging.audio.playback.AudioClipPlayerQueue.class;
        monitor-enter(r1);
        r0 = f8052i;	 Catch:{ all -> 0x003a }
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
        r0 = m8321b(r0);	 Catch:{ all -> 0x0035 }
        f8052i = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8052i;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.audio.playback.AudioClipPlayerQueue.a(com.facebook.inject.InjectorLike):com.facebook.messaging.audio.playback.AudioClipPlayerQueue");
    }

    private static AudioClipPlayerQueue m8321b(InjectorLike injectorLike) {
        return new AudioClipPlayerQueue(AudioManagerMethodAutoProvider.b(injectorLike), IdBasedProvider.a(injectorLike, 7537), VolumeControlStreamManager.m8346a(injectorLike));
    }

    @Inject
    public AudioClipPlayerQueue(AudioManager audioManager, Provider<AudioClipPlayer> provider, VolumeControlStreamManager volumeControlStreamManager) {
        this.f8053a = audioManager;
        this.f8054b = provider;
        this.f8055c = volumeControlStreamManager;
        this.f8056d = new LinkedList();
    }

    public final void m8325a() {
        if (this.f8059g != null) {
            this.f8059g.m8315c();
        }
        this.f8055c.f8094b = Integer.MIN_VALUE;
    }

    public final AudioClipPlayer m8324a(Uri uri) {
        AudioClipPlayer audioClipPlayer = (AudioClipPlayer) this.f8054b.get();
        Preconditions.checkNotNull(uri);
        audioClipPlayer.f8045h = uri;
        AudioClipPlayer audioClipPlayer2 = audioClipPlayer;
        this.f8056d.clear();
        this.f8056d.add(audioClipPlayer2);
        m8322h();
        return audioClipPlayer2;
    }

    private void m8322h() {
        this.f8060h = false;
        if (this.f8059g != null) {
            this.f8059g.m8315c();
        } else if (this.f8056d.isEmpty()) {
            this.f8053a.abandonAudioFocus(this.f8058f);
        } else {
            this.f8055c.f8094b = 3;
            if (this.f8053a.requestAudioFocus(this.f8058f, 0, 2) != 1) {
                int i = 0;
            }
            this.f8059g = (AudioClipPlayer) this.f8056d.remove();
            this.f8059g.m8313a(this.f8057e);
            AudioClipPlayer audioClipPlayer = this.f8059g;
            audioClipPlayer.f8046i = new MediaPlayer();
            AudioPlaybackTimer audioPlaybackTimer = audioClipPlayer.f8042e;
            audioPlaybackTimer.f8064c = audioClipPlayer.f8046i;
            audioPlaybackTimer.f8067f = -1;
            audioClipPlayer.f8046i.setOnCompletionListener(new C09012(audioClipPlayer));
            audioClipPlayer.f8046i.setOnErrorListener(new C09023(audioClipPlayer));
            audioClipPlayer.f8047j = audioClipPlayer.f8040c.a(new C09034(audioClipPlayer));
            Futures.a(audioClipPlayer.f8047j, new C09045(audioClipPlayer), audioClipPlayer.f8041d);
        }
    }

    public static void m8323i(AudioClipPlayerQueue audioClipPlayerQueue) {
        audioClipPlayerQueue.f8059g.m8314b(audioClipPlayerQueue.f8057e);
        audioClipPlayerQueue.f8059g = null;
        audioClipPlayerQueue.m8322h();
    }
}
