package com.facebook.video.player.plugins;

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
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.video.abtest.Video360PlayerConfig;
import com.facebook.video.player.events.RVP360PinchZoomEvent;
import com.facebook.video.player.events.RVP360TouchEvent;
import javax.inject.Inject;

/* compiled from: place_feed_nearby */
public class InlineFeed360TouchPlugin extends RichVideoPlayerPlugin {
    @Inject
    public Video360PlayerConfig f4675a;
    public Feed360TouchListener f4676b;
    public SphericalTouchDetector f4677c;
    public GestureDetector f4678d;
    public boolean f4679l;
    public boolean f4680m;

    /* compiled from: place_feed_nearby */
    public class Feed360TouchListener implements DragListener, ZoomListener {
        final /* synthetic */ InlineFeed360TouchPlugin f4681a;

        public Feed360TouchListener(InlineFeed360TouchPlugin inlineFeed360TouchPlugin) {
            this.f4681a = inlineFeed360TouchPlugin;
        }

        public final void mo408a() {
        }

        public final void mo411b() {
            this.f4681a.f14095g.m14878a(new RVP360TouchEvent(0));
        }

        public final void mo409a(float f, float f2) {
            if (!(this.f4681a.f4679l || f == 0.0f)) {
                this.f4681a.f4679l = true;
            }
            this.f4681a.f14095g.m14878a(new RVP360TouchEvent(1, f, f2));
        }

        public final void mo412b(float f, float f2) {
            this.f4681a.f14095g.m14878a(new RVP360TouchEvent(2, f, f2));
            this.f4681a.f4679l = false;
        }

        public final boolean mo413c() {
            this.f4681a.f14095g.m14878a(new RVP360PinchZoomEvent(1));
            return true;
        }

        public final boolean mo410a(float f) {
            this.f4681a.f14095g.m14878a(new RVP360PinchZoomEvent(2, f));
            return true;
        }

        public final void mo414d() {
            this.f4681a.f14095g.m14878a(new RVP360PinchZoomEvent(3));
        }
    }

    /* compiled from: place_feed_nearby */
    public class SingleTapConfirm extends SimpleOnGestureListener {
        final /* synthetic */ InlineFeed360TouchPlugin f4714a;

        public SingleTapConfirm(InlineFeed360TouchPlugin inlineFeed360TouchPlugin) {
            this.f4714a = inlineFeed360TouchPlugin;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f4714a.performClick();
            return true;
        }
    }

    public static void m5155a(Object obj, Context context) {
        ((InlineFeed360TouchPlugin) obj).f4675a = Video360PlayerConfig.b(FbInjector.get(context));
    }

    public InlineFeed360TouchPlugin(Context context) {
        this(context, null);
    }

    private InlineFeed360TouchPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private InlineFeed360TouchPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4679l = false;
        this.f4680m = false;
        Class cls = InlineFeed360TouchPlugin.class;
        m5155a(this, getContext());
        this.f4676b = new Feed360TouchListener(this);
        this.f4677c = new SphericalTouchDetector(context, this.f4676b, this.f4676b, true);
        this.f4678d = new GestureDetector(getContext(), new SingleTapConfirm(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -536016377);
        this.f4680m = this.f4678d.onTouchEvent(motionEvent);
        boolean a2 = (this.f4680m || !this.f4675a.t) ? false : this.f4677c.m5170a(motionEvent);
        LogUtils.a(-1361134758, a);
        return a2;
    }
}
