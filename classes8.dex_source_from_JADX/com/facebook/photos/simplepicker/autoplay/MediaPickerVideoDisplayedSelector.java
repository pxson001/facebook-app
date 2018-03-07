package com.facebook.photos.simplepicker.autoplay;

import android.view.View;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider;
import com.facebook.feed.autoplay.VideoAutoplayVisibilityDecider.AutoplayVisibility;
import com.facebook.feed.autoplay.VideoDisplayedSelector;
import com.facebook.photos.simplepicker.view.PickerPlayableView;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: show_password_checked */
public class MediaPickerVideoDisplayedSelector implements VideoDisplayedSelector {
    private VideoAutoplayVisibilityDecider f2924a;

    @Inject
    public MediaPickerVideoDisplayedSelector(VideoAutoplayVisibilityDecider videoAutoplayVisibilityDecider) {
        this.f2924a = videoAutoplayVisibilityDecider;
    }

    public final <V extends View> V m2994a(Set<V> set) {
        if (set.isEmpty()) {
            return null;
        }
        int i = Integer.MIN_VALUE;
        V v = null;
        for (V v2 : set) {
            if (this.f2924a.a(v2) == AutoplayVisibility.VISIBLE_FOR_AUTOPLAY) {
                V v3;
                int i2;
                if (v2 instanceof PickerPlayableView) {
                    PickerPlayableView pickerPlayableView = (PickerPlayableView) v2;
                    if (v == null) {
                        i = pickerPlayableView.getPlayPriority();
                        v = v2;
                    } else if (pickerPlayableView.getPlayPriority() > i) {
                        i = pickerPlayableView.getPlayPriority();
                        v3 = v2;
                        i2 = i;
                        i = i2;
                        v = v3;
                    }
                }
                i2 = i;
                v3 = v;
                i = i2;
                v = v3;
            }
        }
        return v;
    }
}
