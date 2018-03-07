package com.facebook.messaging.audio.playback;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Handler;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.io.Closeables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: origin_location_params */
public class AudioClipPlayer {
    private static final Class<?> f8038a = AudioClipPlayer.class;
    private final DefaultAndroidThreadUtil f8039b;
    public final ListeningExecutorService f8040c;
    public final Executor f8041d;
    public final AudioPlaybackTimer f8042e;
    public final Handler f8043f;
    private final Set<PlaybackListener> f8044g = new HashSet();
    public Uri f8045h;
    public MediaPlayer f8046i;
    public ListenableFuture<Void> f8047j;
    public final Runnable f8048k = new C09001(this);

    /* compiled from: origin_location_params */
    class C09001 implements Runnable {
        final /* synthetic */ AudioClipPlayer f8033a;

        C09001(AudioClipPlayer audioClipPlayer) {
            this.f8033a = audioClipPlayer;
        }

        public void run() {
            AudioClipPlayer.m8309a(this.f8033a, Event.PLAYBACK_POSITION_UPDATED);
            HandlerDetour.b(this.f8033a.f8043f, this, 25, 554116368);
        }
    }

    /* compiled from: origin_location_params */
    public class C09012 implements OnCompletionListener {
        final /* synthetic */ AudioClipPlayer f8034a;

        public C09012(AudioClipPlayer audioClipPlayer) {
            this.f8034a = audioClipPlayer;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            AudioClipPlayer.m8312k(this.f8034a);
            AudioClipPlayer.m8309a(this.f8034a, Event.PLAYBACK_COMPLETED);
        }
    }

    /* compiled from: origin_location_params */
    public class C09023 implements OnErrorListener {
        final /* synthetic */ AudioClipPlayer f8035a;

        public C09023(AudioClipPlayer audioClipPlayer) {
            this.f8035a = audioClipPlayer;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            AudioClipPlayer.m8312k(this.f8035a);
            AudioClipPlayer.m8309a(this.f8035a, Event.PLAYBACK_ERROR);
            return true;
        }
    }

    /* compiled from: origin_location_params */
    public class C09034 implements Callable<Void> {
        final /* synthetic */ AudioClipPlayer f8036a;

        public C09034(AudioClipPlayer audioClipPlayer) {
            this.f8036a = audioClipPlayer;
        }

        public Object call() {
            AudioClipPlayer.m8311j(this.f8036a);
            return null;
        }
    }

    /* compiled from: origin_location_params */
    public class C09045 implements FutureCallback<Object> {
        final /* synthetic */ AudioClipPlayer f8037a;

        public C09045(AudioClipPlayer audioClipPlayer) {
            this.f8037a = audioClipPlayer;
        }

        public void onSuccess(Object obj) {
            this.f8037a.f8047j = null;
            AudioClipPlayer.m8309a(this.f8037a, Event.PLAYBACK_STARTED);
            HandlerDetour.a(this.f8037a.f8043f, this.f8037a.f8048k, -50435909);
        }

        public void onFailure(Throwable th) {
            this.f8037a.f8047j = null;
            AudioClipPlayer.m8312k(this.f8037a);
            AudioClipPlayer.m8309a(this.f8037a, Event.PLAYBACK_ERROR);
        }
    }

    /* compiled from: origin_location_params */
    public enum Event {
        PLAYBACK_STARTED,
        PLAYBACK_ERROR,
        PLAYBACK_STOPPED,
        PLAYBACK_COMPLETED,
        PLAYBACK_POSITION_UPDATED,
        PLAYBACK_PAUSED,
        PLAYBACK_RESUMED
    }

    /* compiled from: origin_location_params */
    public interface PlaybackListener {
        void mo299a(Event event);
    }

    public static AudioClipPlayer m8310b(InjectorLike injectorLike) {
        return new AudioClipPlayer(DefaultAndroidThreadUtil.b(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), new AudioPlaybackTimer((Clock) SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike)), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    AudioClipPlayer(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ListeningExecutorService listeningExecutorService, Executor executor, AudioPlaybackTimer audioPlaybackTimer, Handler handler) {
        this.f8039b = defaultAndroidThreadUtil;
        this.f8040c = listeningExecutorService;
        this.f8041d = executor;
        this.f8042e = audioPlaybackTimer;
        this.f8043f = handler;
    }

    public final void m8313a(PlaybackListener playbackListener) {
        this.f8044g.add(playbackListener);
    }

    public final void m8314b(PlaybackListener playbackListener) {
        this.f8044g.remove(playbackListener);
    }

    public final void m8315c() {
        if (this.f8047j != null) {
            this.f8047j.cancel(false);
        }
        m8312k(this);
        m8309a(this, Event.PLAYBACK_STOPPED);
    }

    public final void m8316d() {
        try {
            if (this.f8046i != null && this.f8046i.isPlaying()) {
                this.f8046i.pause();
                m8309a(this, Event.PLAYBACK_PAUSED);
            }
        } catch (IllegalStateException e) {
            BLog.b(f8038a, "The player finished playing before pause() was called");
        }
        HandlerDetour.a(this.f8043f, this.f8048k);
    }

    public final void m8317e() {
        this.f8046i.start();
        AudioPlaybackTimer audioPlaybackTimer = this.f8042e;
        audioPlaybackTimer.f8066e = audioPlaybackTimer.f8067f;
        audioPlaybackTimer.f8065d = audioPlaybackTimer.f8062a.a();
        m8309a(this, Event.PLAYBACK_RESUMED);
        HandlerDetour.a(this.f8043f, this.f8048k, 480752217);
    }

    public final boolean m8318f() {
        return (this.f8046i == null || this.f8046i.isPlaying()) ? false : true;
    }

    public static void m8311j(AudioClipPlayer audioClipPlayer) {
        audioClipPlayer.f8039b.b();
        new StringBuilder("Playing the audio clip: ").append(audioClipPlayer.f8045h);
        InputStream fileInputStream = new FileInputStream(new File(audioClipPlayer.f8045h.getPath()));
        try {
            audioClipPlayer.f8046i.setDataSource(fileInputStream.getFD());
            audioClipPlayer.f8046i.prepare();
            audioClipPlayer.f8046i.start();
        } finally {
            Closeables.a(fileInputStream);
        }
    }

    public static void m8312k(AudioClipPlayer audioClipPlayer) {
        HandlerDetour.a(audioClipPlayer.f8043f, audioClipPlayer.f8048k);
        if (audioClipPlayer.f8046i != null) {
            audioClipPlayer.f8046i.reset();
            audioClipPlayer.f8046i.release();
            audioClipPlayer.f8046i = null;
        }
    }

    public static void m8309a(AudioClipPlayer audioClipPlayer, Event event) {
        int i = 0;
        PlaybackListener[] playbackListenerArr = (PlaybackListener[]) audioClipPlayer.f8044g.toArray(new PlaybackListener[0]);
        int length = playbackListenerArr.length;
        while (i < length) {
            playbackListenerArr[i].mo299a(event);
            i++;
        }
    }
}
