package com.facebook.video.channelfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: temp_scale */
public class ChannelFeedContainerView extends CustomFrameLayout {
    @Inject
    ChannelFeedFocusDimmingManager f2110a;
    @Inject
    ChannelFeedAutoscrollController f2111b;

    private static <T extends View> void m2119a(Class<T> cls, T t) {
        m2120a((Object) t, t.getContext());
    }

    private static void m2120a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((ChannelFeedContainerView) obj).m2118a(ChannelFeedFocusDimmingManager.m2177a(injectorLike), ChannelFeedAutoscrollController.m2107a(injectorLike));
    }

    public ChannelFeedContainerView(Context context) {
        this(context, null);
    }

    public ChannelFeedContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChannelFeedContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2119a(ChannelFeedContainerView.class, (View) this);
    }

    private void m2118a(ChannelFeedFocusDimmingManager channelFeedFocusDimmingManager, ChannelFeedAutoscrollController channelFeedAutoscrollController) {
        this.f2110a = channelFeedFocusDimmingManager;
        this.f2111b = channelFeedAutoscrollController;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f2110a.m2184a();
        this.f2111b.f2092a.removeMessages(1);
        return false;
    }
}
