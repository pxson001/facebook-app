package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStub;
import android.widget.SeekBar;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.facecastdisplay.heatmap.HeatmapView;
import com.facebook.inject.FbInjector;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent;
import com.facebook.video.player.events.RVPLiveVideoControlFadeEvent.State;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.SeekBarBaseHDPlugin;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Thumbnail Uri is already defined. */
public class PreviouslyLiveSeekBarPlugin<E extends AnyPlayerEnvironment> extends SeekBarBaseHDPlugin<E> {
    @Inject
    public FacecastUtil f22135l;
    private final ViewStub f22136m;
    @Nullable
    public HeatmapView f22137n;
    private SeekBar f22138o;
    private boolean f22139p;

    /* compiled from: Thumbnail Uri is already defined. */
    /* synthetic */ class C18901 {
        static final /* synthetic */ int[] f22133a = new int[State.values().length];

        static {
            try {
                f22133a[State.FADE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    /* compiled from: Thumbnail Uri is already defined. */
    class LiveVideoControlFadeSubscriber extends RichVideoPlayerEventSubscriber<RVPLiveVideoControlFadeEvent> {
        final /* synthetic */ PreviouslyLiveSeekBarPlugin f22134a;

        public LiveVideoControlFadeSubscriber(PreviouslyLiveSeekBarPlugin previouslyLiveSeekBarPlugin) {
            this.f22134a = previouslyLiveSeekBarPlugin;
        }

        public final void m24776b(FbEvent fbEvent) {
            switch (C18901.f22133a[((RVPLiveVideoControlFadeEvent) fbEvent).a.ordinal()]) {
                case 1:
                    if (this.f22134a.f22137n != null) {
                        this.f22134a.f22137n.m22639b();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final Class<RVPLiveVideoControlFadeEvent> m24775a() {
            return RVPLiveVideoControlFadeEvent.class;
        }
    }

    private static <T extends View> void m24780a(Class<T> cls, T t) {
        m24781a((Object) t, t.getContext());
    }

    private static void m24781a(Object obj, Context context) {
        ((PreviouslyLiveSeekBarPlugin) obj).f22135l = FacecastUtil.m3107b(FbInjector.get(context));
    }

    private void m24778a(FacecastUtil facecastUtil) {
        this.f22135l = facecastUtil;
    }

    public PreviouslyLiveSeekBarPlugin(Context context) {
        this(context, null);
    }

    public PreviouslyLiveSeekBarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviouslyLiveSeekBarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22136m = (ViewStub) a(2131562878);
        this.f22138o = (SeekBar) a(2131562401);
        this.f22139p = true;
        this.f.add(new LiveVideoControlFadeSubscriber(this));
    }

    protected final void m24782a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        super.a(richVideoPlayerParams, z);
        m24779a(richVideoPlayerParams);
    }

    private void m24779a(RichVideoPlayerParams richVideoPlayerParams) {
        if (this.f22135l.m3111c()) {
            if (this.f22137n == null) {
                this.f22137n = (HeatmapView) this.f22136m.inflate();
            }
            this.f22137n.setVisibility(0);
            this.f22137n.setVideoId(richVideoPlayerParams.a.b);
            if (this.h != null) {
                this.f22137n.setCursor(((float) this.h.f()) / ((float) this.h.h()));
                if (this.f22139p) {
                    this.f22137n.m22639b();
                    this.f22139p = false;
                }
            }
        } else if (this.f22137n != null) {
            this.f22137n.setVisibility(8);
        }
    }

    protected final void m24783c() {
        super.c();
        if (this.f22137n != null) {
            this.f22137n.mo1450a();
        }
    }

    protected int getContentView() {
        m24780a(PreviouslyLiveSeekBarPlugin.class, (View) this);
        return this.f22135l.m3111c() ? 2130904775 : 2130906372;
    }

    protected final void m24784c(int i) {
        if (this.f22137n != null) {
            this.f22137n.setCursor(((float) i) / ((float) this.f22138o.getMax()));
        }
    }

    protected final void m24785l() {
        if (this.f22137n != null) {
            this.f22137n.m22640b(true);
        }
    }

    protected final void m24786m() {
        if (this.f22137n != null) {
            this.f22137n.m22638a(true);
        }
    }
}
