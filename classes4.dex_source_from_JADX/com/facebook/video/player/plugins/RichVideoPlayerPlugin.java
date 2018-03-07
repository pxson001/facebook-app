package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.video.player.AnchorLayout;
import com.facebook.video.player.RichVideoPlayer;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RichVideoPlayerEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.annotation.Nullable;

/* compiled from: delayed_delivery_time */
public abstract class RichVideoPlayerPlugin extends AnchorLayout {
    private boolean f14091a;
    private boolean f14092b;
    protected ViewGroup f14093e;
    public final List<RichVideoPlayerEventSubscriber<? extends RichVideoPlayerEvent>> f14094f;
    public RichVideoPlayerEventBus f14095g;
    @Nullable
    public PlaybackController f14096h;
    @Nullable
    protected RichVideoPlayer f14097i;
    public boolean f14098j;
    protected final Queue<View> f14099k;

    public RichVideoPlayerPlugin(Context context) {
        this(context, null);
    }

    public RichVideoPlayerPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RichVideoPlayerPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14098j = false;
        this.f14091a = false;
        this.f14092b = false;
        this.f14099k = new LinkedList();
        this.f14094f = new ArrayList();
    }

    public void setEventBus(RichVideoPlayerEventBus richVideoPlayerEventBus) {
        RichVideoPlayerPluginUtils.m14937a(richVideoPlayerEventBus, this.f14095g, this.f14094f);
        this.f14095g = richVideoPlayerEventBus;
    }

    public void em_() {
        RichVideoPlayerPluginUtils.m14937a(null, this.f14095g, this.f14094f);
        this.f14095g = null;
    }

    public void mo392a(ViewGroup viewGroup) {
        if (this.f14092b) {
            throw new IllegalStateException("This plugin has already been attached to a RichVideoPlayer");
        }
        Preconditions.checkNotNull(viewGroup);
        this.f14093e = viewGroup;
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            removeView(childAt);
            if (this instanceof VideoPlugin) {
                this.f14093e.addView(childAt, 0);
            } else {
                this.f14093e.addView(childAt);
            }
            this.f14099k.add(childAt);
        }
        this.f14092b = true;
    }

    public void mo395b(ViewGroup viewGroup) {
        Preconditions.checkNotNull(viewGroup);
        while (!this.f14099k.isEmpty()) {
            View view = (View) this.f14099k.poll();
            viewGroup.removeView(view);
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
            }
            addView(view);
        }
        this.f14093e = null;
        this.f14092b = false;
    }

    public void mo393a(PlaybackController playbackController, RichVideoPlayer richVideoPlayer, RichVideoPlayerParams richVideoPlayerParams) {
        boolean z = false;
        this.f14098j = false;
        this.f14096h = playbackController;
        this.f14097i = richVideoPlayer;
        if (!this.f14091a) {
            RichVideoPlayerPluginUtils.m14937a(this.f14095g, null, this.f14094f);
        }
        if (!this.f14091a) {
            z = true;
        }
        mo376a(richVideoPlayerParams, z);
        this.f14091a = true;
    }

    public void mo394b() {
        mo378c();
        RichVideoPlayerPluginUtils.m14937a(null, this.f14095g, this.f14094f);
        this.f14091a = false;
        this.f14096h = null;
        this.f14097i = null;
    }

    public final void m14906g() {
        this.f14098j = true;
    }

    protected void mo376a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
    }

    protected void mo378c() {
    }

    public boolean mo380j() {
        return false;
    }
}
