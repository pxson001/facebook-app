package com.facebook.video.player.plugins;

import android.animation.Animator.AnimatorListener;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.facebook.video.player.events.RichVideoPlayerEvent;
import com.facebook.video.player.events.RichVideoPlayerEventBus;
import com.facebook.video.player.events.RichVideoPlayerEventSubscriber;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: delayed_delivery_display_time */
public class RichVideoPlayerPluginUtils {
    public static void m14937a(@Nullable RichVideoPlayerEventBus richVideoPlayerEventBus, @Nullable RichVideoPlayerEventBus richVideoPlayerEventBus2, List<RichVideoPlayerEventSubscriber<? extends RichVideoPlayerEvent>> list) {
        if (richVideoPlayerEventBus2 != null) {
            for (RichVideoPlayerEventSubscriber b : list) {
                richVideoPlayerEventBus2.b(b);
            }
        }
        if (richVideoPlayerEventBus != null) {
            for (RichVideoPlayerEventSubscriber b2 : list) {
                richVideoPlayerEventBus.a(b2);
            }
        }
    }

    public static void m14933a(View view, View view2, double d, boolean z) {
        m14934a(view, view2, d, z, false);
    }

    private static void m14934a(View view, View view2, double d, boolean z, boolean z2) {
        m14932a(view, view2, d, -1.0d, z, z2);
    }

    public static void m14932a(View view, View view2, double d, double d2, boolean z, boolean z2) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0 && d > 0.0d) {
            int ceil;
            int i;
            double d3 = (((double) width) * 1.0d) / ((double) height);
            if (d2 > 0.0d) {
                if (d2 > d3) {
                    height = (int) Math.ceil(((double) width) / d2);
                } else {
                    width = (int) Math.ceil(((double) height) * d2);
                }
            }
            if ((d >= d3 || z) && (d <= d3 || !z)) {
                ceil = (int) Math.ceil(((double) width) / d);
                i = width;
            } else {
                i = (int) Math.ceil(((double) height) * d);
                ceil = height;
            }
            LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = ceil;
            layoutParams.width = i;
            view2.setLayoutParams(layoutParams);
            if (!z2) {
                return;
            }
            if (ceil > i && z) {
                view2.setTranslationX(0.0f);
                view2.setTranslationY((float) ((height - ceil) / 2));
            } else if (i <= ceil || !z) {
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
            } else {
                view2.setTranslationX((float) ((width - i) / 2));
                view2.setTranslationY(0.0f);
            }
        }
    }

    public static void m14935a(View view, View view2, RectF rectF, double d) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (width > 0 && height > 0 && rectF != null && rectF.height() > 0.0f && rectF.width() > 0.0f && d > 0.0d) {
            double width2 = ((double) (rectF.width() / rectF.height())) * d;
            if (width2 > ((double) width) / ((double) height)) {
                height = (int) Math.rint(((double) width) / width2);
            } else {
                width = (int) Math.rint(width2 * ((double) height));
            }
            LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = height;
            layoutParams.width = width;
            view2.setLayoutParams(layoutParams);
        }
    }

    public static void m14936a(ImageView imageView, int i, int i2, AnimatorListener animatorListener) {
        imageView.animate().cancel();
        imageView.setImageResource(i2);
        imageView.setScaleX(0.5f);
        imageView.setScaleY(0.5f);
        imageView.setAlpha(1.0f);
        imageView.setVisibility(0);
        imageView.animate().scaleX(1.0f).scaleY(1.0f).alpha(0.5f).setDuration((long) i).setListener(animatorListener);
    }
}
