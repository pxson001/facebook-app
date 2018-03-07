package com.facebook.facecastdisplay.tipjar;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.content.event.FbEvent;
import com.facebook.facecastdisplay.tipjar.LiveTipJarView.LiveTipJarViewListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.video.player.RichVideoPlayerParams;
import com.facebook.video.player.events.RVPOpenLiveTipJarEvent;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import com.facebook.video.player.plugins.RichVideoPlayerPlugin;

/* compiled from: assetCount */
public class LiveTipJarPlugin extends RichVideoPlayerPlugin implements LiveTipJarViewListener {
    public final LiveTipJarView f19100a;

    /* compiled from: assetCount */
    class LiveOpenTipJarEventSubscriber extends RichVideoPlayerEventSubscriber<RVPOpenLiveTipJarEvent> {
        final /* synthetic */ LiveTipJarPlugin f19099a;

        public LiveOpenTipJarEventSubscriber(LiveTipJarPlugin liveTipJarPlugin) {
            this.f19099a = liveTipJarPlugin;
        }

        public final void m22653b(FbEvent fbEvent) {
            this.f19099a.f19100a.setVisibility(0);
        }

        public final Class<RVPOpenLiveTipJarEvent> m22652a() {
            return RVPOpenLiveTipJarEvent.class;
        }
    }

    public LiveTipJarPlugin(Context context) {
        this(context, null);
    }

    private LiveTipJarPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private LiveTipJarPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905093);
        this.f.add(new LiveOpenTipJarEventSubscriber(this));
        this.f19100a = (LiveTipJarView) findViewById(2131563512);
        this.f19100a.setClickable(true);
        this.f19100a.f19107e = this;
    }

    protected final void m22655a(RichVideoPlayerParams richVideoPlayerParams, boolean z) {
        if (richVideoPlayerParams.b != null && richVideoPlayerParams.b.containsKey("GraphQLStoryProps") && (richVideoPlayerParams.b.get("GraphQLStoryProps") instanceof FeedProps)) {
            this.f19100a.setMetadata((FeedProps) richVideoPlayerParams.b.get("GraphQLStoryProps"));
            this.f19100a.setVisibility(8);
            return;
        }
        g();
    }

    public final void mo1452d() {
        this.f19100a.setVisibility(8);
    }
}
