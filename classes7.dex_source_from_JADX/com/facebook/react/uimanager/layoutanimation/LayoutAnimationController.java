package com.facebook.react.uimanager.layoutanimation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: flyout_comment_view/ */
public class LayoutAnimationController {
    private final AbstractLayoutAnimation f11923a = new LayoutCreateAnimation();
    private final AbstractLayoutAnimation f11924b = new LayoutUpdateAnimation();
    private final AbstractLayoutAnimation f11925c = new LayoutDeleteAnimation();
    private boolean f11926d;

    public final void m14191a(@Nullable ReadableMap readableMap) {
        int i = 0;
        if (readableMap == null) {
            m14188a();
            return;
        }
        this.f11926d = false;
        if (readableMap.hasKey("duration")) {
            i = readableMap.getInt("duration");
        }
        if (readableMap.hasKey(LayoutAnimationType.CREATE.toString())) {
            this.f11923a.m14180a(readableMap.mo680b(LayoutAnimationType.CREATE.toString()), i);
            this.f11926d = true;
        }
        if (readableMap.hasKey(LayoutAnimationType.UPDATE.toString())) {
            this.f11924b.m14180a(readableMap.mo680b(LayoutAnimationType.UPDATE.toString()), i);
            this.f11926d = true;
        }
        if (readableMap.hasKey(LayoutAnimationType.DELETE.toString())) {
            this.f11925c.m14180a(readableMap.mo680b(LayoutAnimationType.DELETE.toString()), i);
            this.f11926d = true;
        }
    }

    public final void m14188a() {
        this.f11923a.m14183b();
        this.f11924b.m14183b();
        this.f11925c.m14183b();
        this.f11926d = false;
    }

    public final boolean m14192a(View view) {
        return this.f11926d && view.getParent() != null;
    }

    public final void m14189a(View view, int i, int i2, int i3, int i4) {
        UiThreadUtil.m13554b();
        AbstractLayoutAnimation abstractLayoutAnimation = (view.getWidth() == 0 || view.getHeight() == 0) ? this.f11923a : this.f11924b;
        Animation b = abstractLayoutAnimation.m14182b(view, i, i2, i3, i4);
        if (b == null || !(b instanceof HandleLayout)) {
            view.layout(i, i2, i + i3, i2 + i4);
        }
        if (b != null) {
            view.startAnimation(b);
        }
    }

    public final void m14190a(View view, final LayoutAnimationListener layoutAnimationListener) {
        UiThreadUtil.m13554b();
        Animation b = this.f11925c.m14182b(view, view.getLeft(), view.getTop(), view.getWidth(), view.getHeight());
        if (b != null) {
            m14187b(view);
            b.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ LayoutAnimationController f11922b;

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    layoutAnimationListener.mo735a();
                }
            });
            view.startAnimation(b);
            return;
        }
        layoutAnimationListener.mo735a();
    }

    private void m14187b(View view) {
        int i = 0;
        view.setClickable(false);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            while (i < viewGroup.getChildCount()) {
                m14187b(viewGroup.getChildAt(i));
                i++;
            }
        }
    }
}
