package com.facebook.feedplugins.musicstory.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.collect.CollectionsCompat;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Throwables;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: composer_review */
public class SongClipPlayer implements OnAudioFocusChangeListener, OnCompletionListener, OnErrorListener, OnPreparedListener {
    private static volatile SongClipPlayer f8410m;
    private final Context f8411a;
    public final AudioManager f8412b;
    public final Lazy<MediaPlayer> f8413c;
    public Set<SongClipPlayerListener> f8414d;
    public Uri f8415e = null;
    private float f8416f = 0.0f;
    private boolean f8417g;
    private int f8418h;
    public boolean f8419i;
    public SongClipState f8420j = SongClipState.STOPPED;
    public final Handler f8421k = new Handler(Looper.getMainLooper());
    public final Runnable f8422l = new C10401(this);

    /* compiled from: composer_review */
    public interface SongClipPlayerListener {
        void mo231a(int i, int i2);

        void mo232a(Uri uri, int i, int i2);

        void mo233a(Uri uri, SongClipState songClipState);

        void mo234a(Uri uri, String str);
    }

    /* compiled from: composer_review */
    class C10401 implements Runnable {
        final /* synthetic */ SongClipPlayer f8409a;

        C10401(SongClipPlayer songClipPlayer) {
            this.f8409a = songClipPlayer;
        }

        public void run() {
            MediaPlayer mediaPlayer = (MediaPlayer) this.f8409a.f8413c.get();
            SongClipPlayer songClipPlayer = this.f8409a;
            int duration = mediaPlayer.getDuration();
            int currentPosition = mediaPlayer.getCurrentPosition();
            for (SongClipPlayerListener songClipPlayerListener : songClipPlayer.f8414d) {
                if (songClipPlayerListener != null) {
                    songClipPlayerListener.mo231a(duration, currentPosition);
                }
            }
            this.f8409a.m9320a(mediaPlayer.getDuration(), mediaPlayer.getCurrentPosition());
            HandlerDetour.b(this.f8409a.f8421k, this, 200, 1616571000);
        }
    }

    /* compiled from: composer_review */
    public enum SongClipState {
        PLAYING,
        PAUSED,
        STOPPED,
        BUFFERING
    }

