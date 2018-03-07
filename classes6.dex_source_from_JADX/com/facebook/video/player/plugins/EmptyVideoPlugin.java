package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.facebook.content.event.FbEvent;
import com.facebook.video.player.AnchorLayout.LayoutParams;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPSizeChangedEvent;
import com.facebook.video.player.events.RVPVideoSizeUpdatedEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;

/* compiled from: composer_attach_photo */
public class EmptyVideoPlugin extends RichVideoPlayerPlugin {
    public boolean f19327a;
    public double f19328b;
    private ViewGroup f19329c;
    private boolean f19330d;

    /* compiled from: composer_attach_photo */
    class SizeChangedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPSizeChangedEvent> {
        final /* synthetic */ EmptyVideoPlugin f19325a;

        public SizeChangedEventSubscriber(EmptyVideoPlugin emptyVideoPlugin) {
            this.f19325a = emptyVideoPlugin;
        }

        public final void m28096b(FbEvent fbEvent) {
            EmptyVideoPlugin.m28099d(this.f19325a);
        }

        public final Class<RVPSizeChangedEvent> m28095a() {
            return RVPSizeChangedEvent.class;
        }
    }

    /* compiled from: composer_attach_photo */
    class VideoSizeUpdatedEventSubscriber extends RichVideoPlayerEventSubscriber<RVPVideoSizeUpdatedEvent> {
        final /* synthetic */ EmptyVideoPlugin f19326a;

        public VideoSizeUpdatedEventSubscriber(EmptyVideoPlugin emptyVideoPlugin) {
            this.f19326a = emptyVideoPlugin;
        }

        public final void m28098b(FbEvent fbEvent) {
            RVPVideoSizeUpdatedEvent rVPVideoSizeUpdatedEvent = (RVPVideoSizeUpdatedEvent) fbEvent;
            EmptyVideoPlugin emptyVideoPlugin = this.f19326a;
            int i = rVPVideoSizeUpdatedEvent.a;
            int i2 = rVPVideoSizeUpdatedEvent.b;
            if (i > 0 && i2 > 0) {
                if (!emptyVideoPlugin.f19327a) {
                    emptyVideoPlugin.f19328b = ((double) i) / ((double) i2);
                }
                EmptyVideoPlugin.m28099d(emptyVideoPlugin);
            }
        }

        public final Class<RVPVideoSizeUpdatedEvent> m28097a() {
            return RVPVideoSizeUpdatedEvent.class;
        }
    }

    public EmptyVideoPlugin(Context context) {
        this(context, null);
    }

    private EmptyVideoPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private EmptyVideoPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19327a = false;
        this.f19328b = 1.7777777777777777d;
        this.f19330d = false;
        this.f.add(new SizeChangedEventSubscriber(this));
        this.f.add(new VideoSizeUpdatedEventSubscriber(this));
        setContentView(2130907697);
        this.f19329c = (ViewGroup) a(2131560327);
    }

    protected final void m28100a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        Double d = (Double) richVideoPlayerParams.b.get("VideoAspectRatioKey");
        if (z || !(d == null || d.doubleValue() == this.f19328b)) {
            if (d != null) {
                this.f19328b = d.doubleValue();
            }
            m28099d(this);
        }
        if (richVideoPlayerParams.a != null && richVideoPlayerParams.a.s != null) {
            this.f19327a = true;
        }
    }

    public static void m28099d(EmptyVideoPlugin emptyVideoPlugin) {
        RichVideoPlayerPluginUtils.a(emptyVideoPlugin.e, emptyVideoPlugin.f19329c, emptyVideoPlugin.f19328b, emptyVideoPlugin.f19330d);
    }

    public void setShouldCropToFit(boolean z) {
        this.f19330d = z;
    }

    public void setVideoPluginAlignment(VideoPlugin$VideoPluginAlignment videoPlugin$VideoPluginAlignment) {
        LayoutParams layoutParams = (LayoutParams) this.f19329c.getLayoutParams();
        layoutParams.addRule(15, 0);
        layoutParams.addRule(10, 0);
        switch (videoPlugin$VideoPluginAlignment) {
            case TOP:
                layoutParams.addRule(10);
                break;
            case CENTER:
                layoutParams.addRule(15);
                break;
        }
        this.f19329c.setLayoutParams(layoutParams);
    }
}
