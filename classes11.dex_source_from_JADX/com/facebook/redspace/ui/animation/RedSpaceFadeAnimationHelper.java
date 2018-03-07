package com.facebook.redspace.ui.animation;

import android.animation.Animator;
import android.view.View;
import com.facebook.ui.animations.BaseAnimatorListener;

/* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_QUEUED */
public class RedSpaceFadeAnimationHelper {

    /* compiled from: PRIVACY_CHECKUP_WRITE_REQUEST_QUEUED */
    final class C14721 extends BaseAnimatorListener {
        final /* synthetic */ View f12433a;
        final /* synthetic */ float f12434b;

        C14721(View view, float f) {
            this.f12433a = view;
            this.f12434b = f;
        }

        public final void onAnimationCancel(Animator animator) {
            RedSpaceFadeAnimationHelper.m12839b(this.f12433a, this.f12434b);
        }

        public final void onAnimationEnd(Animator animator) {
            RedSpaceFadeAnimationHelper.m12839b(this.f12433a, this.f12434b);
        }
    }

    public static void m12838a(View view, boolean z, float f) {
        if (z) {
            Object tag = view.getTag(2131558603);
            if (view.getAlpha() != f || tag != null) {
                if (!(tag instanceof Float) || !tag.equals(Float.valueOf(f))) {
                    view.animate().cancel();
                    if (view.getVisibility() != 0) {
                        view.setAlpha(0.0f);
                    }
                    view.setVisibility(0);
                    view.setTag(2131558603, Float.valueOf(f));
                    view.animate().alpha(f).setDuration(200).setListener(new C14721(view, f)).start();
                    return;
                }
                return;
            }
            return;
        }
        view.animate().cancel();
        view.setAlpha(f);
        view.setVisibility(m12837a(f));
    }

    public static void m12839b(View view, float f) {
        view.setTag(2131558603, null);
        view.setVisibility(m12837a(f));
    }

    private static int m12837a(float f) {
        return f == 0.0f ? 4 : 0;
    }
}
