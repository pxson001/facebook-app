package com.facebook.video.player.plugins;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.content.event.FbEvent;
import com.facebook.dialtone.DialtoneController;
import com.facebook.dialtone.DialtoneControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayIconStateEvent;
import com.facebook.video.player.events.RVPPlayIconStateEvent.State;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: payments_sync/ */
public class SinglePlayIconPlugin extends RichVideoPlayerPlugin {
    @Inject
    public DialtoneController f14126a;
    @Inject
    public Video360PlayerConfig f14127b;
    public State f14128c;
    public View f14129d;

    /* compiled from: payments_sync/ */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ SinglePlayIconPlugin f14130a;

        public PlayerStateChangedEventSubscriber(SinglePlayIconPlugin singlePlayIconPlugin) {
            this.f14130a = singlePlayIconPlugin;
        }

        public final void m14942b(FbEvent fbEvent) {
            this.f14130a.m14940a(((RVPPlayerStateChangedEvent) fbEvent).f14079b);
        }

        public final Class<RVPPlayerStateChangedEvent> m14941a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    /* compiled from: payments_sync/ */
    class PlayIconStateEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayIconStateEvent> {
        final /* synthetic */ SinglePlayIconPlugin f14131a;

        public PlayIconStateEventSubscriber(SinglePlayIconPlugin singlePlayIconPlugin) {
            this.f14131a = singlePlayIconPlugin;
        }

        public final void m14944b(FbEvent fbEvent) {
            RVPPlayIconStateEvent rVPPlayIconStateEvent = (RVPPlayIconStateEvent) fbEvent;
            this.f14131a.f14128c = rVPPlayIconStateEvent.f14166a;
            if (this.f14131a.f14096h != null) {
                this.f14131a.m14940a(this.f14131a.f14096h.f5115l);
            }
        }

        public final Class<RVPPlayIconStateEvent> m14943a() {
            return RVPPlayIconStateEvent.class;
        }
    }

    public static void m14938a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        SinglePlayIconPlugin singlePlayIconPlugin = (SinglePlayIconPlugin) obj;
        DialtoneController dialtoneController = (DialtoneController) DialtoneControllerImpl.a(fbInjector);
        Video360PlayerConfig b = Video360PlayerConfig.b(fbInjector);
        singlePlayIconPlugin.f14126a = dialtoneController;
        singlePlayIconPlugin.f14127b = b;
    }

    public SinglePlayIconPlugin(Context context) {
        this(context, null);
    }

    private SinglePlayIconPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private SinglePlayIconPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14128c = State.DEFAULT;
        Class cls = SinglePlayIconPlugin.class;
        m14938a((Object) this, getContext());
        setContentView(2130907125);
        this.f14094f.add(new PlayerStateChangedEventSubscriber(this));
        this.f14094f.add(new PlayIconStateEventSubscriber(this));
        this.f14129d = m14861a(2131561882);
    }

    protected final void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        int i;
        if (z) {
            this.f14128c = State.DEFAULT;
        }
        if (richVideoPlayerParams == null || richVideoPlayerParams.f4962a == null || richVideoPlayerParams.f4962a.f4850s == null || !this.f14127b.k) {
            i = 2130842698;
        } else {
            i = 2130840898;
        }
        Drawable a = ContextCompat.a(getContext(), i);
        if (VERSION.SDK_INT < 16) {
            this.f14129d.setBackgroundDrawable(a);
        } else {
            this.f14129d.setBackground(a);
        }
        Preconditions.checkNotNull(this.f14096h);
        m14940a(this.f14096h.f5115l);
    }

    protected final void m14940a(PlaybackController.State state) {
        if (this.f14126a.j()) {
            this.f14129d.setVisibility(8);
            return;
        }
        switch (this.f14128c) {
            case DEFAULT:
                if (!state.isPlayingState()) {
                    this.f14129d.setVisibility(0);
                    return;
                }
                break;
            case HIDE:
                break;
            default:
                return;
        }
        this.f14129d.setVisibility(8);
    }
}
