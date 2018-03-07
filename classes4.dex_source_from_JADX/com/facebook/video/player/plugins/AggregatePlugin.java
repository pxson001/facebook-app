package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.environment.AnyPlayerEnvironment;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.google.common.base.Preconditions;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: playNow */
public abstract class AggregatePlugin<E extends AnyPlayerEnvironment> extends RichVideoPlayerPluginWithEnv<E> {
    protected final Queue<RichVideoPlayerPlugin> f4498a = new LinkedList();
    protected final EmptyVideoPlugin f4499b;

    public AggregatePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4499b = new EmptyVideoPlugin(context);
    }

    public void setEventBus(RichVideoPlayerEventBus richVideoPlayerEventBus) {
        super.setEventBus(richVideoPlayerEventBus);
        for (RichVideoPlayerPlugin eventBus : this.f4498a) {
            eventBus.setEventBus(richVideoPlayerEventBus);
        }
    }

    public final void em_() {
        super.em_();
        for (RichVideoPlayerPlugin em_ : this.f4498a) {
            em_.em_();
        }
    }

    public void mo392a(ViewGroup viewGroup) {
        Preconditions.checkNotNull(viewGroup);
        this.e = viewGroup;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof RichVideoPlayerPluginWithEnv) {
                RichVideoPlayerPluginWithEnv richVideoPlayerPluginWithEnv = (RichVideoPlayerPluginWithEnv) childAt;
                richVideoPlayerPluginWithEnv.setEnvironment(this.f4500c);
                this.f4498a.add(richVideoPlayerPluginWithEnv);
            } else if (childAt instanceof RichVideoPlayerPlugin) {
                this.f4498a.add((RichVideoPlayerPlugin) childAt);
            }
        }
        for (View childAt2 : this.f4498a) {
            removeView(childAt2);
        }
        this.f4498a.add(this.f4499b);
        ViewParent parent = getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this);
        }
        this.f14093e.addView(this);
        for (RichVideoPlayerPlugin a : this.f4498a) {
            a.mo392a(this);
        }
        setInnerResource(2131560327);
    }

    public final void mo395b(ViewGroup viewGroup) {
        RichVideoPlayerPlugin richVideoPlayerPlugin;
        Preconditions.checkNotNull(viewGroup);
        for (RichVideoPlayerPlugin richVideoPlayerPlugin2 : this.f4498a) {
            richVideoPlayerPlugin2.mo395b(this);
        }
        viewGroup.removeView(this);
        while (!this.f4498a.isEmpty()) {
            richVideoPlayerPlugin2 = (RichVideoPlayerPlugin) this.f4498a.poll();
            if (!(richVideoPlayerPlugin2 instanceof EmptyVideoPlugin)) {
                if (richVideoPlayerPlugin2 instanceof RichVideoPlayerPluginWithEnv) {
                    ((RichVideoPlayerPluginWithEnv) richVideoPlayerPlugin2).setEnvironment(null);
                }
                addView(richVideoPlayerPlugin2);
            }
        }
        this.e = null;
    }

    public void mo393a(PlaybackController playbackController, RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams) {
        super.mo393a(playbackController, richVideoPlayer, richVideoPlayerParams);
        for (RichVideoPlayerPlugin a : this.f4498a) {
            a.mo393a(playbackController, richVideoPlayer, richVideoPlayerParams);
        }
    }

    public final void mo394b() {
        for (RichVideoPlayerPlugin b : this.f4498a) {
            b.mo394b();
        }
        super.mo394b();
    }

    public void setEnvironment(E e) {
        super.setEnvironment(e);
        for (RichVideoPlayerPlugin richVideoPlayerPlugin : this.f4498a) {
            if (richVideoPlayerPlugin instanceof RichVideoPlayerPluginWithEnv) {
                ((RichVideoPlayerPluginWithEnv) richVideoPlayerPlugin).setEnvironment(e);
            }
        }
    }
}