    public static com.facebook.feedplugins.musicstory.utils.SongClipPlayer m9319a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f8410m;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feedplugins.musicstory.utils.SongClipPlayer.class;
        monitor-enter(r1);
        r0 = f8410m;	 Catch:{ all -> 0x003a }
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
        r0 = m9323b(r0);	 Catch:{ all -> 0x0035 }
        f8410m = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8410m;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.musicstory.utils.SongClipPlayer.a(com.facebook.inject.InjectorLike):com.facebook.feedplugins.musicstory.utils.SongClipPlayer");
    }

    private static SongClipPlayer m9323b(InjectorLike injectorLike) {
        return new SongClipPlayer((Context) injectorLike.getInstance(Context.class), AudioManagerMethodAutoProvider.b(injectorLike), IdBasedLazy.a(injectorLike, 36));
    }

    @Inject
    public SongClipPlayer(Context context, AudioManager audioManager, Lazy<MediaPlayer> lazy) {
        this.f8411a = context.getApplicationContext();
        this.f8412b = audioManager;
        this.f8413c = lazy;
        this.f8414d = CollectionsCompat.a(new WeakHashMap());
    }

    public final void m9332a(Uri uri, SongClipPlayerListener songClipPlayerListener) {
        if (uri.equals(this.f8415e) && !this.f8414d.contains(songClipPlayerListener)) {
            this.f8414d.add(songClipPlayerListener);
            m9325e();
            this.f8422l.run();
        }
    }

    public final int m9331a() {
        if (this.f8419i) {
            return Math.max(((MediaPlayer) this.f8413c.get()).getDuration() - ((MediaPlayer) this.f8413c.get()).getCurrentPosition(), 0);
        }
        return 0;
    }

    public final int m9334b() {
        if (this.f8419i) {
            return ((MediaPlayer) this.f8413c.get()).getDuration();
        }
        return 0;
    }

    private void m9322a(SongClipState songClipState) {
        this.f8420j = songClipState;
        m9325e();
    }

    private void m9325e() {
        for (SongClipPlayerListener songClipPlayerListener : this.f8414d) {
            if (songClipPlayerListener != null) {
                songClipPlayerListener.mo233a(this.f8415e, this.f8420j);
            }
        }
    }

    public final void m9335b(Uri uri, SongClipPlayerListener songClipPlayerListener) {
        m9333a(uri, songClipPlayerListener, false);
    }

    public final void m9333a(Uri uri, SongClipPlayerListener songClipPlayerListener, boolean z) {
        if (!uri.equals(this.f8415e) || this.f8420j == SongClipState.STOPPED) {
            m9336c();
            this.f8415e = uri;
            this.f8414d.add(songClipPlayerListener);
            m9322a(SongClipState.BUFFERING);
            try {
                m9326f();
            } catch (Throwable e) {
                m9321a(this.f8415e, Throwables.getStackTraceAsString(e));
            }
        } else if (this.f8420j == SongClipState.PLAYING) {
            if (z) {
                m9329i();
            } else {
                m9328h();
            }
        } else if (this.f8420j == SongClipState.BUFFERING) {
            m9322a(SongClipState.STOPPED);
            ((MediaPlayer) this.f8413c.get()).setOnPreparedListener(null);
        } else {
            m9327g();
        }
    }

    private void m9326f() {
        MediaPlayer mediaPlayer = (MediaPlayer) this.f8413c.get();
        this.f8419i = false;
        mediaPlayer.reset();
        try {
            mediaPlayer.setDataSource(this.f8411a, this.f8415e);
        } catch (IllegalStateException e) {
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this.f8411a, this.f8415e);
        }
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.prepareAsync();
    }

    public final void m9336c() {
        ((MediaPlayer) this.f8413c.get()).setOnPreparedListener(null);
        if (((MediaPlayer) this.f8413c.get()).isPlaying()) {
            ((MediaPlayer) this.f8413c.get()).stop();
        }
        m9330k();
        m9322a(SongClipState.STOPPED);
        this.f8414d.clear();
        this.f8412b.abandonAudioFocus(this);
        this.f8415e = null;
    }

    private void m9327g() {
        int i = 1;
        if (this.f8412b.requestAudioFocus(this, 3, 1) != 1) {
            i = 0;
        }
        if (i != 0) {
            this.f8417g = false;
            m9322a(SongClipState.PLAYING);
            MediaPlayer mediaPlayer = (MediaPlayer) this.f8413c.get();
            mediaPlayer.start();
            m9320a(mediaPlayer.getDuration(), mediaPlayer.getCurrentPosition());
            this.f8422l.run();
            HandlerDetour.b(this.f8421k, this.f8422l, 200, -248098937);
        }
    }

    private void m9328h() {
        m9322a(SongClipState.PAUSED);
        ((MediaPlayer) this.f8413c.get()).pause();
        m9330k();
        this.f8412b.abandonAudioFocus(this);
    }

    private void m9329i() {
        this.f8417g = true;
        this.f8418h = ((MediaPlayer) this.f8413c.get()).getCurrentPosition();
    }

    private void m9320a(int i, int i2) {
        if (i2 - this.f8418h <= 1200 || !this.f8417g) {
            if (i <= 0 || i2 < 0 || i2 > i) {
                this.f8416f = 0.0f;
            } else if (i2 < 1200) {
                this.f8416f = 1.0f - ((float) (Math.log((double) (100.0f - (((float) i2) * 0.083333336f))) / Math.log(100.0d)));
            } else if (i - i2 < 1200) {
                this.f8416f = 1.0f - ((float) (Math.log((double) (100.0f - (100.0f - (((float) (i2 - (i - 1200))) * 0.083333336f)))) / Math.log(100.0d)));
            } else if (this.f8417g) {
                this.f8416f = 1.0f - ((float) (Math.log((double) (100.0f - (100.0f - (((float) (i2 - this.f8418h)) * 0.083333336f)))) / Math.log(100.0d)));
            } else if (this.f8416f != 1.0f) {
                this.f8416f = 1.0f;
            } else {
                return;
            }
            ((MediaPlayer) this.f8413c.get()).setVolume(this.f8416f, this.f8416f);
            return;
        }
        this.f8416f = 0.0f;
        if (this.f8417g) {
            m9336c();
        } else {
            m9328h();
        }
        this.f8417g = false;
    }

    private void m9321a(@Nullable Uri uri, String str) {
        for (SongClipPlayerListener songClipPlayerListener : this.f8414d) {
            if (songClipPlayerListener != null) {
                songClipPlayerListener.mo234a(uri, str);
            }
        }
    }

    private void m9330k() {
        HandlerDetour.a(this.f8421k, this.f8422l);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m9336c();
    }

    public void onAudioFocusChange(int i) {
        switch (i) {
            case -3:
            case -2:
                if (this.f8420j == SongClipState.PLAYING) {
                    m9328h();
                    return;
                } else if (this.f8420j != SongClipState.BUFFERING) {
                    return;
                }
                break;
            case -1:
                break;
            case 1:
                if (this.f8420j == SongClipState.PAUSED) {
                    m9327g();
                    return;
                }
                return;
            default:
                return;
        }
        m9336c();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f8419i = true;
        m9327g();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        Uri uri = this.f8415e;
        for (SongClipPlayerListener songClipPlayerListener : this.f8414d) {
            if (songClipPlayerListener != null) {
                songClipPlayerListener.mo232a(uri, i, i2);
            }
        }
        m9336c();
        return true;
    }
}
