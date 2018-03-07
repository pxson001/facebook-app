package com.facebook.video.videohome.audio;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.common.android.AudioManagerMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.videohome.abtest.VideoHomeConfig;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: sticker_attachment_count */
public class VideoHomeInlineAudioManager {
    private static VideoHomeInlineAudioManager f2782g;
    private static final Object f2783h = new Object();
    private final Provider<Boolean> f2784a;
    private final VideoHomeConfig f2785b;
    private final AudioManager f2786c;
    public boolean f2787d;
    public boolean f2788e;
    public WeakReference<RichVideoPlayer> f2789f;

    private static VideoHomeInlineAudioManager m2659b(InjectorLike injectorLike) {
        return new VideoHomeInlineAudioManager(IdBasedProvider.a(injectorLike, 4368), VideoHomeConfig.a(injectorLike), AudioManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public VideoHomeInlineAudioManager(Provider<Boolean> provider, VideoHomeConfig videoHomeConfig, AudioManager audioManager) {
        this.f2784a = provider;
        this.f2785b = videoHomeConfig;
        this.f2786c = audioManager;
    }

    public static VideoHomeInlineAudioManager m2658a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoHomeInlineAudioManager b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2783h) {
                VideoHomeInlineAudioManager videoHomeInlineAudioManager;
                if (a2 != null) {
                    videoHomeInlineAudioManager = (VideoHomeInlineAudioManager) a2.a(f2783h);
                } else {
                    videoHomeInlineAudioManager = f2782g;
                }
                if (videoHomeInlineAudioManager == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2659b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2783h, b3);
                        } else {
                            f2782g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoHomeInlineAudioManager;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m2660c() {
        boolean z = false;
        this.f2787d = false;
        if (this.f2786c.getStreamVolume(2) == 0) {
            z = true;
        }
        this.f2788e = z;
    }

    public final boolean m2661d() {
        return ((Boolean) this.f2784a.get()).booleanValue() || (this.f2785b.a && !this.f2788e);
    }
}
