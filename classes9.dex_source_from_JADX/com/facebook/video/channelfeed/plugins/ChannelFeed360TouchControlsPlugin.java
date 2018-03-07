package com.facebook.video.channelfeed.plugins;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.common.touch.SphericalDragDetector.DragListener;
import com.facebook.common.touch.SphericalTouchDetector;
import com.facebook.common.touch.SphericalZoomDetector.ZoomListener;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.player.events.RVP360TouchEvent;
import javax.inject.Inject;

@DoNotStrip
/* compiled from: street_results */
public class ChannelFeed360TouchControlsPlugin extends ChannelFeedInlineVideoControlsPlugin {
    @Inject
    public Video360PlayerConfig f2717m;
    public Feed360TouchListener f2718n;
    public SphericalTouchDetector f2719o;
    public GestureDetector f2720p;

    /* compiled from: street_results */
    public class Feed360TouchListener implements DragListener, ZoomListener {
        final /* synthetic */ ChannelFeed360TouchControlsPlugin f2714a;
        private boolean f2715b = false;

        public Feed360TouchListener(ChannelFeed360TouchControlsPlugin channelFeed360TouchControlsPlugin) {
            this.f2714a = channelFeed360TouchControlsPlugin;
        }

        public final void m2602a() {
        }

        public final void m2605b() {
            this.f2714a.g.a(new RVP360TouchEvent(0));
        }

        public final void m2603a(float f, float f2) {
            if (Math.abs(f) > 0.0f && !this.f2715b) {
                this.f2714a.getParent().requestDisallowInterceptTouchEvent(true);
                this.f2715b = true;
            }
            this.f2714a.g.a(new RVP360TouchEvent(1, f, f2));
        }

        public final void m2606b(float f, float f2) {
            this.f2714a.g.a(new RVP360TouchEvent(2, f, f2));
            this.f2715b = false;
        }

        public final boolean m2607c() {
            return false;
        }

        public final boolean m2604a(float f) {
            return false;
        }

        public final void m2608d() {
        }
    }

    /* compiled from: street_results */
    public class SingleTapConfirm extends SimpleOnGestureListener {
        final /* synthetic */ ChannelFeed360TouchControlsPlugin f2716a;

        public SingleTapConfirm(ChannelFeed360TouchControlsPlugin channelFeed360TouchControlsPlugin) {
            this.f2716a = channelFeed360TouchControlsPlugin;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f2716a.performClick();
            return true;
        }
    }

    public static void m2610a(Object obj, Context context) {
        ((ChannelFeed360TouchControlsPlugin) obj).f2717m = Video360PlayerConfig.b(FbInjector.get(context));
    }

    @DoNotStrip
    public ChannelFeed360TouchControlsPlugin(Context context) {
        this(context, null);
    }

    private ChannelFeed360TouchControlsPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ChannelFeed360TouchControlsPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = ChannelFeed360TouchControlsPlugin.class;
        m2610a(this, getContext());
        this.f2718n = new Feed360TouchListener(this);
        this.f2719o = new SphericalTouchDetector(context, this.f2718n, this.f2718n, false);
        this.f2720p = new GestureDetector(getContext(), new SingleTapConfirm(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 859659203);
        if (this.f2720p.onTouchEvent(motionEvent) || !this.f2717m.o) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            LogUtils.a(-1342904443, a);
            return onTouchEvent;
        }
        onTouchEvent = this.f2719o.a(motionEvent);
        Logger.a(2, EntryType.UI_INPUT_END, -428204693, a);
        return onTouchEvent;
    }
}
