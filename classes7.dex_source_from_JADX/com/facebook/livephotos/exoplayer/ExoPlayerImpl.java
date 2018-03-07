package com.facebook.livephotos.exoplayer;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.facebook.livephotos.exoplayer.ExoPlayer.Listener;
import com.facebook.livephotos.player.LivePhotoVideoPlayer;
import com.facebook.livephotos.player.LivePhotoVideoPlayer.C06292;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: param_file_uri */
public final class ExoPlayerImpl {
    public final Handler f6709a;
    public final ExoPlayerImplInternal f6710b;
    public final CopyOnWriteArraySet<Listener> f6711c = new CopyOnWriteArraySet();
    public final MediaFormat[][] f6712d;
    private final int[] f6713e;
    public boolean f6714f = false;
    public int f6715g = 1;
    public int f6716h;

    /* compiled from: param_file_uri */
    class C06111 extends Handler {
        final /* synthetic */ ExoPlayerImpl f6708a;

        C06111(ExoPlayerImpl exoPlayerImpl) {
            this.f6708a = exoPlayerImpl;
        }

        public void handleMessage(Message message) {
            ExoPlayerImpl exoPlayerImpl = this.f6708a;
            Iterator it;
            switch (message.what) {
                case 1:
                    System.arraycopy(message.obj, 0, exoPlayerImpl.f6712d, 0, exoPlayerImpl.f6712d.length);
                    exoPlayerImpl.f6715g = message.arg1;
                    it = exoPlayerImpl.f6711c.iterator();
                    while (it.hasNext()) {
                        ((LivePhotoVideoPlayer) it.next()).m9384a(exoPlayerImpl.f6714f, exoPlayerImpl.f6715g);
                    }
                    return;
                case 2:
                    exoPlayerImpl.f6715g = message.arg1;
                    it = exoPlayerImpl.f6711c.iterator();
                    while (it.hasNext()) {
                        ((LivePhotoVideoPlayer) it.next()).m9384a(exoPlayerImpl.f6714f, exoPlayerImpl.f6715g);
                    }
                    return;
                case 3:
                    exoPlayerImpl.f6716h--;
                    if (exoPlayerImpl.f6716h == 0) {
                        Iterator it2 = exoPlayerImpl.f6711c.iterator();
                        while (it2.hasNext()) {
                            it2.next();
                        }
                        return;
                    }
                    return;
                case 4:
                    ExoPlaybackException exoPlaybackException = (ExoPlaybackException) message.obj;
                    Iterator it3 = exoPlayerImpl.f6711c.iterator();
                    while (it3.hasNext()) {
                        LivePhotoVideoPlayer livePhotoVideoPlayer = (LivePhotoVideoPlayer) it3.next();
                        if (!LivePhotoVideoPlayer.m9382d()) {
                            HandlerDetour.a(livePhotoVideoPlayer.f7761e, new C06292(livePhotoVideoPlayer, exoPlaybackException), 1751828527);
                        }
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    public ExoPlayerImpl(int i, int i2, int i3) {
        Log.i("ExoPlayerImpl", "Init 1.5.7");
        this.f6712d = new MediaFormat[i][];
        this.f6713e = new int[i];
        this.f6709a = new C06111(this);
        this.f6710b = new ExoPlayerImplInternal(this.f6709a, this.f6714f, this.f6713e, i2, i3);
    }

    public final void m8578a(TrackRenderer... trackRendererArr) {
        Arrays.fill(this.f6712d, null);
        this.f6710b.f6717a.obtainMessage(1, trackRendererArr).sendToTarget();
    }

    public final void m8577a(boolean z) {
        if (this.f6714f != z) {
            int i;
            this.f6714f = z;
            this.f6716h++;
            Handler handler = this.f6710b.f6717a;
            if (z) {
                i = 1;
            } else {
                i = 0;
            }
            handler.obtainMessage(3, i, 0).sendToTarget();
            Iterator it = this.f6711c.iterator();
            while (it.hasNext()) {
                ((LivePhotoVideoPlayer) it.next()).m9384a(z, this.f6715g);
            }
        }
    }

    public final void m8576a(TrackRenderer trackRenderer, int i, Object obj) {
        ExoPlayerImplInternal exoPlayerImplInternal = this.f6710b;
        exoPlayerImplInternal.f6734r++;
        exoPlayerImplInternal.f6717a.obtainMessage(9, i, 0, Pair.create(trackRenderer, obj)).sendToTarget();
    }
}
