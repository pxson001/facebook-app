package com.facebook.apptab.ui.nux;

import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.facebook.apptab.state.TabTag;
import com.facebook.nux.ui.NuxBubbleView;
import java.util.List;

/* compiled from: souvenirs_part_1 */
public abstract class MainTabNuxController {
    private NuxBubbleView f4259a;
    public List<TabTag> f4260b;
    public ViewGroup f4261c = null;
    public TabTag f4262d = null;
    public Resources f4263e;

    protected abstract void mo1176c();

    public MainTabNuxController(Resources resources) {
        this.f4263e = resources;
    }

    public final void m7885a(ViewGroup viewGroup, List<TabTag> list) {
        this.f4261c = (ViewGroup) viewGroup.getParent();
        if (list != null) {
            this.f4260b = list;
        }
    }

    protected final int m7889f() {
        if (this.f4260b == null) {
            return 0;
        }
        int i = this.f4263e.getDisplayMetrics().widthPixels;
        int size = this.f4260b.size();
        if (size != 0) {
            return i / size;
        }
        return 0;
    }

    public final void m7886a(NuxBubbleView nuxBubbleView, TabTag tabTag) {
        if (m7889f() != 0 && nuxBubbleView != null) {
            if (tabTag == null) {
                ((LayoutParams) nuxBubbleView.getLayoutParams()).gravity = 1;
            }
            nuxBubbleView.c = new 1(this, tabTag, nuxBubbleView);
            this.f4259a = nuxBubbleView;
            this.f4261c.addView(this.f4259a);
        }
    }

    public final void m7890g() {
        if (this.f4259a != null) {
            this.f4259a.f();
            this.f4259a.a();
            this.f4259a = null;
        }
    }

    public final boolean m7891h() {
        return this.f4259a != null;
    }

    public final void m7887b(TabTag tabTag) {
        if (this.f4259a != null && tabTag != null) {
            int f = m7889f();
            if (f != 0) {
                this.f4262d = tabTag;
                int indexOf = this.f4260b.indexOf(tabTag);
                int pointerWidth = (f / 2) - (this.f4259a.getPointerWidth() / 2);
                LayoutParams pointerLayoutParams = this.f4259a.getPointerLayoutParams();
                LayoutParams layoutParams = (LayoutParams) this.f4259a.getLayoutParams();
                if (indexOf < this.f4260b.size() / 2) {
                    f *= indexOf;
                    pointerLayoutParams.gravity = 3;
                    pointerLayoutParams.leftMargin = pointerWidth;
                    layoutParams.gravity = 3;
                    layoutParams.leftMargin = f;
                    return;
                }
                f *= (this.f4260b.size() - indexOf) - 1;
                pointerLayoutParams.gravity = 5;
                pointerLayoutParams.rightMargin = pointerWidth;
                layoutParams.gravity = 5;
                layoutParams.rightMargin = f;
            }
        }
    }
}
