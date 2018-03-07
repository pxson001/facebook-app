package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesLanguageChangeEvent;
import com.facebook.video.player.events.RVPRequestSubtitlesVisibilityChangeEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.subtitles.controller.SubtitleMediaTimeProvider;
import com.facebook.video.subtitles.controller.Subtitles;
import com.facebook.video.subtitles.views.FbSubtitleView;
import com.google.common.base.Preconditions;

@DoNotStrip
/* compiled from: postal_code */
public class SubtitlePlugin extends StubbableRichVideoPlayerPlugin {
    private final SubtitleMediaTimeProvider f4367b;
    private FbSubtitleView f4368c;
    private Subtitles f4369d;
    public boolean f4370l;

    /* compiled from: postal_code */
    class C02031 implements SubtitleMediaTimeProvider {
        final /* synthetic */ SubtitlePlugin f4371a;

        C02031(SubtitlePlugin subtitlePlugin) {
            this.f4371a = subtitlePlugin;
        }

        public final int mo384a() {
            Preconditions.checkNotNull(this.f4371a.f14096h);
            return this.f4371a.f14096h.m5477f();
        }
    }

    /* compiled from: postal_code */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ SubtitlePlugin f4372a;

        public PlayerStateChangedEventSubscriber(SubtitlePlugin subtitlePlugin) {
            this.f4372a = subtitlePlugin;
        }

        public final void m4904b(FbEvent fbEvent) {
            RVPPlayerStateChangedEvent rVPPlayerStateChangedEvent = (RVPPlayerStateChangedEvent) fbEvent;
            if (this.f4372a.f4370l) {
                SubtitlePlugin.m4894a(this.f4372a, rVPPlayerStateChangedEvent.f14079b);
            }
        }

        public final Class<RVPPlayerStateChangedEvent> m4903a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: postal_code */
    class SubtitlesChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSubtitlesVisibilityChangeEvent> {
        final /* synthetic */ SubtitlePlugin f4373a;

        public SubtitlesChangeEventSubscriber(SubtitlePlugin subtitlePlugin) {
            this.f4373a = subtitlePlugin;
        }

        public final void m4906b(FbEvent fbEvent) {
            this.f4373a.m4898a(((RVPRequestSubtitlesVisibilityChangeEvent) fbEvent).f5096a);
        }

        public final Class<RVPRequestSubtitlesVisibilityChangeEvent> m4905a() {
            return RVPRequestSubtitlesVisibilityChangeEvent.class;
        }
    }

    /* compiled from: postal_code */
    class SubtitlesLanguageChangeEventSubscriber extends RichVideoPlayerEventSubscriber<RVPRequestSubtitlesLanguageChangeEvent> {
        final /* synthetic */ SubtitlePlugin f4374a;

        public SubtitlesLanguageChangeEventSubscriber(SubtitlePlugin subtitlePlugin) {
            this.f4374a = subtitlePlugin;
        }

        public final void m4908b(FbEvent fbEvent) {
            RVPRequestSubtitlesLanguageChangeEvent rVPRequestSubtitlesLanguageChangeEvent = (RVPRequestSubtitlesLanguageChangeEvent) fbEvent;
            if (rVPRequestSubtitlesLanguageChangeEvent.f5097a != null) {
                SubtitlePlugin.m4895a(this.f4374a, rVPRequestSubtitlesLanguageChangeEvent.f5097a);
            } else {
                SubtitlePlugin.m4896f(this.f4374a);
            }
        }

        public final Class<RVPRequestSubtitlesLanguageChangeEvent> m4907a() {
            return RVPRequestSubtitlesLanguageChangeEvent.class;
        }
    }

    @DoNotStrip
    public SubtitlePlugin(Context context) {
        this(context, null);
    }

    public SubtitlePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SubtitlePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4367b = new C02031(this);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new SubtitlesChangeEventSubscriber(this));
        this.f14094f.add(new SubtitlesLanguageChangeEventSubscriber(this));
    }

    protected final boolean mo377a(RichVideoPlayerParams richVideoPlayerParams) {
        return this.f4369d != null;
    }

    protected int getLayoutToInflate() {
        return 2130907292;
    }

    protected void setupPlugin(RichVideoPlayerParams richVideoPlayerParams) {
    }

    protected void setupViews(View view) {
        this.f4368c = (FbSubtitleView) view.findViewById(2131563174);
    }

    protected int getStubLayout() {
        return 2130907293;
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Preconditions.checkNotNull(this.f14096h);
        Subtitles subtitles = this.f14096h.f5124u;
        if (subtitles != null) {
            m4895a(this, subtitles);
        } else {
            m4896f(this);
        }
    }

    protected final void mo378c() {
        m4896f(this);
    }

    public static void m4895a(SubtitlePlugin subtitlePlugin, Subtitles subtitles) {
        subtitlePlugin.f4369d = subtitles;
        if (subtitlePlugin.m14963d() && subtitlePlugin.f14096h != null) {
            subtitlePlugin.f4370l = true;
            subtitlePlugin.f4368c.a(subtitlePlugin.f4367b, subtitlePlugin.f4369d);
            subtitlePlugin.m4898a(true);
            m4894a(subtitlePlugin, subtitlePlugin.f14096h.f5115l);
        }
    }

    public static void m4896f(SubtitlePlugin subtitlePlugin) {
        subtitlePlugin.f4369d = null;
        if (subtitlePlugin.f4368c != null) {
            subtitlePlugin.f4368c.f();
        }
        subtitlePlugin.f4370l = false;
    }

    public final void m4898a(boolean z) {
        if (this.f4368c != null) {
            if (z) {
                this.f4368c.a();
            } else {
                this.f4368c.b();
            }
        }
    }

    public static void m4894a(SubtitlePlugin subtitlePlugin, State state) {
        if (subtitlePlugin.f4368c != null) {
            switch (2.a[state.ordinal()]) {
                case 1:
                    subtitlePlugin.f4368c.c();
                    return;
                case 2:
                case 3:
                    subtitlePlugin.f4368c.e();
                    return;
                default:
                    subtitlePlugin.f4368c.d();
                    return;
            }
        }
    }
}
