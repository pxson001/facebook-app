package com.facebook.feedplugins.musicstory;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.musicstory.MusicPlaybackPartDefinition.PlaybackListener;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipPlayerListener;
import com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.google.common.annotations.VisibleForTesting;
import java.util.HashMap;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: composer_non_existing_attachment */
public class MusicPlayer implements SongClipPlayerListener {
    private static MusicPlayer f8175d;
    private static final Object f8176e = new Object();
    @VisibleForTesting
    public final HashMap<Uri, MusicPlayerCallback> f8177a = new HashMap();
    public final Provider<SongClipPlayer> f8178b;
    @Nullable
    public SongClipPlayer f8179c;

    private static MusicPlayer m9166b(InjectorLike injectorLike) {
        return new MusicPlayer(IdBasedSingletonScopeProvider.a(injectorLike, 6403));
    }

    @Inject
    public MusicPlayer(Provider<SongClipPlayer> provider) {
        this.f8178b = provider;
    }

    public static MusicPlayer m9165a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            MusicPlayer b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8176e) {
                MusicPlayer musicPlayer;
                if (a2 != null) {
                    musicPlayer = (MusicPlayer) a2.a(f8176e);
                } else {
                    musicPlayer = f8175d;
                }
                if (musicPlayer == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9166b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8176e, b3);
                        } else {
                            f8175d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = musicPlayer;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final int m9168a(Uri uri) {
        if (m9173c(uri)) {
            return this.f8179c.m9331a();
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m9173c(android.net.Uri r5) {
        /*
        r4 = this;
        r0 = r4.f8179c;
        if (r0 == 0) goto L_0x001b;
    L_0x0004:
        r0 = r4.f8179c;
        r2 = 0;
        r1 = r0.f8419i;
        if (r1 != 0) goto L_0x001d;
    L_0x000b:
        r1 = r2;
    L_0x000c:
        r0 = r1;
        if (r0 != 0) goto L_0x0019;
    L_0x000f:
        r0 = r4.f8179c;
        r1 = 0;
        r2 = r0.f8419i;
        if (r2 != 0) goto L_0x003b;
    L_0x0016:
        r0 = r1;
        if (r0 == 0) goto L_0x001b;
    L_0x0019:
        r0 = 1;
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = 0;
        goto L_0x001a;
    L_0x001d:
        r1 = r0.f8413c;
        r1 = r1.get();
        r1 = (android.media.MediaPlayer) r1;
        r1 = r1.isPlaying();
        if (r1 == 0) goto L_0x0039;
    L_0x002b:
        r1 = r0.f8415e;
        if (r1 == 0) goto L_0x0039;
    L_0x002f:
        r1 = r0.f8415e;
        r1 = r1.equals(r5);
        if (r1 == 0) goto L_0x0039;
    L_0x0037:
        r1 = 1;
        goto L_0x000c;
    L_0x0039:
        r1 = r2;
        goto L_0x000c;
    L_0x003b:
        r2 = r0.f8420j;
        r3 = com.facebook.feedplugins.musicstory.utils.SongClipPlayer.SongClipState.BUFFERING;
        if (r2 != r3) goto L_0x0016;
    L_0x0041:
        r2 = r0.f8415e;
        if (r2 == 0) goto L_0x0016;
    L_0x0045:
        r2 = r0.f8415e;
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x0016;
    L_0x004d:
        r1 = 1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.musicstory.MusicPlayer.c(android.net.Uri):boolean");
    }

    public final void m9174d(Uri uri) {
        if (uri != null) {
            this.f8177a.remove(uri);
        }
    }

    public final void m9175e(Uri uri) {
        if (this.f8179c != null && this.f8177a.containsKey(uri)) {
            ((PlaybackListener) this.f8177a.get(uri)).m9153a(this.f8179c.m9334b(), this.f8179c.m9331a());
        }
        this.f8179c.m9333a(uri, this, true);
        m9174d(uri);
    }

    public final void mo231a(int i, int i2) {
    }

    public final void mo233a(Uri uri, SongClipState songClipState) {
        int i = 0;
        PlaybackListener g = m9167g(uri);
        if (g != null) {
            int a = this.f8179c != null ? this.f8179c.m9331a() : 0;
            if (this.f8179c != null) {
                i = this.f8179c.m9334b();
            }
            switch (songClipState) {
                case PLAYING:
                    g.m9154a(uri, i, a);
                    return;
                case BUFFERING:
                    g.m9152a();
                    return;
                case PAUSED:
                    g.m9156b(i, a);
                    return;
                default:
                    g.m9153a(i, a);
                    return;
            }
        } else if (songClipState == SongClipState.PLAYING || songClipState == SongClipState.BUFFERING) {
            this.f8179c.m9336c();
        }
    }

    public final void mo234a(Uri uri, String str) {
        PlaybackListener g = m9167g(uri);
        if (g != null) {
            g.m9155a(str);
        }
    }

    public final void mo232a(Uri uri, int i, int i2) {
        PlaybackListener g = m9167g(uri);
        if (g != null) {
            StringBuilder stringBuilder = new StringBuilder("onPlayerError");
            stringBuilder.append(" (what=" + i + ") ");
            stringBuilder.append(" (extra=" + i2 + ") ");
            g.m9155a(stringBuilder.toString());
        }
    }

    private PlaybackListener m9167g(Uri uri) {
        if (uri == null || !this.f8177a.containsKey(uri)) {
            return null;
        }
        return (PlaybackListener) this.f8177a.get(uri);
    }
}
