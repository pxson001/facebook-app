package com.facebook.feed.autoplay;

import android.graphics.Rect;
import android.view.View;
import com.facebook.inject.InjectorLike;

/* compiled from: is_receiving_subscription_messages */
public class VideoAutoplayVisibilityDecider {
    public final Rect f18898a = new Rect(0, 0, 0, 0);

    public static VideoAutoplayVisibilityDecider m26575a(InjectorLike injectorLike) {
        return new VideoAutoplayVisibilityDecider();
    }

    public final AutoplayVisibility m26577a(View view) {
        if (m26578b(view)) {
            return AutoplayVisibility.OFFSCREEN;
        }
        view.getGlobalVisibleRect(this.f18898a);
        int width = this.f18898a.width();
        view.getHitRect(this.f18898a);
        if (((float) width) / ((float) this.f18898a.width()) < 0.9f) {
            return AutoplayVisibility.NOT_VISIBLE;
        }
        view.getGlobalVisibleRect(this.f18898a);
        width = this.f18898a.height();
        view.getHitRect(this.f18898a);
        float height = ((float) width) / ((float) this.f18898a.height());
        if (height > 0.5f) {
            return AutoplayVisibility.VISIBLE_FOR_AUTOPLAY;
        }
        if (height < 0.45f) {
            return AutoplayVisibility.NOT_VISIBLE;
        }
        return AutoplayVisibility.VISIBLE;
    }

    public final boolean m26578b(View view) {
        if (view.getParent() == null || view.getWindowToken() == null || !view.getGlobalVisibleRect(this.f18898a)) {
            return true;
        }
        return false;
    }

    public static boolean m26576a(AutoplayVisibility autoplayVisibility) {
        return autoplayVisibility == AutoplayVisibility.VISIBLE_FOR_AUTOPLAY || autoplayVisibility == AutoplayVisibility.VISIBLE;
    }
}
