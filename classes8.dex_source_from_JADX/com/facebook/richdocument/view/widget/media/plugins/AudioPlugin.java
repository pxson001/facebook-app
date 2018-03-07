package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.facebook.content.event.FbEvent;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbImageButton;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.view.touch.RichDocumentTouch;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPPlayerStateChangedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.PlaybackController.State;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: num_swipeable_frames */
public class AudioPlugin extends RichVideoPlayerPlugin {
    @Inject
    public HamDimensions f7610a;
    public final FbImageButton f7611b;
    private final AudioIconClickListener f7612c;
    public boolean f7613d;
    public boolean f7614l;
    public WeakReference<AudioPluginClickListener> f7615m;
    public boolean f7616n;

    /* compiled from: num_swipeable_frames */
    class AudioIconClickListener implements OnClickListener {
        final /* synthetic */ AudioPlugin f7608a;

        public AudioIconClickListener(AudioPlugin audioPlugin) {
            this.f7608a = audioPlugin;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 102449348);
            if (!(this.f7608a.f7615m == null || this.f7608a.f7615m.get() == null)) {
                ((MutedAutoplayPlugin) this.f7608a.f7615m.get()).m7975a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1354470499, a);
        }
    }

    /* compiled from: num_swipeable_frames */
    class PlayerStateChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPPlayerStateChangedEvent> {
        final /* synthetic */ AudioPlugin f7609a;

        public PlayerStateChangedEventSubscriber(AudioPlugin audioPlugin) {
            this.f7609a = audioPlugin;
        }

        public final void m7865b(FbEvent fbEvent) {
            this.f7609a.m7868a(((RVPPlayerStateChangedEvent) fbEvent).b);
        }

        public final Class<RVPPlayerStateChangedEvent> m7864a() {
            return RVPPlayerStateChangedEvent.class;
        }
    }

    public static void m7866a(Object obj, Context context) {
        ((AudioPlugin) obj).f7610a = HamDimensions.m5268a(FbInjector.get(context));
    }

    public AudioPlugin(Context context) {
        this(context, null);
    }

    private AudioPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private AudioPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7612c = new AudioIconClickListener(this);
        Class cls = AudioPlugin.class;
        m7866a((Object) this, getContext());
        setContentView(2130906864);
        this.f7611b = (FbImageButton) a(2131567027);
        this.f7611b.setImageResource(2130837740);
        this.f7616n = true;
        this.f.add(new PlayerStateChangedEventSubscriber(this));
        LayoutParams layoutParams = this.f7611b.getLayoutParams();
        layoutParams.width = this.f7610a.m5276b(2131558721);
        layoutParams.height = this.f7610a.m5276b(2131558722);
        this.f7611b.setLayoutParams(layoutParams);
        this.f7611b.setOnClickListener(this.f7612c);
        int b = this.f7610a.m5276b(2131558724);
        RichDocumentTouch.m7189a(this.f7611b, Integer.valueOf(b), Integer.valueOf(b), Integer.valueOf(3));
    }

    public final void m7870d() {
        if (!this.f7614l) {
            ((Animatable) this.f7611b.getDrawable()).start();
            this.f7614l = true;
        }
    }

    public final void m7871e() {
        if (this.f7611b != null) {
            this.f7611b.setVisibility(8);
            if (this.f7614l) {
                Drawable drawable = this.f7611b.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                    this.f7614l = false;
                }
            }
        }
    }

    public final void m7869a(boolean z) {
        if (this.f7611b != null) {
            this.f7611b.setVisibility(0);
            if (z) {
                m7870d();
            }
        }
    }

    protected final void m7868a(State state) {
        if (state == State.PLAYING && !this.f7613d) {
            m7869a(true);
        } else if (this.f7613d || state != State.PAUSED) {
            m7871e();
        } else {
            m7869a(false);
        }
    }

    protected final void m7867a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Preconditions.checkNotNull(this.h);
        m7868a(this.h.l);
    }
}
