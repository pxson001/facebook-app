package com.facebook.sounds;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import com.facebook.catalyst.modules.media.MediaPlayerUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.FileDescriptor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: event_sms_associates */
public class SoundPlayer {
    private static final Class<?> f15962a = SoundPlayer.class;
    private final Context f15963b;
    private final Resources f15964c;
    private final DefaultAndroidThreadUtil f15965d;
    private final ExecutorService f15966e;
    private MediaPlayer f15967f;
    private boolean f15968g = false;
    public SoundPlayerListener f15969h;

    /* compiled from: event_sms_associates */
    class C11253 implements OnCompletionListener {
        final /* synthetic */ SoundPlayer f15960a;

        C11253(SoundPlayer soundPlayer) {
            this.f15960a = soundPlayer;
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            SoundPlayer.m23598b(this.f15960a);
        }
    }

    /* compiled from: event_sms_associates */
    class C11264 implements OnErrorListener {
        final /* synthetic */ SoundPlayer f15961a;

        C11264(SoundPlayer soundPlayer) {
            this.f15961a = soundPlayer;
        }

        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            Integer.valueOf(i);
            Integer.valueOf(i2);
            SoundPlayer.m23598b(this.f15961a);
            return false;
        }
    }

    public static SoundPlayer m23597b(InjectorLike injectorLike) {
        return new SoundPlayer((Context) injectorLike.getInstance(Context.class), ResourcesMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SoundPlayer(Context context, Resources resources, DefaultAndroidThreadUtil defaultAndroidThreadUtil, ExecutorService executorService) {
        this.f15963b = context;
        this.f15964c = resources;
        this.f15965d = defaultAndroidThreadUtil;
        this.f15966e = executorService;
    }

    public final void m23603a(@Nullable Uri uri, int i) {
        m23604a(uri, i, 1.0f);
    }

    public final void m23604a(@Nullable final Uri uri, final int i, final float f) {
        if (this.f15965d.c()) {
            try {
                ExecutorDetour.a(this.f15966e, new Runnable(this) {
                    final /* synthetic */ SoundPlayer f15955d;

                    public void run() {
                        SoundPlayer.m23600b(this.f15955d, uri, i, f);
                    }
                }, 980417376);
                return;
            } catch (Throwable e) {
                BLog.a(f15962a, "Attempt to play sound rejected by executor service", e);
                return;
            }
        }
        m23600b(this, uri, i, f);
    }

    public final void m23602a(final int i, final int i2, final float f) {
        if (this.f15965d.c()) {
            try {
                ExecutorDetour.a(this.f15966e, new Runnable(this) {
                    final /* synthetic */ SoundPlayer f15959d;

                    public void run() {
                        SoundPlayer.m23599b(this.f15959d, i, i2, f);
                    }
                }, 466209675);
                return;
            } catch (Throwable e) {
                BLog.a(f15962a, "Attempt to play sound rejected by executor service", e);
                return;
            }
        }
        m23599b(this, i, i2, f);
    }

    public final void m23601a() {
        if (this.f15967f != null) {
            try {
                this.f15967f.stop();
            } catch (Throwable th) {
                BLog.b(f15962a, "MediaPlayer failed to stop: %s", th);
            }
        }
        m23598b(this);
    }

    public static void m23599b(SoundPlayer soundPlayer, int i, int i2, float f) {
        AssetFileDescriptor a;
        try {
            a = MediaPlayerUtils.m10497a(soundPlayer.f15963b, i);
            if (a != null) {
                soundPlayer.f15967f = new MediaPlayer();
                soundPlayer.f15967f.setDataSource(a.getFileDescriptor(), a.getStartOffset(), a.getLength());
                soundPlayer.m23595a(i2, true, f);
                m23596a(a);
                return;
            }
            FileDescriptor b = MediaPlayerUtils.m10499b(soundPlayer.f15963b, i);
            soundPlayer.f15967f = new MediaPlayer();
            soundPlayer.f15967f.setDataSource(b);
            soundPlayer.m23595a(i2, true, f);
        } catch (Throwable th) {
            m23596a(a);
        }
    }

    private static void m23596a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor != null) {
            try {
                assetFileDescriptor.close();
            } catch (Throwable th) {
            }
        }
    }

    public static void m23600b(@Nullable SoundPlayer soundPlayer, Uri uri, int i, float f) {
        boolean z = true;
        if (uri != null) {
            try {
                soundPlayer.f15967f = new MediaPlayer();
                soundPlayer.f15967f.setDataSource(soundPlayer.f15963b, uri);
            } catch (Throwable th) {
                BLog.b(f15962a, "MediaPlayer create failed: ", th);
                return;
            }
        }
        soundPlayer.f15967f = MediaPlayer.create(soundPlayer.f15963b, 1);
        z = false;
        soundPlayer.m23595a(i, z, f);
    }

    private void m23595a(int i, boolean z, float f) {
        this.f15967f.setAudioStreamType(i);
        this.f15967f.setLooping(this.f15968g);
        this.f15967f.setOnCompletionListener(new C11253(this));
        this.f15967f.setOnErrorListener(new C11264(this));
        if (z) {
            this.f15967f.prepare();
        }
        this.f15967f.setVolume(f, f);
        this.f15967f.start();
    }

    public static void m23598b(SoundPlayer soundPlayer) {
        if (soundPlayer.f15967f != null) {
            try {
                soundPlayer.f15967f.reset();
                soundPlayer.f15967f.release();
                soundPlayer.f15967f = null;
            } catch (Throwable th) {
                BLog.b(f15962a, "MediaPlayer release failed: ", th);
            }
        }
        if (soundPlayer.f15969h != null) {
            soundPlayer.f15969h.a(soundPlayer);
        }
    }
}
