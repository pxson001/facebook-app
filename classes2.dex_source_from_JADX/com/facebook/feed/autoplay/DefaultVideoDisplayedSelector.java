package com.facebook.feed.autoplay;

import android.graphics.Rect;
import android.view.View;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider.AutoplayVisibility;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: is_save_button */
public class DefaultVideoDisplayedSelector implements VideoDisplayedSelector {
    private VideoAutoplayVisibilityDecider f18896a;
    private final Rect f18897b = new Rect(0, 0, 0, 0);

    @Inject
    public DefaultVideoDisplayedSelector(VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider) {
        this.f18896a = videoAutoplayVisibilityDecider;
    }

    public final <V extends View> V mo3042a(Set<V> set) {
        V v = null;
        if (!set.isEmpty()) {
            int i = 0;
            for (V v2 : set) {
                V v3;
                int i2;
                if (this.f18896a.m26577a((View) v2) == AutoplayVisibility.VISIBLE_FOR_AUTOPLAY) {
                    v2.getGlobalVisibleRect(this.f18897b);
                    if (v == null || this.f18897b.top < i) {
                        v3 = v2;
                        i2 = this.f18897b.top;
                        v = v3;
                        i = i2;
                    }
                }
                i2 = i;
                v3 = v;
                v = v3;
                i = i2;
            }
        }
        return v;
    }
}
